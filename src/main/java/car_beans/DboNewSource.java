package car_beans;
import java.util.*;

public class  DboNewSource  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//
	private String newseditor;//
	private String url;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setNewseditor(String newseditor)
	{
		this.newseditor=newseditor;
		COLUMN_FLAG[1] = true;
	}
	public String getNewseditor()
	{
		return newseditor;
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
}
