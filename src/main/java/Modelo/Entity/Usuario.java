/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Acer
 */
public class Usuario {
    
    private String id;
    private String username;
    private String password;
    private Date birthday;
    private String description;
    private List <Evento> latestEvents;
    private Tag tagList;
    private String idPhoto;

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String id, String username, String password, Date birthday, String description, List<Evento> latestEvents, Tag tagList, String idPhoto) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.description = description;
        this.latestEvents = latestEvents;
        this.tagList = tagList;
        this.idPhoto = idPhoto;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Evento> getLatestEvents() {
        return latestEvents;
    }

    public void setLatestEvents(ArrayList latestEvents) {
        this.latestEvents = latestEvents;
    }

    public Tag getTagList() {
        return tagList;
    }

    public void setTagList(Tag tagList) {
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
        return "ID: " + id + ", Username:" + username + ", Password: " + password + ", Birthday:" + birthday + ", Description: " + description + ", LatestEvents: " + latestEvents + ", TagList: " + tagList + ", idPhoto=" + idPhoto;
    }
    
    
}
