package car_beans;
import java.util.*;

public class  TbApplyCount  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//1-��С����ȡ���� 2-����315��ȡ���� 3-���׳���ȡ���ݣ��Ź��� 4-���׳���ȡ���ݣ���� 5-����315��ȡ�ֻ��������� 9-��ȡsuncars���������������� 10-�����̷�����Ϣ��ʶλ
	private int max_dbid;//
	private int max_315id;//
	private Date last_update_time;//
	private int islock;//0-δ����  1-�Ѽ���  


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setMax_dbid(int max_dbid)
	{
		this.max_dbid=max_dbid;
		COLUMN_FLAG[1] = true;
	}
	public int getMax_dbid()
	{
		return max_dbid;
	}
	public void setMax_315id(int max_315id)
	{
		this.max_315id=max_315id;
		COLUMN_FLAG[2] = true;
	}
	public int getMax_315id()
	{
		return max_315id;
	}
	public void setLast_update_time(Date last_update_time)
	{
		this.last_update_time=last_update_time;
		COLUMN_FLAG[3] = true;
	}
	public Date getLast_update_time()
	{
		return last_update_time;
	}
	public void setIslock(int islock)
	{
		this.islock=islock;
		COLUMN_FLAG[4] = true;
	}
	public int getIslock()
	{
		return islock;
	}
}
