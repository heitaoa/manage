package com.poly.sftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import car_beans.DboNewNews;
import cdn.MyCdnUtil;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.SftpException;
import com.poly.util.MyConfig;

@SuppressWarnings("unchecked")
public class MyRemoteUtil {

	public static final int che_html = 1;
	public static final int m_che_html = 2;
	public static final int ad_html = 3;

	public static final int www315 = 252;
	public static final int auto315 = 170;
	public static final int ssss315 = 113;

	private static final String contain_html = "js|html|htm"; // css|js|jpg|gif|png|PNG;

	@SuppressWarnings("rawtypes")
	private static final HashMap sftpDetails_auto = new HashMap<String, String>();

	private static final HashMap sftpDetails_www = new HashMap<String, String>();

	private static final HashMap sftpDetails_4s = new HashMap<String, String>();

	private static final HashMap sftpDetails_img = new HashMap<String, String>();

	static {
		//
		sftpDetails_auto.put(SFTPConstants.SFTP_REQ_HOST, "10.237.221.108"); // 170
		sftpDetails_auto.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
		sftpDetails_auto.put(SFTPConstants.SFTP_REQ_PASSWORD, "qiandao@31588");
		sftpDetails_auto.put(SFTPConstants.SFTP_REQ_PORT, "63742");

		sftpDetails_www.put(SFTPConstants.SFTP_REQ_HOST, "10.105.31.126"); // 252
		sftpDetails_www.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
		sftpDetails_www.put(SFTPConstants.SFTP_REQ_PASSWORD, "2971934957");
		sftpDetails_www.put(SFTPConstants.SFTP_REQ_PORT, "22");

		sftpDetails_4s.put(SFTPConstants.SFTP_REQ_HOST, "127.0.0.1"); // 113
		sftpDetails_4s.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
		sftpDetails_4s.put(SFTPConstants.SFTP_REQ_PASSWORD, "qiandao@31588");
		sftpDetails_4s.put(SFTPConstants.SFTP_REQ_PORT, "51960");

		//
		sftpDetails_img.put(SFTPConstants.SFTP_REQ_HOST, "10.131.166.140"); // 97
																			// 图片服务器
		sftpDetails_img.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
		sftpDetails_img.put(SFTPConstants.SFTP_REQ_PASSWORD, "qiandao@31588");
		sftpDetails_img.put(SFTPConstants.SFTP_REQ_PORT, "22");

	}

	private static Map<String, String> sftpDetails = sftpDetails_www;

	public static void sync(String sourceFile, String targetPath) throws Exception {

		sftpDetails = sftpDetails_www;

		SFTPTest test = new SFTPTest();

		SFTPChannel channel = test.getSFTPChannel();
		ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);

		System.out.println(">>> >>> begin ...... ");

		putDirectory(sourceFile, targetPath, chSftp, contain_html);

		chSftp.quit();
		channel.closeChannel();

