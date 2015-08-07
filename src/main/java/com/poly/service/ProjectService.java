package com.poly.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.poly.bean.newNews;
import com.poly.dao.data.ActDetailDao;
import com.poly.dao.data.BaomingDao;
import com.poly.dao.data.CountDao;
import com.poly.dao.data.GiftDao;
import com.poly.dao.data.GivingDao;
import com.poly.dao.data.PresentApplyDao;
import com.poly.dao.data.ProCodeSeqDao;
import com.poly.dao.data.ProjectBLAction;
import com.poly.dao.data.ProjectDao;
import com.poly.dao.data.PromoMethodDao;
import com.poly.dao.data.QiandaoDao;
import com.poly.dao.data.VisitRecordDao;

import car_beans.TbDataActDetail;
import car_beans.TbDataBaoming;
import car_beans.TbDataGift;
import car_beans.TbDataPackage;
import car_beans.TbDataPresentApply;
import car_beans.TbDataProject;
import car_beans.TbDataProjectBl;
import car_beans.TbDataPromoMethod;
import car_beans.TbDataQiandao;
import car_beans.TbDataVisitRecord;
import car_daos.TbDataGiftDao;
import car_daos.DBConnect;
import car_daos.TbDataPackageDao;
import car_daos.TbDataPresentApplyDao;
import car_daos.TbDataProjectBlDao;
import car_daos.TbDataProjectDao;
import car_daos.TbDataPromoMethodDao;
import car_daos.TbDataVisitRecordDao;

public class ProjectService {
	
	public static final ProjectService instance = new ProjectService();
	public static ProjectService getInstance() {
		return instance;
	}
	
	ProjectDao projectDao = new ProjectDao();
	TbDataProjectBlDao blDao = new TbDataProjectBlDao();
	
	ProCodeSeqDao proCodeSeqDao = new ProCodeSeqDao();
	
	PromoMethodDao promoMethodDao = new PromoMethodDao();
	
	ActDetailDao actDetailDao = new ActDetailDao();
	
	BaomingDao baomingDao = new BaomingDao();
	
	CountDao countDao = new CountDao();
	
	GivingDao givingDao = new GivingDao();
	
	QiandaoDao qiandaoDao = new QiandaoDao();
	TbDataVisitRecordDao visitRecordDao = new TbDataVisitRecordDao();
	PresentApplyDao presentApplyDao = new PresentApplyDao();
	
	GiftDao giftDao = new GiftDao();
	
	public String getCodeByOrg(int projectType, int ini_org){
		String[] projectTypeName = {"CT","ZX","CZ","CS","JX","QT","DS"};
		String[] orgShortName = {"ZB","SH","XZ","BJ","SY","SZ","GZ","HF","DL","WH","CD","HZ","NJ","CS","JN","QD","FS","AQ","ZZ","FZ","NB"};
		
		String year = new SimpleDateFormat("yyyy").format(new Date());
		String head = projectTypeName[projectType] + orgShortName[ini_org] + "-" + year;
		return proCodeSeqDao.getProNum(head);
	}

	public List<Map<String,String>> finProjectsById(String id) {
		List<Map<String,String>> result = projectDao.findProductInfoById(id);
		
		return result;
	}

	public Map<String, String> findOrgAndDepById(String id) {
		
		return projectDao.findOrgAndDepById(id);
	}

	public List<Map<String, String>> findUsersByCode(String orgCode,String deptCode,String userCode) {
		
		return projectDao.findUsersByCode(orgCode,deptCode,userCode);
	}

