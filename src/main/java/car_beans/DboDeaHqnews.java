package car_beans;
import java.util.*;

public class  DboDeaHqnews  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String title;//标题
	private String des;//导语
	private int serialid;//
	private String carids;//车型$官方指导价$优惠幅度;车型$官方指导价$优惠幅度；
	private Date starttime;//促销开始时间
	private Date endtime;//
	private String salemessage;//其他优惠信息
	private String bigpic;//车型大图
	private String pic1;//四张小图
	private String pic2;//四张小图
	private String pic3;//四张小图
	private String pic4;//四张小图
	private int isaddress;//
	private int ismap;//
	private int isdelete;//
	private Date adddate;//提交时间
	private int newid;//关联到dea_news中的id
	private double saleprice;//优惠金额
	private int eid;//
	private int isaddphone;//
	private int news315;//审核标识


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[1] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setDes(String des)
	{
		this.des=des;
		COLUMN_FLAG[2] = true;
	}
	public String getDes()
	{
		return des;
	}
	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[3] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
	public void setCarids(String carids)
	{
		this.carids=carids;
		COLUMN_FLAG[4] = true;
	}
	public String getCarids()
	{
		return carids;
	}
	public void setStarttime(Date starttime)
	{
		this.starttime=starttime;
		COLUMN_FLAG[5] = true;
	}
	public Date getStarttime()
	{
		return starttime;
	}
	public void setEndtime(Date endtime)
	{
		this.endtime=endtime;
		COLUMN_FLAG[6] = true;
	}
	public Date getEndtime()
	{
		return endtime;
	}
	public void setSalemessage(String salemessage)
	{
		this.salemessage=salemessage;
		COLUMN_FLAG[7] = true;
	}
	public String getSalemessage()
	{
		return salemessage;
	}
	public void setBigpic(String bigpic)
	{
		this.bigpic=bigpic;
		COLUMN_FLAG[8] = true;
	}
	public String getBigpic()
	{
		return bigpic;
	}
	public void setPic1(String pic1)
	{
		this.pic1=pic1;
		COLUMN_FLAG[9] = true;
	}
	public String getPic1()
	{
		return pic1;
	}
	public void setPic2(String pic2)
	{
		this.pic2=pic2;
		COLUMN_FLAG[10] = true;
	}
	public String getPic2()
	{
		return pic2;
	}
	public void setPic3(String pic3)
	{
		this.pic3=pic3;
		COLUMN_FLAG[11] = true;
	}
	public String getPic3()
	{
		return pic3;
	}
	public void setPic4(String pic4)
	{
		this.pic4=pic4;
		COLUMN_FLAG[12] = true;
	}
	public String getPic4()
	{
		return pic4;
	}
	public void setIsaddress(int isaddress)
	{
		this.isaddress=isaddress;
		COLUMN_FLAG[13] = true;
	}
	public int getIsaddress()
	{
		return isaddress;
	}
	public void setIsmap(int ismap)
	{
		this.ismap=ismap;
		COLUMN_FLAG[14] = true;
	}
	public int getIsmap()
	{
		return ismap;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[15] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[16] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setNewid(int newid)
	{
		this.newid=newid;
		COLUMN_FLAG[17] = true;
	}
	public int getNewid()
	{
		return newid;
	}
	public void setSaleprice(double saleprice)
	{
		this.saleprice=saleprice;
		COLUMN_FLAG[18] = true;
	}
	public double getSaleprice()
	{
		return saleprice;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[19] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setIsaddphone(int isaddphone)
	{
		this.isaddphone=isaddphone;
		COLUMN_FLAG[20] = true;
	}
	public int getIsaddphone()
	{
		return isaddphone;
	}
	public void setNews315(int news315)
	{
		this.news315=news315;
		COLUMN_FLAG[21] = true;
	}
	public int getNews315()
	{
		return news315;
	}
}
