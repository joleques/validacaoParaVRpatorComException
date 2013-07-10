package rs.com.teste.bo;

import java.util.List;

import rs.com.teste.exception.ErrorValidacao;
import rs.com.teste.exception.ValidadorException;

public interface Validador<T> {

	public void ehValido() throws ValidadorException;

	public abstract void validarRegrasNegocio();

	public List<ErrorValidacao> getMensagens();
}
