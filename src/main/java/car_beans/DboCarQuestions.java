package car_beans;
import java.util.*;

public class  DboCarQuestions  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int serialid;//
	private int msgtype;//1-怎么样 2-油耗统计 3-缺点 4-优点 5-保养费用 6-颜色有几种
	private int isdelete;//
	private String nickname;//
	private Date addtime;//
	private int browses;//
	private String username;//
	private String formatqcontent;//
	private int answercount;//
	private Date answertime;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[1] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
	public void setMsgtype(int msgtype)
	{
		this.msgtype=msgtype;
		COLUMN_FLAG[2] = true;
	}
	public int getMsgtype()
	{
		return msgtype;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[3] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setNickname(String nickname)
	{
		this.nickname=nickname;
		COLUMN_FLAG[4] = true;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[5] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setBrowses(int browses)
	{
		this.browses=browses;
		COLUMN_FLAG[6] = true;
	}
	public int getBrowses()
	{
		return browses;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[7] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setFormatqcontent(String formatqcontent)
	{
		this.formatqcontent=formatqcontent;
		COLUMN_FLAG[8] = true;
	}
	public String getFormatqcontent()
	{
		return formatqcontent;
	}
	public void setAnswercount(int answercount)
	{
		this.answercount=answercount;
		COLUMN_FLAG[9] = true;
	}
	public int getAnswercount()
	{
		return answercount;
	}
	public void setAnswertime(Date answertime)
	{
		this.answertime=answertime;
		COLUMN_FLAG[10] = true;
	}
	public Date getAnswertime()
	{
		return answertime;
	}
}
