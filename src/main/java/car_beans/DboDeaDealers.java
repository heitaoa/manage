package car_beans;
import java.util.*;

public class  DboDeaDealers  implements java.io.Serializable{

	public String KEY = "eid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int eid;//企业id
	private int paylevel;//企业级别  0一般 4试用 5正式
	private int areaid;//所在地区
	private int modelid;//使用模板id
	private String shortename;//企业简称
	private String mainbrand;//主营品牌
	private String username;//登录账号
	private String ename;//企业名称
	private String domain;//个性域名
	private int indexhotnewssetting;//首页热点新闻设置，0--自动选取最新新闻，1--手动选取
	private int isdelete;//删除标识
	private Date adddate;//
	private String areaids;//
	private String telephone;//
	private Date expirationdate;//
	private int isbitauto;//
	private int is4s;//
	private int isbitautoprice;//
	private int seposttableid;//
	private String address;//
	private int addbbs;//
	private int maxpushid;//
	private Date pushdate;//
	private int bmbasiccount;//
	private String iway;//
	private int issenior;// 默认为0，不为空
	private String remarks;//
	private int isvip;//是否vip经销商1：是，0：不是（默认0）
	private int jinbi;//金币（也可以理解是积分）
	private int isfinishinfo;//是否100%完善信息
	private int isfirstbindmobile;//是否首次成功绑定手机号
	private Date lastlogintime;//最后一次登录时间 (用于对以下规则的判断：vip会员每天第一次登陆后台，奖励金币2)
	private int istmp;//0不是临时1临时用户
	private int ishaotuban;//是否是好途邦
	private int issupervip;//是否是超级vip


	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[0] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setPaylevel(int paylevel)
	{
		this.paylevel=paylevel;
		COLUMN_FLAG[1] = true;
	}
	public int getPaylevel()
	{
		return paylevel;
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
	public void setModelid(int modelid)
	{
		this.modelid=modelid;
		COLUMN_FLAG[3] = true;
	}
	public int getModelid()
	{
		return modelid;
	}
	public void setShortename(String shortename)
	{
		this.shortename=shortename;
		COLUMN_FLAG[4] = true;
	}
	public String getShortename()
	{
		return shortename;
	}
	public void setMainbrand(String mainbrand)
	{
		this.mainbrand=mainbrand;
		COLUMN_FLAG[5] = true;
	}
	public String getMainbrand()
	{
		return mainbrand;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[6] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
		COLUMN_FLAG[7] = true;
	}
	public String getEname()
	{
		return ename;
	}
	public void setDomain(String domain)
	{
		this.domain=domain;
		COLUMN_FLAG[8] = true;
	}
	public String getDomain()
	{
		return domain;
	}
	public void setIndexhotnewssetting(int indexhotnewssetting)
	{
		this.indexhotnewssetting=indexhotnewssetting;
		COLUMN_FLAG[9] = true;
	}
	public int getIndexhotnewssetting()
	{
		return indexhotnewssetting;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[10] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[11] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setAreaids(String areaids)
	{
		this.areaids=areaids;
		COLUMN_FLAG[12] = true;
	}
	public String getAreaids()
	{
		return areaids;
	}
	public void setTelephone(String telephone)
	{
		this.telephone=telephone;
		COLUMN_FLAG[13] = true;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setExpirationdate(Date expirationdate)
	{
		this.expirationdate=expirationdate;
		COLUMN_FLAG[14] = true;
	}
	public Date getExpirationdate()
	{
		return expirationdate;
	}
	public void setIsbitauto(int isbitauto)
	{
		this.isbitauto=isbitauto;
		COLUMN_FLAG[15] = true;
	}
	public int getIsbitauto()
	{
		return isbitauto;
	}
	public void setIs4s(int is4s)
	{
		this.is4s=is4s;
		COLUMN_FLAG[16] = true;
	}
	public int getIs4s()
	{
		return is4s;
	}
	public void setIsbitautoprice(int isbitautoprice)
	{
		this.isbitautoprice=isbitautoprice;
		COLUMN_FLAG[17] = true;
	}
	public int getIsbitautoprice()
	{
		return isbitautoprice;
	}
	public void setSeposttableid(int seposttableid)
	{
		this.seposttableid=seposttableid;
		COLUMN_FLAG[18] = true;
	}
	public int getSeposttableid()
	{
		return seposttableid;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[19] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddbbs(int addbbs)
	{
		this.addbbs=addbbs;
		COLUMN_FLAG[20] = true;
	}
	public int getAddbbs()
	{
		return addbbs;
	}
	public void setMaxpushid(int maxpushid)
	{
		this.maxpushid=maxpushid;
		COLUMN_FLAG[21] = true;
	}
	public int getMaxpushid()
	{
		return maxpushid;
	}
	public void setPushdate(Date pushdate)
	{
		this.pushdate=pushdate;
		COLUMN_FLAG[22] = true;
	}
	public Date getPushdate()
	{
		return pushdate;
	}
	public void setBmbasiccount(int bmbasiccount)
	{
		this.bmbasiccount=bmbasiccount;
		COLUMN_FLAG[23] = true;
	}
	public int getBmbasiccount()
	{
		return bmbasiccount;
	}
	public void setIway(String iway)
	{
		this.iway=iway;
		COLUMN_FLAG[24] = true;
	}
	public String getIway()
	{
		return iway;
	}
	public void setIssenior(int issenior)
	{
		this.issenior=issenior;
		COLUMN_FLAG[25] = true;
	}
	public int getIssenior()
	{
		return issenior;
	}
	public void setRemarks(String remarks)
	{
		this.remarks=remarks;
		COLUMN_FLAG[26] = true;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setIsvip(int isvip)
	{
		this.isvip=isvip;
		COLUMN_FLAG[27] = true;
	}
	public int getIsvip()
	{
		return isvip;
	}
	public void setJinbi(int jinbi)
	{
		this.jinbi=jinbi;
		COLUMN_FLAG[28] = true;
	}
	public int getJinbi()
	{
		return jinbi;
	}
	public void setIsfinishinfo(int isfinishinfo)
	{
		this.isfinishinfo=isfinishinfo;
		COLUMN_FLAG[29] = true;
	}
	public int getIsfinishinfo()
	{
		return isfinishinfo;
	}
	public void setIsfirstbindmobile(int isfirstbindmobile)
	{
		this.isfirstbindmobile=isfirstbindmobile;
		COLUMN_FLAG[30] = true;
	}
	public int getIsfirstbindmobile()
	{
		return isfirstbindmobile;
	}
	public void setLastlogintime(Date lastlogintime)
	{
		this.lastlogintime=lastlogintime;
		COLUMN_FLAG[31] = true;
	}
	public Date getLastlogintime()
	{
		return lastlogintime;
	}
	public void setIstmp(int istmp)
	{
		this.istmp=istmp;
		COLUMN_FLAG[32] = true;
	}
	public int getIstmp()
	{
		return istmp;
	}
	public void setIshaotuban(int ishaotuban)
	{
		this.ishaotuban=ishaotuban;
		COLUMN_FLAG[33] = true;
	}
	public int getIshaotuban()
	{
		return ishaotuban;
	}
	public void setIssupervip(int issupervip)
	{
		this.issupervip=issupervip;
		COLUMN_FLAG[34] = true;
	}
	public int getIssupervip()
	{
		return issupervip;
	}
}