	public String updateOrInsert(TbDataProject project) {
		String pro_num = project.getPro_num();
		int size = projectDao.whereCount("pro_num='"+pro_num+"'");
		if(size>0){
			projectDao.update(project);
		}else{
			try {
				projectDao.save(project);
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
		}
		return "1";
	}

	public Map<String,String> getProjectInfoByProNum(String pro_num) {
		Map<String,String> info = projectDao.findProjectInfoByProNum(pro_num);
//		List<TbDataPromoMethod> promoMethods = promoMethodDao.where("pro_num='"+pro_num+"'");
//		info.put("promoMethods", promoMethods);
		
		
		return info;
	}
	public Map getBlProjectInfoByProNum(String pro_num) {
		Map info = projectDao.findBlProjectInfoByProNum(pro_num);
//		List<TbDataPromoMethod> promoMethods = promoMethodDao.where("pro_num='"+pro_num+"'");
//		info.put("promoMethods", promoMethods);
		
		
		return info;
	}

	public String deleteProjectByProNum(String pro_num) {
		int back = projectDao.deleteProject(pro_num);
		
		return back+"";
	}
	public String deleteBlProjectByProNum(String pro_num) {
		int back = new ProjectBLAction().deleteProject(pro_num);
		
		return back+"";
	}
	public List<Map<String, String>> getProjectsForPromoDirector(Map<String, String> whereMap) {
		return projectDao.getProjectsForPromoDirector(whereMap);
	}
	public List<Map<String, String>> getProjectsForSerDirector(Map<String, String> whereMap) {
		return projectDao.getProjectsForSerDirector(whereMap);
	}

	public int promoDirectorExamineYes(String promo_man, String pro_num) {
		
		TbDataProject tbDataProject = new TbDataProject();
		tbDataProject.setPro_num(pro_num);
		tbDataProject.setPromo_man(promo_man);
		tbDataProject.setPro_state(3);
		
		return TbDataProjectDao.update(tbDataProject);
		
	}

	public int promoDirectorExamineNo(String pro_num) {
		TbDataProject tbDataProject = new TbDataProject();
		tbDataProject.setPro_num(pro_num);
		tbDataProject.setPro_state(4);
		
		return TbDataProjectDao.update(tbDataProject);
	}
	public Map<String, String> getDeptMap(Map<String, String> map) {
		return projectDao.getDeptMap(map);
	}

	public Map<String, String> getInimanMap(Map<String, String> map) {
		return projectDao.getInimanMap(map);
	}

	public Map<String, String> getBrandMap(Map<String, String> map) {
		return projectDao.getBrandMap(map);
	}

	public List<String> getAreaList(Map<String, String> map) {
		return projectDao.getAreaList(map);
	}

	public Map<String, String> getPromoPerMap(String userid) {
		return projectDao.getPromoPerMap(userid);
	}

	public List<Map<String, String>> getProjectsForPromoPer(Map<String, String> map) {
		
		return projectDao.getProjectsForPromoPer(map);
	}

	public List<Map<String, String>> getProjectsByPronumForPer(String pro_num) {
		
		return projectDao.getProjectsByPronumForPer(pro_num);
	}

	public int updatePromoForPer(Map<String, String> map) {
		
		return PromoMethodDao.updatePromoForPer(map);
	}

	public List<TbDataPromoMethod> getPromoListByPronum(String pro_num) {
		
		String subsql = "pro_num = '"+ pro_num +"'";
		
		return PromoMethodDao.where(subsql);
	}

	public int deletePromoFunctionById(String promo_id) {
		String subsql = "promo_id = " + promo_id;
		return TbDataPromoMethodDao.delete(subsql);
	}

	public String examineProjectForService(String pro_num, String state) {
		TbDataProject project = new TbDataProject();
		project.setPro_num(pro_num);
		if("pass".equals(state)){
			project.setPro_state(1);
		}else if("reject".equals(state)){
			project.setPro_state(2);
		}
		return projectDao.update(project)+"";
	}
	public String examineBlProjectForService(String pro_num, String state) {
		TbDataProjectBl project = new TbDataProjectBl();
		project.setPro_num(pro_num);
		if("pass".equals(state)){
			project.setPro_state(1);
		}else if("reject".equals(state)){
			project.setPro_state(2);
		}
		return blDao.update(project)+"";
	}

	public TbDataActDetail findActDetailByProNum(String pro_num) {
		TbDataActDetail tbDataActDetal = new TbDataActDetail();
		tbDataActDetal.setPro_num(pro_num);
		List<TbDataActDetail> list = actDetailDao.where("pro_num='"+pro_num+"'");
		if(list.size()>0){
			tbDataActDetal = list.get(0);
		}
		return tbDataActDetal;
	}

	public int getKctBaomingTotalPage(int pagesize,TbDataProject project) {
		return baomingDao.getKctBaomingTotalPage(pagesize,project);
	}

	public List<Map<String,String>> findKctBaomingListByPage(int page, int pagesize,TbDataProject project) {
		return baomingDao.findKctBaomingListByPage(page,pagesize,project);
	}

	public Map<String, String> getActDetailInfoByProNum(String pro_num) {
		
		return actDetailDao.getActDetailInfoByProNum(pro_num);
	}

	public List<Map<String, String>> findKctModelsByProNum(String pro_num) {

		return projectDao.findKctModelsByProNum(pro_num);
	}

	public List<Map<String, String>> getGivings() {
		
		return projectDao.getGivings();
	}

	public TbDataProject getProjectByProNum(String pro_num) {
		
		return projectDao.where("pro_num='"+pro_num+"'").get(0);
	}

	public List<Map<String, String>> JsonToBaomingInfoList(String data) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		JSONArray jsons = JSONArray.fromObject(data);
		for (Object object : jsons) {
			JSONObject jsonNode = JSONObject.fromObject(object);
			String qiandao_id= jsonNode.get("qiandao_id").toString();
			String name= jsonNode.get("name").toString();
			String phone= jsonNode.get("phone").toString();
			String is_reach = jsonNode.get("is_reach").toString();
			String is_trans= jsonNode.get("is_trans").toString();
			String is_invite= jsonNode.get("is_invite").toString();
			String model= jsonNode.get("model").toString();
			String sale_man= jsonNode.get("sale_man").toString();
			String addr= jsonNode.get("addr").toString();
			String giving_name= jsonNode.get("giving_name").toString();
			String giving_code= jsonNode.get("giving_code").toString();
			String pro_num= jsonNode.get("pro_num").toString();
			String trans_date= jsonNode.get("trans_date").toString();
			Map<String,String> map = new HashMap<String,String>();
			map.put("qiandao_id", qiandao_id);
			map.put("name", name);
			map.put("phone", phone);
			map.put("is_reach", is_reach);
			map.put("is_trans", is_trans);
			map.put("is_invite", is_invite);
			map.put("model", model);
			map.put("sale_man", sale_man);
			map.put("addr", addr);
			map.put("giving_name", giving_name);
			map.put("giving_code", giving_code);
			map.put("pro_num", pro_num);
			map.put("trans_date", trans_date);
			list.add(map);
		}
		return list;
	}

