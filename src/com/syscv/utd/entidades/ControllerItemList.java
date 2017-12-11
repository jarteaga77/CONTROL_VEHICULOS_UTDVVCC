/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import java.util.ArrayList;


/**
 *
 * @author Jonathan
 */
public class ControllerItemList 
{
    LlenarCombo llenar=new LlenarCombo();
    public ArrayList listarItemVehiculo()
    {
        return llenar.listaItem();
    }
    
    public ArrayList listarItemLinea()
    {
        return llenar.listaItem2();
    }
    
      public ArrayList listarItemIDVehi()
    {
        return llenar.listaItem3();
    }
      
    public ArrayList listarItemTipoMto()
    {
        return llenar.listaItem4();
    }
    
    public ArrayList listarItemRutina()
    {
        return llenar.listaItem5();
    }
    
    public ArrayList listarItemMecanico()
    {
        return llenar.listaItem6();
    }
    
    public ArrayList listarItemServicioMec(int mto)
    {
        return llenar.listaItem7(mto);
    }
    
     public ArrayList listarItemSistema()
    {
        return llenar.listaItem8();
    }
     
      public ArrayList listarItemProveedor()
    {
        return llenar.listaItem9();
    }
      
      public ArrayList listarItemSubsistema(int id)
    {
        return llenar.listaItem10(id);
    }
      
        public ArrayList listarItemVehiculoFicha()
    {
        return llenar.Listaitem11();
    }
        
       public ArrayList listarIteTipoDoc()
    {
        return llenar.listaItem12();
    }
    
       
     public ArrayList listarCentroCostos()
    {
        return llenar.listaItem13();
    }
     
      public ArrayList listarItemCentroCostos(int id)
    {
        return llenar.listaItem14(id);
    }
      
         public ArrayList listarConductor()
    {
        return llenar.listaItem15();
    }
     
         
    public ArrayList listarFormaPago()
    {
        return llenar.listaItem16();
    }
    
}
