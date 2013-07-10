package rs.com.teste.service;

import br.com.caelum.vraptor.ioc.Component;
import rs.com.teste.model.Agent;

@Component
public class AgentService {
	
	
	public void save(Agent agent){
		System.out.println("salvou agent");
	}

}
