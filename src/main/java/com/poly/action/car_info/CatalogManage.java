package com.poly.action.car_info;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import car_beans.DboCarAutohomeprop;
import car_beans.DboCarCatalognew;
import car_daos.BaseDao;
import car_daos.DboCarAutohomepropDao;
import car_daos.DboCarCatalognewDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.util.FieldUtil;
import com.redis.RedisManager;
import com.redis.RedisParseUtil;

public class CatalogManage extends MyActionSupport{

	private int catalogId2;
	public int getCatalogId2() {
		return catalogId2;
	}

	public void setCatalogId2(int catalogId2) {
		this.catalogId2 = catalogId2;
	}
	private int catalogId;
	private DboCarAutohomeprop carCatalog;
	private String saveA="";
	private String saveB="";
	private String saveC="";
	private String saveD="";
	private String saveE="";
	private String saveF="";
	private String saveG="";
	private String saveH="";
	private String saveI="";
	private String saveJ="";
	private String saveK="";
	private String saveL="";
	private String saveM="";
	private String saveN="";
	private String saveO="";
	private String saveP="";
	private String saveQ="";
	
	public String execute(){
//		System.out.print(catalogId);
		String csql=" carid ="+catalogId;
		if(DboCarAutohomepropDao.where(csql).size()!=0){
			carCatalog=DboCarAutohomepropDao.where(csql).get(0);
		}else{
			DboCarAutohomeprop car=new DboCarAutohomeprop();
			int id=SeqDao.getNextId("dbo_car_autohomeprop");
			String ids=String.valueOf(id);
			List<DboCarCatalognew> cList=DboCarCatalognewDao.where("catalogid ="+catalogId);
			String name=cList.get(0).getCatalogname();
			car.setId(id);
			car.setP1(name);
			car.setCarid(catalogId);
			try{
				DboCarAutohomepropDao.save(car);
				//RedisParseUtil.jedisPublish("inster", "dbo_car_autohomeprop", ids);
			}catch(Exception e){
				e.printStackTrace();
			}
			carCatalog=car;
		}
		return SUCCESS;
		
	}
	
	public String CatalogManageA(){
		setAjax("1");
		return AJAX;
		
	}
	
