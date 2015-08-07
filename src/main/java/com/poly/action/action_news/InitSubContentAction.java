package com.poly.action.action_news;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import car_beans.DboSubContent;
import car_beans.TbSubSites;
import car_daos.DboSubContentDao;
import car_daos.TbSubSitesDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.NewsAdmDao;
import com.poly.dao.SeqDao;

//���۹���
public class InitSubContentAction extends MyActionSupport {

	public String execute() throws Exception {

		System.out.println("UPDATE dbo_sub_content set sub_sites_id = 1 where parent_id = 1 and sub_sites_id = 9;");

		List<DboSubContent> index_subContentList = DboSubContentDao.where("sub_sites_id = 1 and parent_id=1 and id <> 1");
		
		DboSubContent index_subContent = NewsAdmDao.querySubContentById(1);

		List<TbSubSites> subSites = TbSubSitesDao.find();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��վ��ҳ
		for (TbSubSites tbSubSites : subSites) {
			
//			System.out.println(Cn2Spell.converterToSpell(tbSubSites.getName())+".chetuan.com --> www.chetuan.com/"+Cn2Spell.converterToSpell(tbSubSites.getName())+".html");
			
//			if(tbSubSites.getId() == 1)
//				continue;
//			
//			System.out.println("delete from dbo_sub_content where sub_sites_id = "+tbSubSites.getId()+";");
//			
//			DboSubContent sub = new DboSubContent();
//			sub.setId(SeqDao.getNextId("dbo_sub_content"));
//
//			sub.setPname(Cn2Spell.converterToSpell(tbSubSites.getName()));
//			sub.setPlace(tbSubSites.getName() + "վ��ҳ");
//			sub.setStype(1);
//			sub.setHtmlname(Cn2Spell.converterToSpell(tbSubSites.getName()) + ".html");
//			sub.setIsdelete(0);
//			sub.setLastvisittime(new Date());
//			sub.setDesc(tbSubSites.getName() + "վ��ҳ");
//			sub.setParent_id(sub.getId());
//			sub.setTemplatename("index/index_1.ftl");
//			sub.setSub_sites_id(tbSubSites.getId());
//			// DboSubContentDao.save(sub);
//			String str = "insert into dbo_sub_content(`id`,`pname`,`place`,`stype`,`htmlname`,`isdelete`,`lastvisittime`,`desc`,`parent_id`,`templatename`,`sub_sites_id`) values('" + sub.getId() + "','"
//					+ sub.getPname() + "','" + sub.getPlace() + "','" + sub.getStype() + "','" + sub.getHtmlname() + "','" + sub.getIsdelete() + "','"+sdf.format(sub.getLastvisittime())+"','"+sub.getDesc()+"','"+sub.getParent_id()+"','"+sub.getTemplatename()+"','"+sub.getSub_sites_id()+"');";
//			
//			System.out.println(str);
//			
//			
//			for (DboSubContent dboSubContent : index_subContentList) {
//				
//				DboSubContent sub_1 = new DboSubContent();
//				sub_1.setId(SeqDao.getNextId("dbo_sub_content"));
//				sub_1.setPname(dboSubContent.getPname());
//				sub_1.setPlace(dboSubContent.getPlace().replace("������ҳ",tbSubSites.getName()+"վ��ҳ"));
//				sub_1.setStype(1);
//				sub_1.setHtmlname("block_"+sub_1.getId() + ".js");
//				sub_1.setIsdelete(0);
//				sub_1.setLastvisittime(new Date());
//				sub_1.setDesc(sub_1.getPlace());
//				sub_1.setParent_id(sub.getId());
//				sub_1.setTemplatename("");
//				sub_1.setSub_sites_id(tbSubSites.getId());
//				// DboSubContentDao.save(sub);
//				String str_1 = "insert into dbo_sub_content(`id`,`pname`,`place`,`stype`,`htmlname`,`isdelete`,`lastvisittime`,`desc`,`parent_id`,`templatename`,`sub_sites_id`) values('" + sub_1.getId() + "','"
//						+ sub_1.getPname() + "','" + sub_1.getPlace() + "','" + sub_1.getStype() + "','" + sub_1.getHtmlname() + "','" + sub_1.getIsdelete() + "','"+sdf.format(sub_1.getLastvisittime())+"','"+sub_1.getDesc()+"','"+sub_1.getParent_id()+"','"+sub_1.getTemplatename()+"','"+sub_1.getSub_sites_id()+"');";
//				
//				System.out.println(str_1);
//			}
//			
			
		}
		
		
		

		setAjax("ok");
		return AJAX;
	}

}
