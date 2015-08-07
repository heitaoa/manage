package com.poly.action.action_data;

import java.io.IOException;

import car_beans.TbDataProject;
import car_beans.TbDataProjectBl;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class ServiceSaveProjectAction extends MyActionSupport{
	private TbDataProject project;
	private TbDataProjectBl bl;
	public void back(){
		ProjectService projectService = ProjectService.getInstance();
		String back = projectService.updateOrInsert(project);
		try {
			response.getWriter().write(back);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void backBl(){
		ProjectService projectService = ProjectService.getInstance();
		String back = projectService.updateOrInsert(bl);
		try {
			response.getWriter().write(back);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public TbDataProject getProject() {
		return project;
	}
	public void setProject(TbDataProject project) {
		this.project = project;
	}
	public TbDataProjectBl getBl() {
		return bl;
	}
	public void setBl(TbDataProjectBl bl) {
		this.bl = bl;
	}
	
	
}
