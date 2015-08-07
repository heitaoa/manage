package com.poly.bean;

import java.util.ArrayList;
import java.util.List;

public class ImageCompareBean {

	//{"左前45度","正面","正侧（车头向右）","正后","左后45度"};
	private List<String> waiguan = new ArrayList<String>();
	
	//{"完整内饰（居中）","方向盘","仪表板背光显示","中控台正面","变速器挡把"};
	private List<String> zhongkong = new ArrayList<String>(); 
	
	//{"驾驶座座椅","后排座椅","驾驶位座椅调节","左前车门","后备箱"};
	private List<String> zuoyi = new ArrayList<String>(); 
	
	//{"前舱","左前大灯正面","左外后视镜侧45度","左后尾灯正面","后悬架"};
	private List<String> qita = new ArrayList<String>();
	
	public ImageCompareBean(){
		waiguan.add("左前45度");
		waiguan.add("正面");
		waiguan.add("正侧（车头向右）");
		waiguan.add("正后");
		waiguan.add("左后45度");
		zhongkong.add("完整内饰（居中）");
		zhongkong.add("方向盘");
		zhongkong.add("仪表板背光显示");
		zhongkong.add("中控台正面");
		zhongkong.add("变速器挡把");
		zuoyi.add("驾驶座座椅");
		zuoyi.add("后排座椅");
		zuoyi.add("驾驶位座椅调节");
		zuoyi.add("左前车门");
		zuoyi.add("后备箱");
		qita.add("前舱");
		qita.add("左前大灯正面");
		qita.add("左外后视镜侧45度");
		qita.add("左后尾灯正面");
		qita.add("后悬架");
	}

	public List<String> getWaiguan() {
		
		return waiguan;
	}

	public void setWaiguan(List<String> waiguan) {
		this.waiguan = waiguan;
	}

	public List<String> getZhongkong() {
		
		return zhongkong;
	}

	public void setZhongkong(List<String> zhongkong) {
		this.zhongkong = zhongkong;
	}

	//{"驾驶座座椅","后排座椅","驾驶位座椅调节","左前车门","后备箱"};
	public List<String> getZuoyi() {
		return zuoyi;
	}

	public void setZuoyi(List<String> zuoyi) {
		this.zuoyi = zuoyi;
	}

	//{"前舱","左前大灯正面","左外后视镜侧45度","左后尾灯正面","后悬架"};
	public List<String> getQita() {
		return qita;
	}

	public void setQita(List<String> qita) {
		this.qita = qita;
	} 
	
	
}
