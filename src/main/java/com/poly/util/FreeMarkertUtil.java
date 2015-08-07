package com.poly.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * ģ�幤����
 */
public class FreeMarkertUtil {
	public static final String FILE_ENCODING = System
			.getProperty("file.encoding");

	public static final String OUT_FILE_ENCODING = "UTF-8";

	/**
	 * Webʹ�ã�ģ�����ڵ�Ŀ¼��WebRoot
	 * 
	 * @param tmpname
	 *            �����WebRoot��·����
	 * @return
	 * @throws IOException
	 */
	public static Template getTemplate(String tmpname) throws IOException {
		String templatePath = getWebRootPath();
		return getTemplate(templatePath, tmpname, FILE_ENCODING,
				OUT_FILE_ENCODING);
	}

	public static void processToFile(String tmpname, String outFile,
			Map<Object, Object> rootMap) throws IOException, TemplateException {
		Template getTemplate = getTemplate(tmpname);
		File file = new File(outFile);
		File pFile = file.getParentFile();
		if (!pFile.exists()) {
			pFile.mkdirs();
		}
		PrintWriter out = new PrintWriter(file);
		getTemplate.process(rootMap, out);
	}

	/**
	 * 
	 * 
	 * @param templatePath
	 * @param templateName
	 * @param templateEncoding
	 * @return
	 * @throws IOException
	 */
	public static Template getTemplate(String templatePath,
			String templateName, String templateEncoding, String outFileEncoding)
			throws IOException {
		Configuration config = new Configuration();
		// ���ָ�ʽ��
		config.setNumberFormat("#");
		File file = new File(templatePath);
		// ����Ҫ������ģ�����ڵ�Ŀ¼��������ģ���ļ�
		config.setDirectoryForTemplateLoading(file);
		// config.setDirectoryForTemplateLoading();
		// ���ð�װ�������������װΪ����ģ��
		config.setObjectWrapper(new DefaultObjectWrapper());
		// ��ȡģ��,�����ñ��뷽ʽ������������Ҫ��ҳ���еı����ʽһ��
		Template template = config.getTemplate(templateName, templateEncoding);
		template.setOutputEncoding(outFileEncoding);

		return template;
	}

	public static String getWebRootPath() {
		return ServletActionContext.//
				getServletContext().getRealPath("/");
	}

	/**
	 * @param templatePath
	 *            ģ���ļ����Ŀ¼
	 * @param templateName
	 *            ģ���ļ�����
	 * @param root
	 *            ����ģ�͸�����
	 * @param templateEncoding
	 *            ģ���ļ��ı��뷽ʽ
	 * @param out
	 *            �����
	 */
	public static void processTemplate(String templatePath,
			String templateName, String templateEncoding, Map<?, ?> root,
			Writer out) {
		try {
			Configuration config = new Configuration();
			File file = new File(templatePath);
			// ����Ҫ������ģ�����ڵ�Ŀ¼��������ģ���ļ�
			config.setDirectoryForTemplateLoading(file);
			// config.setDirectoryForTemplateLoading();
			// ���ð�װ�������������װΪ����ģ��
			config.setObjectWrapper(new DefaultObjectWrapper());

			// ��ȡģ��,�����ñ��뷽ʽ������������Ҫ��ҳ���еı����ʽһ��
			Template template = config.getTemplate(templateName,
					templateEncoding);
			// �ϲ�����ģ����ģ��
			template.process(root, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}