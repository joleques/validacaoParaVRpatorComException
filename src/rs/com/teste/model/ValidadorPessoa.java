package rs.com.teste.model;

import rs.com.teste.controller.ValidadorException;


public class ValidadorPessoa extends ValidadorGenericAbstract<Pessoa> {
	
	public ValidadorPessoa(Pessoa pessoa) {
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
