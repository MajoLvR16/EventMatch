/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Tag;
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
public class TagDao implements ITag{
    
    String SQL_CONSULTAR = "SELECT * FROM tag";
    String SQL_INSERTAR = "INSERT INTO tag (id, name) VALUES (?,?)";
    String SQL_BORRAR = "DELETE FROM tag WHERE id = ?";
    String SQL_CONSULTAID = "SELECT * FROM tag WHERE id = ?";
    String SQL_UPDATE = "UPDATE tag SET name = ? WHERE id = ?";
    

    @Override
    public int Insertar(Tag tag) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setString(1, tag.getId());
            sentencia.setString(2, tag.getName());
            
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Tag> consultar() {
    Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List <Tag> tags = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                String id = resultado.getString("id");
                String name = resultado.getString("name");
                Tag tag = new Tag(id, name);
                tags.add(tag);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tags;
    }

    @Override
    public Tag consultarID(Tag tag) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Tag rTag = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAID,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setString(1,tag.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
                String id = resultado.getString("id");
                String name = resultado.getString("name");
                rTag = new Tag(id, name);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rTag;
    }

    @Override
    public int borrar(Tag tag) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setString(1, tag.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Tag tag) {
    Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_UPDATE);
            sentencia.setString(2, tag.getId());
            sentencia.setString(1, tag.getName());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            }
            catch (SQLException ex){
                Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
}
