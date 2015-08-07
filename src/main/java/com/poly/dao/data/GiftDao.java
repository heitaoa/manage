package com.poly.dao.data;

import java.util.Date;
import java.util.List;

import car_beans.TbDataGift;
import car_beans.TbDataPackage;
import car_daos.BaseDao;
import car_daos.TbDataGiftDao;
import car_daos.TbDataPackageDao;

public class GiftDao extends BaseDao {

	public String addGift(TbDataGift tbDataGift) throws Exception {
		String result = "";
		List<TbDataGift> giftList = TbDataGiftDao.where("gift_name='"+ tbDataGift.getGift_name() +"' AND isdel=0");
		if (giftList.size()==0) {
			tbDataGift.setGift_addtime(new Date());
			result = TbDataGiftDao.save(tbDataGift) + "";
		}else {
			result = "礼品名称已经存在，请重新填写！";
		}
		return result;
	}

	public int addPackage(TbDataPackage tbDataPackage) throws Exception {
		int result = -1;
		
		List<TbDataPackage> list1 = TbDataPackageDao.where("package_name='"+ tbDataPackage.getPackage_name() +"' AND isdel=0");
		if (list1.size()==0) {
			TbDataPackageDao.save(tbDataPackage);
			List<TbDataPackage> list = TbDataPackageDao.where("package_name='"+ tbDataPackage.getPackage_name() +"' AND isdel=0");
			int pack_id = 0;
			if (list.size()>0) {
				TbDataPackage tbDataPackage2 = list.get(0);
				pack_id = tbDataPackage2.getPackage_id();
			}
			
			result = pack_id;
		}else {
			result = 0;
		}
		
		return result;
	}
	
}
