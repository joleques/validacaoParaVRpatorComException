package rs.com.teste.controller;

import java.util.ArrayList;
import java.util.List;

import rs.com.teste.model.ErrorValidacao;
import rs.com.teste.model.Validador;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

public class BaseController {

	private Validator validator;
	protected Result result;	
	

	public BaseController(Validator validator, Result result) {
		super();
		this.validator = validator;
		this.result = result;
	}


	protected void validar(Validador<?> validador) throws ValidadorException {
		try {
			validador.ehValido();
		} catch (ValidadorException e) {
			gerarValidacoes(validador.getMensagens());
			throw new ValidadorException();
		}
	}

	private void gerarValidacoes(List<ErrorValidacao> errorValidacao) {
		for (ErrorValidacao erro : errorValidacao) {
			validator.add(new ValidationMessage(erro.getMensagem(), erro.getTipo()));
			if(erro.getCampo() != null)
				appendToErrorFieldsList(erro);
		}
	}

	private void appendToErrorFieldsList(final ErrorValidacao errorField) {
		@SuppressWarnings("unchecked")
		List<ErrorValidacao> errorFieldsList = (ArrayList<ErrorValidacao>) result.included().get("errorFields");

		if (errorFieldsList == null) {
			errorFieldsList = new ArrayList<ErrorValidacao>();
			result.include("errorFields", errorFieldsList);
		}
		errorFieldsList.add(errorField);
	}
	
	@Deprecated
	private void appendToErrorFieldsList(final String errorField) {

		List<String> errorFieldsList = (ArrayList<String>) result.included().get("errorFields");

		if (errorFieldsList == null) {
			errorFieldsList = new ArrayList<String>();
			result.include("errorFields", errorFieldsList);
		}
		errorFieldsList.add(errorField);
	}
}
