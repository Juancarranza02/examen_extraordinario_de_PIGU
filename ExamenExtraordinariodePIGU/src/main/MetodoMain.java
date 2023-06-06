/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import vista.principal;


public class MetodoMain {
    
    public static void main(String[] args) {
        //author63841();
        principal mn = new principal();
        mn.setVisible(true);
    }
    
    public static void  author63841() {
        String nombre = "Juan armando Carranza magadan";
         String matrícula = "63841"; 
         String correo_electrónico = "al06384@gmail.com";
         String hobbies[] = {"Leer", "Correr", "Escuchar Musica"};
        System.out.println("Hola soy "+nombre+" mi Matricula es "+matrícula+"\n Hobbies son : "+"\n *"+hobbies[0]+"\n *"+hobbies[1]+"\n *"+hobbies[2]);
    }
}


