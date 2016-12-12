/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.DatosViajero;

/**
 *
 * @author luis.f.ronquillo
 */
@Stateless
public class DatosViajeroFacade extends AbstractFacade<DatosViajero> {

    @PersistenceContext(unitName = "JPATest")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosViajeroFacade() {
        super(DatosViajero.class);
    }
    
}
