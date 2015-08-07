package car_beans;
import java.util.*;

public class  DboPkztInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//pk专题自增长id
	private int carid1;//车系id1
	private int carid2;//车系id2
	private String prefacetitle;//
	private String prefacecontent;//
	private String apptitle;//
	private String appcontent1;//
	private String appcontent2;//
	private String appimgpath11;//
	private String appimgpath12;//
	private String appimgpath13;//
	private String appimgpath14;//
	private String appimgpath15;//
	private String appimgpath21;//
	private String appimgpath22;//
	private String appimgpath23;//
	private String appimgpath24;//
	private String appimgpath25;//
	private String seattitle;//
	private String seatcontent1;//
	private String seatcontent2;//
	private String seatimgpath11;//
	private String seatimgpath12;//
	private String seatimgpath13;//
	private String seatimgpath14;//
	private String seatimgpath15;//
	private String seatimgpath21;//
	private String seatimgpath22;//
	private String seatimgpath23;//
	private String seatimgpath24;//
	private String seatimgpath25;//
	private String ctrltitle;//
	private String ctrlcontent1;//
	private String ctrlcontent2;//
	private String ctrlimgpath11;//
	private String ctrlimgpath12;//
	private String ctrlimgpath21;//
	private String ctrlimgpath22;//
	private String summarytitle;//
	private String summarycontent;//
	private Date adddate;//
	private Date uptime;//
	private int isdelete;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCarid1(int carid1)
	{
		this.carid1=carid1;
		COLUMN_FLAG[1] = true;
	}
	public int getCarid1()
	{
		return carid1;
	}
	public void setCarid2(int carid2)
	{
		this.carid2=carid2;
		COLUMN_FLAG[2] = true;
	}
	public int getCarid2()
	{
		return carid2;
	}
	public void setPrefacetitle(String prefacetitle)
	{
		this.prefacetitle=prefacetitle;
		COLUMN_FLAG[3] = true;
	}
	public String getPrefacetitle()
	{
		return prefacetitle;
	}
	public void setPrefacecontent(String prefacecontent)
	{
		this.prefacecontent=prefacecontent;
		COLUMN_FLAG[4] = true;
	}
	public String getPrefacecontent()
	{
		return prefacecontent;
	}
	public void setApptitle(String apptitle)
	{
		this.apptitle=apptitle;
		COLUMN_FLAG[5] = true;
	}
	public String getApptitle()
	{
		return apptitle;
	}
	public void setAppcontent1(String appcontent1)
	{
		this.appcontent1=appcontent1;
		COLUMN_FLAG[6] = true;
	}
	public String getAppcontent1()
	{
		return appcontent1;
	}
	public void setAppcontent2(String appcontent2)
	{
		this.appcontent2=appcontent2;
		COLUMN_FLAG[7] = true;
	}
	public String getAppcontent2()
	{
		return appcontent2;
	}
	public void setAppimgpath11(String appimgpath11)
	{
		this.appimgpath11=appimgpath11;
		COLUMN_FLAG[8] = true;
	}
	public String getAppimgpath11()
	{
		return appimgpath11;
	}
	public void setAppimgpath12(String appimgpath12)
	{
		this.appimgpath12=appimgpath12;
		COLUMN_FLAG[9] = true;
	}
	public String getAppimgpath12()
	{
		return appimgpath12;
	}
	public void setAppimgpath13(String appimgpath13)
	{
		this.appimgpath13=appimgpath13;
		COLUMN_FLAG[10] = true;
	}
	public String getAppimgpath13()
	{
		return appimgpath13;
	}
	public void setAppimgpath14(String appimgpath14)
	{
		this.appimgpath14=appimgpath14;
		COLUMN_FLAG[11] = true;
	}
	public String getAppimgpath14()
	{
		return appimgpath14;
	}
	public void setAppimgpath15(String appimgpath15)
	{
		this.appimgpath15=appimgpath15;
		COLUMN_FLAG[12] = true;
	}
	public String getAppimgpath15()
	{
		return appimgpath15;
	}
	public void setAppimgpath21(String appimgpath21)
	{
		this.appimgpath21=appimgpath21;
		COLUMN_FLAG[13] = true;
	}
	public String getAppimgpath21()
	{
		return appimgpath21;
	}
	public void setAppimgpath22(String appimgpath22)
	{
		this.appimgpath22=appimgpath22;
		COLUMN_FLAG[14] = true;
	}
	public String getAppimgpath22()
	{
		return appimgpath22;
	}
	public void setAppimgpath23(String appimgpath23)
	{
		this.appimgpath23=appimgpath23;
		COLUMN_FLAG[15] = true;
	}
	public String getAppimgpath23()
	{
		return appimgpath23;
	}
	public void setAppimgpath24(String appimgpath24)
	{
		this.appimgpath24=appimgpath24;
		COLUMN_FLAG[16] = true;
	}
	public String getAppimgpath24()
	{
		return appimgpath24;
	}
	public void setAppimgpath25(String appimgpath25)
	{
		this.appimgpath25=appimgpath25;
		COLUMN_FLAG[17] = true;
	}
	public String getAppimgpath25()
	{
		return appimgpath25;
	}
	public void setSeattitle(String seattitle)
	{
		this.seattitle=seattitle;
		COLUMN_FLAG[18] = true;
	}
	public String getSeattitle()
	{
		return seattitle;
	}
	public void setSeatcontent1(String seatcontent1)
	{
		this.seatcontent1=seatcontent1;
		COLUMN_FLAG[19] = true;
	}
	public String getSeatcontent1()
	{
		return seatcontent1;
	}
	public void setSeatcontent2(String seatcontent2)
	{
		this.seatcontent2=seatcontent2;
		COLUMN_FLAG[20] = true;
	}
	public String getSeatcontent2()
	{
		return seatcontent2;
	}
	public void setSeatimgpath11(String seatimgpath11)
	{
		this.seatimgpath11=seatimgpath11;
		COLUMN_FLAG[21] = true;
	}
	public String getSeatimgpath11()
	{
		return seatimgpath11;
	}
	public void setSeatimgpath12(String seatimgpath12)
	{
		this.seatimgpath12=seatimgpath12;
		COLUMN_FLAG[22] = true;
	}
	public String getSeatimgpath12()
	{
		return seatimgpath12;
	}
	public void setSeatimgpath13(String seatimgpath13)
	{
		this.seatimgpath13=seatimgpath13;
		COLUMN_FLAG[23] = true;
	}
	public String getSeatimgpath13()
	{
		return seatimgpath13;
	}
	public void setSeatimgpath14(String seatimgpath14)
	{
		this.seatimgpath14=seatimgpath14;
		COLUMN_FLAG[24] = true;
	}
	public String getSeatimgpath14()
	{
		return seatimgpath14;
	}
	public void setSeatimgpath15(String seatimgpath15)
	{
		this.seatimgpath15=seatimgpath15;
		COLUMN_FLAG[25] = true;
	}
	public String getSeatimgpath15()
	{
		return seatimgpath15;
	}
	public void setSeatimgpath21(String seatimgpath21)
	{
		this.seatimgpath21=seatimgpath21;
		COLUMN_FLAG[26] = true;
	}
	public String getSeatimgpath21()
	{
		return seatimgpath21;
	}
	public void setSeatimgpath22(String seatimgpath22)
	{
		this.seatimgpath22=seatimgpath22;
		COLUMN_FLAG[27] = true;
	}
	public String getSeatimgpath22()
	{
		return seatimgpath22;
	}
	public void setSeatimgpath23(String seatimgpath23)
	{
		this.seatimgpath23=seatimgpath23;
		COLUMN_FLAG[28] = true;
	}
	public String getSeatimgpath23()
	{
		return seatimgpath23;
	}
	public void setSeatimgpath24(String seatimgpath24)
	{
		this.seatimgpath24=seatimgpath24;
		COLUMN_FLAG[29] = true;
	}
	public String getSeatimgpath24()
	{
		return seatimgpath24;
	}
	public void setSeatimgpath25(String seatimgpath25)
	{
		this.seatimgpath25=seatimgpath25;
		COLUMN_FLAG[30] = true;
	}
	public String getSeatimgpath25()
	{
		return seatimgpath25;
	}
	public void setCtrltitle(String ctrltitle)
	{
		this.ctrltitle=ctrltitle;
		COLUMN_FLAG[31] = true;
	}
	public String getCtrltitle()
	{
		return ctrltitle;
	}
	public void setCtrlcontent1(String ctrlcontent1)
	{
		this.ctrlcontent1=ctrlcontent1;
		COLUMN_FLAG[32] = true;
	}
	public String getCtrlcontent1()
	{
		return ctrlcontent1;
	}
	public void setCtrlcontent2(String ctrlcontent2)
	{
		this.ctrlcontent2=ctrlcontent2;
		COLUMN_FLAG[33] = true;
	}
	public String getCtrlcontent2()
	{
		return ctrlcontent2;
	}
	public void setCtrlimgpath11(String ctrlimgpath11)
	{
		this.ctrlimgpath11=ctrlimgpath11;
		COLUMN_FLAG[34] = true;
	}
	public String getCtrlimgpath11()
	{
		return ctrlimgpath11;
	}
	public void setCtrlimgpath12(String ctrlimgpath12)
	{
		this.ctrlimgpath12=ctrlimgpath12;
		COLUMN_FLAG[35] = true;
	}
	public String getCtrlimgpath12()
	{
		return ctrlimgpath12;
	}
	public void setCtrlimgpath21(String ctrlimgpath21)
	{
		this.ctrlimgpath21=ctrlimgpath21;
		COLUMN_FLAG[36] = true;
	}
	public String getCtrlimgpath21()
	{
		return ctrlimgpath21;
	}
	public void setCtrlimgpath22(String ctrlimgpath22)
	{
		this.ctrlimgpath22=ctrlimgpath22;
		COLUMN_FLAG[37] = true;
	}
	public String getCtrlimgpath22()
	{
		return ctrlimgpath22;
	}
	public void setSummarytitle(String summarytitle)
	{
		this.summarytitle=summarytitle;
		COLUMN_FLAG[38] = true;
	}
	public String getSummarytitle()
	{
		return summarytitle;
	}
	public void setSummarycontent(String summarycontent)
	{
		this.summarycontent=summarycontent;
		COLUMN_FLAG[39] = true;
	}
	public String getSummarycontent()
	{
		return summarycontent;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[40] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setUptime(Date uptime)
	{
		this.uptime=uptime;
		COLUMN_FLAG[41] = true;
	}
	public Date getUptime()
	{
		return uptime;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[42] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
}
