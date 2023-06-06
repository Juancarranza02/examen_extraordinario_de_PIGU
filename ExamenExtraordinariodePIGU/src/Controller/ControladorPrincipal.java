/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.ModeloJSON;
import vista.principal;
public class ControladorPrincipal {
    
    principal mn;
    ModeloJSON js;

    public ControladorPrincipal(principal mn) {
        this.mn = mn;
        cargarDatos();
    }
    
    public void cargarDatos(){
        js=new ModeloJSON(43.13, 11,5922, "Haumea");
        String texto = "UA: "+js.getUA()+"\n Id: "+js.getId()+"\n Milesk: "+js.getMilesk()+"\n Nombre: "+js.getNombre();
        mn.textJSON.setText(texto);
    }
    
    
}
