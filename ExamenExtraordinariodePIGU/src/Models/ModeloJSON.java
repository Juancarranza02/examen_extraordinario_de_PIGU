/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class ModeloJSON {
    private Double UA;
    private int id;
    private int milesk;
    private String nombre;

    public ModeloJSON(Double UA, int id, int milesk, String nombre) {
        this.UA = UA;
        this.id = id;
        this.milesk = milesk;
        this.nombre = nombre;
    }

    public ModeloJSON() {
    }


    public Double getUA() {
        return UA;
    }

    public void setUA(Double UA) {
        this.UA = UA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMilesk() {
        return milesk;
    }

    public void setMilesk(int milesk) {
        this.milesk = milesk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
