package com.poly.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_daos.DBConnect;
import car_daos.DboNewNewsDao;
import car_daos.DboNewPublishtimeDao;

import com.poly.service.BaseService;

public class PublishNewsPageTask extends TimerTask {

	private final String sql = "select * from dbo_new_publishtime where id > 0 and publishtime > 0 ORDER BY publishtime asc LIMIT 0, 5 for update";

	public void run() {
		System.out.println(">>> >>> PublishNewsPageTask timer task begin");

		DBConnect dbc = null;
		try {
			dbc = BaseService.createTransaction();
			dbc.prepareStatement(sql);
			ResultSet rs = dbc.executeQuery();
			List<DboNewPublishtime> resList = new ArrayList<DboNewPublishtime>();
			while (rs.next()) {
				DboNewPublishtime dbonewpublishtime = new DboNewPublishtime();
				DboNewPublishtimeDao.fill(rs, dbonewpublishtime);
				resList.add(dbonewpublishtime);
			}
			dbc.closePrepareStmt();

			if (resList.size() > 0) {
				for (DboNewPublishtime dboNewPublishtime : resList) {

					if (System.currentTimeMillis() > dboNewPublishtime.getPublishtime().getTime()) {
						System.out.println("publish news -->" + dboNewPublishtime.getId());

						DboNewNews dbonewnews = new DboNewNews();
						dbonewnews.setId(dboNewPublishtime.getId());
						dbonewnews.setIsdelete(0);
						DboNewNewsDao.update(dbc, dbonewnews);

						DboNewPublishtimeDao.delete(dbc, " id = " + dboNewPublishtime.getId());
					}
				}
			}

			BaseService.commitTransaction(dbc);
			dbc = null;
			resList = null;

		} catch (Exception e) {
			try {
				e.printStackTrace();
				BaseService.rollbackTransaction(dbc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			dbc = null;
		}
		System.out.println(">>> >>> PublishNewsPageTask timer task end");
	}

}
