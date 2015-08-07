package car_beans;
import java.util.*;

public class  TbSequence  implements java.io.Serializable{

	public String KEY = "name";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private String name;//
	private int current_value;//
	private int _increment;//


	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[0] = true;
	}
	public String getName()
	{
		return name;
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
	public void set_increment(int _increment)
	{
		this._increment=_increment;
		COLUMN_FLAG[2] = true;
	}
	public int get_increment()
	{
		return _increment;
	}
}
