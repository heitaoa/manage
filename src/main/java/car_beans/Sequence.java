package car_beans;
import java.util.*;

public class  Sequence  implements java.io.Serializable{

	public String KEY = "seq_name";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private String seq_name;//
	private int current_value;//
	private int increment;//


	public void setSeq_name(String seq_name)
	{
		this.seq_name=seq_name;
		COLUMN_FLAG[0] = true;
	}
	public String getSeq_name()
	{
		return seq_name;
	}
	public void setCurrent_value(int current_value)
	{
		this.current_value=current_value;
		COLUMN_FLAG[1] = true;
	}
	public int getCurrent_value()
	{
		return current_value;
	}
	public void setIncrement(int increment)
	{
		this.increment=increment;
		COLUMN_FLAG[2] = true;
	}
	public int getIncrement()
	{
		return increment;
	}
}
