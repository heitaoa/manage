package com.poly.action.action_grabData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.TbApplyCount;
import car_beans.TbApplyInfo;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.TbApplyCountDao;

import com.poly.action.MyActionSupport;
import com.poly.bean.BaoMingDataEntity;
import com.poly.util.MD5;

public class GrabYiCheDataAction extends MyActionSupport {
	public void grabYicheData() {
		Long beginTime = System.currentTimeMillis();
		System.err.println("抓取易车数据:grabYicheData()begin---");
		try {
			//String tg_id = "863,862,861,860,859,856,855,854,853,852,851,850,849,848,847,846,845,844,843,842,841,879,880,881,882,840,839,838,837,836,835,726,610,864,918,919,832,831,830,829,827,826,825,824,823,820,819,899,900,901,902,903,904,905,906,907,908,909,910,911,913,914,915,916,818,817,816,885,887,888,883,884,886,889,890,891,892,893,894,895,878,877,876,875,874,873,872,871,870,869,868,867,866,865";// 团购id
			//String hd_id = "611,610,608,603,602,600,587,567,434,433,402,400,373,365,309,293,281,266,256,247,239,220,193,192,191,190,189,188,187,186,185,181,52,51";// 活动id
			//String tg_id = "948,949,950,951,952,953,985,986,987,988,989,990,991,992,993,994,995,996,997,998,999,1000,1001,1002,1003,1004,1005,1006,1007,1008";
			String tg_id = findYiCheInfo("tg_id");
			//String tg_id = "863,862,861,860,859,856,855,854,853,852,851,850,849,848,847,846,845,844,843,842,841,879,880,881,882,840,839,838,837,836,835,726,610,864,918,919,832,831,830,829,827,826,825,824,823,820,819,899,900,901,902,903,904,905,906,907,908,909,910,911,913,914,915,916,818,817,816,885,887,888,883,884,886,889,890,891,892,893,894,895,878,877,876,875,874,873,872,871,870,869,868,867,866,865,857,858,925,926,927,928,929,930,937,938,939,940,946,948,949,950,951,952,953,985,986,987,988,989,990,991,992,993,994,995,996,997,998,999,1000,1001,1002,1003,1004,1005,1006,1007,1008";
			//String hd_id = "193,192,191,190,189,188,187,186,185,184";//活动id
			//String hd_id = "611,610,608,603,602,600,587,567,434,433,402,400,373,365,309,293,281,266,256,247,239,220,193,192,191,190,189,188,187,186,185,181,52,51";//活动id
			String hd_id = findYiCheInfo("hd_id");
			
			// 获取大客户品牌
			List<HashMap<String, String>> customerCarList = findCustomerCarInfo();

			System.err.println("团购开始");
			importData(3, tg_id, 2, customerCarList);
			System.err.println("活动开始");
			importData(4, hd_id, 1, customerCarList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("抓取易车数据:grabYicheData()end---");
		Long endtime = System.currentTimeMillis();
		System.out.println("导入易车报名数据用时：" + (endtime - beginTime) / 1000 + "秒");
	}

	static TbApplyCountDao tbApplyCountDao = new TbApplyCountDao();
	static TbApplyCountDao tbApplyCountDaosSubDao = new TbApplyCountDao();
	static List<HashMap<String, String>> cityList = null;
	static List<HashMap<String, String>> chexingList = null;
	static int count = 0;
	static {
		cityList = getCityList();
		chexingList = getChexiList();
	}
	//导入数据
	public static void importData(int id, String hdtype, int typex,
			List<HashMap<String, String>> customerCarList) throws Exception {
		TbApplyCount applyCount = tbApplyCountDao.where("id=" + id).get(0);
		int page_num = applyCount.getMax_dbid();
		int count = 100;
		int size = applyCount.getMax_315id();

		String url = getUrl(page_num, count, size, hdtype, typex);
		String data = getJson(url);
		List<HashMap<String, String>> dataList = JsonToList(data);
		if (dataList.size() > 0) {
			int newPage = 1;
			int newSize = 0;
			List<HashMap<String, String>> dataListNew = null;
			// System.err.println("old:"+dataList.size());
			int nowSize = dataList.size();
			if (size == 0) {
				if (nowSize == count) {
					newPage = page_num + 1;
					newSize = 0;
				} else {
					newPage = page_num;
					newSize = nowSize;
				}
				dataListNew = dataList;
			} else {
				if (nowSize == count) {
					dataListNew = dataList.subList(size, dataList.size());
					newPage = page_num + 1;
					newSize = 0;
				}
				if (nowSize > size && nowSize < count) {
					dataListNew = dataList.subList(size, dataList.size());
					newPage = page_num;
					newSize = nowSize;
				}
				if (nowSize == size) {
					dataListNew = new ArrayList<HashMap<String, String>>();
					newPage = page_num;
					newSize = nowSize;
				}
			}
			System.err.println("new:" + dataListNew.size());
			System.err.println("newSize:" + newSize);
			System.err.println("newPage:" + newPage);
			applyCount.setLast_update_time(new Date());
			applyCount.setMax_315id(newSize);
			applyCount.setMax_dbid(newPage);

			saveToDB(dataListNew, customerCarList);

			tbApplyCountDaosSubDao.update(applyCount);
		}

	}

	static void saveToDB(List<HashMap<String, String>> dataList,
			List<HashMap<String, String>> customerCarList) throws Exception {
		List<BaoMingDataEntity> applyInfos = new ArrayList<BaoMingDataEntity>();
		List<HashMap<String, String>> list = dataList;
		int i = 0;
		int type = 0;// 看车团
		for (HashMap<String, String> map : list) {
			i++;
			String carName = map.get("carName");
			String chexi = map.get("chexi");
			String name = map.get("name");
			String phone = map.get("phone");
			String appdate = map.get("appdate");
			String address = map.get("address");
			if (name.length() > 15)
				name = name.substring(0, 15);
			if (phone.length() > 15)
				phone = phone.substring(0, 15);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = null;
			try {
				date = sdf.parse(appdate);
			} catch (Exception e) {
				System.err.println(appdate);
				continue;
				// System.err.println();
			}
			int pingpaiId = 0;
			int chexingId = 0;
			int city = 0;
			int prov = 0;
			List<Integer> carIds = getCarId(carName, chexi);
			if (carIds.get(1) == 0 || carIds.get(0) == 0) {
				System.err.println("carname" + carName);
				continue;
			}
			pingpaiId = carIds.get(0);
			chexingId = carIds.get(1);

			int flag = 0;
			if (!address.contains("其他")) {
				List<Integer> areaIds = getArea(address);
				if (areaIds.get(0) == 0)
					// System.err.println("address"+address);
					prov = areaIds.get(0);
				city = areaIds.get(1);
				flag = 1;
			}
			int phoneProv = 0;
			int phoneCity = 0;
			if (phone.length() > 7) {
				List<HashMap<String, String>> areas = getPhoneArea(phone
						.substring(0, 7));
				if (areas.size() > 0) {
					phoneProv = Integer.parseInt(areas.get(0).get("provid"));
					phoneCity = Integer.parseInt(areas.get(0).get("cityid"));
					if (address.contains("其他")) {
						prov = Integer.parseInt(areas.get(0).get("provid"));
						city = Integer.parseInt(areas.get(0).get("cityid"));
					}
					if (prov == 0) {
						prov = Integer.parseInt(areas.get(0).get("provid"));
						city = Integer.parseInt(areas.get(0).get("cityid"));
					}
				}
			}

			// 大客户品牌特殊处理，全部归类于上海
			boolean cus_flag = isBigCustomer(customerCarList,
					carName.toLowerCase(), chexi.toLowerCase());
			//待定
			//if (cus_flag)
			//	type = 3;// 大客户

			BaoMingDataEntity applyInfo = new BaoMingDataEntity();
			applyInfo.setBaoming_date(date);
			applyInfo.setBrand(pingpaiId);
			applyInfo.setSerial(chexingId);
			applyInfo.setName(name);
			applyInfo.setPhone(phone);
			applyInfo.setType(13);
			applyInfo.setCity(city);
			applyInfo.setProv(prov);
			applyInfo.setCar_info("品牌:" + carName + " 车系:"
					+ (chexi.equals("-") ? "未知" : chexi));
			applyInfo.setPhoneProv(phoneProv);
			applyInfo.setPhoneCity(phoneCity);
			applyInfos.add(applyInfo);

		}
		System.err.println(applyInfos.size());
		if (applyInfos.size() > 0) {
			saveBatch(applyInfos);
		}
	}

	static void saveBatch(List<BaoMingDataEntity> applyInfos) throws Exception {
		// INSERT INTO `car_315`.`tb_data_baoming` (`id`, `name`, `phone`,
		// `serial`, `model`, `prov`, `city`, `pro_num`, `is_reach`, `is_trans`,
		// `is_invite`, `baoming_date`) VALUES ('1', 'zhangsan', '18769790430',
		// NULL, NULL, '1', '35', 'CTSH-2015-0034', '0', '0', '1', '2015-05-01
		// 14:03:57');
		String sql = "INSERT INTO `tb_data_baoming` (`name`, `phone`, `type`, `brand`, `serial`, `model`, `prov`, `city`,`baoming_date`, `car_info`, `phone_prov`, `phone_city`, `ip`,`real_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,13)";
		Connection con = null;

		try {
			con = DBConnectionManager.getInstance().getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			for (int i = 0; i < applyInfos.size(); i++) {
				BaoMingDataEntity applyInfo = applyInfos.get(i);
				pst.setString(1, applyInfo.getName());
				pst.setString(2, applyInfo.getPhone());
				pst.setInt(3, applyInfo.getType());
				pst.setInt(4, applyInfo.getBrand());
				pst.setInt(5, applyInfo.getSerial());
				pst.setInt(6, 0);
				pst.setInt(7, applyInfo.getProv());
				pst.setInt(8, applyInfo.getCity());
				pst.setTimestamp(9, new Timestamp(applyInfo.getBaoming_date()
						.getTime()));
				pst.setString(10, applyInfo.getCar_info());
				pst.setInt(11, applyInfo.getPhoneProv());
				pst.setInt(12, applyInfo.getPhoneCity());
				pst.setString(13, applyInfo.getIp());
				pst.addBatch();
				if (i % 1000 == 0) {
					pst.executeBatch();
					con.commit();
					pst.clearBatch();
				}
			}
			pst.executeBatch();
			con.commit();
			pst.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				con.close();
			}
		}

	}

	static List<HashMap<String, String>> getPhoneArea(String phone) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		DBConnect dbc = null;
		String sql = "select provid,cityid from tb_dict_phone where phone_num = '"
				+ phone + "'";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("provid", rs.getString("provid"));
				map.put("cityid", rs.getString("cityid"));
				list.add(map);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	static List<Integer> getArea(String area) {
		List<Integer> ids = new ArrayList<Integer>();
		int prov = 0;
		int city = 0;
		for (HashMap<String, String> map : cityList) {
			int catalogid = Integer.parseInt(map.get("catalogid"));
			int fatherid = Integer.parseInt(map.get("fatherid"));
			String catalogname = map.get("catalogname");
			String byname = map.get("byname");
			if (area.equals(catalogname) || area.equals(byname)) {
				if (fatherid == 0) {
					prov = catalogid;
					city = 0;
				} else {
					prov = fatherid;
					city = catalogid;
				}
			}
		}
		ids.add(prov);
		ids.add(city);
		return ids;
	}

	// 生成请求bitauto的url
	public static String getUrl(int page_num, int count, int size,
			String hdType, int typex) {
		if (size % count == 0 && size != 0)
			page_num++;

		String url = "";
		String head = "http://api.hd.bitauto.com/chetuan/?";
		String appid = "appid=6c3e086e0222c";
		String appkey = "appkey=0e1c6c3e086e0222cc642ecd62588a83";
		String type = "type=" + typex;// or 2
		//String source_id = "source_id=" + hdType;
		String pageNum = "page_num=" + page_num;
		String resultCount = "result_count=" + count;
		String token = "";
		token = (appid + appkey + pageNum + resultCount + type + "0e1c6c3e086e0222cc642ecd62588a83")
				.replace("=", "");
		token = MD5.toMD5(token);
		token = "token=" + token;
		url = head + appid + "&" + appkey + "&" + type + "&"
				+ pageNum + "&" + resultCount + "&" + token;
		return url;
	}

	// json转换
	public static List<HashMap<String, String>> JsonToList(String data) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = null;
		JSONArray jsons = JSONArray.fromObject(data);
		for (Object object : jsons) {
			JSONObject jsonNode = JSONObject.fromObject(object);
			String status = jsonNode.get("status").toString();
			String msg = jsonNode.get("msg").toString();
			System.err.println("status:" + status + ",msg:" + msg);
			if ("true".equals(status)) {
				JSONArray datax = JSONArray.fromObject(jsonNode.get("data"));
				for (Object object2 : datax) {
					JSONObject jsonNodex = JSONObject.fromObject(object2);
					Object total_num = jsonNodex.get("total_num");
					System.err.println("数据总量:" + total_num);
					// System.err.println(total_num);
					Object total_page = jsonNodex.get("total_page");
					Object now_page = jsonNodex.get("now_page");
					System.err.println("total_page:" + total_page);
					System.err.println("now_page:" + now_page);
					JSONArray items = JSONArray.fromObject(jsonNodex
							.get("items"));// 没有就是[null]
					if (items.toString().contains("[null]"))
						return list;
					for (Object item : items) {

						JSONObject itemsNode = JSONObject.fromObject(item);
						String activity_id = (String) itemsNode
								.get("activity_id");// 活动/团购id
						String Title = (String) itemsNode.get("title");// 标题
						String name = (String) itemsNode.get("contcat");// 报名人姓名
						String phone = (String) itemsNode.get("mobilephone");// 电话号码
						// String Phone_city =
						// (String)itemsNode.get("phone_city");//号码归属地
						String Ip_city_name = (String) itemsNode
								.get("ip_city_name");// Ip归属地
						String city = (String) itemsNode.get("reg_city_name");// 报名城市
						// String Style_name =
						// (String)itemsNode.get("style_name");//车款（若无，则返回空字符串）
						String Model_name = (String) itemsNode
								.get("model_name");// 车型（若无，则返回空字符串）--车系
						String Make_name = (String) itemsNode.get("make_name");// 车系（若无，则返回空字符串）---品牌
						String Car_type = (String) itemsNode.get("car_type");// 购车方式（若无，则返回空字符串）
						String Store_time = (String) itemsNode
								.get("create_date");// 购车时间
						if ("".equals(Store_time)) {
							System.err.println("xx");
						}
						// System.err.println(Ip_city_name);
						if ("".equals(name.trim()))
							name = "团购网友";
						// city = city.replace("市", "");
						Make_name = checkBrand(Make_name);
						Model_name = checkSerial(Model_name);
						map = new HashMap<String, String>();

						map.put("carName", Make_name);
						map.put("chexi", Model_name);
						map.put("name", name);
						map.put("phone", phone);
						map.put("appdate", Store_time);
						map.put("address", city);
						/*
						 * map.put("activity_id", activity_id); map.put("Title",
						 * Title); map.put("name", name); map.put("phone",
						 * phone); map.put("Phone_city", Phone_city);
						 * map.put("Ip_city_name", Ip_city_name);
						 * map.put("city", city); map.put("Style_name",
						 * Style_name); map.put("Model_name", Model_name);
						 * map.put("Make_name", Make_name); map.put("Car_type",
						 * Car_type); map.put("Store_time", Store_time);
						 */
						list.add(map);
					}

				}
			}
		}
		// System.err.println(i);
		return list;
	}

