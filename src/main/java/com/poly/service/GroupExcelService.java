package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.bean.GroupExcelEntity;
import com.poly.dao.subDaos.TbApplyInfoSubDao;

public class GroupExcelService {
	public static final GroupExcelService instance = new GroupExcelService();
	public static GroupExcelService getInstance() {
		return instance;
	}
	TbApplyInfoSubDao tbApplyInfoSubDao = new TbApplyInfoSubDao();
	public List<Map<String,Object>> getGroupApply(GroupExcelEntity groupExcelEntity,int prov,int city,String brands){
		String newBrand = AppInfoService.getInstance().getBrands(brands);
		return tbApplyInfoSubDao.getBackExcelInfo(groupExcelEntity,prov,city,newBrand);
	}

}
