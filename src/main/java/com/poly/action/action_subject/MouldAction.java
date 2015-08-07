package com.poly.action.action_subject;

import java.util.List;
import java.util.Map;

import car_beans.DboPubMould;

import com.poly.action.MyActionSupport;
import com.poly.service.MouldService;
import com.poly.service.SubjectService;

public class MouldAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//模板列表
	private List<DboPubMould> mouldList;
	//专题ID
	private String subjectId;
	//模板
	private DboPubMould mould;
	//模板ID
	private String mouldId;
	//模板ID列表
	private int[] mouldIdList;
	//专题模板ID
	private String smid;
	//专题模板列表
	private List<Map<String,Object>> mapList;
	
	//获取模板列表
	public String toMould(){
		mouldList = MouldService.getMouldList();
		return "toMould";
	}
	//新增模板
	public String toAddMould(){
		return "toAddMould";
	}
	public String addMould(){
		MouldService.saveMould(mould);
		return "addMould";
	}
	//修改模板
	public String toUpdateMould(){
		mould = MouldService.getMouldById(mouldId);
		return "toUpdateMould";
	}
	public String updateMould(){
		MouldService.updateMould(mould);
		return "updateMould";
	}
	//删除模板
	public String deleteMould(){
		MouldService.deleteMould(mouldId);
		return "deleteMould";
	}
	
	//获取专题的模块
	public	String getSubjectMould(){
		mapList = MouldService.getSubjectMouldById(subjectId);
		return "getSubjectMould";
	}
	
	//新增专题模板
	public String toAddSubjectMould(){
		mouldList = MouldService.getMouldList();
		return "toAddSubjectMould";
	}
	public String addSubjectMould(){
		for(int i=0;i<mouldIdList.length;i++){
			MouldService.saveSubjectMould(subjectId,mouldIdList[i]);
		}
		return "addSubjectMould";
	}
	//删除专题模板
	public String deleteSubjectMould(){
		MouldService.deleteSubjectMould(smid);
		return "deleteSubjectMould";
	}
	
	
	
	public DboPubMould getMould() {
		return mould;
	}
	public void setMould(DboPubMould mould) {
		this.mould = mould;
	}
	public List<DboPubMould> getMouldList() {
		return mouldList;
	}
	public void setMouldList(List<DboPubMould> mouldList) {
		this.mouldList = mouldList;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getMouldId() {
		return mouldId;
	}
	public void setMouldId(String mouldId) {
		this.mouldId = mouldId;
	}
	public int[] getMouldIdList() {
		return mouldIdList;
	}
	public void setMouldIdList(int[] mouldIdList) {
		this.mouldIdList = mouldIdList;
	}
	public String getSmid() {
		return smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
	}
	public List<Map<String, Object>> getMapList() {
		return mapList;
	}
	public void setMapList(List<Map<String, Object>> mapList) {
		this.mapList = mapList;
	}
	
}
