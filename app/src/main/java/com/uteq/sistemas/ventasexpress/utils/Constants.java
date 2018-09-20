package com.uteq.sistemas.ventasexpress.utils;

import android.support.v4.app.FragmentManager;

import com.uteq.sistemas.ventasexpress.model.Empleado;

/**
 * Created by Andres on 10/08/2017.
 */

public class Constants {

    public static Empleado empleado;

    public static final String IP_LOCAL = "http://ve.hol.es";
    public static final String WS_RUTA = IP_LOCAL + "/ruta.php";
    public static final String WS_CLIENTE = IP_LOCAL + "/cliente.php";
    public static final String WS_USUARIO = IP_LOCAL + "/usuario.php";
    public static final String WS_PEDIDO = IP_LOCAL + "/pedido.php";
    public static final String WS_EMPLEADO = IP_LOCAL + "/empleado.php";
    public static final String WS_PRODUCTO = IP_LOCAL + "/producto.php";
    public static final String WS_BONIFICACION = IP_LOCAL + "/bonificacion.php";

    //Mensajes
    public static final String MSG_CONFIRMAR_GUARDAR_IMAGEN = "¿Desea guardar la imagen?";
    public static final String MSG_GUARDAR_IMAGEN = "Mantenga presionado para guardar como imagen";
    public static final String MSG_COMPROBAR_CONEXION_INTERNET = "Comprueba tu conexión a internet";
    public static final String MSG_CARGANDO_IMAGEN = "Cargando imagen...";
    public static FragmentManager fragmentManager;
}