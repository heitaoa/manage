package com.poly.service;
import java.util.List;

import car_beans.TbLinks;
import car_daos.TbLinksDao;

public class LinksService {
	public static final LinksService instanec = new LinksService();
	public static LinksService getInstance(){
		return instanec;
	}
	TbLinksDao tbLinksDao = new TbLinksDao();
	public List<TbLinks> listAllLinks(){
		return tbLinksDao.where("isDelete = 0 order by place,addtime");
	}
	public int deleteLinkes(int id){
		int count = 0;
		List<TbLinks> links = tbLinksDao.where("id = "+id);
		if(links.size()>0){
			TbLinks link = links.get(0);
			link.setIsdelete(1);
			count = tbLinksDao.update(link);
		}
		return count;
	}
	public int updateLinkes(TbLinks link){
		int count = 0;
		count = tbLinksDao.update(link);
		return count;
	}
	public int saveLinkes(TbLinks link) throws Exception{
		int count = 0;
		count = tbLinksDao.save(link);
		return count;
	}
	public List<TbLinks> getLinkGroupByPlace(){
		return tbLinksDao.where("isDelete = 0 group by place");
	}
	public List<TbLinks> getLinkGroup(String place){
		return tbLinksDao.where("isDelete = 0 and place='"+place+"'");
	}
}
