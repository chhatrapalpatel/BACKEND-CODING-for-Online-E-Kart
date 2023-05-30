package custome_exception;

public class ValueNotMatchingException extends Exception
{
	String msg;
	public ValueNotMatchingException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String getMessage()
	{
		return msg;
	}
}
