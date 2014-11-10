package com.pucrs.prototipo.services.external;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pucrs.prototipo.core.Estado;
import com.pucrs.prototipo.services.internal.EstadosCidadesInternalService;

@Path("/estadosCidades")
public class EstadosCidadesExternalService {

    private EstadosCidadesInternalService service;

    public EstadosCidadesExternalService() {
	this.service = new EstadosCidadesInternalService();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Estado> getAllEstadosCidades() {
	return service.getAllEstadosCidades();
    }
}
