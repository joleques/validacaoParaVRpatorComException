package rs.com.teste.controller;

import rs.com.teste.bo.ValidatorAgent;
import rs.com.teste.exception.ValidadorException;
import rs.com.teste.model.Agent;
import rs.com.teste.service.AgentService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class AgentController extends BaseController {


	private final AgentService service;

	public AgentController(Result result, Validator validator, AgentService service) {
		super(validator, result);
		this.service = service;
	}
	

	@Get("/agent/save")
	public void save(String nome, String cnpj) throws ValidadorException  {
		result.on(ValidadorException.class).forwardTo(this).form();
		
		Agent joao = new Agent(cnpj,nome);
		
		validar(new ValidatorAgent(joao));
		
		service.save(joao);

		result.forwardTo(this).list();
	}
	
	public void form() {

	}

	public void list() {

	}

}
