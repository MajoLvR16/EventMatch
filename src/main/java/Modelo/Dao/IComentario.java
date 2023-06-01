/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Comentario;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IComentario {
    public int Insertar (Comentario comentario);
    public List<Comentario> consultar();
    public Comentario consultarID(Comentario comentario);
    public int borrar(Comentario comentario);
    public int actualizar(Comentario comentario);
}
