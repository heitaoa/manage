package com.poly.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import car_beans.DboAdmUser;
import car_beans.DboCarCatalognew;
import car_beans.DboContentbak;
import car_beans.DboDntUsers;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboNewRelated;
import car_daos.DBConnect;
import car_daos.DboAdmUserDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboNewCatalogDao;
import car_daos.DboNewContentDao;
import car_daos.DboNewNewsDao;
import car_daos.DboNewPublishtimeDao;
import car_daos.DboNewRelatedDao;

import com.poly.dao.ContentbakDao;
import com.poly.dao.NewsAdmDao;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.FileUtil;
import com.poly.util.MyConfig;
import com.redis.Redis2Dao;

public class NewsAdmService extends BaseService {

	public static int savePageNews(DboNewNews newNews, DboNewContent newContent, DboNewPublishtime newPublishtime, List<DboNewRelated> newRelatedList) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();
			int res1 = 1;// news
			int res2 = 1;// ����
			int res3 = 1;// ����ʱ��
			int res4 = 1;// �������

			// ��һҳ�����Ųű���ȫ����
			if (newNews != null) {
				res1 = NewsAdmDao.saveNews(dbc, newNews);
			}

			res2 = NewsAdmDao.saveContent(dbc, newContent);

			if (newPublishtime != null) {
				res3 = NewsAdmDao.savePublishtime(dbc, newPublishtime);
			}

