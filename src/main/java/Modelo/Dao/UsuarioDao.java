/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Evento;
import Modelo.Entity.Tag;
import Modelo.Entity.Usuario;
import Red.BaseDatos;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class UsuarioDao implements IUsuario{
    
    String SQL_CONSULTAR = "SELECT * FROM usuario";
    String SQL_INSERTAR = "INSERT INTO usuario (id, username, password, birthday, description, latestEvents, tagList, idPhoto) VALUES (?,?,?,?,?,?,?,?)";
    String SQL_BORRAR = "DELETE FROM usuario WHERE id = ?";
    String SQL_CONSULTAID = "SELECT * FROM usuario WHERE id = ?";
    String SQL_UPDATE = "UPDATE usuario SET username = ?, password = ?, birthday = ?, description = ?, latestEvents = ?, tagList = ?, idPhoto = ? WHERE id = ?";
    //comando sql
    //palabras claves mayúscula
    //sql no diferencia entre mayúscula y minúscula
    @Override
    public int Insertar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setString(1, usuario.getId());
            sentencia.setString(2, usuario.getUsername());
            sentencia.setString(3, usuario.getPassword());
            sentencia.setDate(4, usuario.getBirthday());
            sentencia.setString(5, usuario.getDescription());
            sentencia.setArray(6, (Array) usuario.getLatestEvents());
            sentencia.setObject(7, usuario.getTagList());
            sentencia.setString(8, usuario.getIdPhoto());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Usuario> consultar() {
        
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List <Usuario> usuarios = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                String id = resultado.getString("id");
                String username = resultado.getString("username");
                String password = resultado.getString("password");
                Date birthday = resultado.getDate("birthday");
                String description = resultado.getString("description");
                List <Evento> latestEvents = (List <Evento>) resultado.getArray("latestEvents");
                Tag tagList = (Tag) resultado.getObject("tagList");
                String idPhoto = resultado.getString("idPhoto");
                Usuario usuario = new Usuario(id, username, password, birthday, description, latestEvents, tagList, idPhoto);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }
    @Override
    public Usuario consultarID(Usuario usuario) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Usuario rUsuario = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAID,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setString(1,usuario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
                String username = resultado.getString("username");
                String password = resultado.getString("password");
                Date birthday = resultado.getDate("birthday");
                String description = resultado.getString("description");
                List <Evento> latestEvents = (List <Evento>) resultado.getArray("latestEvents");
                Tag tagList = (Tag) resultado.getObject("tagList");
                String idPhoto = resultado.getString("idPhoto");
                rUsuario = new Usuario(idPhoto, username, password, birthday, description, latestEvents, tagList, idPhoto);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rUsuario;
    }

    @Override
    public int borrar(Usuario usuario) {

        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setString(1, usuario.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_UPDATE);
  
            sentencia.setString(1, usuario.getUsername());
            sentencia.setString(2, usuario.getPassword());
            sentencia.setDate(3, usuario.getBirthday());
            sentencia.setString(4, usuario.getDescription());
            sentencia.setArray(5, (Array) usuario.getLatestEvents());
            sentencia.setObject(6, usuario.getTagList());
            sentencia.setString(7, usuario.getIdPhoto());
                      sentencia.setString(8, usuario.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
}
