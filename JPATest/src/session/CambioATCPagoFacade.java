/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.CambioATCPago;

/**
 *
 * @author luis.f.ronquillo
 */
@Stateless
public class CambioATCPagoFacade extends AbstractFacade<CambioATCPago> {

    @PersistenceContext(unitName = "JPATest")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CambioATCPagoFacade() {
        super(CambioATCPago.class);
    }
    
}
