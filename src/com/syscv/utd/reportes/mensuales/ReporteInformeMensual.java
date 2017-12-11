
package com.syscv.utd.reportes.mensuales;


import com.syscv.utd.conexionBD.Conexion;
import java.net.URL;
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
public class ReporteInformeMensual 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  //private final String encabezado="/UTDVVCC/recursos/encabezado.png";//Ruta del logo de la empresa
  //private final String pie="/UTDVVCC/recursos/pie.png";
  
  
    public void ejecutarReporte(int id)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport  
      //  JasperReport subreporte_vehi;
        JasperReport subreporte_total_ccostos;
        JasperReport subreporte_total_gal;
       
     
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/com/syscv/utd/reportes/mensuales/mensual_ctrlcombustible_.jasper");//Ruta del reporte maestro
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
//        URL  in1 = this.getClass().getResource("/com/syscv/utd/reportes/vehiculos.jasper");//Ruta del reporte maestro
//        subreporte_vehi = (JasperReport) JRLoader.loadObject( in1 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
       URL  in2 = this.getClass().getResource("/com/syscv/utd/reportes/mensuales/total_gal_info_men.jasper");//Ruta del reporte maestro
        subreporte_total_gal = (JasperReport) JRLoader.loadObject( in2 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
       
         URL  in3 = this.getClass().getResource("/com/syscv/utd/reportes/mensuales/total_ccostos_info_men.jasper");//Ruta del reporte maestro
        subreporte_total_ccostos = (JasperReport) JRLoader.loadObject( in3 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
       
        
        
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("id",id);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
        
        // parametros.put("vehiculos",subreporte_vehi);
         parametros.put("total_gal",subreporte_total_gal);
         parametros.put("total_ccostos",subreporte_total_ccostos);

        
       //  parametros.put("encabezado",this.getClass().getResourceAsStream(encabezado));//Carga la imagen encabezado en el reporte
        // parametros.put("pie",this.getClass().getResourceAsStream(pie));//Carga la imagen pie en el reporte
  
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Informe Mensual Vehiculos - Equipos - UTDVVCC ");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
    
    
    
 
}
