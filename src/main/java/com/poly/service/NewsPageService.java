package com.poly.service;

import java.util.ArrayList;
import java.util.List;

import car_beans.DboCarCatalognew;
import car_beans.DboContentbak;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboNewRelated;
import car_daos.DBConnect;
import car_daos.DboNewCatalogDao;
import car_daos.DboNewContentDao;
import car_daos.DboNewNewsDao;
import car_daos.DboNewRelatedDao;

import com.poly.dao.NewsAdmDao;
import com.poly.dao.NewsPageDao;
import com.poly.util.FileUtil;
import com.poly.util.HtmlGenerator;
import com.poly.util.MyConfig;
import com.redis.Redis2Dao;

public class NewsPageService extends BaseService {

	public static int savePageNews(DboNewNews newNews, DboNewContent newContent, DboContentbak contentbak, DboNewPublishtime newPublishtime, List<DboNewRelated> newRelatedList) {
		DBConnect dbc = null;
		try {
			dbc = createTransaction();
			int saveFlag = 1;

			//
			if (newNews != null) {
				saveFlag = NewsPageDao.saveNews(dbc, newNews);
			}

			if (saveFlag == 1)
				saveFlag = NewsPageDao.saveContent(dbc, newContent);

			if (saveFlag == 1)
				saveFlag = NewsPageDao.saveContentbak(dbc, contentbak);

			if (saveFlag == 1 && newPublishtime != null) {
				saveFlag = NewsPageDao.savePublishtime(dbc, newPublishtime);
			}

			String subsql = null;
			if (newRelatedList != null && newRelatedList.size() > 0) {
				subsql = " id = " + newNews.getId();
				//
				saveFlag = DboNewRelatedDao.delete(dbc, subsql);
				if (saveFlag == 1) {
					for (DboNewRelated dboNewRelated : newRelatedList) {
						saveFlag = DboNewRelatedDao.save(dbc, dboNewRelated);
						if (saveFlag != 1)
							break;
					}
				}
			}
			
			//即时更新新闻内容数据
			Redis2Dao.insertContentbak(contentbak);

			if (saveFlag == 1) {
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
	public static int updatePageNews(DboNewNews newNews, DboNewContent newContent, DboContentbak contentbak, DboNewPublishtime newPublishtime, List<DboNewRelated> newRelatedList) {
		DBConnect dbc = null;
		int res = 1;
		try {
			dbc = createTransaction();

			res = NewsPageDao.updateNews(dbc, newNews);
			if (res != 1)
				throw (new Exception());
			
			DboNewContent temp_newContent = NewsAdmDao.queryNewContent(newContent.getId());
			if (temp_newContent == null) {
				res = NewsPageDao.saveContent(dbc, newContent);
			} else {
				res = NewsPageDao.updateContent(dbc, newContent);
			}
			
			
			if (res != 1)
				throw (new Exception());

			// 弥补措施，先判断是否存在这条记录
			DboContentbak temp_contentbak = NewsPageDao.queryContentbakById(contentbak.getId());
			if (temp_contentbak == null) {
				res = NewsPageDao.saveContentbak(dbc, contentbak);
			} else {
				System.out.println("updatePageNews==================================temp_contentbak=========>update");
				res = NewsPageDao.updateContentbak(dbc, contentbak);
			}
			
			//即时更新新闻内容数据
			Redis2Dao.insertContentbak(contentbak);

			if (res != 1)
				throw (new Exception());

			if (newPublishtime != null) {
				res = NewsPageDao.updatePublishtime(dbc, newPublishtime);
			}

			// redis
			// if (res == 1)
			// res = Redis2Dao.deleteNews(newNews);
			// if (res == 1)
			// res = Redis2Dao.insertNews(newNews);
			//
			// if (res == 1)
			// res = Redis2Dao.deleteNewcontent(newContent);
			// if (res == 1)
			// res = Redis2Dao.insertNewcontent(newContent);

			if (res != 1)
				throw (new Exception());

			//
			String subsql = null;
			if (newRelatedList != null && newRelatedList.size() > 0) {
				subsql = " id = " + newNews.getId();
				//
				res = DboNewRelatedDao.delete(dbc, subsql);
				if (res == 1) {
					for (DboNewRelated dboNewRelated : newRelatedList) {
						res = DboNewRelatedDao.save(dbc, dboNewRelated);
						if (res != 1)
							break;
					}
				}
			}

			if (res == 1) {
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
			return res;
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

	// �������
	public static List<DboNewRelated> getNewRelated(int news_id) {
		String subsql = " id = " + news_id;
		return DboNewRelatedDao.where(subsql);
	}

	// ��������ҳ html
	public static DboNewNews publishNewsHandler(int news_id) throws Exception {
		DboNewNews news = NewsAdmDao.queryNewsById(news_id);

		String subsql = "catalogid=" + news.getNewscatalogid();
		DboNewCatalog newsCatalog = DboNewCatalogDao.where(subsql).get(0);
		news.setCatalog(newsCatalog);

		List<DboNewContent> contentList = NewsPageDao.queryContentById(news.getId());
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
				carCatalog = NewsPageDao.queryDboCarCatalognew(news.getCarcatalogid());
			// HtmlGenerator.genNewPage(news, dboNewContent, carCatalog,
			// content_page, contentPageSize);
			// WAP
			if (news.getIswap() == 1) {
				// List<DboNewRelated> relatedList =
				// DboNewRelatedDao.where("contentid = " + news.getId());
				List<DboNewRelated> relatedList = NewsPageService.getRelatedList(news, 5);
				// HtmlGenerator.genWapNewPage(news, dboNewContent, carCatalog,
				// relatedList, content_page, contentPageSize);
			}

			content_page++;
		}
		return news;
	}

	// ��ͨ����ϵ��5��������ţ����û�оʹ����Ŀ¼�����5��
	public static List<DboNewRelated> getRelatedList(DboNewNews news, int size) {
		// TODO Auto-generated method stub
		List<DboNewRelated> result = new ArrayList<DboNewRelated>();

		String subsql = "carcatalogid = " + news.getCarcatalogid() + " and iswap = 0 ORDER BY adddate desc  limit 0, " + size;
		List<DboNewNews> newsList = DboNewNewsDao.where(subsql);

		if (newsList.size() < 5) {
			int cur = newsList.size();

			subsql = "newscatalogid = " + news.getNewscatalogid() + " and iswap = 0 ORDER BY adddate desc  limit 0, " + size;
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
}
