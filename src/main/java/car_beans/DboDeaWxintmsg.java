package car_beans;
import java.util.*;

public class  DboDeaWxintmsg  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private String keyword;//
	private String msg_type;//�ظ����ͣ�1:���֣�2��ͼ��
	private String msg_content;//�ظ�����
	private Date adddate;//


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
	public void setKeyword(String keyword)
	{
		this.keyword=keyword;
		COLUMN_FLAG[2] = true;
	}
	public String getKeyword()
	{
		return keyword;
	}
	public void setMsg_type(String msg_type)
	{
		this.msg_type=msg_type;
		COLUMN_FLAG[3] = true;
	}
	public String getMsg_type()
	{
		return msg_type;
	}
	public void setMsg_content(String msg_content)
	{
		this.msg_content=msg_content;
		COLUMN_FLAG[4] = true;
	}
	public String getMsg_content()
	{
		return msg_content;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[5] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
}
