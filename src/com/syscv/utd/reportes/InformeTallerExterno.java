
package com.syscv.utd.reportes;


import com.syscv.utd.conexionBD.Conexion;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author jarteaga
 */
public class InformeTallerExterno 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String logo="/com/syscv/utd/recursos/Logo.png";//Ruta del logo de la empresa
  private final String logo_a="/com/syscv/utd/recursos/logo_a.png";
  
  
    public void ejecutarReporte(Date fecha_ini, Date fecha_fin, String usuario)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport  
    
       
     
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/com/syscv/utd/reportes/InformeTallerExterno.jasper");//Ruta del reporte maestro
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        
        
        
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("ini",fecha_ini);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("fin",fecha_fin);
         parametros.put("usuario",usuario);
      

        
        parametros.put("logo",this.getClass().getResourceAsStream(logo));//Carga la imagen encabezado en el reporte
        parametros.put("logo_a",this.getClass().getResourceAsStream(logo_a));//Carga la imagen pie en el reporte
  
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Informe Taller Externo - UTDVVCC ");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
    
     public void ejecutarReporteFil(Date fecha_ini, Date fecha_fin, String usuario, int id, String nom_v)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport  
    
       
     
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/com/syscv/utd/reportes/InformeTallerExternoFil.jasper");//Ruta del reporte maestro
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        
        
        
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("ini",fecha_ini);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("fin",fecha_fin);
         parametros.put("usuario",usuario);
         parametros.put("nom_ve",nom_v);
         parametros.put("id_ve",id);
      

        
        parametros.put("logo",this.getClass().getResourceAsStream(logo));//Carga la imagen encabezado en el reporte
        parametros.put("logo_a",this.getClass().getResourceAsStream(logo_a));//Carga la imagen pie en el reporte
  
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Informe Taller Externo - UTDVVCC ");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
