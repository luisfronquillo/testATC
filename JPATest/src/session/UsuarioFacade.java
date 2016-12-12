package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

	
	@PersistenceContext(unitName = "JPATest")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
	public UsuarioFacade() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	public void retriveTableId(){
		
		em.flush();
		
	}
	
	

}
