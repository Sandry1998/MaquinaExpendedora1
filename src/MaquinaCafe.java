import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class MaquinaCafe {
    private ArrayList<Cafe> historialVentas;

    /*
    Cuando se crea la maquina cafe-> constructor...se crea el historial de ventas->encender la maquina
     */

    public MaquinaCafe() {
        historialVentas = new ArrayList<>();
    }

    /*
    Mostrar el Menu y luego llamarlo instanciando la clase y llamando el metodo
    Se recorre los enums y se muestra
     */

    public void mostrarMenu(){
        System.out.println("Seleccione una opcion");
        for(int i = 0; i<TipoDeCafe.values().length;i++){
            System.out.println((i+1) + ". " + formatearNombre(TipoDeCafe.values()[i]).toUpperCase()+" ->"+ TipoDeCafe.values()[i].getPrecio()+"€");


        }
    }
    public void servirCafe(int opcion, double dinero){
        if(opcion < 1 || opcion > TipoDeCafe.values().length){
            System.out.println("Opcion no valida");
            return;
        }
        TipoDeCafe tipo = TipoDeCafe.values()[opcion -1];
        double precio = tipo.getPrecio();
        if(dinero < precio){
            System.out.printf("Dinero insuficiente. El %s cuesta %.2f € y usted introdujo %.2f €.%n",formatearNombre(tipo),precio,dinero);
            return;
        }
        double cambio= dinero - precio;
        Cafe cafe = new Cafe(tipo);
        historialVentas.add(cafe);

        System.out.printf("Aqui tiene su %s. Cambio: %.2f €%n", formatearNombre(tipo),cambio);
    }
    public void mostrarHistorial(){
        double totalVentas = 0;
        System.out.println("\nHistorial de Ventas");
        int[] contador = new int[TipoDeCafe.values().length];
        for(Cafe cafe : historialVentas) {
            contador[cafe.getTipo().ordinal()]++;
            totalVentas += cafe.getPrecio();
        }
        for(int i = 0; i < TipoDeCafe.values().length; i++){
            TipoDeCafe tipo = TipoDeCafe.values()[contador[i]];
            System.out.printf("%-20s: %2d Unidades Vendidas (%.2f €)%n",formatearNombre(tipo).toUpperCase(),
                    contador[i], contador[i]* tipo.getPrecio());
        }
        //tenemos creado el historial..ahora creamos una coleccion que no tenga repetidos...
        System.out.println("Total de ventas: " + totalVentas + "€");
    }
    private String formatearNombre(TipoDeCafe tipo){
        return tipo.name().toLowerCase().replace("_"," ");
    }
}
