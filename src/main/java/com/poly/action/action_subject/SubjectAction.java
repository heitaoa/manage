package com.poly.action.action_subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import car_beans.DboSubContent;
import car_beans.DboSubContent315;
import car_beans.DboZhtContent;
import car_daos.DboSubContentDao;
import car_daos.DboZhtContentDao;

import com.poly.action.MyActionSupport;
import com.poly.service.SubjectService;

public class SubjectAction extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//获取专题
	//private List<DboPubSubject> subjectList;
	private List<DboZhtContent> subjectList;
	//专题
	//private DboPubSubject subject;
	private DboZhtContent subject;
	
	//专题模块列表
	//private List<DboPubMould> mouldList;
	//专题ID
	private String subjectId;
	private int page=1;
	private int pageCount;
	private String type;
	
	private String mould;
	
	//专题内容
	private List<DboSubContent> subjectContentList;
	
	
	//获取专题列表
	public String subject(){
		//subjectList = SubjectService.getSubjectList(0,10);
		int from = 0;
		int count = SubjectService.getAllSubjectCount();
		from = (page-1)*10;
		pageCount = count/10 +1;
		subjectList = SubjectService.getAllSubjectList(from,10);
		return "subject";
	}
	
	//添加专题
	public String toAddSubject(){
		//获取可选模板数据
		String subsql = "isdelete = 0 and ishead = 0 and type = '展会'";
		subjectList = DboZhtContentDao.where(subsql);
		return "toAddSubject";
	}

	public String addSubject() throws Exception{
		subject.setAdddate(new Date());
		subject.setIsdelete(0);
		subject.setIsshow(0);
		SubjectService.saveSubject(subject);
		//判断模板在数据库中是否存在
		if(mould!=null&&!"".equals(mould)){
			int id = SubjectService.selectMaxId(subject.getContent());
			String subsql = "isdelete=0 and pname = 'zt_"+mould+"'";
			subjectContentList = DboSubContentDao.where(subsql);
			for(DboSubContent content : subjectContentList){
				content.setPname("zt_"+id);
				SubjectService.insertSubjectContent(content);
			}
		}
		return "addSubject";
	}
	
	//更新专题
	public String toUpdateSubject(){
		String subsql = " id = '"+subjectId+"'";
		subject = DboZhtContentDao.where(subsql).get(0);
		return "toUpdateSubject";
	}

	public String updateSubject(){
		SubjectService.updateSubject(subject);
		return "updateSubject";
	}
	
	//删除专题
	public String deleteSubject(){
		SubjectService.updateSubjectById(subjectId);
		return "deleteSubject";
	}
	
	//获取专题内容
	public String getSubjectContent(){
		String subsql = "isdelete=0 and pname = 'zt_"+subjectId+"'";
		subjectContentList = DboSubContentDao.where(subsql);
		return "getSubjectContent";
	}	
	
	//设置专题为可选模板
	public String setSubjectToMould(){
		SubjectService.setSubjectToMould(subjectId);
		return "setSubjectToMould";
	}	
	public String setSubjectNotToMould(){
		SubjectService.setSubjectNotToMould(subjectId);
		return "setSubjectNotToMould";
	}	
	
	public String publishSubject(){
		SubjectService.genSubjectIndexById(subjectId);
		return "publishSubject";
	}
	
	//查询对应类型的模板
	public void getMouldByType(){
		try {
			type = java.net.URLDecoder.decode(type,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String subsql = "isdelete = 0 and ishead = 0 and type = '"+type+"'";
		subjectList = DboZhtContentDao.where(subsql);
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			JSONArray json = JSONArray.fromObject(subjectList);
			out.write(json.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	public String getMould() {
		return mould;
	}

	public void setMould(String mould) {
		this.mould = mould;
	}

	public List<DboZhtContent> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<DboZhtContent> subjectList) {
		this.subjectList = subjectList;
	}

	public DboZhtContent getSubject() {
		return subject;
	}

	public void setSubject(DboZhtContent subject) {
		this.subject = subject;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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

	public List<DboSubContent> getSubjectContentList() {
		return subjectContentList;
	}

	public void setSubjectContentList(List<DboSubContent> subjectContentList) {
		this.subjectContentList = subjectContentList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
