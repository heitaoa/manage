package com.poly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_beans.TbDataBaoming;
import car_daos.TbDataBaomingDao;

import com.poly.dao.subDaos.Publish4sSubDao;

public class Publish4SService {
	private static final Publish4SService instance = new Publish4SService();

	public static Publish4SService getInstance() {
		return instance;
	}

	Publish4sSubDao publish4sSubDao = new Publish4sSubDao();

	/**
	 * 获取VIP经销商列表
	 * 
	 * @return
	 */
	public List<HashMap<String, String>> getVipDealers() {
		return publish4sSubDao.getVipDealers();
	}

	/**
	 * 匹配到对应的经销商报名
	 * 
	 * @param data
	 */
	public Map<String, Object> findRightVip(HashMap<String, String> data) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			if (data == null || data.size() == 0) {
				result.put("status", 0);// 0 -推送数据有误
				return result;
			}

			List<HashMap<String, String>> vipList = getVipDealers();
			List<HashMap<String, String>> vipBaomingList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = null;
			List<String> enameList = new ArrayList<String>();
			for (HashMap<String, String> vip : vipList) {
				String eid = vip.get("eid");
				String brands[] = vip.get("mainbrand").split(",");
				String areaId = vip.get("catalogid");
				String iway = vip.get("iway").trim();
				String ename = vip.get("ename");
				// 经销商渠道为空 通过品牌车系去推送报名
				if ("".equals(iway)) {
					String id = data.get("id");
					String brandid = data.get("brandId");
					String serialid = data.get("chexiId");
					String catalogid = "9";
					String prov = data.get("prov");
					String city = data.get("city");
					String name = data.get("name");
					String phone = data.get("phone");
					// String orderdate = data.get("appdate");
					if ("0".equals(city) || "10".equals(prov))
						catalogid = city;
					else
						catalogid = prov;
					if (checkBrand(brands, brandid) && areaId.equals(catalogid)) {
						map = new HashMap<String, String>();
						map.put("eid", eid);
						map.put("carid", serialid);
						// map.put("orderdate", orderdate);
						map.put("phone", phone);
						map.put("customername", name);
						map.put("areaid", catalogid);
						vipBaomingList.add(map);
						enameList.add(ename);
					}
				}
				// 经销商渠道不为空 通过经销商渠道去推送报名
				else {
					String iways[] = iway.split(",");
					String id = data.get("id");
					String brandid = data.get("brandId");
					String serialid = data.get("chexiId");
					String catalogid = "9";
					String prov = data.get("prov");
					String city = data.get("city");
					String name = data.get("name");
					String phone = data.get("phone");
					// String orderdate = data.get("appdate");
					String wayName = data.get("iway");
					if ("10".equals(prov))
						catalogid = city;
					else
						catalogid = prov;
					if ("".equals(wayName) || "无".equals(wayName)) {
						if (checkBrand(brands, brandid)
								&& areaId.equals(catalogid)) {
							map = new HashMap<String, String>();
							map.put("eid", eid);
							map.put("carid", serialid);
							// map.put("orderdate", orderdate);
							map.put("phone", phone);
							map.put("customername", name);
							map.put("areaid", catalogid);
							vipBaomingList.add(map);
							enameList.add(ename);
						}
					} else {
						if (checkIway(iways, wayName)
								&& areaId.equals(catalogid)) {
							map = new HashMap<String, String>();
							map.put("eid", eid);
							map.put("carid", serialid);
							// map.put("orderdate", orderdate);
							map.put("phone", phone);
							map.put("customername", name);
							map.put("areaid", catalogid);
							vipBaomingList.add(map);
							enameList.add(ename);
						}
					}

				}
			}
			if (vipBaomingList.size() > 0) {
				
				TbDataBaoming tb = new TbDataBaoming();
				tb.setId(Integer.parseInt(data.get("id")));
				tb.setTuisong_flag(1);
				TbDataBaomingDao.update(tb);
				
				publish4sSubDao.saveVip(vipBaomingList);
				result.put("status", 2);// 2 -推送成功
				result.put("enameList", enameList);// 推送成功的经销商列表
				return result;
			} else {
				result.put("status", 1);// 1 -未找到匹配的经销商
				return result;
			}
		} catch (Exception e) {
			result.put("status", 0);// 0 -推送数据有误
			return result;
		}
	}

	boolean checkBrand(String brands[], String brand) {
		boolean flag = false;
		for (String name : brands) {
			if (name.equals(brand)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	boolean checkIway(String iways[], String iway) {
		boolean flag = false;
		for (String name : iways) {
			if (name.equals(iway)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
