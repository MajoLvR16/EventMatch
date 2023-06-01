/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Modelo.Dao.EventoDao;
import Modelo.Entity.Evento;
import Modelo.Entity.Tag;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class EventoTest {
    public static void main(String[] args) {
        EventoDao eventoDao = new EventoDao();
        Tag musica = new Tag("1", "musica");
        Tag fiesta = new Tag("2", "fiesta");
        List<Tag> tagList = new ArrayList<>(); //Inicializar
        tagList.add(fiesta);
        tagList.add(musica);
        
        Date fechaStereo = new Date(123,19,8);
        
        Evento uno = new Evento("1", "StereoPicnic", "ZZZZZ", fechaStereo, tagList, "sss");
        System.out.println("Resultado al insertar: " + eventoDao.Insertar(uno));
        System.out.println(eventoDao.consultarID(uno).toString());
        
        List<Evento> e;
        e = eventoDao.consultar();
        for(Evento evento : e){
            System.out.println(evento.toString());
            System.out.println("Nombre: " + evento.getEventName());  
        }
        Evento eventoActualizado = new Evento("1", "Tomorrowland", "ZZZZZ", fechaStereo, tagList, "eee");
        System.out.println("Resultado al actualizar: " + eventoDao.actualizar(eventoActualizado));
        System.out.println(eventoDao.consultarID(eventoActualizado).toString());
    }
}