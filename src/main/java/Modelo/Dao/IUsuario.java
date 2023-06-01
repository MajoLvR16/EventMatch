/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Usuario;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IUsuario {
    public int Insertar (Usuario usuario);
    public List<Usuario> consultar();
    public Usuario consultarID(Usuario usuario);
    public int borrar(Usuario usuario);
    public int actualizar(Usuario usuario);

}
