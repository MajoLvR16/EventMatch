/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Entity.Evento;
import Modelo.Entity.Tag;
import Red.BaseDatos;
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
 * @author Acer
 */
public class EventoDao implements IEvento {

    String SQL_CONSULTAR = "SELECT * FROM evento";
    String SQL_INSERTAR = "INSERT INTO evento (id, eventName, description, date, tagList, idPhoto) VALUES (?,?,?,?,?,?)";
    String SQL_BORRAR = "DELETE FROM evento WHERE id = ?";
    String SQL_CONSULTAID = "SELECT * FROM evento WHERE id = ?";
    String SQL_UPDATE = "UPDATE evento SET eventName = ?, description = ?, date = ?, tagList = ?, idPhoto = ? WHERE id = ?";

    @Override
    public int Insertar(Evento evento) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setString(1, evento.getId());
            sentencia.setString(2, evento.getEventName());
            sentencia.setString(3, evento.getDescription());
            sentencia.setDate(4, evento.getDate());
            sentencia.setObject(5, evento.getTagList());
            sentencia.setString(6, evento.getIdPhoto());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public List<Evento> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Evento> eventos = new ArrayList<>();
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String id = resultado.getString("id");
                String eventName = resultado.getString("eventName");
                String description = resultado.getString("description");
                Date date = resultado.getDate("date");
                Tag tagList = (Tag) resultado.getObject("tagList");
                String idPhoto = resultado.getString("idPhoto");
                Evento evento = new Evento(id, eventName, description, date, tagList, idPhoto);
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eventos;
    }

    @Override
    public Evento consultarID(Evento evento) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Evento rEvento = null;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setString(1, evento.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            String eventName = resultado.getString("eventName");
            String description = resultado.getString("description");
            Date date = resultado.getDate("date");
            Tag tagList = (Tag) resultado.getObject("tagList");
            String idPhoto = resultado.getString("idPhoto");
            rEvento = new Evento(idPhoto, eventName, description, date, tagList, idPhoto);

        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(resultado);
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rEvento;
    }

    @Override
    public int borrar(Evento evento) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setString(1, evento.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Evento evento) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_UPDATE);
            sentencia.setString(1, evento.getEventName());
            sentencia.setString(2, evento.getDescription());
            sentencia.setDate(3, evento.getDate());
            sentencia.setObject(4, evento.getTagList());
            sentencia.setString(5, evento.getIdPhoto());
            sentencia.setString(6, evento.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDatos.close(sentencia);
                BaseDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

}
