package com.pucrs.prototipo.services.external;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.pucrs.prototipo.core.Empresa;
import com.pucrs.prototipo.services.internal.EmpresaInternalService;

@Path("/enterprise")
public class EmpresaExternalService {

    EmpresaInternalService service;

    public EmpresaExternalService() {
	this.service = new EmpresaInternalService();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int cadastraEmpresa(String msg) {

	int id = 0;
	ObjectMapper mapper = new ObjectMapper();
	try {
	    Empresa e = mapper.readValue(msg, Empresa.class);
	    id = service.cadastraEmpresa(e);

	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return id;
    }

    @POST
    @Path("/findEnterprise")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Empresa getEmpresa(String id) {
	System.out.println("ID == = = = = = = = ==  "+id);
	Empresa empresa = service.findEmpresaById(Long.parseLong(id));
	return empresa;
    }
}
