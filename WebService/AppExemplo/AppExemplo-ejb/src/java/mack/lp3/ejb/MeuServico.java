package mack.lp3.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mack.lp3.entidades.Ordem;

/**
 *
 * @author Pedro Morelatto
 */
@Path("servico")
@Stateless
public class MeuServico {

    @EJB
    OrdemBean meuBean;

    @GET
    @Produces("application/xml")
    public Ordem processGet() {
        return meuBean.getOrdemById(1);
    }

    @Path("/ordem/{ordem-id}")
    @GET
    @Produces("application/xml")
    public Ordem getOrder(@PathParam("ordem-id") int id) {
        return meuBean.getOrdemById(id);
    }

    @Path("/submissaoOrdem")
    @POST
    @Consumes(MediaType.TEXT_XML)
    public void submitOrder(String ordemXml) {
        System.out.println("POSTPOST");
        System.out.println(ordemXml);
    }

    @POST
    @Path("/ordemPost")
    @Produces("application/xml")
    public Ordem processPost() {
        return meuBean.getOrdemById(1);
    }

}
