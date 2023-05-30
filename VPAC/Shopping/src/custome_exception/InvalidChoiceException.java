package custome_exception;

public class InvalidChoiceException extends Exception {
	String msg;
	
	public InvalidChoiceException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
}