	public String SaveCatalogManageA(){
		try{
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p1="";
			if(saveA.split("@").length>1){
				p1=saveA.split("@")[1];
			}
			String p9="";
			if(saveA.split("@").length>2){
				p9=saveA.split("@")[2];
			}
			String p2="";
			if(saveA.split("@").length>3){
				p2=saveA.split("@")[3];
			}
			String p10="";
			if(saveA.split("@").length>4){
				p10=saveA.split("@")[4];
			}
			String p192="";
			if(saveA.split("@").length>5){
				p192=saveA.split("@")[5];
			}
			String p11="";
			if(saveA.split("@").length>6){
				p11=saveA.split("@")[6];
			}
			String p4="";
			if(saveA.split("@").length>7){
				p4=saveA.split("@")[7];
			}
			String p193="";
			if(saveA.split("@").length>8){
				p193=saveA.split("@")[8];
			}
			String p5="";
			if(saveA.split("@").length>9){
				p5=saveA.split("@")[9];
			}
			String p13="";
			if(saveA.split("@").length>10){
				p13=saveA.split("@")[10];
			}
			String p6="";
			if(saveA.split("@").length>11){
				p6=saveA.split("@")[11];
			}
			String p14="";
			if(saveA.split("@").length>12){
				p14=saveA.split("@")[12];
			}
			String p7="";
			if(saveA.split("@").length>13){
				p7=saveA.split("@")[13];
			}
			String p15="";
			if(saveA.split("@").length>14){
				p15=saveA.split("@")[14];
			}
			String p8="";
			if(saveA.split("@").length>15){
				p8=saveA.split("@")[15];
			}
			String p16="";
			if(saveA.split("@").length>16){
				p16=saveA.split("@")[16];
			}
			String p177="";
			if(saveA.split("@").length>17){
				p177=saveA.split("@")[17];
			}
			String p3="";
			if(saveA.split("@").length>18){
				p3=saveA.split("@")[18];
			}
			String sid=saveA.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p1)){
				catalogA.setP1(p1);
			}
			if(!FieldUtil.isEmpty(p9)){
				catalogA.setP9(p9);
			}
			if(!FieldUtil.isEmpty(p2)){
				catalogA.setP2(p2);
			}
			if(!FieldUtil.isEmpty(p10)){
				catalogA.setP10(p10);
			}
			if(!FieldUtil.isEmpty(p192)){
				catalogA.setP192(p192);
			}
			if(!FieldUtil.isEmpty(p11)){
				catalogA.setP11(p11);
			}
			if(!FieldUtil.isEmpty(p4)){
				catalogA.setP4(p4);
			}
			if(!FieldUtil.isEmpty(p193)){
				catalogA.setP193(p193);
			}
			if(!FieldUtil.isEmpty(p5)){
				catalogA.setP5(p5);
			}
			if(!FieldUtil.isEmpty(p13)){
				catalogA.setP13(p13);
			}
			if(!FieldUtil.isEmpty(p6)){
				catalogA.setP6(p6);
			}
			if(!FieldUtil.isEmpty(p14)){
				catalogA.setP14(p14);
			}
			if(!FieldUtil.isEmpty(p7)){
				catalogA.setP7(p7);
			}
			if(!FieldUtil.isEmpty(p15)){
				catalogA.setP15(p15);
			}
			if(!FieldUtil.isEmpty(p8)){
				catalogA.setP8(p8);
			}
			if(!FieldUtil.isEmpty(p16)){
				catalogA.setP16(p16);
			}
			if(!FieldUtil.isEmpty(p177)){
				catalogA.setP177(p177);
			}
			if(!FieldUtil.isEmpty(p3)){
				catalogA.setP3(p3);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	
	public String SaveCatalogManageB(){
		try{
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
//			var saveB=catalogId+"@"+p17+"@"+p24+"@"+p18+"@"+p25+"@"+p19+"@"+p26+"@"+p20+"@"+p27+"@"+p21+"@"+p28+"@"+p22+"@"+p29+"@"+p23;
			String p17="";
			if(saveB.split("@").length>1){
				p17=saveB.split("@")[1];
			}
			String p24="";
			if(saveB.split("@").length>2){
				p24=saveB.split("@")[2];
			}
			String p18="";
			if(saveB.split("@").length>3){
				p18=saveB.split("@")[3];
			}
			String p25="";
			if(saveB.split("@").length>4){
				p25=saveB.split("@")[4];
			}
			String p19="";
			if(saveB.split("@").length>5){
				p19=saveB.split("@")[5];
			}
			String p26="";
			if(saveB.split("@").length>6){
				p26=saveB.split("@")[6];
			}
			String p20="";
			if(saveB.split("@").length>7){
				p20=saveB.split("@")[7];
			}
			String p27="";
			if(saveB.split("@").length>8){
				p27=saveB.split("@")[8];
			}
			String p21="";
			if(saveB.split("@").length>9){
				p21=saveB.split("@")[9];
			}
			String p28="";
			if(saveB.split("@").length>10){
				p28=saveB.split("@")[10];
			}
			String p22="";
			if(saveB.split("@").length>11){
				p22=saveB.split("@")[11];
			}
			String p29="";
			if(saveB.split("@").length>12){
				p29=saveB.split("@")[12];
			}
			String p23="";
			if(saveB.split("@").length>13){
				p23=saveB.split("@")[13];
			}
			String sid=saveB.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p17)){
				catalogA.setP17(p17);
			}
			if(!FieldUtil.isEmpty(p24)){
				catalogA.setP24(p24);
			}
			if(!FieldUtil.isEmpty(p18)){
				catalogA.setP18(p18);
			}
			if(!FieldUtil.isEmpty(p25)){
				catalogA.setP25(p25);
			}
			if(!FieldUtil.isEmpty(p19)){
				catalogA.setP19(p19);
			}
			if(!FieldUtil.isEmpty(p26)){
				catalogA.setP26(p26);
			}
			if(!FieldUtil.isEmpty(p20)){
				catalogA.setP20(p20);
			}
			if(!FieldUtil.isEmpty(p27)){
				catalogA.setP127(p27);
			}
			if(!FieldUtil.isEmpty(p21)){
				catalogA.setP21(p21);
			}
			if(!FieldUtil.isEmpty(p28)){
				catalogA.setP28(p28);
			}
			if(!FieldUtil.isEmpty(p22)){
				catalogA.setP22(p22);
			}
			if(!FieldUtil.isEmpty(p29)){
				catalogA.setP29(p29);
			}
			if(!FieldUtil.isEmpty(p23)){
				catalogA.setP23(p23);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageC(){
		try{
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
//			var saveC=catalogId+"@"+p30+"@"+p41+"@"+p31+"@"+p42+"@"+p32+"@"+p43+"@"+p33+"@"+p44+"@"+p34+"@"+p45+"@"+p35+"@"+p46+"@"+p36+"@"+p47+"@"+p37+"@"+p48+"@"+p38+"@"+p49+"@"+p39+"@"+p50+"@"+p40+"@"+p51+"@"+p194;
			System.out.print("11111111111111111111111111111111111111");
			String p30="";
			if(saveC.split("@").length>1){
				p30=saveC.split("@")[1];
			}
			String p41="";
			if(saveC.split("@").length>2){
				p41=saveC.split("@")[2];
			}
			String p31="";
			if(saveC.split("@").length>3){
				p31=saveC.split("@")[3];
			}
			String p42="";
			if(saveC.split("@").length>4){
				p42=saveC.split("@")[4];
			}
			String p32="";
			if(saveC.split("@").length>5){
				p32=saveC.split("@")[5];
			}
			String p43="";
			if(saveC.split("@").length>6){
				p43=saveC.split("@")[6];
			}
			String p33="";
			if(saveC.split("@").length>7){
				p33=saveC.split("@")[7];
			}
			String p44="";
			if(saveC.split("@").length>8){
				p44=saveC.split("@")[8];
			}
			String p34="";
			if(saveC.split("@").length>9){
				p34=saveC.split("@")[9];
			}
			String p45="";
			if(saveC.split("@").length>10){
				p45=saveC.split("@")[10];
			}
			String p35="";
			if(saveC.split("@").length>11){
				p35=saveC.split("@")[11];
			}
			String p46="";
			if(saveC.split("@").length>12){
				p46=saveC.split("@")[12];
			}
			String p36="";
			if(saveC.split("@").length>13){
				p36=saveC.split("@")[13];
			}
			String p47="";
			if(saveC.split("@").length>14){
				p47=saveC.split("@")[14];
			}
			String p37="";
			if(saveC.split("@").length>15){
				p37=saveC.split("@")[15];
			}
			String p48="";
			if(saveC.split("@").length>16){
				p48=saveC.split("@")[16];
			}
			String p38="";
			if(saveC.split("@").length>17){
				p38=saveC.split("@")[17];
			}
			String p49="";
			if(saveC.split("@").length>18){
				p49=saveC.split("@")[18];
			}
			String p39="";
			if(saveC.split("@").length>19){
				p39=saveC.split("@")[19];
			}
			String p50="";
			if(saveC.split("@").length>20){
				p50=saveC.split("@")[20];
			}
			String p40="";
			if(saveC.split("@").length>21){
				p40=saveC.split("@")[21];
			}
			String p51="";
			if(saveC.split("@").length>22){
				p51=saveC.split("@")[22];
			}
			String p194="";
			if(saveC.split("@").length>23){
				p194=saveC.split("@")[23];
			}
			String sid=saveC.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p30)){
				catalogA.setP30(p30);
			}
			if(!FieldUtil.isEmpty(p41)){
				catalogA.setP41(p41);
			}
			if(!FieldUtil.isEmpty(p31)){
				catalogA.setP31(p31);
			}
			if(!FieldUtil.isEmpty(p42)){
				catalogA.setP42(p42);
			}
			if(!FieldUtil.isEmpty(p32)){
				catalogA.setP32(p32);
			}
			if(!FieldUtil.isEmpty(p43)){
				catalogA.setP43(p43);
			}
			if(!FieldUtil.isEmpty(p33)){
				catalogA.setP33(p33);
			}
			if(!FieldUtil.isEmpty(p44)){
				catalogA.setP44(p44);
			}
			if(!FieldUtil.isEmpty(p34)){
				catalogA.setP34(p34);
			}
			if(!FieldUtil.isEmpty(p45)){
				catalogA.setP45(p45);
			}
			if(!FieldUtil.isEmpty(p35)){
				catalogA.setP35(p35);
			}
			if(!FieldUtil.isEmpty(p46)){
				catalogA.setP46(p46);
			}
			if(!FieldUtil.isEmpty(p36)){
				catalogA.setP36(p36);
			}
			if(!FieldUtil.isEmpty(p47)){
				catalogA.setP47(p47);
			}
			if(!FieldUtil.isEmpty(p37)){
				catalogA.setP37(p37);
			}
			if(!FieldUtil.isEmpty(p48)){
				catalogA.setP48(p48);
			}
			if(!FieldUtil.isEmpty(p38)){
				catalogA.setP38(p38);
			}
			if(!FieldUtil.isEmpty(p49)){
				catalogA.setP49(p49);
			}
			if(!FieldUtil.isEmpty(p39)){
				catalogA.setP39(p39);
			}
			if(!FieldUtil.isEmpty(p50)){
				catalogA.setP50(p50);
			}
			if(!FieldUtil.isEmpty(p40)){
				catalogA.setP40(p40);
			}
			if(!FieldUtil.isEmpty(p51)){
				catalogA.setP51(p51);
			}
			if(!FieldUtil.isEmpty(p194)){
				catalogA.setP194(p194);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageD(){
		try{
//			var saveD=catalogId+"@"+p52+"@"+p54+"@"+p53;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p52="";
			if(saveD.split("@").length>1){
				p52=saveD.split("@")[1];
			}
			String p54="";
			if(saveD.split("@").length>2){
				p54=saveD.split("@")[2];
			}
			String p53="";
			if(saveD.split("@").length>3){
				p53=saveD.split("@")[3];
			}
			String sid=saveD.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p52)){
				catalogA.setP52(p52);
			}
			if(!FieldUtil.isEmpty(p54)){
				catalogA.setP54(p54);
			}
			if(!FieldUtil.isEmpty(p53)){
				catalogA.setP53(p53);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageE(){
		try{
//			var saveE=catalogId+"@"+p55+"@"+p58+"@"+p56+"@"+p57;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p55="";
			if(saveE.split("@").length>1){
				p55=saveE.split("@")[1];
			}
			String p58="";
			if(saveE.split("@").length>2){
				p58=saveE.split("@")[2];
			}
			String p56="";
			if(saveE.split("@").length>3){
				p56=saveE.split("@")[3];
			}
			String p57="";
			if(saveE.split("@").length>4){
				p57=saveE.split("@")[4];
			}
			String sid=saveE.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p55)){
				catalogA.setP55(p55);
			}
			if(!FieldUtil.isEmpty(p58)){
				catalogA.setP58(p58);
			}
			if(!FieldUtil.isEmpty(p56)){
				catalogA.setP56(p56);
			}
			if(!FieldUtil.isEmpty(p57)){
				catalogA.setP57(p57);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageF(){
		try{
//			var saveF=catalogId+"@"+p60+"@"+p63+"@"+p61+"@"+p64+"@"+p62+"@"+p65;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p60="";
			if(saveF.split("@").length>1){
				p60=saveF.split("@")[1];
			}
			String p63="";
			if(saveF.split("@").length>2){
				p63=saveF.split("@")[2];
			}
			String p61="";
			if(saveF.split("@").length>3){
				p61=saveF.split("@")[3];
			}
			String p64="";
			if(saveF.split("@").length>4){
				p64=saveF.split("@")[4];
			}
			String p62="";
			if(saveF.split("@").length>5){
				p62=saveF.split("@")[5];
			}
			String p65="";
			if(saveF.split("@").length>6){
				p65=saveF.split("@")[6];
			}
			String sid=saveF.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p60)){
				catalogA.setP60(p60);
			}
			if(!FieldUtil.isEmpty(p63)){
				catalogA.setP63(p63);
			}
			if(!FieldUtil.isEmpty(p61)){
				catalogA.setP61(p61);
			}
			if(!FieldUtil.isEmpty(p64)){
				catalogA.setP64(p64);
			}
			if(!FieldUtil.isEmpty(p62)){
				catalogA.setP62(p62);
			}
			if(!FieldUtil.isEmpty(p65)){
				catalogA.setP65(p65);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageG(){
		try{
//			var saveG=catalogId+"@"+p66+"@"+p72+"@"+p67+"@"+p73+"@"+p68+"@"+p74+"@"+p69+"@"+p75+"@"+p70+"@"+p76+"@"+p71+"@"+p77+"@"+p198+"@"+p199;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p66="";
			if(saveG.split("@").length>1){
				p66=saveG.split("@")[1];
			}
			String p72="";
			if(saveG.split("@").length>2){
				p72=saveG.split("@")[2];
			}
			String p67="";
			if(saveG.split("@").length>3){
				p67=saveG.split("@")[3];
			}
			String p73="";
			if(saveG.split("@").length>4){
				p73=saveG.split("@")[4];
			}
			String p68="";
			if(saveG.split("@").length>5){
				p68=saveG.split("@")[5];
			}
			String p74="";
			if(saveG.split("@").length>6){
				p74=saveG.split("@")[6];
			}
			String p69="";
			if(saveG.split("@").length>7){
				p69=saveG.split("@")[7];
			}
			String p75="";
			if(saveG.split("@").length>8){
				p75=saveG.split("@")[8];
			}
			String p70="";
			if(saveG.split("@").length>9){
				p70=saveG.split("@")[9];
			}
			String p76="";
			if(saveG.split("@").length>10){
				p76=saveG.split("@")[10];
			}
			String p71="";
			if(saveG.split("@").length>11){
				p71=saveG.split("@")[11];
			}
			String p77="";
			if(saveG.split("@").length>12){
				p77=saveG.split("@")[12];
			}
			String p198="";
			if(saveG.split("@").length>13){
				p198=saveG.split("@")[13];
			}
			String p199="";
			if(saveG.split("@").length>14){
				p199=saveG.split("@")[14];
			}
			String sid=saveG.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p66)){
				catalogA.setP66(p66);
			}
			if(!FieldUtil.isEmpty(p72)){
				catalogA.setP72(p72);
			}
			if(!FieldUtil.isEmpty(p67)){
				catalogA.setP67(p67);
			}
			if(!FieldUtil.isEmpty(p73)){
				catalogA.setP73(p73);
			}
			if(!FieldUtil.isEmpty(p68)){
				catalogA.setP68(p68);
			}
			if(!FieldUtil.isEmpty(p74)){
				catalogA.setP74(p74);
			}
			if(!FieldUtil.isEmpty(p69)){
				catalogA.setP69(p69);
			}
			if(!FieldUtil.isEmpty(p75)){
				catalogA.setP75(p75);
			}
			if(!FieldUtil.isEmpty(p70)){
				catalogA.setP70(p70);
			}
			if(!FieldUtil.isEmpty(p76)){
				catalogA.setP76(p76);
			}
			if(!FieldUtil.isEmpty(p71)){
				catalogA.setP71(p71);
			}
			if(!FieldUtil.isEmpty(p77)){
				catalogA.setP77(p77);
			}
			if(!FieldUtil.isEmpty(p198)){
				catalogA.setP198(p198);
			}
			if(!FieldUtil.isEmpty(p199)){
				catalogA.setP199(p199);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageH(){
		try{
//			var saveH=catalogId+"@"+p78+"@"+p84+"@"+p79+"@"+p85+"@"+p80+"@"+p86+"@"+p81+"@"+p87+"@"+p82+"@"+p88+"@"+p83+"@"+p89;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p78="";
			if(saveH.split("@").length>1){
				p78=saveH.split("@")[1];
			}
			String p84="";
			if(saveH.split("@").length>2){
				p84=saveH.split("@")[2];
			}
			String p79="";
			if(saveH.split("@").length>3){
				p79=saveH.split("@")[3];
			}
			String p85="";
			if(saveH.split("@").length>4){
				p85=saveH.split("@")[4];
			}
			String p80="";
			if(saveH.split("@").length>5){
				p80=saveH.split("@")[5];
			}
			String p86="";
			if(saveH.split("@").length>6){
				p86=saveH.split("@")[6];
			}
			String p81="";
			if(saveH.split("@").length>7){
				p81=saveH.split("@")[7];
			}
			String p87="";
			if(saveH.split("@").length>8){
				p87=saveH.split("@")[8];
			}
			String p82="";
			if(saveH.split("@").length>9){
				p82=saveH.split("@")[9];
			}
			String p88="";
			if(saveH.split("@").length>10){
				p88=saveH.split("@")[10];
			}
			String p83="";
			if(saveH.split("@").length>11){
				p83=saveH.split("@")[11];
			}
			String p89="";
			if(saveH.split("@").length>12){
				p89=saveH.split("@")[12];
			}
			String sid=saveH.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p78)){
				catalogA.setP78(p78);
			}
			if(!FieldUtil.isEmpty(p84)){
				catalogA.setP84(p84);
			}
			if(!FieldUtil.isEmpty(p79)){
				catalogA.setP79(p79);
			}
			if(!FieldUtil.isEmpty(p85)){
				catalogA.setP85(p85);
			}
			if(!FieldUtil.isEmpty(p80)){
				catalogA.setP80(p80);
			}
			if(!FieldUtil.isEmpty(p86)){
				catalogA.setP86(p86);
			}
			if(!FieldUtil.isEmpty(p81)){
				catalogA.setP81(p81);
			}
			if(!FieldUtil.isEmpty(p87)){
				catalogA.setP87(p87);
			}
			if(!FieldUtil.isEmpty(p82)){
				catalogA.setP82(p82);
			}
			if(!FieldUtil.isEmpty(p88)){
				catalogA.setP88(p88);
			}
			if(!FieldUtil.isEmpty(p83)){
				catalogA.setP83(p83);
			}
			if(!FieldUtil.isEmpty(p89)){
				catalogA.setP89(p89);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageI(){
		try{
//			var saveI=catalogId+"@"+p90+"@"+p93+"@"+p91+"@"+p94+"@"+p92+"@"+p95+"@"+p180;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p90="";
			if(saveI.split("@").length>1){
				p90=saveI.split("@")[1];
			}
			String p93="";
			if(saveI.split("@").length>2){
				p93=saveI.split("@")[2];
			}
			String p91="";
			if(saveI.split("@").length>3){
				p91=saveI.split("@")[3];
			}
			String p94="";
			if(saveI.split("@").length>4){
				p94=saveI.split("@")[4];
			}
			String p92="";
			if(saveI.split("@").length>5){
				p92=saveI.split("@")[5];
			}
			String p95="";
			if(saveI.split("@").length>6){
				p95=saveI.split("@")[6];
			}
			String p180="";
			if(saveI.split("@").length>7){
				p180=saveI.split("@")[7];
			}
			String sid=saveI.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p90)){
				catalogA.setP90(p90);
			}
			if(!FieldUtil.isEmpty(p93)){
				catalogA.setP93(p93);
			}
			if(!FieldUtil.isEmpty(p91)){
				catalogA.setP91(p91);
			}
			if(!FieldUtil.isEmpty(p94)){
				catalogA.setP94(p94);
			}
			if(!FieldUtil.isEmpty(p92)){
				catalogA.setP92(p92);
			}
			if(!FieldUtil.isEmpty(p95)){
				catalogA.setP95(p95);
			}
			if(!FieldUtil.isEmpty(p180)){
				catalogA.setP180(p180);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageJ(){
		try{
//			var saveJ=catalogId+"@"+p96+"@"+p102+"@"+p97+"@"+p103+"@"+p98+"@"+p104+"@"+p99+"@"+p105+"@"+p100+"@"+p106+"@"+p101+"@"+p181;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p96="";
			if(saveJ.split("@").length>1){
				p96=saveJ.split("@")[1];
			}
			String p102="";
			if(saveJ.split("@").length>2){
				p102=saveJ.split("@")[2];
			}
			String p97="";
			if(saveJ.split("@").length>3){
				p97=saveJ.split("@")[3];
			}
			String p103="";
			if(saveJ.split("@").length>4){
				p103=saveJ.split("@")[4];
			}
			String p98="";
			if(saveJ.split("@").length>5){
				p98=saveJ.split("@")[5];
			}
			String p104="";
			if(saveJ.split("@").length>6){
				p104=saveJ.split("@")[6];
			}
			String p99="";
			if(saveJ.split("@").length>7){
				p99=saveJ.split("@")[7];
			}
			String p105="";
			if(saveJ.split("@").length>8){
				p105=saveJ.split("@")[8];
			}
			String p100="";
			if(saveJ.split("@").length>9){
				p100=saveJ.split("@")[9];
			}
			String p106="";
			if(saveJ.split("@").length>10){
				p106=saveJ.split("@")[10];
			}
			String p101="";
			if(saveJ.split("@").length>11){
				p101=saveJ.split("@")[11];
			}
			String p181="";
			if(saveJ.split("@").length>12){
				p181=saveJ.split("@")[12];
			}
			String sid=saveJ.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p96)){
				catalogA.setP96(p96);
			}
			if(!FieldUtil.isEmpty(p102)){
				catalogA.setP102(p102);
			}
			if(!FieldUtil.isEmpty(p97)){
				catalogA.setP97(p97);
			}
			if(!FieldUtil.isEmpty(p103)){
				catalogA.setP103(p103);
			}
			if(!FieldUtil.isEmpty(p98)){
				catalogA.setP98(p98);
			}
			if(!FieldUtil.isEmpty(p104)){
				catalogA.setP104(p104);
			}
			if(!FieldUtil.isEmpty(p99)){
				catalogA.setP99(p99);
			}
			if(!FieldUtil.isEmpty(p105)){
				catalogA.setP105(p105);
			}
			if(!FieldUtil.isEmpty(p100)){
				catalogA.setP100(p100);
			}
			if(!FieldUtil.isEmpty(p106)){
				catalogA.setP106(p106);
			}
			if(!FieldUtil.isEmpty(p101)){
				catalogA.setP101(p101);
			}
			if(!FieldUtil.isEmpty(p181)){
				catalogA.setP181(p181);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageK(){
		try{
//			var saveK=catalogId+"@"+p107+"@"+p117+"@"+p108+"@"+p118+"@"+p109+"@"+p119+"@"+p110+"@"+p120+"@"+p111+"@"+p121+"@"+p112+"@"+p122+"@"+P113+"@"+p123+"@"+p114+"@"+p124+"@"+p115+"@"+p125+"@"+p116+"@"+p126+"@"+p182+"@"+p195+"@"+p196;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p107="";
			if(saveK.split("@").length>1){
				p107=saveK.split("@")[1];
			}
			String p117="";
			if(saveK.split("@").length>2){
				p117=saveK.split("@")[2];
			}
			String p108="";
			if(saveK.split("@").length>3){
				p108=saveK.split("@")[3];
			}
			String p118="";
			if(saveK.split("@").length>4){
				p118=saveK.split("@")[4];
			}
			String p109="";
			if(saveK.split("@").length>5){
				p109=saveK.split("@")[5];
			}
			String p119="";
			if(saveK.split("@").length>6){
				p119=saveK.split("@")[6];
			}
			String p110="";
			if(saveK.split("@").length>7){
				p110=saveK.split("@")[7];
			}
			String p120="";
			if(saveK.split("@").length>8){
				p120=saveK.split("@")[8];
			}
			String p111="";
			if(saveK.split("@").length>9){
				p111=saveK.split("@")[9];
			}
			String p121="";
			if(saveK.split("@").length>10){
				p121=saveK.split("@")[10];
			}
			String p112="";
			if(saveK.split("@").length>11){
				p112=saveK.split("@")[11];
			}
			String p122="";
			if(saveK.split("@").length>12){
				p122=saveK.split("@")[12];
			}
			String p113="";
			if(saveK.split("@").length>13){
				p113=saveK.split("@")[13];
			}
			String p123="";
			if(saveK.split("@").length>14){
				p123=saveK.split("@")[14];
			}
			String p114="";
			if(saveK.split("@").length>15){
				p114=saveK.split("@")[15];
			}
			String p124="";
			if(saveK.split("@").length>16){
				p124=saveK.split("@")[16];
			}
			String p115="";
			if(saveK.split("@").length>17){
				p115=saveK.split("@")[17];
			}
			String p125="";
			if(saveK.split("@").length>18){
				p125=saveK.split("@")[18];
			}
			String p116="";
			if(saveK.split("@").length>19){
				p116=saveK.split("@")[19];
			}
			String p126="";
			if(saveK.split("@").length>20){
				p126=saveK.split("@")[20];
			}
			String p182="";
			if(saveK.split("@").length>21){
				p182=saveK.split("@")[21];
			}
			String p195="";
			if(saveK.split("@").length>22){
				p195=saveK.split("@")[22];
			}
			String p196="";
			if(saveK.split("@").length>23){
				p196=saveK.split("@")[23];
			}
			String sid=saveK.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p107)){
				catalogA.setP107(p107);
			}
			if(!FieldUtil.isEmpty(p117)){
				catalogA.setP117(p117);
			}
			if(!FieldUtil.isEmpty(p108)){
				catalogA.setP108(p108);
			}
			if(!FieldUtil.isEmpty(p118)){
				catalogA.setP118(p118);
			}
			if(!FieldUtil.isEmpty(p109)){
				catalogA.setP109(p109);
			}
			if(!FieldUtil.isEmpty(p119)){
				catalogA.setP119(p119);
			}
			if(!FieldUtil.isEmpty(p110)){
				catalogA.setP110(p110);
			}
			if(!FieldUtil.isEmpty(p120)){
				catalogA.setP120(p120);
			}
			if(!FieldUtil.isEmpty(p111)){
				catalogA.setP111(p111);
			}
			if(!FieldUtil.isEmpty(p121)){
				catalogA.setP121(p121);
			}
			if(!FieldUtil.isEmpty(p112)){
				catalogA.setP112(p112);
			}
			if(!FieldUtil.isEmpty(p122)){
				catalogA.setP122(p122);
			}
			if(!FieldUtil.isEmpty(p113)){
				catalogA.setP113(p113);
			}
			if(!FieldUtil.isEmpty(p123)){
				catalogA.setP123(p123);
			}
			if(!FieldUtil.isEmpty(p114)){
				catalogA.setP114(p114);
			}
			if(!FieldUtil.isEmpty(p124)){
				catalogA.setP124(p124);
			}
			if(!FieldUtil.isEmpty(p115)){
				catalogA.setP115(p115);
			}
			if(!FieldUtil.isEmpty(p125)){
				catalogA.setP125(p125);
			}
			if(!FieldUtil.isEmpty(p116)){
				catalogA.setP116(p116);
			}
			if(!FieldUtil.isEmpty(p126)){
				catalogA.setP126(p126);
			}
			if(!FieldUtil.isEmpty(p182)){
				catalogA.setP182(p182);
			}
			if(!FieldUtil.isEmpty(p195)){
				catalogA.setP195(p195);
			}
			if(!FieldUtil.isEmpty(p196)){
				catalogA.setP196(p196);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageL(){
		try{
//			var saveL=catalogId+"@"+p127+"@"+p136+"@"+p128+"@"+p137+"@"+p129+"@"+p138+"@"+p130+"@"+p139+"@"+p131+"@"+p140+"@"+p132+"@"+p141+"@"+p133+"@"+p142+"@"+p134+"@"+p143+"@"+p135+"@"+p144+"@"+p183+"@"+p184+"@"+p185;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p127="";
			if(saveL.split("@").length>1){
				p127=saveL.split("@")[1];
			}
			String p136="";
			if(saveL.split("@").length>2){
				p136=saveL.split("@")[2];
			}
			String p128="";
			if(saveL.split("@").length>3){
				p128=saveL.split("@")[3];
			}
			String p137="";
			if(saveL.split("@").length>4){
				p137=saveL.split("@")[4];
			}
			String p129="";
			if(saveL.split("@").length>5){
				p129=saveL.split("@")[5];
			}
			String p138="";
			if(saveL.split("@").length>6){
				p138=saveL.split("@")[6];
			}
			String p130="";
			if(saveL.split("@").length>7){
				p130=saveL.split("@")[7];
			}
			String p139="";
			if(saveL.split("@").length>8){
				p139=saveL.split("@")[8];
			}
			String p131="";
			if(saveL.split("@").length>9){
				p131=saveL.split("@")[9];
			}
			String p140="";
			if(saveL.split("@").length>10){
				p140=saveL.split("@")[10];
			}
			String p132="";
			if(saveL.split("@").length>11){
				p132=saveL.split("@")[11];
			}
			String p141="";
			if(saveL.split("@").length>12){
				p141=saveL.split("@")[12];
			}
			String p133="";
			if(saveL.split("@").length>13){
				p133=saveL.split("@")[13];
			}
			String p142="";
			if(saveL.split("@").length>14){
				p142=saveL.split("@")[14];
			}
			String p134="";
			if(saveL.split("@").length>15){
				p134=saveL.split("@")[15];
			}
			String p143="";
			if(saveL.split("@").length>16){
				p143=saveL.split("@")[16];
			}
			String p135="";
			if(saveL.split("@").length>17){
				p135=saveL.split("@")[17];
			}
			String p144="";
			if(saveL.split("@").length>18){
				p144=saveL.split("@")[18];
			}
			String p183="";
			if(saveL.split("@").length>19){
				p183=saveL.split("@")[19];
			}
			String p184="";
			if(saveL.split("@").length>20){
				p184=saveL.split("@")[20];
			}
			String p185="";
			if(saveL.split("@").length>21){
				p185=saveL.split("@")[21];
			}
			String sid=saveL.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p127)){
				catalogA.setP127(p127);
			}
			if(!FieldUtil.isEmpty(p136)){
				catalogA.setP136(p136);
			}
			if(!FieldUtil.isEmpty(p128)){
				catalogA.setP128(p128);
			}
			if(!FieldUtil.isEmpty(p137)){
				catalogA.setP137(p137);
			}
			if(!FieldUtil.isEmpty(p129)){
				catalogA.setP129(p129);
			}
			if(!FieldUtil.isEmpty(p138)){
				catalogA.setP138(p138);
			}
			if(!FieldUtil.isEmpty(p130)){
				catalogA.setP130(p130);
			}
			if(!FieldUtil.isEmpty(p139)){
				catalogA.setP139(p139);
			}
			if(!FieldUtil.isEmpty(p131)){
				catalogA.setP131(p131);
			}
			if(!FieldUtil.isEmpty(p140)){
				catalogA.setP140(p140);
			}
			if(!FieldUtil.isEmpty(p132)){
				catalogA.setP132(p132);
			}
			if(!FieldUtil.isEmpty(p141)){
				catalogA.setP141(p141);
			}
			if(!FieldUtil.isEmpty(p133)){
				catalogA.setP133(p133);
			}
			if(!FieldUtil.isEmpty(p142)){
				catalogA.setP142(p142);
			}
			if(!FieldUtil.isEmpty(p134)){
				catalogA.setP134(p134);
			}
			if(!FieldUtil.isEmpty(p143)){
				catalogA.setP143(p143);
			}
			if(!FieldUtil.isEmpty(p135)){
				catalogA.setP135(p135);
			}
			if(!FieldUtil.isEmpty(p144)){
				catalogA.setP144(p144);
			}
			if(!FieldUtil.isEmpty(p183)){
				catalogA.setP183(p183);
			}
			if(!FieldUtil.isEmpty(p184)){
				catalogA.setP184(p184);
			}
			if(!FieldUtil.isEmpty(p185)){
				catalogA.setP185(p185);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageM(){
		try{
//			var saveM=catalogId+"@"+p145+"@"+p149+"@"+p146+"@"+p150+"@"+p147+"@"+p151+"@"+p148+"@"+p152+"@"+p186;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p145="";
			if(saveM.split("@").length>1){
				p145=saveM.split("@")[1];
			}
			String p149="";
			if(saveM.split("@").length>2){
				p149=saveM.split("@")[2];
			}
			String p146="";
			if(saveM.split("@").length>3){
				p146=saveM.split("@")[3];
			}
			String p150="";
			if(saveM.split("@").length>4){
				p150=saveM.split("@")[4];
			}
			String p147="";
			if(saveM.split("@").length>5){
				p147=saveM.split("@")[5];
			}
			String p151="";
			if(saveM.split("@").length>6){
				p151=saveM.split("@")[6];
			}
			String p148="";
			if(saveM.split("@").length>7){
				p148=saveM.split("@")[7];
			}
			String p152="";
			if(saveM.split("@").length>8){
				p152=saveM.split("@")[8];
			}
			String p186="";
			if(saveM.split("@").length>9){
				p186=saveM.split("@")[9];
			}
			String sid=saveM.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p145)){
				catalogA.setP145(p145);
			}
			if(!FieldUtil.isEmpty(p149)){
				catalogA.setP149(p149);
			}
			if(!FieldUtil.isEmpty(p146)){
				catalogA.setP146(p146);
			}
			if(!FieldUtil.isEmpty(p150)){
				catalogA.setP150(p150);
			}
			if(!FieldUtil.isEmpty(p147)){
				catalogA.setP147(p147);
			}
			if(!FieldUtil.isEmpty(p151)){
				catalogA.setP151(p151);
			}
			if(!FieldUtil.isEmpty(p148)){
				catalogA.setP148(p148);
			}
			if(!FieldUtil.isEmpty(p152)){
				catalogA.setP152(p152);
			}
			if(!FieldUtil.isEmpty(p186)){
				catalogA.setP186(p186);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageN(){
		try{
//			var saveN=catalogId+"@"+p153+"@"+p159+"@"+p154+"@"+p160+"@"+p155+"@"+p161+"@"+p156+"@"+p162+"@"+p157+"@"+p163+"@"+p158+"@"+p197+"@"+p187+"@"+p188;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p153="";
			if(saveN.split("@").length>1){
				p153=saveN.split("@")[1];
			}
			String p159="";
			if(saveN.split("@").length>2){
				p159=saveN.split("@")[2];
			}
			String p154="";
			if(saveN.split("@").length>3){
				p154=saveN.split("@")[3];
			}
			String p160="";
			if(saveN.split("@").length>4){
				p160=saveN.split("@")[4];
			}
			String p155="";
			if(saveN.split("@").length>5){
				p155=saveN.split("@")[5];
			}
			String p161="";
			if(saveN.split("@").length>6){
				p161=saveN.split("@")[6];
			}
			String p156="";
			if(saveN.split("@").length>7){
				p156=saveN.split("@")[7];
			}
			String p162="";
			if(saveN.split("@").length>8){
				p162=saveN.split("@")[8];
			}
			String p157="";
			if(saveN.split("@").length>9){
				p157=saveN.split("@")[9];
			}
			String p163="";
			if(saveN.split("@").length>10){
				p163=saveN.split("@")[10];
			}
			String p158="";
			if(saveN.split("@").length>11){
				p158=saveN.split("@")[11];
			}
			String p197="";
			if(saveN.split("@").length>12){
				p197=saveN.split("@")[12];
			}
			String p187="";
			if(saveN.split("@").length>13){
				p187=saveN.split("@")[13];
			}
			String p188="";
			if(saveN.split("@").length>14){
				p188=saveN.split("@")[14];
			}
			String sid=saveN.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p153)){
				catalogA.setP153(p153);
			}
			if(!FieldUtil.isEmpty(p159)){
				catalogA.setP159(p159);
			}
			if(!FieldUtil.isEmpty(p154)){
				catalogA.setP154(p154);
			}
			if(!FieldUtil.isEmpty(p160)){
				catalogA.setP160(p160);
			}
			if(!FieldUtil.isEmpty(p155)){
				catalogA.setP155(p155);
			}
			if(!FieldUtil.isEmpty(p161)){
				catalogA.setP161(p161);
			}
			if(!FieldUtil.isEmpty(p156)){
				catalogA.setP156(p156);
			}
			if(!FieldUtil.isEmpty(p162)){
				catalogA.setP162(p162);
			}
			if(!FieldUtil.isEmpty(p157)){
				catalogA.setP157(p157);
			}
			if(!FieldUtil.isEmpty(p163)){
				catalogA.setP163(p163);
			}
			if(!FieldUtil.isEmpty(p158)){
				catalogA.setP158(p158);
			}
			if(!FieldUtil.isEmpty(p197)){
				catalogA.setP197(p197);
			}
			if(!FieldUtil.isEmpty(p187)){
				catalogA.setP187(p187);
			}
			if(!FieldUtil.isEmpty(p188)){
				catalogA.setP188(p188);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageO(){
		try{
//			var saveO=catalogId+"@"+p164+"@"+p168+"@"+p165+"@"+p169+"@"+p166+"@"+p170+"@"+p167;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p164="";
			if(saveO.split("@").length>1){
				p164=saveO.split("@")[1];
			}
			String p168="";
			if(saveO.split("@").length>2){
				p168=saveO.split("@")[2];
			}
			String p165="";
			if(saveO.split("@").length>3){
				p165=saveO.split("@")[3];
			}
			String p169="";
			if(saveO.split("@").length>4){
				p169=saveO.split("@")[4];
			}
			String p166="";
			if(saveO.split("@").length>5){
				p166=saveO.split("@")[5];
			}
			String p170="";
			if(saveO.split("@").length>6){
				p170=saveO.split("@")[6];
			}
			String p167="";
			if(saveO.split("@").length>7){
				p167=saveO.split("@")[7];
			}
			String sid=saveO.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p164)){
				catalogA.setP164(p164);
			}
			if(!FieldUtil.isEmpty(p168)){
				catalogA.setP168(p168);
			}
			if(!FieldUtil.isEmpty(p165)){
				catalogA.setP165(p165);
			}
			if(!FieldUtil.isEmpty(p169)){
				catalogA.setP169(p169);
			}
			if(!FieldUtil.isEmpty(p166)){
				catalogA.setP166(p166);
			}
			if(!FieldUtil.isEmpty(p170)){
				catalogA.setP170(p170);
			}
			if(!FieldUtil.isEmpty(p167)){
				catalogA.setP167(p167);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageP(){
		try{
//			var saveO=catalogId+"@"+p171+"@"+p174+"@"+p172+"@"+p175+"@"+p173+"@"+p191+"@"+p189+"@"+p190;
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p171="";
			if(saveP.split("@").length>1){
				p171=saveP.split("@")[1];
			}
			String p174="";
			if(saveP.split("@").length>2){
				p174=saveP.split("@")[2];
			}
			String p172="";
			if(saveP.split("@").length>3){
				p172=saveP.split("@")[3];
			}
			String p175="";
			if(saveP.split("@").length>4){
				p175=saveP.split("@")[4];
			}
			String p173="";
			if(saveP.split("@").length>5){
				p173=saveP.split("@")[5];
			}
			String p191="";
			if(saveP.split("@").length>6){
				p191=saveP.split("@")[6];
			}
			String p189="";
			if(saveP.split("@").length>7){
				p189=saveP.split("@")[7];
			}
			String p190="";
			if(saveP.split("@").length>8){
				p190=saveP.split("@")[8];
			}
			String sid=saveP.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p171)){
				catalogA.setP171(p171);
			}
			if(!FieldUtil.isEmpty(p174)){
				catalogA.setP174(p174);
			}
			if(!FieldUtil.isEmpty(p172)){
				catalogA.setP172(p172);
			}
			if(!FieldUtil.isEmpty(p175)){
				catalogA.setP175(p175);
			}
			if(!FieldUtil.isEmpty(p173)){
				catalogA.setP173(p173);
			}
			if(!FieldUtil.isEmpty(p191)){
				catalogA.setP191(p191);
			}
			if(!FieldUtil.isEmpty(p189)){
				catalogA.setP189(p189);
			}
			if(!FieldUtil.isEmpty(p190)){
				catalogA.setP190(p190);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p200=saveQ.split("@")[1];
			String sid=saveQ.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p200)){
				catalogA.setP200(p200);
			}
			setAjax("0");
		}
		return AJAX;
	}
	
	public String SaveCatalogManageQ(){
		try{
			DboCarAutohomeprop catalogA=new DboCarAutohomeprop();
			String p200="";
			if(saveQ.split("@").length>1){
				p200=saveQ.split("@")[1];
			}
			String sid=saveQ.split("@")[0];
			String idSql=" carid ="+Integer.parseInt(sid);
			DboCarAutohomeprop ids=DboCarAutohomepropDao.where(idSql).get(0);
			catalogA.setId(ids.getId());
			if(!FieldUtil.isEmpty(p200)){
				catalogA.setP200(p200);
			}
			DboCarAutohomepropDao.update(catalogA);
			String length="";
			String idL=String.valueOf(catalogA.getId());
			if(idL.length()>0&&idL.length()<10){
				length="000"+idL.length();
			}else if(idL.length()>9&&idL.length()<100){
				length="00"+idL.length();
			}else if(idL.length()>99&&idL.length()<1000){
				length="0"+idL.length();
			}else{
				length=String.valueOf(idL.length());
			}
			Jedis jedis=RedisManager.getJedisObject();
			jedis.publish("key_queue_event", "0006update0020dbo_car_autohomeprop"+length+catalogA.getId());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public String getSaveQ(){
		return saveQ;
	}
	public void setSaveQ(String saveQ){
		this.saveQ=saveQ;
	}
	
	public String getSaveP(){
		return saveP;
	}
	public void setSaveP(String saveP){
		this.saveP=saveP;
	}
	
	public String getSaveO(){
		return saveO;
	}
	public void setSaveO(String saveO){
		this.saveO=saveO;
	}
	
	public String getSaveN(){
		return saveN;
	}
	public void setSaveN(String saveN){
		this.saveN=saveN;
	}
	
	public String getSaveM(){
		return saveM;
	}
	public void setSaveM(String saveM){
		this.saveM=saveM;
	}
	
	public String getSaveL(){
		return saveL;
	}
	public void setSaveL(String saveL){
		this.saveL=saveL;
	}
	
	public String getSaveK(){
		return saveK;
	}
	public void setSaveK(String saveK){
		this.saveK=saveK;
	}
	
	public String getSaveJ(){
		return saveJ;
	}
	public void setSaveJ(String saveJ){
		this.saveJ=saveJ;
	}
	
	public String getSaveI(){
		return saveI;
	}
	public void setSaveI(String saveI){
		this.saveI=saveI;
	}
	
	public String getSaveH(){
		return saveH;
	}
	public void setSaveH(String saveH){
		this.saveH=saveH;
	}
	
	public String getSaveG(){
		return saveG;
	}
	public void setSaveG(String saveG){
		this.saveG=saveG;
	}
	
	public String getSaveF(){
		return saveF;
	}
	public void setSaveF(String saveF){
		this.saveF=saveF;
	}
	
	public String getSaveE(){
		return saveE;
	}
	public void setSaveE(String saveE){
		this.saveE=saveE;
	}
	
	public String getSaveD(){
		return saveD;
	}
	public void setSaveD(String saveD){
		this.saveD=saveD;
	}
	
	public String getSaveC(){
		return saveC;
	}
	public void setSaveC(String saveC){
		this.saveC=saveC;
	}
	
	public String getSaveB(){
		return saveB;
	}
	public void setSaveB(String saveB){
		this.saveB=saveB;
	}
	
	public String getSaveA(){
		return saveA;
	}
	public void setSaveA(String saveA){
		this.saveA=saveA;
	}
	
	public DboCarAutohomeprop getCarCatalog(){
		return carCatalog;
	}
	public void setCarCatalog(DboCarAutohomeprop carCatalog){
		this.carCatalog=carCatalog;
	}
	
	public int getCatalogId(){
		return catalogId;
	}
	public void setCatalogId(int catalogId){
		this.catalogId=catalogId;
	}
}
