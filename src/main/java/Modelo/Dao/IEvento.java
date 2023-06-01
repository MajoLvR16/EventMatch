/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Evento;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IEvento {
    public int Insertar (Evento evento);
    public List<Evento> consultar();
    public Evento consultarID(Evento evento);
    public int borrar(Evento evento);
    public int actualizar(Evento evento);
    
}
