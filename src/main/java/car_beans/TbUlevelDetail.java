package car_beans;
import java.util.*;

public class  TbUlevelDetail  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false};
	private int level;//�û�Ȩ��  0-ϵͳ����Ա 1-��ͻ��ط���Ա  2-�ͷ� 3-����  4-��վ�༭ 5-��վ�༭  6-��վ����Ա
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
