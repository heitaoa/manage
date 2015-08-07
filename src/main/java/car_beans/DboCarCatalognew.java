package car_beans;
import java.util.*;

public class  DboCarCatalognew  implements java.io.Serializable{

	public String KEY = "catalogid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int catalogid;//
	private String catalogname;//
	private int fatherid;//
	private String byname;//
	private String path;//
	private int islive;//0-闁稿绮堟鍥晬閿燂拷-闁革负鍔嬫鍥晬閿燂拷-闁哄牜浜為弫鎾寸閿燂拷	
	private int onsale;//0-闁稿绮岄弫顓㈡晬閿燂拷-闁革负鍔岄弫顓㈡晬閿燂拷-闁哄牜浜弨銏ゅ船椤曞棛绀�-闁哄牜浜欑粭鍌滄暜閿燂拷	
	private int iyear;//
	private String iway;//
	private int madein;//0-婵炴潙鍢查ˇ濠氭晬閿燂拷- 闁搞儲鍨濇鍥晬閿燂拷-閺夆晜绋戣ぐ锟�
	private int xiangti;//0-闁哄啰濯寸槐锟�闁告娲栫敮浼存晬閿燂拷-濞戞挶鍊曠敮浼存晬閿燂拷-濞戞挸顦敮锟�
	private int jibie;//0-闁哄啰濯寸槐锟�鐎甸偊鍠栭悗鐑芥晬閿燂拷-閻忓繐绻愰悗鐑芥晬閿燂拷-缂佹瘱鍐ㄦ闁搞劌顑戠槐锟�閺夌偠顕ч悗鐑芥晬閿燂拷-濞戞搩鍘奸悗鐑芥晬閿燂拷-濞戞搩鍘奸妵鍥垂鐎ｅ墎绀�-濠㈠爢鍐拷闁挎冻鎷�-閻犵儐浜滃畷鏇㈡晬閿燂拷-閻℃帒鎳愭锟�
	private int leixing;//0-闁哄啰濯寸槐锟�閺夌偠鍎诲┃鍛存晬閿燂拷-閻犳亽鍔庨弲顐ｆ姜閿旇偐绀�-suv闁挎冻鎷�-闁哄啫鎳撻、鎴炴姜閿旇偐绀�-mpv闁挎冻鎷�-閻犵儤鍨煎┃鍛存晬閿燂拷-婵帒鍊告惔閿嬫姜閿旇偐绀�-闁活煈鍠栧畷閬嶆晬閿燂拷-閻庡箍鍨煎┃鍛存晬閿燂拷0-闁告銈嗙盃
	private int bsq;//0-闁哄啰濯寸槐锟�闁归潧顑呮慨鈺呮晬閿燂拷-闁煎浜滄慨鈺呮晬閿燂拷-闁告瑥鐬奸‖鍥触閸剛绀�-闁哄啰濮锋鍥矗濮楋拷鎷烽悤鍌滅5-闁归潧顑堥崵婊勭▔閿熻姤鎷呴敓锟絘mt)
	private int pailiang;//闁活澁鎷�0闁稿﹤绉烽妴鍐矆閻氬绀夐柡浣哥摠閺嗙喖鏁嶇仦鎯х瑩闂佹彃绻愰悺銊╁捶閵婏附锟ラ柣銊ュ閸庡繘宕樼喊澶岀闁告帗鐟ч弫锟�閻炴稏鍔庨妵锟介柨娑虫嫹0濞戞挸绉烽妴鍐矆閻戞ɑ锟ラ柨娑虫嫹
	private String photo;//
	private String serialname;//
	private int newsid;//
	private int isdelete;//
	private Date adddate;// 
	private Date lastupdate;//
	private String addadmin;//
	private String updateadmin;//
	private String deladmin;//
	private int sortid;//
	private String factorytel;//
	private String carkey;//
	private String englishname;//
	private int maincatalogid;//
	private int ishaverelation;//
	private String lname;//
	private int pathlevel;//1-闁告繀鑳舵晶锟�-閺夌儑濡囬柈锟�-閺夌儑绠戦悗锟�
	private int hotlevel;//
	private int fadongji;//1-婵濮ょ悰锟�-闁哄苯鐡ㄧ悰锟�-婵烇絽鍢查幃搴ㄥ礉閵娿儱顫�4-缂佺虎鍨抽弫鎼佸礉閿燂拷5-濠㈠灈鏅濋崝褍顫濋敓锟�
	private int baoyangfeiyong;//
	private int pengzhuanglevel;//
	private String guanurl;//
	private String wayname;//婵炴挾濞�禍鐐純閺嵮呮憻婵綇鎷�	
	private String carbrandphoto;//闁告繀鑳舵晶婵嬪炊閸撗冾暬
	private int old_catalogid;//闁煎府鎷�15閺夌儑绠戦悗鐑藉极閻楀牆绁�	
	private int old_fatherid;//闁煎府鎷�15閺夌儑绠戦悗鐑藉极閻楀牆绁�	
	private double yiche_price;//
	private String chetuanphoto;//閺夌儑绠戝ú鐔煎炊閸撗冾暬

