/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Evento {
    private String id;
    private String eventName;
    private String description;
    private Date date;
    private List<Tag> tagList;
    private String idPhoto;

    public Evento(String eventName) {
        this.eventName = eventName;
    }

    public Evento(String id, String eventName, String description, Date date, List<Tag> tagList, String idPhoto) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.tagList = tagList;
        this.idPhoto = idPhoto;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto;
    }

    

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre del evento: " + eventName + ", Descripcion: " + description + ", Fecha: " + date + ", Tags: " + tagList + ", Foto: " + idPhoto;
    }
    
    
    
}
