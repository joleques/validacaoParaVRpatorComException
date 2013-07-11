package rs.com.teste.bo;

import java.util.ArrayList;
import java.util.List;

import rs.com.teste.exception.ErrorValidacao;
import rs.com.teste.exception.ValidadorException;

public abstract class ValidatorGenericAbstract<T extends Object> implements Validador<T>,Observavel {

	protected T objetoAhSerValidado;
	protected List<ErrorValidacao> mensagens;
	protected List<Observador> listaOberservadores;
	
	public ValidatorGenericAbstract(T objetoAhSerValidado) {
		this.objetoAhSerValidado = objetoAhSerValidado;
		this.mensagens = new ArrayList<ErrorValidacao>();
		this.listaOberservadores = new ArrayList<Observador>();
	}
	public ValidatorGenericAbstract() {
		this.mensagens = new ArrayList<ErrorValidacao>();
		this.listaOberservadores = new ArrayList<Observador>();
	}

	public void ehValido() throws ValidadorException {
		validarRegrasNegocio();		
		temErro();
	}
	
	protected void temErro() throws ValidadorException{
		if(this.mensagens.size() > 0){
			this.notificarObservadores(this.mensagens);
			throw new ValidadorException();
		}
	}
	

	public List<ErrorValidacao> getMensagens() {
		return this.mensagens;
	}
	

	protected T getObjetoAhSerValidado() {
		return objetoAhSerValidado;
	}
	
	public void setObjetoAhSerValidado(T objetoAhSerValidado) {
		this.objetoAhSerValidado = objetoAhSerValidado;
	}


	public void notificarObservadores(List<ErrorValidacao> errorValidacao) {
		for (Observador observador : listaOberservadores) {
			observador.executar(errorValidacao);
		}
	}

	public void addObservadoresDaValidacao(Observador observador) {
		listaOberservadores.add(observador);
	}

	public abstract void validarRegrasNegocio();
	
}
