package com.poly.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.poly.action.MyActionSupport;
import com.poly.sftp.SFTPChannel;
import com.poly.sftp.SFTPConstants;
import com.poly.sftp.SFTPTest;
import com.poly.util.MyConfig;

@SuppressWarnings("serial")
public class DeleteImgAction extends MyActionSupport {

	private static List<String> pass_file;

	private String delFile;

	static {
		// pass_file = new String[] { "html", "htm", "css", "js" };

		pass_file = new ArrayList<String>();
		pass_file.add("gif");
		pass_file.add("png");
		pass_file.add("jpg");
		
	}

	@Override
	public String execute() throws Exception {

		if (delFile != null) {
			int res = 0;

			String filePath = this.getFilePath(delFile);

			if (isLinux()) {
				System.out.println(">>> >>> os is linux");
				String commStr = "";
				commStr = "rm -rf " + filePath+" \n";
				System.out.println(">>> >>> remove file command:" + commStr);
				res = this.exeShCommand(commStr);
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

	//
	private String getFilePath(String delFile) {

		int idx = delFile.lastIndexOf(".");
		String ftype = delFile.substring(idx + 1);

		if (pass_file.contains(ftype)) {
			delFile = delFile.replace("/data/app/nginx/image/", "");
			if (delFile != null && delFile.length() > 1) {
				delFile = "/data/app/nginx/image/" + delFile;

				delFile = delFile.replace("//", "/");
				return delFile;
			}
		}

		return null;
	}

	private int exeShCommand(String shellCommand) throws Exception {

		if (shellCommand == null || shellCommand.length() < 1)
			return 0;
		//
		HashMap sftpDetails_143 = new HashMap<String, String>();
		sftpDetails_143.put(SFTPConstants.SFTP_REQ_HOST, "182.254.245.97"); 
		sftpDetails_143.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
		sftpDetails_143.put(SFTPConstants.SFTP_REQ_PASSWORD, "qiandao@315");
		sftpDetails_143.put(SFTPConstants.SFTP_REQ_PORT, "22");

		SFTPTest test = new SFTPTest();

		Map<String, String> sftpDetails = sftpDetails_143;

		SFTPChannel channel = test.getSFTPChannel();
		ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);

		ChannelShell channelShell = channel.getChannelShell();
		if (channelShell != null) {

			// 获取输入流和输出流
			InputStream instream = channelShell.getInputStream();
			OutputStream outstream = channelShell.getOutputStream();

			outstream.write(shellCommand.getBytes());
			outstream.flush();
			
			Thread.sleep(5 * 1000);
			System.out.println("linux: >>> \n" + getCommRes(instream));

			outstream.close();
			instream.close();

			channelShell.disconnect();
			return 1;
		}

		chSftp.quit();
		channel.closeChannel();
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
	private boolean delFileHandler(String fname) {
		String result = "";
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
