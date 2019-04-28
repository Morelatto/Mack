package mack.lp3.ejb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mack.lp3.entidades.Ordem;

/**
 *
 * @author Pedro Morelatto
 */
@Singleton
@Startup
public class OrdemBean {

    private List<Ordem> lista;

    public Ordem getOrdemById(int id) {
        Ordem ordem = new Ordem();
        for (Ordem o : lista) {
            if (o.getIdOrdem() == id) {
                ordem = o;
            }
        }
        return ordem;
    }

    @PostConstruct
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Entidade-RSPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        lista = em.createNamedQuery("Ordem.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
    }

}
