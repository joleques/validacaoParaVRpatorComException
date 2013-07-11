package rs.com.teste.bo;

import java.util.List;

import rs.com.teste.exception.ErrorValidacao;

public interface Observavel {

	public void notificarObservadores(List<ErrorValidacao> errorValidacao);
	
	public void addObservadoresDaValidacao(Observador observador);
	
}
