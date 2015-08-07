package com.poly.tool;

import cdn.MyCdnUtil;

import com.poly.action.MyActionSupport;

public class CdnAction extends MyActionSupport {

	private String url;

	@Override
	public String execute() throws Exception {
		// String[] urls={"http://inf.315che.com/n/"+ dateStr + "/" +
		// news.getId() + "/"};
		// System.out.println(flushCdn(urls));
		String res = "";
		if (url == null || url.length() < 1)
			return "参数错误";

		res = url + "<br>刷新结果:";
		String[] urls = { url };
		res += MyCdnUtil.flushCdn(urls);
		setAjax(res);
		return AJAX;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
