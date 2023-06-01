/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Comentario;
import Modelo.Entity.Evento;
import Modelo.Entity.Usuario;
import Red.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class ComentarioDao implements IComentario{

    String SQL_CONSULTAR = "SELECT * FROM comentario";
    String SQL_INSERTAR = "INSERT INTO comentario (id, user, event, score, content) VALUES (?,?,?,?,?)";
    String SQL_BORRAR = "DELETE FROM comentario WHERE id = ?";
    String SQL_CONSULTAID = "SELECT * FROM comentario WHERE id = ?";
    String SQL_UPDATE = "UPDATE comentario SET user = ?, event = ?, score = ?, content = ? WHERE id = ?";
    @Override
    public int Insertar(Comentario comentario) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setString(1, comentario.getId());
            sentencia.setObject(2, comentario.getUser());
            sentencia.setObject(3, comentario.getEvent());
            sentencia.setDouble(4, comentario.getScore());
            sentencia.setString(5, comentario.getContent());
            
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Comentario> consultar() {
    Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List <Comentario> comentarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                String id = resultado.getString("id");
                Usuario user = (Usuario) resultado.getObject("user");
                Evento event = (Evento) resultado.getObject("description");
                Double score = resultado.getDouble("score");
                String content = resultado.getString("content");
                Comentario comentario = new Comentario(id, user, event, score, content);
                comentarios.add(comentario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comentarios;
    }

    @Override
    public Comentario consultarID(Comentario comentario) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Comentario rComentario = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAID,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setString(1,comentario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
                Usuario user = (Usuario) resultado.getObject("user");
                Evento event = (Evento) resultado.getObject("event");
                Double score = resultado.getDouble("score");
                String content = resultado.getString("score");
                rComentario = new Comentario(content, user, event, score, content);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rComentario;
    }

    @Override
    public int borrar(Comentario comentario) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setString(1, comentario.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Comentario comentario) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_UPDATE);
            sentencia.setObject(1, comentario.getUser());
            sentencia.setObject(2, comentario.getEvent());
            sentencia.setDouble(3, comentario.getScore());
            sentencia.setString(4, comentario.getContent());
            sentencia.setString(5, comentario.getId());sentencia.setString(5, comentario.getContent());resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
}
