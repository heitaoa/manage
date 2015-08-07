package com.poly.service;

import java.util.List;

import com.poly.dao.che.SubjectDataDao;

import car_beans.DboPubSubjectdata;

public class SubjectDataService {

	public static void saveSubjectData(DboPubSubjectdata subjectdata) {
		// TODO Auto-generated method stub
		SubjectDataDao.saveSubjectData(subjectdata);
	}

	public static List<DboPubSubjectdata> getSubjectDataListById(String subjectId,
			String mouldId) {
		// TODO Auto-generated method stub
		return SubjectDataDao.getSubjectDataListById(subjectId,mouldId);
	}

	public static DboPubSubjectdata getSubjectDataById(String dataId) {
		// TODO Auto-generated method stub
		return SubjectDataDao.getSubjectDataById(dataId);
	}

	public static void updateSubjectData(DboPubSubjectdata subjectdata) {
		// TODO Auto-generated method stub
		SubjectDataDao.updateSubjectData(subjectdata);
	}

}
