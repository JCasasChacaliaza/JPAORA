/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entidad.Persona;

/**
 *
 * @author Usuario
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "PerVentaUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    //utilizar nameQuery para el usuario de logeo
    public Persona encotrarUsuario(String usua) {
        Query q=em.createNamedQuery("Persona.findByIdper", Persona.class).setParameter("idper", usua);
        
        List <Persona> listado=q.getResultList();
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        return null;
    }
}
