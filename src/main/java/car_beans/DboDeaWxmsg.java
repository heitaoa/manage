package car_beans;
import java.util.*;

public class  DboDeaWxmsg  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String msg_content;//
	private String msg_type;//
	private String msg_srl;//
	private String change_time;//
	private int msg_status;//
	private int retry_num;//
	private int eid;//
	private Date adddate;//
	private int newsid;//对应dea_news的id
	private String newscontent;//
	private String title;//新闻标题
	private int from_type;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setMsg_content(String msg_content)
	{
		this.msg_content=msg_content;
		COLUMN_FLAG[1] = true;
	}
	public String getMsg_content()
	{
		return msg_content;
	}
	public void setMsg_type(String msg_type)
	{
		this.msg_type=msg_type;
		COLUMN_FLAG[2] = true;
	}
	public String getMsg_type()
	{
		return msg_type;
	}
	public void setMsg_srl(String msg_srl)
	{
		this.msg_srl=msg_srl;
		COLUMN_FLAG[3] = true;
	}
	public String getMsg_srl()
	{
		return msg_srl;
	}
	public void setChange_time(String change_time)
	{
		this.change_time=change_time;
		COLUMN_FLAG[4] = true;
	}
	public String getChange_time()
	{
		return change_time;
	}
	public void setMsg_status(int msg_status)
	{
		this.msg_status=msg_status;
		COLUMN_FLAG[5] = true;
	}
	public int getMsg_status()
	{
		return msg_status;
	}
	public void setRetry_num(int retry_num)
	{
		this.retry_num=retry_num;
		COLUMN_FLAG[6] = true;
	}
	public int getRetry_num()
	{
		return retry_num;
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
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[8] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setNewsid(int newsid)
	{
		this.newsid=newsid;
		COLUMN_FLAG[9] = true;
	}
	public int getNewsid()
	{
		return newsid;
	}
	public void setNewscontent(String newscontent)
	{
		this.newscontent=newscontent;
		COLUMN_FLAG[10] = true;
	}
	public String getNewscontent()
	{
		return newscontent;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[11] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setFrom_type(int from_type)
	{
		this.from_type=from_type;
		COLUMN_FLAG[12] = true;
	}
	public int getFrom_type()
	{
		return from_type;
	}
}
