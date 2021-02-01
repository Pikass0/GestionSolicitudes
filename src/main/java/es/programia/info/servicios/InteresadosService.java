/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.programia.info.servicios;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
public interface InteresadosService {
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Interesado buscarInteresadoPorCriterio(String nombre, String apellidos, String empresa) throws GestionSolicitudesException;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearNuevoInteresado(Interesado interesado) throws GestionSolicitudesException;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarInteresado(Interesado interesado) throws GestionSolicitudesException;
    
    
}
