package car_beans;
import java.util.*;

public class  TbLinks  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private String title;//����
	private String link;//����
	private String place;//����λ�� index_1
	private Date addtime;//���ʱ��
	private int isdelete;//0-δɾ��  1-��ɾ��


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[1] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setLink(String link)
	{
		this.link=link;
		COLUMN_FLAG[2] = true;
	}
	public String getLink()
	{
		return link;
	}
	public void setPlace(String place)
	{
		this.place=place;
		COLUMN_FLAG[3] = true;
	}
	public String getPlace()
	{
		return place;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[4] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[5] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
}
