package rs.com.teste.model;

import java.util.List;

import rs.com.teste.controller.ValidadorException;

public interface Validador<T> {

	public void ehValido() throws ValidadorException;

	public abstract void validarRegrasNegocio();

	public List<ErrorValidacao> getMensagens();
}
