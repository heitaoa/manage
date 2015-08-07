package com.poly.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.lang.StringEscapeUtils;




//import com.deity.album.beans.Album;
//import com.deity.album.beans.Photo;
//import com.deity.album.beans.User;
//import com.deity.album.services.AlbumService;
//import com.deity.album.services.PhotoService;
//import com.deity.album.utils.ConfUtils;
//import com.deity.album.utils.ConnectService;
//import com.deity.album.utils.CookieManager;
//import com.deity.album.utils.GeneratorHtml;
//import com.deity.album.utils.ImageUtil;
//import com.deity.album.utils.XMLManager;

import com.poly.upload.HttpFileUpload;
import com.poly.upload.InvalidFile;
import com.poly.util.ImageLinuxUtil;
import com.poly.util.MyConfig;

public class ReceiveServlet extends HttpServlet {

	private static final String RAR = "application/octet-stream";


	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(4096);
		factory.setRepository(new File(InitServlet.constant.getProperty("temp")));

		HttpFileUpload fu = new HttpFileUpload(factory);
		fu.setSizeMax(150 * 1024 * 1024);

		String to = request.getParameter("to");// ��ת���
		String postType = request.getParameter("postType");// ��ͼ��ʽ
		long aid = Long.parseLong(request.getParameter("aid"));// ���id
		String scid = request.getParameter("cid");
		String clubAid = request.getParameter("clubAid");
		long cid = 0;
		if (scid != null) {
			cid = Long.parseLong(scid);// ս��id
		}
//		Album album = null;// ������

