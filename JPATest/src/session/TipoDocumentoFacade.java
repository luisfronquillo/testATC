package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TipoDocumento;

/**
 *
 * @author luis.f.ronquillo
 */
@Stateless
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> {

	

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }
    
}
