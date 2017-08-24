package helloworld;

import javax.transaction.Transactional;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.jboss.resteasy.util.HttpResponseCodes;

@Transactional
@Path("dao")
public class PessoaService extends PessoaDAO {
 	
	@POST
	@Path("persist")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa persiste(@Min(3) @QueryParam ("rg") Integer rg, @QueryParam ("nome") String nome) {
		Pessoa p = persisteDAO(rg, nome);
		return p;
	}
	
	@GET
	@Path("find")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa mostraRg(@QueryParam ("rg") Integer rg) {
		Pessoa p = mostraRgDAO(rg);
		return p;
	}
	
	@DELETE
	@Path("remove")
	public Response remover(@QueryParam ("rg") Integer rg) {
		removeDAO(rg);
		return Response.ok(HttpResponseCodes.SC_OK).build();
	}
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa alterar(@QueryParam ("rg") Integer rg, @QueryParam ("novoNome") String novoNome) {
		Pessoa p = alteraDAO(rg, novoNome);
		return p;
	}
	
	
}
