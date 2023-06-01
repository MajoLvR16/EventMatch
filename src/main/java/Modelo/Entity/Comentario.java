/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entity;

/**
 *
 * @author Acer
 */
public class Comentario {
    
    private String id;
    private Usuario user;
    private Evento event;
    private Double score;
    private String content;

    public Comentario(String id) {
        this.id = id;
    }

    public Comentario(String id, Usuario user, Evento event, Double score, String content) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.score = score;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Usuario: " + user + ", Evento: " + event + ", Puntaje:" + score + ", Contenido:" + content;
    }
    
    
    
}
