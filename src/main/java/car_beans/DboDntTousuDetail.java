package car_beans;
import java.util.*;

public class  DboDntTousuDetail  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private int tousuid;//Ͷ�߱�����
	private String content;//�ظ�����
	private Date addtime;//���ʱ��


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
