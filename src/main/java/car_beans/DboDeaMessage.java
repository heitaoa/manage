package car_beans;
import java.util.*;

public class  DboDeaMessage  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false};
	private int id;//
	private String question;//
	private Date adddate;//
	private int eid;//
	private String answer;//
	private int isdelete;//
	private Date answerdate;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setQuestion(String question)
	{
		this.question=question;
		COLUMN_FLAG[1] = true;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[2] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[3] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
		COLUMN_FLAG[4] = true;
	}
	public String getAnswer()
	{
		return answer;
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
	public void setAnswerdate(Date answerdate)
	{
		this.answerdate=answerdate;
		COLUMN_FLAG[6] = true;
	}
	public Date getAnswerdate()
	{
		return answerdate;
	}
}
