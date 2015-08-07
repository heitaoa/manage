package com.redis;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import car_beans.DboCarAutohomeprop;
import car_beans.DboCarCatalognew;
import car_beans.DboDeaDealers;
import car_beans.DboDntTousuDetail;
import car_beans.DboSubData;

import com.poly.util.GetPy;
import com.poly.util.ObjectToMapUtil;
import com.poly.util.StringUtils;

public class RedisDao {

	protected String tbl = "tb_xxx";

	// protected String KEY_INDEX_1 = "tb_xxx:index:fieldname";

	protected String KEY_QUEUE = "key_queue";

	public RedisDao() {

	}

	public static boolean existsSSetKey(String key) {
		boolean result; 
		Jedis jedis = RedisManager.getJedisObject();
		result = jedis.exists(key);
		RedisManager.recycleJedisOjbect(jedis);
		return result;
	}

	public static long lenSSetKey(String key) {
		long len = 0;
		Jedis jedis = RedisManager.getJedisObject();
		len = jedis.zcount(key, 0, 1);
		RedisManager.recycleJedisOjbect(jedis);
		return len;
	}

	public static String getValueByKey(String key, String field) {
		String result;
		Jedis jedis = RedisManager.getJedisObject();
		result = jedis.hget(key, field);
		RedisManager.recycleJedisOjbect(jedis);
		return result;
	}

	public static Object getObjectByKey(String key) {
		Object result;
		Jedis jedis = RedisManager.getJedisObject();
		result = jedis.hgetAll(key);
		RedisManager.recycleJedisOjbect(jedis);
		return result;
	}

	public static Map<String, String> getObjectsByKey(String key) {
		Map<String, String> result;
		Jedis jedis = RedisManager.getJedisObject();
		result = jedis.hgetAll(key);
		RedisManager.recycleJedisOjbect(jedis);
		return result;
	}

	public static HashMap<String, Object> getDealerlist(String province1,
			String cityid1, int page, String serialid, String carid, int is4s) {
		String province = province1;
		String cityid = cityid1;
		Jedis jedis = RedisManager.getJedisObject();// 获得jedis实例
		String provincename = "";
		String catalogname = "";
		HashMap obj = new HashMap<String, String>();
		long tot_page;
		long prev_page;
		long next_page;
		List<Integer> lstPage = new ArrayList<Integer>();
		List<Map<String, String>> lstDealer = new ArrayList<Map<String, String>>();
		long len;

		if (province != null && province.equals("-1") == false
				&& province.equals("0") == false && province.length() > 0) {
			String fatherid = jedis.hget("dbo_are_catalog:catalogid:"
					+ province, "fatherid");
			if (fatherid != null && fatherid.equals("0") == false) {
				cityid = province;
			}
		}

		String dstkey = "collection:dealerlist:" + province + ":" + cityid
				+ ":" + serialid + ":" + carid + ":" + is4s;
		if (existsSSetKey(dstkey)) {
			len = lenSSetKey(dstkey);
		} else {

			Set<String> areaid = null;
			// jedis.zinterstore(dstkey, sets)

			if (cityid != null && cityid.equals("-1") == false
					&& cityid.equals("0") == false && cityid.length() > 0) {
				// cmd = "dbo_are_catalog:catalogid:" + cityid;
				areaid = new HashSet<String>();
				areaid.add(cityid);
			} else if (province != null && province.equals("-1") == false
					&& province.equals("0") == false && province.length() > 0) {
				String cmd = "dbo_are_catalog:list:city:" + province;
				areaid = jedis.zrange(cmd, 0, -1);

				provincename = jedis.hget("dbo_are_catalog:catalogid:"
						+ province, "catalogname");
			}
			if (areaid != null && areaid.size() > 0) {
				String[] union_wh = new String[areaid.size()];
				int i = 0;

				for (i = 0; i < areaid.size(); i++) {
					union_wh[i] = "dbo_dea_dealers:list:areaid:"
							+ (String) (areaid.toArray()[i]);
				}
				if (jedis.exists(dstkey + ":areadid") == false) {
					jedis.zunionstore(dstkey + ":areadid", union_wh);
					int seconds = 100;
					jedis.expire(dstkey + ":areadid", seconds);
				}
			}
			List<String> inter_wh_tmp = new ArrayList<String>();
			if (areaid != null && areaid.size() > 0) {
				inter_wh_tmp.add(dstkey + ":areadid");
			}
			if (serialid != null && serialid.equals("-1") == false
					&& serialid.length() > 0) {
				inter_wh_tmp.add("dbo_dea_dealers:list:mainbrand:" + serialid);
				catalogname = jedis.hget("dbo_car_catalognew:catalogid:"
						+ serialid, "catalogname");
			}
			if (carid != null && carid.equals("-1") == false
					&& carid.length() > 0) {
				Set<String> carlist = jedis.zrange(
						"dbo_car_catalognew:list:fatherid:" + carid, 0, -1);

				String[] union_serial = new String[carlist.size()];

				for (int ii = 0; ii < carlist.size(); ii++) {
					union_serial[ii] = "dbo_ent_product:list:typeid-eid:"
							+ (String) (carlist.toArray()[ii]);
				}
				if (jedis.exists(dstkey + ":typeid-eid") == false) {
					jedis.zunionstore(dstkey + ":typeid-eid", union_serial);
					int seconds = 60 * 60;
					jedis.expire(dstkey + ":typeid-eid", seconds);
				}
				inter_wh_tmp.add(dstkey + ":typeid-eid");
				catalogname = jedis.hget("dbo_car_catalognew:catalogid:"
						+ carid, "catalogname");
			}
			inter_wh_tmp.add("dbo_dea_dealerinfo:list:eid:all");
			if (is4s == 1 || is4s == 0) {
				inter_wh_tmp.add("dbo_dea_dealers:list:is4s:" + is4s);
			}
			String[] inter_wh = new String[inter_wh_tmp.size()];
			inter_wh_tmp.toArray(inter_wh);
			if (inter_wh.length == 1) {
				dstkey = inter_wh[0];
				// jedis.rename(inter_wh[0], dstkey);
				len = jedis.zcount(dstkey, 0, 1);
			} else {
				len = jedis.zinterstore(dstkey, inter_wh);
			}
		}
		tot_page = len / 10;
		if (len % 10 > 0) {
			tot_page = tot_page + 1;
		}
		prev_page = page - 1;
		next_page = page + 1;
		int bg = (page - 1) / 5 * 5;
		for (int i = bg; i < bg + 5; i++) {
			if (i < tot_page) {
				lstPage.add(i + 1);
			}
		}
		Set<String> lstEid = jedis.zrange(dstkey, (page - 1) * 8, page * 8);

		for (int j = 0; j < lstEid.size(); j++) {
			Map<String, String> map = jedis.hgetAll("dbo_dea_dealers:eid:"
					+ (String) (lstEid.toArray()[j]));
			lstDealer.add(map);
		}
		RedisManager.recycleJedisOjbect(jedis);
		obj.put("len", len);
		obj.put("key", dstkey);
		obj.put("tot_page", tot_page);
		obj.put("prev_page", prev_page);
		obj.put("next_page", next_page);
		obj.put("tot_num", len);
		obj.put("lstPage", lstPage);
		obj.put("lstDealer", lstDealer);
		obj.put("catalogname", catalogname);
		obj.put("provincename", provincename);
		return obj;
	}

