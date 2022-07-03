package sotelo.joshua.bl;

public class Cliente {
    private String nombre;
    private int identificacion;
    private String fechaN;
    private int edad;
    private String direccion;


    public Cliente() {
    }

    public Cliente(String nombre, int identificacion, String fechaN, int edad, String direccion) {
        setNombre(nombre);
        setIdentificacion(identificacion);
        setFechaN(fechaN);
        setEdad(edad);
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaN() {
        return fechaN;
    }



    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


//no uso el toString, pero lo deje porque así lo habiamos visto en clase
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion +
                ", fechaN=" + fechaN +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
