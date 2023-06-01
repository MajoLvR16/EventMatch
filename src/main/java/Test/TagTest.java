/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Modelo.Dao.TagDao;
import Modelo.Entity.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TagTest {
    public static void main(String[] args){
    TagDao tagDao = new TagDao();
    Tag rock = new Tag("1", "rock");
    System.out.println("Resultado al insertar: " + tagDao.Insertar(rock));
    //System.out.println("Resultado al borrar:" + tagDao.borrar(rock));
    
    System.out.println(tagDao.consultarID(rock).toString());
    
    Tag pop = new Tag("2", "pop");
    System.out.println("Resultado al insertar: " + tagDao.Insertar(pop));
    
    List <Tag> m;
    m = tagDao.consultar();
        for(Tag tag : m){
            System.out.println(tag.toString()); //Este lo añadí yo
            System.out.println("nombre: " + tag.getName());
        }
        
    Tag rockActualizado = new Tag("1", "rock n'roll");
        System.out.println("Resultado al actualizar: " + tagDao.actualizar(rockActualizado));
        System.out.println(tagDao.consultarID(rockActualizado).toString());
    }
}
