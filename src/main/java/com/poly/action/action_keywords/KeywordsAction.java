package com.poly.action.action_keywords;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import car_beans.TbKeywords;

import com.poly.action.MyActionSupport;
import com.poly.service.KeywordsService;

@SuppressWarnings("serial")
public class KeywordsAction extends MyActionSupport {
	public static final int PAGESIZE = 20;
	private List<TbKeywords> keywords;
	private TbKeywords keyword;

	private int counts;
	private int allPage;
	private int curPage;

	public String toPage() {
		keywords = KeywordsService.queryAllKeywords();

		counts = keywords.size();
		allPage = counts / PAGESIZE;
		if (counts % PAGESIZE != 0) {
			allPage++;
		}
		if (allPage < 1) {
			allPage = 1;
		}
		if (curPage < 1) {
			curPage = 1;
		}
		if (curPage > allPage) {
			curPage = allPage;
		}

		int fromIndex = PAGESIZE * (curPage - 1);
		int toIndex = PAGESIZE * curPage;
		if (toIndex > counts) {
			toIndex = counts;
		}
		keywords = keywords.subList(fromIndex, toIndex);
		return "toPage";
	}

	public void toUpdate() {

	}

	public void update() {

	}

	public void delete() throws Exception {
		KeywordsService.deleteById(id);
		PrintWriter out = getOut();
		out.println("OK");
		closeOut();
	}

	private int id;

	public void add() throws Exception {
		PrintWriter out = getOut();
		try {
			KeywordsService.saveKeyword(keyword);
			out.print("OK");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("ERROR");
		}
		closeOut();
	}

	public void valiKW() throws Exception {
		PrintWriter out = getOut();
		boolean htk = KeywordsService.hasThisKeyword(keyword.getKeyword());
		System.out.println(htk);
		out.println(htk);
		closeOut();
	}

	private PrintWriter getOut() throws IOException {
		response.setCharacterEncoding("UTF-8");
		return response.getWriter();
	}

	private void closeOut() throws IOException {
		response.getWriter().close();
	}

	public List<TbKeywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<TbKeywords> keywords) {
		this.keywords = keywords;
	}

	public TbKeywords getKeyword() {
		return keyword;
	}

	public void setKeyword(TbKeywords keyword) {
		this.keyword = keyword;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
