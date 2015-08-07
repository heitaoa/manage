package car_beans;
import java.util.*;

public class  DboNewPublishtime  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false};
	private int id;//新闻id
	private Date publishtime;//发布时间


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setPublishtime(Date publishtime)
	{
		this.publishtime=publishtime;
		COLUMN_FLAG[1] = true;
	}
	public Date getPublishtime()
	{
		return publishtime;
	}
}