			String subsql = null;
			if (newRelatedList != null && newRelatedList.size() > 0) {
				subsql = " id = " + newNews.getId();
				// ��ɾ���ϵģ��ٲ����µ��������
				res4 = DboNewRelatedDao.delete(dbc, subsql);
				if (res4 == 1) {
					for (DboNewRelated dboNewRelated : newRelatedList) {
						res4 = DboNewRelatedDao.save(dbc, dboNewRelated);
						if (res4 != 1)
							break;
					}
				}
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
	public static int updatePageNews(DboNewNews newNews, DboNewContent newContent, DboNewPublishtime newPublishtime, List<DboNewRelated> newRelatedList) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();

			int res1 = NewsAdmDao.updateNews(dbc, newNews);
			int res2 = NewsAdmDao.updateContent(dbc, newContent);
			int res3 = 1;
			if (newPublishtime != null) {
				res3 = NewsAdmDao.updatePublishtime(dbc, newPublishtime);
			}
			// �������
			int res4 = 1;
			String subsql = null;
			if (newRelatedList != null && newRelatedList.size() > 0) {
				subsql = " id = " + newNews.getId();
				// ��ɾ���ϵģ��ٲ����µ��������
				res4 = DboNewRelatedDao.delete(dbc, subsql);
				if (res4 == 1) {
					for (DboNewRelated dboNewRelated : newRelatedList) {
						res4 = DboNewRelatedDao.save(dbc, dboNewRelated);
						if (res4 != 1)
							break;
					}
				}
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
	public static int deletePageNews(String ids) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();
			String subsql = " id in(" + ids + ")";
			int res1 = DboNewNewsDao.delete(dbc, subsql);
			subsql = " newsid in(" + ids + ")";
			int res2 = DboNewContentDao.delete(dbc, subsql);
			if (res1 == 1 && res2 == 1) {
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

	public static int delNewsHtmlByCarcatalogid(int carcatalogid) {
		System.out.println(">>> >>> NewsAdmService.delNewsHtmlByCarcatalogid()");
		try {
			List<DboNewNews> list = NewsAdmDao.queryNewsByCarcatalogid(carcatalogid);
			System.out.println(">>> >>> list.size:"+list.size());
			for (DboNewNews dboNewNews : list) {
				System.out.println(">>> >>> del newsid:"+dboNewNews.getId());
				MyRemoteUtil.del(dboNewNews);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	// �������
	public static List<DboNewRelated> getNewRelated(int news_id) {
		String subsql = " id = " + news_id;
		return DboNewRelatedDao.where(subsql);
	}

	// 生成 html 1|生存成功;2|生存失败
	public static int publishNewsTR(int news_id) {
		int res = 1;
		DBConnect dbc = null;
		try {
			DboNewNews news = publishNewsHandler(news_id);

			dbc = BaseService.createTransaction();

			news.setIsdelete(0);
			NewsAdmDao.updateNews(dbc, news);
			DboNewPublishtimeDao.delete(dbc, " id = " + news_id);

			BaseService.commitTransaction(dbc);

		} catch (Exception e) {
			res = 2;
			try {
				e.printStackTrace();
				BaseService.rollbackTransaction(dbc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			dbc = null;
		}
		return res;
	}

	// 生成 html
	public static DboNewNews publishNewsHandler(int news_id) throws Exception {
		DboNewNews news = NewsAdmDao.queryNewsById(news_id);
		return publishNewsHandler(news);
	}

	// 生成 html
	public static DboNewNews publishNewsHandler(DboNewNews news) throws Exception {
		List<DboNewContent> contentList = NewsAdmDao.queryContentById(news.getId());
		news.setContents(contentList);
		int content_page = 1;
		int contentPageSize = contentList.size();
		for (DboNewContent dboNewContent : contentList) {
			// DboNewContent content =
			// NewsPageDao.queryContentById(news.getId(), content_page);

			// ���ļ��ж�ȡ��������
			String fpath = MyConfig.html_che_path + dboNewContent.getNewscontent();
			String contentStr = FileUtil.fread(fpath, 0);
			dboNewContent.setNewscontent(contentStr);

			// ����HTML
			DboCarCatalognew carCatalog = null;
			if (news.getCarcatalogid() > 0)
				carCatalog = NewsAdmDao.queryDboCarCatalognew(news.getCarcatalogid());
			// HtmlGenerator.genNewPage(news, dboNewContent, carCatalog,
			// content_page, contentPageSize);
			content_page++;
		}
		return news;
	}

	// ��ͨ����ϵ��5��������ţ����û�оʹ����Ŀ¼�����5��
	public static List<DboNewRelated> getRelatedList(DboNewNews news) {
		// TODO Auto-generated method stub
		List<DboNewRelated> result = new ArrayList<DboNewRelated>();

		String subsql = "carcatalogid = " + news.getCarcatalogid() + " and iswap = 0 ORDER BY adddate desc  limit 0, 5";
		List<DboNewNews> newsList = DboNewNewsDao.where(subsql);

		if (newsList.size() < 5) {
			int cur = newsList.size();

			subsql = "newscatalogid = " + news.getNewscatalogid() + " and iswap = 0 ORDER BY adddate desc  limit 0, 5";
			List<DboNewNews> tempList = DboNewNewsDao.where(subsql);

			for (DboNewNews dboNewNews : tempList) {
				newsList.add(dboNewNews);

				++cur;
				if (cur >= 5) {
					break;
				}
			}

		}

		for (DboNewNews dboNewNews : newsList) {
			DboNewRelated related = new DboNewRelated();
			related.setTitle(dboNewNews.getNewstitle());
			// related.setUrl(MyConfig.wap_ct_url + "wapnews/" +
			// news.getNewscatalogid() + "/page_" + news.getId() + "_1.html");

			result.add(related);
		}

		return result;
	}

	// ----------------------------------------------che

	public static DboNewCatalog getNewsCatalogByList(List<DboNewCatalog> allNewsCatalogList, int catalogid) {
		for (DboNewCatalog dboNewCatalog : allNewsCatalogList) {
			if (dboNewCatalog.getCatalogid() == catalogid)
				return dboNewCatalog;
		}
		return null;
	}

	public static List<DboNewNews> listForNews(String newsCatalogidStr, String addadmin, int isdelete, int newType, String keyWord, int iswap, int begin, int pageSize) {
		return NewsAdmDao.whereByType(newsCatalogidStr, addadmin, isdelete, newType, keyWord, iswap, begin, pageSize);
	}

	public static int countForNews(String newsCatalogidStr, String addadmin, int isdelete, int newType, String keyWord, int iswap) {
		return NewsAdmDao.countByType(newsCatalogidStr, addadmin, isdelete, newType, keyWord, iswap);
	}

	public static List<Map<String, String>> queryAllEditorList() {

		List<Map<String, String>> editors = Redis2Dao.getAllEditor();

		if (editors == null) {
			List<DboDntUsers> userList = NewsAdmDao.queryUserByUlevel("4,5");
			String usernames = "";
			for (DboDntUsers dboDntUsers : userList) {
				usernames += ",'" + dboDntUsers.getUsername() + "'";
			}
			if (usernames.length() > 1) {
				usernames = usernames.substring(1);
				String subsql = "username in (" + usernames + ")";
				List<DboAdmUser> allEditorList = DboAdmUserDao.where(subsql);

				// 插入redis
				Redis2Dao.setAllEditor(allEditorList);
			}

		}

		return Redis2Dao.getAllEditor();
	}

	public static DboNewCatalog queryNewsCatalogById(int newsCatalogid) {
		String substr = "catalogid = " + newsCatalogid;
		List<DboNewCatalog> list = DboNewCatalogDao.where(substr);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	public static DboCarCatalognew queryCarCatalogById(int carCatalogid) {
		String substr = "catalogid = " + carCatalogid;
		List<DboCarCatalognew> list = DboCarCatalognewDao.where(substr);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	// recursive
	public static void getNewCatalogByFatherid(List<DboNewCatalog> allNewCatalogList, DboNewCatalog newCatalog) throws Exception {
		allNewCatalogList.add(newCatalog);

		if (newCatalog.getPathlevel() == 3)
			return;

		List<DboNewCatalog> dboNewCatalogs = NewsAdmDao.queryNewsCatalogByFatherid(newCatalog.getCatalogid());

		for (DboNewCatalog dboNewCatalog : dboNewCatalogs) {
			getNewCatalogByFatherid(allNewCatalogList, dboNewCatalog);
		}
		return;
	}

	public static int updateIsdelete(String[] idArr, int isdelete) {
		String idsStr = "";
		for (int i = 0; i < idArr.length; i++) {
			idsStr += "," + idArr[i];
		}
		idsStr = idsStr.substring(1);
		String sql = "update dbo_new_news set isdelete = " + isdelete + " where id in (" + idsStr + ")";
		return DboNewNewsDao.execute(sql);
	}

	public static List<DboNewContent> queryContentById(int id) {
		String sql = " newsid=" + id + " order by sortid asc, id asc";
		return DboNewContentDao.where(sql);
	}

	public static DboContentbak queryContentbak(int cid) {
		String subsql = "cid=" + cid;
		List<DboContentbak> newsList = ContentbakDao.where(subsql);
		if (newsList != null && newsList.size() > 0) {
			return newsList.get(0);
		}
		return null;
	}

	public static List<DboNewNews> queryNewsList(String[] idArr) {
		String idsStr = "";
		for (int i = 0; i < idArr.length; i++) {
			idsStr += "," + idArr[i];
		}
		idsStr = idsStr.substring(1);
		String subsql = "id in (" + idsStr + ")";
		return DboNewNewsDao.where(subsql);
	}

	public static List<DboNewContent> queryNewsContentList(String[] idArr) {
		String idsStr = "";
		for (int i = 0; i < idArr.length; i++) {
			idsStr += "," + idArr[i];
		}
		idsStr = idsStr.substring(1);
		String subsql = "newsid in (" + idsStr + ")";
		return DboNewContentDao.where(subsql);
	}

}
