package car_beans;
import java.util.*;

public class  DboPubSubject  implements java.io.Serializable{

	public String KEY = "subjectid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int subjectid;//专题id
	private String subjectname;//专题名称
	private String subjecttype;//专题类型
	private Date subjectdate;//专题建立时间
	private String subjecturl;//专题链接


	public void setSubjectid(int subjectid)
	{
		this.subjectid=subjectid;
		COLUMN_FLAG[0] = true;
	}
	public int getSubjectid()
	{
		return subjectid;
	}
	public void setSubjectname(String subjectname)
	{
		this.subjectname=subjectname;
		COLUMN_FLAG[1] = true;
	}
	public String getSubjectname()
	{
		return subjectname;
	}
	public void setSubjecttype(String subjecttype)
	{
		this.subjecttype=subjecttype;
		COLUMN_FLAG[2] = true;
	}
	public String getSubjecttype()
	{
		return subjecttype;
	}
	public void setSubjectdate(Date subjectdate)
	{
		this.subjectdate=subjectdate;
		COLUMN_FLAG[3] = true;
	}
	public Date getSubjectdate()
	{
		return subjectdate;
	}
	public void setSubjecturl(String subjecturl)
	{
		this.subjecturl=subjecturl;
		COLUMN_FLAG[4] = true;
	}
	public String getSubjecturl()
	{
		return subjecturl;
	}
}
