package rs.com.teste.bo;

import rs.com.teste.exception.ErrorValidacao;
import rs.com.teste.exception.ValidadorException;
import rs.com.teste.model.Agent;


public class ValidatorAgent extends ValidatorGenericAbstract<Agent> {
	
	public ValidatorAgent(Agent pessoa) {
		super(pessoa);
	}

	@Override
	public void validarRegrasNegocio() {
		try {
			validadorObrigatorio();
			validadorRegras();
		} catch (ValidadorException e) {
			
		}
	}

	public void validarAPI() throws ValidadorException{
		validaAPI();
		temErro();
	}
	
	private void validaAPI() {
		// TODO Auto-generated method stub
		
	}

	private void validadorRegras() {
		if(objetoAhSerValidado.getNome().length() < 10)
			mensagens.add(new ErrorValidacao("Tamanho minimo para o nome é 10 caracteres","Campo Nome"));
		
		if(objetoAhSerValidado.getCnpj().length() < 14)
			mensagens.add(new ErrorValidacao("Tamanho minimo para o CNPJ é 14 caracteres","Campo CNPJ"));
	}

	private void validadorObrigatorio() throws ValidadorException {
		if(objetoAhSerValidado.getCnpj() == null)
			mensagens.add(new ErrorValidacao("CNPJ é obrigatório","Campo CNPJ"));
		
		if(objetoAhSerValidado.getNome() == null)
			mensagens.add(new ErrorValidacao("Nome é obrigatório","Campo Nome"));
		
		temErro();
	}

}
