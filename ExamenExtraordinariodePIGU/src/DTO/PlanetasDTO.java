/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Models.ModeloJSON;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.principal;

public class PlanetasDTO {

    List<ModeloJSON> elementos = new ArrayList<ModeloJSON>();

    public PlanetasDTO() {
        llenarElementos();
    }

    public void llenarElementos() {
        elementos.add(new ModeloJSON(43.13, 11, 5922, "haumea")); //0
        elementos.add(new ModeloJSON(5.2, 5, 780, "J�piter")); //1

    }

    public void Aceptar(int recNo, Double UA, int id, int milesk, String nombre) {
        if (recNo == -1) {
            elementos.add(new ModeloJSON(UA, id, milesk, nombre));
        } else {
            elementos.get(recNo).setId(id);
            elementos.get(recNo).setMilesk(milesk);
            elementos.get(recNo).setNombre(nombre);
            elementos.get(recNo).setUA(UA);
        }
    }

    public void limpiarTable(DefaultTableModel modeloTabla) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }

    public void setDatos(principal db) {
        DefaultTableModel modeloTabla = (DefaultTableModel) db.tblElementos.getModel();
        limpiarTable(modeloTabla);
        int columnas = modeloTabla.getColumnCount();
        Object[] datos = new Object[columnas];
        for (int i = 0; i < elementos.size(); i++) {
            datos[0] = i;
            datos[1] = elementos.get(i).getId();
            datos[2] = elementos.get(i).getNombre();
            datos[3] = elementos.get(i).getMilesk();
            datos[4] = elementos.get(i).getUA();
            modeloTabla.addRow(datos);
        }
    }

    public boolean ExportarInfo() {
        String ruta = System.getProperty("user.home");
        String url = ruta + "\\OneDrive\\Escritorio\\tblPlanetas.txt";
        System.out.println("Inico guardar archivo");
        File archivo = new File(url);
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            for (ModeloJSON quimico : elementos) {
                escribir.print("ID: " + quimico.getId() + "  ");
                escribir.print("Nombre: " + quimico.getNombre() + "  ");
                escribir.print("Milesk: " + quimico.getMilesk() + "  ");
                escribir.print("Id: " + quimico.getId() + "  ");
                escribir.print("UA: " + quimico.getUA() + "\n ");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error en crear archivo " + ex.getMessage());
            return false;
        }
    }

    public void Actualizar(int filaActual, principal db) {
        if (filaActual != -1) {
            db.txt_recNo.setText("" + db.tblElementos.getValueAt(filaActual, 0));
            db.txt_id.setText("" + db.tblElementos.getValueAt(filaActual, 1));
            db.txt_Nombre.setText("" + db.tblElementos.getValueAt(filaActual, 2));
            db.txt_milesk.setText("" + db.tblElementos.getValueAt(filaActual, 3));
            db.txt_UA.setText("" + db.tblElementos.getValueAt(filaActual, 4));
        } else {
            System.out.println("Es necesario Seleccionar un registro");
        }
    }

    public void removeRow(int filaActual) {
        if (filaActual != -1) {
            System.out.println(filaActual);
            JOptionPane.showMessageDialog(null, "Se elimino el registro: " + filaActual);
            elementos.remove(filaActual);
        }
    }

    public void LimpiarCampos(principal db) {
        int contador = Integer.parseInt(db.ilbd.getText());
        db.txt_Nombre.setText("");
        db.txt_UA.setText("");
        db.txt_milesk.setText("");
        db.txt_id.setText("" + (contador + 1));
        db.txt_Nombre.requestFocus(true);
    }

    public int lastItemList() {
        return elementos.get(elementos.size() - 1).getId();
    }

}
