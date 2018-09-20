package com.uteq.sistemas.ventasexpress.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ruta {
    private int id;
    private int idempleado;
    private String dia;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Ruta() {

    }

    public Ruta(JSONObject a) throws JSONException {
        id = a.getInt("id");
        idempleado = a.getInt("id_empleado");
        dia = a.getString("dia");
    }

    public static ArrayList<Ruta> JsonObjectsBuild(JSONArray datos)
            throws JSONException {
        ArrayList<Ruta> rutas = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            rutas.add(new Ruta(datos.getJSONObject(i)));
        }
        return rutas;
    }
}