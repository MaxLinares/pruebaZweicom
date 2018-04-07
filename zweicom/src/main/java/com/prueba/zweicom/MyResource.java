package com.prueba.zweicom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

/**
 * Root resource (exposed at "calculoFibonacci" path)
 */
@Path("calculoFibonacci")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    /***
     * Metodo que retorna el valor de Fibonacci de N y N-1 que se ingresa por parametro.
     * @param in_value
     * @return
     */
    @GET
    @Path("/valor/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcularFibonacci(final @PathParam ("value") String in_value ) {
    	try {
    		Integer aux = calculo(Integer.parseInt(in_value));
    		return ("El valor de fibonacci de "+ in_value + " es :"+ aux + 
    				" y el "+ in_value +"-1: " + (aux-1));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.checkError();
			return "Error en el calculo de fibonacci al intentar un casteo"; 
		}
    }
    /***
     * Metodo que calcula el valor de Fibonacci que se ingresa por parametro.
     * @param init
     * @return
     */
    public int calculo (Integer init){
    	if (init <= 0) return 0;
    	if (init == 1) return 1;
    	if (init == 2) return 2;
    	return (calculo(init-1) + calculo(init-2));
    }
}