		try {
			List invalidFiles = new ArrayList();
			List fileItemList = fu.parseRequest(request, invalidFiles);
			Iterator fileItemListIte = fileItemList.iterator();
			int addCount = fileItemList.size();

			if (addCount == 0) {// û���ļ��ϴ�
				failRedirect(response, to, aid, cid);
				return;
			}

//			// ȡservice����
//			WebApplicationContext ctx = WebApplicationContextUtils
//					.getRequiredWebApplicationContext(InitServlet.servletContext);
//			photoService = (PhotoService) ctx.getBean("photoService");
//			albumService = (AlbumService) ctx.getBean("albumService");

			// ʵ����user
//			Long userId = new Long(CookieManager.getCookieValue(request, "userId"));
//			String userName = CookieManager.getCookieValue(request, "userName");
//			String nickName = CookieManager.getCookieValue(request, "nickName");
//			nickName = URLDecoder.decode(nickName, "utf-8");
//			user = new User();
//			user.setUid(userId);
//			user.setUserName(userName);
//			user.setNickName(nickName);
//			String p = ConfUtils.getPath(user);	t/i/a/tianqin
			String p = "t/i/a/tianqin";//�������ظ�

			List newPhoto = new ArrayList();// ���ϴ�����Ƭ

//			album = albumService.findById(aid);

			addCount = 0;// �ϴ��ļ������㣬������Ч�ļ�
			long addSize = 0; // �ϴ��ļ��ܴ�С
			while (fileItemListIte.hasNext()) {
				FileItem fileItem = (FileItem) fileItemListIte.next();
				if (RAR.equals(fileItem.getContentType())) {// �ϴ�����ѹ����
					StringBuffer path = new StringBuffer(MyConfig.html_pic_upload_path);

					// ������ʱĿ¼
					path.append(p + "/album/temp");
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdir();
					}

					// ����ѹ��������ʱĿ¼
					File file = new File(path.toString() + "/temp.rar");
					fileItem.write(file);

					if (unRar(path)) {// ��ѹ�ɹ�
						file.delete();
					} else {// ��ѹʧ�ܣ��Ƿ��ļ�
						InvalidFile invalidFile = new InvalidFile("�Ƿ��ļ�", fileItem.getName());
						invalidFiles.add(invalidFile);
						file.delete();
						continue;
					}

					// �����ѹ���Ŀ¼���������ļ��Ƶ�һ��Ŀ¼
					searchFile(0, path.toString() + "/", path.toString());

					// ���浽db
					File pics[] = dir.listFiles();
					for (int i = 0; i < pics.length; i++) {
						String ext = getPicExtP(pics[i].getPath());
						if (ext == null) {// ɾ���޷�ʶ����ļ�
							pics[i].delete();
							continue;
						}
						if ("bmp".equals(ext)) {// bmp��ת��jpg��������Щ����������
							ImageLinuxUtil.bmpToJpg(pics[i].getPath(), pics[i].getPath());
							ext = "jpg";
						}

						// ����photo����
//						Photo photo = new Photo();
//						String[] arr = pics[i].getName().split("\\\\");
//						String detail = arr[arr.length - 1];
//						photo.setDetail(detail.substring(detail.indexOf("_") + 1, detail.lastIndexOf(".")));
//						photo.setCreateDate(new Date());
//						photo.setUserId(userId);
//						photo.setPhotoSize(pics[i].length());
//						photo.setAlbum(album);
//						photo.setResize(0);
//						photo.setExt(ext);
//						photoService.save(photo);
//						photo.setPhotoOrder(photo.getPid());
						
						addSize += pics[i].length();

						// ����ͼƬurl
//						StringBuffer url = new StringBuffer(InitServlet.constant.getProperty("url"));
//						url.append(p + "/album/");
//						url.append(album.getAid() + "/");
//
//						if (album.getCount() == 0) {
//							album.setCover(url.toString() + photo.getPid() + "_s." + ext);
//						}
//						url.append(photo.getPid());
//						photo.setUrl(url.toString());

						// ���ļ��Ƶ����Ŀ¼
						StringBuffer path1 = new StringBuffer(MyConfig.html_pic_upload_path);
						path1.append(p + "/album/tq");
//						path1.append(album.getAid() + "/");
//						path1.append(photo.getPid());
						path1.append("." + ext);
						File file1 = new File(path1.toString());
						pics[i].renameTo(file1);

//						photoService.update(photo);
//						newPhoto.add(photo);

//						hotStat(album, photo, p);
						addCount++;
					}
				} else {// ͼƬ�ļ�
					String ext = getPicExt(fileItem.getContentType());
					if ("bmp".equals(ext)) {
						ext = "jpg";
					}
//					Photo photo = new Photo();
					String[] arr = fileItem.getName().split("\\\\");
					String detail = arr[arr.length - 1];
//					photo.setDetail(detail.substring(detail.indexOf("_") + 1, detail.lastIndexOf(".")));
//					photo.setCreateDate(new Date());
//					photo.setUserId(userId);
//					photo.setPhotoSize(fileItem.getSize());
//					photo.setAlbum(album);
//					photo.setResize(0);
//					photo.setExt(ext);
//					photoService.save(photo);
//					photo.setPhotoOrder(photo.getPid());

					addSize += fileItem.getSize();

//					StringBuffer url = new StringBuffer(InitServlet.constant.getProperty("url"));
//					url.append(p + "/album/");
//					url.append(album.getAid() + "/");
//
//					if (album.getCount() == 0) {
//						album.setCover(url.toString() + photo.getPid() + "_s." + ext);
//
//					}
//					url.append(photo.getPid());
//					photo.setUrl(url.toString());

					StringBuffer path = new StringBuffer(MyConfig.html_pic_upload_path);
					path.append(p + "/album/");
//					path.append(album.getAid() + "/");
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdirs();
					}
					
					
//					path.append(photo.getPid());
					path.append(System.currentTimeMillis()+"_"+(Math.random() * 100)+"." + ext);
					File file = new File(path.toString());
					fileItem.write(file);
					if ("image/bmp".equals(fileItem.getContentType())) {
						ImageLinuxUtil.bmpToJpg(path.toString(), path.toString());
					}

//					photoService.update(photo);
//					newPhoto.add(photo);

//					hotStat(album, photo, p);
					addCount++;
				}
			}

