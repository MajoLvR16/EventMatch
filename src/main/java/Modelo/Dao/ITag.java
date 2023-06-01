/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Tag;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ITag {
    public int Insertar (Tag tag);
    public List<Tag> consultar();
    public Tag consultarID(Tag tag);
    public int borrar(Tag tag);
    public int actualizar(Tag tag);
}
