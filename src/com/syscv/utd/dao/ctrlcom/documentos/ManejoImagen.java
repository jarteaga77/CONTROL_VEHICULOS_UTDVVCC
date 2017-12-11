package com.syscv.utd.dao.ctrlcom.documentos;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 * 
 * @author Jonathan
 * CLASE PARA CONECTARSE A UNA BASE DE DATOS POSTEGRES, INSERTAR Y RECUPERAR IMAGENES JPG
 */
public class ManejoImagen {

   //DATOS PARA LA CONEXION
   private String bd = "SistemaControlVehiculos";
   private String user = "postgres";
   private String password = "postgres";
   //private String url = "jdbc:postgresql://localhost:5432/"+bd;
   private String url = "jdbc:postgresql://192.168.1.128:5432/"+bd;

   private Connection connection = null;
   private ResultSet resultSet = null;
   private Statement statement = null;
    
    //Constructor de clase que se conecta a la base de datoS
    public ManejoImagen()
    {
      try{
         Class.forName("org.postgresql.Driver");         
         connection = DriverManager.getConnection(url, user , password);
         System.out.println("Conectado a la base de datos [ " + this.bd + "]");
      }catch(Exception e){
         System.err.println(e.getMessage());
      }
    }

    /* metodo que guarda una imagen JPG en la base de datos
     * input: ID : identificador unico para el registro, osea primary key
     * name: nombre de la imagen para reconocerlo mas adelante
     * ruta: direccion absoluta de la imagen JPG
    */
    public boolean guardarfoto(String id, String name, String ruta, int idctrl) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 1048576)
             { 
                 throw new Exception("El tamaño de la foto es superior a 1 Mb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO consumo_combustible.doc_control_combustible(id, nombre, archivo,id_ctrl) " + " VALUES(?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, idctrl);
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }

    /* Metodo que convierte una cadena de bytes en una imagen JPG
     * input:
     *       bytes: array que contiene los binarios de la imagen
     * Output: la foto JPG en formato IMAGE
     */
 private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");    
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 }

 /* Metodo que extrae los registros de la tabla IMAGEN de la base de datos
  * crea instancia nueva de la clase imagen.java y añade los datos
  * agrega estos datos a un DefaultListModel
  * output:
  *         dml: Es un DefaultListModel que contiene instancia de la clase imagen.java
  */
    public DefaultListModel Lista_Imagenes(int id)
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_num,id,nombre,archivo,id_ctrl FROM consumo_combustible.doc_control_combustible WHERE id_ctrl="+id+" ");
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             imagen img = new imagen();
             img.setId( resultSet.getString("id") ) ;
             img.setName( resultSet.getString("nombre") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
    
    
    
    public DefaultListModel Lista_Imagenes2(int id)
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_foto,id,nombre,foto,id_vehiculo_equipo FROM utilidades.foto_vehiculos WHERE id_vehiculo_equipo="+id+" ");
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             imagen img = new imagen();
             img.setId( resultSet.getString("id") ) ;
             img.setName( resultSet.getString("nombre") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("foto")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
    
    
    public DefaultListModel Listar_doc(int id)
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_doc,id,nombre,archivo,id_vehiculo FROM utilidades.documentacion_vehiculo WHERE id_vehiculo="+id+" AND activo=true ");
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             imagen img = new imagen();
             img.setId( resultSet.getString("id") ) ;
             img.setName( resultSet.getString("nombre") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
    
    
    
    public boolean guardarfoto2(String id, String name, String ruta, int id_vehiculo) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 50000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  50kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.foto_vehiculos(id, nombre, foto,id_vehiculo_equipo) " + " VALUES(?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_vehiculo);
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }


    public boolean guardardoc(String id, String name, String ruta, int id_vehiculo, boolean doc_vence, int tipo_doc, int id_usuario, Date fecha_inicio, Date fecha_vence, String n_doc) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 6000000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  600kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.documentacion_vehiculo(id, nombre, archivo,id_vehiculo, doc_vence,id_tipo_doc,id_usuario,fecha_inicio,fecha_vencimiento, n_documento) " + " VALUES(?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_vehiculo);
             pstm.setBoolean(5, doc_vence);
             pstm.setInt(6, tipo_doc);
             pstm.setInt(7, id_usuario);
             pstm.setDate(8, (java.sql.Date) fecha_inicio);
             pstm.setDate(9, (java.sql.Date) fecha_vence);
             pstm.setString(10,  n_doc);
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }
    
    
    public boolean guardarfotoCon(String id, String name, String ruta, int id_conductor) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 200000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  200kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.foto_conductor(id, nombre, foto,id_conductor) " + " VALUES(?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_conductor);
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }
    
    
    
    public boolean guardarDoc_Conductor(String ida, String name, String ruta, int id_conductor, boolean doc_vence, int tipo_doc, int id_usuario, Date fecha_inicio, Date fecha_vence, String n_doc,String categoria, String restricion) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 500000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  50kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.doc_conductor(id_a, nombre, archivo,num_licencia, categoria,desde,hasta,restriccion,id_usuario,id_conductor,id_tipo_doc,doc_vence) " + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, ida);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setString(4, n_doc);
             pstm.setString(5, categoria);
             pstm.setDate(6, (java.sql.Date) fecha_inicio);
             pstm.setDate(7, (java.sql.Date) fecha_vence);
             pstm.setString(8, restricion);
             pstm.setInt(9, id_usuario);
             pstm.setInt(10, id_conductor);
             pstm.setInt(11, tipo_doc);
             pstm.setBoolean(12, doc_vence);
             
             
    
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }
    
    
    
    public DefaultListModel Lista_Fot_Conductor(int id)
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_foto,id,nombre,foto,id_conductor FROM utilidades.foto_conductor WHERE id_conductor="+id+" ");
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             imagen img = new imagen();
             img.setId( resultSet.getString("id") ) ;
             img.setName( resultSet.getString("nombre") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("foto")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
    
     public DefaultListModel Lista_Doc_Conductor(int id)
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,id_a,nombre,archivo,id_conductor FROM utilidades.doc_conductor WHERE id_conductor="+id+" ");
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             imagen img = new imagen();
             img.setId( resultSet.getString("id_a") ) ;
             img.setName( resultSet.getString("nombre") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
     
     
     public boolean guardarDt_costos(String id, String name, String ruta,int id_vehiculo, int id_fact_mto_ex, Date fecha_fact, String fact_num, int id_proveedor, String concepto, double subtotal, double descuento, double vlor_iva, double total,String iva, int oc_) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 600000)
             { 
                 throw new Exception("El tamaño de la foto es superior a 1 50kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO mantenimientos_mecanica.dt_cos_fact_mto_ext(id, nombre, archivo_fact,id_vehiculo, id_fact_mto_ex,fecha_fact,fact_num,id_proveedor,concepto,subtotal,descuento,vlor_iva,total,iva,oc_) " + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_vehiculo);
             pstm.setInt(5,id_fact_mto_ex);
             pstm.setDate(6, (java.sql.Date) fecha_fact);
             pstm.setString(7, fact_num);
             pstm.setInt(8, id_proveedor);
             pstm.setString(9, concepto);
             pstm.setDouble(10, subtotal);
             pstm.setDouble(11, descuento);
             pstm.setDouble(12, vlor_iva);
             pstm.setDouble(13, total);
             pstm.setString(14, iva);
             pstm.setInt(15, oc_);
    
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
        return false;
   }
     
   public boolean guardarComparendos(String id, String name, String ruta,int id_vehiculo, int id_conductor, String desc_multa, String num_comparendo, int valor, Date fecha, int id_usuario) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 200000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  200kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.comparendos(id, nombre, archivo,id_vehiculo, id_conductor,descripcion_multa,num_comparendo,valor,fecha_comparendo, id_usuario) " + " VALUES(?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_vehiculo);
             pstm.setInt(5,id_conductor);
             pstm.setString(6, desc_multa);
             pstm.setString(7, num_comparendo);
             pstm.setInt(8, valor);
             pstm.setDate(9, (java.sql.Date) fecha);
             pstm.setInt(10, id_usuario);
             
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
        return false;
   }  
   
   
    public boolean guardarPagos(String id, String name, String ruta,int id_comparendo, Date fecha_pago, int  valor, String descripcion, String paz_salvo,int id_formapago, int id_usuario) throws Exception {
        FileInputStream fis = null;
        int tamanofile=0;
       
             File file = new File(ruta);
             tamanofile=(int) file.length();
             if(tamanofile > 200000)
             { 
                 throw new Exception("El tamaño de la foto es superior a  200kb");
             }
              try {
             System.out.println(file.length());
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO utilidades.pagos_comparendos(id, nombre, archivo,id_comparendo, fecha_pago,valor,descripcion,paz_salvo_num,id_forma_pago, id_usuario) " + " VALUES(?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, id);
             pstm.setString(2, name);
             pstm.setBinaryStream(3, fis,(int) file.length());
             pstm.setInt(4, id_comparendo);
             pstm.setDate(5, (java.sql.Date) fecha_pago);
             pstm.setInt(6, valor);
             pstm.setString(7, descripcion);
             pstm.setString(8, paz_salvo);
             pstm.setInt(9, id_formapago);
             pstm.setInt(10, id_usuario);
             
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
        return false;
   }  
     
     
    
}
