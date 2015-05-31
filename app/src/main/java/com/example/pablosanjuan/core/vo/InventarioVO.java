package com.example.pablosanjuan.core.vo;

/**
 * Created by Pablo Sanjuan on 29/05/2015.
 */
public class InventarioVO {
    private String Id;
    private String Nombre;
    private String Fecha;
    private String Genero;
    private String Proposito;
    private String Peso;
    private String Color;
    private String Raza;
    private String Id_padre;
    private String Id_madre;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getProposito() {
        return Proposito;
    }

    public void setProposito(String proposito) {
        Proposito = proposito;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getId_padre() {
        return Id_padre;
    }

    public void setId_padre(String id_padre) {
        Id_padre = id_padre;
    }

    public String getId_madre() {
        return Id_madre;
    }

    public void setId_madre(String id_madre) {
        Id_madre = id_madre;
    }
}