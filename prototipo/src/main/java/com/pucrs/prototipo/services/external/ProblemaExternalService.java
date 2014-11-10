package com.pucrs.prototipo.services.external;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pucrs.prototipo.core.Problema;
import com.pucrs.prototipo.services.internal.ProblemaInternalService;

@Path("/problems")
public class ProblemaExternalService {

    private ProblemaInternalService service;

    public ProblemaExternalService() {
	this.service = new ProblemaInternalService();
    }

    @GET
    @Path("/findAllProblems")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Problema> getAllProblems() {
	ArrayList<Problema> allProblems = service.getAllProblems();
	return allProblems;
    }

    @POST
    @Path("/resgisterProblemsToEnterprise/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerProblemsToEnterprise(String id) {

    }

}
