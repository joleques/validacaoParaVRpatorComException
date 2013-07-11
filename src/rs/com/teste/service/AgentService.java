package rs.com.teste.service;

import br.com.caelum.vraptor.ioc.Component;
import rs.com.teste.bo.Observador;
import rs.com.teste.bo.ValidatorAgent;
import rs.com.teste.bo.ValidatorGenericAbstract;
import rs.com.teste.exception.ValidadorException;
import rs.com.teste.model.Agent;

@Component
public class AgentService {
	
	private ValidatorAgent validatorAgent;
	
	
	private AgentService(ValidatorAgent validatorAgent) {
		this.validatorAgent = validatorAgent;
	}
	
	public void addObservadoresDaValidacao(Observador observador){
		validatorAgent.addObservadoresDaValidacao(observador);
	}

	public void save(Agent agent) throws ValidadorException{
		validatorAgent.setObjetoAhSerValidado(agent);
		validatorAgent.ehValido();
		System.out.println("salvou agent");
	}

}
