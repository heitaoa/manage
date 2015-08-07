package car_beans;
import java.util.*;

public class  TbApplyDetail  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private int uid;//操作者id
	private int applyid;//报名表id
	private int type;//操作类型  0 -恢复 1-删除
	private String remark;//备注
	private Date addtime;//


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
	public void setApplyid(int applyid)
	{
		this.applyid=applyid;
		COLUMN_FLAG[2] = true;
	}
	public int getApplyid()
	{
		return applyid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[3] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setRemark(String remark)
	{
		this.remark=remark;
		COLUMN_FLAG[4] = true;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[5] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
}