	public String saveBaomingInfo(List<Map<String, String>> list) {
		for(Map<String,String> map:list){
			String baoming_id = map.get("baoming_id");
			try{
				if(StringUtils.isEmpty(baoming_id)){	
					baomingDao.saveNotInvite(map);
				}else{
					
					baomingDao.saveInvite(map);
					
				}
			}catch(Exception e){
				e.printStackTrace();
				return "-1";
			}
			
			
		}
		return "1";
	}

	public String insertOrUpdateActDetail(TbDataActDetail detail) {
		
		return actDetailDao.insertOrUpdateActDetail(detail);
	}
	
	public Map<String, String> getBrandMapForCount() {
		return countDao.getBrandMapForCount();
	}

	public Map<String, String> getOrgMapForCount() {
		return countDao.getOrgMapForCount();
	}

	public Map<String, String> getExecutorMapForCount() {
		return countDao.getExecutorMapForCount();
	}

	public List<Map<String, String>> getListForActiveCost(Map<String, String> requireMap) {
		return countDao.getListForActiveCost(requireMap);
	}

	public List<Map<String, String>> getListForActiveData(Map<String, String> map) {
		return countDao.getListForActiveData(map);
	}

	public List<Map<String, String>> getSignTable(String pro_num) {
		return countDao.getSignTable(pro_num);
	}

