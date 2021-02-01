/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.programia.info.web;

import es.programia.info.entidades.Interesado;
import es.programia.info.servicios.InteresadosService;

import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author user
 */
@Named(value = "solicitudesMB")
@RequestScoped
public class GestionSolicitudesBean {

    private Interesado interesado;
    private boolean visible = true;
    
    @EJB
    private InteresadosService servicio;
    
    private static Logger log = Logger.getLogger("GestionSolicitudesBean");
    
    public GestionSolicitudesBean() {
        interesado = new Interesado();
    }

    
    
    
    public void buscar(){
        
    }
    
    
    //GET SET-------------
    
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }
    

    
}
