package com.uteq.sistemas.ventasexpress.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Bonificacion {

    private int codigo;
    private String idempleado;
    private int idpedido;
    private double totalpedido;
    private int tasa;
    private double bonificacion;
    private String fecha;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public double getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(double totalpedido) {
        this.totalpedido = totalpedido;
    }

    public int getTasa() {
        return tasa;
    }

    public void setTasa(int tasa) {
        this.tasa = tasa;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) { this.fecha = fecha; }


    public Bonificacion(JSONObject a) throws JSONException {
        codigo = a.getInt("codigo");
        idempleado = a.getString("id_empleado");
        idpedido = a.getInt("id_pedido");
        totalpedido = a.getDouble("total_pedido");
        tasa = a.getInt("tasa");
        bonificacion = a.getDouble("bonificacion");
        fecha = a.getString("fecha");
    }

    public static ArrayList<Bonificacion> JsonObjectsBuild(JSONArray datos)
            throws JSONException {
        ArrayList<Bonificacion> bonificacion = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            bonificacion.add(new Bonificacion(datos.getJSONObject(i)));
        }
        return bonificacion;
    }
}