//			album.setAlbumSize(album.getAlbumSize() + addSize);
//			album.setCount(album.getCount() + addCount);
//			albumService.updateAlbum(album);
			// ��ӵ�xml
//			XMLManager.addAlbum(album);
//			int spaceCount = photoService.amountPhotoBySpace(1, user);
//			if (spaceCount < 7) {// �ŵ��ռ�
//				for (int i = 0; i < newPhoto.size() && i < 7 - spaceCount; i++) {
//					Photo xp = (Photo) newPhoto.get(i);
//					XMLManager.addPhoto(xp);
//					xp.setSpace(1);
//					photoService.update(xp);
//				}
//			}
//			GeneratorHtml.genEworldNewAlbum(user, album);
			// ���ɾ�̬ҳ��
//			albumService.genListAlbum(user);

//			photoService.genPhotoPage(album, user);

//			Album cntm = albumService.findCntm(user);
//			if (cntm != null) {// cntm����ѡ��
//				GeneratorHtml.genCntmUser(1, user);
//			}
//			request.getSession().setAttribute("invalidFiles", invalidFiles);
//			if (postType != null) {// ����ͼ
//				request.getSession().setAttribute("newPhoto", newPhoto);
//				response.sendRedirect("./post_up_3.action");
//			} else {
//				if (to == null) {// һ���ϴ�
//					response.sendRedirect("./upload_result.action?aid=" + album.getAid());
//				} else if ("wall".equals(to)) {// �ռ䱳��
//					Photo tp = (Photo) newPhoto.get(0);
//					response.sendRedirect("http://zone.17dian.com/zone/uploadbg.action?url=" + tp.getUrl() + "."
//							+ tp.getExt());
//				} else if ("club".equals(to)) {
//					StringBuffer sb = new StringBuffer();
//
//					sb.append("<root cid=\"");
//					sb.append(cid);
//					sb.append("\" aid=\"");
//					sb.append(clubAid);
//					sb.append("\" userId=\"");
//					sb.append(user.getUid());
//					sb.append("\">");
//					for (int i = 0; i < newPhoto.size(); i++) {
//						Photo tp = (Photo) newPhoto.get(i);
//						sb.append("<photo>");
//						sb.append("<url>");
//						sb.append(tp.getUrl());
//						sb.append("</url>");
//						sb.append("<ext>");
//						sb.append(tp.getExt());
//						sb.append("</ext>");
//						sb.append("<detail><![CDATA[");
//						sb.append(StringEscapeUtils.escapeXml(tp.getDetail()));
//						sb.append("]]></detail>");
//						sb.append("</photo>");
//					}
//					sb.append("</root>");
//					String result = ConnectService.connect(ConfUtils.getStringValue("clubUpload"), sb.toString());
//					if ("1".equals(result)) {
//						response.sendRedirect("http://team.tqd.17dian.com/club/upload_success.action");
//					} else {
//						response.sendRedirect("http://team.tqd.17dian.com/club/upload_fail.action");
//					}
//				} else {// to=cntm
//					Photo tp0 = (Photo) newPhoto.get(0);
//					Photo tp1 = (Photo) newPhoto.get(1);
//					String s = "http://tm.17dian.com/apply/getimg.action?userId=" + user.getUid() + "&imgurl1="
//							+ tp0.getUrl() + "." + tp0.getExt() + "&imgurl2=" + tp1.getUrl() + "." + tp1.getExt();
//					if (newPhoto.size() > 2) {
//						Photo tp2 = (Photo) newPhoto.get(2);
//						s += "&imgurl3=" + tp2.getUrl() + "." + tp2.getExt();
//					}
//					ConnectService.connect(s, "");
//					response.sendRedirect("http://tm.17dian.com/apply/savetook.action");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
			failRedirect(response, to, aid, cid);

		} finally {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// fu.dispose();
		}
	}

	private void failRedirect(HttpServletResponse res, String to, long aid, long cid) {
		try {
			if (to == null) {
				res.sendRedirect("./upload.action?aid=" + aid);
			} else if ("wall".equals(to)) {
				res.sendRedirect("./upload.action?type=1&aid=" + aid);
			} else if ("club".equals(to)) {
				res.sendRedirect("./upload.action?cid=" + cid);
			} else {// to=cntm
				res.setContentType("text/html;charset=gbk");
				PrintWriter pw = res.getWriter();
				pw.print("<script>alert('�ϴ�ʧ�ܣ����Ժ����Ի��ϴ�����ͼƬ');location.href='http://tm.17dian.com/apply/savetook.action'</script>");
				pw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void hotStat(Album album, Photo photo, String p) {
//		String hit = InitServlet.constant.getProperty("path") + p + "/album/" + album.getAid() + "/" + photo.getPid()
//				+ "display.html";
//		File file1 = new File(hit);
//		try {
//			FileWriter fw = new FileWriter(file1);
//			fw.write("0");
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		hit = InitServlet.constant.getProperty("path") + p + "/album/" + album.getAid() + "/" + photo.getPid()
//				+ "hidden.html";
//		File file2 = new File(hit);
//		try {
//			FileWriter fw = new FileWriter(file2);
//			fw.write("0");
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	private boolean unRar(StringBuffer path) {
		// StringBuffer sb = new StringBuffer();
		String result = "";
		try {
			Process process;

			process = Runtime.getRuntime().exec("unrar x " + path.toString() + "/temp.rar " + path.toString());
			result = doWaitFor(process);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.indexOf("All OK") != -1) {
			return true;
		} else {
			return false;
		}
	}

	private void searchFile(int id, String p, String str) {
		File dir = new File(str);
		File pics[] = dir.listFiles();
		if (pics == null) {
			dir.renameTo(new File(p + id + "_" + dir.getName()));
			return;
		}
		for (int i = 0; i < pics.length; i++) {
			searchFile(id + 1, p, pics[i].getPath());
			dir.delete();
		}
	}

	private String getPicExtP(String path) {
		String result = null;
		try {
			Process p = Runtime.getRuntime().exec("identify -format %m " + path);
			p.waitFor();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
			in.close();
			if (sb.toString().indexOf("identify") == -1) {
				if ("JPEG".equals(sb.toString())) {
					result = "jpg";
				} else if ("BMP".equals(sb.toString())) {
					result = "bmp";
				} else if (sb.toString().indexOf("GIF") != -1) {
					result = "gif";
				} else if ("PNG".equals(sb.toString())) {
					result = "png";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getPicExt(String pictureContentType) {
		String ext = null;
		if ("image/pjpeg".equals(pictureContentType)) {
			ext = "jpg";
		} else if ("image/gif".equals(pictureContentType)) {
			ext = "gif";
		} else if ("image/x-png".equals(pictureContentType)) {
			ext = "png";
		} else if ("image/jpg".equals(pictureContentType)) {
			ext = "jpg";
		} else if ("image/jpeg".equals(pictureContentType)) {
			ext = "jpg";
		} else if ("image/png".equals(pictureContentType)) {
			ext = "png";
		} else if ("image/bmp".equals(pictureContentType)) {
			ext = "bmp";
		}
		return ext;
	}

	public String doWaitFor(Process p) {
		// int exitValue = -1; // returned to caller when p is finished
		StringBuffer sb = new StringBuffer();
		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			boolean finished = false; // Set to true when p is finished

			while (!finished) {
				try {
					String str = null;
					while ((str = in.readLine()) != null) {
						sb.append(str);
					}

					// Ask the process for its exitValue. If the process
					// is not finished, an IllegalThreadStateException
					// is thrown. If it is finished, we fall through and
					// the variable finished is set to true.
					// exitValue = p.exitValue();
					finished = true;
				} catch (IllegalThreadStateException e) {
					// e.printStackTrace();
					// Process is not finished yet;
					// Sleep a little to save on CPU cycles
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			// unexpected exception! print it out for debugging...
			System.err.println("doWaitFor(): unexpected exception - " + e.getMessage());
		}

		// return completion status to caller
		return sb.toString();
	}
}
