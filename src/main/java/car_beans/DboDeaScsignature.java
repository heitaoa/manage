package car_beans;
import java.util.*;

public class  DboDeaScsignature  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int cid;//商品标示
	private String sncode;//
	private int status;//状态：0：下单未付款；1：已付款；2：未下单，尚在购物车中
	private int isdone;//0：未处理；1：已处理
	private int pickup;//
	private Date adddate;//
	private int eid;//
	private String username;//
	private String userphone;//
	private String openid;//微信用户
	private int num;//数量


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCid(int cid)
	{
		this.cid=cid;
		COLUMN_FLAG[1] = true;
	}
	public int getCid()
	{
		return cid;
	}
	public void setSncode(String sncode)
	{
		this.sncode=sncode;
		COLUMN_FLAG[2] = true;
	}
	public String getSncode()
	{
		return sncode;
	}
	public void setStatus(int status)
	{
		this.status=status;
		COLUMN_FLAG[3] = true;
	}
	public int getStatus()
	{
		return status;
	}
	public void setIsdone(int isdone)
	{
		this.isdone=isdone;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdone()
	{
		return isdone;
	}
	public void setPickup(int pickup)
	{
		this.pickup=pickup;
		COLUMN_FLAG[5] = true;
	}
	public int getPickup()
	{
		return pickup;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[6] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[7] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[8] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUserphone(String userphone)
	{
		this.userphone=userphone;
		COLUMN_FLAG[9] = true;
	}
	public String getUserphone()
	{
		return userphone;
	}
	public void setOpenid(String openid)
	{
		this.openid=openid;
		COLUMN_FLAG[10] = true;
	}
	public String getOpenid()
	{
		return openid;
	}
	public void setNum(int num)
	{
		this.num=num;
		COLUMN_FLAG[11] = true;
	}
	public int getNum()
	{
		return num;
	}
}
