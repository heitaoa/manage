package com.poly.action.action_news;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import car_beans.DboCarCatalognew;
import car_beans.DboContentbak;
import car_beans.DboNewCatalog;
import car_beans.DboNewContent;
import car_beans.DboNewNews;
import car_beans.DboNewPublishtime;
import car_beans.DboNewRelated;
import car_beans.DboNewSource;
import car_daos.DboNewContentDao;
import car_daos.DboNewSourceDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.NewsAdmDao;
import com.poly.dao.NewsPageDao;
import com.poly.dao.SeqDao;
import com.poly.freemarkerMethod.RealnameMethod;
import com.poly.service.AdminService;
import com.poly.service.ImageComService;
import com.poly.service.NewsAdmService;
import com.poly.service.NewsPageService;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.CalcPageUtil;
import com.poly.util.FieldUtil;
import com.poly.util.HtmlGenerator;
import com.poly.util.HtmlRegExpUtil;
import com.poly.util.MyConfig;
import com.poly.util.StringUtils;
import com.redis.Redis2Dao;

/**
 * @author tq
 *
 */
@SuppressWarnings("serial")
public class NewsAdmAction extends MyActionSupport {

	private final int resFlag_edit_by_other = 1;
	private int resFlag;//

	private String node_id;// 新闻树对应的目录

	private int pageSize = 12;
	private int pages = 1;
	private int page = 1;

	private int newsCatalogid;
	private String addadmin;
	private int isdelete = -1;
	private int newType;
	private String keyWord;

	private DboNewCatalog newsCatalog;
	private List<DboNewNews> newsList;
	private List<Map<String, String>> editorList;

	private List<Map<String, String>> editors;

	private int newsid;

	private DboNewNews news;
	private DboNewPublishtime newPublishtime;

	private List<DboNewSource> newSourceList;

	private List<DboNewContent> newContentList;

	private DboNewContent newContent;
	private String newsContentStr;
	private int contentPage = 1;
	private int contentPages = 1;

	private DboContentbak contentbak;

	private String newPublishtimeStr;

	private int isModify;// 是否修改

	private String newsidStr;// 批量newsid

	private String previewStr;

	private DboCarCatalognew carCatalognew;

	private RealnameMethod realnameMethod = new RealnameMethod();

