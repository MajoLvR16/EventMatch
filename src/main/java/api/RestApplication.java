/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Acer
 */
@ApplicationPath("/api")
public class RestApplication extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilter.class);
        classes.add(UsuarioResource.class);
        classes.add(EventoResource.class);
        classes.add(ComentarioResource.class);
        classes.add(TagResource.class);
        // Agrega aquí tus clases de recursos (endpoints) adicionales
        return classes;
    }

}
