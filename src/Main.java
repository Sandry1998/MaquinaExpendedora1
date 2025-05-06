import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Instanciamos la clase MaquinaCafe
         */

        MaquinaCafe maquina=new MaquinaCafe();
        Scanner sc=new Scanner(System.in);
        int opcion;
        do{
            maquina.mostrarMenu();
            System.out.println("0. APAGAR MAQUINA");
            System.out.println("ELIJA LA OPCION");
            opcion=sc.nextInt();
            if(opcion!=0){
                System.out.println("Introduzca el dinero (€): ");
                double dinero=sc.nextDouble();
                maquina.servirCafe(opcion,dinero);
            }
        }while(opcion!=0);
        maquina.mostrarHistorial();

    }
}