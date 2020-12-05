package com.example.mindmattersapp.models;

public class Topics {
    private String topicId, titulo, URL;
    int idTopicImg;

    public Topics(String topicId, String titulo, String URL, int idTopicImg) {
        this.topicId = topicId;
        this.titulo = titulo;
        this.URL = URL;
        this.idTopicImg = idTopicImg;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getIdTopicImg() {
        return idTopicImg;
    }

    public void setIdTopicImg(int idTopicImg) {
        this.idTopicImg = idTopicImg;
    }
}
