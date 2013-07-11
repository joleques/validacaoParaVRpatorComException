package rs.com.teste.bo;

import java.util.List;

import rs.com.teste.exception.ErrorValidacao;

public interface Observador {

	public void executar(List<ErrorValidacao> errorValidacao);
}
