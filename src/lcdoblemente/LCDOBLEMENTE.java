/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdoblemente;

/**
 *
 * @author christom
 */
public class LCDOBLEMENTE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LCDE milista = new LCDE();
        milista.InsertarInicio(30);
        milista.InsertarInicio(20);
        milista.InsertarFinal(40);
        milista.InsertarFinal(60);
        System.out.println("Lista del ultimo al primero");
        milista.Mostrar1();
        milista.InsertarDespuesdeunNodo(40, 31);
        System.out.println("Lista del primero al ultimo");
        milista.Mostrar2();
     milista.borrarPrimero();
//        milista.borrarPrimero();
       milista.borrarUltimo();
  System.out.println("Lista del ultimo al primero");
        milista.Mostrar1();

    }

}
