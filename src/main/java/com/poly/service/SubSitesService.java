package com.poly.service;

import java.util.Date;
import java.util.List;

import car_beans.DboAreCatalog;
import car_beans.DboSubContent;
import car_beans.TbSubSites;
import car_daos.DboAreCatalogDao;
import car_daos.DboSubContentDao;
import car_daos.TbSubSitesDao;

import com.poly.exception.BusinessException;
import com.poly.util.PinyinUtil;
import com.poly.util.TbSequenceUtil;

public class SubSitesService {
	
	private static SubSitesService subSitesService = new SubSitesService();
	
	public static SubSitesService getInstance() {
		return subSitesService;
	}
	
	/**
	 * 更新分站tb_sub_sites，以及dbo_sub_content
	 * @param tbSubSites
	 */
	public void update(TbSubSites tbSubSites) throws Exception {
		if(existNameWhenUpdate(tbSubSites.getId(),tbSubSites.getName())) {
			throw new BusinessException("分站名称已存在");
		}
		
		// 更新分站tb_sub_sites
		updateSubSite(tbSubSites.getId(), tbSubSites.getName());
		
		// 更新分站dbo_sub_content
		updateSubContent(tbSubSites.getId(), tbSubSites.getName());
	}
	
	/**
	 * 新增分站tb_sub_sites，以及dbo_sub_content
	 * @param tbSubSites
	 * @throws Exception 
	 */
	public void insert(String name) throws Exception {
		if(existName(name)) {
			throw new BusinessException("分站名称已存在");
		}
		
		// 新增分站 tb_sub_sites
		TbSubSites subSites = insertSubSites(name);
		
		if(subSites != null) {
			// 新增焦点图4条数据 dbo_sub_content
			insertSubContentList(subSites);
		}
	}
	
	/**
	 * 新增时，是否存在分站名称
	 * @param name
	 * @return
	 */
	public boolean existName(String name) {
		int count = TbSubSitesDao.whereCount(" name = '" + name + "'");
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 更新时，是否存在分站名称
	 * @param id  更新的分站id
	 * @param name 更新的名称
	 * @return
	 */
	public boolean existNameWhenUpdate(int id, String name) {
		int count = TbSubSitesDao.whereCount(" name = '" + name + "' and id <> "+id);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * tb_sub_sites 插入数据
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public TbSubSites insertSubSites(String name) throws Exception {
		int areaid = 0;
		//List<DboAreCatalog> list = DboAreCatalogDao.where("catalogname like '%"+name+"%' order by pathlevel desc");
		List<DboAreCatalog> list = DboAreCatalogDao.where("byname = '"+name+"'");
		if(list.size() > 0) {
			areaid = list.get(0).getCatalogid();
		} else {
			throw new BusinessException("未找到城市");
		}
		TbSubSites tbSubSites = new TbSubSites();
		tbSubSites.setAreaid(areaid);
		tbSubSites.setName(name);
		tbSubSites.setEname(PinyinUtil.converterToSpell(name));
		TbSubSitesDao.save(tbSubSites);
		List<TbSubSites> top1 = TbSubSitesDao.where("1=1 order by id desc limit 0, 1");
		if(top1.size() == 1) {
			return top1.get(0);
		} 
		return null;
	}
	
	/**
	 * 新增到dbo_sub_content 焦点图 共4条数据，例如
 	 *  29978	新车图库	株洲分站/新车图库	4	1		0	2015-01-21 11:01:46		21300		28	0
 	 *  29979	焦点图	    株洲分站/焦点图	    4	1		0	0000-00-00 00:00:00		21300		28	0
 	 *  29980	焦点图下栏	株洲分站/焦点图下栏	4	1		0	0000-00-00 00:00:00		21300		28	0
 	 *  29981	汽车头条	株洲分站/汽车头条	4	1		0	0000-00-00 00:00:00		21300		28	0
	 * 
	 * @param subSites
	 * @throws Exception 
	 */
	public void insertSubContentList(TbSubSites subSites) throws Exception {
		// 新增到dbo_sub_content 焦点图 共4条数据
		insertSubContent(subSites, "新车图库");
		insertSubContent(subSites, "焦点图");
		insertSubContent(subSites, "焦点图下栏");
		insertSubContent(subSites, "汽车头条");
	}
	
	/**
	 * 新增到dbo_sub_content  
	 * @param subSites
	 * @pname DboSubContent.pname
	 * @throws Exception 
	 */
	public void insertSubContent(TbSubSites subSites, String pname) throws Exception {
		// 分站id
		int subSitesId = subSites.getId();
		// 分站名称
		String name = subSites.getName();
		 
		DboSubContent subContent = new DboSubContent();
		subContent.setId(TbSequenceUtil.nextVal("dbo_sub_content"));
		subContent.setPname(pname);
		subContent.setPlace(name + "分站/" + pname);
		subContent.setStype(4);
		subContent.setHtmltype(1);
		subContent.setIsdelete(0);
		subContent.setLastvisittime(new Date());
		//subContent.setDesc("");
		subContent.setParent_id(21300);
		//subContent.setTemplatename("");
		subContent.setSub_sites_id(subSitesId);
		subContent.setSync_id(0);
		DboSubContentDao.save(subContent);
	}
	
	/**
	 * 更新tb_sub_sites name 和 ename 
	 * @param id
	 * @param name
	 */
	public void updateSubSite(int id, String name) {
		int areaid = 0;
		List<DboAreCatalog> list = DboAreCatalogDao.where("byname = '"+name+"'");
		if(list.size() > 0) {
			areaid = list.get(0).getCatalogid();
		} 
		
		TbSubSites tbSubSites = new TbSubSites();
		tbSubSites.setId(id);
		tbSubSites.setName(name);
		if(areaid != 0) {
			tbSubSites.setAreaid(areaid);
		}
		tbSubSites.setEname(PinyinUtil.converterToSpell(name));
		TbSubSitesDao.update(tbSubSites); 
	} 
	
	
	/**
	 * 更新tb_sub_sites name 和 ename 
	 * @param id
	 * @param name
	 */
	public void updateSubContent(int subSiteId, String name) { 
		List<DboSubContent> list = DboSubContentDao.where("sub_sites_id="+subSiteId + " and stype=4 and parent_id=21300");
		for(DboSubContent dboSubContent : list) {
			if("新车图库".equals(dboSubContent.getPname())) {
				dboSubContent.setPlace(name + "分站/新车图库");
				DboSubContentDao.update(dboSubContent);
			}
			if("焦点图".equals(dboSubContent.getPname())) {
				dboSubContent.setPlace(name + "分站/焦点图");
				DboSubContentDao.update(dboSubContent);
			}
			if("焦点图下栏".equals(dboSubContent.getPname())) {
				dboSubContent.setPlace(name + "分站/焦点图下栏");
				DboSubContentDao.update(dboSubContent);
			}
			if("汽车头条".equals(dboSubContent.getPname())) {
				dboSubContent.setPlace(name + "分站/汽车头条");
				DboSubContentDao.update(dboSubContent);
			}
			
		} 
	} 
}
