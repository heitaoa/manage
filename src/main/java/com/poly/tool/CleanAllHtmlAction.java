package com.poly.tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.poly.action.MyActionSupport;
import com.poly.sftp.SFTPChannel;
import com.poly.sftp.SFTPConstants;
import com.poly.sftp.SFTPTest;

@SuppressWarnings("serial")
public class CleanAllHtmlAction extends MyActionSupport {

	@Override
	public String execute() throws Exception {
		// if (isLinux()) {
		// cleanAllHtml();
		// } else {
		// setErr("windows下自行删除!");
		// return ERROR;
		// }
		// setErr("清除完毕!");
		setErr("20150318 >>> 禁止使用!");
		return ERROR;
	}

	//
	private boolean cleanAllHtml() {
		String result = "";
		try {
			Process process = null;
			String commStr = "";
			commStr = "/data/app/nginx/sbin/clean_cache_html.sh";
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

	
}
