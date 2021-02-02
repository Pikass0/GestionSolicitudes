/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.programia.info.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@Named(value = "proviciasBean")
@ViewScoped
public class proviciasBean implements Serializable{

    private String provincia;  
    private Map<String,String> provincias;
    
    @PostConstruct
    public void init() {
        provincias  = new HashMap<String, String>();
        provincias.put("Bizkaia", "Bizkaia");
        provincias.put("Madrid", "Madrid");
        provincias.put("Valencia", "Valencia");
        provincias.put("Asturias", "Asturias");
        provincias.put("Extremadura", "Extremadura");
        
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String country) {
        this.provincia = country;
    }


    public Map<String, String> getProvincias() {
        return provincias;
    }


    
    public void displayLocation() {
        FacesMessage msg;
        if(provincia != null)
            msg = new FacesMessage("Selected " + provincia);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "No ha seleccionado provincia"); 
            
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
}
