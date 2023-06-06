/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.PlanetasDTO;
import Models.ModeloJSON;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.metal.MetalBorders;
import vista.principal;
public class ControladorPrincipal implements ActionListener{
    
    principal mn;
    ModeloJSON js;
    PlanetasDTO pl = new PlanetasDTO();

    public ControladorPrincipal(principal mn) {
        this.mn = mn;
        mn.btn_Aceptar.addActionListener(this);
        mn.btn_MostrarDatos.addActionListener(this);
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
        }
    }
    
    
}
