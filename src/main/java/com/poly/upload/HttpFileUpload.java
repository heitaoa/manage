package com.poly.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 * ���������������ṩ��Ӧ��Ϣ
 */
public class HttpFileUpload extends FileUpload {
	// ��Ĭ�ϲ����ļ�
	public static ResourceBundle config = ResourceBundle.getBundle("upload-config");

	private static final long K = 1024;

	private static final long M = 1024 * 1024;

	// Ĭ�ϵĵ����ļ���С���ƣ�0Ϊ�����ƣ������ļ��д�ŵ�ΪString����
	private long fileLimitSize = getByteSize(config.getString("fileLimitSize"));

	// Ĭ�ϵ��ļ��ϴ���������
	private String allowFileTypes = config.getString("allowFileTypes");

	// private String allowFiles = null; // �����ϴ����ļ����ͣ�null��ʾ������
	private boolean allowField = false; // �Ƿ���������ļ���Ĭ��Ϊ��

	private int reportLimitSize = 10240; // ��С���泤�ȣ�Ĭ��Ϊ10K

	private StreamReport streamReport = null; // �ϴ����ȴ������

	public HttpFileUpload() {
		super();
		setSizeMax(getByteSize(config.getString("onceMaxSize")));
	}

	public HttpFileUpload(FileItemFactory fileItemFactory) {
		super(fileItemFactory);
		setSizeMax(getByteSize(config.getString("onceMaxSize")));
	}

	public long getFileLimitSize() {
		return fileLimitSize;
	}

	public void setFileLimitSize(long fileLimitSize) {
		this.fileLimitSize = fileLimitSize;
	}

	public static long getByteSize(String size) {
		String unit = size.substring(size.length() - 1).toUpperCase();
		String num;
		if (unit.equals("K")) {
			num = size.substring(0, size.length() - 1);
			return Long.parseLong(num) * HttpFileUpload.K;
		} else if (unit.equals("M")) {
			num = size.substring(0, size.length() - 1);
			return Long.parseLong(num) * HttpFileUpload.M;
		} else {
			return Long.parseLong(size);
		}
	}

	/**
	 * @return [String] �����ϴ����ļ�����
	 */
	public String getAllowFileTypes() {
		return allowFileTypes;
	}

	/**
	 * ���������ϴ����ļ����ͣ�Ĭ����""��������
	 * 
	 * @param allowFileTypes
	 */
	public void setAllowFileTypes(String allowFileTypes) {
		this.allowFileTypes = allowFileTypes;
	}

	public void addAllowFileTypes(String allowFileTypes) {
		this.allowFileTypes += ("," + allowFileTypes);
	}

	/**
	 * �����Ƿ��������س�file�����field������
	 * 
	 * @param allow
	 */
	public void setAllowField(boolean allow) {
		allowField = allow;
	}

	/**
	 * @return [boolean] �Ƿ��������س�file�����field
	 */
	public boolean isAllowField() {
		return allowField;
	}

	/**
	 * ������С���泤�ȣ��������Ӱ�챨��Ƶ�ȣ�Ĭ����10K
	 * 
	 * @param reportLimitSize
	 */
	public void setReportLimitSize(int reportLimitSize) {
		this.reportLimitSize = reportLimitSize;
	}

	public int getReportLimitSize() {
		return reportLimitSize;
	}

	/**
	 * �ϴ���������
	 */
	public void dispose() {
		if (streamReport != null)
			streamReport.dispose();
	}

