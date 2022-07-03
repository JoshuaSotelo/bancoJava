package sotelo.joshua.bl;


import java.util.Scanner;
public class Cuenta {
    static Scanner scan = new Scanner(System.in);

    private  double numeroCuenta;
    private  double saldo;
    static int idCliente;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, double saldo, int idCliente) {
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldo);
        setIdCliente(idCliente);
    }

    public  double getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public  double getSaldo() {
        return saldo;
    }

    public  void setSaldo(double saldo ) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }





    //no uso el toString, pero lo deje porque así lo habiamos visto en clase

    @Override
    public String toString() {
        return "cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                ", idCliente=" + idCliente +
                '}';
    }

}
