/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.programia.info.servicios;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class InteresadosServiceImpl implements InteresadosService{

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public Interesado buscarInteresadoPorCriterio(String nombre, String apellidos, String empresa) throws GestionSolicitudesException {
        Query query = em.createNamedQuery("Interesado.findByNombreApellidoEmpresa");
        if (nombre == null) {
            nombre = "%";
        }else{
            nombre = nombre.toLowerCase();
        }
        if (apellidos == null) {
            apellidos = "%";
        }else{
            apellidos = apellidos.toLowerCase();
        }
        if (empresa == null) {
            empresa = "%";
        }else{
            empresa = empresa.toLowerCase();
        }
        
        query.setParameter("nombre", nombre);
        query.setParameter("apellidos", apellidos);
        query.setParameter("empresa", empresa);
        
        
        query.setMaxResults(1);
        
        List<Interesado> interesados = query.getResultList();
        
        if (interesados == null || interesados.isEmpty()) {
            throw new GestionSolicitudesException("info_busqueda_no_resultados");
        }
        
        return interesados.get(0);

    }

    @Override
    public void crearNuevoInteresado(Interesado interesado) throws GestionSolicitudesException {
        
        em.persist(interesado);
        
    }

    @Override
    public void modificarInteresado(Interesado interesado) throws GestionSolicitudesException {
        
        try{
            Interesado interesadoAux = em.find(Interesado.class, interesado.getIdInteresado());
            em.merge(interesado);
            
        }catch(OptimisticLockException ole){
            throw new GestionSolicitudesException("La persona interesada actual ya"
                    + " ha sido modoficada por otra persona. Por favor, vuelva a recuperarlo.");
        }
        
        
    }
    
    
    
}
