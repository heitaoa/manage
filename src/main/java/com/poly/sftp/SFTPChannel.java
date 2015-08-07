package com.poly.sftp;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPChannel {
	Session session = null;
	Channel channel = null;

	private static final Logger LOG = Logger.getLogger(SFTPChannel.class.getName());

	public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {

		String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
		String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
		String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
		String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

		int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
		if (port != null && !port.equals("")) {
			ftpPort = Integer.valueOf(port);
		}

		JSch jsch = new JSch(); // ����JSch����
		session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // �����û���������ip���˿ڻ�ȡһ��Session����
		LOG.debug("Session created.");
		if (ftpPassword != null) {
			session.setPassword(ftpPassword); // ��������
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config); // ΪSession��������properties
		session.setTimeout(timeout); // ����timeoutʱ��
		session.connect(); // ͨ��Session��������
		LOG.debug("Session connected.");

		LOG.debug("Opening Channel.");
		channel = session.openChannel("sftp"); // ��SFTPͨ��
		channel.connect(); // ����SFTPͨ��������
		LOG.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
				+ ", returning: " + channel);
		return (ChannelSftp) channel;
	}

	public void closeChannel() throws Exception {
		if (channel != null) {
			channel.disconnect();
		}
		if (session != null) {
			session.disconnect();
		}
	}

	//
	public ChannelShell getChannelShell() throws Exception {
		if (session != null) {
			Channel channel = session.openChannel("shell"); // ��SFTPͨ��
			channel.connect(); // ����SFTPͨ��������
			return (ChannelShell) channel;
		}
		return null;
	}

}
