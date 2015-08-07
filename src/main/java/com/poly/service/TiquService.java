package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.bean.newNews;
import com.poly.dao.data.TiquDataDao;

import car_beans.DboCarCatalognew;
import car_beans.TbDataTiqudata;
import car_daos.DboCarCatalognewDao;

public class TiquService {
	public static final TiquService instance = new TiquService();
	public static TiquService getInstance() {
		return instance;
	}
	
	TiquDataDao tiquDataDao = new TiquDataDao();
	
	public List<Map<String, String>> getCarList(String fatherid) {
		return tiquDataDao.getCarList(fatherid);
	}

	public Map<String, String> getUserinfo(String userid) {
		return tiquDataDao.getUserinfo(userid);
	}

	public List<Map<String, String>> getProvList(int fatherid) {
		return tiquDataDao.getProvList(fatherid);
	}

	public int addTiqu(TbDataTiqudata tbDataTiqudata) throws Exception {
		return tiquDataDao.save(tbDataTiqudata);
	}

	public List<Map<String, String>> getProList(Map<String, String> whereMap) {
		return tiquDataDao.getProList(whereMap);
	}

	public Map<String, String> getDeptMap() {
		return tiquDataDao.getDeptMap();
	}

	public List<Map<String, String>> getProListForDirExamine(Map<String, String> whereMap) {
		return tiquDataDao.getProListForDirExamine(whereMap);
	}

	public int dirExamineYes(String tiqu_num) {
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		tbDataTiqudata.setTiqu_num(tiqu_num);
		tbDataTiqudata.setExamine_state(1);
		return tiquDataDao.update(tbDataTiqudata);
	}

	public List<Map<String, String>> getExamineResult(Map<String, String> whereMap) {
		return tiquDataDao.getExamineResult(whereMap);
	}

	public int dirExamineNo(String tiqu_num, String deny_cause) {
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		tbDataTiqudata.setTiqu_num(tiqu_num);
		tbDataTiqudata.setExamine_state(2);
		tbDataTiqudata.setDeny_cause(deny_cause);
		return tiquDataDao.update(tbDataTiqudata);
	}

	public List<Map<String, String>> getProListForHighExamine() {
		return tiquDataDao.getProListForHighExamine();
	}

	public int hightExamineYes(String tiqu_num, int is_deduct) {
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		tbDataTiqudata.setTiqu_num(tiqu_num);
		tbDataTiqudata.setIs_deduct(is_deduct);
		tbDataTiqudata.setExamine_state(3);
		return tiquDataDao.update(tbDataTiqudata);
	}

	public int hightExamineNo(String tiqu_num, String deny_cause) {
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		tbDataTiqudata.setTiqu_num(tiqu_num);
		tbDataTiqudata.setDeny_cause(deny_cause);
		tbDataTiqudata.setExamine_state(4);
		return tiquDataDao.update(tbDataTiqudata);
	}

	public int perExecute(String tiqu_num, int tiqu_state) {
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		tbDataTiqudata.setTiqu_num(tiqu_num);
		tbDataTiqudata.setTiqu_state(tiqu_state);
		return tiquDataDao.update(tbDataTiqudata);
	}

	public List<Map<String, String>> getProListForDeal() {
		return tiquDataDao.getProListForDeal();
	}

	public List<Map<String, String>> getBaomingListForDeal(String tiqu_num, int needNum) {
		return tiquDataDao.getBaomingListForDeal(tiqu_num, needNum);
	}

	public List<Map<String, String>> getBaomingListAddForDeal(String num, int needNum) {
		return tiquDataDao.getBaomingListAddForDeal(num, needNum);
	}

	public int updateExportCount(String tiqu_num) {
		return tiquDataDao.updateExportCount(tiqu_num);
	}

	public String querenExecute(String tiqu_num) {
		String result = "";
		List<TbDataTiqudata> list = tiquDataDao.where("tiqu_num='" + tiqu_num + "'");
		TbDataTiqudata tbDataTiqudata = list.get(0);
		if (tbDataTiqudata.getExport_count()>0) {
			TbDataTiqudata tbDataTiqudata2 = new TbDataTiqudata();
			tbDataTiqudata2.setTiqu_num(tiqu_num);
			tbDataTiqudata2.setTiqu_state(3);
			tiquDataDao.update(tbDataTiqudata2);
			result = "1";
		}else {
			result = "您还没有提取数据，请先提取数据！";
		}
		return result;
	}

	public int getProListPages(Map<String, String> whereMap) {
		return tiquDataDao.getProListPages(whereMap);
	}

	public List<Map<String, String>> getBaomingListForExport(String baoming_ids) {
		return tiquDataDao.getBaomingListForExport(baoming_ids);
	}

	
	
	
}
