package car_beans;
import java.util.*;

public class  DboAdmFunction  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//�Զ�����id
	private String action;//��ת·��
	private String name;//���ܵ�����
	private int fatherid;//���ڵ�id
	private int isdelete;//�Ƿ�ɾ��״̬


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setAction(String action)
	{
		this.action=action;
		COLUMN_FLAG[1] = true;
	}
	public String getAction()
	{
		return action;
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
	public void setFatherid(int fatherid)
	{
		this.fatherid=fatherid;
		COLUMN_FLAG[3] = true;
	}
	public int getFatherid()
	{
		return fatherid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
}
