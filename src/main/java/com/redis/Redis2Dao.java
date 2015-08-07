package com.redis;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;
import car_beans.DboAdmUser;
import car_beans.DboContentbak;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_daos.DboAdmUserDao;

import com.poly.util.ObjectToMapUtil;

public class Redis2Dao {

	protected String tbl = "tb_xxx";

	// protected String KEY_INDEX_1 = "tb_xxx:index:fieldname";

	protected String KEY_QUEUE = "key_queue";

	public Redis2Dao() {

	}

	// static {
	// initAdmUser();
	// }

	// 初始化dbo_adm_user
	// public static void initAdmUser() {
	// System.out.println(">>> >>> initAdmUser()");
	// List<DboAdmUser> admUserList = DboAdmUserDao.find();
	// Redis2Dao.initAdmUser(admUserList);
	// }

	// // 若key不存在，则存储
	// jedis.setnx("foo", "foo not exits");
	// // 设置key的有效期，并存储数据
	// jedis.setex("foo", 2, "foo not exits");

	public static boolean existsSSetKey(String key) {
		boolean result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.exists(key);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static long lenSSetKey(String key) {
		long len = 0;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			len = jedis.zcount(key, 0, 1);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return len;
	}

	/**
	 * <p>
	 * 通过key返回zset中的value个数
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	public Long zcard(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = RedisManager.getJedis2Object();
			res = jedis.zcard(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return res;
	}

	public static String getValueByKey(String key, String field) {
		String result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.hget(key, field);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static Object getObjectByKey(String key) {
		Object result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.hgetAll(key);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static Map<String, String> getObjectsByKey(String key) {
		Map<String, String> result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.hgetAll(key);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static Set<String> getTabList(String prex_ky, int bg, int end) {
		Set<String> result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.zrange(prex_ky, bg, end);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static List<Map<String, String>> getNewsContentByNewsid(int newsid) {
		List<Map<String, String>> obj = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String cmd = "dbo_new_content:list:newsid:" + newsid;
			Set<String> lstid = jedis.zrange(cmd, 0, -1);
			for (int ii = 0; ii < lstid.size(); ii++) {
				Map<String, String> mapdata = jedis.hgetAll("dbo_new_content:id:" + (String) (lstid.toArray()[ii]));
				if (mapdata == null || mapdata.size() == 0) {
					continue;
				}
				obj.add(mapdata);
			}
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return obj;
	}

	// 获取新闻内容详情
	public static List<Map<String, String>> getContentbakByCid(int cid) {
		Jedis jedis = RedisManager.getJedis2Object();
		String cmd = "dbo_contentbak:list:cid:" + cid;
		Set<String> set_carid = jedis.zrange(cmd, 0, -1);
		List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
		for (int j = 0; j < set_carid.size(); j++) {
			System.out.println(set_carid.toArray()[j]);
			Map<String, String> map = jedis.hgetAll("dbo_contentbak:id:" + (String) (set_carid.toArray()[j]));
			lstret.add(map);
		}
		RedisManager.recycleJedis2Ojbect(jedis);
		return lstret;
	}

	public static List<Map<String, String>> getNewsRelatedBycontentid(int contentid) {
		List<Map<String, String>> obj = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String cmd = "dbo_new_related:list:contentid:" + contentid;
			Set<String> lstid = jedis.zrange(cmd, 0, -1);
			for (int ii = 0; ii < lstid.size(); ii++) {
				Map<String, String> mapdata = jedis.hgetAll("dbo_new_related:id:" + (String) (lstid.toArray()[ii]));
				if (mapdata == null || mapdata.size() == 0) {
					continue;
				}
				obj.add(mapdata);
			}
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return obj;
	}

	public static Set<String> getTabListRev(String prex_ky, int bg, int end) {
		Set<String> result;
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			result = jedis.zrevrange(prex_ky, bg, end);
		} finally {
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return result;
	}

	public static Map<String, String> getTab(String prex_ky, String val) {
		return getObjectsByKey(prex_ky + val);
	}

	// 查询新闻目录的子节点
	public static List<String> getNewsCatalogByFatherid(String fatherid) {
		List<String> list = new ArrayList<String>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String key = "dbo_new_catalog:list:fatherid:" + fatherid;
			Set<String> idlist = jedis.zrange(key, 0, -1);
			if (idlist != null && idlist.size() > 0) {
				for (int i = 0; i < idlist.size(); i++) {
					list.add(idlist.toArray()[i].toString());
				}
			}
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return list;
	}

	// 查询最新的新闻
	public static List<Map<String, String>> getNewestNews(int from, int end) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String key = "dbo_new_news:list:id:all";
			Set<String> idlist = new HashSet<String>();
			idlist = jedis.zrevrange(key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return list;
	}

	// 查询最新原创新闻
	public static List<Map<String, String>> getNewestOriginalNews(int original, int from, int end) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String key = "dbo_new_news:list:isoriginal:" + original;
			Set<String> idlist = new HashSet<String>();
			idlist = jedis.zrevrange(key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return list;
	}

	// 根据新闻类型查询新闻
	public static List<Map<String, String>> getNewsByNewsType(String newsType, int from, int end) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String key = "dbo_new_news:list:newscatalogid:" + newsType;
			Set<String> idlist = new HashSet<String>();
			idlist = jedis.zrevrange(key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return list;
	}

	// 根据新闻类型查询新闻
	public static Map<String, Object> getAllNewsByNewsType(List<String> idList, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		String[] union_wh = new String[idList.size()];
		Map<String, Object> objmap = new HashMap<String, Object>();
		String key = "news:catalog:dbo_new_news:" + idList.hashCode();
		long ids = 0;
		ZParams Op_params = new ZParams();
		Op_params.aggregate(ZParams.Aggregate.MIN);
		try {
			if (jedis.exists(key)) {
				ids = jedis.zcard(key);
			} else {
				for (int i = 0; i < idList.size(); i++) {
					union_wh[i] = "dbo_new_news:list:newscatalogid:" + idList.get(i);
				}
				ids = jedis.zunionstore(key, Op_params, union_wh);
			}
			// String key =
			// "newsList:dbo_new_news:"+jedis.incr("newsList:dbo_new_news");

			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			Set<String> idlist = jedis.zrevrange(key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("pagecount", pagecount);
			objmap.put("count", ids);
			objmap.put("newsList", list);

			jedis.expire(key, 3600);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 根据新闻类型查询新闻
	public static Map<String, Object> getNewsByNewsTypeAndAreaId(List<String> idList, int page, int max, String areaid) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		String[] union_wh = new String[idList.size()];
		String[] inter_wh = new String[2];
		Map<String, Object> objmap = new HashMap<String, Object>();
		String area_key = "dbo_new_news:list:areaid:" + areaid;
		// String key = "area:newsList:dbo_new_news:"+idList.hashCode();
		String key = "news:catalog:dbo_new_news:" + idList.hashCode();
		ZParams Op_params = new ZParams();
		Op_params.aggregate(ZParams.Aggregate.MIN);
		try {
			if (!jedis.exists(key)) {
				for (int i = 0; i < idList.size(); i++) {
					union_wh[i] = "dbo_new_news:list:newscatalogid:" + idList.get(i);
				}
				// String key =
				// "news_union_newsList:dbo_new_news:"+jedis.incr("newsList:dbo_new_news");
				jedis.zunionstore(key, Op_params, union_wh);
			}
			inter_wh[0] = area_key;
			inter_wh[1] = key;
			String dst_key = "news_inter_newsList:dbo_new_news:" + jedis.incr("newsList:dbo_new_news");
			Long ids = jedis.zinterstore(dst_key, Op_params, inter_wh);
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			Set<String> idlist = jedis.zrevrange(dst_key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("pagecount", pagecount);
			objmap.put("count", ids);
			objmap.put("newsList", list);
			jedis.expire(key, 3600);
			jedis.expire(dst_key, 60);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 查询车型的文章
	public static Map<String, Object> getNewsByNewsTypeAndCarId(List<String> idList, int page, int max, String carid) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		String[] union_wh = new String[idList.size()];
		String[] inter_wh = new String[2];
		Map<String, Object> objmap = new HashMap<String, Object>();
		String area_key = "dbo_new_news:list:carcatalogid:" + carid;
		// String key = "news:catalog:dbo_new_news:"+idList.hashCode();
		String key = "news:catalog:dbo_new_news:" + idList.hashCode();
		ZParams Op_params = new ZParams();
		Op_params.aggregate(ZParams.Aggregate.MIN);
		try {

			if (!jedis.exists(key)) {
				for (int i = 0; i < idList.size(); i++) {
					union_wh[i] = "dbo_new_news:list:newscatalogid:" + idList.get(i);
				}
				// String key =
				// "car_union_newsList:dbo_new_news:"+jedis.incr("newsList:dbo_new_news");
				long ids1 = jedis.zunionstore(key, Op_params, union_wh);
			}

			inter_wh[0] = area_key;
			inter_wh[1] = key;
			String dst_key = "car_inter_newsList:dbo_new_news:" + jedis.incr("newsList:dbo_new_news");
			Long ids = jedis.zinterstore(dst_key, Op_params, inter_wh);
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			Set<String> idlist = jedis.zrevrange(dst_key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("pagecount", pagecount);
			objmap.put("count", ids);
			objmap.put("newsList", list);
			jedis.expire(key, 3600);
			jedis.expire(dst_key, 60);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 查询区域下车型的文章
	public static Map<String, Object> getNewsByAreaIdAndCarId(List<String> idList, int page, int max, String carid, String areaid) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();
		String[] union_wh = new String[idList.size()];
		String[] inter_wh = new String[3];
		Map<String, Object> objmap = new HashMap<String, Object>();
		String area_key = "dbo_new_news:list:areaid:" + areaid;
		String car_key = "dbo_new_news:list:carcatalogid:" + carid;
		// String key = "car:area:newsList:dbo_new_news:"+idList.hashCode();
		String key = "news:catalog:dbo_new_news:" + idList.hashCode();
		ZParams Op_params = new ZParams();
		Op_params.aggregate(ZParams.Aggregate.MIN);
		try {
			if (!jedis.exists(key)) {
				for (int i = 0; i < idList.size(); i++) {
					union_wh[i] = "dbo_new_news:list:newscatalogid:" + idList.get(i);
				}
				// String key =
				// "key_union_newsList:dbo_new_news:"+jedis.incr("newsList:dbo_new_news");
				jedis.zunionstore(key, Op_params, union_wh);
			}
			inter_wh[0] = area_key;
			inter_wh[1] = key;
			inter_wh[2] = car_key;
			String dst_key = "dst_inter_newsList:dbo_new_news:" + jedis.incr("newsList:dbo_new_news");
			Long ids = jedis.zinterstore(dst_key, Op_params, inter_wh);
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			Set<String> idlist = jedis.zrevrange(dst_key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("pagecount", pagecount);
			objmap.put("count", ids);
			objmap.put("newsList", list);
			jedis.expire(key, 3600);
			jedis.expire(dst_key, 60);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 查询车型的所有文章
	public static Map<String, Object> getNewsByCarid(String carid, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> objmap = new HashMap<String, Object>();
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			String key = "dbo_new_news:list:carcatalogid:" + carid;
			Set<String> idlist = new HashSet<String>();
			Long ids = jedis.zcard(key);
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			idlist = jedis.zrevrange(key, from, end - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("newsList", list);
			objmap.put("pagecount", pagecount);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 按日期查询所有文章文章页
	public static Map<String, Object> getNewsByDate(long objtime, long lasttime, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> objmap = new HashMap<String, Object>();
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			String key = "dbo_new_news:list:id:all";
			// long lasttime = objtime + 86399;
			Set<String> idlist = new HashSet<String>();
			Long ids = jedis.zcount(key, objtime, lasttime);
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			// idlist = jedis.zrevrange(key,from,end);
			idlist = jedis.zrevrangeByScore(key, lasttime, objtime, from, 10);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("newsList", list);
			objmap.put("pagecount", pagecount);
			objmap.put("count", ids);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 按日期查询所有原创文章页
	public static Map<String, Object> getNewsByDateAndOriginal(String original, long objtime, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> objmap = new HashMap<String, Object>();
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			String key = "dbo_new_news:list:isoriginal:" + original;
			long lasttime = objtime + 86399;
			Long ids = jedis.zcount(key, objtime, lasttime);
			Set<String> idlist = new HashSet<String>();
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			idlist = jedis.zrevrangeByScore(key, lasttime, objtime, from, 10);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("newsList", list);
			objmap.put("pagecount", pagecount);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 按日期查询所有原创文章页
	public static List<Map<String, String>> getNewsByOriginal(String original, long objtime, long lasttime, int from, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			String key = "dbo_new_news:list:isoriginal:" + original;
			// long lasttime = objtime + 86399;
			Long ids = jedis.zcount(key, objtime, lasttime);
			Set<String> idlist = new HashSet<String>();
			// Long pagecount = ids / max;
			// if (ids % max > 0) {
			// pagecount++;
			// }
			// int from = (page - 1) * max;
			// int end = page * max;
			idlist = jedis.zrevrangeByScore(key, lasttime, objtime, from, max);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return list;
	}

	// 按编辑查询原创文章页
	public static Map<String, Object> getNewsByPeopleName(String username, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> objmap = new HashMap<String, Object>();
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			String key = "dbo_new_news:list:addadmin:" + username;
			Long ids = jedis.zcard(key);
			Set<String> idlist = new HashSet<String>();
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			idlist = jedis.zrevrange(key, from, max - 1);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("newsList", list);
			objmap.put("pagecount", pagecount);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 按日期查询所有原创文章页
	public static Map<String, Object> getNewsBynewsTypeAndDateAndOriginal(String original, List<String> idList, long objtime, int page, int max) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> objmap = new HashMap<String, Object>();
		Jedis jedis = RedisManager.getJedis2Object();
		String[] union_wh = new String[idList.size()];
		String[] inter_wh = new String[2];
		// String type_key =
		// "original:newsList:dbo_new_news:"+idList.hashCode();
		String type_key = "type:news:catalog:dbo_new_news:" + idList.hashCode();
		ZParams Op_params = new ZParams();
		Op_params.aggregate(ZParams.Aggregate.MIN);
		try {
			if (!jedis.exists(type_key)) {
				for (int i = 0; i < idList.size(); i++) {
					union_wh[i] = "dbo_new_news:list:newscatalogid:" + idList.get(i);
				}
				// String type_key =
				// "type_union_newsList:dbo_new_news:"+jedis.incr("newsList:dbo_new_news");
				jedis.zunionstore(type_key, Op_params, union_wh);
			}

			String ori_key = "dbo_new_news:list:isoriginal:" + original;
			inter_wh[0] = ori_key;
			inter_wh[1] = type_key;
			String key = "newsList:dbo_new_news:" + jedis.incr("newsList:dbo_new_news");
			jedis.zinterstore(key, Op_params, inter_wh);
			long lasttime = objtime + 86399;
			Long ids = jedis.zcount(key, objtime, lasttime);
			Set<String> idlist = new HashSet<String>();
			Long pagecount = ids / max;
			if (ids % max > 0) {
				pagecount++;
			}
			int from = (page - 1) * max;
			int end = page * max;
			idlist = jedis.zrevrangeByScore(key, lasttime, objtime, from, 10);
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = jedis.hgetAll("dbo_new_news:id:" + idlist.toArray()[i]);
				if (map == null || map.size() == 0) {
					continue;
				}
				list.add(map);
			}
			objmap.put("newsList", list);
			objmap.put("pagecount", pagecount);
			jedis.expire(key, 60);
			jedis.expire(type_key, 3600);
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
		return objmap;
	}

	// 插入新闻
	public static int insertNews(DboNewNews newNews) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(newNews);
			if (map == null || map.size() == 0)
				return -1;
			jedis.hmset("dbo_new_news:id:" + newNews.getId(), map);

			int id = newNews.getId();
			int newsCatalogid = newNews.getNewscatalogid();
			Date adddate = newNews.getAdddate();
			String newseditor = newNews.getNewseditor();
			int areaid = newNews.getAreaid();
			int carcatalogid = newNews.getCarcatalogid();
			int isoriginal = newNews.getIsoriginal();

			double sort = adddate.getTime() / 1000;

			Map<String, Double> sortMap = new HashMap<String, Double>();
			sortMap.put(String.valueOf(id), sort);

			// tcCmd = "ZADD dbo_new_news:list:newscatalogid:";
			jedis.zadd("dbo_new_news:list:newscatalogid:" + newsCatalogid, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:addadmin:";
			jedis.zadd("dbo_new_news:list:addadmin:" + newseditor, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:areaid:";
			jedis.zadd("dbo_new_news:list:areaid:" + areaid, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:carcatalogid:";
			jedis.zadd("dbo_new_news:list:carcatalogid:" + carcatalogid, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:isoriginal:";
			jedis.zadd("dbo_new_news:list:isoriginal:" + isoriginal, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:id:all";
			jedis.zadd("dbo_new_news:list:id:all", sortMap);

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入新闻
	public static int updateNews(DboNewNews newNews, int old_newsCatalogid, int old_areaid, int old_carcatalogid, int old_isoriginal) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(newNews);
			if (map == null || map.size() == 0)
				return -1;
			jedis.hmset("dbo_new_news:id:" + newNews.getId(), map);

			int id = newNews.getId();
			int newsCatalogid = newNews.getNewscatalogid();
			Date adddate = newNews.getAdddate();
			String newseditor = newNews.getNewseditor();
			int areaid = newNews.getAreaid();
			int carcatalogid = newNews.getCarcatalogid();
			int isoriginal = newNews.getIsoriginal();

			double sort = adddate.getTime() / 1000;

			Map<String, Double> sortMap = new HashMap<String, Double>();
			sortMap.put(String.valueOf(id), sort);

			// tcCmd = "ZADD dbo_new_news:list:newscatalogid:";
			if (old_newsCatalogid > 0) {
				jedis.zrem("dbo_new_news:list:newscatalogid:" + old_newsCatalogid, String.valueOf(id));
				jedis.zadd("dbo_new_news:list:newscatalogid:" + newsCatalogid, sortMap);
			}

			// tcCmd = "ZADD dbo_new_news:list:addadmin:";
			// jedis.zadd("dbo_new_news:list:addadmin:" + newseditor, sortMap);

			// tcCmd = "ZADD dbo_new_news:list:areaid:";
			if (old_areaid > 0) {
				jedis.zrem("dbo_new_news:list:areaid:" + old_areaid, String.valueOf(id));
				jedis.zadd("dbo_new_news:list:areaid:" + areaid, sortMap);
			}

			// tcCmd = "ZADD dbo_new_news:list:carcatalogid:";
			if (old_carcatalogid > 0) {
				jedis.zrem("dbo_new_news:list:carcatalogid:" + old_carcatalogid, String.valueOf(id));
				jedis.zadd("dbo_new_news:list:carcatalogid:" + carcatalogid, sortMap);
			}

			if (old_isoriginal >= 0) {
				// tcCmd = "ZADD dbo_new_news:list:isoriginal:";
				jedis.zrem("dbo_new_news:list:isoriginal:" + old_isoriginal, String.valueOf(id));
				jedis.zadd("dbo_new_news:list:isoriginal:" + isoriginal, sortMap);
			}

			// tcCmd = "ZADD dbo_new_news:list:id:all";
			// jedis.zadd("dbo_new_news:list:id:all", sortMap);

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入新闻
	public static int deleteNews(DboNewNews newNews) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(newNews);
			if (map == null || map.size() == 0)
				return -1;

			int id = newNews.getId();
			int newsCatalogid = newNews.getNewscatalogid();
			Date adddate = newNews.getAdddate();
			String newseditor = newNews.getNewseditor();
			int areaid = newNews.getAreaid();
			int carcatalogid = newNews.getCarcatalogid();
			int isoriginal = newNews.getIsoriginal();

			jedis.del("dbo_new_news:id:" + id);

			double sort = adddate.getTime() / 1000;

			Map<String, Double> sortMap = new HashMap<String, Double>();
			sortMap.put(String.valueOf(id), sort);

			// tcCmd = "ZADD dbo_new_news:list:newscatalogid:";
			jedis.zrem("dbo_new_news:list:newscatalogid:" + newsCatalogid, String.valueOf(id));

			// tcCmd = "ZADD dbo_new_news:list:addadmin:";
			jedis.zrem("dbo_new_news:list:addadmin:" + newseditor, String.valueOf(id));

			// tcCmd = "ZADD dbo_new_news:list:areaid:";
			jedis.zrem("dbo_new_news:list:areaid:" + areaid, String.valueOf(id));

			// tcCmd = "ZADD dbo_new_news:list:carcatalogid:";
			jedis.zrem("dbo_new_news:list:carcatalogid:" + carcatalogid, String.valueOf(id));

			// tcCmd = "ZADD dbo_new_news:list:isoriginal:";
			jedis.zrem("dbo_new_news:list:isoriginal:" + isoriginal, String.valueOf(id));

			// tcCmd = "ZADD dbo_new_news:list:id:all";
			jedis.zrem("dbo_new_news:list:id:all", String.valueOf(id));

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入news_content
	public static int insertContentbak(DboContentbak contentbak) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(contentbak);
			if (map == null || map.size() == 0)
				return -1;

			int id = contentbak.getId();
			// int newsid = contentbak.getNewsid();

			jedis.hmset("dbo_contentbak:id:" + String.valueOf(id), map);

			// tcCmd = "ZADD dbo_new_content:list:newsid:";
			// jedis.zadd("dbo_new_content:list:newsid:" + newsid, sortid,
			// String.valueOf(id));

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入news_content
	public static int insertNewcontent(DboNewContent dboNewContent) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(dboNewContent);
			if (map == null || map.size() == 0)
				return -1;

			int id = dboNewContent.getId();
			int newsid = dboNewContent.getNewsid();
			int sortid = dboNewContent.getSortid();

			jedis.hmset("dbo_new_content:id:" + String.valueOf(id), map);

			// tcCmd = "ZADD dbo_new_content:list:newsid:";
			jedis.zadd("dbo_new_content:list:newsid:" + newsid, sortid, String.valueOf(id));

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入新闻
	public static int deleteNewcontent(DboNewContent dboNewContent) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			Map<String, String> map = ObjectToMapUtil.changeToMap(dboNewContent);
			if (map == null || map.size() == 0)
				return -1;

			int id = dboNewContent.getId();
			int newsid = dboNewContent.getNewsid();

			jedis.del("dbo_new_content:id:" + String.valueOf(id));

			// tcCmd = "ZADD dbo_new_content:list:newsid:";
			jedis.zrem("dbo_new_content:list:newsid:" + newsid, String.valueOf(id));

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入news_content
	// public static int initAdmUser(List<DboAdmUser> list) {
	// Jedis jedis = RedisManager.getJedis2Object();
	//
	// try {
	// for (DboAdmUser dboAdmUser : list) {
	// Map<String, String> map = ObjectToMapUtil.changeToMap(dboAdmUser);
	// if (map == null || map.size() == 0)
	// return -1;
	//
	// int id = dboAdmUser.getId();
	// String username = dboAdmUser.getUsername();
	//
	// jedis.hmset("dbo_adm_user:id:" + String.valueOf(id), map);
	//
	// jedis.set("dbo_adm_user:id:username:" + username, String.valueOf(id));
	//
	// }
	// return 1;
	// } finally {
	// // TODO: handle exception
	// RedisManager.recycleJedis2Ojbect(jedis);
	// }
	// }

	public static Map<String, String> getAllEditorByUsername(String username) throws Exception {
		Jedis jedis = RedisManager.getJedis2Object();
		// System.out.println("getAllEditorByUsername -----000--->");
		try {
			String id_key = "dbo_adm_user:list:username:" + username;
			Set<String> ids = jedis.zrange(id_key, 0, -1);
			String id = null;
			if (ids.size() > 0) {
				id = (String) (ids.toArray()[0]);
				Map<String, String> map = jedis.hgetAll("dbo_adm_user:id:" + id);
				return map;
			} else {
				System.out.println(">>> >>> dbo_adm_user:list:username:"+username+" not find");
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	// 插入news_content
	public static int setAllEditor(List<DboAdmUser> list) {
		Jedis jedis = RedisManager.getJedis2Object();

		try {
			String allid = "";

			for (DboAdmUser dboAdmUser : list) {
				allid += "," + dboAdmUser.getId();

			}
			allid = allid.substring(1);
			jedis.set("dbo_adm_user_all_editor", allid);

			return 1;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	public static void delAllEditor() {
		Jedis jedis = RedisManager.getJedis2Object();
		try {
			// String allid = jedis.get("dbo_adm_user_all_editor");
			jedis.del("dbo_adm_user_all_editor");

		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	public static List<Map<String, String>> getAllEditor() {
		Jedis jedis = RedisManager.getJedis2Object();

		try {

			if (!jedis.exists("dbo_adm_user_all_editor"))
				return null;

			String allid = jedis.get("dbo_adm_user_all_editor");

			String[] arr = allid.split(",");

			List<Map<String, String>> allEditor = new ArrayList<Map<String, String>>();

			for (String id : arr) {

				Map<String, String> map = jedis.hgetAll("dbo_adm_user:id:" + id);
				allEditor.add(map);
			}

			return allEditor;
		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

	public static void main(String[] args) {
		// String rootpath =
		// "D:\\workspace_java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\adminche\\";
		// car_daos.DBConnectionManager.init(rootpath);
		//
		// initAdmUser();
		// delAllEditor();
		Jedis jedis = RedisManager.getJedis2Object();

		try {

			Map<String, String> map = jedis.hgetAll("dbo_adm_user:id:529");
			Set<Entry<String, String>> set = map.entrySet();
			for (Entry<String, String> entry : set) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}

			// jedis.hdel("dbo_new_news:id:600759");

			// jedis.hmset("dbo_new_news:id:" + newNews.getId(), map);

		} finally {
			// TODO: handle exception
			RedisManager.recycleJedis2Ojbect(jedis);
		}
	}

}
