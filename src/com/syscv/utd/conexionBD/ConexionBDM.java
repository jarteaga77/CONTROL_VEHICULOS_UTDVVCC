
package com.syscv.utd.conexionBD;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * realiza la conexion a la base de datos permitiendo realizar consultas o modificaciones
 * @author jarteaga
 */
public class ConexionBDM
{

    /**
     * Variable que define el tipo de base de datos a conectar
     */
    private  Connection conexion;

    private  Statement estatuto;

    /**
     * Nombre del usuario de la base de datos
     */
    private final  String nombreUsuario= "root";

    /**
     * Contrasena de la base de datos
     */
    private final  String contrasena="@admin1.@";

    private final String nombreBaseDatos="almacen";
//    private String nombreBaseDatos="prueba";

    /**
     * Metodo encargado de efectuar la conexion
     */
    public  void conectar()
    {

        String nombreDriver = null;
        String url = null;

        
        nombreDriver = "com.mysql.jdbc.Driver";//Driver PostgresSQL
      //   url =  "jdbc:postgresql://localhost/"+nombreBaseDatos;
      url =  "jdbc:mysql://192.168.1.128/"+nombreBaseDatos;
        
      // url =  "jdbc:postgresql://192.168.1.249:5432/"+nombreBaseDatos;
        

        try
        {
            Class.forName(nombreDriver).newInstance();
            conexion = DriverManager.getConnection(url,nombreUsuario,contrasena);
            estatuto = conexion.createStatement();

        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Metodo encargado de cerrar la conexion
     */
    public  void desconectar()
    {
        try
        {
            estatuto.close();
            conexion.close();
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para ejecutar consultas de tipo INSERT, UPDATE, DELETE
     * @param querySQL String consulta en SQL
     */
    public  void executeUpdateQuery(String querySQL)
    {
        try
        {
            conectar();
            estatuto.executeUpdate(querySQL);
            //desconectar();
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para ejecutar consultas de tipo SELECT
     * @param querySQL String consulta en SQL
     * @return ResultSet con los valores encontrados
     */
    public  ResultSet executeQuery(String querySQL)
    {
        try
        {
            conectar();
            return estatuto.executeQuery(querySQL);
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        return null;
    }
}



