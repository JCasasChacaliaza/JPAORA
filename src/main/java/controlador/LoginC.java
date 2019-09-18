package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import modelo.dao.PersonaFacade;


@Named(value = "loginC")
@SessionScoped
public class LoginC implements Serializable {

    private String nombreUsuario;
    private String contrUsuario;
    
    @EJB
    private PersonaFacade uduFacade;
    public LoginC() {
    }

    public String autenticar(){
        return "ingresar";
    }       
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrUsuario() {
        return contrUsuario;
    }

    public void setContrUsuario(String contrUsuario) {
        this.contrUsuario = contrUsuario;
    }
    
    
}
