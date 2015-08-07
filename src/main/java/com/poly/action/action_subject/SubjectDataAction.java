package com.poly.action.action_subject;

import java.util.Date;
import java.util.List;

import car_beans.DboSubData;
import car_beans.DboSubData315;
import car_daos.DboSubDataDao;

import com.poly.action.MyActionSupport;
import com.poly.service.SubjectService;

public class SubjectDataAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//专题模块数据
	private DboSubData subjectdata;
	//模板ID
	private String contentid;
	//数据ID
	private String dataId;
	//专题模板数据
	List<DboSubData> subjectdataList;
	
	//添加数据
	public String toAddSubjectData(){
		return "toAddSubjectData";
	}
	public String addSubjectData() throws Exception{
		//SubjectDataService.saveSubjectData(subjectdata);
		//subjectId = String.valueOf(subjectdata.getSid());
		//mouldId = String.valueOf(subjectdata.getMid());
		subjectdata.setAdddate(new Date());
		subjectdata.setIsdelete(0);
		//DboSubDataDao.save(subjectdata);
		SubjectService.insertSubjectData(subjectdata);
		contentid = String.valueOf(subjectdata.getSid());
		return "addSubjectData";
	}
	
	//专题数据列表
	public String subjectData(){
		String subsql = "isdelete = 0 and sid = '"+contentid+"'";
		subjectdataList = DboSubDataDao.where(subsql);
		return "subjectData";
	}
	
	//修改数据
	public String toUpdateSubjectData(){
		String subsql = "id = '"+dataId+"'";
		subjectdata = DboSubDataDao.where(subsql).get(0);
		return "toUpdateSubjectData";
	}
	public String updateSubjectData(){
		SubjectService.updateSubjectData(subjectdata);
		contentid = String.valueOf(subjectdata.getSid());
		return "updateSubjectData";
	}
	
	//删除数据
	public String deleteSubjectData(){
		SubjectService.deleteSubjectData(dataId);
		return  "deleteSubjectData";
	}
	public DboSubData getSubjectdata() {
		return subjectdata;
	}
	public void setSubjectdata(DboSubData subjectdata) {
		this.subjectdata = subjectdata;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public List<DboSubData> getSubjectdataList() {
		return subjectdataList;
	}
	public void setSubjectdataList(List<DboSubData> subjectdataList) {
		this.subjectdataList = subjectdataList;
	}
}