	public Map<String, String> getTransAreaMap() {
		return countDao.getTransAreaMap();
	}

	public List<Map<String, String>> getTransList(Map<String, String> mapWhere) {
		return countDao.getTransList(mapWhere);
	}

	public List<Map<String, String>> getNotsaleList(Map<String, String> mapWhere) {
		return countDao.getNotsaleList(mapWhere);
	}

	public Map<String, String> getProvMap() {
		return presentApplyDao.getProvMap();
	}

	public String getCityStrByProv(String prov) {
		return presentApplyDao.getCityStrByProv(prov);
	}

	public List<Map<String, String>> getApplyList(Map<String, String> mapWhere) {
		return presentApplyDao.getApplyList(mapWhere);
	}

	public int updateCarMsg(Map<String, String> map) {
		return presentApplyDao.updateCarMsg(map);
	}

	public int updateRemark(Map<String, String> map) {
		return presentApplyDao.updateRemark(map);
	}
	public Map<String, Map<String, String>> getGiftDataByProNum(String pro_num) {
		
		return givingDao.getGiftsByProNum(pro_num);
	}
	public int updateState(Map<String, String> map) {
		return presentApplyDao.updateState(map);
	}

	public int getProjectsPagesForPromoDirector(Map<String, String> map) {
		return projectDao.getProjectsPagesForPromoDirector(map);
	}
	public int getProjectsPagesForSerDirector(Map<String, String> map) {
		return projectDao.getProjectsPagesForSerDirector(map);
	}

	public String checkCarMsg(Map<String, String> map) {
		return presentApplyDao.checkCarMsg(map);
	}

	public List<Map<String, String>> getPresentByPhone(String apply_id) {
		return presentApplyDao.getPresentByPhone(apply_id);
	}

	public int setPresentForApply(Map<String, String> map) {
		return presentApplyDao.setPresentForApply(map);
	}

	public List<Map<String, String>> findKctQiandaoListByPage(int page,
			int pagesize, String pro_num) {
		
		return qiandaoDao.findKctQiandaoListByPage( page,
				 pagesize,  pro_num);
	}
	public List<Map<String, String>> findKctQiandaoListForViewByPage(int page,
			int pagesize, String pro_num) {
		
		return qiandaoDao.findKctQiandaoListForViewByPage( page,
				pagesize,  pro_num);
	}

	public String saveQiandaoInfo(List<Map<String, String>> list) {
		for(Map<String,String> map:list){
			String qiandao_id = map.get("qiandao_id");
			try{
				if(StringUtils.isEmpty(qiandao_id)){	
					qiandaoDao.saveNotInvite(map);
				}else{
					
					qiandaoDao.saveInvite(map);
					
				}
			}catch(Exception e){
				e.printStackTrace();
				return "-1";
			}
			
			
		}
		return "1";
	}

	public int getKctQiandaoTotalPage(int pagesize, String pro_num) {
		
		return qiandaoDao.getKctQiandaoTotalPage(pagesize,pro_num);
	}

	public List<Map<String, String>> getExamineList(String service_type,
			String pro_num, String start, String end, String examine_state,
			String send_state, String iway, String model,int page,int pageSize,String name,String phone){
		
		return projectDao.getExamineList(service_type,pro_num,start,end,examine_state,send_state,iway,model,page,pageSize,name,phone);
	}

	public List<Map<String, String>> getModelsByIway(String iway) {
		
		return projectDao.getModelsByIway(iway);
	}
	public List<Map<String, String>> getIways() {
		
		return projectDao.getIways();
	}

	public List<Map<String, String>> getProNumsByType(String service_type) {
		
		return projectDao.getProNumsByType(service_type);
	}

	public String examineGift(String trans_id, String examine_state) {
		
		return projectDao.examineGift( trans_id,  examine_state);
	}

