package com.poly.action.action_grabData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.TbApplyCount;
import car_beans.TbApplyInfo;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.TbApplyCountDao;

import com.poly.action.MyActionSupport;
import com.poly.bean.BaoMingDataEntity;
import com.poly.service.PhoneAreaService;

public class GrabDataAction extends MyActionSupport {
	// 抓取小胖数据
	public void grabXiaoPang() {
		System.err.println("抓取小胖数据:grabXiaoPang()begin---");
		Long beginTime = System.currentTimeMillis();
		try {
			List<HashMap<String, String>> customerCarList = findCustomerCarInfo();
			importFromOtherDB(customerCarList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		System.err.println("抓取小胖数据:grabXiaoPang()end---");
		Long endtime = System.currentTimeMillis();
		System.out.println("导入小胖数据用时：" + (endtime - beginTime) / 1000 + "秒");
	}
	
	// 抓取新315数据
		public void grabNew315Data() {
			System.err.println("抓取新315数据:grabNew315Data()begin---");
			Long beginTime = System.currentTimeMillis();
			try {
				List<HashMap<String, String>> customerCarList = findCustomerCarInfo();
				importFromNew315(customerCarList);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
			System.err.println("抓取新315数据:grabNew315Data()end---");
			Long endtime = System.currentTimeMillis();
			System.out.println("导入新315数据用时：" + (endtime - beginTime) / 1000 + "秒");
		}
		

	static List<DboAreCatalog> provList = null;
	static List<DboAreCatalog> cityList = null;
	static List<DboCarCatalognew> pingpaiList = null;
	static List<DboCarCatalognew> chexingList = null;
	static List<DboAreCatalog> areaList = null;
	static List<DboCarCatalognew> chexiList = null;
	static TbApplyCountDao tbApplyCountDao = new TbApplyCountDao();
	static {
		DboAreCatalogDao dboAreCatalogDao = new DboAreCatalogDao();
		DboCarCatalognewDao dboCarCatalognewDao = new DboCarCatalognewDao();
		String provSql = "  fatherid = 0";
		provList = dboAreCatalogDao.where(provSql);
		String citySql = " fatherid <> 0";
		cityList = dboAreCatalogDao.where(citySql);
		String pingpaiSql = "  fatherid = 0";
		pingpaiList = dboCarCatalognewDao.where(pingpaiSql);
		String areaSql = " isdelete = 0";
		areaList = dboAreCatalogDao.where(areaSql);
		String chexingSql = "  pathlevel = 3 ";
		chexingList = dboCarCatalognewDao.where(chexingSql);
		String chexiSql = " pathlevel = 2 ";
		chexiList = dboCarCatalognewDao.where(chexiSql);

	}

	// 抓取新315后台数据
	static List<HashMap<String, String>> findNew315Data() {
		TbApplyCountDao tbApplyCountDao = new TbApplyCountDao();
		TbApplyCount tbApplyCount = tbApplyCountDao.where("id = 2").get(0);
		int maxid = tbApplyCount.getMax_315id();
		Connection dbc = getNew315Connection();
		String sql = "SELECT t1.id,t1. NAME,t1.phone,t1.appdate, (select catalogname from dbo_car_catalognew where t1.carid = catalogid ) 'pinpai',( CASE when t1.seriesid is null then (select catalogname from dbo_car_catalognew where t1.modelid	 = catalogid ) else (select catalogname from dbo_car_catalognew where t1.seriesid	 = catalogid ) END) 'chexi' FROM tb_apply_info t1 WHERE LENGTH(t1.phone) = 11 and t1.id >"
				+ maxid + " order by t1.id LIMIT 100";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				String phone = rs.getString("phone") == null ? "" : rs
						.getString("phone");
				String name = rs.getString("name") == null ? "" : rs
						.getString("name");
				if (name.length() > 20)
					name = name.substring(0, 20);
				if (phone.length() > 20)
					phone = phone.substring(0, 20);
				if ("".equals(name))
					name = "315团友";
				String appdate = rs.getString("appdate") == null ? "" : rs
						.getString("appdate");
				if ("".equals(appdate))
					continue;
				String chexi = rs.getString("chexi");
				String pinpai = rs.getString("pinpai");
				map.put("id", rs.getString("id"));
				map.put("chexi", chexi);
				map.put("phone", phone);
				map.put("name", name);
				map.put("pingpai", pinpai);
				map.put("appdate", appdate);
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

	// 抓取小胖看车团数据
	static List<HashMap<String, String>> find() {
		TbApplyCountDao tbApplyCountDao = new TbApplyCountDao();
		TbApplyCount tbApplyCount = tbApplyCountDao.where("id = 1").get(0);
		int maxid = tbApplyCount.getMax_dbid();
		Connection dbc = getXiaoPangConnection();
		String sql = "select t1.sid,t1.ip,t1.area,t1.id,t1.name,t1.phone,t1.appdate,t1.isFootForm 'type' ,t2.mark_name 'pingpai',t3.name 'chexing' from car_apply t1 join car_mark t2 on t1.cid = t2.id join car_model t3 on t1.mid = t3 .id where t1.id > "
				+ maxid + " order by id ASC limit 100";
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement pstmt = dbc.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("appdate", rs.getString("appdate"));
				map.put("type", rs.getString("type"));
				map.put("pingpai", rs.getString("pingpai"));
				map.put("chexing", rs.getString("chexing"));
				map.put("area", rs.getString("area"));
				map.put("ip", rs.getString("ip"));
				map.put("sid", rs.getString("sid"));
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

	// 从王小强的小胖看车团导入数据
	static void importFromOtherDB(List<HashMap<String, String>> customerCarList)
			throws Exception {
		TbApplyCount tbApplyCount = tbApplyCountDao.where("id = 1").get(0);
		List<HashMap<String, String>> list = find();
		System.err.println("获取数据个数(tuan.315che.com):" + list.size());
		if (list.size() > 0) {
			List<BaoMingDataEntity> applyInfos = screeningList(list, customerCarList);
			String maxId = list.get(list.size() - 1).get("id");
			System.err.println("maxId:"+maxId);
			tbApplyCount.setMax_dbid(Integer.parseInt(maxId));
			saveBatch(applyInfos);
		}
		tbApplyCount.setLast_update_time(new Date());
		tbApplyCountDao.update(tbApplyCount);
	}

	// 导入新315的报名数据
	static void importFromNew315(List<HashMap<String, String>> customerCarList) throws Exception {
		TbApplyCount tbApplyCount = tbApplyCountDao.where("id = 2").get(0);
		// String str = sendGet();
		// List<HashMap<String,String>> list = jsonToList(str);
		List<HashMap<String, String>> list = findNew315Data();
		System.err.println("获取数据个数(315che):" + list.size());
		if (list.size() > 0) {
			String maxId = list.get(list.size() - 1).get("id");
			System.err.println(maxId);
			tbApplyCount.setMax_315id(Integer.parseInt(maxId));
			List<BaoMingDataEntity> applyInfos = screeningNew315List(list,customerCarList);
			saveBatch(applyInfos);
		}
		tbApplyCount.setLast_update_time(new Date());
		tbApplyCountDao.update(tbApplyCount);
	}

	// 过滤小胖看车团数据
	static List<BaoMingDataEntity> screeningList(List<HashMap<String, String>> list,
			List<HashMap<String, String>> customerCarList)
			throws ParseException {
		List<BaoMingDataEntity> applyInfos = new ArrayList<BaoMingDataEntity>();
		for (HashMap<String, String> hashMap : list) {
			String name = hashMap.get("name");
			String phone = hashMap.get("phone");
			String appdate = hashMap.get("appdate");
			String type = hashMap.get("type");
			String sid = hashMap.get("sid") == null ? "" : hashMap.get("sid");
			// int isotherciyt = 0;
			int typex = 0;//(看车团)
			int real_type = 4;//tuan.315che.com-PC(百度)
			if ("0".equals(type) || "1".equals(type) || "2".equals(type))
				real_type = 4;
			if ("6".equals(type))
				real_type = 5;
			if ("4".equals(type))
				real_type = 9;
			if ("7".equals(type))
				real_type = 7;// suncars-PC
			if ("8".equals(type) || "11".equals(type))
				real_type = 10;// suncars-手机
			if ("baodian".equals(sid))
				real_type = 14;// 合作媒体测试
			if (sid.contains("test"))
				real_type = 14;// 合作媒体测试
			int fid = Integer.parseInt(type);
			if (10000 < fid && fid < 100000) {
				real_type = 12;// 特卖惠专题报名
			}
			if (100000 < fid && fid < 200000) {
				real_type = 18;// 购车节专题报名
			}
			
			if (1000 < fid && fid < 10000) {
				real_type = 14;// 合作APP
			}

			String pingpai = hashMap.get("pingpai");
			String chexing = hashMap.get("chexing");
			String area = hashMap.get("area");
			int prov = 9;
			int city = 0;
			if (area != null) {
				if (!"".equals(area.trim())) {
					String[] areas = area.split(" ");
					if (areas.length < 2) {
						List<Integer> areax = getAreaId2(area);
						prov = areax.get(0);
						city = areax.get(1);
					} else {
						String provid = areas[0];
						String cityid = areas[1];
						prov = getProvId(provid);
						city = getCityId(cityid);
					}

				} else {
					if (phone.length() > 7) {
						String areas = PhoneAreaService.getInstance()
								.getAreaname(phone.substring(0, 7));
						List<Integer> areax = getAreaId2(areas);
						prov = areax.get(0);
						city = areax.get(1);
					}
				}
			}
			int pingpaiId = getPingpaiId(pingpai);
			int chexingId = getChexingId(chexing, pingpaiId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(appdate);
			int phoneProv = 0;
			int phoneCity = 0;
			if (phone.length() > 7) {
				String areas = PhoneAreaService.getInstance().getAreaname(
						phone.substring(0, 7));
				List<Integer> areax = getAreaIdX(areas);
				phoneProv = areax.get(0);
				phoneCity = areax.get(1);
			}
			boolean cus_flag = isBigCustomer(customerCarList,
					pingpai.toLowerCase(), chexing.toLowerCase());
			if (cus_flag) {
				/*prov = 9;
				city = 0;
				phoneProv = 0;
				phoneCity = 0;*/
				typex = 3;//(大客户)

			}

			BaoMingDataEntity applyInfo = new BaoMingDataEntity();
			applyInfo.setBaoming_date(date);
			applyInfo.setBrand(pingpaiId);
			applyInfo.setSerial(chexingId);
			applyInfo.setName(name);
			applyInfo.setPhone(phone);
			applyInfo.setType(typex);
			applyInfo.setCity(city);
			applyInfo.setProv(prov);
			applyInfo.setCar_info("品牌:" + pingpai + " 车系:" + chexing);
			applyInfo.setIp(hashMap.get("ip"));
			applyInfo.setPhoneProv(phoneProv);
			applyInfo.setPhoneCity(phoneCity);
			applyInfo.setReal_type(real_type);
			applyInfos.add(applyInfo);
		}
		return applyInfos;
	}

	// 过滤新315数据
	static List<BaoMingDataEntity> screeningNew315List(
			List<HashMap<String, String>> list,List<HashMap<String, String>> customerCarList) throws ParseException {
		List<BaoMingDataEntity> applyInfos = new ArrayList<BaoMingDataEntity>();
		for (HashMap<String, String> hashMap : list) {
			String name = hashMap.get("name");
			String phone = hashMap.get("phone");
			String appdate = hashMap.get("appdate");
			String source = hashMap.get("source");
			
			String pingpai = hashMap.get("pingpai");
			String chexing = hashMap.get("chexi");
			int typex = 0;
			boolean cus_flag = isBigCustomer(customerCarList,
					pingpai.toLowerCase(), chexing.toLowerCase());
			if (cus_flag) {
				/*prov = 9;
				city = 0;
				phoneProv = 0;
				phoneCity = 0;*/
				typex = 0;//(大客户)待定

			}
			int provId = 9;
			int cityId = 0;
			int pingpaiId = getPingpaiId(pingpai);
			int chexingId = getChexingId(chexing, pingpaiId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(appdate);
			BaoMingDataEntity applyInfo = new BaoMingDataEntity();
			applyInfo.setBaoming_date(date);
			applyInfo.setBrand(pingpaiId);
			applyInfo.setSerial(chexingId);
			applyInfo.setName(name);
			applyInfo.setPhone(phone);
			applyInfo.setType(typex);
			applyInfo.setCar_info("品牌:" + pingpai + " 车系:" + chexing);
			// applyInfo.setIs_other_city(0);
			int phoneProv = 0;
			int phoneCity = 0;
			if (phone.length() > 7) {
				String areas = PhoneAreaService.getInstance().getAreaname(
						phone.substring(0, 7));
				List<Integer> areax = getAreaIdX(areas);
				phoneProv = areax.get(0);
				phoneCity = areax.get(1);
				provId = areax.get(0);
				cityId = areax.get(1);
			}
			applyInfo.setCity(cityId);
			applyInfo.setProv(provId);
			applyInfo.setPhoneProv(phoneProv);
			applyInfo.setPhoneCity(phoneCity);
			applyInfo.setReal_type(6);//315che报名
			applyInfos.add(applyInfo);

		}
		return applyInfos;
	}

	// 获得省市ID
	static List<Integer> getAreaId(String area, int path) {
		int cityid = 0;
		int provid = 9;
		// System.err.println(area);
		List<Integer> list = new ArrayList<Integer>();
		for (DboAreCatalog dboAreCatalog : areaList) {
			int catalogid = dboAreCatalog.getCatalogid();
			String catalogname = dboAreCatalog.getCatalogname();
			int levelPaht = dboAreCatalog.getPathlevel();
			if (area.equals(catalogname)) {
				if (path == 2) {
					cityid = catalogid;
					provid = dboAreCatalog.getFatherid();
					break;
				}
			}
			if (path == 1) {
				provid = catalogid;
				break;
			}
		}
		list.add(provid);
		list.add(cityid);
		return list;
	}

	// 获得省市ID
	static List<Integer> getAreaId2(String area) {
		int cityid = 0;
		int provid = 9;
		// System.err.println(area);
		List<Integer> list = new ArrayList<Integer>();
		for (DboAreCatalog dboAreCatalog : areaList) {
			int catalogid = dboAreCatalog.getCatalogid();
			String byname = dboAreCatalog.getByname();
			int fatherid = dboAreCatalog.getFatherid();
			if (area.equals(byname)) {
				if (fatherid == 0) {
					provid = catalogid;
					break;
				} else {
					provid = fatherid;
					cityid = catalogid;
					break;
				}
			}

		}
		list.add(provid);
		list.add(cityid);
		return list;
	}

	// 获得省市ID，没有赋值0,0
	static List<Integer> getAreaIdX(String area) {
		int cityid = 0;
		int provid = 0;
		// System.err.println(area);
		List<Integer> list = new ArrayList<Integer>();
		for (DboAreCatalog dboAreCatalog : areaList) {
			int catalogid = dboAreCatalog.getCatalogid();
			String byname = dboAreCatalog.getByname();
			int fatherid = dboAreCatalog.getFatherid();
			if (area.equals(byname)) {
				if (fatherid == 0) {
					provid = catalogid;
					break;
				} else {
					provid = fatherid;
					cityid = catalogid;
					break;
				}
			}

		}
		list.add(provid);
		list.add(cityid);
		return list;
	}

	// 获得省ID
	static int getProvId(String prov) {
		int provId = 9;
		for (DboAreCatalog dboAreCatalog : provList) {
			int provIdX = dboAreCatalog.getCatalogid();
			String byName = dboAreCatalog.getByname();
			if (prov.equals(byName)) {
				provId = provIdX;
				break;
			}
		}
		return provId;
	}

	// 获得城市ID
	static int getCityId(String city) {
		int cityId = 0;
		for (DboAreCatalog dboAreCatalog : cityList) {
			int cityIdX = dboAreCatalog.getCatalogid();
			String byName = dboAreCatalog.getByname();
			if (city.equals(byName)) {
				cityId = cityIdX;
				break;
			}
		}
		return cityId;
	}

	// 获得品牌ID
	static int getPingpaiId(String pingpai) {
		String pingpainew = pingpai.toLowerCase().trim();
		int id = 0;
		for (DboCarCatalognew dboCarCatalognew : pingpaiList) {
			int cid = dboCarCatalognew.getCatalogid();
			String cname = dboCarCatalognew.getCatalogname() == null ? ""
					: dboCarCatalognew.getCatalogname().toLowerCase().trim();
			if (pingpainew.equals(cname)) {
				id = cid;
				break;
			}
			if (cname.contains(pingpainew) || pingpainew.contains(cname)) {
				id = cid;
				break;
			}
		}
		return id;
	}

	// 获得车型ID
	static int getChexingId(String chexing, int brandid) {
		String chexingnew = chexing.toLowerCase();
		int id = 0;
		if (id == 0) {
			for (DboCarCatalognew dboCarCatalognew : chexiList) {
				int fatherid = dboCarCatalognew.getCatalogid();
				String cname = (dboCarCatalognew.getCatalogname() == null ? ""
						: dboCarCatalognew.getCatalogname()).toLowerCase();
				String byname = (dboCarCatalognew.getByname() == null ? ""
						: dboCarCatalognew.getByname()).toLowerCase();
				if (cname.equals((chexingnew)) || byname.equals(chexingnew)) {
					for (DboCarCatalognew dboCarCatalognewx : chexingList) {
						if (dboCarCatalognewx.getFatherid() == fatherid) {
							id = dboCarCatalognewx.getFatherid();
							break;
						}
					}

				}

			}
		}
		if (id == 0) {
			for (DboCarCatalognew dboCarCatalognew : chexiList) {
				int fatherid = dboCarCatalognew.getCatalogid();
				String cname = (dboCarCatalognew.getCatalogname() == null ? ""
						: dboCarCatalognew.getCatalogname()).toLowerCase();
				String byname = (dboCarCatalognew.getByname() == null ? ""
						: dboCarCatalognew.getByname()).toLowerCase();
				if (cname.contains((chexingnew)) || byname.contains(chexingnew)
						|| chexingnew.contains(cname)) {
					for (DboCarCatalognew dboCarCatalognewx : chexingList) {
						if (dboCarCatalognewx.getFatherid() == fatherid) {
							id = dboCarCatalognewx.getFatherid();
							break;
						}
					}

				}
			}
		}
		if (id == 0) {
			for (DboCarCatalognew dboCarCatalognew : chexiList) {
				int fatherid = dboCarCatalognew.getCatalogid();
				String cname = (dboCarCatalognew.getCatalogname() == null ? ""
						: dboCarCatalognew.getCatalogname()).toLowerCase();
				String byname = (dboCarCatalognew.getByname() == null ? ""
						: dboCarCatalognew.getByname()).toLowerCase();
				if (cname.contains((chexingnew)) || byname.contains(chexingnew)) {
					for (DboCarCatalognew dboCarCatalognewx : chexingList) {
						if (dboCarCatalognewx.getFatherid() == fatherid) {
							id = dboCarCatalognewx.getFatherid();
							break;
						}
					}

				}
			}

		}
		if (id == 0) {
			String tempName = "";
			if (chexingnew.length() > 2)
				tempName = chexingnew.substring(0, chexingnew.length() - 1);
			if (!"".equals(tempName)) {
				for (DboCarCatalognew dboCarCatalognew : chexiList) {
					int fatherid = dboCarCatalognew.getCatalogid();
					String cname = (dboCarCatalognew.getCatalogname() == null ? ""
							: dboCarCatalognew.getCatalogname()).toLowerCase();
					String byname = (dboCarCatalognew.getByname() == null ? ""
							: dboCarCatalognew.getByname()).toLowerCase();

					if (cname.equals((tempName)) || byname.equals(tempName)) {
						for (DboCarCatalognew dboCarCatalognewx : chexingList) {
							if (dboCarCatalognewx.getFatherid() == fatherid) {
								id = dboCarCatalognewx.getFatherid();
								break;
							}
						}

					}
				}
			}

		}
		if (id == 0) {
			for (DboCarCatalognew dboCarCatalognew : chexingList) {
				int cid = dboCarCatalognew.getCatalogid();
				String cname = (dboCarCatalognew.getCatalogname() == null ? ""
						: dboCarCatalognew.getCatalogname()).toLowerCase();
				String byname = (dboCarCatalognew.getByname() == null ? ""
						: dboCarCatalognew.getByname()).toLowerCase();
				if (cname.contains((chexingnew)) || byname.contains(chexingnew)) {
					id = dboCarCatalognew.getFatherid();
					break;
				}

			}
		}
		if (id == 0)
			System.err.println(chexing);
		if (id == 0) {
			id = getBrand(brandid);
		}

		return id;
	}

	static int getIdX(String str) {
		return Integer.parseInt(str.substring(4, str.length()));
	}

	static void saveBatch(List<BaoMingDataEntity> applyInfos) throws Exception {
		//INSERT INTO `car_315`.`tb_data_baoming` (`id`, `name`, `phone`, `serial`, `model`, `prov`, `city`, `pro_num`, `is_reach`, `is_trans`, `is_invite`, `baoming_date`) VALUES ('1', 'zhangsan', '18769790430', NULL, NULL, '1', '35', 'CTSH-2015-0034', '0', '0', '1', '2015-05-01 14:03:57');
		String sql = "INSERT INTO `tb_data_baoming` (`name`, `phone`, `type`, `brand`, `serial`, `model`, `prov`, `city`,`baoming_date`, `car_info`, `phone_prov`, `phone_city`, `ip`, `real_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
				pst.setInt(14, applyInfo.getReal_type());
				
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
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	// 根据品牌id 随便返回个车型
	static int getBrand(int id) {
		int result = 0;
		DBConnect dbc = null;
		List<Integer> idList = new ArrayList<Integer>();
		String sql = "SELECT catalogid  from dbo_car_catalognew where isdelete = 0 AND fatherid = "+ id;
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				idList.add(rs.getInt("catalogid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbc != null) {
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (idList.size() > 0)
			result = idList.get(0);
		return result;
	}

	//新315db
	public	static Connection getNew315Connection() {
			String url = "jdbc:mysql://182.254.131.113:3306/car_315?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");// 要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
				DriverManager.setLoginTimeout(10);// 超过10s拿不到链接报错
				con = DriverManager.getConnection(url, "main_select",
						"main_select");
				con.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;

		}
	
	public static Connection getXiaoPangConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://115.159.56.197:3306/tuan_315che?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=round";
		try {
			Class.forName("com.mysql.jdbc.Driver");// 要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
			DriverManager.setLoginTimeout(10);// 超过10s拿不到链接报错
			conn = DriverManager.getConnection(url, "car_apply_select",
					"car_select@315");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
