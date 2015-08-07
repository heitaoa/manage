package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.formula.functions.Now;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_beans.TbDataTiqudata;
import car_daos.DboCarCatalognewDao;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;
import com.poly.service.TiquService;

public class TqAddNewAction extends MyActionSupport {
	
	private ProjectService projectService = ProjectService.getInstance();
	private TiquService tiquService = TiquService.getInstance();
	
	private List<Map<String, String>> provList;  //省份列表
	private List<Map<String, String>> cityList;  //城市列表
	private List<Map<String, String>> carList;
	
	private String tiqu_num;//项目编号
	private String ini_man;//发起人
	private String ini_man_name;       //发起人姓名
	private int ini_dept;//发起部门
	private String ini_dept_name;     //发起部门名称
	private int ini_org;//发起站点
	private String ini_org_name;       //站点名称
	private String ini_date;//发起时间
	private String contact_num;//关联合同号
	private String contact_money;//合同金额
	private Date contact_start_date;//合同开始日期
	private Date contact_end_date;//合同结束日期
	private String cust_name;//客户名称
	private int brand;//品牌
	private int car;//车系
	private int prov;//推广省份 -1 代表全国
	private int city;//推广城市 -1代表该省份下所有城市
	private int data_count;//数据需求量
	private Date data_start_date;//数据周期开始日期
	private Date data_end_date;//数据周期结束日期
	private int is_agree_deduct;//是否同意扣除执行金额
	private String apply_cause;//申请原因
	private int is_deduct;//是否扣除执行金额--高层审核结果
	private int examine_state;//审核状态(0-未审核、1-主管通过、2-主管驳回、3-高层通过、4-高层驳回)
	private int tiqu_state;//提取状态(0-未操作、1-同意执行、2-取消执行、3-已执行)
	
	private String fatherid = "0";
	
	public String execute(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ini_date = sdf.format(new Date());
		provList = tiquService.getProvList(0);
		carList = tiquService.getCarList(fatherid);
		ini_man = (String)session.get("userid");
		Map<String, String> userInfo = tiquService.getUserinfo(ini_man);
		ini_man_name = userInfo.get("user_name");
		ini_dept = Integer.parseInt(userInfo.get("dept_code"));
		ini_dept_name = userInfo.get("dept_name");
		ini_org = Integer.parseInt(userInfo.get("org_code"));
		ini_org_name = userInfo.get("org_name");
		
		return SUCCESS;
	}
	
	public void sub() throws Exception{
		
		TbDataTiqudata tbDataTiqudata = new TbDataTiqudata();
		
		tbDataTiqudata.setIni_man(ini_man);
		tbDataTiqudata.setIni_date(new Date());
		tbDataTiqudata.setIni_dept(ini_dept);
		tbDataTiqudata.setIni_org(ini_org);
		tbDataTiqudata.setProv(prov);
		tbDataTiqudata.setCity(city);
		tbDataTiqudata.setBrand(brand);
		tbDataTiqudata.setCar(car);
		
		tbDataTiqudata.setContact_num(contact_num);
		tbDataTiqudata.setCust_name(cust_name);
		tbDataTiqudata.setContact_money(contact_money);
		tbDataTiqudata.setContact_end_date(contact_end_date);
		tbDataTiqudata.setContact_start_date(contact_start_date);
		
		tbDataTiqudata.setData_count(data_count);
		tbDataTiqudata.setData_start_date(data_start_date);
		tbDataTiqudata.setData_end_date(data_end_date);
		
		tbDataTiqudata.setIs_agree_deduct(is_agree_deduct);
		tbDataTiqudata.setApply_cause(apply_cause);
		
		tiqu_num = projectService.getCodeByOrg(6,ini_org);
		tbDataTiqudata.setTiqu_num(tiqu_num);
		
		int result = tiquService.addTiqu(tbDataTiqudata);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write("" + result);
	}
	
