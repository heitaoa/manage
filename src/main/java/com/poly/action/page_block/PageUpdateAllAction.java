package com.poly.action.page_block;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import car_beans.DboSubContent;
import car_beans.DboSubData;
import car_daos.DboSubContentDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.subDaos.DboSubDataSubDao;
import com.poly.service.SubContentService;
import com.poly.util.HtmlGenerator;

@SuppressWarnings("serial")
public class PageUpdateAllAction extends MyActionSupport {

	@Override
	public String execute() throws Exception {
		List<DboSubContent> contents = DboSubContentDao.find();
		int su = 0;
		int er = 0;
		for (DboSubContent content : contents) {
			List<DboSubData> list = DboSubDataSubDao
					.where(" isdelete=0 and sid=" + content.getId()
							+ " order by sortid desc");
			for (DboSubData dboSubData : list) {
				String str = dboSubData.getContent();
				if (str != null) {
					Pattern p = Pattern.compile("\r|\n");
					Matcher m = p.matcher(str);
					dboSubData.setContent(m.replaceAll(""));
				}
			}
			Object[] param = list.toArray();
			try {
				print(content, param);
				System.out.println(content.getPname() + " ... ");
				su++;
			} catch (Exception e) {
				er++;
				e.printStackTrace();
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.println("refresh success: " + su + " pages, error: " + er
				+ " pages!");
		out.close();
		return null;
	}

	private void print(DboSubContent content, Object[] param) throws Exception {
		Object[] objArr = { param };
		if (content.getPlace() != null
				&& content.getPlace().indexOf("index") != -1) {
			Map<String, List<DboSubData>> dataMap = SubContentService
					.queryIndexDATA();
			HtmlGenerator.genIndex(content, objArr, dataMap);
		} else {
			HtmlGenerator.genBlockjs(content, objArr);
		}
	}
}
