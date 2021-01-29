
package es.programia.info.excepciones;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class GestionSolicitudesException extends Exception {

    private String[] params;
    
    public GestionSolicitudesException(String msg, String ... params) {
        super(msg);
        
        if (params != null) {
            this.params = params;
        }
        
    }
    
    
    public GestionSolicitudesException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public String[] getParams() {
        return params;
    }
    
    
    
    
}
