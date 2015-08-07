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
import com.poly.util.syncapplyinfo.ConvertData;

public class SyncApplyInfoAction extends MyActionSupport {
	// 抓取小胖数据
	public void syncData() {
		System.err.println("同步客服数据:syncData()begin---");
		Long beginTime = System.currentTimeMillis();
		try {
			new ConvertData().main(null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		System.err.println("同步客服数据:syncData()end---");
		Long endtime = System.currentTimeMillis();
		System.out.println("同步客服数据用时：" + (endtime - beginTime) / 1000 + "秒");
	}
	









}
