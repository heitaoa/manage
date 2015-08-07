package com.poly.action.action_baoming;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.TbDataBaominglog;
import car_daos.TbDataBaominglogDao;

import com.poly.action.MyActionSupport;
import com.poly.service.Publish4SService;
import com.poly.util.TbSequenceUtil;
import com.redis.RedisDao;
/**
 * 推送报名至经销商
 * @author zq
 *
 */
public class Publish4SAction extends MyActionSupport{
	private String id;//报名主键
	private String prov;//报名省份id
	private String city;//报名市id
	private String brandId;//报名品牌id
	private String chexiId;//报名车系id
	private String name;//姓名
	private String phone;//电话
	private String iway = "";//渠道
	/**
	 * 网页推送报名数据至经销商
	 * @throws Exception 
	 */
	public void publishDateTo4S() throws Exception{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("id",id);
		data.put("prov",prov);
		data.put("city",city);
		//data.put("brandId",brandId);
		data.put("chexiId",chexiId);
		data.put("name",name);
		data.put("phone",phone);
		Map<String, String> map = RedisDao.getCatalognewById(Integer.valueOf(chexiId));
		if(map!=null && map.size() > 0){
			iway = map.get("iway");
			data.put("brandId",map.get("fatherid"));
		}
		data.put("iway",iway);
		Map<String, Object> resultMap = Publish4SService.getInstance().findRightVip(data);
		
		Map<String,Object> map1 = (Map<String, Object>) session.get("userInfo");
		String man =  map1.get("username").toString();
		String userid = map1.get("userid").toString();
		
		
		TbDataBaominglog bmlog = new TbDataBaominglog();
		bmlog.setId(TbSequenceUtil.nextVal("tb_data_baominglog"));
		bmlog.setBaomingid(Integer.parseInt(id));
		bmlog.setUserid(userid);
		bmlog.setUsername(man);
		bmlog.setOperate_time(new Date());
		bmlog.setOperate_content(name+"&&&"+"城市id号"+prov+"--"+city+"&&&品牌id号"+brandId+"--"+chexiId);
		bmlog.setOperate_state("推送经销商");
		TbDataBaominglogDao.save(bmlog);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONObject json = JSONObject.fromObject(resultMap);
		out.print(json.toString());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getChexiId() {
		return chexiId;
	}
	public void setChexiId(String chexiId) {
		this.chexiId = chexiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIway() {
		return iway;
	}
	public void setIway(String iway) {
		this.iway = iway;
	}
	
	
	
	
}
