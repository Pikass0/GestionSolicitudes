/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.programia.info.web;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import es.programia.info.servicios.InteresadosService;
import java.io.Serializable;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@Named(value = "solicitudesMB")
@ViewScoped
public class GestionSolicitudesBean implements Serializable{

    private Interesado interesado;
    private String nombre;
    private String apellidos;
    private String empresa;
    private boolean visible = false;
    private boolean readOnly = true;
    
    @EJB
    private InteresadosService servicio;
    
    private static Logger log = Logger.getLogger("GestionSolicitudesBean");
    
    public GestionSolicitudesBean() {
        interesado = new Interesado();
    }

    
    
    
    public void buscar(){
        
        try {
            this.interesado = servicio.buscarInteresadoPorCriterio(nombre, apellidos, empresa);
            visible = true;
            
        } catch (GestionSolicitudesException ex) {
            Logger.getLogger(GestionSolicitudesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void grabar(){
        
        try {
            servicio.modificarInteresado(interesado);
        } catch (GestionSolicitudesException ex) {
            Logger.getLogger(GestionSolicitudesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void editar(){
        readOnly = !readOnly;
    }
    
    public void cancelar(){
        interesado = new Interesado();
        visible = !visible;
    }
    
    
    //GET SET-------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
    
    
    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
    
    
    
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
