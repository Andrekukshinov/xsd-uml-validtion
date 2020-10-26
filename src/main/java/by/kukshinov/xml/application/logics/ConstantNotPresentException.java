package by.kukshinov.xml.application.logics;

public class ConstantNotPresentException extends RuntimeException {
    public ConstantNotPresentException() {
    }

    public ConstantNotPresentException(String message) {
	   super(message);
    }

    public ConstantNotPresentException(String message, Throwable cause) {
	   super(message, cause);
    }

    public ConstantNotPresentException(Throwable cause) {
	   super(cause);
    }

    public ConstantNotPresentException(
		  String message, Throwable cause, boolean enableSuppression,
		  boolean writableStackTrace) {
	   super(message, cause, enableSuppression, writableStackTrace);
    }
}
