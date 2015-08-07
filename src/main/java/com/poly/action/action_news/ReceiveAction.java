package com.poly.action.action_news;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import com.poly.action.MyActionSupport;
import com.poly.bean.Pic;
import com.poly.upload.HttpFileUpload;
import com.poly.upload.InvalidFile;
import com.poly.util.IconUtil;
import com.poly.util.ImageLinuxUtil;
import com.poly.util.ImageUtil;
import com.poly.util.MyConfig;
import com.poly.util.UnrarUtil;

//���۹���
public class ReceiveAction extends MyActionSupport {

	private static final String RAR = "application/octet-stream";

	public static void main(String[] args) {
		File file = new File("d://zzz/test/");
		System.out.println(file.getParent());
		File pics[] = file.listFiles();
		searchFile(0, file.getPath() + "/", file.getPath());
		System.out.println(file.getName());
	}

	public String receive() {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(4096);
		factory.setRepository(new File(MyConfig.html_pic_upload_path + "temp/"));

		HttpFileUpload fu = new HttpFileUpload(factory);
		fu.setSizeMax(150 * 1024 * 1024);

		// String to = request.getParameter("to");// ��ת���
		// String postType = request.getParameter("postType");// ��ͼ��ʽ
		// long aid = Long.parseLong(request.getParameter("aid"));// ���id
		// String scid = request.getParameter("cid");
		// String clubAid = request.getParameter("clubAid");
		// long cid = 0;
		// if (scid != null) {
		// cid = Long.parseLong(scid);// ս��id
		// }
		// Album album = null;// ������

		try {
			List invalidFiles = new ArrayList();
			List fileItemList = fu.parseRequest(request, invalidFiles);
			Iterator fileItemListIte = fileItemList.iterator();
			int addCount = fileItemList.size();

			if (addCount == 0) {// û���ļ��ϴ�
				// failRedirect(response, to, aid, cid);
				setAjax("û���ϴ��ļ�");
				return AJAX;
			}

			// // ȡservice����
			// WebApplicationContext ctx = WebApplicationContextUtils
			// .getRequiredWebApplicationContext(InitServlet.servletContext);
			// photoService = (PhotoService) ctx.getBean("photoService");
			// albumService = (AlbumService) ctx.getBean("albumService");

			// ʵ����user
			// Long userId = new Long(CookieManager.getCookieValue(request,
			// "userId"));
			// String userName = CookieManager.getCookieValue(request,
			// "userName");
			// String nickName = CookieManager.getCookieValue(request,
			// "nickName");
			// nickName = URLDecoder.decode(nickName, "utf-8");
			// user = new User();
			// user.setUid(userId);
			// user.setUserName(userName);
			// user.setNickName(nickName);
			// String p = ConfUtils.getPath(user); t/i/a/tianqin
			String p = "t/i/a/tianqin";// �������ظ�

			List newPhoto = new ArrayList();// ���ϴ�����Ƭ

			// album = albumService.findById(aid);

			addCount = 0;// �ϴ��ļ������㣬������Ч�ļ�
			long addSize = 0; // �ϴ��ļ��ܴ�С
			while (fileItemListIte.hasNext()) {
				FileItem fileItem = (FileItem) fileItemListIte.next();

				// �ϴ�����ѹ����
				if (RAR.equals(fileItem.getContentType())) {
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

					if (unRar(file.getParent() + "/", file.getName())) {// ��ѹ�ɹ�
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
						// Photo photo = new Photo();
						// String[] arr = pics[i].getName().split("\\\\");
						// String detail = arr[arr.length - 1];
						// photo.setDetail(detail.substring(detail.indexOf("_")
						// + 1, detail.lastIndexOf(".")));
						// photo.setCreateDate(new Date());
						// photo.setUserId(userId);
						// photo.setPhotoSize(pics[i].length());
						// photo.setAlbum(album);
						// photo.setResize(0);
						// photo.setExt(ext);
						// photoService.save(photo);
						// photo.setPhotoOrder(photo.getPid());

						addSize += pics[i].length();

						// ����ͼƬurl
						// StringBuffer url = new
						// StringBuffer(InitServlet.constant.getProperty("url"));
						// url.append(p + "/album/");
						// url.append(album.getAid() + "/");
						//
						// if (album.getCount() == 0) {
						// album.setCover(url.toString() + photo.getPid() +
						// "_s." + ext);
						// }
						// url.append(photo.getPid());
						// photo.setUrl(url.toString());

						// ���ļ��Ƶ����Ŀ¼
						StringBuffer path1 = new StringBuffer(MyConfig.html_pic_upload_path);
						path1.append(p + "/album/tq");
						// path1.append(album.getAid() + "/");
						// path1.append(photo.getPid());
						path1.append("." + ext);
						File file1 = new File(path1.toString());
						pics[i].renameTo(file1);

						// photoService.update(photo);
						// newPhoto.add(photo);

						// hotStat(album, photo, p);
						addCount++;
					}
				} else {// ͼƬ�ļ�
					String ext = getPicExt(fileItem.getContentType());
					if ("bmp".equals(ext)) {
						ext = "jpg";
					}
					// Photo photo = new Photo();
					String[] arr = fileItem.getName().split("\\\\");
					String detail = arr[arr.length - 1];
					// photo.setDetail(detail.substring(detail.indexOf("_") + 1,
					// detail.lastIndexOf(".")));
					// photo.setCreateDate(new Date());
					// photo.setUserId(userId);
					// photo.setPhotoSize(fileItem.getSize());
					// photo.setAlbum(album);
					// photo.setResize(0);
					// photo.setExt(ext);
					// photoService.save(photo);
					// photo.setPhotoOrder(photo.getPid());

					addSize += fileItem.getSize();

					// StringBuffer url = new
					// StringBuffer(InitServlet.constant.getProperty("url"));
					// url.append(p + "/album/");
					// url.append(album.getAid() + "/");
					//
					// if (album.getCount() == 0) {
					// album.setCover(url.toString() + photo.getPid() + "_s." +
					// ext);
					//
					// }
					// url.append(photo.getPid());
					// photo.setUrl(url.toString());

					StringBuffer path = new StringBuffer(MyConfig.html_pic_upload_path);
					path.append(p + "/album/");
					// path.append(album.getAid() + "/");
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdirs();
					}

					// path.append(photo.getPid());
					path.append(System.currentTimeMillis() + "_" + (Math.random() * 100) + "." + ext);
					File file = new File(path.toString());
					fileItem.write(file);
					if ("image/bmp".equals(fileItem.getContentType())) {
						ImageLinuxUtil.bmpToJpg(path.toString(), path.toString());
					}

					// photoService.update(photo);
					// newPhoto.add(photo);

					// hotStat(album, photo, p);
					addCount++;
				}
			}

			// album.setAlbumSize(album.getAlbumSize() + addSize);
			// album.setCount(album.getCount() + addCount);
			// albumService.updateAlbum(album);
			// ��ӵ�xml
			// XMLManager.addAlbum(album);
			// int spaceCount = photoService.amountPhotoBySpace(1, user);
			// if (spaceCount < 7) {// �ŵ��ռ�
			// for (int i = 0; i < newPhoto.size() && i < 7 - spaceCount; i++) {
			// Photo xp = (Photo) newPhoto.get(i);
			// XMLManager.addPhoto(xp);
			// xp.setSpace(1);
			// photoService.update(xp);
			// }
			// }
			// GeneratorHtml.genEworldNewAlbum(user, album);
			// ���ɾ�̬ҳ��
			// albumService.genListAlbum(user);

			// photoService.genPhotoPage(album, user);

			// Album cntm = albumService.findCntm(user);
			// if (cntm != null) {// cntm����ѡ��
			// GeneratorHtml.genCntmUser(1, user);
			// }
			// request.getSession().setAttribute("invalidFiles", invalidFiles);
			// if (postType != null) {// ����ͼ
			// request.getSession().setAttribute("newPhoto", newPhoto);
			// response.sendRedirect("./post_up_3.action");
			// } else {
			// if (to == null) {// һ���ϴ�
			// response.sendRedirect("./upload_result.action?aid=" +
			// album.getAid());
			// } else if ("wall".equals(to)) {// �ռ䱳��
			// Photo tp = (Photo) newPhoto.get(0);
			// response.sendRedirect("http://zone.17dian.com/zone/uploadbg.action?url="
			// + tp.getUrl() + "."
			// + tp.getExt());
			// } else if ("club".equals(to)) {
			// StringBuffer sb = new StringBuffer();
			//
			// sb.append("<root cid=\"");
			// sb.append(cid);
			// sb.append("\" aid=\"");
			// sb.append(clubAid);
			// sb.append("\" userId=\"");
			// sb.append(user.getUid());
			// sb.append("\">");
			// for (int i = 0; i < newPhoto.size(); i++) {
			// Photo tp = (Photo) newPhoto.get(i);
			// sb.append("<photo>");
			// sb.append("<url>");
			// sb.append(tp.getUrl());
			// sb.append("</url>");
			// sb.append("<ext>");
			// sb.append(tp.getExt());
			// sb.append("</ext>");
			// sb.append("<detail><![CDATA[");
			// sb.append(StringEscapeUtils.escapeXml(tp.getDetail()));
			// sb.append("]]></detail>");
			// sb.append("</photo>");
			// }
			// sb.append("</root>");
			// String result =
			// ConnectService.connect(ConfUtils.getStringValue("clubUpload"),
			// sb.toString());
			// if ("1".equals(result)) {
			// response.sendRedirect("http://team.tqd.17dian.com/club/upload_success.action");
			// } else {
			// response.sendRedirect("http://team.tqd.17dian.com/club/upload_fail.action");
			// }
			// } else {// to=cntm
			// Photo tp0 = (Photo) newPhoto.get(0);
			// Photo tp1 = (Photo) newPhoto.get(1);
			// String s = "http://tm.17dian.com/apply/getimg.action?userId=" +
			// user.getUid() + "&imgurl1="
			// + tp0.getUrl() + "." + tp0.getExt() + "&imgurl2=" + tp1.getUrl()
			// + "." + tp1.getExt();
			// if (newPhoto.size() > 2) {
			// Photo tp2 = (Photo) newPhoto.get(2);
			// s += "&imgurl3=" + tp2.getUrl() + "." + tp2.getExt();
			// }
			// ConnectService.connect(s, "");
			// response.sendRedirect("http://tm.17dian.com/apply/savetook.action");
			// }
			// }
		} catch (Exception e) {
			e.printStackTrace();
			// failRedirect(response, to, aid, cid);

		} finally {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// fu.dispose();
		}
		return SUCCESS;
	}

	private String photoContentType;
	private String photoFileName;
	private File photo;

	public String uploadPic() {
		System.out.println("�ϴ��ļ�:" + photoFileName);
		// תСд����дJPG������
		if (photoFileName != null) {
			photoFileName = photoFileName.toLowerCase();
		}
		String tempName = photoFileName;
		System.out.println("������ϴ��ļ�:" + tempName);
		//
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String subpath = f.format(new Date());
		// ���ؽ�����
		Pic pic = new Pic();
		// �ϴ�����ѹ����
		if (photoContentType.indexOf(RAR) != -1) {
			System.out.println("upload file is rar/zip");
			//
			String tail = tempName.substring(tempName.length() - 4);
			if (!tail.equals(".rar") && !tail.equals(".zip")) {
				pic.setErr("���ϴ���ȷ��ʽ����.rar��.zip��β");
				return AJAX;
			}
			// �ļ�������������׺
			subpath = subpath + "/" + System.currentTimeMillis() + "_" + tempName.substring(0, tempName.indexOf(tail));
			// ����Ŀ¼
			String savePath = MyConfig.html_pic_upload_path + "/" + subpath + "/";
			File dir = new File(savePath);
			if (!dir.exists())
				dir.mkdirs();
			//
			File file = new File(savePath + tempName);
			photo.renameTo(file);
			// ��ѹ�ļ�
			Boolean boo = false;
			if (isLinux()) {
				System.out.println("os is linux");
				boo = this.unRar(file.getParent() + "/", file.getName());
			} else {
				System.out.println("os is windox");
				boo = UnrarUtil.decompressionRarFiles(file.getPath(), file.getParent() + "/");
			}
			// ��ѹ�ɹ�
			if (boo) {
				System.out.println("extract success:" + file.getPath());
				file.delete();
				// ��ѹʧ�ܣ��Ƿ��ļ�
			} else {
				// InvalidFile invalidFile = new InvalidFile("�Ƿ��ļ�",
				// photoFileName);
				// invalidFiles.add(invalidFile);
				System.out.println("extract fail:" + file.getPath());
				file.delete();
			}
			// �����ѹ���Ŀ¼���������ļ��Ƶ�һ��Ŀ¼
			searchFile(0, savePath, savePath);
			// url����Ŀ¼Ŀ¼��ǰ̨��Ҫ
			//pic.setUrlPath(MyConfig.www_ct_url + "/upload/" + subpath + "/");
			//
			int addSize = 0;
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> icons = new ArrayList<String>();
			//
			String err = null;
			// ���浽db
			File pics[] = dir.listFiles();
			for (int i = 0; i < pics.length; i++) {
				File p = pics[i];
				String pName = p.getName();
				pName = pName.toLowerCase();
				// ��д-->Сд
				if (!pName.equals(p.getName())) {
					p.renameTo(new File(p.getParent() + "/" + pName));
				}
				// ɾ����ͼƬ�ļ�
				if (!ImageUtil.isPicture(pName, null)) {
					p.delete();
					if (err == null)
						err = "ɾ����ͼƬ�ļ���" + pName;
					else
						err += "," + pName;
					continue;
				}
				// ��С
				addSize += p.length();
				//
				names.add(pName);
				// ˮӡ ����
				String iconName = "";
				for (int j = 0; j < IconUtil.iconList().size(); j++) {
					iconName = ImageUtil.zoomToIcon(p, IconUtil.iconList().get(j).getWidth(), IconUtil.iconList()
							.get(j).getHeigth());
				}
				// ImageUtil.pressTextForCT(p.getPath());//ˮӡ ������ֻ�У����ź��ͼû��ˮӡ
				icons.add(iconName);
				// ����DB
				String insertPic = "ct1/" + subpath + "/" + pName;
				// ...
			}
			
			Collections.sort(names);
			Collections.sort(icons);
			//
			String nameStr = "";
			for (int i = 0; i < names.size(); i++) {
				String file2 = names.get(i);
				nameStr += " > "+ file2;
			}
			System.out.println(" 1 >>> names :"+nameStr);
			
			
			pic.setNames(names);
			pic.setIcons(icons);
			//
			//pic.setIcon(MyConfig.www_ct_url + "/upload/rar.jpg");
			//
			if (err == null)
				err = "�ϴ��ɹ�:" + photoFileName;
			pic.setErr("�ϴ��ɹ���" + photoFileName);
		} else if (getPicExt(photoContentType) != null) {
			// ������
			tempName = newPhotoName(photoFileName);
			// Ŀ¼
			String dataDir = MyConfig.html_pic_upload_path;
			//
			File savedFile = new File(dataDir + "/" + subpath, tempName);
			File saveDir = new File(savedFile.getParent());
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			photo.renameTo(savedFile);
			// �������ݿ�
			String insertPic = "ct1/" + subpath + "/" + tempName;

			// ���ص�ҳ��
			// setAjax(MyConfig.www_ct_url+"/upload/"+dt+"/"+tempName);

			// ����
			String iconName = "";
			for (int i = 0; i < IconUtil.iconList().size(); i++) {
				iconName = ImageUtil.zoomToIcon(savedFile, IconUtil.iconList().get(i).getWidth(), IconUtil.iconList()
						.get(i).getHeigth());
			}
			// ImageUtil.pressTextForCT(savedFile.getPath());//ˮӡ
			// ������ֻ�У����ź��ͼû��ˮӡ
			// String iconName = ImageUtil.zoomToIcon(savedFile, 0, 0);
			//
			//pic.setName(MyConfig.www_ct_url + "/upload/" + subpath + "/" + tempName);
			//pic.setIcon(MyConfig.www_ct_url + "/upload/" + subpath + "/" + iconName);
		} else {
			pic.setErr("���ϴ�һ��ͼƬ����rarѹ����");
		}
		JSONObject json = JSONObject.fromObject(pic);
		setAjax(json.toString());
		return AJAX;
	}

	// ͬ��
	// ArrayList map=new ArrayList();
	// map.add(carCatalog);
	// map.add(carMan);
	// response.setContentType("text/html;charset=gbk");
	// PrintWriter out = response.getWriter();
	// JSONArray json = JSONArray.fromObject(map);
	// out.print(json.toString());
	// out.close();

	// �첽
	// public void getMainTree() throws IOException{
	// TreeMap<String, List<HashMap<String, Object>>> mianmap =
	// CarImageService.getInstance().getMainCar();
	// response.setContentType("text/html;charset=gbk");
	// PrintWriter out = response.getWriter();
	// JSONArray json = JSONArray.fromObject(mianmap);
	// String jsonp=request.getParameter("jsonpcallback");
	// out.print(jsonp+"("+json.toString()+")");
	// }

	public static String newPhotoName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
		return sdf.format(new Date()) + fileName.hashCode() + fileName.substring(fileName.lastIndexOf("."));
	}

	public String urlEditV() {
		System.out.println("urlEditV");
		return SUCCESS;
	}

	public String imgEditV() {
		System.out.println("imgEditV");
		return SUCCESS;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	// �Ƿ���linuxϵͳ
	private static Boolean isLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os.toLowerCase().indexOf("windows") != -1)
			return false;
		return true;
	}

	//
	private boolean unRar(String fdir, String fname) {
		// StringBuffer sb = new StringBuffer();
		System.out.println("unRar:" + fdir + fname);
		String result = "";
		try {
			Process process = null;
			String commStr = "";
			// unzip -o test.zip -d tmp/
			// ��ѹ���ļ�test.zip��ָ��Ŀ¼tmp�½�ѹ�������������ͬ���ļ����ڣ�Ҫ��unzip�����ԭ�ȵ��ļ���
			if (fname.indexOf(".zip") != -1) {
				commStr = "unzip -o " + fdir + fname + " -d " + fdir;
				System.out.println("commond:" + commStr);
				process = Runtime.getRuntime().exec(commStr);
				result = doWaitFor(process);
				System.out.println("extract .zip file result:" + result);
				return true;
				// System.out.println("result unzip:" + result);
			} else if (fname.indexOf(".rar") != -1) {
				// ��Ҫ��װ rarlinux -o+ ���ǲ�����
				commStr = "rar e -o+ " + fdir + fname + " " + fdir;
				System.out.println("commond:" + commStr);
				process = Runtime.getRuntime().exec(commStr);
				result = doWaitFor(process);
				System.out.println("extract .rar file result:" + result);
				if (result.indexOf("All OK") != -1) {
					return true;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
					e.printStackTrace();
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

	private static void searchFile(int id, String toDir, String fPath) {
		File dir = new File(fPath);
		File pics[] = dir.listFiles();
		// dir���ļ�
		if (pics == null) {
			dir.renameTo(new File(toDir +  dir.getName()));
			return;
		}
		for (int i = 0; i < pics.length; i++) {
			searchFile(id++, toDir, pics[i].getPath());
		}
		dir.delete();
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

	public String ueUploadPic() {
		System.out.println("ueUploadPic()");
		String tempName = "";
		//
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String subpath = f.format(new Date());
		// ���ؽ�����
		Pic pic = new Pic();
		if (photoContentType != null && "image/jpeg".equals(photoContentType)) {
			// ������
			tempName = newPhotoName(photoFileName);
			// Ŀ¼
			String dataDir = MyConfig.html_pic_upload_path;
			//
			File savedFile = new File(dataDir + "/" + subpath, tempName);
			File saveDir = new File(savedFile.getParent());
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			photo.renameTo(savedFile);
			// �������ݿ�
			String insertPic = "ct1/" + subpath + "/" + tempName;

			// ���ص�ҳ��
			// setAjax(MyConfig.www_ct_url+"/upload/"+dt+"/"+tempName);

			// ����
			String iconName = "";
			for (int i = 0; i < IconUtil.iconList().size(); i++) {
				iconName = ImageUtil.zoomToIcon(savedFile, IconUtil.iconList().get(i).getWidth(), IconUtil.iconList()
						.get(i).getHeigth());
			}
			// String iconName = ImageUtil.zoomToIcon(savedFile, 0, 0);
			//
//			pic.setName(MyConfig.www_ct_url + "/upload/" + subpath + "/" + tempName);
//			pic.setIcon(MyConfig.www_ct_url + "/upload/" + subpath + "/" + iconName);
		} else {
			pic.setErr("���ϴ�һ��ͼƬ����rarѹ����");
		}
		JSONObject json = JSONObject.fromObject(pic);
		setAjax(json.toString());
		return AJAX;
	}

}
