package hu.schonherz.training.java.language.exceptions;

public class MyException extends RuntimeException {

	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyException(String arg0) {
		super(arg0);
	}

	public MyException(Throwable arg0) {
		super(arg0);
	}

}