	// 某些品牌映射处理
	static String checkBrand(String brand){
		String str = brand;
		if(brand.contains("长安轿车"))
			str = "长安汽车";
		if(brand.contains("上海通用别克"))
			str = "通用别克";
		if(brand.contains("奥迪"))
			str = "一汽-大众奥迪";
		if(brand.contains("上海通用雪佛兰"))
			str = "通用雪佛兰";
		if(brand.contains("上海大众斯柯达"))
			str = "斯柯达";
		if(brand.contains("上海通用凯迪拉克"))
			str = "通用凯迪拉克";
		if(brand.contains("东风雪铁龙"))
			str = "东风雪铁龙";
		if(brand.contains("荣威"))
			str = "荣威";
		if(brand.contains("进口奔驰"))
			str = "进口奔驰";
		if(brand.contains("广汽三菱"))
			str = "三菱";
		if(brand.contains("野马"))
			str = "野马";
		if(brand.contains("雷克萨斯"))
			str = "雷克萨斯";
		if(brand.contains("进口宝马"))
			str = "进口宝马";
		if(brand.contains("捷豹"))
			str = "捷豹";
		if(brand.contains("林肯"))
			str = "林肯";
		if(brand.contains("绅宝"))
			str = "北京汽车";
		if(brand.contains("东风悦达起亚"))
			str = "东风悦达起亚";
		return str;
	}
	static String checkSerial(String brand){
		String str = brand;
		if(brand.contains("桑塔纳"))
			str = "桑塔纳";
		
		return str;
	}

