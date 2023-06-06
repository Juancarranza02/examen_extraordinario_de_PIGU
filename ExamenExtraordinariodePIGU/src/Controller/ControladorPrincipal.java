/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.PlanetasDTO;
import Models.ModeloJSON;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;
import vista.principal;
public class ControladorPrincipal implements ActionListener, MouseListener{
    
    principal mn;
    ModeloJSON js;
    PlanetasDTO pl = new PlanetasDTO();
    int filaActual = 0;
    boolean verificar = false;

    public ControladorPrincipal(principal mn) {
        this.mn = mn;
        mn.btn_Aceptar.addActionListener(this);
        mn.btn_MostrarDatos.addActionListener(this);
        this.mn.btn_Actualizar.addActionListener(this);
        this.mn.btn_Eliminar.addActionListener(this);
        this.mn.btn_cancelar.addActionListener(this);  
        this.mn.btn_Exportar.addActionListener(this);
        this.mn.tblElementos.addMouseListener(this);
        pl.setDatos(mn);
        mn.ilbd.setText(""+pl.lastItemList());
        mn.setLocationRelativeTo(mn);
       // cargarDatos();
    }
    
 /*   public void cargarDatos(){
        js=new ModeloJSON(43.13, 11,5922, "Haumea");
        String texto = "UA: "+js.getUA()+"\n Id: "+js.getId()+"\n Milesk: "+js.getMilesk()+"\n Nombre: "+js.getNombre();
        mn.textJSON.setText(texto);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mn.btn_Aceptar){
            pl.Aceptar(Integer.parseInt(mn.txt_recNo.getText()), Double.parseDouble(mn.txt_UA.getText()), Integer.parseInt(mn.txt_id.getText()), Integer.parseInt(mn.txt_milesk.getText()), mn.txt_Nombre.getText());
        }else if(e.getSource() == mn.btn_MostrarDatos){
            pl.setDatos(mn);
        }else if(e.getSource() == mn.btn_cancelar){
           pl.LimpiarCampos(mn);
           
        }else if(e.getSource() == mn.btn_Eliminar){
                 pl.removeRow(filaActual);
                 pl.setDatos(mn);
        }else if(e.getSource() == mn.btn_Actualizar){
            pl.Actualizar(filaActual, mn);
            
        }else if(e.getSource() == mn.btn_Exportar){
               if(pl.ExportarInfo()){
                   JOptionPane.showMessageDialog(mn, "Se creo correctamente");
                   mn.Exportar.setLocation(200,0);
                   mn.Exportar.setSize(800, 600);
                   mn.Exportar.setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(mn, "Error.. Verifique.");
               }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if(e.getSource() == mn.tblElementos){
            filaActual = mn.tblElementos.getSelectedRow();
            mn.txt_id.setText(""+(filaActual+1));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
     }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
    
}
