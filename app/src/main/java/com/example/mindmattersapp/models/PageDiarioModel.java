package com.example.mindmattersapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PageDiarioModel {
    private String id, titulo, fecha, content;

    public PageDiarioModel(String id, String titulo, String fecha, String content) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
