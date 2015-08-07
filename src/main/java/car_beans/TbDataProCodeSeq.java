package car_beans;
import java.util.*;

public class  TbDataProCodeSeq  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false};
	private String head;//
	private int code;//


	public void setHead(String head)
	{
		this.head=head;
		COLUMN_FLAG[0] = true;
	}
	public String getHead()
	{
		return head;
	}
	public void setCode(int code)
	{
		this.code=code;
		COLUMN_FLAG[1] = true;
	}
	public int getCode()
	{
		return code;
	}
}