		System.out.println(">>> >>> done ...... ");

	}

	public static void syncImg(String sourceFile, String targetPath) throws Exception {

		sftpDetails = sftpDetails_img;

		SFTPTest test = new SFTPTest();

		SFTPChannel channel = test.getSFTPChannel();
		ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);

		System.out.println(">>> >>> begin ...... ");

		putDirectory(sourceFile, targetPath, chSftp, contain_html);

		chSftp.quit();
		channel.closeChannel();

		System.out.println(">>> >>> done ...... ");

	}

	// src原文件； dst 目标目录
	public static void putDirectory(String src, String dst, ChannelSftp chSftp, String contain) throws SftpException {
		// 如果服务器目录不存在，需要创建目录
		try {
			chSftp.cd(dst);
		} catch (SftpException sException) {
			// sException.printStackTrace();
			if (ChannelSftp.SSH_FX_NO_SUCH_FILE == sException.id) {
				chSftp.mkdir(dst);
			}
		}
		//
		File file = new File(src);
		File[] dir = file.listFiles();
		// file是文件
		if (dir == null) {

			String f_type = getFileType(src);
			// 匹配上传文件类型
			if (contain.indexOf(f_type) > -1) {
				System.out.println(src + " >>> " + dst);
				// 上传
				// long fileSize = file.length();
				// chSftp.put(src, dst, new FileProgressMonitor(fileSize),
				// ChannelSftp.OVERWRITE);
				chSftp.put(src, dst, ChannelSftp.OVERWRITE);
			}
			return;
		}
		// 目录
		for (int i = 0; i < dir.length; i++) {
			File sub_file = dir[i];
			File[] sub_dir = sub_file.listFiles();
			// 文件
			if (sub_dir == null) {
				putDirectory(sub_file.getPath(), dst, chSftp, contain);
				continue;
			}
			// 目录 需要取目录名
			String sub_name = sub_file.getName();
			putDirectory(src + sub_name + "\\", dst + sub_name + "/", chSftp, contain);
			// System.out.println("subDitr:"+subDir);
		}
	}

	//
	private static String getFileType(String fileUri) {
		File file = new File(fileUri);
		String fileName = file.getName();
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		return fileType;
	}

	/**
	 * 删除单条新闻对应的目录
	 * 
	 * @param news
	 * @return
	 * @throws Exception
	 */
	public static int del(DboNewNews news) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM");
		String dateStr = sdf.format(news.getAdddate());
		String delDir = "/inf/n/" + dateStr + "/" + news.getId() + "/";

		String catalogDir = "/news/" + news.getNewscatalogid() + "/";

		int res = -1;
		int catalog_res = -1;

		if (isLinux()) {
			// String commStr = "rm -rf " + delDir + " \n";
			String commStr = "/home/tq/del.sh " + che_html + " " + delDir + " \n";
			res = exeCommand(commStr, www315);

		} else {
			Boolean resBoo = delFileHandler(delDir);
			res = resBoo ? 1 : -1;

			resBoo = delFileHandler(catalogDir);
			catalog_res = resBoo ? 1 : -1;
		}
		//del.sh脚本中会刷新cdn
