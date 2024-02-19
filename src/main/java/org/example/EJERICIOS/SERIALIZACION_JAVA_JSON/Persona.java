package org.example.EJERICIOS.SERIALIZACION_JAVA_JSON;

public class Persona {
    private String Nombre;
    private String Apellidos;
    private int DNI;
    public Persona() {}
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persona "+getNombre();
    }
}
