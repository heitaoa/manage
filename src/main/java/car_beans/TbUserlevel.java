package car_beans;
import java.util.*;

public class  TbUserlevel  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//
	private String userid;//用户id
	private String ulevel;//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[1] = true;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUlevel(String ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[2] = true;
	}
	public String getUlevel()
	{
		return ulevel;
	}
}
