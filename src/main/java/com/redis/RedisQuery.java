package com.redis;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import car_daos.DBConnect;
import redis.clients.jedis.Jedis;

public class RedisQuery {
	public static final RedisQuery QUERY = new RedisQuery();
	private Handler handler = new Handler();
	private Handler2 handler2 = new Handler2();

	private RedisQuery() {

	}

	public static RedisQuery newInstance() {
		return QUERY;
	}

	public void loadSeriesForReids() {
		DoQuery<List<Map<String, String>>> doQuery = new DoQuery<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doQuery(Jedis jedis) {
				List<Map<String, Object>> series = querySeriesFromDB();

				// int index = 0;
				for (Map<String, Object> ser : series) {
					int catalogid = (Integer) ser.get("catalogid");
					Integer count = Integer.parseInt("" + ser.get("count"));
					Object jibie = ser.get("jibie");
					Object leixing = ser.get("leixing");
					if (count == null) {
						count = 0;
					}
					try {
						byte[] bytes = ObjectRedisUtil.serialize(ser);
						String value = ObjectRedisUtil.encode(bytes);
						jedis.set("dbo_car_catalognew:obj-catalogid:"
								+ catalogid, value);
						Map<String, Double> map = new HashMap<String, Double>();
						map.put(Integer.toString(catalogid), (double) count);

						jedis.zadd("dbo_car_catalognew:list:obj-count", map);
						jedis.zadd("dbo_car_catalognew:list:obj-jibie:"//
								+ jibie, map);
						jedis.zadd("dbo_car_catalognew:list:obj-leixing:"//
								+ leixing, map);

						// System.out.println(series.size() + " : " +
						// (++index));
					} catch (IOException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
				return null;
			}
		};
		handler2.query(doQuery);
	}

	public List<Map<String, Object>> querySeriesByJibieLeixing(final int jibie,
			final int leixing, final int start, final int end) {
		DoQuery<List<Map<String, Object>>> doQuery = new DoQuery<List<Map<String, Object>>>() {
			@Override
			public List<Map<String, Object>> doQuery(Jedis jedis) {
				Set<String> keys = null;
				if (jibie <= 0 && leixing <= 0) {
					keys = jedis.zrevrange("dbo_car_catalognew:list:obj-count",
							start, end);
				} else {
					String cmd1 = "dbo_car_catalognew:list:obj-jibie:" + jibie;
					String cmd2 = "dbo_car_catalognew:list:obj-leixing:"
							+ leixing;
					if (jibie <= 0 && leixing > 0) {
						keys = jedis.zrevrange(cmd2, start, end);
					} else if (jibie > 0 && leixing <= 0) {
						keys = jedis.zrevrange(cmd1, start, end);
					} else {
						String dstkey = UUID.randomUUID().toString();
						try {
							jedis.zinterstore(dstkey, cmd1, cmd2);
							keys = jedis.zrevrange(dstkey, start, end);
						} finally {
							jedis.expireAt(dstkey, 10);
						}
					}
				}
				List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
				if (keys != null) {
					for (String key : keys) {
						try {
							byte bytes[] = ObjectRedisUtil.decode(jedis
									.get("dbo_car_catalognew:obj-catalogid:"
											+ key));
							@SuppressWarnings("unchecked")
							Map<String, Object> map = (Map<String, Object>) ObjectRedisUtil
									.unSerialize(bytes);
							maps.add(map);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return maps;
			}
		};
		return handler2.query(doQuery);
	}

	public static void main(String[] args) {
		QUERY.handler2.query(new DoQuery<Integer>() {
			@Override
			public Integer doQuery(Jedis jedis) {
				Object o = jedis.zrange(
						"dbo_car_catalognew:list:obj-leixing:1", 0, -1).size();
				System.out.println(o);
				return null;
			}
		});
	}

	public List<Map<String, Object>> querySeriesFromDB() {
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		DBConnect dbc = null;
		try {
			String sql = "select s.*,count(seriesid) as count from (select * from dbo_car_catalognew s "
					+ "where s.isdelete=0 and s.pathlevel=2 and s.onsale=1) s left join tb_apply_info a "
					+ "on s.catalogid=a.seriesid group by s.catalogid order by count desc";
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				ResultSetMetaData meta = rs.getMetaData();
				int clmCount = meta.getColumnCount();
				String columns[] = new String[clmCount];
				for (int i = 1; i <= clmCount; i++) {
					columns[i - 1] = meta.getColumnName(i);
				}
				Map<String, Object> row = new HashMap<String, Object>();
				for (String column : columns) {
					row.put(column, rs.getObject(column));
				}
				maps.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e1) {
					// e1.printStackTrace();
				}
			}
		}
		return maps;
	}

	@Deprecated
	public List<Map<String, String>> querySeriesCarByLevel(final int pathlevel,
			final int jibie, final int leixing, final int start, final int end) {
		DoQuery<List<Map<String, String>>> doQuery = new DoQuery<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doQuery(Jedis jedis) {
				String dstkey = null;
				Set<String> keys = null;
				if (jibie > 0 || leixing > 0) {
					try {
						String cmd1 = "dbo_car_catalognew:list:pathlevel:"
								+ pathlevel;
						String cmd2 = "dbo_car_catalognew:list:jibie:" + jibie;
						String cmd3 = "dbo_car_catalognew:list:leixing:"
								+ leixing;

						dstkey = "dbo_car_catalognew:zinterstore:pathlevel:"
								+ pathlevel + ":jibie:" + jibie + ":leixing:"
								+ leixing;
						if (jibie > 0 && leixing > 0) {
							jedis.zinterstore(dstkey, cmd1, cmd2, cmd3);
						} else if (jibie > 0) {
							jedis.zinterstore(dstkey, cmd1, cmd2);
						} else {
							jedis.zinterstore(dstkey, cmd1, cmd3);
						}
						keys = jedis.zrange(dstkey, start, end);
					} finally {
						jedis.expireAt(dstkey, 10);
					}
				} else {
					dstkey = "dbo_car_catalognew:list:pathlevel:" + pathlevel;
					keys = jedis.zrange(dstkey, start, end);
				}
				List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
				for (String id : keys) {
					String key = "dbo_car_catalognew:catalogid:" + id;
					Map<String, String> map = jedis.hgetAll(key);
					maps.add(map);

					String count_key = "tb_apply_info:list:seriesid:" + id;
					long count = jedis.zcount(count_key, "-inf", "+inf");
					map.put("count", Long.toString(count));
				}
				return maps;
			}
		};
		return handler.query(doQuery);
	}

	public List<Map<String, String>> queryNewsByCatalogid(final int catalogid,
			final int start, final int end) {
		DoQuery<List<Map<String, String>>> doQuery = new DoQuery<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doQuery(Jedis jedis) {
				Set<String> keys = jedis.zrevrange(
						"dbo_new_news:list:newscatalogid:" + catalogid, start,
						end);
				List<Map<String, String>> result = new ArrayList<Map<String, String>>();
				for (String key : keys) {
					Map<String, String> map = jedis.hgetAll("dbo_new_news:id:"
							+ key);
					result.add(map);
				}
				return result;
			}
		};
		return handler2.query(doQuery);
	}

