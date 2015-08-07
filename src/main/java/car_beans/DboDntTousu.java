package car_beans;
import java.util.*;

public class  DboDntTousu  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int uid;//
	private String name;//
	private String phone;//
	private String email;//
	private String port;//
	private String address;//
	private String hao;//
	private String lc;//
	private String fdj;//
	private String cj;//
	private int serial;//
	private Date buydate;//
	private String ssssname;//
	private String sssstel;//
	private int xladdress;//
	private int carstate;//
	private String problem;//
	private String suqiu;//
	private String title;//
	private String content;//
	private Date addtime;//
	private int state;//
	private String image;//
	private String imagename;//
	private String cause;//
	private int tid;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUid(int uid)
	{
		this.uid=uid;
		COLUMN_FLAG[1] = true;
	}
	public int getUid()
	{
		return uid;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[2] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[3] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setEmail(String email)
	{
		this.email=email;
		COLUMN_FLAG[4] = true;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPort(String port)
	{
		this.port=port;
		COLUMN_FLAG[5] = true;
	}
	public String getPort()
	{
		return port;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[6] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setHao(String hao)
	{
		this.hao=hao;
		COLUMN_FLAG[7] = true;
	}
	public String getHao()
	{
		return hao;
	}
	public void setLc(String lc)
	{
		this.lc=lc;
		COLUMN_FLAG[8] = true;
	}
	public String getLc()
	{
		return lc;
	}
	public void setFdj(String fdj)
	{
		this.fdj=fdj;
		COLUMN_FLAG[9] = true;
	}
	public String getFdj()
	{
		return fdj;
	}
	public void setCj(String cj)
	{
		this.cj=cj;
		COLUMN_FLAG[10] = true;
	}
	public String getCj()
	{
		return cj;
	}
	public void setSerial(int serial)
	{
		this.serial=serial;
		COLUMN_FLAG[11] = true;
	}
	public int getSerial()
	{
		return serial;
	}
	public void setBuydate(Date buydate)
	{
		this.buydate=buydate;
		COLUMN_FLAG[12] = true;
	}
	public Date getBuydate()
	{
		return buydate;
	}
	public void setSsssname(String ssssname)
	{
		this.ssssname=ssssname;
		COLUMN_FLAG[13] = true;
	}
	public String getSsssname()
	{
		return ssssname;
	}
	public void setSssstel(String sssstel)
	{
		this.sssstel=sssstel;
		COLUMN_FLAG[14] = true;
	}
	public String getSssstel()
	{
		return sssstel;
	}
	public void setXladdress(int xladdress)
	{
		this.xladdress=xladdress;
		COLUMN_FLAG[15] = true;
	}
	public int getXladdress()
	{
		return xladdress;
	}
	public void setCarstate(int carstate)
	{
		this.carstate=carstate;
		COLUMN_FLAG[16] = true;
	}
	public int getCarstate()
	{
		return carstate;
	}
	public void setProblem(String problem)
	{
		this.problem=problem;
		COLUMN_FLAG[17] = true;
	}
	public String getProblem()
	{
		return problem;
	}
	public void setSuqiu(String suqiu)
	{
		this.suqiu=suqiu;
		COLUMN_FLAG[18] = true;
	}
	public String getSuqiu()
	{
		return suqiu;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[19] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setContent(String content)
	{
		this.content=content;
		COLUMN_FLAG[20] = true;
	}
	public String getContent()
	{
		return content;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[21] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setState(int state)
	{
		this.state=state;
		COLUMN_FLAG[22] = true;
	}
	public int getState()
	{
		return state;
	}
	public void setImage(String image)
	{
		this.image=image;
		COLUMN_FLAG[23] = true;
	}
	public String getImage()
	{
		return image;
	}
	public void setImagename(String imagename)
	{
		this.imagename=imagename;
		COLUMN_FLAG[24] = true;
	}
	public String getImagename()
	{
		return imagename;
	}
	public void setCause(String cause)
	{
		this.cause=cause;
		COLUMN_FLAG[25] = true;
	}
	public String getCause()
	{
		return cause;
	}
	public void setTid(int tid)
	{
		this.tid=tid;
		COLUMN_FLAG[26] = true;
	}
	public int getTid()
	{
		return tid;
	}
}