	// 预览
	public String previewNews() {
		try {
			if (news == null) {
				setErr("新闻输入有误");
				return INPUT;
			}

			if (newsContentStr == null) {
				setErr("请输入内容");
				return INPUT;
			}

			if (news.getId() == 0)
				news.setId(SeqDao.getNextId("dbo_new_news"));
			Date now = new Date(System.currentTimeMillis());
			// news.setAdddate(now);
			// news.setLastupdate(now);
			news.setToptime(now);
			news.setSinktime(now);
			news.setSortid(news.getId());
			if (this.isModify == 1)
				news.setUpdateadmin((String) session.get("user"));
			else
				news.setAddadmin((String) session.get("user"));
			// content
			if (newContent.getId() == 0)
				newContent.setId(SeqDao.getNextId("dbo_new_content"));
			newContent.setNewsid(news.getId());

			// 内容 过滤乱码
			newsContentStr = StringUtils.escapeHtml315(newsContentStr);
			newContent.setNewscontent(newsContentStr);

			// 相关新闻 dbo_new_related
			String[] relationNews = request.getParameterValues("relation_news");
			List<DboNewRelated> newRelatedList = new ArrayList<DboNewRelated>();
			if (relationNews != null && relationNews.length > 0) {
				for (String string : relationNews) {
					// System.out.println("relation:" + string);
					String[] relatedArr = string.split("|");
					if (relatedArr != null && relatedArr.length == 3) {
						DboNewRelated dboNewRelated = new DboNewRelated();
						dboNewRelated.setId(news.getId());
						dboNewRelated.setContentid(Integer.valueOf(relatedArr[0]));
						dboNewRelated.setTitle(relatedArr[1]);
						dboNewRelated.setUrl(relatedArr[2]);
						newRelatedList.add(dboNewRelated);
					}
				}
			}
			// 预览
			DboCarCatalognew carCatalog = null;
			if (news.getCarcatalogid() > 0)
				carCatalog = NewsPageDao.queryDboCarCatalognew(news.getCarcatalogid());
			this.previewStr = HtmlGenerator.preNewPage(news, newContent, carCatalog, contentPage, contentPages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	//
	public String revertNews() {
		try {
			int res = 0;
			if (newsid > 0) {
				this.news = new DboNewNews();
				news.setId(newsid);
				news.setIsdelete(2);
				res = NewsAdmDao.update(news);

				// // redis
				// if (res == 1) {
				// this.news = NewsAdmDao.queryNewsById(newsid);
				// res = Redis2Dao.insertNews(news);
				// if (res == 1) {
				// List<DboNewContent> newContents =
				// NewsAdmDao.queryContentById(newsid);
				// for (DboNewContent dboNewContent : newContents) {
				// int temp_res = Redis2Dao.insertNewcontent(dboNewContent);
				// if (temp_res != 1)
				// res = temp_res;
				// }
				// }
				// }
			}
			//
			if (newsidStr != null && newsidStr.length() > 1) {
				String[] idArr = null;
				if (newsidStr != null && newsidStr.length() > 1) {
					idArr = newsidStr.split(",");
				}
				res = NewsAdmService.updateIsdelete(idArr, 0);

				// // redis
				// if (res == 1) {
				// List<DboNewNews> newsList =
				// NewsAdmService.queryNewsList(idArr);
				// for (DboNewNews dboNewNews : newsList) {
				// int temp_res = Redis2Dao.insertNews(dboNewNews);
				// if (temp_res != 1)
				// res = temp_res;
				// }
				// List<DboNewContent> newContentList =
				// NewsAdmService.queryNewsContentList(idArr);
				// for (DboNewContent dboNewContent : newContentList) {
				// int temp_res = Redis2Dao.insertNewcontent(dboNewContent);
				// if (temp_res != 1)
				// res = temp_res;
				// }
				// }
			}

			if (res == 1)
				setAjax("还原成功");
			else
				setAjax("还原失败");
			return AJAX;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAjax("还原失败");
		return AJAX;
	}

	// 是否是第一次发布新闻
	private int firstPublish;

	//
	public String publishNews() {
		try {
			int res = 0;
			if (newsid > 0) {
				this.news = new DboNewNews();
				news.setId(newsid);
				news.setIsdelete(0);
				news.setGradeid1(0);

				Date now = new Date(System.currentTimeMillis());

				if (firstPublish == 1)
					news.setAdddate(now);

				news.setLastupdate(now);// 更新时间

				res = NewsAdmDao.update(news);

				// redis
				if (res == 1) {
					this.news = NewsAdmDao.queryNewsById(newsid);
					res = Redis2Dao.insertNews(news);
					if (res == 1) {
						List<DboNewContent> newContents = NewsAdmDao.queryContentById(newsid);
						for (DboNewContent dboNewContent : newContents) {
							int temp_res = Redis2Dao.insertNewcontent(dboNewContent);
							if (temp_res != 1)
								res = temp_res;
						}
					}
					// 清除html
					MyRemoteUtil.del(news);
				}
			}
			//
			if (newsidStr != null && newsidStr.length() > 1) {
				String[] idArr = null;
				if (newsidStr != null && newsidStr.length() > 1) {
					idArr = newsidStr.split(",");
				}
				res = NewsAdmService.updateIsdelete(idArr, 0);

				// redis
				if (res == 1) {
					List<DboNewNews> newsList = NewsAdmService.queryNewsList(idArr);
					for (DboNewNews dboNewNews : newsList) {
						int temp_res = Redis2Dao.insertNews(dboNewNews);
						if (temp_res != 1)
							res = temp_res;

						// 清除html
						MyRemoteUtil.del(news);
					}
					List<DboNewContent> newContentList = NewsAdmService.queryNewsContentList(idArr);
					for (DboNewContent dboNewContent : newContentList) {
						int temp_res = Redis2Dao.insertNewcontent(dboNewContent);
						if (temp_res != 1)
							res = temp_res;
					}
				}
			}

			if (res == 1)
				setAjax("发布成功");
			else
				setAjax("发布失败");
			return AJAX;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAjax("发布失败");
		return AJAX;
	}

	private int contentid;

	//
	public String deleteContent() {
		try {
			int res = 0;
			if (contentid > 0) {

				DboNewContent newContent = NewsAdmDao.queryContentByContentid(contentid);
				if (newContent != null) {
					// DB
					res = DboNewContentDao.delete("id = " + contentid);

					Redis2Dao.deleteNewcontent(newContent);

					// 清除html
					this.news = NewsAdmDao.queryNewsById(newContent.getNewsid());
					if (news != null)
						MyRemoteUtil.del(news);
				}
			}

			if (res == 1)
				setAjax("删除成功");
			else
				setAjax("删除失败");
			return AJAX;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAjax("错误，请联系技术");
		return AJAX;
	}
	
	
	//
	public String deleteNews() {
		try {
			int res = 0;
			if (newsid > 0) {
				this.news = new DboNewNews();
				news.setId(newsid);
				news.setIsdelete(1);
				res = NewsAdmDao.update(news);

				// redis
				if (res == 1) {
					this.news = NewsAdmDao.queryNewsById(newsid);
					res = Redis2Dao.deleteNews(news);
					if (res == 1) {
						List<DboNewContent> newContents = NewsAdmDao.queryContentById(newsid);
						for (DboNewContent dboNewContent : newContents) {
							int temp_res = Redis2Dao.deleteNewcontent(dboNewContent);
							if (temp_res != 1)
								res = temp_res;
						}
					}

					// 清除html
					MyRemoteUtil.del(news);
				}
			}
			//
			if (newsidStr != null && newsidStr.length() > 1) {
				String[] idArr = null;
				if (newsidStr != null && newsidStr.length() > 1) {
					idArr = newsidStr.split(",");
				}
				res = NewsAdmService.updateIsdelete(idArr, 1);

				// redis
				if (res == 1) {
					List<DboNewNews> newsList = NewsAdmService.queryNewsList(idArr);
					for (DboNewNews dboNewNews : newsList) {
						int temp_res = Redis2Dao.deleteNews(dboNewNews);
						if (temp_res != 1)
							res = temp_res;

						// 清除html
						MyRemoteUtil.del(dboNewNews);
					}
					List<DboNewContent> newContentList = NewsAdmService.queryNewsContentList(idArr);
					for (DboNewContent dboNewContent : newContentList) {
						int temp_res = Redis2Dao.deleteNewcontent(dboNewContent);
						if (temp_res != 1)
							res = temp_res;
					}
				}
			}

			if (res == 1)
				setAjax("删除成功");
			else
				setAjax("删除失败");
			return AJAX;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAjax("错误，请联系技术");
		return AJAX;
	}

	private final int save_default = 2;
	private final int save_new_page = 3;
	private final int save_by_timer = 4;

	private int saveType;

	public String saveNews() {
		System.out.println("saveNews()");
		try {
			System.out.println("### >>> saveNews() ---------0---------- newsid"+newsid);
			
			
			if (saveType == save_default || saveType == save_by_timer) {
				if (isModify == 1) {
					System.out.println("### >>> saveNews() ---------01---------- >>>修改--》保存 | 预发布");
				} else {
					if (contentPage == 1) {
						System.out.println("### >>> saveNews() ---------02---------- >>>保存 | 预发布（第一页）");
					} else {
						System.out.println("### >>> saveNews() ---------03---------- >>>保存 | 预发布");
					}
				}
			}

			if (saveType == save_new_page) {
				if (contentPage == 1) {
					if (isModify == 1)
						System.out.println("### >>> saveNews() ---------04---------- >>>修改--》保存 新页（第一页）");
					else
						System.out.println("### >>> saveNews() ---------05---------- >>>保存 新页（第一页）");
				} else {
					if (isModify == 1)
						System.out.println("### >>> saveNews() ---------0---------- >>>修改--》保存 新页");
					else
						System.out.println("### >>> saveNews() ---------0---------- >>保存 新页");
				}
			}
			
			
			
			
			if (newsCatalog == null) {
				setErr("请选择新闻目录");
				return INPUT;
			}

			if (this.newsContentStr == null || newsContentStr.length() < 5) {
				setErr("请输入新闻内容");
				return INPUT;
			}

			if (news == null) {
				setErr("请重新选择新闻目录");
				return INPUT;
			}

			if (newsCatalog != null) {
				news.setCatalog(newsCatalog);
			}
			System.out.println("### >>> saveNews() ---------1---------- isModify"+isModify);
			if (news.getId() == 0)
				news.setId(SeqDao.getNextId("dbo_new_news"));
			Date now = new Date(System.currentTimeMillis());
			System.out.println("### >>> saveNews() ---------2---------- news.getId() "+news.getId() );
			// 第一次保存新闻
			if (this.isModify != 1 && contentPage == 1) {
				news.setGradeid1(1);
				news.setAdddate(now);// 第一次发布时间，（因为不能为空，暂存为保存时间）
				news.setSavedate(now);// 第一次保存时间
			}

			news.setLastupdate(now);// 更新时间

			news.setToptime(now);
			news.setSinktime(now);
			news.setSortid(news.getId());
			news.setIsdelete(2);// 未发布
			//
			Object addadmin = session.get("oldid");

			if (this.isModify == 1)
				news.setUpdateadmin((String) addadmin);
			else
				news.setAddadmin((String) addadmin);

			// content
			if (this.isModify != 1 && newContent.getId() == 0)
				newContent.setId(SeqDao.getNextId("dbo_new_content"));

			if (this.isModify != 1) {
				newContent.setSortid(next_sortid);
			}
			newContent.setNewsid(news.getId());

			if (this.isModify != 1) {
				newContent.setAdddate(now);
				newContent.setLastupdate(now);
			}

			// 新闻内容写到文件
			// String subPath = "new/" + news.getNewscatalogid() + "/page_" +
			// news.getId() + "_" + newContent.getId() + ".txt";

			// 过滤乱码
			newsContentStr = StringUtils.escapeHtml315(newsContentStr);

			// 取描述文字
			if (contentPage == 1) {
				String description = HtmlRegExpUtil.filterHtml(newsContentStr);
				int len = 100;
				if (description.length() < len)
					len = description.length();
				description = description.substring(0, len);
				news.setDescription(description);
			}

			System.out.println("--------------------------------capture first img");
			// 标题图片提取
			if (news.getTitlephoto() == null || news.getTitlephoto().length() < 1 || news.getTitlephoto().equals("default.jpg")) {
				System.out.println("-----------------1---------------set default img");
				news.setTitlephoto("default.jpg");
				// 从新闻内容中提取
				String titlephoto = HtmlRegExpUtil.getFirstImg(newsContentStr);
				if (titlephoto != null && titlephoto.length() > 3) {
					System.out.println("-----------------2---------------set first img:"+titlephoto);
					titlephoto = titlephoto.replaceAll(MyConfig.che_url, "");
					news.setTitlephoto(titlephoto);
				} else {
					System.out.println("-----------------3---------------get img by carinfo");
					// 从车系中找一张图片
					if (news.getCarcatalogid() > 0) {
						String carImg = null;
						List<String> imgList = ImageComService.getInstance().typespic(news.getCarcatalogid() + "", "1", 1);
						if (imgList != null && imgList.size() > 0) {
							carImg = imgList.get(0);
						}
						if (carImg != null) {
							news.setTitlephoto(carImg);
						}
					}
				}
			}

			// 新闻内容写到文件
			// FileUtil.fwrite(MyConfig.html_che_path + subPath,
			// newsContentStr);
			// newContent.setNewscontent(subPath);

			// 新闻内容
			if (contentbak == null)
				contentbak = new DboContentbak();

			System.out.println("newstitle =======================>" + news.getNewstitle());
			System.out.println("old id =======================>" + contentbak.getId());
			System.out.println("old cid =======================>" + contentbak.getCid());
			if (this.isModify != 1 || contentbak.getId() == 0)
				contentbak.setId(SeqDao.getNextId("dbo_contentbak"));
			contentbak.setCid(newContent.getId());
			contentbak.setContentstr(newsContentStr);
			contentbak.setAdddate(now);
			
			System.out.println("new id =======================>" + contentbak.getId());
			System.out.println("old cid =======================>" + contentbak.getCid());
			
			contentbak.setNewsid(news.getId());

			// 相关新闻 dbo_new_related
			String[] relationNews = request.getParameterValues("relation_news");
			List<DboNewRelated> newRelatedList = new ArrayList<DboNewRelated>();
			if (relationNews != null && relationNews.length > 0) {
				for (String string : relationNews) {
					// System.out.println("relation:" + string);
					String[] relatedArr = string.split("|");
					if (relatedArr != null && relatedArr.length == 3) {
						DboNewRelated dboNewRelated = new DboNewRelated();
						dboNewRelated.setId(news.getId());
						dboNewRelated.setContentid(Integer.valueOf(relatedArr[0]));
						dboNewRelated.setTitle(relatedArr[1]);
						dboNewRelated.setUrl(relatedArr[2]);
						newRelatedList.add(dboNewRelated);
					}
				}
			}

			// 预发布 处理
			if (saveType == this.save_by_timer) {
				newPublishtime = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (!FieldUtil.isEmpty(newPublishtimeStr)) {
					Date publishdate = sdf.parse(newPublishtimeStr);
					if (publishdate != null) {
						newPublishtime = new DboNewPublishtime();
						newPublishtime.setId(news.getId());
						newPublishtime.setPublishtime(publishdate);

						news.setAdddate(publishdate);// 显示预发布的的时间
					}
				}
				news.setIsdelete(3);// 预发布
			}

			// insert DB

			if (saveType == save_default || saveType == save_by_timer) {
				if (isModify == 1) {
					NewsPageService.updatePageNews(news, newContent, contentbak, newPublishtime, newRelatedList);
				} else {
					if (contentPage == 1) {
						NewsPageService.savePageNews(news, newContent, contentbak, newPublishtime, newRelatedList);
					} else {
						NewsPageService.savePageNews(null, newContent, contentbak, newPublishtime, newRelatedList);
					}
				}
			}

			if (saveType == save_new_page) {
				if (contentPage == 1) {
					if (isModify == 1)
						NewsPageService.updatePageNews(news, newContent, contentbak, newPublishtime, newRelatedList);
					else
						NewsPageService.savePageNews(news, newContent, contentbak, newPublishtime, newRelatedList);
				} else {

					if (isModify == 1)
						NewsPageService.updatePageNews(news, newContent, contentbak, newPublishtime, newRelatedList);
					else
						NewsPageService.savePageNews(null, newContent, contentbak, null, null);
				}
				newContent.setId(0);
				newsContentStr = "";
				contentbak.setId(0);
			}

			isModify = 0;// 一次只能修改一个页面

			// return
			if (saveType == save_default || saveType == save_by_timer) {
				// this.listByCatalogid(news.getNewscatalogid());
				return "tonewslist";
			} else if (saveType == save_new_page) {
				setErr("新闻第 " + contentPage + " 页保存成功!");

				++contentPage;
				contentPages = contentPage;
				// 来源
				if (newSourceList == null) {
					newSourceList = DboNewSourceDao.find();
				}
				return INPUT;
			} else {
				System.out.println("NewsAction.saveNews(): >>> 未处理的保存类型：" + saveType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return INPUT;
	}

	private int isimgnews = 0;

	private int next_sortid = 1;

	private Date today;

	public String viewNewsEdit() {
		try {
			today = new Date();

			if (newsid > 0) {
				System.out.println(">>> >>> viewNewsEdit() ------0------has newsid:"+newsid);
				this.news = NewsAdmDao.queryNewsById(newsid);
				
				
				if (this.isModify == 1) {
					System.out.println(">>> >>> viewNewsEdit() -------1-----isModify:"+isModify);
					news.setIsdelete(2);// 还原成初始状态
				} else {
					System.out.println(">>> >>> viewNewsEdit() -------2-----isModify:"+isModify);
					news.setId(0);
				}
			}
			//
			if (news == null)
				news = new DboNewNews();
			//
			if (newsCatalogid > 0) {
				news.setNewscatalogid(newsCatalogid);
			}
			//
			this.newsCatalog = NewsAdmService.queryNewsCatalogById(news.getNewscatalogid());
			news.setCatalog(newsCatalog);
			if (newsCatalog != null)
				news.setAreaid(newsCatalog.getAreaid());

			if (isimgnews > 0)
				news.setIsimgnews(isimgnews);

			// 发布时间
			newPublishtime = NewsAdmDao.queryPublishtimeById(newsid);
			if (newPublishtime == null) {
				newPublishtime = new DboNewPublishtime();
				newPublishtime.setPublishtime(new Date());
			}
			// 来源
			if (newSourceList == null) {
				newSourceList = DboNewSourceDao.find();
			}
			// 内容
			if (newsid > 0) {
				System.out.println(">>> >>> viewNewsEdit() -------4-----newsid:"+newsid);
				this.newContentList = NewsAdmService.queryContentById(newsid);
				contentPages = newContentList.size();
				System.out.println(">>> >>> viewNewsEdit() -------5-----contentPages:"+contentPages);
				if (contentPage < 1)
					contentPage = 1;
				if (contentPage > contentPages)
					contentPage = contentPages;

				
				System.out.println(">>> >>> viewNewsEdit() -------6-----contentPages:"+contentPages);
				
				// next_sortid
				next_sortid = contentPages;
				if (contentPages > 0) {
					next_sortid = newContentList.get(contentPages - 1).getSortid() + 1;
				}

				System.out.println(">>> >>> viewNewsEdit() -------7-----contentPage:"+contentPage);
				int page = 1;
				for (DboNewContent dboNewContent : this.newContentList) {
					if (page == contentPage) {
						this.newContent = dboNewContent;
					}
					page++;
				}

				if (this.newContent != null && this.newContent.getId() > 0) {
					System.out.println(">>> >>> viewNewsEdit() -------8-----newContent.getId():"+newContent.getId());
					
					this.contentbak = NewsAdmService.queryContentbak(this.newContent.getId());

					System.out.println(">>> >>> viewNewsEdit() -------9-----contentbak.getId():"+contentbak.getId());
					System.out.println(">>> >>> viewNewsEdit() -------91-----contentbak.getCid():"+contentbak.getCid());
					
					if (this.isModify == 1) {
						// 不动作
					} else {
						// 清空ID，应为是从其他新闻中复制过来的
						this.newContent.setId(0);
						System.out.println(">>> >>> viewNewsEdit() -------92-----newContent.getId():"+newContent.getId());
					}
				}

				if (this.contentbak != null) {
					
					if (this.isModify == 1) {
						// 不动作
						System.out.println(">>> >>> viewNewsEdit() -------10-----contentbak.getId():"+contentbak.getId());
					} else {
						// 清空ID，应为是从其他新闻中复制过来的
						this.contentbak.setId(0);
						System.out.println(">>> >>> viewNewsEdit() -------11-----contentbak.getId():"+contentbak.getId());
					}

					newsContentStr = this.contentbak.getContentstr();
				}

			}

			// 关联车系
			if (news.getCarcatalogid() > 0) {
				this.carCatalognew = NewsAdmService.queryCarCatalogById(news.getCarcatalogid());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<Map<String, String>> getEditors() {
		return editors;
	}

	public void setEditors(List<Map<String, String>> editors) {
		this.editors = editors;
	}

	public void setEditorList(List<Map<String, String>> editorList) {
		this.editorList = editorList;
	}

	public String viewNewsList() {
		long begin = System.currentTimeMillis();
		try {

			editors = AdminService.getInstance().listBianji();

			if (newsCatalogid > 0) {
				this.listByCatalogid(newsCatalogid);
				//
				// if (resFlag != null && resFlag.length() > 0) {
				// //
				// if (resFlag.equals("chetuan")) {
				// String callbackFunName =
				// request.getParameter("callbackparam");
				// setAjax(callbackFunName + "([ { name:\"John\"}])");
				// return AJAX;
				// }
				// //
				// if (resFlag.equals("subPage")) {
				// return "pageListSub";
				// }
				// }

			} else {
				setErr("请先选择一个目录");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (resFlag == resFlag_edit_by_other) {
			return "newsList_sub";
		}
		System.out.println("NewsAdmAction.viewNewsList()-----off tm----" + (System.currentTimeMillis() - begin));
		return SUCCESS;
	}

	//
	private void listByCatalogid(int newsCatalogid) throws Exception {
		// editorList = NewsAdmService.queryAllEditorList();

		newsCatalog = NewsAdmService.queryNewsCatalogById(newsCatalogid);
		//
		List<DboNewCatalog> allNewsCatalogList = new ArrayList<DboNewCatalog>();
		NewsAdmService.getNewCatalogByFatherid(allNewsCatalogList, newsCatalog);
		String newsCatalogidStr = "";
		for (DboNewCatalog dboNewCatalog : allNewsCatalogList) {
			newsCatalogidStr += "," + dboNewCatalog.getCatalogid();
		}
		newsCatalogidStr = newsCatalogidStr.substring(1);
		System.out.println("newsCatalogidStr-->" + newsCatalogidStr);

		int amnout = NewsAdmService.countForNews(newsCatalogidStr, addadmin, isdelete, newType, keyWord, 0);
		pages = CalcPageUtil.getPages(amnout, pageSize);
		if (page < 1)
			page = 1;
		if (page > pages)
			page = pages;
		//
		int begin = (page - 1) * pageSize;
		newsList = NewsAdmService.listForNews(newsCatalogidStr, addadmin, isdelete, newType, keyWord, 0, begin, pageSize);

		for (DboNewNews dboNewNews : newsList) {
			List<DboNewContent> contents = null;
			contents = NewsAdmDao.queryContentById(dboNewNews.getId());
			dboNewNews.setContents(contents);

			DboNewCatalog dboNewCatalog = null;
			dboNewCatalog = NewsAdmService.getNewsCatalogByList(allNewsCatalogList, dboNewNews.getNewscatalogid());
			dboNewNews.setCatalog(dboNewCatalog);
		}
	}

	public String refreshNews() {
		try {
			if (newsid > 0) {
				this.news = NewsAdmDao.queryNewsById(newsid);
				int res = MyRemoteUtil.del(news);

				if (res == 11)
					setAjax("清除html成功");
				else
					setAjax("清除html失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AJAX;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNewsCatalogid() {
		return newsCatalogid;
	}

	public void setNewsCatalogid(int newsCatalogid) {
		this.newsCatalogid = newsCatalogid;
	}

	public DboContentbak getContentbak() {
		return contentbak;
	}

	public void setContentbak(DboContentbak contentbak) {
		this.contentbak = contentbak;
	}

	public int getFirstPublish() {
		return firstPublish;
	}

	public void setFirstPublish(int firstPublish) {
		this.firstPublish = firstPublish;
	}

	public String getAddadmin() {
		return addadmin;
	}

	public void setAddadmin(String addadmin) {
		this.addadmin = addadmin;
	}

	public RealnameMethod getRealnameMethod() {
		return realnameMethod;
	}

	public void setRealnameMethod(RealnameMethod realnameMethod) {
		this.realnameMethod = realnameMethod;
	}

	public DboCarCatalognew getCarCatalognew() {
		return carCatalognew;
	}

	public void setCarCatalognew(DboCarCatalognew carCatalognew) {
		this.carCatalognew = carCatalognew;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public DboNewContent getNewContent() {
		return newContent;
	}

	public void setNewContent(DboNewContent newContent) {
		this.newContent = newContent;
	}

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public String getNewPublishtimeStr() {
		return newPublishtimeStr;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public int getNext_sortid() {
		return next_sortid;
	}

	public void setNext_sortid(int next_sortid) {
		this.next_sortid = next_sortid;
	}

	public void setNewPublishtimeStr(String newPublishtimeStr) {
		this.newPublishtimeStr = newPublishtimeStr;
	}

	public int getIsModify() {
		return isModify;
	}

	public int getContentPage() {
		System.out.println("NewsAction.getContentPage()" + contentPage);
		return contentPage;
	}

	public void setContentPage(int contentPage) {
		this.contentPage = contentPage;
	}

	public String getPreviewStr() {
		return previewStr;
	}

	public void setPreviewStr(String previewStr) {
		this.previewStr = previewStr;
	}

	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}

	public String getNewsidStr() {
		return newsidStr;
	}

	public void setNewsidStr(String newsidStr) {
		this.newsidStr = newsidStr;
	}

	public int getSaveType() {
		return saveType;
	}

	public void setSaveType(int saveType) {
		this.saveType = saveType;
	}

	public int getSave_default() {
		return save_default;
	}

	public int getIsimgnews() {
		return isimgnews;
	}

	public void setIsimgnews(int isimgnews) {
		this.isimgnews = isimgnews;
	}

	public int getSave_new_page() {
		return save_new_page;
	}

	public int getSave_by_timer() {
		return save_by_timer;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public int getNewType() {
		return newType;
	}

	public void setNewType(int newType) {
		this.newType = newType;
	}

	public int getResFlag_edit_by_other() {
		return resFlag_edit_by_other;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public DboNewCatalog getNewsCatalog() {
		return newsCatalog;
	}

	public void setNewsCatalog(DboNewCatalog newsCatalog) {
		this.newsCatalog = newsCatalog;
	}

	public List<DboNewNews> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<DboNewNews> newsList) {
		this.newsList = newsList;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getNewsContentStr() {
		return newsContentStr;
	}

	public void setNewsContentStr(String newsContentStr) {
		this.newsContentStr = newsContentStr;
	}

	public int getResFlag() {
		return resFlag;
	}

	public int getContentPages() {
		return contentPages;
	}

	public void setContentPages(int contentPages) {
		this.contentPages = contentPages;
	}

	public DboNewPublishtime getNewPublishtime() {
		return newPublishtime;
	}

	public void setNewPublishtime(DboNewPublishtime newPublishtime) {
		this.newPublishtime = newPublishtime;
	}

	public List<DboNewSource> getNewSourceList() {
		return newSourceList;
	}

	public void setNewSourceList(List<DboNewSource> newSourceList) {
		this.newSourceList = newSourceList;
	}

	public DboNewNews getNews() {
		return news;
	}

	public void setNews(DboNewNews news) {
		this.news = news;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public void setResFlag(int resFlag) {
		this.resFlag = resFlag;
	}

	public List<Map<String, String>> getEditorList() {
		return editorList;
	}

}