	public List<Map<String, String>> queryNewsByFatheridSortByDate(
			final int fatherid, final int step, final int size) {
		DoQuery<List<Map<String, String>>> doQuery = new DoQuery<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doQuery(Jedis jedis) {
				List<Map<String, String>> result = new ArrayList<Map<String, String>>();
				Set<String> keys = jedis.zrange(
						"dbo_new_catalog:list:fatherid:" + fatherid, 0, -1);
				for (String catalogid : keys) {
					Set<String> nids = jedis.zrevrange(
							"dbo_new_news:list:newscatalogid:"//
									+ catalogid, 0, step - 1);
					for (String id : nids) {
						result.add(jedis.hgetAll("dbo_new_news:id:" + id));
					}
				}
				final SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Collections.sort(result, new Comparator<Map<String, String>>() {
					@Override
					public int compare(Map<String, String> o1,
							Map<String, String> o2) {
						String adddate1 = o1.get("adddate").//
								replaceAll("&nbsp", " ");
						String adddate2 = o2.get("adddate").//
								replaceAll("&nbsp", " ");
						try {
							Date d1 = sdf.parse(adddate1);
							Date d2 = sdf.parse(adddate2);
							return d1.getTime() > d2.getTime() ? -1 : 1;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return 0;
					}
				});
				if (result.size() > size) {
					result = result.subList(0, size);
				}
				return result;
			}
		};
		return handler2.query(doQuery);
	}

	public List<Map<String, String>> queryOtherModels(final int mid,
			final int len) {
		DoQuery<List<Map<String, String>>> doQuery = new DoQuery<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doQuery(Jedis jedis) {
				String key = "dbo_car_catalognew:catalogid:";
				Map<String, String> model = jedis.hgetAll(key + mid);
				String sid = model.get("fatherid");
				String fkey = "dbo_car_catalognew:list:fatherid:";
				Set<String> mids = jedis.zrange(fkey + sid, 0, len);
				List<Map<String, String>> models = new ArrayList<Map<String, String>>();
				for (String m : mids) {
					if (!Integer.toString(mid).equals(m)) {
						Map<String, String> mds = jedis.hgetAll(key + m);
						if ("1".equals(mds.get("onsale"))) {
							models.add(mds);
						}
					}
				}
				return models;
			}
		};
		return handler.query(doQuery);
	}

	private class Handler {
		public <R> R query(DoQuery<R> doQuery) {
			Jedis jedis = null;
			try {
				jedis = RedisManager.getJedisObject();
				return doQuery.doQuery(jedis);
			} finally {
				if (jedis != null) {
					RedisManager.recycleJedisOjbect(jedis);
				}
			}
		}
	}

	private class Handler2 {
		public <R> R query(DoQuery<R> doQuery) {
			Jedis jedis = null;
			try {
				jedis = RedisManager.getJedis2Object();
				return doQuery.doQuery(jedis);
			} finally {
				if (jedis != null) {
					RedisManager.recycleJedis2Ojbect(jedis);
				}
			}
		}
	}

	private interface DoQuery<T> {
		public T doQuery(Jedis jedis);
	}
}
