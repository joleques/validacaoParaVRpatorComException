package rs.com.teste.bo;

import br.com.caelum.vraptor.ioc.Component;
import rs.com.teste.exception.ErrorValidacao;
import rs.com.teste.exception.ValidadorException;
import rs.com.teste.model.Agent;

@Component
public class ValidatorAgent extends ValidatorGenericAbstract<Agent> {

	public ValidatorAgent() {
		super();
	}

	public ValidatorAgent(Agent pessoa) {
		super(pessoa);
	}

	@Override
	public void validarRegrasNegocio() {
		validadorRegras();
	}

	private void validadorRegras() {
		if (possuiCnpj()) {
			if (objetoAhSerValidado.getCnpj().length() < 14)
				mensagens.add(new ErrorValidacao( "Tamanho minimo para o CNPJ é 14 caracteres", "Campo CNPJ"));
		}

		if (possuiNome()) {
			if (objetoAhSerValidado.getNome().length() < 10)
				mensagens.add(new ErrorValidacao( "Tamanho minimo para o nome é 10 caracteres", "Campo Nome"));
		}

	}

	private boolean possuiNome() {
		if (objetoAhSerValidado.getNome() == null) {
			mensagens.add(new ErrorValidacao("Nome é obrigatório", "Campo Nome"));
			return false;
		}
		return true;
	}

	private boolean possuiCnpj() {
		if (objetoAhSerValidado.getCnpj() == null) {
			mensagens.add(new ErrorValidacao("CNPJ é obrigatório", "Campo CNPJ"));
			return false;
		}
		return true;
	}

}