	/**
	 * ����ϴ����� ����allowFieldֵ�����Ƿ���ճ�file���������field��������ϴ����ļ��Ƿ�Ϊ������ļ�
	 * 
	 * @param request
	 * @return
	 * @throws FileUploadException
	 * @throws IOException
	 */
	public List parseRequest(HttpServletRequest request, List invalidFiles) throws FileUploadException {
		ServletRequestContext ctx = new ServletRequestContext(request);
		if (ctx == null) {
			throw new NullPointerException("HttpFileUpload(parseRequestEx): ctx parameter");
		}
		ArrayList items = new ArrayList();
		String contentType = ctx.getContentType();
		if ((null == contentType) || (!contentType.toLowerCase().startsWith(MULTIPART))) {
			throw new InvalidContentTypeException("HttpFileUpload(parseRequestEx): the request doesn't contain a "
					+ MULTIPART_FORM_DATA + " or " + MULTIPART_MIXED + " stream, content type header is " + contentType);
		}
		long requestSize = ctx.contentLength();
		if (requestSize == -1) {
			throw new UnknownSizeException("�������ݴ�Сδ֪���ϴ�����ֹ��");
		}
		long sizeMax = getSizeMax();
		if (sizeMax > 0 && requestSize > sizeMax) {
			throw new SizeLimitExceededException("�����ļ��ܴ�С [ " + requestSize + " ] �����޶� [ " + sizeMax + " ]���ϴ�����ֹ��",
					requestSize, sizeMax);
		}

		String charEncoding = getHeaderEncoding();
		if (charEncoding == null) {
			charEncoding = ctx.getCharacterEncoding();
		}

		try {
			byte[] boundary = getBoundary(contentType);
			if (boundary == null) {
				throw new FileUploadException("the request was rejected because " + "no multipart boundary was found");
			}

			streamReport = new StreamReport(request);
			streamReport.init();
			streamReport.setReportLimitSize(reportLimitSize);

			InputStream input = ctx.getInputStream();
			InputSteamEx inputEx = new InputSteamEx(input, streamReport);
			MultipartStream multi = new MultipartStream(inputEx, boundary);
			multi.setHeaderEncoding(charEncoding);

			boolean nextPart = multi.skipPreamble();
			while (nextPart) {
				Map headers = parseHeaders(multi.readHeaders());
				String fieldName = getFieldName(headers);
				if (fieldName != null && fieldName.equals("file")) {
					String subContentType = getHeader(headers, CONTENT_TYPE);
					if (subContentType != null && subContentType.toLowerCase().startsWith(MULTIPART_MIXED)) {
						// Multiple files.
						// ����һ�㴫���ļ�ʱ�����õ���multipart/form-data���������ﲻ�����
						byte[] subBoundary = getBoundary(subContentType);
						multi.setBoundary(subBoundary);
						boolean nextSubPart = multi.skipPreamble();
						while (nextSubPart) {
							headers = parseHeaders(multi.readHeaders());
							if (getFileName(headers) != null) {
								FileItem item = createItem(headers, false);
								OutputStream os = item.getOutputStream();
								try {
									multi.readBodyData(os);
								} finally {
									os.close();
								}
								items.add(item);
							} else {
								// Ignore anything but files inside
								// multipart/mixed.
								multi.discardBodyData();
							}
							nextSubPart = multi.readBoundary();
						}
						multi.setBoundary(boundary);
					} else {
						// �����ļ�ʱ�����õ���multipart/form-data��������Ҫ����������
						String fileName = getFileName(headers);

						if (fileName == null || fileName.length() == 0) {
							nextPart = multi.readBoundary();
							continue;
						}
						FileItem item = createItem(headers, fileName == null);
						if (item.isFormField()) // ���ļ���
						{
							OutputStream os = item.getOutputStream();
							try {
								multi.readBodyData(os);
							} finally {
								os.close();
							}
							if (this.allowField) {
								items.add(item);
							}
						} else
						// �ļ���
						{
							String fileContentType = item.getContentType();
							if (!isAllowFileType(fileContentType)) // �����������ϴ����ļ�����
							{
								invalidFiles.add(new InvalidFile("�Ƿ����ļ��ϴ����� [ " + fileContentType + " ]", fileName));
								nextPart = multi.readBoundary();
								continue;
							}
							OutputStream os = item.getOutputStream();
							try {
								streamReport.setCurrentUploadFileName(fileName);
								multi.readBodyData(os);
							} finally {
								os.close();
							}
							long fileSize = item.getSize(); // getSize������ǰ�����
							if (fileSize > this.fileLimitSize && this.fileLimitSize > 0) {
								invalidFiles.add(new InvalidFile("���������ļ���С���ƣ��ļ���С[ " + fileSize / 1024 + "kb ]������Ϊ[ "
										+ this.fileLimitSize / 1024 + "kb ] ", fileName));
								nextPart = multi.readBoundary();
								continue;
							}
							items.add(item);
						}
					}
				} else {
					// Skip this part.
					multi.discardBodyData();
				}
				nextPart = multi.readBoundary();
			}
		} catch (IOException e) {
			throw new FileUploadException("Processing of " + MULTIPART_FORM_DATA + " request failed. " + e.getMessage());
		}
		return items;
	}

	private boolean isAllowFileType(String fileType) {
		if (allowFileTypes.length() > 0 && fileType.trim().length() > 0)
			return allowFileTypes.indexOf(fileType.toLowerCase()) != -1;
		else
			return true;
	}

}
