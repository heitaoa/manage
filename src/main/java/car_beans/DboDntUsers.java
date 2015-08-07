package car_beans;
import java.util.*;

public class  DboDntUsers  implements java.io.Serializable{

	public String KEY = "uid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int uid;//
	private String username;//登录名
	private String nickname;//
	private String password;//
	private String secques;//
	private int spaceid;//地域信息
	private int gender;//
	private int adminid;//
	private int groupid;//
	private int groupexpiry;//
	private String extgroupids;//
	private String regip;//
	private Date joindate;//
	private String lastip;//
	private Date lastvisit;//
	private Date lastactivity;//
	private Date lastpost;//
	private int lastpostid;//
	private String lastposttitle;//
	private int posts;//
	private int digestposts;//
	private int oltime;//
	private int pageviews;//
	private double credits;//
	private double extcredits1;//
	private double extcredits2;//
	private double extcredits3;//
	private double extcredits4;//
	private double extcredits5;//
	private double extcredits6;//
	private double extcredits7;//
	private double extcredits8;//
	private int avatarshowid;//
	private String email;//
	private String bday;//
	private int sigstatus;//
	private int tpp;//
	private int ppp;//
	private int templateid;//
	private int pmsound;//
	private int showemail;//
	private int newsletter;//
	private int invisible;//
	private int newpm;//
	private int newpmcount;//
	private int accessmasks;//
	private int onlinestate;//
	private String pass;//
	private String salt;//
	private String salt2;//
	private String carnumber;//
	private int guid;//
	private Date buydate;//


