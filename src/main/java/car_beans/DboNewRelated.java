package car_beans;
import java.util.*;

public class  DboNewRelated  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private int contentid;//��������id
	private String url;//�������ӵ�ַ
	private String title;//�������ű���


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setContentid(int contentid)
	{
		this.contentid=contentid;
		COLUMN_FLAG[1] = true;
	}
	public int getContentid()
	{
		return contentid;
	}
	public void setUrl(String url)
	{
		this.url=url;
		COLUMN_FLAG[2] = true;
	}
	public String getUrl()
	{
		return url;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[3] = true;
	}
	public String getTitle()
	{
		return title;
	}
}
