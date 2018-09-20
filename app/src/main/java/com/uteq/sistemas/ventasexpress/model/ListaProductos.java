package com.uteq.sistemas.ventasexpress.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaProductos {

    private String codigo;
    private String codigoCategoria;
    private String nombre;
    private int stockMaximo;
    private int stockMinimo;
    private double precioPublico;
    private String observacion;

    public ListaProductos(JSONObject a) throws JSONException {
        this.codigo = a.getString("codigo");
        this.codigoCategoria = a.getString("codigo_categoria");
        this.nombre = a.getString("nombre");
        this.stockMaximo = a.getInt("stock_maximo");
        this.stockMinimo = a.getInt("stock_minimo");
        this.precioPublico = a.getDouble("precio_publico");
        this.observacion = a.getString("observacion");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public static ArrayList<ListaProductos> JsonObjectsBuild(JSONArray datos)
            throws JSONException {
        ArrayList<ListaProductos> productoList = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            productoList.add(new ListaProductos(datos.getJSONObject(i)));
        }
        return productoList;
    }
}