	public void setUid(int uid)
	{
		this.uid=uid;
		COLUMN_FLAG[0] = true;
	}
	public int getUid()
	{
		return uid;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[1] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setNickname(String nickname)
	{
		this.nickname=nickname;
		COLUMN_FLAG[2] = true;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setPassword(String password)
	{
		this.password=password;
		COLUMN_FLAG[3] = true;
	}
	public String getPassword()
	{
		return password;
	}
	public void setSecques(String secques)
	{
		this.secques=secques;
		COLUMN_FLAG[4] = true;
	}
	public String getSecques()
	{
		return secques;
	}
	public void setSpaceid(int spaceid)
	{
		this.spaceid=spaceid;
		COLUMN_FLAG[5] = true;
	}
	public int getSpaceid()
	{
		return spaceid;
	}
	public void setGender(int gender)
	{
		this.gender=gender;
		COLUMN_FLAG[6] = true;
	}
	public int getGender()
	{
		return gender;
	}
	public void setAdminid(int adminid)
	{
		this.adminid=adminid;
		COLUMN_FLAG[7] = true;
	}
	public int getAdminid()
	{
		return adminid;
	}
	public void setGroupid(int groupid)
	{
		this.groupid=groupid;
		COLUMN_FLAG[8] = true;
	}
	public int getGroupid()
	{
		return groupid;
	}
	public void setGroupexpiry(int groupexpiry)
	{
		this.groupexpiry=groupexpiry;
		COLUMN_FLAG[9] = true;
	}
	public int getGroupexpiry()
	{
		return groupexpiry;
	}
	public void setExtgroupids(String extgroupids)
	{
		this.extgroupids=extgroupids;
		COLUMN_FLAG[10] = true;
	}
	public String getExtgroupids()
	{
		return extgroupids;
	}
	public void setRegip(String regip)
	{
		this.regip=regip;
		COLUMN_FLAG[11] = true;
	}
	public String getRegip()
	{
		return regip;
	}
	public void setJoindate(Date joindate)
	{
		this.joindate=joindate;
		COLUMN_FLAG[12] = true;
	}
	public Date getJoindate()
	{
		return joindate;
	}
	public void setLastip(String lastip)
	{
		this.lastip=lastip;
		COLUMN_FLAG[13] = true;
	}
	public String getLastip()
	{
		return lastip;
	}
	public void setLastvisit(Date lastvisit)
	{
		this.lastvisit=lastvisit;
		COLUMN_FLAG[14] = true;
	}
	public Date getLastvisit()
	{
		return lastvisit;
	}
	public void setLastactivity(Date lastactivity)
	{
		this.lastactivity=lastactivity;
		COLUMN_FLAG[15] = true;
	}
	public Date getLastactivity()
	{
		return lastactivity;
	}
	public void setLastpost(Date lastpost)
	{
		this.lastpost=lastpost;
		COLUMN_FLAG[16] = true;
	}
	public Date getLastpost()
	{
		return lastpost;
	}
	public void setLastpostid(int lastpostid)
	{
		this.lastpostid=lastpostid;
		COLUMN_FLAG[17] = true;
	}
	public int getLastpostid()
	{
		return lastpostid;
	}
	public void setLastposttitle(String lastposttitle)
	{
		this.lastposttitle=lastposttitle;
		COLUMN_FLAG[18] = true;
	}
	public String getLastposttitle()
	{
		return lastposttitle;
	}
	public void setPosts(int posts)
	{
		this.posts=posts;
		COLUMN_FLAG[19] = true;
	}
	public int getPosts()
	{
		return posts;
	}
	public void setDigestposts(int digestposts)
	{
		this.digestposts=digestposts;
		COLUMN_FLAG[20] = true;
	}
	public int getDigestposts()
	{
		return digestposts;
	}
	public void setOltime(int oltime)
	{
		this.oltime=oltime;
		COLUMN_FLAG[21] = true;
	}
	public int getOltime()
	{
		return oltime;
	}
	public void setPageviews(int pageviews)
	{
		this.pageviews=pageviews;
		COLUMN_FLAG[22] = true;
	}
	public int getPageviews()
	{
		return pageviews;
	}
	public void setCredits(double credits)
	{
		this.credits=credits;
		COLUMN_FLAG[23] = true;
	}
	public double getCredits()
	{
		return credits;
	}
	public void setExtcredits1(double extcredits1)
	{
		this.extcredits1=extcredits1;
		COLUMN_FLAG[24] = true;
	}
	public double getExtcredits1()
	{
		return extcredits1;
	}
	public void setExtcredits2(double extcredits2)
	{
		this.extcredits2=extcredits2;
		COLUMN_FLAG[25] = true;
	}
	public double getExtcredits2()
	{
		return extcredits2;
	}
	public void setExtcredits3(double extcredits3)
	{
		this.extcredits3=extcredits3;
		COLUMN_FLAG[26] = true;
	}
	public double getExtcredits3()
	{
		return extcredits3;
	}
	public void setExtcredits4(double extcredits4)
	{
		this.extcredits4=extcredits4;
		COLUMN_FLAG[27] = true;
	}
	public double getExtcredits4()
	{
		return extcredits4;
	}
	public void setExtcredits5(double extcredits5)
	{
		this.extcredits5=extcredits5;
		COLUMN_FLAG[28] = true;
	}
	public double getExtcredits5()
	{
		return extcredits5;
	}
	public void setExtcredits6(double extcredits6)
	{
		this.extcredits6=extcredits6;
		COLUMN_FLAG[29] = true;
	}
	public double getExtcredits6()
	{
		return extcredits6;
	}
	public void setExtcredits7(double extcredits7)
	{
		this.extcredits7=extcredits7;
		COLUMN_FLAG[30] = true;
	}
	public double getExtcredits7()
	{
		return extcredits7;
	}
	public void setExtcredits8(double extcredits8)
	{
		this.extcredits8=extcredits8;
		COLUMN_FLAG[31] = true;
	}
	public double getExtcredits8()
	{
		return extcredits8;
	}
	public void setAvatarshowid(int avatarshowid)
	{
		this.avatarshowid=avatarshowid;
		COLUMN_FLAG[32] = true;
	}
	public int getAvatarshowid()
	{
		return avatarshowid;
	}
	public void setEmail(String email)
	{
		this.email=email;
		COLUMN_FLAG[33] = true;
	}
	public String getEmail()
	{
		return email;
	}
	public void setBday(String bday)
	{
		this.bday=bday;
		COLUMN_FLAG[34] = true;
	}
	public String getBday()
	{
		return bday;
	}
	public void setSigstatus(int sigstatus)
	{
		this.sigstatus=sigstatus;
		COLUMN_FLAG[35] = true;
	}
	public int getSigstatus()
	{
		return sigstatus;
	}
	public void setTpp(int tpp)
	{
		this.tpp=tpp;
		COLUMN_FLAG[36] = true;
	}
	public int getTpp()
	{
		return tpp;
	}
	public void setPpp(int ppp)
	{
		this.ppp=ppp;
		COLUMN_FLAG[37] = true;
	}
	public int getPpp()
	{
		return ppp;
	}
	public void setTemplateid(int templateid)
	{
		this.templateid=templateid;
		COLUMN_FLAG[38] = true;
	}
	public int getTemplateid()
	{
		return templateid;
	}
	public void setPmsound(int pmsound)
	{
		this.pmsound=pmsound;
		COLUMN_FLAG[39] = true;
	}
	public int getPmsound()
	{
		return pmsound;
	}
	public void setShowemail(int showemail)
	{
		this.showemail=showemail;
		COLUMN_FLAG[40] = true;
	}
	public int getShowemail()
	{
		return showemail;
	}
	public void setNewsletter(int newsletter)
	{
		this.newsletter=newsletter;
		COLUMN_FLAG[41] = true;
	}
	public int getNewsletter()
	{
		return newsletter;
	}
	public void setInvisible(int invisible)
	{
		this.invisible=invisible;
		COLUMN_FLAG[42] = true;
	}
	public int getInvisible()
	{
		return invisible;
	}
	public void setNewpm(int newpm)
	{
		this.newpm=newpm;
		COLUMN_FLAG[43] = true;
	}
	public int getNewpm()
	{
		return newpm;
	}
	public void setNewpmcount(int newpmcount)
	{
		this.newpmcount=newpmcount;
		COLUMN_FLAG[44] = true;
	}
	public int getNewpmcount()
	{
		return newpmcount;
	}
	public void setAccessmasks(int accessmasks)
	{
		this.accessmasks=accessmasks;
		COLUMN_FLAG[45] = true;
	}
	public int getAccessmasks()
	{
		return accessmasks;
	}
	public void setOnlinestate(int onlinestate)
	{
		this.onlinestate=onlinestate;
		COLUMN_FLAG[46] = true;
	}
	public int getOnlinestate()
	{
		return onlinestate;
	}
	public void setPass(String pass)
	{
		this.pass=pass;
		COLUMN_FLAG[47] = true;
	}
	public String getPass()
	{
		return pass;
	}
	public void setSalt(String salt)
	{
		this.salt=salt;
		COLUMN_FLAG[48] = true;
	}
	public String getSalt()
	{
		return salt;
	}
	public void setSalt2(String salt2)
	{
		this.salt2=salt2;
		COLUMN_FLAG[49] = true;
	}
	public String getSalt2()
	{
		return salt2;
	}
	public void setCarnumber(String carnumber)
	{
		this.carnumber=carnumber;
		COLUMN_FLAG[50] = true;
	}
	public String getCarnumber()
	{
		return carnumber;
	}
	public void setGuid(int guid)
	{
		this.guid=guid;
		COLUMN_FLAG[51] = true;
	}
	public int getGuid()
	{
		return guid;
	}
	public void setBuydate(Date buydate)
	{
		this.buydate=buydate;
		COLUMN_FLAG[52] = true;
	}
	public Date getBuydate()
	{
		return buydate;
	}
}
