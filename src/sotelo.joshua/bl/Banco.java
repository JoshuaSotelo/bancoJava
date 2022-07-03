package sotelo.joshua.bl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    static Scanner scan = new Scanner(System.in);
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Cuenta> cuentas;

    public Banco() {
        setClientes(new ArrayList<>());
        setCuentas(new ArrayList<>());
        setClientes(clientes);
        setCuentas(cuentas);

    }
    //no uso estos getters porque ya hice una lista bonita según yo :)
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }


    //--------------------Modo prueba-----------------

    //-----------------------------Modo prueba con datos llenados--- Opcion 8 en el menú


    public void agregarPrueba() {
        System.out.println("Modo prueba ejecutandose");


        Cuenta cuenta = new Cuenta(1, 10000, 11752);
        cuentas.add(cuenta);
        Cuenta cuenta2 = new Cuenta(2, 20000, 11762);
        cuentas.add(cuenta2);
        Cuenta cuenta3 = new Cuenta(3, 1, 11772);
        cuentas.add(cuenta3);
        listaCuentas();
        Cliente cliente = new Cliente("Joshua", 101, "29/11/1999", 22, "Limón");
        clientes.add(cliente);
        Cliente cliente2 = new Cliente("Andrey", 102, "13/10/1799", 222, "Limón");
        clientes.add(cliente2);
        listaClientes();

        System.out.println("Ahora pruebo eliminar datos de cuenta 2, en el espacio array 1");
        cuentas.get(1).setNumeroCuenta(25);
        cuentas.get(1).setSaldo(25);

        System.out.println("Ahora imprimo resultados a ver qué pedo");
        listaCuentas();

        System.out.println("Ahora Prueba añadir saldo");
        double saldo = cuentas.get(1).getSaldo();
        double saldoAñadir = 10000;
        double suma = saldo + saldoAñadir;
        cuentas.get(1).setSaldo(suma);
        listaCuentas();


    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public static void setCuentas(ArrayList<Cuenta> cuentas) {

        Banco.cuentas = cuentas;
    }


    //---------------Agregar clientes y cuentas----------------

    public void agregarCliente() throws IOException {


        boolean estado;
        do {

            estado = false;


            System.out.println("Ingrese el nombre del cliente");
            String nombre = scan.next();
            System.out.println("Ingrese el numero de identificación del cliente");

            int identificacion = scan.nextInt();

            boolean validacion = validarIdCliente(identificacion);
            if (!validacion) {
                System.out.println("Ingrese la fecha de nacimiento del cliente en formato " + "dia/mes/año");
                String fechaN = scan.next();
                System.out.println("Ingrese la edad del cliente");
                int edad = scan.nextInt();
                System.out.println("Ingrese la dirección del cliente");
                String direccion = scan.next();

                Cliente cliente = new Cliente(nombre, identificacion, fechaN, edad, direccion);

                clientes.add(cliente);
                estado = true;


            } else {
                System.out.println("Cliente ya registrado previamente");

                System.out.println("Si desea salir al menú principal digite 1, de querer volver a intentar el formulario actual, digite cualquier otro numero");
                int opcion = scan.nextInt();
                if (opcion == 1) {
                    estado = true;

                }
            }


        } while (estado == false);

    }

    public void agregarCuentaBanco(int idCliente, int numeroCuenta, double saldoInicial) {


        Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial, idCliente);
        cuentas.add(cuenta);


    }

    public void agregarCuenta() throws IOException {

        boolean status = true;
        do {
            System.out.println("Ingrese el numero de identificación del cliente");
            int idCliente = scan.nextInt();
            boolean validacion = validarIdCliente(idCliente);
            if (validacion) {
                System.out.println("Ingrese el numero de cuenta");
                int numeroCuenta = scan.nextInt();
                boolean validacion2 = validarNumeroCuenta(numeroCuenta, 0);

                if (!validacion2) {

                    boolean estado = false;
                    do {

                        System.out.println("Estimado cliente, tiene que hacer un deposito de 50000 o mayor para poder crear la cuenta");
                        System.out.println("Ingrese el saldo a ingresar en la cuenta. Tome en cuenta que al ser el deposito incial tiene que ser mayor de 50.000 colones");
                        double saldoInicial = scan.nextDouble();
                        if (saldoInicial >= 50000) {
                            agregarCuentaBanco(idCliente, numeroCuenta, saldoInicial);
                            status = true;
                            estado = true;
                            System.out.println("Cuenta registrada con exito");



                        } else {
                            System.out.println("Saldo ingresado invalido");
                            System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                            int salida = scan.nextInt();
                            if (salida == 1) {
                                estado = true;
                            }


                        }


                    } while (estado == false);


                } else {
                    System.out.println("Numero de cuenta ya registrado");
                    status = false;


                    System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                    int salida = scan.nextInt();
                    if (salida == 1) {
                        status = true;
                    }

                }

            } else {
                System.out.println("Usuario no registrado, intente de nuevo");
                status = false;
                System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                int salida = scan.nextInt();
                if (salida == 1) {
                    status = true;
                }

            }


        } while (status == false);


    }


    //-------------Estos sin uso--------------

    /*
    public void removerCliente(int indice) {

        clientes.size();
        clientes.remove(indice);
    }

    public void removerCuenta(int indice) {
        cuentas.remove(indice);
    }

    */


    //no uso el toString, pero lo deje porque así lo habiamos visto en clase



