package car_beans;
import java.util.*;

public class  DboDntUserlevel  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int uid;//
	private int ulevel;//�����̺�̨{1|�ܾ���2|��ǰ����3|�ۺ����}�����ź�̨{4|��վ�����пɼ���5|��վȨ��}��
	private int eid;//
	private int isdelete;//
	private int sub_sites_id;//��վȨ��


	public void setUid(int uid)
	{
		this.uid=uid;
		COLUMN_FLAG[0] = true;
	}
	public int getUid()
	{
		return uid;
	}
	public void setUlevel(int ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[1] = true;
	}
	public int getUlevel()
	{
		return ulevel;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[2] = true;
	}
	public int getEid()
	{
		return eid;
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
	public void setSub_sites_id(int sub_sites_id)
	{
		this.sub_sites_id=sub_sites_id;
		COLUMN_FLAG[4] = true;
	}
	public int getSub_sites_id()
	{
		return sub_sites_id;
	}
}
