package com.poly.action.car_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.DboCarAutohomeprop;
import car_daos.DBConnect;
import car_daos.DboCarAutohomepropDao;
import car_daos.DboCarCatalognewDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.NewsAdmService;
import com.poly.util.DeleteCarParamFileUtil;
import com.poly.util.FieldUtil;
import com.redis.RedisDao;
import com.redis.RedisManager;
import com.redis.RedisParseUtil;

public class CarDataInput extends MyActionSupport{
	
	private int catalogId;
	private String jbcsData;
	private String csData;
	private String fdjData;
	private String bsxData;
	private String dfzxData;
	private String clzdData;
	private String aqzbData;
	private String czpzData;
	private String wbpzData;
	private String nbpzData;
	private String zypzData;
	private String dmtpzData;
	private String dgpzData;
	private String plpzData;
	private String ktpzData;
	private String gkjpzData;
	private String ddjData;
	
	public String getDdjData() {
		return ddjData;
	}

	public void setDdjData(String ddjData) {
		this.ddjData = ddjData;
	}

	public String getYsData() {
		return ysData;
	}

	public void setYsData(String ysData) {
		this.ysData = ysData;
	}

	private String ysData;

	public String execute(){
		return SUCCESS;
	}
	
	public void selectLevel2CarInfo() throws IOException{
		String cSql=" carid = "+catalogId;
		List<DboCarAutohomeprop> autohomeList=DboCarAutohomepropDao.where(cSql);
		if(autohomeList.size()>0){
			if(FieldUtil.isEmpty(autohomeList.get(0).getP1())){
				autohomeList.get(0).setP1("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP2())){
				autohomeList.get(0).setP2("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP3())){
				autohomeList.get(0).setP3("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP4())){
				autohomeList.get(0).setP4("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP5())){
				autohomeList.get(0).setP5("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP6())){
				autohomeList.get(0).setP6("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP7())){
				autohomeList.get(0).setP7("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP8())){
				autohomeList.get(0).setP8("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP9())){
				autohomeList.get(0).setP9("-");
			}
			
			if(FieldUtil.isEmpty(autohomeList.get(0).getP10())){
				autohomeList.get(0).setP10("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP11())){
				autohomeList.get(0).setP11("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP12())){
				autohomeList.get(0).setP12("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP13())){
				autohomeList.get(0).setP13("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP14())){
				autohomeList.get(0).setP14("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP15())){
				autohomeList.get(0).setP15("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP16())){
				autohomeList.get(0).setP16("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP17())){
				autohomeList.get(0).setP17("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP18())){
				autohomeList.get(0).setP18("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP19())){
				autohomeList.get(0).setP19("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP20())){
				autohomeList.get(0).setP20("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP21())){
				autohomeList.get(0).setP21("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP22())){
				autohomeList.get(0).setP22("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP23())){
				autohomeList.get(0).setP23("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP24())){
				autohomeList.get(0).setP24("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP25())){
				autohomeList.get(0).setP25("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP26())){
				autohomeList.get(0).setP26("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP27())){
				autohomeList.get(0).setP27("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP28())){
				autohomeList.get(0).setP28("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP29())){
				autohomeList.get(0).setP29("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP30())){
				autohomeList.get(0).setP30("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP31())){
				autohomeList.get(0).setP31("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP32())){
				autohomeList.get(0).setP32("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP33())){
				autohomeList.get(0).setP33("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP34())){
				autohomeList.get(0).setP34("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP35())){
				autohomeList.get(0).setP35("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP36())){
				autohomeList.get(0).setP36("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP37())){
				autohomeList.get(0).setP37("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP38())){
				autohomeList.get(0).setP38("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP39())){
				autohomeList.get(0).setP39("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP40())){
				autohomeList.get(0).setP40("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP41())){
				autohomeList.get(0).setP41("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP42())){
				autohomeList.get(0).setP42("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP43())){
				autohomeList.get(0).setP43("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP44())){
				autohomeList.get(0).setP44("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP45())){
				autohomeList.get(0).setP45("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP46())){
				autohomeList.get(0).setP46("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP47())){
				autohomeList.get(0).setP47("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP48())){
				autohomeList.get(0).setP48("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP49())){
				autohomeList.get(0).setP49("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP50())){
				autohomeList.get(0).setP50("-");
			}
			
			if(FieldUtil.isEmpty(autohomeList.get(0).getP51())){
				autohomeList.get(0).setP51("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP52())){
				autohomeList.get(0).setP52("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP53())){
				autohomeList.get(0).setP53("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP54())){
				autohomeList.get(0).setP54("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP55())){
				autohomeList.get(0).setP55("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP56())){
				autohomeList.get(0).setP56("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP57())){
				autohomeList.get(0).setP57("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP58())){
				autohomeList.get(0).setP58("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP59())){
				autohomeList.get(0).setP59("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP60())){
				autohomeList.get(0).setP60("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP61())){
				autohomeList.get(0).setP61("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP62())){
				autohomeList.get(0).setP62("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP63())){
				autohomeList.get(0).setP63("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP64())){
				autohomeList.get(0).setP64("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP65())){
				autohomeList.get(0).setP65("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP66())){
				autohomeList.get(0).setP66("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP67())){
				autohomeList.get(0).setP67("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP68())){
				autohomeList.get(0).setP68("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP69())){
				autohomeList.get(0).setP69("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP70())){
				autohomeList.get(0).setP70("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP71())){
				autohomeList.get(0).setP71("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP72())){
				autohomeList.get(0).setP72("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP73())){
				autohomeList.get(0).setP73("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP74())){
				autohomeList.get(0).setP74("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP75())){
				autohomeList.get(0).setP75("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP76())){
				autohomeList.get(0).setP76("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP77())){
				autohomeList.get(0).setP77("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP78())){
				autohomeList.get(0).setP78("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP79())){
				autohomeList.get(0).setP79("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP80())){
				autohomeList.get(0).setP80("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP81())){
				autohomeList.get(0).setP81("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP82())){
				autohomeList.get(0).setP82("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP83())){
				autohomeList.get(0).setP83("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP84())){
				autohomeList.get(0).setP84("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP85())){
				autohomeList.get(0).setP85("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP86())){
				autohomeList.get(0).setP86("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP87())){
				autohomeList.get(0).setP87("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP88())){
				autohomeList.get(0).setP88("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP89())){
				autohomeList.get(0).setP89("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP90())){
				autohomeList.get(0).setP90("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP91())){
				autohomeList.get(0).setP91("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP92())){
				autohomeList.get(0).setP92("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP93())){
				autohomeList.get(0).setP93("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP94())){
				autohomeList.get(0).setP94("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP95())){
				autohomeList.get(0).setP95("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP96())){
				autohomeList.get(0).setP96("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP97())){
				autohomeList.get(0).setP97("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP98())){
				autohomeList.get(0).setP98("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP99())){
				autohomeList.get(0).setP99("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP100())){
				autohomeList.get(0).setP100("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP101())){
				autohomeList.get(0).setP101("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP102())){
				autohomeList.get(0).setP102("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP103())){
				autohomeList.get(0).setP103("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP104())){
				autohomeList.get(0).setP104("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP105())){
				autohomeList.get(0).setP105("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP106())){
				autohomeList.get(0).setP106("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP107())){
				autohomeList.get(0).setP107("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP108())){
				autohomeList.get(0).setP108("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP109())){
				autohomeList.get(0).setP109("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP110())){
				autohomeList.get(0).setP110("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP111())){
				autohomeList.get(0).setP111("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP112())){
				autohomeList.get(0).setP112("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP113())){
				autohomeList.get(0).setP113("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP114())){
				autohomeList.get(0).setP114("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP115())){
				autohomeList.get(0).setP115("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP116())){
				autohomeList.get(0).setP116("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP117())){
				autohomeList.get(0).setP117("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP118())){
				autohomeList.get(0).setP118("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP119())){
				autohomeList.get(0).setP119("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP120())){
				autohomeList.get(0).setP120("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP121())){
				autohomeList.get(0).setP121("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP122())){
				autohomeList.get(0).setP122("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP123())){
				autohomeList.get(0).setP123("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP124())){
				autohomeList.get(0).setP124("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP125())){
				autohomeList.get(0).setP125("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP126())){
				autohomeList.get(0).setP126("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP127())){
				autohomeList.get(0).setP127("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP128())){
				autohomeList.get(0).setP128("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP129())){
				autohomeList.get(0).setP129("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP130())){
				autohomeList.get(0).setP130("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP131())){
				autohomeList.get(0).setP131("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP132())){
				autohomeList.get(0).setP132("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP133())){
				autohomeList.get(0).setP133("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP134())){
				autohomeList.get(0).setP134("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP135())){
				autohomeList.get(0).setP135("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP136())){
				autohomeList.get(0).setP136("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP137())){
				autohomeList.get(0).setP137("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP138())){
				autohomeList.get(0).setP138("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP139())){
				autohomeList.get(0).setP139("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP140())){
				autohomeList.get(0).setP140("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP141())){
				autohomeList.get(0).setP141("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP142())){
				autohomeList.get(0).setP142("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP143())){
				autohomeList.get(0).setP143("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP144())){
				autohomeList.get(0).setP144("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP145())){
				autohomeList.get(0).setP145("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP146())){
				autohomeList.get(0).setP146("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP147())){
				autohomeList.get(0).setP147("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP148())){
				autohomeList.get(0).setP148("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP149())){
				autohomeList.get(0).setP149("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP150())){
				autohomeList.get(0).setP150("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP151())){
				autohomeList.get(0).setP151("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP152())){
				autohomeList.get(0).setP152("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP153())){
				autohomeList.get(0).setP153("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP154())){
				autohomeList.get(0).setP154("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP155())){
				autohomeList.get(0).setP155("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP156())){
				autohomeList.get(0).setP156("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP157())){
				autohomeList.get(0).setP157("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP158())){
				autohomeList.get(0).setP158("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP159())){
				autohomeList.get(0).setP159("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP160())){
				autohomeList.get(0).setP160("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP161())){
				autohomeList.get(0).setP161("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP162())){
				autohomeList.get(0).setP162("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP163())){
				autohomeList.get(0).setP163("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP164())){
				autohomeList.get(0).setP164("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP165())){
				autohomeList.get(0).setP165("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP166())){
				autohomeList.get(0).setP166("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP167())){
				autohomeList.get(0).setP167("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP168())){
				autohomeList.get(0).setP168("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP169())){
				autohomeList.get(0).setP169("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP170())){
				autohomeList.get(0).setP170("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP171())){
				autohomeList.get(0).setP171("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP172())){
				autohomeList.get(0).setP172("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP173())){
				autohomeList.get(0).setP173("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP174())){
				autohomeList.get(0).setP174("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP175())){
				autohomeList.get(0).setP175("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP176())){
				autohomeList.get(0).setP176("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP177())){
				autohomeList.get(0).setP177("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP178())){
				autohomeList.get(0).setP178("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP179())){
				autohomeList.get(0).setP179("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP180())){
				autohomeList.get(0).setP180("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP181())){
				autohomeList.get(0).setP181("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP182())){
				autohomeList.get(0).setP182("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP183())){
				autohomeList.get(0).setP183("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP184())){
				autohomeList.get(0).setP184("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP185())){
				autohomeList.get(0).setP185("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP186())){
				autohomeList.get(0).setP186("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP187())){
				autohomeList.get(0).setP187("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP188())){
				autohomeList.get(0).setP188("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP189())){
				autohomeList.get(0).setP189("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP190())){
				autohomeList.get(0).setP190("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP191())){
				autohomeList.get(0).setP191("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP192())){
				autohomeList.get(0).setP192("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP193())){
				autohomeList.get(0).setP193("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP194())){
				autohomeList.get(0).setP194("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP195())){
				autohomeList.get(0).setP195("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP196())){
				autohomeList.get(0).setP196("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP197())){
				autohomeList.get(0).setP197("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP198())){
				autohomeList.get(0).setP198("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP199())){
				autohomeList.get(0).setP199("-");
			}
			if(FieldUtil.isEmpty(autohomeList.get(0).getP200())){
				autohomeList.get(0).setP199("-");
			}
		}else{
			DboCarAutohomeprop autohomeprop=new DboCarAutohomeprop();
			autohomeprop.setCarid(catalogId);
			try {
				DboCarAutohomepropDao.save(autohomeprop);
				autohomeList=DboCarAutohomepropDao.where(" carid = "+catalogId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(autohomeList);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString());
		out.close();
	}
	
	public String UpDateCarDate(){
		try{
			String catalogName=DboCarCatalognewDao.where(" catalogid = "+catalogId).get(0).getCatalogname();
			String carSql=" carid = "+catalogId;
			int cid=0;
			List<DboCarAutohomeprop> catalogList=DboCarAutohomepropDao.where(carSql);
			if(catalogList.size()>0){
				cid=catalogList.get(0).getId();
			}else{
				int id=SeqDao.getNextId("dbo_car_autohomeprop");
				DboCarAutohomeprop catalog=new DboCarAutohomeprop();
				cid=id;
				catalog.setCarid(catalogId);
				catalog.setId(id);
				catalog.setP1(catalogName);
				try{
					DboCarAutohomepropDao.save(catalog);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			List<DboCarAutohomeprop> oldAutohomeprops=DboCarAutohomepropDao.where(" carid = "+catalogId);
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			catalogA.setId(cid);
			catalogA.setCarid(catalogId);
			String jbcsString=jbcsData.substring(1,jbcsData.length()-1 );
			String p1="";
			if(jbcsString.split("@").length>0){
				p1=jbcsString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p1)){
				catalogA.setP1(p1);
			}
			String p2="";
			if(jbcsString.split("@").length>1){
				p2=jbcsString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p2)){
				if(p2.indexOf("~")!=-1){
					p2=p2.substring(0,p2.indexOf("~"));
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}else{
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}
				
				catalogA.setP2(p2);
			}
			String p192="";
			if(jbcsString.split("@").length>2){
				p192=jbcsString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p192)){
				catalogA.setP192(p192);
			}
			String p4="";
			if(jbcsString.split("@").length>3){
				p4=jbcsString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p4)){
				catalogA.setP4(p4);
			}
			String p5="";
			if(jbcsString.split("@").length>4){
				p5=jbcsString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p5)){
				catalogA.setP5(p5);
			}
			String p6="";
			if(jbcsString.split("@").length>5){
				p6=jbcsString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p6)){
				catalogA.setP6(p6);
			}
			String p7="";
			if(jbcsString.split("@").length>6){
				p7=jbcsString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p7)){
				catalogA.setP7(p7);
			}
			String p8="";
			if(jbcsString.split("@").length>7){
				p8=jbcsString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p8)){
				catalogA.setP8(p8);
			}
			String p9="";
			if(jbcsString.split("@").length>8){
				p9=jbcsString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p9)){
				catalogA.setP9(p9);
			}
			String p10="";
			if(jbcsString.split("@").length>9){
				p10=jbcsString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p10)){
				catalogA.setP10(p10);
			}
			String p13="";
			if(jbcsString.split("@").length>10){
				p13=jbcsString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p13)){
				catalogA.setP13(p13);
			}
			String p14="";
			if(jbcsString.split("@").length>11){
				p14=jbcsString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p14)){
				catalogA.setP14(p14);
			}
			String p15="";
			if(jbcsString.split("@").length>12){
				p15=jbcsString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p15)){
				catalogA.setP15(p15);
			}
			String p193="";
			if(jbcsString.split("@").length>13){
				p193=jbcsString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p193)){
				catalogA.setP193(p193);
			}
//			String p23="";
//			if(jbcsString.split("@").length>14){
//				p23=jbcsString.split("@")[14];
//			}
			String p16="";
			if(jbcsString.split("@").length>15){
				p16=jbcsString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p16)){
				catalogA.setP16(p16);
			}
			String p177="";
			if(jbcsString.split("@").length>16){
				p177=jbcsString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p177)){
				catalogA.setP177(p177);
			}
			String csString=csData.substring(1,csData.length()-1 );
			String p17="";
			if(csString.split("@").length>0){
				p17=csString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p17)){
				catalogA.setP17(p17);
			}
			String p18="";
			if(csString.split("@").length>1){
				p18=csString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p18)){
				catalogA.setP18(p18);
			}
			String p19="";
			if(csString.split("@").length>2){
				p19=csString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p19)){
				catalogA.setP19(p19);
			}
			String p20="";
			if(csString.split("@").length>3){
				p20=csString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p20)){
				catalogA.setP20(p20);
			}
			String p21="";
			if(csString.split("@").length>4){
				p21=csString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p21)){
				catalogA.setP21(p21);
			}
			String p22="";
			if(csString.split("@").length>5){
				p22=csString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p22)){
				catalogA.setP22(p22);
			}
			String p23="";
			if(csString.split("@").length>6){
				p23=csString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p23)){
				catalogA.setP23(p23);
			}
			String p24="";
			if(csString.split("@").length>7){
				p24=csString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p24)){
				catalogA.setP24(p24);
			}
			String p25="";
			if(csString.split("@").length>8){
				p25=csString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p25)){
				catalogA.setP25(p25);
			}
			String p26="";
			if(csString.split("@").length>9){
				p26=csString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p26)){
				catalogA.setP26(p26);
			}
			String p27="";
			if(csString.split("@").length>10){
				p27=csString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p27)){
				catalogA.setP27(p27);
			}
			String p28="";
			if(csString.split("@").length>11){
				p28=csString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p28)){
				catalogA.setP28(p28);
			}
			String p29="";
			if(csString.split("@").length>12){
				p29=csString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p29)){
				catalogA.setP29(p29);
			}
			String fdjString=fdjData.substring(1,fdjData.length()-1 );
			String p194="";
			if(fdjString.split("@").length>0){
				p194=fdjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p194)){
				catalogA.setP194(p194);
			}
			String p30="";
			if(fdjString.split("@").length>1){
				p30=fdjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p30)){
				catalogA.setP30(p30);
			}
			String p31="";
			if(fdjString.split("@").length>2){
				p31=fdjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p31)){
				if(p31.indexOf(".")<0){
					p31=p31+".0";
				}
				catalogA.setP31(p31);
			}
			String p32="";
			if(fdjString.split("@").length>3){
				p32=fdjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p32)){
				catalogA.setP32(p32);
				if(p32.indexOf("-")==-1){
					if(p32.indexOf("自然")!=-1){
						catalogA.setP209("L");
					}else{
						catalogA.setP209("T");
					}
				}
			}
			String p33="";
			if(fdjString.split("@").length>4){
				p33=fdjString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p33)){
				catalogA.setP33(p33);
			}
			String p34="";
			if(fdjString.split("@").length>5){
				p34=fdjString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p34)){
				catalogA.setP34(p34);
			}
			String p35="";
			if(fdjString.split("@").length>6){
				p35=fdjString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p35)){
				catalogA.setP35(p35);
			}
			String p36="";
			if(fdjString.split("@").length>7){
				p36=fdjString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p36)){
				catalogA.setP36(p36);
			}
			String p37="";
			if(fdjString.split("@").length>8){
				p37=fdjString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p37)){
				catalogA.setP37(p37);
			}
			String p38="";
			if(fdjString.split("@").length>9){
				p38=fdjString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p38)){
				catalogA.setP38(p38);
			}
			String p39="";
			if(fdjString.split("@").length>10){
				p39=fdjString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p39)){
				catalogA.setP39(p39);
			}
			String p40="";
			if(fdjString.split("@").length>11){
				p40=fdjString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p40)){
				catalogA.setP40(p40);
			}
			String p41="";
			if(fdjString.split("@").length>12){
				p41=fdjString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p41)){
				catalogA.setP41(p41);
			}
			String p42="";
			if(fdjString.split("@").length>13){
				p42=fdjString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p42)){
				catalogA.setP42(p42);
			}
			String p43="";
			if(fdjString.split("@").length>14){
				p43=fdjString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p43)){
				catalogA.setP43(p43);
			}
			String p44="";
			if(fdjString.split("@").length>15){
				p44=fdjString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p44)){
				catalogA.setP44(p44);
			}
			String p45="";
			if(fdjString.split("@").length>16){
				p45=fdjString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p45)){
				catalogA.setP45(p45);
			}
			String p46="";
			if(fdjString.split("@").length>17){
				p46=fdjString.split("@")[17];
			}
			if(!FieldUtil.isEmpty(p46)){
				catalogA.setP46(p46);
			}
			String p47="";
			if(fdjString.split("@").length>18){
				p47=fdjString.split("@")[18];
			}
			if(!FieldUtil.isEmpty(p47)){
				catalogA.setP47(p47);
			}
			String p48="";
			if(fdjString.split("@").length>19){
				p48=fdjString.split("@")[19];
			}
			if(!FieldUtil.isEmpty(p48)){
				catalogA.setP48(p48);
			}
			String p49="";
			if(fdjString.split("@").length>20){
				p49=fdjString.split("@")[20];
			}
			if(!FieldUtil.isEmpty(p49)){
				catalogA.setP49(p49);
			}
			String p50="";
			if(fdjString.split("@").length>21){
				p50=fdjString.split("@")[21];
			}
			if(!FieldUtil.isEmpty(p50)){
				catalogA.setP50(p50);
			}
			String p51="";
			if(fdjString.split("@").length>22){
				p51=fdjString.split("@")[22];
			}
			if(!FieldUtil.isEmpty(p51)){
				catalogA.setP51(p51);
			}
			String bsxString=bsxData.substring(1,bsxData.length()-1 );
			String p52="";
			if(bsxString.split("@").length>0){
				p52=bsxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p52)){
				catalogA.setP52(p52);
			}
			String p53="";
			if(bsxString.split("@").length>1){
				p53=bsxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p53)){
				catalogA.setP53(p53);
			}
			String p54="";
			if(bsxString.split("@").length>2){
				p54=bsxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p54)){
				catalogA.setP54(p54);
			}
			String dfzxString=dfzxData.substring(1,dfzxData.length()-1 );
			String p55="";
			if(dfzxString.split("@").length>0){
				p55=dfzxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p55)){
				catalogA.setP55(p55);
			}
			String p56="";
			if(dfzxString.split("@").length>1){
				p56=dfzxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p56)){
				catalogA.setP56(p56);
			}
			String p57="";
			if(dfzxString.split("@").length>2){
				p57=dfzxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p57)){
				catalogA.setP57(p57);
			}
			String p58="";
			if(dfzxString.split("@").length>3){
				p58=dfzxString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p58)){
				catalogA.setP58(p58);
			}
			String p59="";
			if(dfzxString.split("@").length>4){
				p59=dfzxString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p59)){
				catalogA.setP59(p59);
			}
			String clzdString=clzdData.substring(1,clzdData.length()-1 );
			String p60="";
			if(clzdString.split("@").length>0){
				p60=clzdString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p60)){
				catalogA.setP60(p60);
			}
			String p61="";
			if(clzdString.split("@").length>1){
				p61=clzdString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p61)){
				catalogA.setP61(p61);
			}
			String p62="";
			if(clzdString.split("@").length>2){
				p62=clzdString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p62)){
				catalogA.setP62(p62);
			}
			String p63="";
			if(clzdString.split("@").length>3){
				p63=clzdString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p63)){
				catalogA.setP63(p63);
			}
			String p64="";
			if(clzdString.split("@").length>4){
				p64=clzdString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p64)){
				catalogA.setP64(p64);
			}
			String p65="";
			if(clzdString.split("@").length>5){
				p65=clzdString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p65)){
				catalogA.setP65(p65);
			}
			String aqzbString=aqzbData.substring(1,aqzbData.length()-1 );
			String p66="";
			String p67="";
			if(aqzbString.split("@").length>0){
				if(aqzbString.split("@")[0].indexOf("/")!=-1){
					p66=aqzbString.split("@")[0].substring(1,aqzbString.split("@")[0].indexOf("/"));
					p67=aqzbString.split("@")[0].substring(aqzbString.split("@")[0].length()-1,aqzbString.split("@")[0].length());
				}else{
					p66=aqzbString.split("@")[0];
					p67=aqzbString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p66)){
				catalogA.setP66(p66);
			}
			if(!FieldUtil.isEmpty(p67)){
				catalogA.setP67(p67);
			}
			String p68="";
			String p69="";
			if(aqzbString.split("@").length>1){
				if(aqzbString.split("@")[1].indexOf("/")!=-1){
					p68=aqzbString.split("@")[1].substring(1,aqzbString.split("@")[1].indexOf("/"));
					p69=aqzbString.split("@")[1].substring(aqzbString.split("@")[1].length()-1,aqzbString.split("@")[1].length());
				}else{
					p68=aqzbString.split("@")[1];
					p69=aqzbString.split("@")[1];
				}
			}
			if(!FieldUtil.isEmpty(p68)){
				catalogA.setP68(p68);
			}
			if(!FieldUtil.isEmpty(p69)){
				catalogA.setP69(p69);
			}
			String p70="";
			String p71="";
			if(aqzbString.split("@").length>2){
				if(aqzbString.split("@")[2].indexOf("/")!=-1){
					p70=aqzbString.split("@")[2].substring(1,aqzbString.split("@")[2].indexOf("/"));
					p71=aqzbString.split("@")[2].substring(aqzbString.split("@")[2].length()-1,aqzbString.split("@")[2].length());
				}else{
					p70=aqzbString.split("@")[2];
					p71=aqzbString.split("@")[2];
				}
			}
			if(!FieldUtil.isEmpty(p70)){
				catalogA.setP70(p70);
			}
			if(!FieldUtil.isEmpty(p71)){
				catalogA.setP71(p71);
			}
			String p72="";
			if(aqzbString.split("@").length>3){
				p72=aqzbString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p72)){
				catalogA.setP72(p72);
			}
			String p87="";
			if(aqzbString.split("@").length>4){
				p87=aqzbString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p87)){
				catalogA.setP87(p87);
			}
			String p88="";
			if(aqzbString.split("@").length>5){
				p88=aqzbString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p88)){
				catalogA.setP88(p88);
			}
			String p73="";
			if(aqzbString.split("@").length>6){
				p73=aqzbString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p73)){
				catalogA.setP73(p73);
			}
			String p198="";
			if(aqzbString.split("@").length>7){
				p198=aqzbString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p198)){
				catalogA.setP198(p198);
			}
			String p74="";
			if(aqzbString.split("@").length>8){
				p74=aqzbString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p74)){
				catalogA.setP74(p74);
			}
			String p75="";
			if(aqzbString.split("@").length>9){
				p75=aqzbString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p75)){
				catalogA.setP75(p75);
			}
			String p76="";
			if(aqzbString.split("@").length>10){
				p76=aqzbString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p76)){
				catalogA.setP76(p76);
			}
			String p77="";
			if(aqzbString.split("@").length>11){
				p77=aqzbString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p77)){
				catalogA.setP77(p77);
			}
			String czpzString=czpzData.substring(1,czpzData.length()-1 );
			String p78="";
			if(czpzString.split("@").length>0){
				p78=czpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p78)){
				catalogA.setP78(p78);
			}
			String p79="";
			if(czpzString.split("@").length>1){
				p79=czpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p79)){
				catalogA.setP79(p79);
			}
			String p80="";
			if(czpzString.split("@").length>2){
				p80=czpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p80)){
				catalogA.setP80(p80);
			}
			String p81="";
			if(czpzString.split("@").length>3){
				p81=czpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p81)){
				catalogA.setP81(p81);
			}
			String p82="";
			if(czpzString.split("@").length>4){
				p82=czpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p82)){
				catalogA.setP82(p82);
			}
			String p83="";
			if(czpzString.split("@").length>5){
				p83=czpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p83)){
				catalogA.setP83(p83);
			}
			String p84="";
			if(czpzString.split("@").length>7){
				p84=czpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p84)){
				catalogA.setP84(p84);
			}
			String p85="";
			if(czpzString.split("@").length>8){
				p85=czpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p85)){
				catalogA.setP85(p85);
			}
			String p86="";
			if(czpzString.split("@").length>9){
				p86=czpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p86)){
				catalogA.setP86(p86);
			}
			String p89="";
			if(czpzString.split("@").length>10){
				p89=czpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p89)){
				catalogA.setP89(p89);
			}
			String wbpzString=wbpzData.substring(1,wbpzData.length()-1 );
			String p90="";
			if(wbpzString.split("@").length>0){
				p90=wbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p90)){
				catalogA.setP90(p90);
			}
			String p91="";
			if(wbpzString.split("@").length>1){
				p91=wbpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p91)){
				catalogA.setP91(p91);
			}
			String p94="";
			if(wbpzString.split("@").length>2){
				p94=wbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p94)){
				catalogA.setP94(p94);
			}
			String p95="";
			if(wbpzString.split("@").length>3){
				p95=wbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p95)){
				catalogA.setP95(p95);
			}
			String p180="";
			if(wbpzString.split("@").length>4){
				p180=wbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p180)){
				catalogA.setP180(p180);
			}
			String p126="";
			if(wbpzString.split("@").length>6){
				p126=wbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p126)){
				catalogA.setP126(p126);
			}
			String nbpzString=nbpzData.substring(1,nbpzData.length()-1 );
			String p96="";
			if(nbpzString.split("@").length>0){
				p96=nbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p96)){
				catalogA.setP96(p96);
			}
			String p97="";
			String p98="";
			if(nbpzString.split("@").length>1){
				if(nbpzString.split("@")[1].length()>0){
					
					if(nbpzString.split("@")[1].indexOf("+")!=-1){
						p97="●";
						p98="●";
					}else{
						if(nbpzString.split("@")[1].substring(0,1).equals("上下")){
							p97="●";
							p98="-";
						}else{
							p97="-";
							p98="●";
						}
					}
				}
				
			}
			if(!FieldUtil.isEmpty(p97)){
				catalogA.setP97(p97);
			}
			if(!FieldUtil.isEmpty(p98)){
				catalogA.setP98(p98);
			}
			String p181="";
			if(nbpzString.split("@").length>2){
				p181=nbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p181)){
				catalogA.setP181(p181);
			}
			String p99="";
			if(nbpzString.split("@").length>3){
				p99=nbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p99)){
				catalogA.setP99(p99);
			}
			String p100="";
			if(nbpzString.split("@").length>4){
				p100=nbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p100)){
				catalogA.setP100(p100);
			}
			String p101="";
			if(nbpzString.split("@").length>6){
				p101=nbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p101)){
				catalogA.setP101(p101);
			}
			String p103="";
			if(nbpzString.split("@").length>8){
				p103=nbpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p103)){
				catalogA.setP103(p103);
			}
			String p104="";
			if(nbpzString.split("@").length>9){
				p104=nbpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p104)){
				catalogA.setP104(p104);
			}
			String p105="";
			if(nbpzString.split("@").length>10){
				p105=nbpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p105)){
				catalogA.setP105(p105);
			}
			String zypzString=zypzData.substring(1,zypzData.length()-1 );
			String p107="";
			if(zypzString.split("@").length>0){
				p107=zypzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p107)){
				catalogA.setP107(p107);
			}
			String p108="";
			if(zypzString.split("@").length>1){
				p108=zypzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p108)){
				catalogA.setP108(p108);
			}
			String p109="";
			if(zypzString.split("@").length>2){
				p109=zypzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p109)){
				catalogA.setP109(p109);
			}
			String p110="";
			if(zypzString.split("@").length>3){
				p110=zypzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p110)){
				catalogA.setP110(p110);
			}
			String p182="";
			if(zypzString.split("@").length>4){
				p182=zypzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p182)){
				catalogA.setP182(p182);
			}
			String p195="";
			if(zypzString.split("@").length>6){
				p195=zypzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p195)){
				catalogA.setP195(p195);
			}
			String p196="";
			if(zypzString.split("@").length>7){
				p196=zypzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p196)){
				catalogA.setP196(p196);
			}
			String p113="";
			if(zypzString.split("@").length>8){
				p113=zypzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p113)){
				catalogA.setP113(p113);
			}
			String p114="";
			if(zypzString.split("@").length>9){
				p114=zypzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p114)){
				catalogA.setP114(p114);
			}
			String p115="";
			String p116="";
			if(zypzString.split("@").length>10){
				if(zypzString.split("@")[10].indexOf("/")!=-1){
					p115=zypzString.split("@")[10].substring(1,zypzString.split("@")[10].indexOf("/"));
					p116=zypzString.split("@")[10].substring(zypzString.split("@")[10].length()-1,zypzString.split("@")[10].length());
				}else{
					p115=zypzString.split("@")[10];
					p116=zypzString.split("@")[10];
				}
			}
			
			if(!FieldUtil.isEmpty(p115)){
				catalogA.setP115(p115);
			}
			if(!FieldUtil.isEmpty(p116)){
				catalogA.setP116(p116);
			}
			String p117="";
			if(zypzString.split("@").length>11){
				p117=zypzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p117)){
				catalogA.setP117(p117);
			}
			String p118="";
			if(zypzString.split("@").length>12){
				p118=zypzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p118)){
				catalogA.setP118(p118);
			}
			String p119="";
			String p120="";
			if(zypzString.split("@").length>13){
				if(zypzString.split("@")[13].indexOf("整体放倒")!=-1){
					p119="●";
				}
				if(zypzString.split("@")[13].indexOf("比例放倒")!=-1){
					p120="●";
				}
			}
			if(!FieldUtil.isEmpty(p119)){
				catalogA.setP119(p119);
			}
			if(!FieldUtil.isEmpty(p120)){
				catalogA.setP120(p120);
			}
			String p121="";
			if(zypzString.split("@").length>14){
				p121=zypzString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p121)){
				catalogA.setP121(p121);
			}
			String p122="";
			String p123="";
			if(zypzString.split("@").length>15){
				if(zypzString.split("@")[15].indexOf("/")!=-1){
					p122=zypzString.split("@")[15].substring(1,zypzString.split("@")[15].indexOf("/"));
					p123=zypzString.split("@")[15].substring(zypzString.split("@")[15].length()-1,zypzString.split("@")[15].length());
				}else{
					p122=zypzString.split("@")[15];
					p123=zypzString.split("@")[15];
				}
			}
			if(!FieldUtil.isEmpty(p122)){
				catalogA.setP122(p122);
			}
			if(!FieldUtil.isEmpty(p123)){
				catalogA.setP123(p123);
			}
			String p125="";
			if(zypzString.split("@").length>16){
				p125=zypzString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p125)){
				catalogA.setP125(p125);
			}
			String dmtpzString=dmtpzData.substring(1,dmtpzData.length()-1);
			String p127="";
			if(dmtpzString.split("@").length>0){
				p127=dmtpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p127)){
				catalogA.setP127(p127);
			}
			String p183="";
			if(dmtpzString.split("@").length>1){
				p183=dmtpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p183)){
				catalogA.setP183(p183);
			}
			String p128="";
			if(dmtpzString.split("@").length>2){
				p128=dmtpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p128)){
				catalogA.setP128(p128);
			}
			String p130="";
			if(dmtpzString.split("@").length>3){
				p130=dmtpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p130)){
				catalogA.setP130(p130);
			}
			String p184="";
			if(dmtpzString.split("@").length>4){
				p184=dmtpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p184)){
				catalogA.setP184(p184);
			}
			String p132="";
			if(dmtpzString.split("@").length>5){
				p132=dmtpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p132)){
				catalogA.setP132(p132);
			}
			String p134="";
			if(dmtpzString.split("@").length>6){
				p134=dmtpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p134)){
				catalogA.setP134(p134);
			}
			String p135="";
			if(dmtpzString.split("@").length>7){
				p135=dmtpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p135)){
				catalogA.setP135(p135);
			}
			String p136="";
			if(dmtpzString.split("@").length>8){
				p136=dmtpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p136)){
				catalogA.setP136(p136);
			}
			String p137="";
			String p138="";
			String p139="";
			String p140="";
			if(dmtpzString.split("@").length>9){
				if(dmtpzString.split("@")[9].indexOf("单碟")!=-1){
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p137="●";
					}else{
						p139="●";
					}
				}else{
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p138="●";
					}else{
						p140="●";
					}
				}
			}
			if(!FieldUtil.isEmpty(p137)){
				catalogA.setP137(p137);
			}
			if(!FieldUtil.isEmpty(p138)){
				catalogA.setP138(p138);
			}
			if(!FieldUtil.isEmpty(p139)){
				catalogA.setP139(p139);
			}
			if(!FieldUtil.isEmpty(p140)){
				catalogA.setP140(p140);
			}
			String p141="";
			String p142="";
			String p143="";
			String p144="";
			if(dmtpzString.split("@").length>11){
				if(dmtpzString.split("@")[11].indexOf("2-3")!=-1){
					p141="●";
				}
				if(dmtpzString.split("@")[11].indexOf("4-5")!=-1){
					p142="●";
				}
				if(dmtpzString.split("@")[11].indexOf("6-7")!=-1){
					p143="●";
				}
				if(dmtpzString.split("@")[11].indexOf("≥8")!=-1){
					p144="●";
				}
			}
			if(!FieldUtil.isEmpty(p141)){
				catalogA.setP141(p141);
			}
			if(!FieldUtil.isEmpty(p142)){
				catalogA.setP142(p142);
			}
			if(!FieldUtil.isEmpty(p143)){
				catalogA.setP143(p143);
			}
			if(!FieldUtil.isEmpty(p144)){
				catalogA.setP144(p144);
			}
			String dgpzString=dgpzData.substring(1,dgpzData.length()-1);
			String p145="";
			if(dgpzString.split("@").length>0){
				p145=dgpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p145)){
				catalogA.setP145(p145);
			}
			String p146="";
			if(dgpzString.split("@").length>2){
				p146=dgpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p146)){
				catalogA.setP146(p146);
			}
			String p147="";
			if(dgpzString.split("@").length>3){
				p147=dgpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p147)){
				catalogA.setP147(p147);
			}
			String p148="";
			if(dgpzString.split("@").length>4){
				p148=dgpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p148)){
				catalogA.setP148(p148);
			}
			String p149="";
			if(dgpzString.split("@").length>6){
				p149=dgpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p149)){
				catalogA.setP149(p149);
			}
			String p151="";
			if(dgpzString.split("@").length>7){
				p151=dgpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p151)){
				catalogA.setP151(p151);
			}
			String p152="";
			if(dgpzString.split("@").length>8){
				p152=dgpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p152)){
				catalogA.setP152(p152);
			}
			String p186="";
			if(dgpzString.split("@").length>9){
				p186=dgpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p186)){
				catalogA.setP186(p186);
			}
			String plpzString=plpzData.substring(1,plpzData.length()-1);
			String p153="";
			String p154="";
			if(plpzString.split("@").length>0){
				if(plpzString.split("@")[0].indexOf("/")!=-1){
					p153=plpzString.split("@")[0].substring(1,plpzString.split("@")[0].indexOf("/"));
					p154=plpzString.split("@")[0].substring(plpzString.split("@")[0].length()-1,plpzString.split("@")[0].length());
				}else{
					p153=plpzString.split("@")[0];
					p154=plpzString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p153)){
				catalogA.setP153(p153);
			}
			if(!FieldUtil.isEmpty(p154)){
				catalogA.setP154(p154);
			}
			String p155="";
			if(plpzString.split("@").length>1){
				p155=plpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p155)){
				catalogA.setP155(p155);
			}
			String p187="";
			if(plpzString.split("@").length>2){
				p187=plpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p187)){
				catalogA.setP187(p187);
			}
			String p156="";
			if(plpzString.split("@").length>3){
				p156=plpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p156)){
				catalogA.setP156(p156);
			}
			String p157="";
			if(plpzString.split("@").length>4){
				p157=plpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p157)){
				catalogA.setP157(p157);
			}
			String p158="";
			if(plpzString.split("@").length>5){
				p158=plpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p158)){
				catalogA.setP158(p158);
			}
			String p159="";
			if(plpzString.split("@").length>6){
				p159=plpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p159)){
				catalogA.setP159(p159);
			}
			String p197="";
			if(plpzString.split("@").length>7){
				p197=plpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p197)){
				catalogA.setP197(p197);
			}
			String p160="";
			if(plpzString.split("@").length>8){
				p160=plpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p160)){
				catalogA.setP160(p160);
			}
			String p161="";
			if(plpzString.split("@").length>9){
				p161=plpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p161)){
				catalogA.setP161(p161);
			}
			String p162="";
			if(plpzString.split("@").length>11){
				p162=plpzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p162)){
				catalogA.setP162(p162);
			}
			String p188="";
			if(plpzString.split("@").length>12){
				p188=plpzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p188)){
				catalogA.setP188(p188);
			}
			String p163="";
			if(plpzString.split("@").length>13){
				p163=plpzString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p163)){
				catalogA.setP163(p163);
			}
			String ktpzString=ktpzData.substring(1,ktpzData.length()-1);
			String p164="";
			if(ktpzString.split("@").length>0){
				p164=ktpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p164)){
				catalogA.setP164(p164);
			}
			String p166="";
			if(ktpzString.split("@").length>1){
				p166=ktpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p166)){
				catalogA.setP166(p166);
			}
			String p167="";
			if(ktpzString.split("@").length>2){
				p167=ktpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p167)){
				catalogA.setP167(p167);
			}
			String p168="";
			if(ktpzString.split("@").length>3){
				p168=ktpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p168)){
				catalogA.setP168(p168);
			}
			String p169="";
			if(ktpzString.split("@").length>4){
				p169=ktpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p169)){
				catalogA.setP169(p169);
			}
			String p170="";
			if(ktpzString.split("@").length>5){
				p170=ktpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p170)){
				catalogA.setP170(p170);
			}
			String gkjpzString=gkjpzData.substring(1,gkjpzData.length()-1);
			String p171="";
			if(gkjpzString.split("@").length>0){
				p171=gkjpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p171)){
				catalogA.setP171(p171);
			} 
			String p172="";
			if(gkjpzString.split("@").length>2){
				p172=gkjpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p172)){
				catalogA.setP172(p172);
			} 
			String p189="";
			if(gkjpzString.split("@").length>4){
				p189=gkjpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p189)){
				catalogA.setP189(p189);
			} 
			String p190="";
			if(gkjpzString.split("@").length>5){
				p190=gkjpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p190)){
				catalogA.setP190(p190);
			} 
			String p173="";
			if(gkjpzString.split("@").length>6){
				p173=gkjpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p173)){
				catalogA.setP173(p173);
			} 
			String p191="";
			if(gkjpzString.split("@").length>7){
				p191=gkjpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p191)){
				catalogA.setP191(p191);
			}
			String p174="";
			if(gkjpzString.split("@").length>8){
				p174=gkjpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p174)){
				catalogA.setP174(p174);
			} 
			String p175="";
			if(gkjpzString.split("@").length>9){
				p175=gkjpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p175)){
				catalogA.setP175(p175);
			} 
			if(!FieldUtil.isEmpty(ysData)){
				catalogA.setP200(ysData);
			}
			DboCarAutohomepropDao.update(catalogA);
			RedisDao.UpDateAutohomepropByOne(catalogId, catalogA,oldAutohomeprops.get(0));
			Map<String, String> cataMap=RedisDao.getCatalognewById(catalogId);
			int pathLevel=Integer.parseInt(cataMap.get("pathlevel"));
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else{
				
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				//NewsAdmService.delNewsHtmlByCarcatalogid(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(cid));
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String UpDateCarDateFour(){
		try{
			String catalogName=DboCarCatalognewDao.where(" catalogid = "+catalogId).get(0).getCatalogname();
			String carSql=" carid = "+catalogId;
			int cid=0;
			List<DboCarAutohomeprop> catalogList=DboCarAutohomepropDao.where(carSql);
			if(catalogList.size()>0){
				cid=catalogList.get(0).getId();
			}else{
				int id=SeqDao.getNextId("dbo_car_autohomeprop");
				DboCarAutohomeprop catalog=new DboCarAutohomeprop();
				cid=id;
				catalog.setCarid(catalogId);
				catalog.setId(id);
				catalog.setP1(catalogName);
				try{
					DboCarAutohomepropDao.save(catalog);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			List<DboCarAutohomeprop> oldAutohomeprops=DboCarAutohomepropDao.where(" carid = "+catalogId);
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			catalogA.setId(cid);
			catalogA.setCarid(catalogId);
			String jbcsString=jbcsData.substring(1,jbcsData.length()-1 );
			String p1="";
			if(jbcsString.split("@").length>0){
				p1=jbcsString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p1)){
				catalogA.setP1(p1);
			}
			String p2="";
			if(jbcsString.split("@").length>1){
				p2=jbcsString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p2)){
				if(p2.indexOf("~")!=-1){
					p2=p2.substring(0,p2.indexOf("~"));
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}else{
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}
				
				catalogA.setP2(p2);
			}
			String p192="";
			if(jbcsString.split("@").length>2){
				p192=jbcsString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p192)){
				catalogA.setP192(p192);
			}
			String p4="";
			if(jbcsString.split("@").length>3){
				p4=jbcsString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p4)){
				catalogA.setP4(p4);
			}
			String p5="";
			if(jbcsString.split("@").length>4){
				p5=jbcsString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p5)){
				catalogA.setP5(p5);
			}
			String p6="";
			if(jbcsString.split("@").length>5){
				p6=jbcsString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p6)){
				catalogA.setP6(p6);
			}
			String p7="";
			if(jbcsString.split("@").length>6){
				p7=jbcsString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p7)){
				catalogA.setP7(p7);
			}
			String p8="";
			if(jbcsString.split("@").length>7){
				p8=jbcsString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p8)){
				catalogA.setP8(p8);
			}
			String p9="";
			if(jbcsString.split("@").length>8){
				p9=jbcsString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p9)){
				catalogA.setP9(p9);
			}
			String p10="";
			if(jbcsString.split("@").length>9){
				p10=jbcsString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p10)){
				catalogA.setP10(p10);
			}
			String p13="";
			if(jbcsString.split("@").length>10){
				p13=jbcsString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p13)){
				catalogA.setP13(p13);
			}
			String p14="";
			if(jbcsString.split("@").length>11){
				p14=jbcsString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p14)){
				catalogA.setP14(p14);
			}
			String p15="";
			if(jbcsString.split("@").length>12){
				p15=jbcsString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p15)){
				catalogA.setP15(p15);
			}
			String p193="";
			if(jbcsString.split("@").length>13){
				p193=jbcsString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p193)){
				catalogA.setP193(p193);
			}
//			String p23="";
//			if(jbcsString.split("@").length>14){
//				p23=jbcsString.split("@")[14];
//			}
			String p16="";
			if(jbcsString.split("@").length>15){
				p16=jbcsString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p16)){
				catalogA.setP16(p16);
			}
			String p177="";
			if(jbcsString.split("@").length>16){
				p177=jbcsString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p177)){
				catalogA.setP177(p177);
			}
			String csString=csData.substring(1,csData.length()-1 );
			String p17="";
			if(csString.split("@").length>0){
				p17=csString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p17)){
				catalogA.setP17(p17);
			}
			String p18="";
			if(csString.split("@").length>1){
				p18=csString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p18)){
				catalogA.setP18(p18);
			}
			String p19="";
			if(csString.split("@").length>2){
				p19=csString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p19)){
				catalogA.setP19(p19);
			}
			String p20="";
			if(csString.split("@").length>3){
				p20=csString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p20)){
				catalogA.setP20(p20);
			}
			String p21="";
			if(csString.split("@").length>4){
				p21=csString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p21)){
				catalogA.setP21(p21);
			}
			String p22="";
			if(csString.split("@").length>5){
				p22=csString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p22)){
				catalogA.setP22(p22);
			}
			String p23="";
			if(csString.split("@").length>6){
				p23=csString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p23)){
				catalogA.setP23(p23);
			}
			String p24="";
			if(csString.split("@").length>7){
				p24=csString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p24)){
				catalogA.setP24(p24);
			}
			String p25="";
			if(csString.split("@").length>8){
				p25=csString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p25)){
				catalogA.setP25(p25);
			}
			String p26="";
			if(csString.split("@").length>9){
				p26=csString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p26)){
				catalogA.setP26(p26);
			}
			String p27="";
			if(csString.split("@").length>10){
				p27=csString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p27)){
				catalogA.setP27(p27);
			}
			String p28="";
			if(csString.split("@").length>11){
				p28=csString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p28)){
				catalogA.setP28(p28);
			}
			String p29="";
			if(csString.split("@").length>12){
				p29=csString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p29)){
				catalogA.setP29(p29);
			}
			String fdjString=fdjData.substring(1,fdjData.length()-1 );
			String p194="";
			if(fdjString.split("@").length>0){
				p194=fdjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p194)){
				catalogA.setP194(p194);
			}
			String p30="";
			if(fdjString.split("@").length>1){
				p30=fdjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p30)){
				catalogA.setP30(p30);
			}
			String p31="";
			if(fdjString.split("@").length>2){
				p31=fdjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p31)){
				catalogA.setP31(p31);
			}
			String p32="";
			if(fdjString.split("@").length>3){
				p32=fdjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p32)){
				catalogA.setP32(p32);
			}
			String p33="";
			if(fdjString.split("@").length>4){
				p33=fdjString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p33)){
				catalogA.setP33(p33);
			}
			String p34="";
			if(fdjString.split("@").length>5){
				p34=fdjString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p34)){
				catalogA.setP34(p34);
			}
			String p35="";
			if(fdjString.split("@").length>6){
				p35=fdjString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p35)){
				catalogA.setP35(p35);
			}
			String p36="";
			if(fdjString.split("@").length>7){
				p36=fdjString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p36)){
				catalogA.setP36(p36);
			}
			String p37="";
			if(fdjString.split("@").length>8){
				p37=fdjString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p37)){
				catalogA.setP37(p37);
			}
			String p38="";
			if(fdjString.split("@").length>9){
				p38=fdjString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p38)){
				catalogA.setP38(p38);
			}
			String p39="";
			if(fdjString.split("@").length>10){
				p39=fdjString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p39)){
				catalogA.setP39(p39);
			}
			String p40="";
			if(fdjString.split("@").length>11){
				p40=fdjString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p40)){
				catalogA.setP40(p40);
			}
			String p41="";
			if(fdjString.split("@").length>12){
				p41=fdjString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p41)){
				catalogA.setP41(p41);
			}
			String p42="";
			if(fdjString.split("@").length>13){
				p42=fdjString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p42)){
				catalogA.setP42(p42);
			}
			String p43="";
			if(fdjString.split("@").length>14){
				p43=fdjString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p43)){
				catalogA.setP43(p43);
			}
			String p44="";
			if(fdjString.split("@").length>15){
				p44=fdjString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p44)){
				catalogA.setP44(p44);
			}
			String p45="";
			if(fdjString.split("@").length>16){
				p45=fdjString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p45)){
				catalogA.setP45(p45);
			}
			String p46="";
			if(fdjString.split("@").length>17){
				p46=fdjString.split("@")[17];
			}
			if(!FieldUtil.isEmpty(p46)){
				catalogA.setP46(p46);
			}
			String p47="";
			if(fdjString.split("@").length>18){
				p47=fdjString.split("@")[18];
			}
			if(!FieldUtil.isEmpty(p47)){
				catalogA.setP47(p47);
			}
			String p48="";
			if(fdjString.split("@").length>19){
				p48=fdjString.split("@")[19];
			}
			if(!FieldUtil.isEmpty(p48)){
				catalogA.setP48(p48);
			}
			String p49="";
			if(fdjString.split("@").length>20){
				p49=fdjString.split("@")[20];
			}
			if(!FieldUtil.isEmpty(p49)){
				catalogA.setP49(p49);
			}
			String p50="";
			if(fdjString.split("@").length>21){
				p50=fdjString.split("@")[21];
			}
			if(!FieldUtil.isEmpty(p50)){
				catalogA.setP50(p50);
			}
			String p51="";
			if(fdjString.split("@").length>22){
				p51=fdjString.split("@")[22];
			}
			if(!FieldUtil.isEmpty(p51)){
				catalogA.setP51(p51);
			}
			String ddjString=ddjData.substring(1,ddjData.length()-1);
			String p205="";
			if(ddjString.split("@").length>0){
				p205=ddjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p205)){
				catalogA.setP205(p205);
			}
			String p206="";
			if(ddjString.split("@").length>1){
				p206=ddjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p206)){
				catalogA.setP206(p206);
			}
			String p207="";
			if(ddjString.split("@").length>2){
				p207=ddjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p207)){
				catalogA.setP207(p207);
			}
			String p208="";
			if(ddjString.split("@").length>3){
				p208=ddjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p208)){
				catalogA.setP208(p208);
			}
			String bsxString=bsxData.substring(1,bsxData.length()-1 );
			String p52="";
			if(bsxString.split("@").length>0){
				p52=bsxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p52)){
				catalogA.setP52(p52);
			}
			String p53="";
			if(bsxString.split("@").length>1){
				p53=bsxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p53)){
				catalogA.setP53(p53);
			}
			String p54="";
			if(bsxString.split("@").length>2){
				p54=bsxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p54)){
				catalogA.setP54(p54);
			}
			String dfzxString=dfzxData.substring(1,dfzxData.length()-1 );
			String p55="";
			if(dfzxString.split("@").length>0){
				p55=dfzxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p55)){
				catalogA.setP55(p55);
			}
			String p56="";
			if(dfzxString.split("@").length>1){
				p56=dfzxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p56)){
				catalogA.setP56(p56);
			}
			String p57="";
			if(dfzxString.split("@").length>2){
				p57=dfzxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p57)){
				catalogA.setP57(p57);
			}
			String p58="";
			if(dfzxString.split("@").length>3){
				p58=dfzxString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p58)){
				catalogA.setP58(p58);
			}
			String p59="";
			if(dfzxString.split("@").length>4){
				p59=dfzxString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p59)){
				catalogA.setP59(p59);
			}
			String clzdString=clzdData.substring(1,clzdData.length()-1 );
			String p60="";
			if(clzdString.split("@").length>0){
				p60=clzdString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p60)){
				catalogA.setP60(p60);
			}
			String p61="";
			if(clzdString.split("@").length>1){
				p61=clzdString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p61)){
				catalogA.setP61(p61);
			}
			String p62="";
			if(clzdString.split("@").length>2){
				p62=clzdString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p62)){
				catalogA.setP62(p62);
			}
			String p63="";
			if(clzdString.split("@").length>3){
				p63=clzdString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p63)){
				catalogA.setP63(p63);
			}
			String p64="";
			if(clzdString.split("@").length>4){
				p64=clzdString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p64)){
				catalogA.setP64(p64);
			}
			String p65="";
			if(clzdString.split("@").length>5){
				p65=clzdString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p65)){
				catalogA.setP65(p65);
			}
			String aqzbString=aqzbData.substring(1,aqzbData.length()-1 );
			aqzbString=aqzbString.replaceAll("&nbsp;", " ");
			String p66="";
			String p67="";
			if(aqzbString.split("@").length>0){
				if(aqzbString.split("@")[0].indexOf("/")!=-1){
					p66=aqzbString.split("@")[0].substring(1,aqzbString.split("@")[0].indexOf("/"));
					p67=aqzbString.split("@")[0].substring(aqzbString.split("@")[0].length()-1,aqzbString.split("@")[0].length());
				}else{
					p66=aqzbString.split("@")[0];
					p67=aqzbString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p66)){
				catalogA.setP66(p66);
			}
			if(!FieldUtil.isEmpty(p67)){
				catalogA.setP67(p67);
			}
			String p68="";
			String p69="";
			if(aqzbString.split("@").length>1){
				if(aqzbString.split("@")[1].indexOf("/")!=-1){
					p68=aqzbString.split("@")[1].substring(1,aqzbString.split("@")[1].indexOf("/"));
					p69=aqzbString.split("@")[1].substring(aqzbString.split("@")[1].length()-1,aqzbString.split("@")[1].length());
				}else{
					p68=aqzbString.split("@")[1];
					p69=aqzbString.split("@")[1];
				}
			}
			if(!FieldUtil.isEmpty(p68)){
				catalogA.setP68(p68);
			}
			if(!FieldUtil.isEmpty(p69)){
				catalogA.setP69(p69);
			}
			String p70="";
			String p71="";
			if(aqzbString.split("@").length>2){
				if(aqzbString.split("@")[2].indexOf("/")!=-1){
					p70=aqzbString.split("@")[2].substring(1,aqzbString.split("@")[2].indexOf("/"));
					p71=aqzbString.split("@")[2].substring(aqzbString.split("@")[2].length()-1,aqzbString.split("@")[2].length());
				}else{
					p70=aqzbString.split("@")[2];
					p71=aqzbString.split("@")[2];
				}
			}
			if(!FieldUtil.isEmpty(p70)){
				catalogA.setP70(p70);
			}
			if(!FieldUtil.isEmpty(p71)){
				catalogA.setP71(p71);
			}
			String p72="";
			if(aqzbString.split("@").length>3){
				p72=aqzbString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p72)){
				catalogA.setP72(p72);
			}
			String p87="";
			if(aqzbString.split("@").length>4){
				p87=aqzbString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p87)){
				catalogA.setP87(p87);
			}
			String p88="";
			if(aqzbString.split("@").length>5){
				p88=aqzbString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p88)){
				catalogA.setP88(p88);
			}
			String p73="";
			if(aqzbString.split("@").length>6){
				p73=aqzbString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p73)){
				catalogA.setP73(p73);
			}
			String p198="";
			if(aqzbString.split("@").length>7){
				p198=aqzbString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p198)){
				catalogA.setP198(p198);
			}
			String p74="";
			if(aqzbString.split("@").length>8){
				p74=aqzbString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p74)){
				catalogA.setP74(p74);
			}
			String p75="";
			if(aqzbString.split("@").length>9){
				p75=aqzbString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p75)){
				catalogA.setP75(p75);
			}
			String p76="";
			if(aqzbString.split("@").length>10){
				p76=aqzbString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p76)){
				catalogA.setP76(p76);
			}
			String p77="";
			if(aqzbString.split("@").length>11){
				p77=aqzbString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p77)){
				catalogA.setP77(p77);
			}
			String czpzString=czpzData.substring(1,czpzData.length()-1 );
			czpzString=czpzString.replaceAll("&nbsp;", " ");
			String p78="";
			if(czpzString.split("@").length>0){
				p78=czpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p78)){
				catalogA.setP78(p78);
			}
			String p79="";
			if(czpzString.split("@").length>1){
				p79=czpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p79)){
				catalogA.setP79(p79);
			}
			String p80="";
			if(czpzString.split("@").length>2){
				p80=czpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p80)){
				catalogA.setP80(p80);
			}
			String p81="";
			if(czpzString.split("@").length>3){
				p81=czpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p81)){
				catalogA.setP81(p81);
			}
			String p82="";
			if(czpzString.split("@").length>4){
				p82=czpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p82)){
				catalogA.setP82(p82);
			}
			String p83="";
			if(czpzString.split("@").length>5){
				p83=czpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p83)){
				catalogA.setP83(p83);
			}
			String p84="";
			if(czpzString.split("@").length>7){
				p84=czpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p84)){
				catalogA.setP84(p84);
			}
			String p85="";
			if(czpzString.split("@").length>8){
				p85=czpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p85)){
				catalogA.setP85(p85);
			}
			String p86="";
			if(czpzString.split("@").length>9){
				p86=czpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p86)){
				catalogA.setP86(p86);
			}
			String p89="";
			if(czpzString.split("@").length>10){
				p89=czpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p89)){
				catalogA.setP89(p89);
			}
			String wbpzString=wbpzData.substring(1,wbpzData.length()-1 );
			wbpzString=wbpzString.replaceAll("&nbsp;", " ");
			String p90="";
			if(wbpzString.split("@").length>0){
				p90=wbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p90)){
				catalogA.setP90(p90);
			}
			String p91="";
			if(wbpzString.split("@").length>1){
				p91=wbpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p91)){
				catalogA.setP91(p91);
			}
			String p94="";
			if(wbpzString.split("@").length>2){
				p94=wbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p94)){
				catalogA.setP94(p94);
			}
			String p95="";
			if(wbpzString.split("@").length>3){
				p95=wbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p95)){
				catalogA.setP95(p95);
			}
			String p180="";
			if(wbpzString.split("@").length>4){
				p180=wbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p180)){
				catalogA.setP180(p180);
			}
			String p126="";
			if(wbpzString.split("@").length>6){
				p126=wbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p126)){
				catalogA.setP126(p126);
			}
			String nbpzString=nbpzData.substring(1,nbpzData.length()-1 );
			nbpzString=nbpzString.replaceAll("&nbsp;", " ");
			String p96="";
			if(nbpzString.split("@").length>0){
				p96=nbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p96)){
				catalogA.setP96(p96);
			}
			String p97="";
			String p98="";
			if(nbpzString.split("@").length>1){
				if(nbpzString.split("@")[1].length()>0){
					
					if(nbpzString.split("@")[1].indexOf("+")!=-1){
						p97="●";
						p98="●";
					}else{
						if(nbpzString.split("@")[1].substring(0,1).equals("上下")){
							p97="●";
							p98="-";
						}else{
							p97="-";
							p98="●";
						}
					}
				}
				
			}
			if(!FieldUtil.isEmpty(p97)){
				catalogA.setP97(p97);
			}
			if(!FieldUtil.isEmpty(p98)){
				catalogA.setP98(p98);
			}
			String p181="";
			if(nbpzString.split("@").length>2){
				p181=nbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p181)){
				catalogA.setP181(p181);
			}
			String p99="";
			if(nbpzString.split("@").length>3){
				p99=nbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p99)){
				catalogA.setP99(p99);
			}
			String p100="";
			if(nbpzString.split("@").length>4){
				p100=nbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p100)){
				catalogA.setP100(p100);
			}
			String p101="";
			if(nbpzString.split("@").length>6){
				p101=nbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p101)){
				catalogA.setP101(p101);
			}
			String p103="";
			if(nbpzString.split("@").length>8){
				p103=nbpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p103)){
				catalogA.setP103(p103);
			}
			String p104="";
			if(nbpzString.split("@").length>9){
				p104=nbpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p104)){
				catalogA.setP104(p104);
			}
			String p105="";
			if(nbpzString.split("@").length>10){
				p105=nbpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p105)){
				catalogA.setP105(p105);
			}
			String zypzString=zypzData.substring(1,zypzData.length()-1 );
			zypzString=zypzString.replaceAll("&nbsp;", " ");
			String p107="";
			if(zypzString.split("@").length>0){
				p107=zypzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p107)){
				catalogA.setP107(p107);
			}
			String p108="";
			if(zypzString.split("@").length>1){
				p108=zypzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p108)){
				catalogA.setP108(p108);
			}
			String p109="";
			if(zypzString.split("@").length>2){
				p109=zypzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p109)){
				catalogA.setP109(p109);
			}
			String p110="";
			if(zypzString.split("@").length>3){
				p110=zypzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p110)){
				catalogA.setP110(p110);
			}
			String p182="";
			if(zypzString.split("@").length>4){
				p182=zypzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p182)){
				catalogA.setP182(p182);
			}
			String p195="";
			if(zypzString.split("@").length>6){
				p195=zypzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p195)){
				catalogA.setP195(p195);
			}
			String p196="";
			if(zypzString.split("@").length>7){
				p196=zypzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p196)){
				catalogA.setP196(p196);
			}
			String p113="";
			if(zypzString.split("@").length>8){
				p113=zypzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p113)){
				catalogA.setP113(p113);
			}
			String p114="";
			if(zypzString.split("@").length>9){
				p114=zypzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p114)){
				catalogA.setP114(p114);
			}
			String p115="";
			String p116="";
			if(zypzString.split("@").length>10){
				if(zypzString.split("@")[10].indexOf("/")!=-1){
					p115=zypzString.split("@")[10].substring(1,zypzString.split("@")[10].indexOf("/"));
					p116=zypzString.split("@")[10].substring(zypzString.split("@")[10].length()-1,zypzString.split("@")[10].length());
				}else{
					p115=zypzString.split("@")[10];
					p116=zypzString.split("@")[10];
				}
			}
			
			if(!FieldUtil.isEmpty(p115)){
				catalogA.setP115(p115);
			}
			if(!FieldUtil.isEmpty(p116)){
				catalogA.setP116(p116);
			}
			String p117="";
			if(zypzString.split("@").length>11){
				p117=zypzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p117)){
				catalogA.setP117(p117);
			}
			String p118="";
			if(zypzString.split("@").length>12){
				p118=zypzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p118)){
				catalogA.setP118(p118);
			}
			String p119="";
			String p120="";
			if(zypzString.split("@").length>13){
				if(zypzString.split("@")[13].indexOf("整体放倒")!=-1){
					p119="●";
				}
				if(zypzString.split("@")[13].indexOf("比例放倒")!=-1){
					p120="●";
				}
			}
			if(!FieldUtil.isEmpty(p119)){
				catalogA.setP119(p119);
			}
			if(!FieldUtil.isEmpty(p120)){
				catalogA.setP120(p120);
			}
			String p121="";
			if(zypzString.split("@").length>14){
				p121=zypzString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p121)){
				catalogA.setP121(p121);
			}
			String p122="";
			String p123="";
			if(zypzString.split("@").length>15){
				if(zypzString.split("@")[15].indexOf("/")!=-1){
					p122=zypzString.split("@")[15].substring(1,zypzString.split("@")[15].indexOf("/"));
					p123=zypzString.split("@")[15].substring(zypzString.split("@")[15].length()-1,zypzString.split("@")[15].length());
				}else{
					p122=zypzString.split("@")[15];
					p123=zypzString.split("@")[15];
				}
			}
			if(!FieldUtil.isEmpty(p122)){
				catalogA.setP122(p122);
			}
			if(!FieldUtil.isEmpty(p123)){
				catalogA.setP123(p123);
			}
			String p125="";
			if(zypzString.split("@").length>16){
				p125=zypzString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p125)){
				catalogA.setP125(p125);
			}
			String dmtpzString=dmtpzData.substring(1,dmtpzData.length()-1);
			dmtpzString=dmtpzString.replaceAll("&nbsp;", " ");
			String p127="";
			if(dmtpzString.split("@").length>0){
				p127=dmtpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p127)){
				catalogA.setP127(p127);
			}
			String p183="";
			if(dmtpzString.split("@").length>1){
				p183=dmtpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p183)){
				catalogA.setP183(p183);
			}
			String p128="";
			if(dmtpzString.split("@").length>2){
				p128=dmtpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p128)){
				catalogA.setP128(p128);
			}
			String p130="";
			if(dmtpzString.split("@").length>3){
				p130=dmtpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p130)){
				catalogA.setP130(p130);
			}
			String p184="";
			if(dmtpzString.split("@").length>4){
				p184=dmtpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p184)){
				catalogA.setP184(p184);
			}
			String p132="";
			if(dmtpzString.split("@").length>5){
				p132=dmtpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p132)){
				catalogA.setP132(p132);
			}
			String p134="";
			if(dmtpzString.split("@").length>6){
				p134=dmtpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p134)){
				catalogA.setP134(p134);
			}
			String p135="";
			if(dmtpzString.split("@").length>7){
				p135=dmtpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p135)){
				catalogA.setP135(p135);
			}
			String p136="";
			if(dmtpzString.split("@").length>8){
				p136=dmtpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p136)){
				catalogA.setP136(p136);
			}
			String p137="";
			String p138="";
			String p139="";
			String p140="";
			if(dmtpzString.split("@").length>9){
				if(dmtpzString.split("@")[9].indexOf("单碟")!=-1){
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p137="●";
					}else{
						p139="●";
					}
				}else{
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p138="●";
					}else{
						p140="●";
					}
				}
			}
			if(!FieldUtil.isEmpty(p137)){
				catalogA.setP137(p137);
			}
			if(!FieldUtil.isEmpty(p138)){
				catalogA.setP138(p138);
			}
			if(!FieldUtil.isEmpty(p139)){
				catalogA.setP139(p139);
			}
			if(!FieldUtil.isEmpty(p140)){
				catalogA.setP140(p140);
			}
			String p141="";
			String p142="";
			String p143="";
			String p144="";
			if(dmtpzString.split("@").length>11){
				if(dmtpzString.split("@")[11].indexOf("2-3")!=-1){
					p141="●";
				}
				if(dmtpzString.split("@")[11].indexOf("4-5")!=-1){
					p142="●";
				}
				if(dmtpzString.split("@")[11].indexOf("6-7")!=-1){
					p143="●";
				}
				if(dmtpzString.split("@")[11].indexOf("≥8")!=-1){
					p144="●";
				}
			}
			if(!FieldUtil.isEmpty(p141)){
				catalogA.setP141(p141);
			}
			if(!FieldUtil.isEmpty(p142)){
				catalogA.setP142(p142);
			}
			if(!FieldUtil.isEmpty(p143)){
				catalogA.setP143(p143);
			}
			if(!FieldUtil.isEmpty(p144)){
				catalogA.setP144(p144);
			}
			String dgpzString=dgpzData.substring(1,dgpzData.length()-1);
			dgpzString=dgpzString.replaceAll("&nbsp;", " ");
			String p145="";
			if(dgpzString.split("@").length>0){
				p145=dgpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p145)){
				catalogA.setP145(p145);
			}
			String p146="";
			if(dgpzString.split("@").length>2){
				p146=dgpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p146)){
				catalogA.setP146(p146);
			}
			String p147="";
			if(dgpzString.split("@").length>3){
				p147=dgpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p147)){
				catalogA.setP147(p147);
			}
			String p148="";
			if(dgpzString.split("@").length>4){
				p148=dgpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p148)){
				catalogA.setP148(p148);
			}
			String p149="";
			if(dgpzString.split("@").length>6){
				p149=dgpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p149)){
				catalogA.setP149(p149);
			}
			String p151="";
			if(dgpzString.split("@").length>7){
				p151=dgpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p151)){
				catalogA.setP151(p151);
			}
			String p152="";
			if(dgpzString.split("@").length>8){
				p152=dgpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p152)){
				catalogA.setP152(p152);
			}
			String p186="";
			if(dgpzString.split("@").length>9){
				p186=dgpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p186)){
				catalogA.setP186(p186);
			}
			String plpzString=plpzData.substring(1,plpzData.length()-1);
			plpzString=plpzString.replaceAll("&nbsp;", " ");
			String p153="";
			String p154="";
			if(plpzString.split("@").length>0){
				if(plpzString.split("@")[0].indexOf("/")!=-1){
					p153=plpzString.split("@")[0].substring(1,plpzString.split("@")[0].indexOf("/"));
					p154=plpzString.split("@")[0].substring(plpzString.split("@")[0].length()-1,plpzString.split("@")[0].length());
				}else{
					p153=plpzString.split("@")[0];
					p154=plpzString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p153)){
				catalogA.setP153(p153);
			}
			if(!FieldUtil.isEmpty(p154)){
				catalogA.setP154(p154);
			}
			String p155="";
			if(plpzString.split("@").length>1){
				p155=plpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p155)){
				catalogA.setP155(p155);
			}
			String p187="";
			if(plpzString.split("@").length>2){
				p187=plpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p187)){
				catalogA.setP187(p187);
			}
			String p156="";
			if(plpzString.split("@").length>3){
				p156=plpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p156)){
				catalogA.setP156(p156);
			}
			String p157="";
			if(plpzString.split("@").length>4){
				p157=plpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p157)){
				catalogA.setP157(p157);
			}
			String p158="";
			if(plpzString.split("@").length>5){
				p158=plpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p158)){
				catalogA.setP158(p158);
			}
			String p159="";
			if(plpzString.split("@").length>6){
				p159=plpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p159)){
				catalogA.setP159(p159);
			}
			String p197="";
			if(plpzString.split("@").length>7){
				p197=plpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p197)){
				catalogA.setP197(p197);
			}
			String p160="";
			if(plpzString.split("@").length>8){
				p160=plpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p160)){
				catalogA.setP160(p160);
			}
			String p161="";
			if(plpzString.split("@").length>9){
				p161=plpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p161)){
				catalogA.setP161(p161);
			}
			String p162="";
			if(plpzString.split("@").length>11){
				p162=plpzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p162)){
				catalogA.setP162(p162);
			}
			String p188="";
			if(plpzString.split("@").length>12){
				p188=plpzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p188)){
				catalogA.setP188(p188);
			}
			String p163="";
			if(plpzString.split("@").length>13){
				p163=plpzString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p163)){
				catalogA.setP163(p163);
			}
			String ktpzString=ktpzData.substring(1,ktpzData.length()-1);
			ktpzString=ktpzString.replaceAll("&nbsp;", " ");
			String p164="";
			if(ktpzString.split("@").length>0){
				p164=ktpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p164)){
				catalogA.setP164(p164);
			}
			String p166="";
			if(ktpzString.split("@").length>1){
				p166=ktpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p166)){
				catalogA.setP166(p166);
			}
			String p167="";
			if(ktpzString.split("@").length>2){
				p167=ktpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p167)){
				catalogA.setP167(p167);
			}
			String p168="";
			if(ktpzString.split("@").length>3){
				p168=ktpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p168)){
				catalogA.setP168(p168);
			}
			String p169="";
			if(ktpzString.split("@").length>4){
				p169=ktpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p169)){
				catalogA.setP169(p169);
			}
			String p170="";
			if(ktpzString.split("@").length>5){
				p170=ktpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p170)){
				catalogA.setP170(p170);
			}
			String gkjpzString=gkjpzData.substring(1,gkjpzData.length()-1);
			gkjpzString=gkjpzString.replaceAll("&nbsp;", " ");
			String p171="";
			if(gkjpzString.split("@").length>0){
				p171=gkjpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p171)){
				catalogA.setP171(p171);
			} 
			String p172="";
			if(gkjpzString.split("@").length>2){
				p172=gkjpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p172)){
				catalogA.setP172(p172);
			} 
			String p189="";
			if(gkjpzString.split("@").length>4){
				p189=gkjpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p189)){
				catalogA.setP189(p189);
			} 
			String p190="";
			if(gkjpzString.split("@").length>5){
				p190=gkjpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p190)){
				catalogA.setP190(p190);
			} 
			String p173="";
			if(gkjpzString.split("@").length>6){
				p173=gkjpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p173)){
				catalogA.setP173(p173);
			} 
			String p191="";
			if(gkjpzString.split("@").length>7){
				p191=gkjpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p191)){
				catalogA.setP191(p191);
			}
			String p174="";
			if(gkjpzString.split("@").length>8){
				p174=gkjpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p174)){
				catalogA.setP174(p174);
			} 
			String p175="";
			if(gkjpzString.split("@").length>9){
				p175=gkjpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p175)){
				catalogA.setP175(p175);
			} 
			if(!FieldUtil.isEmpty(ysData)){
				catalogA.setP200(ysData);
			}
			DboCarAutohomepropDao.update(catalogA);
			RedisDao.UpDateAutohomepropByOne(catalogId, catalogA,oldAutohomeprops.get(0));
			Map<String, String> cataMap=RedisDao.getCatalognewById(catalogId);
			int pathLevel=Integer.parseInt(cataMap.get("pathlevel"));
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				//NewsAdmService.delNewsHtmlByCarcatalogid(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(cid));
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String UpDateCarDateThree(){
		try{
			String catalogName=DboCarCatalognewDao.where(" catalogid = "+catalogId).get(0).getCatalogname();
			String carSql=" carid = "+catalogId;
			int cid=0;
			List<DboCarAutohomeprop> catalogList=DboCarAutohomepropDao.where(carSql);
			if(catalogList.size()>0){
				cid=catalogList.get(0).getId();
			}else{
				int id=SeqDao.getNextId("dbo_car_autohomeprop");
				DboCarAutohomeprop catalog=new DboCarAutohomeprop();
				cid=id;
				catalog.setCarid(catalogId);
				catalog.setId(id);
				catalog.setP1(catalogName);
				try{
					DboCarAutohomepropDao.save(catalog);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			List<DboCarAutohomeprop> oldAutohomeprops=DboCarAutohomepropDao.where(" carid = "+catalogId);
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			catalogA.setId(cid);
			catalogA.setCarid(catalogId);
			String jbcsString=jbcsData.substring(1,jbcsData.length()-1 );
			String p1="";
			if(jbcsString.split("@").length>0){ 
				p1=jbcsString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p1)){
				catalogA.setP1(p1);
			}
			String p2="";
			if(jbcsString.split("@").length>1){
				p2=jbcsString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p2)){
				if(p2.indexOf("~")!=-1){
					p2=p2.substring(0,p2.indexOf("~"));
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}else{
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}
				
				catalogA.setP2(p2);
			}
			String p192="";
			if(jbcsString.split("@").length>2){
				p192=jbcsString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p192)){
				catalogA.setP192(p192);
			}
			String p4="";
			if(jbcsString.split("@").length>3){
				p4=jbcsString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p4)){
				catalogA.setP4(p4);
			}
			String p5="";
			if(jbcsString.split("@").length>4){
				p5=jbcsString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p5)){
				catalogA.setP5(p5);
			}
			String p6="";
			if(jbcsString.split("@").length>5){
				p6=jbcsString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p6)){
				catalogA.setP6(p6);
			}
			String p7="";
			if(jbcsString.split("@").length>6){
				p7=jbcsString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p7)){
				catalogA.setP7(p7);
			}
			String p8="";
			if(jbcsString.split("@").length>7){
				p8=jbcsString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p8)){
				catalogA.setP8(p8);
			}
			String p9="";
			if(jbcsString.split("@").length>8){
				p9=jbcsString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p9)){
				catalogA.setP9(p9);
			}
			String p10="";
			if(jbcsString.split("@").length>9){
				p10=jbcsString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p10)){
				catalogA.setP10(p10);
			}
			String p13="";
			if(jbcsString.split("@").length>10){
				p13=jbcsString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p13)){
				catalogA.setP13(p13);
			}
			String p14="";
			if(jbcsString.split("@").length>11){
				p14=jbcsString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p14)){
				catalogA.setP14(p14);
			}
			String p15="";
			if(jbcsString.split("@").length>12){
				p15=jbcsString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p15)){
				catalogA.setP15(p15);
			}
			String p193="";
			if(jbcsString.split("@").length>13){
				p193=jbcsString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p193)){
				catalogA.setP193(p193);
			}
