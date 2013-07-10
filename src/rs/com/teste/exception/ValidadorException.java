package rs.com.teste.exception;


public class ValidadorException extends Exception {

	private ErrorValidacao error;

	public ValidadorException(ErrorValidacao error) {
		super(error.getMensagem());
		this.error = error;
	}

	public ValidadorException() {

	}

	public ErrorValidacao getError() {
		return error;
	}
	
	

}