	public void getCarCatalog() throws IOException{
		carList = tiquService.getCarList(fatherid);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(carList);
		out.print(json.toString());
	}
	
	public void getCityList() throws IOException{
		cityList = tiquService.getProvList(prov);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(cityList);
		out.print(json.toString());
	}

	public List<Map<String, String>> getProvList() {
		return provList;
	}

	public void setProvList(List<Map<String, String>> provList) {
		this.provList = provList;
	}

	public String getTiqu_num() {
		return tiqu_num;
	}

	public void setTiqu_num(String tiqu_num) {
		this.tiqu_num = tiqu_num;
	}

	public String getIni_man() {
		return ini_man;
	}

	public void setIni_man(String ini_man) {
		this.ini_man = ini_man;
	}

	public String getIni_man_name() {
		return ini_man_name;
	}

	public void setIni_man_name(String ini_man_name) {
		this.ini_man_name = ini_man_name;
	}

	public int getIni_dept() {
		return ini_dept;
	}

	public void setIni_dept(int ini_dept) {
		this.ini_dept = ini_dept;
	}

	public int getIni_org() {
		return ini_org;
	}

	public void setIni_org(int ini_org) {
		this.ini_org = ini_org;
	}

	public String getIni_date() {
		return ini_date;
	}

	public void setIni_date(String ini_date) {
		this.ini_date = ini_date;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getContact_money() {
		return contact_money;
	}

	public void setContact_money(String contact_money) {
		this.contact_money = contact_money;
	}

	public Date getContact_start_date() {
		return contact_start_date;
	}

	public void setContact_start_date(Date contact_start_date) {
		this.contact_start_date = contact_start_date;
	}

	public Date getContact_end_date() {
		return contact_end_date;
	}

	public void setContact_end_date(Date contact_end_date) {
		this.contact_end_date = contact_end_date;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
		this.car = car;
	}

	public int getProv() {
		return prov;
	}

	public void setProv(int prov) {
		this.prov = prov;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getData_count() {
		return data_count;
	}

	public void setData_count(int data_count) {
		this.data_count = data_count;
	}

	public Date getData_start_date() {
		return data_start_date;
	}

	public void setData_start_date(Date data_start_date) {
		this.data_start_date = data_start_date;
	}

	public Date getData_end_date() {
		return data_end_date;
	}

	public void setData_end_date(Date data_end_date) {
		this.data_end_date = data_end_date;
	}

	public int getIs_agree_deduct() {
		return is_agree_deduct;
	}

	public void setIs_agree_deduct(int is_agree_deduct) {
		this.is_agree_deduct = is_agree_deduct;
	}

	public String getApply_cause() {
		return apply_cause;
	}

	public void setApply_cause(String apply_cause) {
		this.apply_cause = apply_cause;
	}

	public int getIs_deduct() {
		return is_deduct;
	}

	public void setIs_deduct(int is_deduct) {
		this.is_deduct = is_deduct;
	}

	public int getExamine_state() {
		return examine_state;
	}

	public void setExamine_state(int examine_state) {
		this.examine_state = examine_state;
	}

	public int getTiqu_state() {
		return tiqu_state;
	}

	public void setTiqu_state(int tiqu_state) {
		this.tiqu_state = tiqu_state;
	}

	public List<Map<String, String>> getCarList() {
		return carList;
	}

	public void setCarList(List<Map<String, String>> carList) {
		this.carList = carList;
	}

	public String getFatherid() {
		return fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public String getIni_org_name() {
		return ini_org_name;
	}

	public void setIni_org_name(String ini_org_name) {
		this.ini_org_name = ini_org_name;
	}

	public String getIni_dept_name() {
		return ini_dept_name;
	}

	public void setIni_dept_name(String ini_dept_name) {
		this.ini_dept_name = ini_dept_name;
	}

	public void setCityList(List<Map<String, String>> cityList) {
		this.cityList = cityList;
	}
	
	
}
