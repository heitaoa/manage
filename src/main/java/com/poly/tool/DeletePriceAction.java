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
public class DeletePriceAction extends MyActionSupport {

	private static List<String> pass_file;
	
	
	

	private static int server;

	private String delFile;

	static {
		// pass_file = new String[] { "html", "htm", "css", "js" };

		pass_file = new ArrayList<String>();
		pass_file.add("htm");
		pass_file.add("html");
		pass_file.add("css");
		pass_file.add("js");
	}

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

	@Override
	public String execute() throws Exception {

		if (delFile != null) {
			int res = 0;

			String filePath = "/price/";

			if (isLinux()) {
				System.out.println(">>> >>> os is linux");
				String commStr = "";
				commStr = "rm -rf " + filePath + " \n";
				System.out.println(">>> >>> remove file command:" + commStr);

				if (server == 0) {
					if (delFile.indexOf("/auto/") > -1)
						server = MyRemoteUtil.auto315;
					else
						server = MyRemoteUtil.www315;
				}

				res = MyRemoteUtil.exeCommand(commStr, server);
			} else {
				System.out.println("os is windows");
				Boolean resBoo = delFileHandler(filePath);
				res = resBoo ? 1 : 0;
			}

			if (res == 1)
				setErr(delFile + "<br>删除成功! -- " + (new SimpleDateFormat()).format(new Date()));
			else
				setErr(delFile + "<br>删除失败! -- " + (new SimpleDateFormat()).format(new Date()));
		}
		return ERROR;
	}

//	//
//	private boolean rmFile(String fname) {
//		String result = "";
//		try {
//			Process process = null;
//			String commStr = "";
//			commStr = "rm -rf " + fname;
//			System.out.println("commond:" + commStr);
//			process = Runtime.getRuntime().exec(commStr);
//			result = doWaitFor(process);
//			System.out.println(commStr + " complete :" + result);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	//
	private String getFilePath(String delFile) {

		int idx = delFile.lastIndexOf(".");
		String ftype = delFile.substring(idx + 1);

		if (pass_file.contains(ftype)) {
			delFile = delFile.replace(MyConfig.html_che_path, "");
			if (delFile != null && delFile.length() > 1) {
				delFile = MyConfig.html_che_path + delFile;

				delFile = delFile.replace("//", "/");
				return delFile;
			}
		}

		return null;
	}

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

	public static int getServer() {
		return server;
	}

	public static void setServer(int server) {
		DeletePriceAction.server = server;
	}

}
