package com.example.mindmattersapp.models;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String nombre;
    private String especialidad;
    private String subEspecialidad;
    private Integer calificacion;
    private String distancia;
    private String descripcion;
    private String horario1;
    private String horario2;
    private String tel1;
    private String tel2;
    private String direccion;
    private int foto;

    public Doctor() {

    }


    public Doctor(String nombre, String especialidad, String subEspecialidad, Integer calificacion, String distancia, String descripcion, String horario1, String horario2, String tel1, String tel2, String direccion, int foto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.subEspecialidad = subEspecialidad;
        this.calificacion = calificacion;
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.horario1 = horario1;
        this.horario2 = horario2;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.direccion = direccion;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSubEspecialidad() {
        return subEspecialidad;
    }

    public void setSubEspecialidad(String subEspecialidad) {
        this.subEspecialidad = subEspecialidad;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario1() {
        return horario1;
    }

    public void setHorario1(String horario1) {
        this.horario1 = horario1;
    }

    public String getHorario2() {
        return horario2;
    }

    public void setHorario2(String horario2) {
        this.horario2 = horario2;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