	public int getExamineListPages(String service_type, String pro_num,
			String start, String end, String examine_state, String send_state,
			String iway, String model, int page, int pageSize,String name,String phone) {
		
		return projectDao.getExamineListPages(service_type,pro_num,start,end,examine_state,send_state,iway,model,page,pageSize,name,phone);
	}
	

	public int getPagesForApplyList(Map<String, String> mapWhere) {
		return presentApplyDao.getPagesForApplyList(mapWhere);
	}

	public Map<String, Integer> getProjectStateNum() {
		return projectDao.getProjectStateNum();
	}

	public int getProjectFinishNum() {
		return projectDao.getProjectFinishNum();
	}

	public int getCountForPromoPerNew(Map<String, String> map) {
		return projectDao.getCountForPromoPerNew(map);
	}

	public int getCountForPromoPerOld(Map<String, String> map) {
		return projectDao.getCountForPromoPerOld(map);
	}

	public int getCountForPromoPerFinish(Map<String, String> map) {
		return projectDao.getCountForPromoPerFinish(map);
	}

	public int getProjectsPagesForPromoPer(Map<String, String> map) {
		return projectDao.getProjectsPagesForPromoPer(map);
	}

	public List<Map<String, String>> findProjectsByUseridAndState(String id,
			int state) {
		
		return projectDao.findProductInfoByUseridAndState(id, state);
	}
	public List<Map<String, String>> findProjectsBlByUseridAndState(String id,
			int state) {
		
		return projectDao.findProductBlInfoByUseridAndState(id, state);
	}

	public List<Map<String, String>> getOrgList() {
		
		return projectDao.getOrgList();
	}
	
	public Map<String, String> getUserCityId(String userid) {
		return presentApplyDao.getUserCityId(userid);
	}

	public int updatePostBill(Map<String, String> map) {
		return presentApplyDao.updatePostBill(map);
	}

	public List<Map<String, String>> getProjectListBlListForPromoDir(Map<String, String> map) {
		return projectDao.getProjectListBlListForPromoDir(map);
	}

	public Map getBlProjectInfoForDir(String pro_num) {
		return projectDao.getBlProjectInfoForDir(pro_num);
	}

	public int examineYesForBl(String pro_num) {
		return projectDao.examineYesForBl(pro_num);
	}

	public int examineNoForBl(String pro_num) {
		TbDataProjectBl tbDataProjectBl = new TbDataProjectBl();
		tbDataProjectBl.setPro_num(pro_num);
		tbDataProjectBl.setPro_state(4);
		return TbDataProjectBlDao.update(tbDataProjectBl);
	}

	public int delProjectBl(String pro_num) {
		return TbDataProjectBlDao.delete("pro_num='"+ pro_num +"'");
	}