	// 获取品牌id 车系id
	static List<Integer> getCarId(String carName, String chexiI) {
		List<Integer> ids = new ArrayList<Integer>();
		int cid = 0;
		int mid = 0;
		if (!"-".equals(chexiI)) {
			for (HashMap<String, String> map : chexingList) {
				String chexi = map.get("chexi");
				String chexiByname = map.get("chexiByname");
				String chexing = map.get("chexing");
				String chexingByname = map.get("chexingByname");
				int catalogid = Integer.parseInt(map.get("catalogid"));
				int fatherid = Integer.parseInt(map.get("fatherid"));
				if (chexi.equals(chexiI) || chexiByname.equals(chexiI)
						|| chexing.equals(chexiI)
						|| chexingByname.equals(chexiI)) {
					cid = fatherid;
					mid = catalogid;
					break;
				}

			}
			if (cid == 0) {
				for (HashMap<String, String> map : chexingList) {
					String chexi = map.get("chexi");
					String chexiByname = map.get("chexiByname");
					String chexing = map.get("chexing");
					String chexingByname = map.get("chexingByname");
					int catalogid = Integer.parseInt(map.get("catalogid"));
					int fatherid = Integer.parseInt(map.get("fatherid"));
					String iway = map.get("iway");
					if (iway.contains(carName)
							&& (chexi.contains(chexiI)
									|| chexiByname.contains(chexiI)
									|| chexing.contains(chexiI) || chexingByname
										.contains(chexiI)||chexi.replace(" ", "").contains(chexiI)||chexing.replace(" ", "").contains(chexiI))) {
						cid = fatherid;
						mid = catalogid;
						break;
					}

				}
			}
		}
		if (cid == 0) {
			for (HashMap<String, String> map : chexingList) {
				int catalogid = Integer.parseInt(map.get("catalogid"));
				String iway = map.get("iway");
				int fatherid = Integer.parseInt(map.get("fatherid"));
				if (carName.equals(iway)) {
					cid = fatherid;
					mid = catalogid;
					break;
				}
			}
		}
		if (cid == 0) {
			for (HashMap<String, String> map : chexingList) {
				int catalogid = Integer.parseInt(map.get("catalogid"));
				String iway = map.get("iway");
				int fatherid = Integer.parseInt(map.get("fatherid"));
				if (iway.contains(carName)) {
					cid = fatherid;
					mid = catalogid;
					break;
				}
			}
		}
		ids.add(cid);
		ids.add(mid);
		return ids;
	}

