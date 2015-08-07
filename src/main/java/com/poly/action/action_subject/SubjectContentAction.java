package com.poly.action.action_subject;

import java.util.Date;

import car_beans.DboSubContent;
import car_beans.DboSubContent315;
import car_daos.DboSubContent315Dao;
import car_daos.DboSubContentDao;

import com.poly.action.MyActionSupport;
import com.poly.service.SubjectService;

public class SubjectContentAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String contentid;
	private DboSubContent content;
	private String subjectId;
	
	//添加专题内容
	public String toAddSubjectContent(){
		return "toAddSubjectContent";
	}
	
	public String addSubjectContent() throws Exception{
		content.setLastvisittime(new Date());
		content.setIsdelete(0);
		content.setStype(2);
		SubjectService.insertSubjectContent(content);
		subjectId = content.getPname().substring(content.getPname().indexOf("_")+1);
		return "addSubjectContent";
	}
	
	//修改专题内容
	public String toUpdateSubjectContent(){
		String subsql = "id = '"+contentid+"'";
		content = DboSubContentDao.where(subsql).get(0);
		return "toUpdateSubjectContent";
	}
	                                   
	public String updateSubjectContent() throws Exception{
		SubjectService.updateSubjectContentById(content);
		subjectId = content.getPname().substring(content.getPname().indexOf("_")+1);
		return "updateSubjectContent";
	}
	
	//删除专题内容
	public String deleteSubjectContent(){
		SubjectService.deleteSubjectContentById(contentid);
		return "deleteSubjectContent";
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

	public DboSubContent getContent() {
		return content;
	}

	public void setContent(DboSubContent content) {
		this.content = content;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	
	

}
