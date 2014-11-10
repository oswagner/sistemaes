package com.pucrs.prototipo.services.external;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pucrs.prototipo.core.Solucao;
import com.pucrs.prototipo.services.internal.SolutionInternalService;

@Path("/solutions")
public class SolucoesExternalService {

    private SolutionInternalService service;

    public SolucoesExternalService() {
	this.service = new SolutionInternalService();
    }

    @POST
    @Path("/findSolutionsByProblems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Solucao> getSolutionByProblems(String value) {
	ArrayList<Long> ids = new ArrayList<>();
	String replaced = value.replace("[", "").replace("]", "");
	String[] splited = replaced.split(",");
	for (int i = 0; i < splited.length; i++) {
	    ids.add(Long.parseLong(splited[i].trim()));
	}

	ArrayList<Solucao> solutionsByProblems = service.getSolutionsByProblems(ids);
	

	return solutionsByProblems;
    }
}