	// 获取城市列表
	static List<HashMap<String, String>> getCityList() {
		DBConnect dbc = null;
		String sql = "select catalogid,catalogname,fatherid,byname from dbo_are_catalog ";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("catalogid", rs.getString("catalogid"));
				map.put("catalogname", rs.getString("catalogname"));
				map.put("fatherid", rs.getString("fatherid"));
				map.put("byname", rs.getString("byname"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 获取车系列表
	static List<HashMap<String, String>> getChexiList() {
		DBConnect dbc = null;
		String sql = "select t3.catalogname chexi,t3.byname chexiByname,t1.catalogname chexing,t1.byname chexingByname,t1.iway,t3.fatherid,t1.fatherid as catalogid from dbo_car_catalognew t1 LEFT OUTER JOIN dbo_car_catalognew t2 on t1.catalogid = t2.catalogid LEFT OUTER JOIN dbo_car_catalognew t3 on t2.fatherid = t3.catalogid  where t1.pathlevel= 3 and t1.isdelete=0 and t1.iway is not null and t1.iway!='' and t3.fatherid is not NULL;";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("catalogid", rs.getString("catalogid"));
				map.put("iway", rs.getString("iway"));
				map.put("fatherid", rs.getString("fatherid"));
				map.put("chexi", rs.getString("chexi"));
				map.put("chexiByname",
						rs.getString("chexiByname") == null ? "火火火火" : rs
								.getString("chexiByname"));
				map.put("chexing", rs.getString("chexing"));
				map.put("chexingByname",
						rs.getString("chexingByname") == null ? "火火火火" : rs
								.getString("chexingByname"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 查看是否属于大客户品牌
	static boolean isBigCustomer(List<HashMap<String, String>> list,
			String brand, String serial) {
		boolean flag = false;
		brand = brand.toLowerCase();
		serial = serial.toLowerCase();
		Loop1: for (HashMap<String, String> map : list) {
			String brand_ = map.get("brand");
			String serial_ = map.get("serial");
			if ("全部".equals(serial_)) {
				if (brand.contains(brand_)) {
					flag = true;
					break;
				}

			} else {
				String[] serialArray = serial_.split("#");
				for (String serial_x : serialArray) {
					if (serial.contains(serial_x) && !"".equals(serial_x)) {
						flag = true;
						break Loop1;
					}
				}
			}

		}
		return flag;
	}

	// 获取大客户品牌信息
	static List<HashMap<String, String>> findCustomerCarInfo() {
		Connection dbc = DBConnectionManager.getInstance().getConnection();
		String sql = "SELECT brand,serial FROM tb_customers_car WHERE isdelete = 0";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String brand = rs.getString("brand").toLowerCase();
				String serial = rs.getString("serial").toLowerCase();
				map.put("brand", brand);
				map.put("serial", serial);
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 发起请求返回json
	public static String getJson(String urlNameString) {
		String result = "";
		BufferedReader in = null;
		try {
			// String urlNameString
			// ="http://api.test.hd.bitauto.com/baoming/?appid=793ad45b69bc0&appkey=0f1340da76c0305a793ad45b69bc01b0&hd_id=110,21,32&page_num=1&result_count=10&token=55f0d6f007b8878e5a132d88a20390cb";
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！");
			// e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "[" + result + "]";

	}
	// 获取易车id
		static String findYiCheInfo(String id) {
			String ycid = "";
			Connection dbc = DBConnectionManager.getInstance().getConnection();
			String sql = "SELECT yicheid FROM tb_apply_yicheid_config WHERE isdelete = 0";
			if("tg_id".equals(id)){
				sql += " and id = '"+id+"'";
			}
			if("hd_id".equals(id)){
				sql += " and id = '"+id+"'";
			}
//			HashMap<String, String> map = null;
//			List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			try {
				PreparedStatement pstmt = dbc.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					//map = new HashMap<String, String>();
					String yicheid = rs.getString("yicheid");
					
					//map.put("yicheid", yicheid);
					//list.add(map);
					ycid += (yicheid+",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (dbc != null)
						dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return ycid.substring(0, ycid.length()-1);
		}
}
