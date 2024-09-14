package models;

public class Empleado {
    private String codigo;
    private String nombreEmpleado;
    private int horasTrabajadas;
    private double valorHoraTrabajada;
    private double salario;

    public Empleado() {
        this.codigo = "00000";
        this.nombreEmpleado = "sin definir";
        this.horasTrabajadas = 0;
        this.valorHoraTrabajada = 0;
        this.salario = 0;
    }

    public Empleado(String codigo, String nombreEmpleado, int horasTrabajadas, double valorHoraTrabajada) {
        this.codigo = codigo;
        this.nombreEmpleado = nombreEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHoraTrabajada = valorHoraTrabajada;
        this.calcularSueldo(); // Calcular el salario al momento de la creación
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
        calcularSueldo(); // Recalcular el salario si se actualizan las horas trabajadas
    }

    public double getValorHoraTrabajada() {
        return valorHoraTrabajada;
    }

    public void setValorHoraTrabajada(double valorHoraTrabajada) {
        this.valorHoraTrabajada = valorHoraTrabajada;
        calcularSueldo(); // Recalcular el salario si se actualiza el valor por hora
    }

    public double getSalario() {
        return salario;
    }

    private void calcularSueldo() {
        this.salario = this.horasTrabajadas * this.valorHoraTrabajada;
    }
}
