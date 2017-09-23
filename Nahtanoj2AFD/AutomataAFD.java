/*
 * Expresión hecha: (10+0)*011
 * Profesor, creo que he podido corregir el autómata con expresión (10+0)*011. 
 * Lo he probado de diferntes maneras en los días últimos y nunca me ha arrojado una cadena erronea.
 * La lógica la seguí fue apartir del diagrama que le había mostrado en clase 
 * (si se pudo subir el archivo es AFD_Nahtanoj2.png) y del ejemplo que nos dio en clase
 */

/**
 *
 * @author Jonathan Leyva de la Vega -- 140288
 */




import java.util.Scanner;



public class AutomataAFD { //RegEx := (10|0)*011

    int cont;
    boolean aceptada;/*para guardar los caratcteres y los va ir separando*/
    char [] car;

     public static void main(String[]args){
        AutomataAFD aut= new AutomataAFD();
        System.out.println("Alfabeto:={0,1}");
        System.out.println("Expresión regular := (10+0)*011");
        System.out.print("Ingrese una cadena -> ");
        Scanner inp = new Scanner(System.in);
        String cadena = inp.nextLine();
        aut.car=cadena.toCharArray();
        aut.inicio();
        if(aut.aceptada)
        {
            System.out.println("Cadena aceptada");
        }
        else
            System.out.println("cadena NO aceptada");
    }
     public void inicio (){ /*metodo*/
         cont = 0;
         aceptada = false;
         this.q0();/*irnos al codigo 0 */
     }
     public void q0(){
         System.out.println("En q0");/*imprimimos y decimos que estamos en q0*/
         if(cont < car.length){ /*cuantos carácteres tiene mi arreglo*/ 
             switch (car[cont]) {
                 case '1':
                     cont++;/*incrememnto mi contador*/
                     this.q1();
                     break;
                 case '0':
                     cont++;/*incrememnto mi contador*/
                     this.q3();
                     break;
                 default: //Cualquier otro carácter
                     cont++;/*incrememnto mi contador*/
                     this.qError();/*si no lo dejo en 0*/
                     break;
             }
        }
     }
     public void q1(){
     System.out.println("En q1");
         if(cont < car.length){//cuantos espacios tiene mi arreglo/
             switch (car[cont]) {
                 case '0':
                     cont++;/*incrememnto mi contador*/
                     this.q2();
                     break;
                 default: //Cualquier otro carácter
                     cont++;/*incrememnto mi contador*/
                     this.qError();
                     break;
             }
             }
     }
     public void q2(){
     System.out.println("En q2");
         if(cont < car.length){//cuantos carácteres tiene mi arreglo/
             switch (car[cont]) {
                 case '1':
                     cont++;/*incrememnto mi contador*/
                     this.q1();
                     break;
                 case '0':
                     cont++;/*incrememnto mi contador*/
                     this.q3();/*si no lo dejo en 0*/
                     break;
                 default: //Cualquier otro carácter
                     cont++;/*incrememnto mi contador*/
                     this.qError();/*si no lo dejo en 0*/
                     break;
             }
         }
     }
     public void q3(){
     System.out.println("En q3");
         if(cont < car.length){//cuantos carácteres tiene mi arreglo/
             switch (car[cont]) {
                 case '1':
                     cont++;/*incrememnto mi contador*/
                     this.q4();
                     break;
                 case '0':
                     cont++;/*incrememnto mi contador*/
                     this.q3();
                     break;
                 default: //Cualquier otro carácter
                     cont++;/*incrememnto mi contador*/
                     this.qError();
                     break;
             }
             }
     }
     public void q4(){
              System.out.println("En q4");
         if(cont < car.length){//cuantos carácteres tiene mi arreglo/
             switch (car[cont]) {
                 case '1':
                     cont++;/*incrememnto mi contador*/
                     this.q5();
                     break;
                 case '0':
                     cont++;/*incrememnto mi contador*/
                     this.q2();
                     break;
                 default: //Cualquier otro carácter
                     cont++;/*incrememnto mi contador*/
                     this.qError();
                     break;
             }
         }
     }
     public void q5(){
        System.out.println("En q5 es aceptada");
         if(cont < car.length){//cuantos carácteres tiene mi arreglo/
             cont++;
             System.out.println("Contiene carácteres extra");
             this.qError();
         }
         else
         {
             this.aceptada=true;
         }
     }
     public void qError(){
     System.out.println();
     this.aceptada = false;/*restablecemos nuestra bandera */
     }

}
