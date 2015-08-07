package com.poly.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_daos.DBConnect;
import car_daos.DboSubContentDao;

import com.poly.bean.QueryResult;
import com.poly.dao.NewsAdmDao;
import com.poly.dao.subDaos.DboSubDataSubDao;

public class SubContentService extends BaseService {

	public static QueryResult<List<DboSubContent>> querySubContentByKeywordAndcitySite(
			String keyword, String spaceid, int startIndex, int pageSize)
			throws Exception {
		QueryResult<List<DboSubContent>> queryResult = new QueryResult<List<DboSubContent>>();

		StringBuffer buf = new StringBuffer();
		// buf.append(" stype=1 ");
		// if (keyword != null) {
		// buf.append("and place like '%" + keyword + "%' ");
		// }
		// if (spaceid != null && !"".equals(spaceid.trim())) {
		// buf.append("and sub_sites_id=" + spaceid);
		// }

		String sql = "select & from dbo_sub_content a,tb_sub_sites b where a.sub_sites_id=b.id and (stype=1 or stype=3)";
		buf.append(sql);
		if (keyword != null) {
			buf.append("and a.place like '%" + keyword + "%' ");
		}
		if (spaceid != null && !"".equals(spaceid.trim())) {
			buf.append("and a.sub_sites_id=" + spaceid);
		}

		String count_sql = buf.toString().replace("&", "count(1) as count");
		DBConnect connect = new DBConnect(count_sql);
		ResultSet rs = connect.executeQuery();
		if (rs.next()) {
			queryResult.setCount(rs.getInt("count"));
		}

		buf.append(" limit " + startIndex + "," + pageSize);

		String data_sql = buf.toString().replace("&", "*");
		connect = new DBConnect(data_sql);
		rs = connect.executeQuery();

		List<DboSubContent> contents = new ArrayList<DboSubContent>();
		while (rs.next()) {
			DboSubContent content = new DboSubContent();
			content.setId(rs.getInt("id"));
			content.setDesc(rs.getString("desc"));
			content.setHtmlname(rs.getString("htmlname"));
			content.setIsdelete(rs.getInt("isdelete"));
			content.setLastvisittime(rs.getDate("lastvisittime"));
			content.setParent_id(rs.getInt("parent_id"));
			content.setPlace(rs.getString("place"));
			content.setPname(rs.getString("pname"));
			content.setStype(rs.getInt("stype"));
			content.setTemplatename(rs.getString("templatename"));
			content.setSub_sites_id(rs.getInt("sub_sites_id"));

			contents.add(content);
		}

		queryResult.setResult(contents);

		return queryResult;
	}

	public static Map<String, List<DboSubData>> queryPagesubDataBySid(int sid)
			throws Exception {
		return DboSubDataSubDao.queryPagesubDataBySid(sid);
	}

	public static Map<String, List<DboSubData>> queryIndexDATA()
			throws Exception {
		return DboSubDataSubDao.queryIndexDATA();
	}

	public static int savePageNews(DboNewNews newNews,
			DboNewContent newContent, DboNewPublishtime newPublishtime) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();
			int res1 = NewsAdmDao.saveNews(dbc, newNews);
			int res2 = NewsAdmDao.saveContent(dbc, newContent);
			int res3 = 1;
			if (newPublishtime != null) {
				res3 = NewsAdmDao.savePublishtime(dbc, newPublishtime);
			}
			if (res1 == 1 && res2 == 1 && res3 == 1) {
				commitTransaction(dbc);
				return 1;
			} else {
				throw (new Exception());
			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
				rollbackTransaction(dbc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
	}

	// �޸�
	public static int updatePageNews(DboNewNews newNews,
			DboNewContent newContent, DboNewPublishtime newPublishtime) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();

			int res1 = NewsAdmDao.updateNews(dbc, newNews);
			int res2 = NewsAdmDao.updateContent(dbc, newContent);
			int res3 = 1;
			if (newPublishtime != null) {
				res3 = NewsAdmDao.updatePublishtime(dbc, newPublishtime);
			}

			if (res1 == 1 && res2 == 1 && res3 == 1) {
				commitTransaction(dbc);
				return 1;
			} else {
				throw (new Exception());
			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
				rollbackTransaction(dbc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return -1;
		}
	}

	//
	public static DboSubContent findByArea(DboAreCatalog dboAreCatalog) {
		// TODO Auto-generated method stub
		// place
		String subsql = "place = '" + dboAreCatalog.getEnglingname() + "'";
		List<DboSubContent> list = DboSubContentDao.where(subsql);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

}
