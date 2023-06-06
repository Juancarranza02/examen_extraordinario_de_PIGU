/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Models.ModeloJSON;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.principal;

public class PlanetasDTO {

    List<ModeloJSON> elementos = new ArrayList<ModeloJSON>();

    public PlanetasDTO() {

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

}
