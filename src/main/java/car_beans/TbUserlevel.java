package car_beans;
import java.util.*;

public class  TbUserlevel  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//
	private String userid;//�û�id
	private String ulevel;//�û�Ȩ��  0-ϵͳ����Ա 1-��ͻ��ط���Ա  2-�ͷ� 3-����  4-��վ�༭ 5-��վ�༭  6-��վ����Ա


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[1] = true;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUlevel(String ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[2] = true;
	}
	public String getUlevel()
	{
		return ulevel;
	}
}
