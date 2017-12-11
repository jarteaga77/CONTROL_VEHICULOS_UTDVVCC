package com.syscv.utd.dao.ctrlcom.documentos;
import java.awt.Image;
/**
 *
 * @author Jonathan
 * CLASE PARA ALMACENAR LOS DATOS DE LA TABLA IMAGEN
 */
public class imagen {

    private String id,name;
    private Image archivo;
    private int id_num, idctrl;

    public int getId_num() {
        return id_num;
    }

    public void setId_num(int id_num) {
        this.id_num = id_num;
    }

    public int getIdctrl() {
        return idctrl;
    }

    public void setIdctrl(int idctrl) {
        this.idctrl = idctrl;
    }
    

    public Image getArchivo() {
        return archivo;
    }

    public void setArchivo(Image archivo) {
        this.archivo = archivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
 
    @Override
    public String toString() {
        return this.id+" : "+this.name;
    }

}
