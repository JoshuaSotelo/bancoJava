package sotelo.joshua.ui;

import sotelo.joshua.bl.Banco;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        boolean status = true;
        Banco banco = new Banco();


        while (status) {
            System.out.println("___Ingrese una opcion del menú___");
            System.out.println("________1-Agregar Cliente________");
            System.out.println("_______2-Lista de clientes_______");
            System.out.println("_____3-Nueva cuenta corriente____");
            System.out.println("_________4-agregar fondos________");
            System.out.println("____5-hacer retiro de fondos_____");
            System.out.println("___6-Ver el saldo de la cuenta___");
            System.out.println("______________7-salir____________");

            int opcion = scan.nextInt();


            if (opcion >= 0 && opcion == 1) {


                banco.agregarCliente();


            } else if (opcion == 2) {
                banco.listaClientes();
                banco.listaCuentas();
            } else if (opcion == 3) {


                banco.agregarCuenta();

            } else if (opcion == 4) {
                banco.agregarSaldo(false);


            } else if (opcion == 5) {
                banco.retirarSaldo(false);


            } else if (opcion == 6) {
                banco.verSaldo();


            }else if (opcion == 7) {
                System.out.println("Finalizando programa");
                System.out.println("Hasta luego!");
                status = false;


                //modo prueba con datos ya rellenados
            }else if (opcion == 8) {
                banco.agregarPrueba();


            } else {
                System.out.println("Ingrese una opción valida");
                System.out.println("Desea salir? digite 1. O de no ser así  y querer volver al formulario indique cualquier otro número");
                int salida = scan.nextInt();
                if (salida == 1) {
                    System.out.println("Finalizando programa");
                    System.out.println("Hasta luego!");
                    status = false;
                }
            }

        }


    }
}
