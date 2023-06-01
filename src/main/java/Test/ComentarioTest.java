/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Modelo.Dao.ComentarioDao;
import Modelo.Entity.Comentario;
import Modelo.Entity.Evento;
import Modelo.Entity.Tag;
import Modelo.Entity.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ComentarioTest {
    
    public static void main(String[] args) {
        ComentarioDao comentarioDao = new ComentarioDao();
        //List<Comentario> l = new ArrayList();
        Date birthday = new Date(2005, 7, 16);
        Tag tag = new Tag("Tag1", "TagPrueba");
        List<Evento> e = new ArrayList();
        String idPhoto = "idPhotoPrueba";
        Evento evento = new Evento("Evento1", "EventoPrueba", "Eventito de prueba", birthday, (List<Tag>) tag, idPhoto);
        e.add(evento);
        Usuario u = new Usuario("1152268", "Majo", "Password", birthday, "Ola me llamo Majo", e, tag, idPhoto);
        Comentario c = new Comentario("Comentario1", u, evento, 2.2, "Holaxd");
        comentarioDao.Insertar(c);
    
    }
}