//		String[] urls = { "http://inf.315che.com/n/" + dateStr + "/" + news.getId() + "/" };
//		System.out.println(MyCdnUtil.flushCdn(urls));
		return res * 10 + catalog_res;
	}

	public static int exeCommand(String shellCommand, int server) {

		System.out.println(">>> >>> exeCommand() :" + shellCommand);
		System.out.println(">>> >>> server :" + server);

		if (shellCommand.indexOf("rm -rf") != -1) {
			System.out.println(">>> >>> >>> limit command :" + shellCommand);
			return -1;
		}

		if (shellCommand == null || shellCommand.length() < 1)
			return 0;

		SFTPTest test = new SFTPTest();

		Map<String, String> sftpDetails = sftpDetails_www;

		if (server == www315)
			sftpDetails = sftpDetails_www;

		if (server == auto315)
			sftpDetails = sftpDetails_auto;

		if (server == ssss315) {
			// sftpDetails = sftpDetails_4s;

			exeComm(shellCommand);
			return 1;
		}

		SFTPChannel channel = null;
		ChannelSftp chSftp = null;
		try {
			channel = test.getSFTPChannel();
			chSftp = channel.getChannel(sftpDetails, 60000);

			ChannelShell channelShell = channel.getChannelShell();

			if (channelShell != null) {

				// System.out.println("begin exe command: >>> >>>" +
				// channelShell);

				// 获取输入流和输出流
				InputStream instream = channelShell.getInputStream();
				OutputStream outstream = channelShell.getOutputStream();

				outstream.write(shellCommand.getBytes());
				outstream.flush();

				Thread.sleep(1 * 1000);
				System.out.println("exe command res: >>> >>> " + getCommRes(instream));

				outstream.close();
				instream.close();

				channelShell.disconnect();
				return 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (chSftp != null)
				chSftp.quit();
			if (channel != null)
				try {
					channel.closeChannel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return -1;
	}

	private static String getCommRes(InputStream instream) throws UnsupportedEncodingException, IOException, Exception {
		// 获取命令执行的结果
		if (instream.available() > 0) {
			byte[] data = new byte[instream.available()];
			int nLen = instream.read(data);

			if (nLen < 0) {
				throw new Exception("network error.");
			}

			// 转换输出结果并打印出来
			String temp = new String(data, 0, nLen, "iso8859-1");
			return temp;
		}
		return "";
	}

	//
	private static boolean exeComm(String commStr) {
		String result = "";
		try {
			Process process = null;
			System.out.println("commond:" + commStr);
			process = Runtime.getRuntime().exec(commStr);
			result = doWaitFor(process);
			System.out.println(commStr + " complete :" + result);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//
	private static boolean delFileHandler(String fname) {
		try {
			File file = new File(fname);
			if (file.exists()) {
				System.out.println("存在文件：" + fname + "，并删除;");
				return file.delete();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static String doWaitFor(Process p) {
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

	private static Boolean isLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os.toLowerCase().indexOf("windows") != -1)
			return false;
		return true;
	}

	private static List<String> pass_file;
	static {
		// pass_file = new String[] { "html", "htm", "css", "js" };

		pass_file = new ArrayList<String>();
		pass_file.add("htm");
		pass_file.add("html");
		pass_file.add("css");
		pass_file.add("js");
	}

	//
	public static String getFilePath(String delFile) {

		int idx = delFile.lastIndexOf(".");
		String ftype = delFile.substring(idx + 1);

		if (pass_file.contains(ftype)) {
			delFile = delFile.replace(MyConfig.html_che_path, "");
			if (delFile != null && delFile.length() > 1) {
				// delFile = MyConfig.html_che_path + delFile;

				delFile = delFile.replace("//", "/");

				if (delFile.startsWith("/"))
					delFile = delFile.substring(1);

				if (delFile.startsWith("*") || delFile.startsWith("index.htm")) {
					System.out.println(">>> >>> >>> dangerous command:" + delFile);
					return null;
				}

				return delFile;
			}
		}

		return null;
	}

	//不能开放的删除页面，只能通过脚本覆盖
	private static ArrayList<String> refuseHtm;

	static {
		refuseHtm = new ArrayList<String>();
		refuseHtm.add("inf/index.htm");
		refuseHtm.add("pingce/index.htm");
		refuseHtm.add("price/index.htm");
		refuseHtm.add("tuku/index.htm");
		//
		refuseHtm.add("citysite/sh.htm");
		refuseHtm.add("citysite/bj.htm");
		refuseHtm.add("citysite/gz.htm");
		refuseHtm.add("citysite/nanjing.htm");
		refuseHtm.add("citysite/wuhan.htm");
		refuseHtm.add("citysite/chengdu.htm");
		refuseHtm.add("citysite/shenyang.htm");
		refuseHtm.add("citysite/dalian.htm");
		refuseHtm.add("citysite/hefei.htm");
		refuseHtm.add("citysite/hangzhou.htm");
		refuseHtm.add("citysite/suzhou.htm");
		refuseHtm.add("citysite/xuzhou.htm");
		refuseHtm.add("citysite/foshan.htm");
		refuseHtm.add("citysite/jinan.htm");
		refuseHtm.add("citysite/zhengzhou.htm");
		refuseHtm.add("citysite/changsha.htm");
		refuseHtm.add("citysite/qingdao.htm");
		refuseHtm.add("tousu/index.htm");
		
	}

	public static Boolean isRefuse(String delFile) {
		if (delFile == null || delFile.length() < 2)
			return false;
		for (String string : refuseHtm) {
			if (delFile.indexOf(string) != -1)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isRefuse("/inf/index.htm"));
	}
	

}
