package helloworld;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.HttpResponseCodes;
 
@Path("necessario")
public class Hello {
	
	private static HashMap<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
	private static int cont = 0;
	
	public int aumentaCont(int cont) {
		cont = cont + 1;
		return cont;
	}

	
	@GET
	@Path("/teste/{param}")
	public Response imprimirMessage(@PathParam("param") String mje) {
		String salida = "Hola desde un Restful Web Service: " + mje;
		return Response.status(200).entity(salida).build();
	}
	
	@Path("/oi")
	@POST
	public Response imprimeOla (@QueryParam("nome") String nome) {
		return Response.status(200).entity(nome).build();
	}
	
	@GET
	@Path("/echo")
	public Response getEchoMsg(@QueryParam("message") String msg) {
		return Response.ok("Sua mensagem foi: " + msg).build();
	}
	
	@GET
	@Path("/objeto")
	@Produces(MediaType.APPLICATION_XML)
	public Pessoa getPessoa() {
		return new Pessoa(0,"Jully Anne");
		
	}
	
	@GET  
	@Path("pessoas")  
	@Produces(MediaType.APPLICATION_XML)  
	public List<Pessoa> todasPessoas(){  
	    try {  
	        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	        pessoas.add(new Pessoa (0, "Jully"));
	        pessoas.add(new Pessoa(1, "Patrick"));
	        pessoas.add(new Pessoa(2, "Daniel"));
	        pessoas.add(new Pessoa (3, "Bruno"));
	          
	        return pessoas;  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }  
	}  
	
	@POST
	@Path("adicionaPessoa")
	public Response adicionaPessoa(@QueryParam("rg") Integer rg, @QueryParam("nome") String nome) {
		pessoas.put(cont, new Pessoa(rg, nome));
		cont = aumentaCont(cont);
		return Response.status(HttpResponseCodes.SC_CREATED).entity(pessoas.toString()).build();
	}
	
	@GET
	@Path("valorCont")
	public Response retornaCont() {
		return Response.status(HttpResponseCodes.SC_OK).entity(cont).build();
	}
	
	@GET
	@Path("mostraPessoas")
	@Produces(MediaType.APPLICATION_XML)
	public HashMap<Integer, Pessoa> mostraPessoas() {
		return pessoas;
	}

}
