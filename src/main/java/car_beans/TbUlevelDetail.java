package car_beans;
import java.util.*;

public class  TbUlevelDetail  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false};
	private int level;//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员
	private String functionid;//


	public void setLevel(int level)
	{
		this.level=level;
		COLUMN_FLAG[0] = true;
	}
	public int getLevel()
	{
		return level;
	}
	public void setFunctionid(String functionid)
	{
		this.functionid=functionid;
		COLUMN_FLAG[1] = true;
	}
	public String getFunctionid()
	{
		return functionid;
	}
}
