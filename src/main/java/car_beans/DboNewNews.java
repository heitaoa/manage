package car_beans;
import java.util.*;

public class  DboNewNews  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//自动增长id
	private int newscatalogid;//新闻分类
	private int areaid;//地域分类id
	private int carcatalogid;//车型分类id
	private String newstitle;//标题
	private String newskeywords;//关键字
	private String titlephoto;//图片
	private String newseditor;//作者和出处信息
	private String addadmin;//添加操作管理员用户名
	private String updateadmin;//修改操作管理员用户名
	private String deladmin;//删除操作管理员用户名
	private int totop;//被顶的次数
	private int tosink;//被踩的次数
	private int gradeid1;//扩展列1 (是否是第一次发布)
	private int gradeid2;//扩展列2
	private int gradeid3;//扩展列3
	private int gradeid4;//扩展列4
	private int gradeid5;//扩展列5
	private Date adddate;//添加时间
	private Date lastupdate;//最后更新时间
	private int isdelete;//0正常
	private int sortid;//
	private int isphoto;//
	private String description;//
	private int isoriginal;//
	private Date toptime;//
	private Date sinktime;//
	private String relink;//
	private int isimgnews;//
	private int pricedown;//
	private String carslevel;//
	private int serialid;//
	private String shorttitle;//
	private int chktitlephoto;//
	private int chkdescription;//
	private int islook;//
	private int ismultpagelink;//是否显示分页链接;0|不显示分页链接；1|显示分页链接；
	private int iswap;//是否需要生成wap版
	private int old_carcatalogid;//老315车型数据
	private Date savedate;//文章第一次保存时间

	private DboNewCatalog catalog;//
	public void setCatalog(DboNewCatalog catalog)
	{
		this.catalog=catalog;
	}
	public DboNewCatalog getCatalog()
	{
		return catalog;
	}
	private List contents;//
	public void setContents(List contents)
	{
		this.contents=contents;
	}
	public List getContents()
	{
		return contents;
	}

	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setNewscatalogid(int newscatalogid)
	{
		this.newscatalogid=newscatalogid;
		COLUMN_FLAG[1] = true;
	}
	public int getNewscatalogid()
	{
		return newscatalogid;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[2] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setCarcatalogid(int carcatalogid)
	{
		this.carcatalogid=carcatalogid;
		COLUMN_FLAG[3] = true;
	}
	public int getCarcatalogid()
	{
		return carcatalogid;
	}
	public void setNewstitle(String newstitle)
	{
		this.newstitle=newstitle;
		COLUMN_FLAG[4] = true;
	}
	public String getNewstitle()
	{
		return newstitle;
	}
	public void setNewskeywords(String newskeywords)
	{
		this.newskeywords=newskeywords;
		COLUMN_FLAG[5] = true;
	}
	public String getNewskeywords()
	{
		return newskeywords;
	}
	public void setTitlephoto(String titlephoto)
	{
		this.titlephoto=titlephoto;
		COLUMN_FLAG[6] = true;
	}
	public String getTitlephoto()
	{
		return titlephoto;
	}
	public void setNewseditor(String newseditor)
	{
		this.newseditor=newseditor;
		COLUMN_FLAG[7] = true;
	}
	public String getNewseditor()
	{
		return newseditor;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[8] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpdateadmin(String updateadmin)
	{
		this.updateadmin=updateadmin;
		COLUMN_FLAG[9] = true;
	}
	public String getUpdateadmin()
	{
		return updateadmin;
	}
	public void setDeladmin(String deladmin)
	{
		this.deladmin=deladmin;
		COLUMN_FLAG[10] = true;
	}
	public String getDeladmin()
	{
		return deladmin;
	}
	public void setTotop(int totop)
	{
		this.totop=totop;
		COLUMN_FLAG[11] = true;
	}
	public int getTotop()
	{
		return totop;
	}
	public void setTosink(int tosink)
	{
		this.tosink=tosink;
		COLUMN_FLAG[12] = true;
	}
	public int getTosink()
	{
		return tosink;
	}
	public void setGradeid1(int gradeid1)
	{
		this.gradeid1=gradeid1;
		COLUMN_FLAG[13] = true;
	}
	public int getGradeid1()
	{
		return gradeid1;
	}
	public void setGradeid2(int gradeid2)
	{
		this.gradeid2=gradeid2;
		COLUMN_FLAG[14] = true;
	}
	public int getGradeid2()
	{
		return gradeid2;
	}
	public void setGradeid3(int gradeid3)
	{
		this.gradeid3=gradeid3;
		COLUMN_FLAG[15] = true;
	}
	public int getGradeid3()
	{
		return gradeid3;
	}
	public void setGradeid4(int gradeid4)
	{
		this.gradeid4=gradeid4;
		COLUMN_FLAG[16] = true;
	}
	public int getGradeid4()
	{
		return gradeid4;
	}
	public void setGradeid5(int gradeid5)
	{
		this.gradeid5=gradeid5;
		COLUMN_FLAG[17] = true;
	}
	public int getGradeid5()
	{
		return gradeid5;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[18] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[19] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[20] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[21] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setIsphoto(int isphoto)
	{
		this.isphoto=isphoto;
		COLUMN_FLAG[22] = true;
	}
	public int getIsphoto()
	{
		return isphoto;
	}
	public void setDescription(String description)
	{
		this.description=description;
		COLUMN_FLAG[23] = true;
	}
	public String getDescription()
	{
		return description;
	}
	public void setIsoriginal(int isoriginal)
	{
		this.isoriginal=isoriginal;
		COLUMN_FLAG[24] = true;
	}
	public int getIsoriginal()
	{
		return isoriginal;
	}
	public void setToptime(Date toptime)
	{
		this.toptime=toptime;
		COLUMN_FLAG[25] = true;
	}
	public Date getToptime()
	{
		return toptime;
	}
	public void setSinktime(Date sinktime)
	{
		this.sinktime=sinktime;
		COLUMN_FLAG[26] = true;
	}
	public Date getSinktime()
	{
		return sinktime;
	}
	public void setRelink(String relink)
	{
		this.relink=relink;
		COLUMN_FLAG[27] = true;
	}
	public String getRelink()
	{
		return relink;
	}
	public void setIsimgnews(int isimgnews)
	{
		this.isimgnews=isimgnews;
		COLUMN_FLAG[28] = true;
	}
	public int getIsimgnews()
	{
		return isimgnews;
	}
	public void setPricedown(int pricedown)
	{
		this.pricedown=pricedown;
		COLUMN_FLAG[29] = true;
	}
	public int getPricedown()
	{
		return pricedown;
	}
	public void setCarslevel(String carslevel)
	{
		this.carslevel=carslevel;
		COLUMN_FLAG[30] = true;
	}
	public String getCarslevel()
	{
		return carslevel;
	}
	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[31] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
	public void setShorttitle(String shorttitle)
	{
		this.shorttitle=shorttitle;
		COLUMN_FLAG[32] = true;
	}
	public String getShorttitle()
	{
		return shorttitle;
	}
	public void setChktitlephoto(int chktitlephoto)
	{
		this.chktitlephoto=chktitlephoto;
		COLUMN_FLAG[33] = true;
	}
	public int getChktitlephoto()
	{
		return chktitlephoto;
	}
	public void setChkdescription(int chkdescription)
	{
		this.chkdescription=chkdescription;
		COLUMN_FLAG[34] = true;
	}
	public int getChkdescription()
	{
		return chkdescription;
	}
	public void setIslook(int islook)
	{
		this.islook=islook;
		COLUMN_FLAG[35] = true;
	}
	public int getIslook()
	{
		return islook;
	}
	public void setIsmultpagelink(int ismultpagelink)
	{
		this.ismultpagelink=ismultpagelink;
		COLUMN_FLAG[36] = true;
	}
	public int getIsmultpagelink()
	{
		return ismultpagelink;
	}
	public void setIswap(int iswap)
	{
		this.iswap=iswap;
		COLUMN_FLAG[37] = true;
	}
	public int getIswap()
	{
		return iswap;
	}
	public void setOld_carcatalogid(int old_carcatalogid)
	{
		this.old_carcatalogid=old_carcatalogid;
		COLUMN_FLAG[38] = true;
	}
	public int getOld_carcatalogid()
	{
		return old_carcatalogid;
	}
	public void setSavedate(Date savedate)
	{
		this.savedate=savedate;
		COLUMN_FLAG[39] = true;
	}
	public Date getSavedate()
	{
		return savedate;
	}
}