	// ��ȡ����������
	public static Map<String, String> getDealer(int eid) {
		return getTab("dbo_dea_dealers:eid:", String.valueOf(eid));
		// "dbo_dea_dealerinfo:eid:" + eid
	}

	public static Map<String, String> getTab(String prex_ky, String val) {
		return getObjectsByKey(prex_ky + val);
	}

	// dbo_car_catalognew
	// select * from dbo_car_catalognew where catalogid=��
	public static Map<String, String> getCatalognewById(int id) {
		return getTab("dbo_car_catalognew:catalogid:", String.valueOf(id));
	}
	
	//更具级别获取相关信息
	public static List<Map<String, String>> getcatalogMapByPatheLevel(int pathlevel){
		Jedis jedis = RedisManager.getJedisObject();
		List<Map<String, String>> obj = new ArrayList<Map<String, String>>();
		try {
			Set<String> tmpareaid = jedis.zrange(
					"dbo_car_catalognew:list:pathlevel:" + pathlevel, 0, -1);
			for (int jjj = 0; jjj < tmpareaid.size(); jjj++) {
				Map<String, String> tmpp = jedis
						.hgetAll("dbo_car_catalognew:catalogid:"
								+ (String) (tmpareaid.toArray()[jjj]));
				if (tmpp != null && tmpp.size() > 0) {
					obj.add(tmpp);
				}
			}
		} finally {
			RedisManager.recycleJedisOjbect(jedis);
		}
		return obj;
	}
	
