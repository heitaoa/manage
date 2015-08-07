package com.poly.dao;

import java.util.List;

import car_beans.DboCarCatalognew;
import car_beans.DboDntUsers;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboSubContent;
import car_daos.DBConnect;
import car_daos.DboCarCatalognewDao;
import car_daos.DboDntUsersDao;
import car_daos.DboNewCatalogDao;
import car_daos.DboNewContentDao;
import car_daos.DboNewNewsDao;
import car_daos.DboNewPublishtimeDao;
import car_daos.DboSubContentDao;

import com.poly.util.DateUtils;

public class NewsAdmDao extends DboNewNewsDao {

	public static int countByType(String newscatalogid, String addadmin, int isdelete, int newType, String keyWord, int iswap) {

		String w = " newscatalogid in (" + newscatalogid + ")";
		if (addadmin != null && !"".equals(addadmin.trim()))
			w += " and addadmin='" + addadmin + "'";
		//
		if (isdelete == -1)
			w += " and isdelete <> 1";
		else
			w += " and isdelete=" + isdelete;

		if (newType == 1)// ԭ��
			w += " and isoriginal=1";
		if (newType == 2)// ����ͼƬ����
			w += " and isimgnews=1";
		if (newType == 3)// ԭ��ͼƬ����
			w += " and isoriginal=1 and isimgnews=1";
		if (newType == 4)// �ؿ�
			w += " and islook=1";

		if (iswap == 1)// ֻ�ҳ�wap����
			w += " and iswap=1";

		if (keyWord != null && !"".equals(keyWord.trim()))
			w += " and newstitle like '%" + keyWord + "%'";

		return whereCount(w);
	}

	public static List<DboNewNews> whereByType(String newscatalogid, String addadmin, int isdelete, int newType, String keyWord, int iswap, int start, int pagesize) {
		String w = " newscatalogid in (" + newscatalogid + ")";
		if (addadmin != null && !"".equals(addadmin.trim()))
			w += " and addadmin='" + addadmin + "'";
		//
		if (isdelete == -1)
			w += " and isdelete <> 1";
		else
			w += " and isdelete=" + isdelete;

		if (newType == 1)// ԭ��
			w += " and isoriginal=1";
		if (newType == 2)// ����ͼƬ����
			w += " and isimgnews=1";
		if (newType == 3)// ԭ��ͼƬ����
			w += " and isoriginal=1 and isimgnews=1";
		if (newType == 4)// �ؿ�
			w += " and islook=1";

		if (iswap == 1)// ֻ�ҳ�wap����
			w += " and iswap=1";

		if (keyWord != null && !"".equals(keyWord.trim()))// �ؿ�
			w += " and newstitle like '%" + keyWord + "%'";

		w += " ORDER BY sortid DESC limit " + start + ", " + pagesize;

		return where(w);
	}

	public static int saveNews(DBConnect dbc, DboNewNews newNews) throws Exception {
		// TODO Auto-generated method stub
		return save(dbc, newNews);
	}

	public static int saveContent(DBConnect dbc, DboNewContent newContent) throws Exception {
		// TODO Auto-generated method stub
		return DboNewContentDao.save(dbc, newContent);
	}

	public static int savePublishtime(DBConnect dbc, DboNewPublishtime newPublishtime) throws Exception {
		// TODO Auto-generated method stub
		return DboNewPublishtimeDao.save(dbc, newPublishtime);
	}

	// �޸�
	public static int updateNews(DBConnect dbc, DboNewNews newNews) throws Exception {
		// TODO Auto-generated method stub
		update(dbc, newNews);
		return 1;
	}

	public static int updateContent(DBConnect dbc, DboNewContent content) throws Exception {
		// TODO Auto-generated method stub
		if (content != null)
			DboNewContentDao.update(dbc, content);
		return 1;
	}

	public static int updatePublishtime(DBConnect dbc, DboNewPublishtime publishtime) throws Exception {
		// TODO Auto-generated method stub
		String sql = " id=" + publishtime.getId();
		DboNewPublishtimeDao.delete(dbc, sql);
		DboNewPublishtimeDao.save(dbc, publishtime);
		return 1;
	}

	// ��ѯ
	public static DboNewCatalog queryNewsCatalogById(int catalogid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " catalogid =" + catalogid;
		List<DboNewCatalog> list = DboNewCatalogDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public static List<DboNewNews> queryNewsByCarcatalogid(int carcatalogid) throws Exception {
		String sql = " carcatalogid =" + carcatalogid + " and lastupdate > '"+DateUtils.getForwardDay(30)+"' and isdelete=0 ORDER BY lastupdate DESC limit 10";
		return DboNewNewsDao.where(sql);
	}

	// ��ѯ
	public static List<DboNewContent> queryContentById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " newsid=" + id;
		return DboNewContentDao.where(sql);
	}

	// ��ѯ
	public static DboNewContent queryNewContent(int id) throws Exception {
		String sql = " id=" + id;
		List<DboNewContent> list = DboNewContentDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ��ѯ
	public static DboNewPublishtime queryPublishtimeById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " id=" + id;
		List<DboNewPublishtime> list = DboNewPublishtimeDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ��ѯ
	public static DboCarCatalognew queryDboCarCatalognew(int catalogid) throws Exception {
		// TODO Auto-generated method stub
		String sql = " catalogid=" + catalogid;
		List<DboCarCatalognew> list = DboCarCatalognewDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ��ѯ
	public static DboSubContent querySubContentById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " id=" + id;
		List<DboSubContent> list = DboSubContentDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ��ѯ
	public static List<DboNewCatalog> queryNewsCatalogByFatherid(int f_id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " fatherid=" + f_id;
		return DboNewCatalogDao.where(sql);
	}

	public static DboNewContent queryContentByNewsid(int newsid, int page) throws Exception {
		String sql = " newsid=" + newsid;
		List<DboNewContent> list = DboNewContentDao.where(sql);
		if (list != null && list.size() >= page && page > 0) {
			return list.get(page - 1);
		}
		return null;
	}

	public static DboNewContent queryContentByContentid(int contentid) throws Exception {
		String sql = " id =" + contentid;
		List<DboNewContent> list = DboNewContentDao.where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public static DboNewNews queryNewsById(int id) throws Exception {
		String sql = " id=" + id;
		List<DboNewNews> list = where(sql);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public static List<DboDntUsers> queryUserByUlevel(String ulevelStr) {
		String sql = " uid in (select uid from dbo_dnt_userlevel where ulevel in (" + ulevelStr + "))";
		return DboDntUsersDao.where(sql);
	}

}
