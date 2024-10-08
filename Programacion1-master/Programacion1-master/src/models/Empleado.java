package models;

public class Empleado {
    private String codigo;
    private String nombreEmpleado;
    private int horasTrabajadas;
    private double valorHoraTrabajada;

    public Empleado(String codigo, String nombreEmpleado, int horasTrabajadas, double valorHoraTrabajada) {
        this.codigo = codigo;
        this.nombreEmpleado = nombreEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHoraTrabajada = valorHoraTrabajada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHoraTrabajada() {
        return valorHoraTrabajada;
    }

    public void setValorHoraTrabajada(double valorHoraTrabajada) {
        this.valorHoraTrabajada = valorHoraTrabajada;
    }

    public double getSalario() {
        return calcularSueldo(horasTrabajadas, valorHoraTrabajada);
    }

    private double calcularSueldo(int horas, double valorHora) {
        return horas * valorHora;
    }
}
