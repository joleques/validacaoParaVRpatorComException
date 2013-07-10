package rs.com.teste.bo;

import java.util.ArrayList;
import java.util.List;

import rs.com.teste.exception.ErrorValidacao;
import rs.com.teste.exception.ValidadorException;

public abstract class ValidatorGenericAbstract<T extends Object> implements Validador<T> {

	protected T objetoAhSerValidado;
	protected List<ErrorValidacao> mensagens;
	
	public ValidatorGenericAbstract(T objetoAhSerValidado) {
		this.objetoAhSerValidado = objetoAhSerValidado;
		this.mensagens = new ArrayList<ErrorValidacao>();
	}

	public void ehValido() throws ValidadorException {
		validarRegrasNegocio();		
		temErro();
	}
	
	protected void temErro() throws ValidadorException{
		if(this.mensagens.size() > 0)
			throw new ValidadorException();  
	}
	

	public List<ErrorValidacao> getMensagens() {
		return this.mensagens;
	}
	

	protected T getObjetoAhSerValidado() {
		return objetoAhSerValidado;
	}

	public abstract void validarRegrasNegocio();
	
}
