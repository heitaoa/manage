package car_beans;
import java.util.*;

public class  TbApplyDownloadDetail  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//
	private String userid;//�����û�id
	private Date appenddate;//���ʱ��
	private int count;//��������
	private String querysql;//����sql
	private String ip;//����ip
	private String hostip;//����ip
	private String hostname;//��������


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
	public void setAppenddate(Date appenddate)
	{
		this.appenddate=appenddate;
		COLUMN_FLAG[2] = true;
	}
	public Date getAppenddate()
	{
		return appenddate;
	}
	public void setCount(int count)
	{
		this.count=count;
		COLUMN_FLAG[3] = true;
	}
	public int getCount()
	{
		return count;
	}
	public void setQuerysql(String querysql)
	{
		this.querysql=querysql;
		COLUMN_FLAG[4] = true;
	}
	public String getQuerysql()
	{
		return querysql;
	}
	public void setIp(String ip)
	{
		this.ip=ip;
		COLUMN_FLAG[5] = true;
	}
	public String getIp()
	{
		return ip;
	}
	public void setHostip(String hostip)
	{
		this.hostip=hostip;
		COLUMN_FLAG[6] = true;
	}
	public String getHostip()
	{
		return hostip;
	}
	public void setHostname(String hostname)
	{
		this.hostname=hostname;
		COLUMN_FLAG[7] = true;
	}
	public String getHostname()
	{
		return hostname;
	}
}
