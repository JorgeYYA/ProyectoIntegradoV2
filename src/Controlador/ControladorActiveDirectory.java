package Controlador;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ControladorActiveDirectory {

    private Hashtable<String, String> env;
    
    public ControladorActiveDirectory(String servidor, String usuario, String dominio, String password) {
        
        env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.PROVIDER_URL, servidor);
        
        //Rellenamos con el usuario/dominio y password
        env.put(Context.SECURITY_PRINCIPAL, usuario+"@"+dominio);
        env.put(Context.SECURITY_CREDENTIALS, password);
    }
    
    public boolean existeUsuario(){
        DirContext ctx;  
        try {
            //Autenticamos el usuario
            ctx = new InitialDirContext(env);
            System.out.println("El usuario se ha autenticado correctamente");
            ctx.close();
            return true;
        } catch (NamingException ex) {
            System.out.println("Ha habido un error en la autenticación: "+ex);
            return false;
        }
    }
}