	public String updateOrInsert(TbDataProjectBl bl) {
		String pro_num = bl.getPro_num();
		int size = blDao.whereCount("pro_num='"+pro_num+"'");
		if(size>0){
			blDao.update(bl);
		}else{
			try {
				blDao.save(bl);
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
		}
		return "1";
	}

	public boolean isExistsBl(String pro_num) {
		int size = blDao.whereCount("pro_num='"+pro_num+"'");
		if(size>0){
			return true;
		}
		return false;
	}

	public String saveBl(TbDataProjectBl bl) {
		try {
			blDao.save(bl);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}
	
	public Map<String, String> getProjectInfoForPromoByProNum(String pro_num) {
		return projectDao.getProjectInfoForPromoByProNum(pro_num);
	}
	public void saveVisitRecord(TbDataVisitRecord record){
		try {
			String pro_num = record.getPro_num();
			int phoneerror = record.getPhoneerror();
			Map<String,String> info = this.getProjectInfoByProNum(pro_num);
			String type = info.get("service_type");
			if(phoneerror==1||"100".equals(type)){
				return;
			}
			int baoming_id = record.getBaoming_id();
			List<TbDataVisitRecord> list = visitRecordDao.where("pro_num='"+pro_num+"' and baoming_id="+baoming_id);
			if(list.size()>0){
				record.setRecord_id(list.get(0).getRecord_id());
				visitRecordDao.update(record);
			}else{
				visitRecordDao.save(record);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public List<Map<String, String>> getProjectForServiceExamine(String userid,Map<String, String> orgAndDep) {
		return projectDao.getProjectForServiceExamine(userid,orgAndDep);
	}

	public String endProject(String pro_num) {
		TbDataProject project = new TbDataProject();
		project.setPro_num(pro_num);
		project.setPro_state(5);
		return projectDao.update(project)+"";
	}

	public List<Map<String, String>> getQiandaoListByProNum(String pro_num) {
		
		return qiandaoDao.getQiandaoListByProNum(pro_num);
	}

	public Map<String, Integer> getDataByProNum(String pro_num) {
		// TODO Auto-generated method stub
		return projectDao.getDataByProNum(pro_num);
	}
	
	public Map<String, String> getQiandaoInfoByRecordId(int record_id) {
		// TODO Auto-generated method stub
		return qiandaoDao.getQiandaoInfoByRecordId(record_id);
	}

	public int updateVisitRecord(TbDataVisitRecord td) {
		
		return new TbDataVisitRecordDao().update(td);
		
	}

	public List<Map<String, String>> getQiandaoListForDownLoad(String pro_num) {
		
		return qiandaoDao.getQiandaoListForDownLoad(pro_num);
	}

	public int updateIdCord(Map<String, String> map) {
		TbDataPresentApply tbDataPresentApply = new TbDataPresentApply();
		tbDataPresentApply.setId(Integer.parseInt(map.get("apply_id")));
		tbDataPresentApply.setOwner_idcode(map.get("owner_idcode"));
		return TbDataPresentApplyDao.update(tbDataPresentApply);
	}
	public List<Map<String, String>> getQtProjects(String orgCode) {
		// TODO Auto-generated method stub
		return projectDao.getQtProjects(orgCode);
	}
	
	public int getTransListPages(Map<String, String> mapWhere) {
		return countDao.getTransListPages(mapWhere);
	}
	public int getBrandIdByIway(String iway){
		return projectDao.getBrandIdByIway(iway);
	}
	public List<TbDataGift> getGiftList() {
		return TbDataGiftDao.where("isdel=0");
	}

	public String addGift(TbDataGift tbDataGift) throws Exception {
		return giftDao.addGift(tbDataGift);
	}

	public int delGift(int gift_id) {
		TbDataGift tbDataGift = new TbDataGift();
		tbDataGift.setGift_id(gift_id);
		tbDataGift.setIsdel(1);
		return TbDataGiftDao.update(tbDataGift);
	}

	public static List<TbDataPackage> getPackageList() {
		return TbDataPackageDao.where("isdel=0");
	}

	public int addPackage(TbDataPackage tbDataPackage) throws Exception {
		return giftDao.addPackage(tbDataPackage);
	}

	public int delPackage(int package_id) {
		TbDataPackage tbDataPackage = new TbDataPackage();
		tbDataPackage.setIsdel(1);
		tbDataPackage.setPackage_id(package_id);
		return TbDataPackageDao.update(tbDataPackage);
	}

	public int presentDel(String apply_id) {
		TbDataPresentApply tbDataPresentApply = new TbDataPresentApply();
		tbDataPresentApply.setId(Integer.valueOf(apply_id));
		tbDataPresentApply.setIs_del(1);
		
		return TbDataPresentApplyDao.update(tbDataPresentApply);
	}
	
	public int getApplyListPages(Map<String, String> mapWhere) {
		return countDao.getApplyListPages(mapWhere);
	}
	public int getbrandCountByCitys(Map<String,String> mapWhere,String iway) {
		return countDao.getbrandCountByCitys(mapWhere,iway);
	}
	public int getbrandwCountByCitys(Map<String, String> mapWhere,String iway) {
		return countDao.getbrandwCountByCitys(mapWhere,iway);
	}
	public int getbrandyxCountByCitys(Map<String, String> mapWhere,String iway) {
		return countDao.getbrandyxCountByCitys(mapWhere,iway);
	}
	public List<Map<String, String>> getApplyList2(Map<String, String> mapWhere) {
		return countDao.getApplyList(mapWhere);
	}
	public int selectCounts(Map<String, String> mapWhere,String str) {
		return countDao.selectCounts(mapWhere,str);
	}

	public Set<String> getIwaysSelect(String org_code) {
		Set<String> iways_select = projectDao.getIways_select_Qt(org_code);
		return iways_select;
	}

	public List<Map<String, String>> getCountBaomingChannelList(String start,
			String end) {
		List<Map<String, String>> list = projectDao.getCountBaomingChannelList(start, end);
		int sum = 0;
		for(Map<String,String> map:list){
			String real_type = map.get("real_type");
			int  count = Integer.parseInt(map.get("count"));
			sum += count;
			if("0".equals(real_type)){
				map.put("type_name", "车团PC");
			}else if("1".equals(real_type)){
				map.put("type_name", "车团手机");
			}else if("4".equals(real_type)){
				map.put("type_name", "tuan.315che.com-pc（百度）");
			}else if("5".equals(real_type)){
				map.put("type_name", "tuan.315che.com-mobile(百度)");
			}else if("6".equals(real_type)){
				map.put("type_name", "315chePC");
			}else if("7".equals(real_type)){
				map.put("type_name", "suncarsPC");
			}else if("8".equals(real_type)){
				map.put("type_name", "315che手机");
			}else if("9".equals(real_type)){
				map.put("type_name", "合作媒体");
			}else if("10".equals(real_type)){
				map.put("type_name", "suncars手机");
			}else if("11".equals(real_type)){
				map.put("type_name", "专题页报名");
			}else if("12".equals(real_type)){
				map.put("type_name", "特卖惠专题");
			}else if("13".equals(real_type)){
				map.put("type_name", "合作网站");
			}else if("14".equals(real_type)){
				map.put("type_name", "合作app");
			}else if("18".equals(real_type)){
				map.put("type_name", "购车节专题");
			}else if("19".equals(real_type)){
				map.put("type_name", "车展自行访客");
			}else if("20".equals(real_type)){
				map.put("type_name", "合作渠道");
			}else{
				map.put("type_name", "");
			}
		}
		for(Map<String,String> map:list){
			int  count = Integer.parseInt(map.get("count"));
			if(sum==0){
				map.put("rate", "0");
			}else{
				double rate = (double)count/sum*100;
				BigDecimal bd = new BigDecimal(rate);
				rate = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				map.put("rate", rate+"");
			}
		}
		Collections.sort(list,new Comparator<Map<String,String>>(){

			public int compare(Map<String, String> map1, Map<String, String> map2) {
				int c1 = Integer.parseInt(map1.get("count"));
				int c2 = Integer.parseInt(map2.get("count"));
				return c2-c1;
			}
			
			
		});
		return list;
	}
	public Map<String,Map<String,String>> countKF(String start,String end,String users) throws ParseException{
		Map<String,Map<String,String>>dateMap = new LinkedHashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> data = projectDao.CountKF(start, end, users);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_s = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();
		
		
		c_s.setTime(df.parse(start));
		c_e.setTime(df.parse(end));

		while(c_e.after(c_s)){
			String date = df.format(c_e.getTime());
			Map<String,String> map = data.get(date);
			if(map == null){
				map = new HashMap<String,String>();
			}
			
			dateMap.put(date, map);
			c_e.add(Calendar.DAY_OF_YEAR, -1);
		}
		String date = df.format(c_e.getTime());
		Map<String,String> map = data.get(date);
		if(map == null){
			map = new HashMap<String,String>();
		}
		dateMap.put(date, map);
		return dateMap;
	}

	public List<Map<String, String>> getAreaBaomingData(Map<String, String> map) {
		return countDao.getAreaBaomingData(map);
	}

	public List<Map<String, String>> getAreaBaomingDataNull() {
		return countDao.getAreaBaomingDataNull();
	}
}
