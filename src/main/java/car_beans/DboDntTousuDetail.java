package car_beans;
import java.util.*;

public class  DboDntTousuDetail  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private int tousuid;//投诉表主键
	private String content;//回复内容
	private Date addtime;//添加时间


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setTousuid(int tousuid)
	{
		this.tousuid=tousuid;
		COLUMN_FLAG[1] = true;
	}
	public int getTousuid()
	{
		return tousuid;
	}
	public void setContent(String content)
	{
		this.content=content;
		COLUMN_FLAG[2] = true;
	}
	public String getContent()
	{
		return content;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[3] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
}
