package rs.com.teste.controller;

import rs.com.teste.model.Pessoa;
import rs.com.teste.model.ValidadorPessoa;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class ValidacaoController extends BaseController {


	public ValidacaoController(Result result, Validator validator) {
		super(validator, result);
	}

	@Get("/testeException")
	public void testeException(String nome, String cnpj) throws ValidadorException  {
		result.on(ValidadorException.class).forwardTo(this).gerouException();
		Pessoa joao = new Pessoa();
		joao.setCnpj(cnpj);
		joao.setNome(nome);
		validar(new ValidadorPessoa(joao));

		result.forwardTo(this).naoGerouException();
	}

	public void gerouException() {

	}

	public void naoGerouException() {

	}

}
