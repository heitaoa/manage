package car_beans;
import java.util.*;

public class  TbDataBaominglog  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int baomingid;//����id
	private String userid;//����
	private String username;//����
	private String operate_content;//��������
	private Date operate_time;//����ʱ��
	private String operate_state;//��������
	private int return_visit_state;//�ط�״̬ 0-δ�ط� 1-һ�� 2-���� 3-���� 4- ����
	private int phoneerror;//�绰�ܷ��ͨ  0-�ѽ�ͨ 1-δ��ͨ
	private int constacterror;//0-�ѹ�ͨ 1-δ��ͨ


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setBaomingid(int baomingid)
	{
		this.baomingid=baomingid;
		COLUMN_FLAG[1] = true;
	}
	public int getBaomingid()
	{
		return baomingid;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[2] = true;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[3] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setOperate_content(String operate_content)
	{
		this.operate_content=operate_content;
		COLUMN_FLAG[4] = true;
	}
	public String getOperate_content()
	{
		return operate_content;
	}
	public void setOperate_time(Date operate_time)
	{
		this.operate_time=operate_time;
		COLUMN_FLAG[5] = true;
	}
	public Date getOperate_time()
	{
		return operate_time;
	}
	public void setOperate_state(String operate_state)
	{
		this.operate_state=operate_state;
		COLUMN_FLAG[6] = true;
	}
	public String getOperate_state()
	{
		return operate_state;
	}
	public void setReturn_visit_state(int return_visit_state)
	{
		this.return_visit_state=return_visit_state;
		COLUMN_FLAG[7] = true;
	}
	public int getReturn_visit_state()
	{
		return return_visit_state;
	}
	public void setPhoneerror(int phoneerror)
	{
		this.phoneerror=phoneerror;
		COLUMN_FLAG[8] = true;
	}
	public int getPhoneerror()
	{
		return phoneerror;
	}
	public void setConstacterror(int constacterror)
	{
		this.constacterror=constacterror;
		COLUMN_FLAG[9] = true;
	}
	public int getConstacterror()
	{
		return constacterror;
	}
}