/*
    @Override
    public static String toString() {
        return "Banco{" +
                "clientes=" + clientes +
                ", cuentas=" + cuentas +
                '}';
    }*/


    //-----------------------------Listas-------------------

    public void listaClientes() {

        System.out.println("Lista de clientes");
        System.out.println("------------------------------------------");

        for (int i = 0; i < clientes.size(); i++) {
            int suma = i + 1;
            System.out.println("------------Cliente #" +suma +"-------");
            System.out.println("Nombre del Cliente: " + clientes.get(i).getNombre());
            System.out.println("Identificación del Cliente: " + clientes.get(i).getIdentificacion());
            System.out.println("Fecha de nacimiento del Cliente: " + clientes.get(i).getFechaN());
            System.out.println("Edad del Cliente: " + clientes.get(i).getEdad());
            System.out.println("Dirección del Cliente: " + clientes.get(i).getDireccion());
            System.out.println("------------------------------------------");
        }
    }

    public void listaCuentas() {

        System.out.println("Lista de cuentas");
        System.out.println("------------------------------------------");
        for (int i = 0; i < cuentas.size(); i++) {
            int suma = i + 1;
            System.out.println("------------Cuenta #" + suma+"--------");
            System.out.println("ID del cliente: " + cuentas.get(i).getIdCliente());
            System.out.println("Número de cuenta: " + cuentas.get(i).getNumeroCuenta());
            System.out.println("Saldo de la cuenta: " + cuentas.get(i).getSaldo());
            System.out.println("------------------------------------------");

        }

    }


    //--------------------------------Validaciones-------------------
    public static boolean validarIdCliente(int idCliente) throws IOException {
        boolean verificacion = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdentificacion() == idCliente) {
                System.out.println("Usuario validado con exito, nuemero de identificacion: " + clientes.get(i).getIdentificacion() + " existente");
                verificacion = true;
            } else {


            }
        }
        return verificacion;
    }

    public boolean validarNumeroCuenta(double numeroCuenta, int i) throws IOException {

        boolean validacion;
        if (cuentas.size() == 0) {
            System.out.println("No hay ninguna cuenta registrada");
            validacion = false;

        } else {
            validacion = false;
            for (i = 0; i < cuentas.size(); i++) {
                if (numeroCuenta == cuentas.get(i).getNumeroCuenta()) {
                    System.out.println("Cuenta validada, numero de cuenta: " + numeroCuenta);
                    System.out.println("En el espacio del arrayList: " + i);
                    validacion = true;

                } else {


                }

            }


        }
        return validacion;
    }


    public boolean validarRetiro(double saldoRetirar, int i) {
        double saldo = cuentas.get(i).getSaldo();
        if (saldoRetirar == 0) {
            System.out.println("Monto invalido por favor vuelva a intentarlo");
            return false;


        } else {
            if (saldoRetirar <= saldo) {
                System.out.println("Saldo suficiente");

                return true;
            } else {
                System.out.println("Saldo Insuficiente");
                System.out.println("Intentelo nuevamente");


                return false;


            }

        }


    }


    public void verSaldo() throws IOException {

        int numeroCuenta;
        int i;
        boolean estado = true;
        do {

            System.out.println("Ingrese el numero de cuenta a la que consultará el saldo");
            numeroCuenta = scan.nextInt();
            boolean validacion = validarNumeroCuenta(numeroCuenta, 0);

            if (validacion) {
                i=indexCuentas(numeroCuenta,0);

                System.out.println("El numero de cuenta: " + numeroCuenta + ", cuenta con el saldo de: " + cuentas.get(i).getSaldo());
                estado = false;

            } else {
                System.out.println("Numero de cuenta inexistente");
                System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                int salida = scan.nextInt();
                if (salida == 1) {
                    estado = false;
                }

            }


        } while (estado);


    }


    //------------------------Movimientos de cuenta-----------------------------
    //estos "añadirSaldoBanco" y el de retirar son como una funcion en un segundo nivel de confirmacion, es para no hacer tan largo la otra funcion y tener estas especificas de sumar o restar por aparte
    public void añadirSaldoBanco(double saldoAñadir, int numeroCuenta, int i) throws IOException {
        double saldo = cuentas.get(i).getSaldo();
        double suma = saldo + saldoAñadir;


        System.out.println("Previamente la cuenta contaba con: " + cuentas.get(i).getSaldo());
        cuentas.get(i).setSaldo(suma);
        System.out.println("Saldo registrado con exito, ahora cuenta con: " + cuentas.get(i).getSaldo());


    }

    public void retirarSaldoBanco(double saldoRetirar, int i) throws IOException {
        double saldo = cuentas.get(i).getSaldo();
        double resta = saldo - saldoRetirar;


        System.out.println("Previamente su cuenta contaba con: " + cuentas.get(i).getSaldo());
        cuentas.get(i).setSaldo(resta);
        System.out.println("Saldo retirado con exito, ahora cuenta con el saldo de: " + cuentas.get(i).getSaldo());

    }

    public void agregarSaldo(boolean validacion) throws IOException {

        validacion = false;
        int i = 0;
        while (validacion == false) {

            System.out.println("Ingrese el numero de cuenta");
            int numeroCuenta = scan.nextInt();
            validacion = validarNumeroCuenta(numeroCuenta, i);



            if (validacion) {
                i=indexCuentas(numeroCuenta,0);


                System.out.println("Ingrese la cantidad a añadir: ");
                double saldoAñadir = scan.nextDouble();
                if (saldoAñadir > 0) {
                    añadirSaldoBanco(saldoAñadir, numeroCuenta, i);

                    validacion = true;


                } else {
                    System.out.println("Cantidad ingresada invalida");
                    validacion = false;


                    System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                    int salida = scan.nextInt();
                    if (salida == 1) {
                        validacion = true;
                    }
                }

            } else {

                System.out.println("Numero de cuenta inexistente");
                validacion = false;
                System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                int salida = scan.nextInt();
                if (salida == 1) {
                    validacion = true;
                }
            }

        }
    }

    public int indexCuentas(int numeroCuenta, int i){

            for (i = 0; i < cuentas.size(); i++) {
                if (numeroCuenta == cuentas.get(i).getNumeroCuenta()) {
                    return i;

                } else {


                }

            }






        return i;
    };


    public void retirarSaldo(boolean validacion) throws IOException {
        validacion = false;
        int i = 0;
        while (validacion == false) {

            System.out.println("Ingrese el numero de cuenta");
            int numeroCuenta = scan.nextInt();
            validacion = validarNumeroCuenta(numeroCuenta, i);


            if (validacion) {
                i=indexCuentas(numeroCuenta,0);


                System.out.println("Ingrese la cantidad a retirar: ");
                double saldoRetirar = scan.nextDouble();
                validacion = validarRetiro(saldoRetirar, i);



                if (validacion) {
                    retirarSaldoBanco(saldoRetirar, i);
                    validacion = true;


                } else {
                    validacion = false;
                    System.out.println("Desea salir? digite 1  ------    O de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                    int salida = scan.nextInt();
                    if (salida == 1) {
                        validacion = true;
                    }


                }


            } else {
                System.out.println("Numero de cuenta inexistente");
                validacion = false;
                System.out.println("Desea salir? digite 1- de no ser así  y querer volver a intentar, ingrese cualquier otro digito");
                int salida = scan.nextInt();
                if (salida == 1) {
                    validacion = true;
                }
            }

        }

    }


}



