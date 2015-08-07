package car_beans;
import java.util.*;

public class  DboDeaWxaccount  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private String wx_name;//
	private String wx_pwd;//
	private String wx_account;//
	private int wx_ok;//0-正在验证，1-成功，2-失败微信号的状态：-1：尚未绑定；2：0/3：验证中；1：绑定成功；2：验证失败；4：验证失败，可能资料不全
	private String wx_qrurl;//
	private Date adddate;//
	private Date last_update;//
	private String appid;//
	private String appsecret;//appid和appsecret可获取access_token（在线调试的token）
	private int is_service;//
	private String bizuin;//
	private String slave_user;//微信cookie里面的账号
	private String slave_sid;//微信cookie里面的加密串，和slave_user组成关键内容
	private String wtoken;//
	private Date checktime;//上一次api检查时间
	private Date cookiecheckdate;//上一次更新cookie的时间
	private int hasmenu;//
	private int zhuti;//微官网的风格
	private int apiday;//
	private int menu_status;//
	private int isaskingopen;//是否开通询问功能
	private int statdate;//
	private int update_interval;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[1] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setWx_name(String wx_name)
	{
		this.wx_name=wx_name;
		COLUMN_FLAG[2] = true;
	}
	public String getWx_name()
	{
		return wx_name;
	}
	public void setWx_pwd(String wx_pwd)
	{
		this.wx_pwd=wx_pwd;
		COLUMN_FLAG[3] = true;
	}
	public String getWx_pwd()
	{
		return wx_pwd;
	}
	public void setWx_account(String wx_account)
	{
		this.wx_account=wx_account;
		COLUMN_FLAG[4] = true;
	}
	public String getWx_account()
	{
		return wx_account;
	}
	public void setWx_ok(int wx_ok)
	{
		this.wx_ok=wx_ok;
		COLUMN_FLAG[5] = true;
	}
	public int getWx_ok()
	{
		return wx_ok;
	}
	public void setWx_qrurl(String wx_qrurl)
	{
		this.wx_qrurl=wx_qrurl;
		COLUMN_FLAG[6] = true;
	}
	public String getWx_qrurl()
	{
		return wx_qrurl;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[7] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLast_update(Date last_update)
	{
		this.last_update=last_update;
		COLUMN_FLAG[8] = true;
	}
	public Date getLast_update()
	{
		return last_update;
	}
	public void setAppid(String appid)
	{
		this.appid=appid;
		COLUMN_FLAG[9] = true;
	}
	public String getAppid()
	{
		return appid;
	}
	public void setAppsecret(String appsecret)
	{
		this.appsecret=appsecret;
		COLUMN_FLAG[10] = true;
	}
	public String getAppsecret()
	{
		return appsecret;
	}
	public void setIs_service(int is_service)
	{
		this.is_service=is_service;
		COLUMN_FLAG[11] = true;
	}
	public int getIs_service()
	{
		return is_service;
	}
	public void setBizuin(String bizuin)
	{
		this.bizuin=bizuin;
		COLUMN_FLAG[12] = true;
	}
	public String getBizuin()
	{
		return bizuin;
	}
	public void setSlave_user(String slave_user)
	{
		this.slave_user=slave_user;
		COLUMN_FLAG[13] = true;
	}
	public String getSlave_user()
	{
		return slave_user;
	}
	public void setSlave_sid(String slave_sid)
	{
		this.slave_sid=slave_sid;
		COLUMN_FLAG[14] = true;
	}
	public String getSlave_sid()
	{
		return slave_sid;
	}
	public void setWtoken(String wtoken)
	{
		this.wtoken=wtoken;
		COLUMN_FLAG[15] = true;
	}
	public String getWtoken()
	{
		return wtoken;
	}
	public void setChecktime(Date checktime)
	{
		this.checktime=checktime;
		COLUMN_FLAG[16] = true;
	}
	public Date getChecktime()
	{
		return checktime;
	}
	public void setCookiecheckdate(Date cookiecheckdate)
	{
		this.cookiecheckdate=cookiecheckdate;
		COLUMN_FLAG[17] = true;
	}
	public Date getCookiecheckdate()
	{
		return cookiecheckdate;
	}
	public void setHasmenu(int hasmenu)
	{
		this.hasmenu=hasmenu;
		COLUMN_FLAG[18] = true;
	}
	public int getHasmenu()
	{
		return hasmenu;
	}
	public void setZhuti(int zhuti)
	{
		this.zhuti=zhuti;
		COLUMN_FLAG[19] = true;
	}
	public int getZhuti()
	{
		return zhuti;
	}
	public void setApiday(int apiday)
	{
		this.apiday=apiday;
		COLUMN_FLAG[20] = true;
	}
	public int getApiday()
	{
		return apiday;
	}
	public void setMenu_status(int menu_status)
	{
		this.menu_status=menu_status;
		COLUMN_FLAG[21] = true;
	}
	public int getMenu_status()
	{
		return menu_status;
	}
	public void setIsaskingopen(int isaskingopen)
	{
		this.isaskingopen=isaskingopen;
		COLUMN_FLAG[22] = true;
	}
	public int getIsaskingopen()
	{
		return isaskingopen;
	}
	public void setStatdate(int statdate)
	{
		this.statdate=statdate;
		COLUMN_FLAG[23] = true;
	}
	public int getStatdate()
	{
		return statdate;
	}
	public void setUpdate_interval(int update_interval)
	{
		this.update_interval=update_interval;
		COLUMN_FLAG[24] = true;
	}
	public int getUpdate_interval()
	{
		return update_interval;
	}
}
