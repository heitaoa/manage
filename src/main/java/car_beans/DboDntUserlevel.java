package car_beans;
import java.util.*;

public class  DboDntUserlevel  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int uid;//
	private int ulevel;//经销商后台{1|总经理；2|售前服务；3|售后服务}；车团后台{4|总站，所有可见；5|分站权限}；
	private int eid;//
	private int isdelete;//
	private int sub_sites_id;//分站权限


	public void setUid(int uid)
	{
		this.uid=uid;
		COLUMN_FLAG[0] = true;
	}
	public int getUid()
	{
		return uid;
	}
	public void setUlevel(int ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[1] = true;
	}
	public int getUlevel()
	{
		return ulevel;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[2] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[3] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setSub_sites_id(int sub_sites_id)
	{
		this.sub_sites_id=sub_sites_id;
		COLUMN_FLAG[4] = true;
	}
	public int getSub_sites_id()
	{
		return sub_sites_id;
	}
}
