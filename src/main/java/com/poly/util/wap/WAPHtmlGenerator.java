package com.poly.util.wap;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.poly.dao.che.PageBlockDAO;
import com.poly.util.JsonUtil;
import com.poly.util.MyConfig;

import car_beans.DboSubContent;
import car_beans.DboSubData;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WAPHtmlGenerator {
	public static final String FILE_ENCODING = "UTF-8";
	// System.getProperty("file.encoding");

	public static final String OUT_FILE_ENCODING = "UTF-8";

	public static Template getWAPTemplate(String name) throws IOException {
		String templatePath = getWebRootPath() + File.separator + "WEB-INF"
				+ File.separator + "waptemplate";
		return getTemplate(templatePath, name, FILE_ENCODING, OUT_FILE_ENCODING);
	}

	@SuppressWarnings("unchecked")
	public static void generatorHTML(DboSubContent content) throws Exception {
		String tmpname = content.getTemplatename();
		if (tmpname == null || "".equals(tmpname.trim())) {
			return;
		}
		String outFile = "";//MyConfig.wap_sr_path + content.getHtmlname();
		Map<Object, Object> rootMap = new HashMap<Object, Object>();

//		rootMap.put("wap_ct_url", MyConfig.wap_ct_url);
//		rootMap.put("wap_sr_path", MyConfig.wap_sr_path);
//		rootMap.put("www_ct_url", MyConfig.www_ct_url);
//		rootMap.put("img_che_url", MyConfig.img_che_url);

		try {
			// subData
			List<DboSubData> subDatas = PageBlockDAO
					.queryPagesubDataBySid(content.getId());

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// id 映射
			rootMap.put("dataMap", dataMap);
			// 页面所有subdata
			rootMap.put("subDatas", subDatas);

			List<DboSubData> row_subDatas = null;

			// id 映射
			for (DboSubData data : subDatas) {
				row_subDatas = (List<DboSubData>) dataMap.get(Integer
						.toString(data.getSid()));
				if (row_subDatas == null) {
					row_subDatas = new ArrayList<DboSubData>();
					dataMap.put(Integer.toString(data.getSid()), row_subDatas);
				}
				row_subDatas.add(data);
			}

			Set<String> keys = dataMap.keySet();

			Map<String, String> jsonMap = new HashMap<String, String>();
			for (String key : keys) {
				if (key.matches("\\d+")) {
					jsonMap.put(key + "_json",
							JsonUtil.toJsonString(dataMap.get(key)));
				}
			}
			rootMap.put("jsonMap", jsonMap);
			processToFile(tmpname, outFile, rootMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void processToFile(String tmpname, String outFile,
			Map<Object, Object> rootMap) throws IOException, TemplateException {
		Template getTemplate = getWAPTemplate(tmpname);
		File file = new File(outFile);
		File pFile = file.getParentFile();
		if (!pFile.exists()) {
			pFile.mkdirs();
		}
		PrintWriter out = new PrintWriter(file, "UTF-8");
		getTemplate.process(rootMap, out);
	}

	public static Template getTemplate(String templatePath,
			String templateName, String templateEncoding, String outFileEncoding)
			throws IOException {
		Configuration config = new Configuration();
		config.setNumberFormat("#");
		File file = new File(templatePath);
		config.setDirectoryForTemplateLoading(file);
		// config.setDirectoryForTemplateLoading();
		config.setObjectWrapper(new DefaultObjectWrapper());
		Template template = config.getTemplate(templateName, templateEncoding);
		template.setOutputEncoding(outFileEncoding);

		return template;
	}

	public static String getWebRootPath() {
		return ServletActionContext.//
				getServletContext().getRealPath("/");
	}

}