	private DboCarCatalognew carSeries;//
	public void setCarSeries(DboCarCatalognew carSeries)
	{
		this.carSeries=carSeries;
	}
	public DboCarCatalognew getCarSeries()
	{
		return carSeries;
	}
	private DboCarInfo carInfo;//
	public void setCarInfo(DboCarInfo carInfo)
	{
		this.carInfo=carInfo;
	}
	public DboCarInfo getCarInfo()
	{
		return carInfo;
	}

	public void setCatalogid(int catalogid)
	{
		this.catalogid=catalogid;
		COLUMN_FLAG[0] = true;
	}
	public int getCatalogid()
	{
		return catalogid;
	}
	public void setCatalogname(String catalogname)
	{
		this.catalogname=catalogname;
		COLUMN_FLAG[1] = true;
	}
	public String getCatalogname()
	{
		return catalogname;
	}
	public void setFatherid(int fatherid)
	{
		this.fatherid=fatherid;
		COLUMN_FLAG[2] = true;
	}
	public int getFatherid()
	{
		return fatherid;
	}
	public void setByname(String byname)
	{
		this.byname=byname;
		COLUMN_FLAG[3] = true;
	}
	public String getByname()
	{
		return byname;
	}
	public void setPath(String path)
	{
		this.path=path;
		COLUMN_FLAG[4] = true;
	}
	public String getPath()
	{
		return path;
	}
	public void setIslive(int islive)
	{
		this.islive=islive;
		COLUMN_FLAG[5] = true;
	}
	public int getIslive()
	{
		return islive;
	}
	public void setOnsale(int onsale)
	{
		this.onsale=onsale;
		COLUMN_FLAG[6] = true;
	}
	public int getOnsale()
	{
		return onsale;
	}
	public void setIyear(int iyear)
	{
		this.iyear=iyear;
		COLUMN_FLAG[7] = true;
	}
	public int getIyear()
	{
		return iyear;
	}
	public void setIway(String iway)
	{
		this.iway=iway;
		COLUMN_FLAG[8] = true;
	}
	public String getIway()
	{
		return iway;
	}
	public void setMadein(int madein)
	{
		this.madein=madein;
		COLUMN_FLAG[9] = true;
	}
	public int getMadein()
	{
		return madein;
	}
	public void setXiangti(int xiangti)
	{
		this.xiangti=xiangti;
		COLUMN_FLAG[10] = true;
	}
	public int getXiangti()
	{
		return xiangti;
	}
	public void setJibie(int jibie)
	{
		this.jibie=jibie;
		COLUMN_FLAG[11] = true;
	}
	public int getJibie()
	{
		return jibie;
	}
	public void setLeixing(int leixing)
	{
		this.leixing=leixing;
		COLUMN_FLAG[12] = true;
	}
	public int getLeixing()
	{
		return leixing;
	}
	public void setBsq(int bsq)
	{
		this.bsq=bsq;
		COLUMN_FLAG[13] = true;
	}
	public int getBsq()
	{
		return bsq;
	}
	public void setPailiang(int pailiang)
	{
		this.pailiang=pailiang;
		COLUMN_FLAG[14] = true;
	}
	public int getPailiang()
	{
		return pailiang;
	}
	public void setPhoto(String photo)
	{
		this.photo=photo;
		COLUMN_FLAG[15] = true;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setSerialname(String serialname)
	{
		this.serialname=serialname;
		COLUMN_FLAG[16] = true;
	}
	public String getSerialname()
	{
		return serialname;
	}
	public void setNewsid(int newsid)
	{
		this.newsid=newsid;
		COLUMN_FLAG[17] = true;
	}
	public int getNewsid()
	{
		return newsid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[18] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[19] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[20] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[21] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpdateadmin(String updateadmin)
	{
		this.updateadmin=updateadmin;
		COLUMN_FLAG[22] = true;
	}
	public String getUpdateadmin()
	{
		return updateadmin;
	}
	public void setDeladmin(String deladmin)
	{
		this.deladmin=deladmin;
		COLUMN_FLAG[23] = true;
	}
	public String getDeladmin()
	{
		return deladmin;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[24] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setFactorytel(String factorytel)
	{
		this.factorytel=factorytel;
		COLUMN_FLAG[25] = true;
	}
	public String getFactorytel()
	{
		return factorytel;
	}
	public void setCarkey(String carkey)
	{
		this.carkey=carkey;
		COLUMN_FLAG[26] = true;
	}
	public String getCarkey()
	{
		return carkey;
	}
	public void setEnglishname(String englishname)
	{
		this.englishname=englishname;
		COLUMN_FLAG[27] = true;
	}
	public String getEnglishname()
	{
		return englishname;
	}
	public void setMaincatalogid(int maincatalogid)
	{
		this.maincatalogid=maincatalogid;
		COLUMN_FLAG[28] = true;
	}
	public int getMaincatalogid()
	{
		return maincatalogid;
	}
	public void setIshaverelation(int ishaverelation)
	{
		this.ishaverelation=ishaverelation;
		COLUMN_FLAG[29] = true;
	}
	public int getIshaverelation()
	{
		return ishaverelation;
	}
	public void setLname(String lname)
	{
		this.lname=lname;
		COLUMN_FLAG[30] = true;
	}
	public String getLname()
	{
		return lname;
	}
	public void setPathlevel(int pathlevel)
	{
		this.pathlevel=pathlevel;
		COLUMN_FLAG[31] = true;
	}
	public int getPathlevel()
	{
		return pathlevel;
	}
	public void setHotlevel(int hotlevel)
	{
		this.hotlevel=hotlevel;
		COLUMN_FLAG[32] = true;
	}
	public int getHotlevel()
	{
		return hotlevel;
	}
	public void setFadongji(int fadongji)
	{
		this.fadongji=fadongji;
		COLUMN_FLAG[33] = true;
	}
	public int getFadongji()
	{
		return fadongji;
	}
	public void setBaoyangfeiyong(int baoyangfeiyong)
	{
		this.baoyangfeiyong=baoyangfeiyong;
		COLUMN_FLAG[34] = true;
	}
	public int getBaoyangfeiyong()
	{
		return baoyangfeiyong;
	}
	public void setPengzhuanglevel(int pengzhuanglevel)
	{
		this.pengzhuanglevel=pengzhuanglevel;
		COLUMN_FLAG[35] = true;
	}
	public int getPengzhuanglevel()
	{
		return pengzhuanglevel;
	}
	public void setGuanurl(String guanurl)
	{
		this.guanurl=guanurl;
		COLUMN_FLAG[36] = true;
	}
	public String getGuanurl()
	{
		return guanurl;
	}
	public void setWayname(String wayname)
	{
		this.wayname=wayname;
		COLUMN_FLAG[37] = true;
	}
	public String getWayname()
	{
		return wayname;
	}
	public void setCarbrandphoto(String carbrandphoto)
	{
		this.carbrandphoto=carbrandphoto;
		COLUMN_FLAG[38] = true;
	}
	public String getCarbrandphoto()
	{
		return carbrandphoto;
	}
	public void setOld_catalogid(int old_catalogid)
	{
		this.old_catalogid=old_catalogid;
		COLUMN_FLAG[39] = true;
	}
	public int getOld_catalogid()
	{
		return old_catalogid;
	}
	public void setOld_fatherid(int old_fatherid)
	{
		this.old_fatherid=old_fatherid;
		COLUMN_FLAG[40] = true;
	}
	public int getOld_fatherid()
	{
		return old_fatherid;
	}
	public void setYiche_price(double yiche_price)
	{
		this.yiche_price=yiche_price;
		COLUMN_FLAG[41] = true;
	}
	public double getYiche_price()
	{
		return yiche_price;
	}
	public void setChetuanphoto(String chetuanphoto)
	{
		this.chetuanphoto=chetuanphoto;
		COLUMN_FLAG[42] = true;
	}
	public String getChetuanphoto()
	{
		return chetuanphoto;
	}
}