//			String p23="";
//			if(jbcsString.split("@").length>14){
//				p23=jbcsString.split("@")[14];
//			}
			String p16="";
			if(jbcsString.split("@").length>15){
				p16=jbcsString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p16)){
				catalogA.setP16(p16);
			}
			String p177="";
			if(jbcsString.split("@").length>16){
				p177=jbcsString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p177)){
				catalogA.setP177(p177);
			}
			String csString=csData.substring(1,csData.length()-1 );
			String p17="";
			if(csString.split("@").length>0){
				p17=csString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p17)){
				catalogA.setP17(p17);
			}
			String p18="";
			if(csString.split("@").length>1){
				p18=csString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p18)){
				catalogA.setP18(p18);
			}
			String p19="";
			if(csString.split("@").length>2){
				p19=csString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p19)){
				catalogA.setP19(p19);
			}
			String p20="";
			if(csString.split("@").length>3){
				p20=csString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p20)){
				catalogA.setP20(p20);
			}
			String p21="";
			if(csString.split("@").length>4){
				p21=csString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p21)){
				catalogA.setP21(p21);
			}
			String p22="";
			if(csString.split("@").length>5){
				p22=csString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p22)){
				catalogA.setP22(p22);
			}
			String p23="";
			if(csString.split("@").length>6){
				p23=csString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p23)){
				catalogA.setP23(p23);
			}
			String p24="";
			if(csString.split("@").length>7){
				p24=csString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p24)){
				catalogA.setP24(p24);
			}
			String p25="";
			if(csString.split("@").length>8){
				p25=csString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p25)){
				catalogA.setP25(p25);
			}
			String p26="";
			if(csString.split("@").length>9){
				p26=csString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p26)){
				catalogA.setP26(p26);
			}
			String p27="";
			if(csString.split("@").length>10){
				p27=csString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p27)){
				catalogA.setP27(p27);
			}
			String p28="";
			if(csString.split("@").length>11){
				p28=csString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p28)){
				catalogA.setP28(p28);
			}
			String p29="";
			if(csString.split("@").length>12){
				p29=csString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p29)){
				catalogA.setP29(p29);
			}
			String fdjString=fdjData.substring(1,fdjData.length()-1 );
			String p194="";
			if(fdjString.split("@").length>0){
				p194=fdjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p194)){
				catalogA.setP194(p194);
			}
			String p30="";
			if(fdjString.split("@").length>1){
				p30=fdjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p30)){
				catalogA.setP30(p30);
			}
			String p31="";
			if(fdjString.split("@").length>2){
				p31=fdjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p31)){
				catalogA.setP31(p31);
			}
			String p32="";
			if(fdjString.split("@").length>3){
				p32=fdjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p32)){
				catalogA.setP32(p32);
			}
			String p33="";
			if(fdjString.split("@").length>4){
				p33=fdjString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p33)){
				catalogA.setP33(p33);
			}
			String p34="";
			if(fdjString.split("@").length>5){
				p34=fdjString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p34)){
				catalogA.setP34(p34);
			}
			String p35="";
			if(fdjString.split("@").length>6){
				p35=fdjString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p35)){
				catalogA.setP35(p35);
			}
			String p36="";
			if(fdjString.split("@").length>7){
				p36=fdjString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p36)){
				catalogA.setP36(p36);
			}
			String p37="";
			if(fdjString.split("@").length>8){
				p37=fdjString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p37)){
				catalogA.setP37(p37);
			}
			String p38="";
			if(fdjString.split("@").length>9){
				p38=fdjString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p38)){
				catalogA.setP38(p38);
			}
			String p39="";
			if(fdjString.split("@").length>10){
				p39=fdjString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p39)){
				catalogA.setP39(p39);
			}
			String p40="";
			if(fdjString.split("@").length>11){
				p40=fdjString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p40)){
				catalogA.setP40(p40);
			}
			String p41="";
			if(fdjString.split("@").length>12){
				p41=fdjString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p41)){
				catalogA.setP41(p41);
			}
			String p42="";
			if(fdjString.split("@").length>13){
				p42=fdjString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p42)){
				catalogA.setP42(p42);
			}
			String p43="";
			if(fdjString.split("@").length>14){
				p43=fdjString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p43)){
				catalogA.setP43(p43);
			}
			String p44="";
			if(fdjString.split("@").length>15){
				p44=fdjString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p44)){
				catalogA.setP44(p44);
			}
			String p45="";
			if(fdjString.split("@").length>16){
				p45=fdjString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p45)){
				catalogA.setP45(p45);
			}
			String p46="";
			if(fdjString.split("@").length>17){
				p46=fdjString.split("@")[17];
			}
			if(!FieldUtil.isEmpty(p46)){
				catalogA.setP46(p46);
			}
			String p47="";
			if(fdjString.split("@").length>18){
				p47=fdjString.split("@")[18];
			}
			if(!FieldUtil.isEmpty(p47)){
				catalogA.setP47(p47);
			}
			String p48="";
			if(fdjString.split("@").length>19){
				p48=fdjString.split("@")[19];
			}
			if(!FieldUtil.isEmpty(p48)){
				catalogA.setP48(p48);
			}
			String p49="";
			if(fdjString.split("@").length>20){
				p49=fdjString.split("@")[20];
			}
			if(!FieldUtil.isEmpty(p49)){
				catalogA.setP49(p49);
			}
			String p50="";
			if(fdjString.split("@").length>21){
				p50=fdjString.split("@")[21];
			}
			if(!FieldUtil.isEmpty(p50)){
				catalogA.setP50(p50);
			}
			String p51="";
			if(fdjString.split("@").length>22){
				p51=fdjString.split("@")[22];
			}
			if(!FieldUtil.isEmpty(p51)){
				catalogA.setP51(p51);
			}
			String ddjString=ddjData.substring(1,ddjData.length()-1);
			String p205="";
			if(ddjString.split("@").length>0){
				p205=ddjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p205)){
				catalogA.setP205(p205);
			}
			String p206="";
			if(ddjString.split("@").length>1){
				p206=ddjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p206)){
				catalogA.setP206(p206);
			}
			String p207="";
			if(ddjString.split("@").length>2){
				p207=ddjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p207)){
				catalogA.setP207(p207);
			}
			String p208="";
			if(ddjString.split("@").length>3){
				p208=ddjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p208)){
				catalogA.setP208(p208);
			}
			String bsxString=bsxData.substring(1,bsxData.length()-1 );
			String p52="";
			if(bsxString.split("@").length>0){
				p52=bsxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p52)){
				catalogA.setP52(p52);
			}
			String p53="";
			if(bsxString.split("@").length>1){
				p53=bsxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p53)){
				catalogA.setP53(p53);
			}
			String p54="";
			if(bsxString.split("@").length>2){
				p54=bsxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p54)){
				catalogA.setP54(p54);
			}
			String dfzxString=dfzxData.substring(1,dfzxData.length()-1 );
			String p55="";
			if(dfzxString.split("@").length>0){
				p55=dfzxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p55)){
				catalogA.setP55(p55);
			}
			String p56="";
			if(dfzxString.split("@").length>1){
				p56=dfzxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p56)){
				catalogA.setP56(p56);
			}
			String p57="";
			if(dfzxString.split("@").length>2){
				p57=dfzxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p57)){
				catalogA.setP57(p57);
			}
			String p58="";
			if(dfzxString.split("@").length>3){
				p58=dfzxString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p58)){
				catalogA.setP58(p58);
			}
			String p59="";
			if(dfzxString.split("@").length>4){
				p59=dfzxString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p59)){
				catalogA.setP59(p59);
			}
			String clzdString=clzdData.substring(1,clzdData.length()-1 );
			String p60="";
			if(clzdString.split("@").length>0){
				p60=clzdString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p60)){
				catalogA.setP60(p60);
			}
			String p61="";
			if(clzdString.split("@").length>1){
				p61=clzdString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p61)){
				catalogA.setP61(p61);
			}
			String p62="";
			if(clzdString.split("@").length>2){
				p62=clzdString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p62)){
				catalogA.setP62(p62);
			}
			String p63="";
			if(clzdString.split("@").length>3){
				p63=clzdString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p63)){
				catalogA.setP63(p63);
			}
			String p64="";
			if(clzdString.split("@").length>4){
				p64=clzdString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p64)){
				catalogA.setP64(p64);
			}
			String p65="";
			if(clzdString.split("@").length>5){
				p65=clzdString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p65)){
				catalogA.setP65(p65);
			}
			String aqzbString=aqzbData.substring(1,aqzbData.length()-1 );
			aqzbString=aqzbString.replaceAll("&nbsp;", " ");
			String p66="";
			String p67="";
			if(aqzbString.split("@").length>0){
				if(aqzbString.split("@")[0].indexOf("/")!=-1){
					p66=aqzbString.split("@")[0].substring(1,aqzbString.split("@")[0].indexOf("/"));
					p67=aqzbString.split("@")[0].substring(aqzbString.split("@")[0].length()-1,aqzbString.split("@")[0].length());
				}else{
					p66=aqzbString.split("@")[0];
					p67=aqzbString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p66)){
				catalogA.setP66(p66);
			}
			if(!FieldUtil.isEmpty(p67)){
				catalogA.setP67(p67);
			}
			String p68="";
			String p69="";
			if(aqzbString.split("@").length>1){
				if(aqzbString.split("@")[1].indexOf("/")!=-1){
					p68=aqzbString.split("@")[1].substring(1,aqzbString.split("@")[1].indexOf("/"));
					p69=aqzbString.split("@")[1].substring(aqzbString.split("@")[1].length()-1,aqzbString.split("@")[1].length());
				}else{
					p68=aqzbString.split("@")[1];
					p69=aqzbString.split("@")[1];
				}
			}
			if(!FieldUtil.isEmpty(p68)){
				catalogA.setP68(p68);
			}
			if(!FieldUtil.isEmpty(p69)){
				catalogA.setP69(p69);
			}
			String p70="";
			String p71="";
			if(aqzbString.split("@").length>2){
				if(aqzbString.split("@")[2].indexOf("/")!=-1){
					p70=aqzbString.split("@")[2].substring(1,aqzbString.split("@")[2].indexOf("/"));
					p71=aqzbString.split("@")[2].substring(aqzbString.split("@")[2].length()-1,aqzbString.split("@")[2].length());
				}else{
					p70=aqzbString.split("@")[2];
					p71=aqzbString.split("@")[2];
				}
			}
			if(!FieldUtil.isEmpty(p70)){
				catalogA.setP70(p70);
			}
			if(!FieldUtil.isEmpty(p71)){
				catalogA.setP71(p71);
			}
			String p72="";
			if(aqzbString.split("@").length>3){
				p72=aqzbString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p72)){
				catalogA.setP72(p72);
			}
			String p87="";
			if(aqzbString.split("@").length>4){
				p87=aqzbString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p87)){
				catalogA.setP87(p87);
			}
			String p88="";
			if(aqzbString.split("@").length>5){
				p88=aqzbString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p88)){
				catalogA.setP88(p88);
			}
			String p73="";
			if(aqzbString.split("@").length>6){
				p73=aqzbString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p73)){
				catalogA.setP73(p73);
			}
			String p198="";
			if(aqzbString.split("@").length>7){
				p198=aqzbString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p198)){
				catalogA.setP198(p198);
			}
			String p74="";
			if(aqzbString.split("@").length>8){
				p74=aqzbString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p74)){
				catalogA.setP74(p74);
			}
			String p75="";
			if(aqzbString.split("@").length>9){
				p75=aqzbString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p75)){
				catalogA.setP75(p75);
			}
			String p76="";
			if(aqzbString.split("@").length>10){
				p76=aqzbString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p76)){
				catalogA.setP76(p76);
			}
			String p77="";
			if(aqzbString.split("@").length>11){
				p77=aqzbString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p77)){
				catalogA.setP77(p77);
			}
			String czpzString=czpzData.substring(1,czpzData.length()-1 );
			czpzString=czpzString.replaceAll("&nbsp;", " ");
			String p78="";
			if(czpzString.split("@").length>0){
				p78=czpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p78)){
				catalogA.setP78(p78);
			}
			String p79="";
			if(czpzString.split("@").length>1){
				p79=czpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p79)){
				catalogA.setP79(p79);
			}
			String p80="";
			if(czpzString.split("@").length>2){
				p80=czpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p80)){
				catalogA.setP80(p80);
			}
			String p81="";
			if(czpzString.split("@").length>3){
				p81=czpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p81)){
				catalogA.setP81(p81);
			}
			String p82="";
			if(czpzString.split("@").length>4){
				p82=czpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p82)){
				catalogA.setP82(p82);
			}
			String p83="";
			if(czpzString.split("@").length>5){
				p83=czpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p83)){
				catalogA.setP83(p83);
			}
			String p84="";
			if(czpzString.split("@").length>7){
				p84=czpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p84)){
				catalogA.setP84(p84);
			}
			String p85="";
			if(czpzString.split("@").length>8){
				p85=czpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p85)){
				catalogA.setP85(p85);
			}
			String p86="";
			if(czpzString.split("@").length>9){
				p86=czpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p86)){
				catalogA.setP86(p86);
			}
			String p89="";
			if(czpzString.split("@").length>10){
				p89=czpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p89)){
				catalogA.setP89(p89);
			}
			String wbpzString=wbpzData.substring(1,wbpzData.length()-1 );
			wbpzString=wbpzString.replaceAll("&nbsp;", " ");
			String p90="";
			if(wbpzString.split("@").length>0){
				p90=wbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p90)){
				catalogA.setP90(p90);
			}
			String p91="";
			if(wbpzString.split("@").length>1){
				p91=wbpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p91)){
				catalogA.setP91(p91);
			}
			String p94="";
			if(wbpzString.split("@").length>2){
				p94=wbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p94)){
				catalogA.setP94(p94);
			}
			String p95="";
			if(wbpzString.split("@").length>3){
				p95=wbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p95)){
				catalogA.setP95(p95);
			}
			String p180="";
			if(wbpzString.split("@").length>4){
				p180=wbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p180)){
				catalogA.setP180(p180);
			}
			String p126="";
			if(wbpzString.split("@").length>6){
				p126=wbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p126)){
				catalogA.setP126(p126);
			}
			String nbpzString=nbpzData.substring(1,nbpzData.length()-1 );
			nbpzString=nbpzString.replaceAll("&nbsp;", " ");
			String p96="";
			if(nbpzString.split("@").length>0){
				p96=nbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p96)){
				catalogA.setP96(p96);
			}
			String p97="";
			String p98="";
			if(nbpzString.split("@").length>1){
				if(nbpzString.split("@")[1].length()>0){
					
					if(nbpzString.split("@")[1].indexOf("+")!=-1){
						p97="●";
						p98="●";
					}else{
						if(nbpzString.split("@")[1].substring(0,1).equals("上下")){
							p97="●";
							p98="-";
						}else{
							p97="-";
							p98="●";
						}
					}
				}
				
			}
			if(!FieldUtil.isEmpty(p97)){
				catalogA.setP97(p97);
			}
			if(!FieldUtil.isEmpty(p98)){
				catalogA.setP98(p98);
			}
			String p181="";
			if(nbpzString.split("@").length>2){
				p181=nbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p181)){
				catalogA.setP181(p181);
			}
			String p99="";
			if(nbpzString.split("@").length>3){
				p99=nbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p99)){
				catalogA.setP99(p99);
			}
			String p100="";
			if(nbpzString.split("@").length>4){
				p100=nbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p100)){
				catalogA.setP100(p100);
			}
			String p101="";
			if(nbpzString.split("@").length>6){
				p101=nbpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p101)){
				catalogA.setP101(p101);
			}
			String p103="";
			if(nbpzString.split("@").length>8){
				p103=nbpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p103)){
				catalogA.setP103(p103);
			}
			String p104="";
			if(nbpzString.split("@").length>9){
				p104=nbpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p104)){
				catalogA.setP104(p104);
			}
			String p105="";
			if(nbpzString.split("@").length>10){
				p105=nbpzString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p105)){
				catalogA.setP105(p105);
			}
			String zypzString=zypzData.substring(1,zypzData.length()-1 );
			zypzString=zypzString.replaceAll("&nbsp;", " ");
			String p107="";
			if(zypzString.split("@").length>0){
				p107=zypzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p107)){
				catalogA.setP107(p107);
			}
			String p108="";
			if(zypzString.split("@").length>1){
				p108=zypzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p108)){
				catalogA.setP108(p108);
			}
			String p109="";
			if(zypzString.split("@").length>2){
				p109=zypzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p109)){
				catalogA.setP109(p109);
			}
			String p110="";
			if(zypzString.split("@").length>3){
				p110=zypzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p110)){
				catalogA.setP110(p110);
			}
			String p182="";
			if(zypzString.split("@").length>4){
				p182=zypzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p182)){
				catalogA.setP182(p182);
			}
			String p195="";
			if(zypzString.split("@").length>6){
				p195=zypzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p195)){
				catalogA.setP195(p195);
			}
			String p196="";
			if(zypzString.split("@").length>7){
				p196=zypzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p196)){
				catalogA.setP196(p196);
			}
			String p113="";
			if(zypzString.split("@").length>8){
				p113=zypzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p113)){
				catalogA.setP113(p113);
			}
			String p114="";
			if(zypzString.split("@").length>9){
				p114=zypzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p114)){
				catalogA.setP114(p114);
			}
			String p115="";
			String p116="";
			if(zypzString.split("@").length>10){
				if(zypzString.split("@")[10].indexOf("/")!=-1){
					p115=zypzString.split("@")[10].substring(1,zypzString.split("@")[10].indexOf("/"));
					p116=zypzString.split("@")[10].substring(zypzString.split("@")[10].length()-1,zypzString.split("@")[10].length());
				}else{
					p115=zypzString.split("@")[10];
					p116=zypzString.split("@")[10];
				}
			}
			
			if(!FieldUtil.isEmpty(p115)){
				catalogA.setP115(p115);
			}
			if(!FieldUtil.isEmpty(p116)){
				catalogA.setP116(p116);
			}
			String p117="";
			if(zypzString.split("@").length>11){
				p117=zypzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p117)){
				catalogA.setP117(p117);
			}
			String p118="";
			if(zypzString.split("@").length>12){
				p118=zypzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p118)){
				catalogA.setP118(p118);
			}
			String p119="";
			String p120="";
			if(zypzString.split("@").length>13){
				if(zypzString.split("@")[13].indexOf("整体放倒")!=-1){
					p119="●";
				}
				if(zypzString.split("@")[13].indexOf("比例放倒")!=-1){
					p120="●";
				}
			}
			if(!FieldUtil.isEmpty(p119)){
				catalogA.setP119(p119);
			}
			if(!FieldUtil.isEmpty(p120)){
				catalogA.setP120(p120);
			}
			String p121="";
			if(zypzString.split("@").length>14){
				p121=zypzString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p121)){
				catalogA.setP121(p121);
			}
			String p122="";
			String p123="";
			if(zypzString.split("@").length>15){
				if(zypzString.split("@")[15].indexOf("/")!=-1){
					p122=zypzString.split("@")[15].substring(1,zypzString.split("@")[15].indexOf("/"));
					p123=zypzString.split("@")[15].substring(zypzString.split("@")[15].length()-1,zypzString.split("@")[15].length());
				}else{
					p122=zypzString.split("@")[15];
					p123=zypzString.split("@")[15];
				}
			}
			if(!FieldUtil.isEmpty(p122)){
				catalogA.setP122(p122);
			}
			if(!FieldUtil.isEmpty(p123)){
				catalogA.setP123(p123);
			}
			String p125="";
			if(zypzString.split("@").length>16){
				p125=zypzString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p125)){
				catalogA.setP125(p125);
			}
			String dmtpzString=dmtpzData.substring(1,dmtpzData.length()-1);
			dmtpzString=dmtpzString.replaceAll("&nbsp;", " ");
			String p127="";
			if(dmtpzString.split("@").length>0){
				p127=dmtpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p127)){
				catalogA.setP127(p127);
			}
			String p183="";
			if(dmtpzString.split("@").length>1){
				p183=dmtpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p183)){
				catalogA.setP183(p183);
			}
			String p128="";
			if(dmtpzString.split("@").length>2){
				p128=dmtpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p128)){
				catalogA.setP128(p128);
			}
			String p130="";
			if(dmtpzString.split("@").length>3){
				p130=dmtpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p130)){
				catalogA.setP130(p130);
			}
			String p184="";
			if(dmtpzString.split("@").length>4){
				p184=dmtpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p184)){
				catalogA.setP184(p184);
			}
			String p132="";
			if(dmtpzString.split("@").length>5){
				p132=dmtpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p132)){
				catalogA.setP132(p132);
			}
			String p134="";
			if(dmtpzString.split("@").length>6){
				p134=dmtpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p134)){
				catalogA.setP134(p134);
			}
			String p135="";
			if(dmtpzString.split("@").length>7){
				p135=dmtpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p135)){
				catalogA.setP135(p135);
			}
			String p136="";
			if(dmtpzString.split("@").length>8){
				p136=dmtpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p136)){
				catalogA.setP136(p136);
			}
			String p137="";
			String p138="";
			String p139="";
			String p140="";
			if(dmtpzString.split("@").length>9){
				if(dmtpzString.split("@")[9].indexOf("单碟")!=-1){
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p137="●";
					}else{
						p139="●";
					}
				}else{
					if(dmtpzString.split("@")[9].indexOf("CD")!=-1){
						p138="●";
					}else{
						p140="●";
					}
				}
			}
			if(!FieldUtil.isEmpty(p137)){
				catalogA.setP137(p137);
			}
			if(!FieldUtil.isEmpty(p138)){
				catalogA.setP138(p138);
			}
			if(!FieldUtil.isEmpty(p139)){
				catalogA.setP139(p139);
			}
			if(!FieldUtil.isEmpty(p140)){
				catalogA.setP140(p140);
			}
			String p141="";
			String p142="";
			String p143="";
			String p144="";
			if(dmtpzString.split("@").length>11){
				if(dmtpzString.split("@")[11].indexOf("2-3")!=-1){
					p141="●";
				}
				if(dmtpzString.split("@")[11].indexOf("4-5")!=-1){
					p142="●";
				}
				if(dmtpzString.split("@")[11].indexOf("6-7")!=-1){
					p143="●";
				}
				if(dmtpzString.split("@")[11].indexOf("≥8")!=-1){
					p144="●";
				}
			}
			if(!FieldUtil.isEmpty(p141)){
				catalogA.setP141(p141);
			}
			if(!FieldUtil.isEmpty(p142)){
				catalogA.setP142(p142);
			}
			if(!FieldUtil.isEmpty(p143)){
				catalogA.setP143(p143);
			}
			if(!FieldUtil.isEmpty(p144)){
				catalogA.setP144(p144);
			}
			String dgpzString=dgpzData.substring(1,dgpzData.length()-1);
			dgpzString=dgpzString.replaceAll("&nbsp;", " ");
			String p145="";
			if(dgpzString.split("@").length>0){
				p145=dgpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p145)){
				catalogA.setP145(p145);
			}
			String p146="";
			if(dgpzString.split("@").length>2){
				p146=dgpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p146)){
				catalogA.setP146(p146);
			}
			String p147="";
			if(dgpzString.split("@").length>3){
				p147=dgpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p147)){
				catalogA.setP147(p147);
			}
			String p148="";
			if(dgpzString.split("@").length>4){
				p148=dgpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p148)){
				catalogA.setP148(p148);
			}
			String p149="";
			if(dgpzString.split("@").length>6){
				p149=dgpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p149)){
				catalogA.setP149(p149);
			}
			String p151="";
			if(dgpzString.split("@").length>7){
				p151=dgpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p151)){
				catalogA.setP151(p151);
			}
			String p152="";
			if(dgpzString.split("@").length>8){
				p152=dgpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p152)){
				catalogA.setP152(p152);
			}
			String p186="";
			if(dgpzString.split("@").length>9){
				p186=dgpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p186)){
				catalogA.setP186(p186);
			}
			String plpzString=plpzData.substring(1,plpzData.length()-1);
			plpzString=plpzString.replaceAll("&nbsp;", " ");
			String p153="";
			String p154="";
			if(plpzString.split("@").length>0){
				if(plpzString.split("@")[0].indexOf("/")!=-1){
					p153=plpzString.split("@")[0].substring(1,plpzString.split("@")[0].indexOf("/"));
					p154=plpzString.split("@")[0].substring(plpzString.split("@")[0].length()-1,plpzString.split("@")[0].length());
				}else{
					p153=plpzString.split("@")[0];
					p154=plpzString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p153)){
				catalogA.setP153(p153);
			}
			if(!FieldUtil.isEmpty(p154)){
				catalogA.setP154(p154);
			}
			String p155="";
			if(plpzString.split("@").length>1){
				p155=plpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p155)){
				catalogA.setP155(p155);
			}
			String p187="";
			if(plpzString.split("@").length>2){
				p187=plpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p187)){
				catalogA.setP187(p187);
			}
			String p156="";
			if(plpzString.split("@").length>3){
				p156=plpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p156)){
				catalogA.setP156(p156);
			}
			String p157="";
			if(plpzString.split("@").length>4){
				p157=plpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p157)){
				catalogA.setP157(p157);
			}
			String p158="";
			if(plpzString.split("@").length>5){
				p158=plpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p158)){
				catalogA.setP158(p158);
			}
			String p159="";
			if(plpzString.split("@").length>6){
				p159=plpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p159)){
				catalogA.setP159(p159);
			}
			String p197="";
			if(plpzString.split("@").length>7){
				p197=plpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p197)){
				catalogA.setP197(p197);
			}
			String p160="";
			if(plpzString.split("@").length>8){
				p160=plpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p160)){
				catalogA.setP160(p160);
			}
			String p161="";
			if(plpzString.split("@").length>9){
				p161=plpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p161)){
				catalogA.setP161(p161);
			}
			String p162="";
			if(plpzString.split("@").length>11){
				p162=plpzString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p162)){
				catalogA.setP162(p162);
			}
			String p188="";
			if(plpzString.split("@").length>12){
				p188=plpzString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p188)){
				catalogA.setP188(p188);
			}
			String p163="";
			if(plpzString.split("@").length>13){
				p163=plpzString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p163)){
				catalogA.setP163(p163);
			}
			String ktpzString=ktpzData.substring(1,ktpzData.length()-1);
			ktpzString=ktpzString.replaceAll("&nbsp;", " ");
			String p164="";
			if(ktpzString.split("@").length>0){
				p164=ktpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p164)){
				catalogA.setP164(p164);
			}
			String p166="";
			if(ktpzString.split("@").length>1){
				p166=ktpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p166)){
				catalogA.setP166(p166);
			}
			String p167="";
			if(ktpzString.split("@").length>2){
				p167=ktpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p167)){
				catalogA.setP167(p167);
			}
			String p168="";
			if(ktpzString.split("@").length>3){
				p168=ktpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p168)){
				catalogA.setP168(p168);
			}
			String p169="";
			if(ktpzString.split("@").length>4){
				p169=ktpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p169)){
				catalogA.setP169(p169);
			}
			String p170="";
			if(ktpzString.split("@").length>5){
				p170=ktpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p170)){
				catalogA.setP170(p170);
			}
			String gkjpzString=gkjpzData.substring(1,gkjpzData.length()-1);
			gkjpzString=gkjpzString.replaceAll("&nbsp;", " ");
			String p171="";
			if(gkjpzString.split("@").length>0){
				p171=gkjpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p171)){
				catalogA.setP171(p171);
			} 
			String p172="";
			if(gkjpzString.split("@").length>2){
				p172=gkjpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p172)){
				catalogA.setP172(p172);
			} 
			String p189="";
			if(gkjpzString.split("@").length>4){
				p189=gkjpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p189)){
				catalogA.setP189(p189);
			} 
			String p190="";
			if(gkjpzString.split("@").length>5){
				p190=gkjpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p190)){
				catalogA.setP190(p190);
			} 
			String p173="";
			if(gkjpzString.split("@").length>6){
				p173=gkjpzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p173)){
				catalogA.setP173(p173);
			} 
			String p191="";
			if(gkjpzString.split("@").length>7){
				p191=gkjpzString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p191)){
				catalogA.setP191(p191);
			}
			String p174="";
			if(gkjpzString.split("@").length>8){
				p174=gkjpzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p174)){
				catalogA.setP174(p174);
			} 
			String p175="";
			if(gkjpzString.split("@").length>9){
				p175=gkjpzString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p175)){
				catalogA.setP175(p175);
			} 
			if(!FieldUtil.isEmpty(ysData)){
				catalogA.setP200(ysData);
			}
			DboCarAutohomepropDao.update(catalogA);
			RedisDao.UpDateAutohomepropByOne(catalogId, catalogA,oldAutohomeprops.get(0));
			Map<String, String> cataMap=RedisDao.getCatalognewById(catalogId);
			int pathLevel=Integer.parseInt(cataMap.get("pathlevel"));
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				//NewsAdmService.delNewsHtmlByCarcatalogid(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(cid));
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String UpDateCarDateTwo(){
		try{
			String catalogName=DboCarCatalognewDao.where(" catalogid = "+catalogId).get(0).getCatalogname();
			String carSql=" carid = "+catalogId;
			int cid=0;
			List<DboCarAutohomeprop> catalogList=DboCarAutohomepropDao.where(carSql);
			if(catalogList.size()>0){
				cid=catalogList.get(0).getId();
			}else{
				int id=SeqDao.getNextId("dbo_car_autohomeprop");
				DboCarAutohomeprop catalog=new DboCarAutohomeprop();
				cid=id;
				catalog.setCarid(catalogId);
				catalog.setId(id);
				catalog.setP1(catalogName);
				try{
					DboCarAutohomepropDao.save(catalog);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			List<DboCarAutohomeprop> oldAutohomeprops=DboCarAutohomepropDao.where(" carid = "+catalogId);
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			catalogA.setId(cid);
			catalogA.setCarid(catalogId);
			String jbcsString=jbcsData.substring(1,jbcsData.length()-1 );
			String p1="";
			if(jbcsString.split("@").length>0){
				p1=jbcsString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p1)){
				catalogA.setP1(p1);
			}
			String p2="";
			if(jbcsString.split("@").length>1){
				p2=jbcsString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p2)){
				if(p2.indexOf("~")!=-1){
					p2=p2.substring(0,p2.indexOf("~"));
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}else{
					if(p2.indexOf("万")!=-1){
						p2=p2.substring(0,p2.indexOf("万"));
					}
				}
				
				catalogA.setP2(p2);
			}
			String p192="";
			if(jbcsString.split("@").length>2){
				p192=jbcsString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p192)){
				catalogA.setP192(p192);
			}
			String p4="";
			if(jbcsString.split("@").length>3){
				p4=jbcsString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p4)){
				catalogA.setP4(p4);
			}
			String p5="";
			if(jbcsString.split("@").length>4){
				p5=jbcsString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p5)){
				catalogA.setP5(p5);
			}
			String p6="";
			if(jbcsString.split("@").length>5){
				p6=jbcsString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p6)){
				catalogA.setP6(p6);
			}
			String p7="";
			if(jbcsString.split("@").length>6){
				p7=jbcsString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p7)){
				catalogA.setP7(p7);
			}
			String p8="";
			if(jbcsString.split("@").length>7){
				p8=jbcsString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p8)){
				catalogA.setP8(p8);
			}
			String p193="";
			if(jbcsString.split("@").length>8){
				p193=jbcsString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p193)){
				catalogA.setP193(p193);
			}
			String p16="";
			if(jbcsString.split("@").length>9){
				p16=jbcsString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p16)){
				catalogA.setP16(p16);
			}
			String csString=csData.substring(1,csData.length()-1 );
			String p17="";
			if(csString.split("@").length>0){
				p17=csString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p17)){
				catalogA.setP17(p17);
			}
			String p18="";
			if(csString.split("@").length>1){
				p18=csString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p18)){
				catalogA.setP18(p18);
			}
			String p19="";
			if(csString.split("@").length>2){
				p19=csString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p19)){
				catalogA.setP19(p19);
			}
			String p20="";
			if(csString.split("@").length>3){
				p20=csString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p20)){
				catalogA.setP20(p20);
			}
			String p21="";
			if(csString.split("@").length>4){
				p21=csString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p21)){
				catalogA.setP21(p21);
			}
			String p22="";
			if(csString.split("@").length>5){
				p22=csString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p22)){
				catalogA.setP22(p22);
			}
			String p23="";
			if(csString.split("@").length>6){
				p23=csString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p23)){
				catalogA.setP23(p23);
			}
			String p24="";
			if(csString.split("@").length>7){
				p24=csString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p24)){
				catalogA.setP24(p24);
			}
			String p25="";
			if(csString.split("@").length>8){
				p25=csString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p25)){
				catalogA.setP25(p25);
			}
			String p26="";
			if(csString.split("@").length>9){
				p26=csString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p26)){
				catalogA.setP26(p26);
			}
			String p27="";
			if(csString.split("@").length>10){
				p27=csString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p27)){
				catalogA.setP27(p27);
			}
			String p201="";
			if(csString.split("@").length>11){
				p201=csString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p201)){
				catalogA.setP201(p201);
			}
			String p202="";
			if(csString.split("@").length>12){
				p202=csString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p202)){
				catalogA.setP202(p202);
			}
			String p203="";
			if(csString.split("@").length>13){
				p203=csString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p203)){
				catalogA.setP203(p203);
			}
			String fdjString=fdjData.substring(1,fdjData.length()-1 );
			String p194="";
			if(fdjString.split("@").length>0){
				p194=fdjString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p194)){
				catalogA.setP194(p194);
			}
			String p30="";
			if(fdjString.split("@").length>1){
				p30=fdjString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p30)){
				catalogA.setP30(p30);
			}
			String p31="";
			if(fdjString.split("@").length>2){
				p31=fdjString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p31)){
				catalogA.setP31(p31);
			}
			String p32="";
			if(fdjString.split("@").length>3){
				p32=fdjString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p32)){
				catalogA.setP32(p32);
			}
			String p33="";
			if(fdjString.split("@").length>4){
				p33=fdjString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p33)){
				catalogA.setP33(p33);
			}
			String p34="";
			if(fdjString.split("@").length>5){
				p34=fdjString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p34)){
				catalogA.setP34(p34);
			}
			String p35="";
			if(fdjString.split("@").length>6){
				p35=fdjString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p35)){
				catalogA.setP35(p35);
			}
			String p36="";
			if(fdjString.split("@").length>7){
				p36=fdjString.split("@")[7];
			}
			if(!FieldUtil.isEmpty(p36)){
				catalogA.setP36(p36);
			}
			String p37="";
			if(fdjString.split("@").length>8){
				p37=fdjString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p37)){
				catalogA.setP37(p37);
			}
			String p38="";
			if(fdjString.split("@").length>9){
				p38=fdjString.split("@")[9];
			}
			if(!FieldUtil.isEmpty(p38)){
				catalogA.setP38(p38);
			}
			String p39="";
			if(fdjString.split("@").length>10){
				p39=fdjString.split("@")[10];
			}
			if(!FieldUtil.isEmpty(p39)){
				catalogA.setP39(p39);
			}
			String p40="";
			if(fdjString.split("@").length>11){
				p40=fdjString.split("@")[11];
			}
			if(!FieldUtil.isEmpty(p40)){
				catalogA.setP40(p40);
			}
			String p41="";
			if(fdjString.split("@").length>12){
				p41=fdjString.split("@")[12];
			}
			if(!FieldUtil.isEmpty(p41)){
				catalogA.setP41(p41);
			}
			String p42="";
			if(fdjString.split("@").length>13){
				p42=fdjString.split("@")[13];
			}
			if(!FieldUtil.isEmpty(p42)){
				catalogA.setP42(p42);
			}
			String p43="";
			if(fdjString.split("@").length>14){
				p43=fdjString.split("@")[14];
			}
			if(!FieldUtil.isEmpty(p43)){
				catalogA.setP43(p43);
			}
			String p44="";
			if(fdjString.split("@").length>15){
				p44=fdjString.split("@")[15];
			}
			if(!FieldUtil.isEmpty(p44)){
				catalogA.setP44(p44);
			}
			
			String p46="";
			if(fdjString.split("@").length>16){
				p46=fdjString.split("@")[16];
			}
			if(!FieldUtil.isEmpty(p46)){
				catalogA.setP46(p46);
			}
			String p47="";
			if(fdjString.split("@").length>17){
				p47=fdjString.split("@")[17];
			}
			if(!FieldUtil.isEmpty(p47)){
				catalogA.setP47(p47);
			}
			String p48="";
			if(fdjString.split("@").length>18){
				p48=fdjString.split("@")[18];
			}
			if(!FieldUtil.isEmpty(p48)){
				catalogA.setP48(p48);
			}
			String p49="";
			if(fdjString.split("@").length>19){
				p49=fdjString.split("@")[19];
			}
			if(!FieldUtil.isEmpty(p49)){
				catalogA.setP49(p49);
			}
			String p50="";
			if(fdjString.split("@").length>20){
				p50=fdjString.split("@")[20];
			}
			if(!FieldUtil.isEmpty(p50)){
				catalogA.setP50(p50);
			}
			String p51="";
			if(fdjString.split("@").length>21){
				p51=fdjString.split("@")[21];
			}
			if(!FieldUtil.isEmpty(p51)){
				catalogA.setP51(p51);
			}
			String bsxString=bsxData.substring(1,bsxData.length()-1 );
			String p52="";
			if(bsxString.split("@").length>0){
				p52=bsxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p52)){
				catalogA.setP52(p52);
			}
			String p53="";
			if(bsxString.split("@").length>1){
				p53=bsxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p53)){
				catalogA.setP53(p53);
			}
			String p54="";
			if(bsxString.split("@").length>2){
				p54=bsxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p54)){
				catalogA.setP54(p54);
			}
			String dfzxString=dfzxData.substring(1,dfzxData.length()-1 );
			String p55="";
			if(dfzxString.split("@").length>0){
				p55=dfzxString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p55)){
				catalogA.setP55(p55);
			}
			String p56="";
			if(dfzxString.split("@").length>1){
				p56=dfzxString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p56)){
				catalogA.setP56(p56);
			}
			String p57="";
			if(dfzxString.split("@").length>2){
				p57=dfzxString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p57)){
				catalogA.setP57(p57);
			}
			String p58="";
			if(dfzxString.split("@").length>3){
				p58=dfzxString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p58)){
				catalogA.setP58(p58);
			}
			String p59="";
			if(dfzxString.split("@").length>4){
				p59=dfzxString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p59)){
				catalogA.setP59(p59);
			}
			String clzdString=clzdData.substring(1,clzdData.length()-1 );
			String p60="";
			if(clzdString.split("@").length>0){
				p60=clzdString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p60)){
				catalogA.setP60(p60);
			}
			String p61="";
			if(clzdString.split("@").length>1){
				p61=clzdString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p61)){
				catalogA.setP61(p61);
			}
			String p63="";
			if(clzdString.split("@").length>2){
				p63=clzdString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p63)){
				catalogA.setP63(p63);
			}
			String p64="";
			if(clzdString.split("@").length>3){
				p64=clzdString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p64)){
				catalogA.setP64(p64);
			}
			String aqzbString=aqzbData.substring(1,aqzbData.length()-1 );
			aqzbString=aqzbString.replaceAll("&nbsp;", " ");
			String p66="";
			String p67="";
			if(aqzbString.split("@").length>0){
				if(aqzbString.split("@")[0].indexOf("/")!=-1){
					p66=aqzbString.split("@")[0].substring(1,aqzbString.split("@")[0].indexOf("/"));
					p67=aqzbString.split("@")[0].substring(aqzbString.split("@")[0].length()-1,aqzbString.split("@")[0].length());
				}else{
					p66=aqzbString.split("@")[0];
					p67=aqzbString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p66)){
				catalogA.setP66(p66);
			}
			if(!FieldUtil.isEmpty(p67)){
				catalogA.setP67(p67);
			}
			String p68="";
			String p69="";
			if(aqzbString.split("@").length>1){
				if(aqzbString.split("@")[1].indexOf("/")!=-1){
					p68=aqzbString.split("@")[1].substring(1,aqzbString.split("@")[1].indexOf("/"));
					p69=aqzbString.split("@")[1].substring(aqzbString.split("@")[1].length()-1,aqzbString.split("@")[1].length());
				}else{
					p68=aqzbString.split("@")[1];
					p69=aqzbString.split("@")[1];
				}
			}
			if(!FieldUtil.isEmpty(p68)){
				catalogA.setP68(p68);
			}
			if(!FieldUtil.isEmpty(p69)){
				catalogA.setP69(p69);
			}
			String p74="";
			if(aqzbString.split("@").length>2){
				p74=aqzbString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p74)){
				catalogA.setP74(p74);
			}
			String p75="";
			if(aqzbString.split("@").length>3){
				p75=aqzbString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p75)){
				catalogA.setP75(p75);
			}
			String p76="";
			if(aqzbString.split("@").length>4){
				p76=aqzbString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p76)){
				catalogA.setP76(p76);
			}
			String czpzString=czpzData.substring(1,czpzData.length()-1 );
			czpzString=czpzString.replaceAll("&nbsp;", " ");
			String p78="";
			if(czpzString.split("@").length>0){
				p78=czpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p78)){
				catalogA.setP78(p78);
			}
			String p79="";
			if(czpzString.split("@").length>1){
				p79=czpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p79)){
				catalogA.setP79(p79);
			}
			String p80="";
			if(czpzString.split("@").length>2){
				p80=czpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p80)){
				catalogA.setP80(p80);
			}
			String p81="";
			if(czpzString.split("@").length>3){
				p81=czpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p81)){
				catalogA.setP81(p81);
			}
			String p82="";
			if(czpzString.split("@").length>4){
				p82=czpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p82)){
				catalogA.setP82(p82);
			}
			String wbpzString=wbpzData.substring(1,wbpzData.length()-1 );
			wbpzString=wbpzString.replaceAll("&nbsp;", " ");
			String p90="";
			if(wbpzString.split("@").length>0){
				p90=wbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p90)){
				catalogA.setP90(p90);
			}
			String p91="";
			if(wbpzString.split("@").length>1){
				p91=wbpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p91)){
				catalogA.setP91(p91);
			}
			String p95="";
			if(wbpzString.split("@").length>2){
				p95=wbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p95)){
				catalogA.setP95(p95);
			}
			String nbpzString=nbpzData.substring(1,nbpzData.length()-1 );
			nbpzString=nbpzString.replaceAll("&nbsp;", " ");
			String p96="";
			if(nbpzString.split("@").length>0){
				p96=nbpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p96)){
				catalogA.setP96(p96);
			}
			String p99="";
			if(nbpzString.split("@").length>1){
				p99=nbpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p99)){
				catalogA.setP99(p99);
			}
			
			String p101="";
			if(nbpzString.split("@").length>2){
				p101=nbpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p101)){
				catalogA.setP101(p101);
			}
			String p204="";
			if(nbpzString.split("@").length>3){
				p204=nbpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p204)){
				catalogA.setP204(p204);
			}
			String p103="";
			if(nbpzString.split("@").length>4){
				p103=nbpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p103)){
				catalogA.setP103(p103);
			}
			String p104="";
			if(nbpzString.split("@").length>5){
				p104=nbpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p104)){
				catalogA.setP104(p104);
			}
			
			String zypzString=zypzData.substring(1,zypzData.length()-1 );
			zypzString=zypzString.replaceAll("&nbsp;", " ");
			String p107="";
			if(zypzString.split("@").length>0){
				p107=zypzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p107)){
				catalogA.setP107(p107);
			}
			String p109="";
			if(zypzString.split("@").length>1){
				p109=zypzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p109)){
				catalogA.setP109(p109);
			}
			String p110="";
			if(zypzString.split("@").length>2){
				p110=zypzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p110)){
				catalogA.setP110(p110);
			}
			String p111="";
			if(zypzString.split("@").length>3){
				p111=zypzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p111)){
				catalogA.setP111(p111);
			}
			String p195="";
			if(zypzString.split("@").length>4){
				p195=zypzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p195)){
				catalogA.setP195(p195);
			}
			String p196="";
			if(zypzString.split("@").length>5){
				p196=zypzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p196)){
				catalogA.setP196(p196);
			}
			String p115="";
			if(zypzString.split("@").length>6){
				p115=zypzString.split("@")[6];
			}
			if(!FieldUtil.isEmpty(p115)){
				catalogA.setP115(p115);
			}
			String p119="";
			String p120="";
			if(zypzString.split("@").length>7){
				if(zypzString.split("@")[7].indexOf("整体放倒")!=-1){
					p119="●";
				}
				if(zypzString.split("@")[7].indexOf("比例放倒")!=-1){
					p120="●";
				}
			}
			if(!FieldUtil.isEmpty(p119)){
				catalogA.setP119(p119);
			}
			if(!FieldUtil.isEmpty(p120)){
				catalogA.setP120(p120);
			}
			String p122="";
			if(zypzString.split("@").length>8){
				p122=zypzString.split("@")[8];
			}
			if(!FieldUtil.isEmpty(p122)){
				catalogA.setP122(p122);
			}
			String dmtpzString=dmtpzData.substring(1,dmtpzData.length()-1);
			dmtpzString=dmtpzString.replaceAll("&nbsp;", " ");
			String p127="";
			if(dmtpzString.split("@").length>0){
				p127=dmtpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p127)){
				catalogA.setP127(p127);
			}
			String p134="";
			if(dmtpzString.split("@").length>1){
				p134=dmtpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p134)){
				catalogA.setP134(p134);
			}
			String p135="";
			if(dmtpzString.split("@").length>2){
				p135=dmtpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p135)){
				catalogA.setP135(p135);
			}
			String p137="";
			String p138="";
			String p139="";
			String p140="";
			if(dmtpzString.split("@").length>3){
				if(dmtpzString.split("@")[3].indexOf("单碟")!=-1){
					if(dmtpzString.split("@")[3].indexOf("CD")!=-1){
						p137="●";
					}else{
						p139="●";
					}
				}else{
					if(dmtpzString.split("@")[3].indexOf("CD")!=-1){
						p138="●";
					}else{
						p140="●";
					}
				}
			}
			if(!FieldUtil.isEmpty(p137)){
				catalogA.setP137(p137);
			}
			if(!FieldUtil.isEmpty(p138)){
				catalogA.setP138(p138);
			}
			if(!FieldUtil.isEmpty(p139)){
				catalogA.setP139(p139);
			}
			if(!FieldUtil.isEmpty(p140)){
				catalogA.setP140(p140);
			}
			String dgpzString=dgpzData.substring(1,dgpzData.length()-1);
			dgpzString=dgpzString.replaceAll("&nbsp;", " ");
			String p145="";
			if(dgpzString.split("@").length>0){
				p145=dgpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p145)){
				catalogA.setP145(p145);
			}
			String p149="";
			if(dgpzString.split("@").length>1){
				p149=dgpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p149)){
				catalogA.setP149(p149);
			}
			String p151="";
			if(dgpzString.split("@").length>2){
				p151=dgpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p151)){
				catalogA.setP151(p151);
			}
			String plpzString=plpzData.substring(1,plpzData.length()-1);
			plpzString=plpzString.replaceAll("&nbsp;", " ");
			String p153="";
			String p154="";
			if(plpzString.split("@").length>0){
				if(plpzString.split("@")[0].indexOf("/")!=-1){
					p153=plpzString.split("@")[0].substring(1,plpzString.split("@")[0].indexOf("/"));
					p154=plpzString.split("@")[0].substring(plpzString.split("@")[0].length()-1,plpzString.split("@")[0].length());
				}else{
					p153=plpzString.split("@")[0];
					p154=plpzString.split("@")[0];
				}
			}
			if(!FieldUtil.isEmpty(p153)){
				catalogA.setP153(p153);
			}
			if(!FieldUtil.isEmpty(p154)){
				catalogA.setP154(p154);
			}
			String p156="";
			if(plpzString.split("@").length>1){
				p156=plpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p156)){
				catalogA.setP156(p156);
			}
			String p157="";
			if(plpzString.split("@").length>2){
				p157=plpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p157)){
				catalogA.setP157(p157);
			}
			String p160="";
			if(plpzString.split("@").length>3){
				p160=plpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p160)){
				catalogA.setP160(p160);
			}
			String p161="";
			if(plpzString.split("@").length>4){
				p161=plpzString.split("@")[4];
			}
			if(!FieldUtil.isEmpty(p161)){
				catalogA.setP161(p161);
			}
			
			String p188="";
			if(plpzString.split("@").length>5){
				p188=plpzString.split("@")[5];
			}
			if(!FieldUtil.isEmpty(p188)){
				catalogA.setP188(p188);
			}
			
			String ktpzString=ktpzData.substring(1,ktpzData.length()-1);
			ktpzString=ktpzString.replaceAll("&nbsp;", " ");
			String p164="";
			if(ktpzString.split("@").length>0){
				p164=ktpzString.split("@")[0];
			}
			if(!FieldUtil.isEmpty(p164)){
				catalogA.setP164(p164);
			}
			String p166="";
			if(ktpzString.split("@").length>1){
				p166=ktpzString.split("@")[1];
			}
			if(!FieldUtil.isEmpty(p166)){
				catalogA.setP166(p166);
			}
			String p167="";
			if(ktpzString.split("@").length>2){
				p167=ktpzString.split("@")[2];
			}
			if(!FieldUtil.isEmpty(p167)){
				catalogA.setP167(p167);
			}
			String p168="";
			if(ktpzString.split("@").length>3){
				p168=ktpzString.split("@")[3];
			}
			if(!FieldUtil.isEmpty(p168)){
				catalogA.setP168(p168);
			}
			if(!FieldUtil.isEmpty(ysData)){
				catalogA.setP200(ysData);
			}
			DboCarAutohomepropDao.update(catalogA);
			RedisDao.UpDateAutohomepropByOne(catalogId, catalogA,oldAutohomeprops.get(0));
			Map<String, String> cataMap=RedisDao.getCatalognewById(catalogId);
			int pathLevel=Integer.parseInt(cataMap.get("pathlevel"));
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(Integer.parseInt(cataMap.get("fatherid")));
				//NewsAdmService.delNewsHtmlByCarcatalogid(Integer.parseInt(cataMap.get("fatherid")));
				DeleteCarParamFileUtil.deleteFile(Integer.parseInt(cataMap.get("fatherid")), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(catalogId, cataMap.get("englishname"));
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(cid));
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getJbcsData() {
		return jbcsData;
	}

	public void setJbcsData(String jbcsData) {
		this.jbcsData = jbcsData;
	}

	public String getCsData() {
		return csData;
	}

	public void setCsData(String csData) {
		this.csData = csData;
	}

	public String getFdjData() {
		return fdjData;
	}

	public void setFdjData(String fdjData) {
		this.fdjData = fdjData;
	}

	public String getBsxData() {
		return bsxData;
	}

	public void setBsxData(String bsxData) {
		this.bsxData = bsxData;
	}

	public String getDfzxData() {
		return dfzxData;
	}

	public void setDfzxData(String dfzxData) {
		this.dfzxData = dfzxData;
	}

	public String getClzdData() {
		return clzdData;
	}

	public void setClzdData(String clzdData) {
		this.clzdData = clzdData;
	}

	public String getAqzbData() {
		return aqzbData;
	}

	public void setAqzbData(String aqzbData) {
		this.aqzbData = aqzbData;
	}

	public String getCzpzData() {
		return czpzData;
	}

	public void setCzpzData(String czpzData) {
		this.czpzData = czpzData;
	}

	public String getWbpzData() {
		return wbpzData;
	}

	public void setWbpzData(String wbpzData) {
		this.wbpzData = wbpzData;
	}

	public String getNbpzData() {
		return nbpzData;
	}

	public void setNbpzData(String nbpzData) {
		this.nbpzData = nbpzData;
	}

	public String getZypzData() {
		return zypzData;
	}

	public void setZypzData(String zypzData) {
		this.zypzData = zypzData;
	}

	public String getDmtpzData() {
		return dmtpzData;
	}

	public void setDmtpzData(String dmtpzData) {
		this.dmtpzData = dmtpzData;
	}

	public String getDgpzData() {
		return dgpzData;
	}

	public void setDgpzData(String dgpzData) {
		this.dgpzData = dgpzData;
	}

	public String getPlpzData() {
		return plpzData;
	}

	public void setPlpzData(String plpzData) {
		this.plpzData = plpzData;
	}

	public String getKtpzData() {
		return ktpzData;
	}

	public void setKtpzData(String ktpzData) {
		this.ktpzData = ktpzData;
	}

	public String getGkjpzData() {
		return gkjpzData;
	}

	public void setGkjpzData(String gkjpzData) {
		this.gkjpzData = gkjpzData;
	}
}
