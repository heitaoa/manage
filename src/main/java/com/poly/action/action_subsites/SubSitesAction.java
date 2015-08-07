package com.poly.action.action_subsites;

import java.util.List;

import car_beans.TbSubSites;
import car_daos.TbSubSitesDao;

import com.poly.action.MyActionSupport;
import com.poly.exception.BusinessException;
import com.poly.service.SubSitesService;
import com.poly.util.PageUtil;

public class SubSitesAction extends MyActionSupport{

	private int page = 1;
	private int pageCount;
	private List<TbSubSites> list;
	private int id;
	private TbSubSites tbSubSites = new TbSubSites();
	private String errorMsg = "";
	
	/**
	 * 分站列表
	 * @return
	 */
	public String list() {
		int startIndex = PageUtil.calStartIndex(page);
		list = TbSubSitesDao.where(" 1=1 order by id desc limit "+startIndex+",10");
		int count = TbSubSitesDao.whereCount(" 1=1 ");
		// 计算总页数
		pageCount = PageUtil.calPages(count);
		return SUCCESS;
	}
	
	/**
	 * 分站新增或修改
	 * @return
	 * @throws Exception 
	 */
	public String save() throws Exception {
		if(tbSubSites.getId() > 0) {
			// 更新
			SubSitesService.getInstance().update(tbSubSites);
		} else {
			// 新增
			try {
				SubSitesService.getInstance().insert(tbSubSites.getName());
			} catch(BusinessException e) {
				errorMsg = e.getMessage();
				return ERROR;
			}
		}
		return SUCCESS;
	} 

	/**
	 * 跳转到分站编辑页
	 * @return
	 */
	public String toSave() {
		if(id > 0) {
			List<TbSubSites> list = TbSubSitesDao.where("id=" + id);
			if(list.size() == 1) {
				tbSubSites = list.get(0);
			}
		} 
		
		return SUCCESS;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<TbSubSites> getList() {
		return list;
	}

	public void setList(List<TbSubSites> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TbSubSites getTbSubSites() {
		return tbSubSites;
	}

	public void setTbSubSites(TbSubSites tbSubSites) {
		this.tbSubSites = tbSubSites;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
