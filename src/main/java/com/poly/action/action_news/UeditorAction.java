package com.poly.action.action_news;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.poly.action.MyActionSupport;
import com.poly.bean.Pic;
import com.poly.bean.UeditorImage;
import com.poly.util.IconUtil;
import com.poly.util.ImageUtil;
import com.poly.util.MyConfig;

//���۹���
public class UeditorAction extends MyActionSupport {

	private static final String RAR = "application/octet-stream";

	public static void main(String[] args) {
		File file = new File("d://zzz/test/");
		System.out.println(file.getParent());
		File pics[] = file.listFiles();
		searchFile(0, file.getPath() + "/", file.getPath());
		System.out.println(file.getName());
	}

	public String ueditor() {
		try {

			System.out.println("===========================");
			Map map = this.request.getParameterMap();
			for (Object key : map.keySet()) {
				System.out.println("========1===================" + key.toString());
			}


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

	
	private String upfileContentType;
	private String upfileFileName;
	private File upfile;

	public String uploadimage() {
		System.out.println("�ϴ��ļ�:" + upfileFileName);
		// תСд����дJPG������
		if (upfileFileName != null) {
			upfileFileName = upfileFileName.toLowerCase();
		}
		String tempName = upfileFileName;
		System.out.println("������ϴ��ļ�:" + tempName);
		//
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String subpath = f.format(new Date());
		// ���ؽ�����
		UeditorImage pic = new UeditorImage();
		 if (upfile != null) {
			// ������
			tempName = newPhotoName(upfileFileName);
			// Ŀ¼
			String dataDir = MyConfig.html_pic_upload_path;
			//
			File savedFile = new File(dataDir + "/" + subpath, tempName);
			File saveDir = new File(savedFile.getParent());
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			upfile.renameTo(savedFile);
			// �������ݿ�
			String insertPic = "ct1/" + subpath + "/" + tempName;

			// ���ص�ҳ��
			// setAjax(MyConfig.che_url+"/upload/"+dt+"/"+tempName);

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
//			pic.setName(MyConfig.che_url + "/upload/" + subpath + "/" + tempName);
//			pic.setIcon(MyConfig.che_url + "/upload/" + subpath + "/" + iconName);
		} else {
//			pic.setErr("���ϴ�һ��ͼƬ����rarѹ����");
		}
		 pic.setImageUrl("http://localhost/ueditor/php/controller.php?action=uploadimage");
		 pic.setImagePath("/ueditor/jsp/");
		 pic.setImageFieldName("photo");
		 pic.setImageMaxSize(2048);
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
		return upfileContentType;
	}

	public void setPhotoContentType(String upfileContentType) {
		this.upfileContentType = upfileContentType;
	}

	public String getPhotoFileName() {
		return upfileFileName;
	}

	public void setPhotoFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
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
			dir.renameTo(new File(toDir + dir.getName()));
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
		if (upfileContentType != null && "image/jpeg".equals(upfileContentType)) {
			// ������
			tempName = newPhotoName(upfileFileName);
			// Ŀ¼
			String dataDir = MyConfig.html_pic_upload_path;
			//
			File savedFile = new File(dataDir + "/" + subpath, tempName);
			File saveDir = new File(savedFile.getParent());
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			upfile.renameTo(savedFile);
			// �������ݿ�
			String insertPic = "ct1/" + subpath + "/" + tempName;

			// ���ص�ҳ��
			// setAjax(MyConfig.che_url+"/upload/"+dt+"/"+tempName);

			// ����
			String iconName = "";
			for (int i = 0; i < IconUtil.iconList().size(); i++) {
				iconName = ImageUtil.zoomToIcon(savedFile, IconUtil.iconList().get(i).getWidth(), IconUtil.iconList()
						.get(i).getHeigth());
			}
			// String iconName = ImageUtil.zoomToIcon(savedFile, 0, 0);
			//
			pic.setName(MyConfig.che_url + "/upload/" + subpath + "/" + tempName);
			pic.setIcon(MyConfig.che_url + "/upload/" + subpath + "/" + iconName);
		} else {
			pic.setErr("���ϴ�һ��ͼƬ����rarѹ����");
		}
		JSONObject json = JSONObject.fromObject(pic);
		setAjax(json.toString());
		return AJAX;
	}

	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

}
