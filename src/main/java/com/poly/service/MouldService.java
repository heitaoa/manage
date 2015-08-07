package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.dao.che.MouldDao;
import com.poly.dao.che.SubjectDao;

import car_beans.DboPubMould;

public class MouldService {

	public static List<DboPubMould> getMouldList() {
		// TODO Auto-generated method stub
		return MouldDao.getMouldList();
	}
	
	public static List<Map<String,Object>> getSubjectMouldById(String subjectId) {
		// TODO Auto-generated method stub
		return MouldDao.getSubjectMouldById(subjectId);
	}

	public static void saveMould(DboPubMould mould) {
		// TODO Auto-generated method stub
		MouldDao.saveMould(mould);
	}

	public static DboPubMould getMouldById(String mouldId) {
		// TODO Auto-generated method stub
		return MouldDao.getMouldById(mouldId);
	}

	public static void saveSubjectMould(String subjectId, int mouldId) {
		// TODO Auto-generated method stub
		MouldDao.saveSubjectMould(subjectId,mouldId);
	}

	public static void deleteSubjectMould(String smid) {
		// TODO Auto-generated method stub
		MouldDao.deleteSubjectMould(smid);
	}

	public static void updateMould(DboPubMould mould) {
		// TODO Auto-generated method stub
		MouldDao.updateMould(mould);
	}

	public static void deleteMould(String mouldId) {
		// TODO Auto-generated method stub
		MouldDao.deleteMould(mouldId);
	}

}
