import models.Empleado;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Empleado empleado = new Empleado();

        System.out.println("Ingresa el nombre del empleado:");
        String nombre = sc.nextLine();
        empleado.setNombreEmpleado(nombre);

        System.out.println("Ingresa las horas trabajadas:");
        int horas = sc.nextInt();
        empleado.setHorasTrabajadas(horas);

        System.out.println("Ingresa el valor de la hora:");
        double valor = sc.nextDouble();
        empleado.setValorHoraTrabajada(valor);

        // Ya no es necesario llamar a calcularSueldo explícitamente, ya que se llama automáticamente en los setters.
        System.out.println("Cheque generado a: " + empleado.getNombreEmpleado() + " por el valor de: " + empleado.getSalario());
    }
}
