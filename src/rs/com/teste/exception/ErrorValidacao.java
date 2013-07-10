package rs.com.teste.exception;

public class ErrorValidacao {
	
	private static final String ERROR = "ERROR";

	private String mensagem;
	
	private String campo;
	
	private String tipo;

	
	
	public ErrorValidacao(String mensagem, String campo) {
		super();
		this.mensagem = mensagem;
		this.campo = campo;
		this.tipo = ERROR;
	}

	public ErrorValidacao(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