	// 根据品牌获取渠道列表
	public static List<Map<String, List<Object>>> getCarListByBrand(
			int catatolid) {
		Jedis jedis = RedisManager.getJedisObject();
		List<Map<String, List<Object>>> obj = new ArrayList<Map<String, List<Object>>>();
		try {
			String cmd = "dbo_car_catalognew:list:brand-iway:" + catatolid;
			Set<String> lstiway = jedis.zrange(cmd, 0, -1);
			for (int i = 0; i < lstiway.size(); i++) {
				Map<String, List<Object>> map = new HashMap<String, List<Object>>();
				List<Object> lst = new ArrayList<Object>();
				Set<String> lstid = jedis.zrange(
						"dbo_car_catalognew:list:iway:"
								+ (String) (lstiway.toArray()[i]), 0, -1);
				for (int j = 0; j < lstid.size(); j++) {
					Map<String, String> mapdt = jedis
							.hgetAll("dbo_car_catalognew:catalogid:"
									+ (String) (lstid.toArray()[j]));
					if (mapdt != null && mapdt.size() > 0) {
						List<Map<String, String>> objList = getCatalognewByFatherId(Integer.valueOf(mapdt.get("catalogid")));
						if(objList.size()>0){
							mapdt.put("childrenid",objList.get(0).get("catalogid"));
							lst.add(mapdt);
						}
					}
				}
				map.put((String) (lstiway.toArray()[i]), lst);
				obj.add(map);
			}
		} finally {
			RedisManager.recycleJedisOjbect(jedis);
		}
		return obj;
	}
		
		
	// 更具渠道获取车系
	public static List<Map<String, String>> getCarInfoByIway(int brandid,
			String iway, int serialid) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<Map<String, String>> serialList = getCatalognewByFatherId(brandid);
		for (Map<String, String> map : serialList) {
			String iwayx = map.get("iway");
			String islive = map.get("islive");// 1-在产
			String onsale = map.get("onsale");// 1-在售
			if (!"1".equals(islive) || !"1".equals(onsale))
				continue;
			if (iwayx.equals(iway)
					&& !(serialid + "").equals(map.get("catalogid")))
				list.add(map);
		}
		return list;

	}
	

	// select * from dbo_car_catalognew where fatherid = ��
	// SELECT lname ,catalogname,catalogid,byname FROM dbo_car_catalognew WHERE
	// isdelete = 0 AND fatherid = 0 ORDER BY lname
	public static List<Map<String, String>> getCatalognewByFatherId(int id) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_car_catalognew:list:fatherid:" + id;

		Set<String> set_carid = jedis.zrange(cmd, 0, -1);
		List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
		for (int j = 0; j < set_carid.size(); j++) {
			Map<String, String> map = jedis
					.hgetAll("dbo_car_catalognew:catalogid:"
							+ (String) (set_carid.toArray()[j]));
			lstret.add(map);
		}
		RedisManager.recycleJedisOjbect(jedis);
		return lstret;
	}

	// dbo_car_autohomeprop
	// select * from dbo_car_autohomeprop where carid = ��
	public static Map<String, String> getAutohomepropByCarId(int id) {
		return getTab("dbo_car_autohomeprop:carid:", String.valueOf(id));
	}

	// select * from dbo_car_autohomeprop where where carid in����
	public static List<Map<String, String>> getAutohomepropBySerialId(int id) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_car_catalognew:list:fatherid:" + id;

		Set<String> set_carid = jedis.zrange(cmd, 0, -1);

		List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
		for (int j = 0; j < set_carid.size(); j++) {
			Map<String, String> map = jedis
					.hgetAll("dbo_car_autohomeprop:carid:"
							+ (String) (set_carid.toArray()[j]));
			lstret.add(map);
		}
		RedisManager.recycleJedisOjbect(jedis);
		return lstret;
	}
	
	public static List<Map<String, String>> getAutohomepropBySerialId2(int id) {
		Jedis jedis = RedisManager.getJedisObject();
		String zinterRedisKey = UUID.randomUUID().toString();
		List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
		
		try{
		String cmd = "dbo_car_catalognew:list:fatherid:" + id;
		
		String cmd1 = "dbo_car_catalognew:list:onsale:1";
		long count = jedis.zinterstore(zinterRedisKey, cmd, cmd1);

		Set<String> set_carid = jedis.zrange(zinterRedisKey, 0, -1);

		for (int j = 0; j < set_carid.size(); j++) {
			Map<String, String> map = jedis
					.hgetAll("dbo_car_autohomeprop:carid:"
							+ (String) (set_carid.toArray()[j]));
			lstret.add(map);
		}
		} finally {
			jedis.expire(zinterRedisKey, 60);
			RedisManager.recycleJedisOjbect(jedis);
		}
		return lstret;
	}

	// dbo_pub_ipdata
	// SELECT areaid from dbo_pub_ipdata WHERE ipnumstart<= ? AND ipnumend >=?
	public static Map<String, String> getPubIpDataByIP(long ip) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_pub_ipdata:list:ip";

		Set<String> set_carid = jedis.zrangeByScore(cmd, ip, ip);
		if (set_carid.size() > 0) {
			Map<String, String> map = jedis.hgetAll("dbo_pub_ipdata:id:"
					+ (String) (set_carid.toArray()[0]));
			RedisManager.recycleJedisOjbect(jedis);
			return map;
		} else {
			RedisManager.recycleJedisOjbect(jedis);
			return null;
		}
	}

	// SELECT b.id,a.catalogid,b.title,a.type,b.path FROM dbo_img_title a INNER
	// JOIN dbo_img_content b ON a.id = b.titleid WHERE a.catalogid = ? ORDER BY
	// type,b.sortid
	public static List<Map<String, String>> getImgTitleContentByCatalogid(int id) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_img_title:list:catalogid:" + id;
		Set<String> set_a = jedis.zrange(cmd, 0, -1);
		List<Map<String, String>> lsta = new ArrayList<Map<String, String>>();
		if (set_a.size() > 0) {
			for (int j = 0; j < set_a.size(); j++) {
				Map<String, String> map = jedis.hgetAll("dbo_img_title:id:"
						+ (String) (set_a.toArray()[j]));
				lsta.add(map);
			}
		}
		List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
		for (int i = 0; i < lsta.size(); i++) {
			cmd = "dbo_img_content:list:titleid:" + lsta.get(i).get("id");
			Set<String> set_b = jedis.zrange(cmd, 0, -1);
			for (int j = 0; j < set_b.size(); j++) {
				Map<String, String> map = jedis.hgetAll("dbo_img_content:id:"
						+ (String) (set_b.toArray()[j]));
				map.put("catalogid", lsta.get(i).get("catalogid"));
				map.put("type", lsta.get(i).get("type"));
				lstret.add(map);
			}
		}
		RedisManager.recycleJedisOjbect(jedis);
		return lstret;
	}

	// SELECT a.catalogid,COUNT(*) AS max FROM dbo_img_title a INNER JOIN
	// dbo_img_content b ON a.id = b.titleid WHERE a.catalogid IN ( xxx ) GROUP
	// BY a.catalogid
	public static List<Map<String, Object>> getImgTitleCountByCatalogid(int id) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_car_catalognew:list:fatherid:" + id;
		Set<String> set_catalogid = jedis.zrange(cmd, 0, -1);

		List<Map<String, Object>> lstret = new ArrayList<Map<String, Object>>();

		for (int z = 0; z < set_catalogid.size(); z++) {
			cmd = "dbo_img_title:list:catalogid:"
					+ (String) (set_catalogid.toArray()[z]);
			Set<String> set_a = jedis.zrange(cmd, 0, -1);
			List<Map<String, String>> lsta = new ArrayList<Map<String, String>>();
			if (set_a.size() > 0) {
				for (int j = 0; j < set_a.size(); j++) {
					Map<String, String> map = jedis.hgetAll("dbo_img_title:id:"
							+ (String) (set_a.toArray()[j]));
					lsta.add(map);
				}
			}
			for (int i = 0; i < lsta.size(); i++) {
				cmd = "dbo_img_content:list:titleid:" + lsta.get(i).get("id");
				Set<String> set_b = jedis.zrange(cmd, 0, -1);
				boolean cheflag = false;
				for (Map<String, Object> lmap : lstret) {
					if ((lmap.get("catalogid").toString()).equals(lsta.get(i)
							.get("catalogid"))) {
						int count = Integer.parseInt(lmap.get("count")
								.toString()) + set_b.size();
						lmap.put("count", count);
						cheflag = true;
					}
				}
				if (!cheflag) {
					if (set_b.size() != 0) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("catalogid", lsta.get(i).get("catalogid"));
						map.put("count", set_b.size());
						lstret.add(map);
					}
				}
			}

		}
		RedisManager.recycleJedisOjbect(jedis);
		return lstret;
	}

	// select MIN(price) AS min,MAX(price) AS max from dbo_ent_product where
	// typeid = ?
	public static Map<String, Object> getEntProductPriceRange(int id) {
		Jedis jedis = RedisManager.getJedisObject();

		String cmd = "dbo_ent_product:list:typeid:" + id;
		Set<Tuple> set_catalogid = jedis.zrangeByScoreWithScores(cmd, "-inf",
				"+inf");
		long maxp = 0;
		long minp = 0;
		if (set_catalogid.size() > 0) {
			Tuple kk = (Tuple) (set_catalogid.toArray()[0]);
			minp = (long) kk.getScore();

			kk = (Tuple) (set_catalogid.toArray()[set_catalogid.size() - 1]);
			minp = (long) kk.getScore();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("min", minp);
		map.put("max", maxp);

		RedisManager.recycleJedisOjbect(jedis);
		return map;
	}

	// 获取所有品牌或车系的下图片数量——————参数：父id
	public static Map<String, String> getCarsNum(int fatherid) {
		Jedis jedis = RedisManager.getJedisObject();
		Map<String, String> result = new HashMap<String, String>();
		try {
			Set<String> lstid = jedis.zrange(
					"dbo_car_catalognew:list:fatherid:" + fatherid, 0, -1);
			for (String key : lstid) {
				String num = jedis
						.hget("dbo_img_adcnt:catalogid:" + key, "cnt");
				result.put(key, num);
			}
		} catch (Error err) {

		} finally {
			RedisManager.recycleJedisOjbect(jedis);
		}
		return result;
	}

	public static String getCarsNumByid(int carid) {
		Jedis jedis = RedisManager.getJedisObject();
		String num = "0";
		try {
			num = jedis.hget("dbo_img_cnt:catalogid:" + carid, "cnt");
		} catch (Error err) {

		} finally {
			RedisManager.recycleJedisOjbect(jedis);
		}
		return num;
	}

	public static void insertSubData(DboSubData subData) {
		Jedis jedis = RedisManager.getJedisObject();
		try {
			Map<String, String> dataMap = new HashMap<String, String>();
			Class<?> clazz = DboSubData.class;
			Field fields[] = clazz.getDeclaredFields();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Field f : fields) {
				f.setAccessible(true);
				try {
					Object obj = f.get(subData);
					String result = null;
					if (obj != null && obj instanceof Date) {
						result = sdf.format((Date) obj);
					} else {
						if (obj != null) {
							result = obj.toString();
						}
					}
					result = StringUtils.parseRedisStr(result);
					dataMap.put(f.getName(), result);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			String key = "dbo_sub_data:id:" + subData.getId();
			jedis.hmset(key, dataMap);

			Map<String, Double> bySortid = new HashMap<String, Double>();
			bySortid.put(Integer.toString(subData.getId()),
					(double) subData.getSortid());
			Object sid = dataMap.get("sid");
			key = "dbo_sub_data:list:sid:" + sid;
			jedis.zadd(key, bySortid);

		} finally {
			RedisManager.recycleJedisOjbect(jedis);
		}
	}

	public static void UpdateUserLevelByUid(int uid, int eid,
			Map<String, String> mp) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.hmset("dbo_dnt_userlevel:uid:" + uid, mp);
				jedis.zadd("dbo_dnt_userlevel:list:eid:" + eid, 0,
						String.valueOf(uid));
			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpdateDealerInfoByUid(int uid, String username,
			Map<String, String> mp) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.hmset("dbo_dnt_users:uid:" + uid, mp);
				jedis.zadd("dbo_dnt_users:list:username:" + username, 0,
						String.valueOf(uid));
			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpdateDealerInfosByEid(int eid, int areaid, int is4s,
			int paylevel, String iway, String mainbrand, int jinbi,
			DboDeaDealers oldInfo, DboDeaDealers newinfo) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.zrem("dbo_dea_dealers:list:issupervip:"+oldInfo.getIssupervip(),String.valueOf(eid));
				jedis.zadd("dbo_dea_dealers:list:issupervip:"+newinfo.getIssupervip(), 0,String.valueOf(eid));
				jedis.zrem(
						"dbo_dea_dealers:list:areaid:" + oldInfo.getAreaid(),
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealers:list:areaid:" + areaid, jinbi,
						String.valueOf(eid));
				jedis.zrem("dbo_dea_dealers:list:is4s:" + oldInfo.getIs4s(),
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealers:list:is4s:" + is4s, jinbi,
						String.valueOf(eid));
				jedis.zrem(
						"dbo_dea_dealers:list:paylevel:"
								+ oldInfo.getPaylevel(), String.valueOf(eid));
				jedis.zadd("dbo_dea_dealers:list:paylevel:" + paylevel, newinfo.getExpirationdate().getTime()/1000,
						String.valueOf(eid));
				String[] oldIways = oldInfo.getIway().split(",");
				for (int j = 0; j < oldIways.length; j++) {
					jedis.zrem("dbo_dea_dealers:list:iway:" + oldIways[j],
							String.valueOf(eid));
				}
				String[] iways = iway.split(",");
				for (int j = 0; j < iways.length; j++) {
					jedis.zadd("dbo_dea_dealers:list:iway:" + iways[j], jinbi,
							String.valueOf(eid));
				}
				String[] oldBrand = oldInfo.getMainbrand().split(",");
				for (int j = 0; j < oldBrand.length; j++) {
					jedis.zrem("dbo_dea_dealers:list:mainbrand:" + oldBrand[j],
							String.valueOf(eid));
				}
				String[] mainbrands = mainbrand.split(",");
				for (int j = 0; j < mainbrands.length; j++) {
					jedis.zadd("dbo_dea_dealers:list:mainbrand:"
							+ mainbrands[j], jinbi, String.valueOf(eid));
				}
				jedis.zadd("dbo_dea_dealers:list:eid:all", jinbi+oldInfo.getIssupervip()*1000000,
						String.valueOf(eid));
				Map<String, String> mp = ObjectToMapUtil.changeToMap(newinfo);
				jedis.hmset("dbo_dea_dealers:eid:" + eid, mp);

			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void inSertDealersByEid(DboDeaDealers info,
			Map<String, String> mp) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.zadd("dbo_dea_dealers:list:issupervip:"+info.getIssupervip(), 0,String.valueOf(info.getEid()));
				jedis.zadd(
						"dbo_dea_dealers:list:username:" + info.getUsername(),
						info.getJinbi(), String.valueOf(info.getEid()));
				jedis.zadd("dbo_dea_dealers:list:domain:" + info.getDomain(),
						info.getJinbi(), String.valueOf(info.getEid()));
				jedis.zadd("dbo_dea_dealers:list:areaid:" + info.getAreaid(),
						info.getJinbi(), String.valueOf(info.getEid()));
				jedis.zadd("dbo_dea_dealers:list:is4s:" + info.getIs4s(),
						info.getJinbi(), String.valueOf(info.getEid()));
				jedis.zadd(
						"dbo_dea_dealers:list:paylevel:" + info.getPaylevel(),
						info.getExpirationdate().getTime()/1000, String.valueOf(info.getEid()));
				String[] iways = info.getIway().split(",");
				for (int j = 0; j < iways.length; j++) {
					jedis.zadd("dbo_dea_dealers:list:iway:" + iways[j],
							info.getJinbi(), String.valueOf(info.getEid()));
				}
				String[] mainbrands = info.getMainbrand().split(",");
				for (int j = 0; j < mainbrands.length; j++) {
					jedis.zadd("dbo_dea_dealers:list:mainbrand:"
							+ mainbrands[j], info.getJinbi(),
							String.valueOf(info.getEid()));
				}
				jedis.zadd("dbo_dea_dealers:list:eid:all",info.getJinbi()+info.getIssupervip()*1000000 ,String.valueOf(info.getEid()));
				jedis.hmset("dbo_dea_dealers:eid:" + info.getEid(), mp);
			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void insertDealerInfoByEid(Map<String, String> mp, int eid) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {

				jedis.zadd("dbo_dea_dealerinfo:list:eid:all", 0,
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lat:all", 0,
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lat:all2", 0,
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lng:all", 0,
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lng:all2", 0,
						String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lat:all1",1, String.valueOf(eid));
				jedis.zadd("dbo_dea_dealerinfo:list:h_lng:all1",1, String.valueOf(eid));
				jedis.hmset("dbo_dea_dealerinfo:eid:" + eid, mp);
			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpdateDealerIsdeleteByEid(int eid, String username,
			String domain, int areaid, int is4s, int paylevel, String iway,
			String mainbrand) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {

				jedis.zrem("dbo_dea_dealers:list:username:" + username,
						String.valueOf(eid));
				jedis.zrem("dbo_dea_dealers:list:domain:" + domain,
						String.valueOf(eid));
				jedis.zrem("dbo_dea_dealers:list:areaid:" + areaid,
						String.valueOf(eid));
				jedis.zrem("dbo_dea_dealers:list:is4s:" + is4s,
						String.valueOf(eid));
				jedis.zrem("dbo_dea_dealers:list:paylevel:" + paylevel,
						String.valueOf(eid));
				String[] iways = iway.split(",");
				for (int j = 0; j < iways.length; j++) {
					jedis.zrem("dbo_dea_dealers:list:iway:" + iways[j],
							String.valueOf(eid));
				}

				jedis.zrem("dbo_dea_dealers:list:eid:all", String.valueOf(eid));
				String[] mainbrands = mainbrand.split(",");
				for (int j = 0; j < mainbrands.length; j++) {
					jedis.zrem("dbo_dea_dealers:list:mainbrand:"
							+ mainbrands[j], String.valueOf(eid));
				}

				jedis.del("dbo_dea_dealers:eid:" + eid);
			} finally {

				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpdateUserPassWordByEid(int uid, String password) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.hset("dbo_dnt_users:uid:" + uid, "password", password);
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowBySaveA(int id, int live, int sale,
			String eName, String photo, String mainphoto,
			DboCarCatalognew oldCatalognew, DboCarCatalognew newCatalognew) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.zrem(
						"dbo_car_catalognew:list:islive:"
								+ oldCatalognew.getIslive(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:islive:" + live,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale:" + sale,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale1:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale1:" + sale, 0,
						String.valueOf(id));
				jedis.zrem("dbo_car_catalognew:list:englishname:"
						+ oldCatalognew.getEnglishname(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:englishname:" + eName, 0,
						String.valueOf(id));
				jedis.hset("dbo_car_catalognew:catalogid:" + id, "islive",
						String.valueOf(live));
				jedis.hset("dbo_car_catalognew:catalogid:" + id, "onsale",
						String.valueOf(sale));
				jedis.hset("dbo_car_catalognew:catalogid:" + id, "englishname",
						eName);
				Map<String, String> mp = ObjectToMapUtil
						.changeToMap(newCatalognew);
				jedis.hmset("dbo_car_catalognew:catalogid:" + id, mp);
				
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowBySaveC(int id, String live,
			String sale, String iyear, String xiangti, String bsq,
			String jibie, String madein, String leixing, String fadongji,
			String eName, String pailiang, String photo, String qudao,
			DboCarCatalognew oldCatalognew, DboCarCatalognew newCatalognew) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.zrem(
						"dbo_car_catalognew:list:islive:"
								+ oldCatalognew.getIslive(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:islive:" + live,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale:" + sale,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale1:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale1:" + sale, 0,
						String.valueOf(id));
				jedis.zrem("dbo_car_catalognew:list:englishname:"
						+ oldCatalognew.getEnglishname(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:englishname:" + eName, 0,
						String.valueOf(id));
				String oldIway = oldCatalognew.getIway();
				int num = 0;
				for (int j = 0; j < oldIway.length(); j++) {
					if (oldIway.substring(j, j + 1).matches("^[a-zA-Z]*")) {
						num++;
					}
				}
				if (num == 0) {
					for (int j = 0; j < oldIway.length(); j++) {
						jedis.zrem(
								"dbo_car_catalognew:like:iway:"
										+ oldIway.charAt(j), String.valueOf(id));
					}
				} else {
					jedis.zrem("dbo_car_catalognew:like:iway:" + oldIway,
							String.valueOf(id));
				}

				int Num = 0;
				for (int j = 0; j < newCatalognew.getIway().length(); j++) {
					if (newCatalognew.getIway().substring(j, j + 1)
							.matches("^[a-zA-Z]*")) {
						Num++;
					}
				}
				if (Num == 0) {
					for (int j = 0; j < newCatalognew.getIway().length(); j++) {
						jedis.zrem("dbo_car_catalognew:like:catalogname:"
								+ newCatalognew.getIway().substring(j, j + 1),
								String.valueOf(id));
					}
				} else {
					jedis.zrem("dbo_car_catalognew:like:catalogname:"
							+ newCatalognew.getIway(), String.valueOf(id));
				}
				jedis.zrem("dbo_car_catalognew:list:iway2:" + oldIway,
						String.valueOf(id));
				try {
					String sname = GetPy.getGBKpy(qudao).toUpperCase()
							.substring(0, 1);
					jedis.zadd("dbo_car_catalognew:list:iway2:" + qudao,
							Integer.parseInt(ObjectToMapUtil
									.stringToAscii(sname)), String.valueOf(id));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jedis.zrem(
						"dbo_car_catalognew:list:jibie:"
								+ oldCatalognew.getJibie(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:jibie:" + jibie,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:bsq:" + oldCatalognew.getBsq(),
						String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:bsq:" + bsq,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:leixing:"
								+ oldCatalognew.getLeixing(),
						String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:leixing:" + leixing,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:fadongji:"
								+ oldCatalognew.getFadongji(),
						String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:fadongji:" + fadongji,
						Integer.parseInt(iyear), String.valueOf(id));
				jedis.zrem("dbo_car_catalognew:list:pailiang:all",
						String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:pailiang:all",
						Integer.parseInt(pailiang), String.valueOf(id));
				Map<String, String> mp = ObjectToMapUtil
						.changeToMap(newCatalognew);
				jedis.hmset("dbo_car_catalognew:catalogid:" + id, mp);
				
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateAutohomepropBySaveC(int id,
			DboCarAutohomeprop autohome) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				Map<String, String> mp = ObjectToMapUtil.changeToMap(autohome);
				jedis.hmset("dbo_car_autohomeprop:carid:" + id, mp);
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateAutohomepropByAdd(int id,DboCarAutohomeprop info){
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				Map<String, String> mp = ObjectToMapUtil.changeToMap(info);
				jedis.hmset("dbo_car_autohomeprop:carid:" + id, mp);
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}
	
	public static void UpDateCatalognowByAdd(int id, DboCarCatalognew info) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				Map<String, String> mp = ObjectToMapUtil.changeToMap(info);
				jedis.hmset("dbo_car_catalognew:catalogid:"+id, mp);
				jedis.hmset("dbo_car_autohomeprop:carid:" + id, mp);
				jedis.zadd(
						"dbo_car_catalognew:list:fatherid:"
								+ info.getFatherid(), info.getIyear(),
						String.valueOf(id));
				jedis.zadd(
						"dbo_car_catalognew:list:islive:" + info.getIslive(),
						info.getIyear(), String.valueOf(id));
				jedis.zadd(
						"dbo_car_catalognew:list:onsale:" + info.getOnsale(),
						info.getIyear(), String.valueOf(id));
				jedis.zadd(
						"dbo_car_catalognew:list:onsale1:" + info.getOnsale(),
						0, String.valueOf(id));
				jedis.zadd(
						"dbo_car_catalognew:list:englishname:"
								+ info.getEnglishname(), 0, String.valueOf(id));
				jedis.zadd(
						"dbo_car_catalognew:list:pathlevel:"
								+ info.getPathlevel(), 0, String.valueOf(id));
				if (info.getPathlevel() == 1) {
					jedis.zadd(
							"dbo_car_catalognew:list:lname:" + info.getLname(),
							0, String.valueOf(id));
				} else if (info.getPathlevel() == 2) {
					jedis.zadd(
							"dbo_car_catalognew:list:brand-iway:"
									+ info.getFatherid(), 0, info.getIway());
				} else {
					for (int j = 0; j < info.getCatalogname().length(); j++) {
						jedis.zadd("dbo_car_catalognew:like:catalogname:"
								+ info.getCatalogname().substring(0, j), 0,
								String.valueOf(id));
					}
				}
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowByDelete(int id, DboCarCatalognew info) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.hset("dbo_car_catalognew:catalogid:" + id, "isdelete",
						"1");
				jedis.zrem(
						"dbo_car_catalognew:list:fatherid:"
								+ info.getFatherid(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:islive:" + info.getIslive(),
						String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale:" + info.getOnsale(),
						String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale1:" + info.getOnsale(),
						String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:englishname:"
								+ info.getEnglishname(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:pathlevel:"
								+ info.getPathlevel(), String.valueOf(id));
				if (info.getPathlevel() == 3) {
					jedis.zrem(
							"dbo_car_catalognew:list:islive:"
									+ info.getIslive(), String.valueOf(id));
					for (int j = 0; j < info.getCatalogname().length(); j++) {
						jedis.zrem("dbo_car_catalognew:like:catalogname:"
								+ info.getCatalogname().substring(0, j),
								String.valueOf(id));
					}
					int Num = 0;
					for (int j = 0; j < info.getIway().length(); j++) {
						if (info.getIway().substring(j, j + 1)
								.matches("^[a-zA-Z]*")) {
							Num++;
						}
					}
					if (Num == 0) {
						for (int j = 0; j < info.getIway().length(); j++) {
							jedis.zrem("dbo_car_catalognew:like:catalogname:"
									+ info.getIway().substring(j, j + 1),
									String.valueOf(id));
						}
					} else {
						jedis.zrem("dbo_car_catalognew:like:catalogname:"
								+ info.getIway(), String.valueOf(id));
					}
					jedis.zrem(
							"dbo_car_catalognew:list:iway2:" + info.getIway(),
							String.valueOf(id));
					jedis.zrem(
							"dbo_car_catalognew:list:jibie:" + info.getJibie(),
							String.valueOf(id));
					jedis.zrem("dbo_car_catalognew:list:bsq:" + info.getBsq(),
							String.valueOf(id));
					jedis.zrem(
							"dbo_car_catalognew:list:leixing:"
									+ info.getLeixing(), String.valueOf(id));
					jedis.zrem(
							"dbo_car_catalognew:list:fadongji:"
									+ info.getFadongji(), String.valueOf(id));
					jedis.zrem(
							"dbo_car_catalognew:list:pailiang:"
									+ info.getPailiang(), String.valueOf(id));
				} else if (info.getPathlevel() == 2) {
					jedis.zrem(
							"dbo_car_catalognew:list:iway:" + info.getIway(),
							String.valueOf(id));
					jedis.zrem(
							"dbo_car_catalognew:list:leixing:"
									+ info.getLeixing(), String.valueOf(id));
				} else {
					jedis.zrem(
							"dbo_car_catalognew:list:lname:" + info.getLname(),
							String.valueOf(id));
				}

			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowByEdit(int id, String name) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.hset("dbo_car_catalognew:catalogid:" + id, "catalogname",
						name);
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateAutohomepropByOne(int id,
			DboCarAutohomeprop autohomeprop, DboCarAutohomeprop oldAutohomeprop) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				Map<String, String> mp = ObjectToMapUtil
						.changeToMap(autohomeprop);
				jedis.hmset("dbo_car_autohomeprop:carid:" + id, mp);
				jedis.zrem("dbo_car_autohomeprop:list:p2:all",
						String.valueOf(id));
				String p2 = autohomeprop.getP2();
				int Num = 0;
				if(p2!=null&&p2.length()>0){
					if(p2.indexOf("-")>-1){
						p2="0";
					}
				}else{
					p2="0";
				}
				if (p2.indexOf(".") != -1) {
					if (p2.substring(p2.indexOf(".") + 1, p2.length()).length() == 1) {
						Num = Integer
								.parseInt(p2.substring(0, p2.indexOf(".")))
								* 10000
								+ Integer.parseInt(p2.substring(
										p2.indexOf(".") + 1, p2.length()))
								* 1000;
					} else if (p2.substring(p2.indexOf(".") + 1, p2.length())
							.length() == 2) {

					} else if (p2.substring(p2.indexOf(".") + 1, p2.length())
							.length() == 3) {
						Num = Integer
								.parseInt(p2.substring(0, p2.indexOf(".")))
								* 10000
								+ Integer.parseInt(p2.substring(
										p2.indexOf(".") + 1, p2.length())) * 10;
					} else {
						Num = Integer
								.parseInt(p2.substring(0, p2.indexOf(".")))
								* 10000
								+ Integer.parseInt(p2.substring(
										p2.indexOf(".") + 1, p2.length()));
					}

				} else {
					Num = Integer.parseInt(p2) * 10000;
				}
				jedis.zadd("dbo_car_autohomeprop:list:p2:all", Num,
						String.valueOf(id));
				// String cmd = "dbo_car_catalognew:list:fatherid:" + id;
				//
				// Set<String> set_carid = jedis.zrange(cmd, 0, -1);
				// for (int j = 0; j < set_carid.size(); j++) {
				// jedis.hset("dbo_car_autohomeprop:carid:"+(String)
				// (set_carid.toArray()[j]), "iway",qudao);
				// }
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateAutohomepropBySaveBqudao(int id, String qudao) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				String cmd = "dbo_car_catalognew:list:fatherid:" + id;

				Set<String> set_carid = jedis.zrange(cmd, 0, -1);
				for (int j = 0; j < set_carid.size(); j++) {
					jedis.hset("dbo_car_autohomeprop:carid:"
							+ (String) (set_carid.toArray()[j]), "iway", qudao);
				}
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void saveTousuDetail(DboDntTousuDetail dboDntTousuDetail) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				Map<String, String> map = ObjectToMapUtil.changeToMap(dboDntTousuDetail);
				if(map == null || map.size() == 0)
					return ;
				jedis.hmset("dbo_dnt_tousu_detail_tmp:id:" + dboDntTousuDetail.getId(),map);
				
				Map<String, Double> sortMap = new HashMap<String, Double>();
				double sort = dboDntTousuDetail.getAddtime().getTime()/1000;
				sortMap.put(dboDntTousuDetail.getId()+"", sort);
				jedis.zadd("dbo_dnt_tousu_detail_tmp:list:tousuid:"+dboDntTousuDetail.getTousuid(),sortMap);
				
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowBySaveBqudao(int id, String qudao,
			String lname, DboCarCatalognew oldCatalognew,
			DboCarCatalognew newCatalognew) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				String cmd = "dbo_car_catalognew:list:fatherid:" + id;

				Set<String> set_carid = jedis.zrange(cmd, 0, -1);
				List<Map<String, String>> lstret = new ArrayList<Map<String, String>>();
				for (int j = 0; j < set_carid.size(); j++) {
					jedis.hset("dbo_car_catalognew:catalogid:"
							+ (String) (set_carid.toArray()[j]), "iway", qudao);
					jedis.hset("dbo_car_catalognew:catalogid:"
							+ (String) (set_carid.toArray()[j]), "wayname",
							lname);
					String oldIway = oldCatalognew.getIway();
					for (int g = 0; g < oldIway.length(); g++) {
						jedis.zrem(
								"dbo_car_catalognew:like:iway:"
										+ oldIway.charAt(g),
								(String) (set_carid.toArray()[j]));
					}
					for (int g = 0; g < qudao.length(); g++) {
						jedis.zadd(
								"dbo_car_catalognew:like:iway:"
										+ qudao.charAt(g), 0,
								(String) (set_carid.toArray()[j]));
					}
					jedis.zrem("dbo_car_catalognew:list:iway2:" + oldIway,
							(String) (set_carid.toArray()[j]));
					try {
						String sname = GetPy.getGBKpy(qudao).toUpperCase()
								.substring(0, 1);
						jedis.zadd("dbo_car_catalognew:list:iway2:" + qudao,
								Integer.parseInt(ObjectToMapUtil
										.stringToAscii(sname)),
								(String) (set_carid.toArray()[j]));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static void UpDateCatalognowBySaveB(int id, String live,
			String sale, String eName, String carkey, String leixing,
			String jibie, String pengzhuanglevel, String baoyangfeiyong,
			String photo, String qudao, DboCarCatalognew oldCatalognew,
			DboCarCatalognew newCatalognew) {
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				jedis.zrem(
						"dbo_car_catalognew:list:islive:"
								+ oldCatalognew.getIslive(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:islive:" + live,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale:" + sale,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:onsale1:"
								+ oldCatalognew.getOnsale(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:onsale1:" + sale, 0,
						String.valueOf(id));
				jedis.zrem("dbo_car_catalognew:list:englishname:"
						+ oldCatalognew.getEnglishname(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:englishname:" + eName, 0,
						String.valueOf(id));
				jedis.zrem(
						" dbo_car_catalognew:list:leixing:"
								+ oldCatalognew.getLeixing(),
						String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:leixing:" + leixing,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem(
						"dbo_car_catalognew:list:jibie:"
								+ oldCatalognew.getJibie(), String.valueOf(id));
				jedis.zadd("dbo_car_catalognew:list:jibie:" + jibie,
						oldCatalognew.getIyear(), String.valueOf(id));
				jedis.zrem("dbo_car_catalognew:list:brand-iway:"
						+ oldCatalognew.getFatherid(), oldCatalognew.getIway());
				jedis.zadd("dbo_car_catalognew:list:brand-iway:"
						+ oldCatalognew.getFatherid(), 0, qudao);
				jedis.zrem(
						"dbo_car_catalognew:list:iway:"
								+ oldCatalognew.getIway(), String.valueOf(id));
				try {
					String lname = GetPy
							.getGBKpy(oldCatalognew.getCatalogname())
							.toUpperCase().substring(0, 1);
					jedis.zadd("dbo_car_catalognew:list:iway:" + qudao, Integer
							.parseInt(ObjectToMapUtil.stringToAscii(lname)),
							String.valueOf(id));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Map<String, String> mp = ObjectToMapUtil
						.changeToMap(newCatalognew);
				jedis.hmset("dbo_car_catalognew:catalogid:" + id, mp);
				
			} finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

	public static int cleanCheIndex() {
		Jedis jedis = RedisManager.getJedisObject();
		try {
			jedis = RedisManager.getJedisObject();

			long res = jedis
					.del("CheIndexDAOImpl_queryAllSubdataByParentId_21237_");
			res = jedis.del("CheIndexDAOImpl_queryModelPriceByProID_1_0_");
			res = jedis.del("CheIndexDAOImpl_queryModelPriceByProID_9_0_");
			res = jedis
					.del("CheIndexDAOImpl_queryDealearsByProIDFor4sAVIP_1_0_");
			res = jedis.del("CheIndexDAOImpl_queryAllBrandForIDName_");

		} finally {
			if (jedis != null) {
				RedisManager.recycleJedisOjbect(jedis);
			}
		}
		
		Jedis jedis3 = RedisManager.getJedis3Object();
		try {
			jedis3 = RedisManager.getJedis3Object();

			long res = jedis3
					.del("CheIndexDAOImpl_queryAllSubdataByParentId_21237_");
			res = jedis3.del("CheIndexDAOImpl_queryModelPriceByProID_1_0_");
			res = jedis3.del("CheIndexDAOImpl_queryModelPriceByProID_9_0_");
			res = jedis3
					.del("CheIndexDAOImpl_queryDealearsByProIDFor4sAVIP_1_0_");
			res = jedis3.del("CheIndexDAOImpl_queryAllBrandForIDName_");
		} finally {
			if (jedis3 != null) {
				RedisManager.recycleJedis3Ojbect(jedis3);
			}
		}
		return 1;
	}
	
	public static void deleteTousuDetail(String tousuid){
		for (int i = 0; i < 2; i++) {
			Jedis jedis;
			if (i == 0)
				jedis = RedisManager.getJedisObject();
			else
				jedis = RedisManager.getJedis3Object();
			try {
				 jedis.del("dbo_dnt_tousu_ori:id:"+tousuid);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (i == 0) {
					RedisManager.recycleJedisOjbect(jedis);
				} else {
					RedisManager.recycleJedis3Ojbect(jedis);
				}
			}
		}
	}

}
