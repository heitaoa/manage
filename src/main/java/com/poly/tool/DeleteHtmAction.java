package com.poly.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.poly.action.MyActionSupport;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.MyConfig;

@SuppressWarnings("serial")
public class DeleteHtmAction extends MyActionSupport {

	private static int server;

	private String delFile;

	public static void main(String[] args) {
		// System.out.println(pass_file.contains("ajss"));

		// File file = new File("D:/nginx-1.4.7/che_html/tuku/index.htm");
		// if (file.exists()) {
		// System.out.println("exists");
		// System.out.println(file.delete());
		// }
		//
		// System.out.println("1.2.3.4.5".lastIndexOf("."));

		if ("/auto/sss".indexOf("/auto") > -1)
			System.out.println("11");
		else
			System.out.println("12");

	}

	public String test500() throws Exception {
		System.out.println("DeleteHtmAction.test500()");
		int a = 44 / 0;
		System.out.println(a);
		return SUCCESS;
	}

	public String deleteMobileHtml() throws Exception {

		if (delFile != null) {
			int res = 0;

			String filePath = MyRemoteUtil.getFilePath(delFile);

			if (filePath != null) {
				res = this.delHandler(MyRemoteUtil.m_che_html, filePath);
			}

			if (res == 1)
				setErr(delFile + "删除成功! - " + (new SimpleDateFormat()).format(new Date()));
			else
				setErr(delFile + "删除失败! - " + (new SimpleDateFormat()).format(new Date()));
		}
		return ERROR;
	}

	@Override
	public String execute() throws Exception {

		if (delFile != null) {
			int res = 0;

			String filePath = MyRemoteUtil.getFilePath(delFile);

			// 20150618
			if (MyRemoteUtil.isRefuse(filePath)) {
				setErr("受限制的操作，请联系技术，谢谢！");
				return ERROR;
			}

			if (filePath != null) {
				res = this.delHandler(MyRemoteUtil.che_html, filePath);
			}

			if (res == 1)
				setErr(delFile + "删除成功! - " + (new SimpleDateFormat()).format(new Date()));
			else
				setErr(delFile + "删除失败! - " + (new SimpleDateFormat()).format(new Date()));
		}
		return ERROR;
	}

	private int delHandler(int path, String filePath) {
		int res = 0;
		if (isLinux()) {
			System.out.println(">>> >>> os is linux");
			String commStr = "";
			commStr = "/home/tq/del.sh " + path + " " + filePath + " \n";
			// System.out.println(">>> >>> remove file command:" + commStr);

			if (delFile.indexOf("auto/") > -1) {
				server = MyRemoteUtil.auto315;
				System.out.println(">>> >>> auto315");
			}

			else if (delFile.indexOf("html_dealer/") > -1) {
				server = MyRemoteUtil.ssss315;
				System.out.println(">>> >>> ssss315");
			}

			else {
				server = MyRemoteUtil.www315;
				System.out.println(">>> >>> www315");
			}

			res = MyRemoteUtil.exeCommand(commStr, server);
		} else {
			System.out.println("os is windows");
			Boolean resBoo = delFileHandler(filePath);
			res = resBoo ? 1 : 0;
		}
		return res;
	}

	// //
	// private boolean rmFile(String fname) {
	// String result = "";
	// try {
	// Process process = null;
	// String commStr = "";
	// commStr = "rm -rf " + fname;
	// System.out.println("commond:" + commStr);
	// process = Runtime.getRuntime().exec(commStr);
	// result = doWaitFor(process);
	// System.out.println(commStr + " complete :" + result);
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return false;
	// }

	//
	private boolean delFileHandler(String fname) {
		try {
			File file = new File(fname);
			if (file.exists()) {
				System.out.println("删除文件：" + fname);
				return file.delete();
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String doWaitFor(Process p) {
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

	public String getDelFile() {
		return delFile;
	}

	public void setDelFile(String delFile) {
		this.delFile = delFile;
	}

}
