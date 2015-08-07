package com.poly.action.page_block;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import car_beans.DboSubContent;
import car_beans.DboSubData;

import com.poly.action.MyActionSupport;
import com.poly.dao.che.PageBlockDAO;
import com.poly.util.JsonUtil;

@SuppressWarnings("serial")
public class ChePageModifyAction extends MyActionSupport {

	private int cid;
	private List<DboSubData> subDatas;
	private DboSubContent content;

	public String toPageModify() {
		content = PageBlockDAO.querySubContentById(cid);
		if (content == null) {
			return ERROR;
		}

		subDatas = PageBlockDAO.querySubDatasByCid(cid);

		return SUCCESS;
	}

	private int id;

	public void delete() throws IOException {
		int count = PageBlockDAO.deleteSubDataById(id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(count);
	}

	private DboSubData subData;
	private String SYNC;

	private int sortId_01;
	private int sortId_02;

	public void changeSort() throws IOException {

		boolean isOk = true;

		try {
			PageBlockDAO.changeSorted(sortId_01, sortId_02);
		} catch (Exception e) {
			isOk = false;
		}

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(isOk);
	}

	public String insert() throws Exception {
		if ("SYNC".equals(SYNC)) {
			int sub_id = PageBlockDAO.getSubDataId();
			subData.setId(sub_id);
			subData.setSortid(sub_id);
			// 同步
			int sid = PageBlockDAO.querySubContentById(cid).getSync_id();
			subData.setSid(sid);
			PageBlockDAO.insertSubData(subData);

			subData.setSync_id(sub_id);
		}

		int id = PageBlockDAO.getSubDataId();
		subData.setId(id);
		subData.setSortid(id);
		subData.setSid(cid);
		PageBlockDAO.insertSubData(subData);

		return toPageModify();
	}

	public String update() {
		DboSubData subData = PageBlockDAO
				.querySubDataById(this.subData.getId());

		// title link link_back ctitle clink color pic
		subData.setTitle(this.subData.getTitle());
		subData.setLink(this.subData.getLink());
		subData.setLink_back(this.subData.getLink_back());
		subData.setCtitle(this.subData.getCtitle());
		subData.setClink(this.subData.getClink());
		subData.setColor(this.subData.getColor());
		subData.setPic(this.subData.getPic());
		subData.setAdddate(new Date());

		PageBlockDAO.updateSubData(subData, cid);

		if ("SYNC".equals(SYNC)) {
			// 同步
			DboSubData synSubData = PageBlockDAO.querySubDataById(subData
					.getSync_id());

			synSubData.setTitle(this.subData.getTitle());
			synSubData.setLink(this.subData.getLink());
			synSubData.setLink_back(this.subData.getLink_back());
			synSubData.setCtitle(this.subData.getCtitle());
			synSubData.setClink(this.subData.getClink());
			synSubData.setColor(this.subData.getColor());
			synSubData.setPic(this.subData.getPic());

			PageBlockDAO.updateSubData(synSubData, cid);
		}

		return toPageModify();
	}

	public void toUpdate() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		DboSubData subData = PageBlockDAO.querySubDataById(id);
		String subDataStr = JsonUtil.toJsonString(subData);
		out.println(subDataStr);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public List<DboSubData> getSubDatas() {
		return subDatas;
	}

	public DboSubContent getContent() {
		return content;
	}

	public void setContent(DboSubContent content) {
		this.content = content;
	}

	public void setSubDatas(List<DboSubData> subDatas) {
		this.subDatas = subDatas;
	}

	public DboSubData getSubData() {
		return subData;
	}

	public void setSubData(DboSubData subData) {
		this.subData = subData;
	}

	public int getSortId_01() {
		return sortId_01;
	}

	public void setSortId_01(int sortId_01) {
		this.sortId_01 = sortId_01;
	}

	public int getSortId_02() {
		return sortId_02;
	}

	public void setSortId_02(int sortId_02) {
		this.sortId_02 = sortId_02;
	}

	public String getSYNC() {
		return SYNC;
	}

	public void setSYNC(String sYNC) {
		SYNC = sYNC;
	}

}
