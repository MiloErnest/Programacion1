package services;

import models.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoService {
    private List<Empleado> empleados;
    private Scanner sc;

    public EmpleadoService() {
        this.empleados = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("----- Menú -----");
            System.out.println("1. Crear Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Buscar Empleado");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    modificarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearEmpleado() {
        System.out.println("Ingrese el código del empleado:");
        String codigo = sc.nextLine();
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese las horas trabajadas:");
        int horas = sc.nextInt();
        System.out.println("Ingrese el valor de la hora:");
        double valor = sc.nextDouble();
        sc.nextLine(); // Limpiar el buffer del scanner

        Empleado empleado = new Empleado(codigo, nombre, horas, valor);
        empleados.add(empleado);
        System.out.println("Empleado creado: " + empleado.getNombreEmpleado());
    }

    private void modificarEmpleado() {
        System.out.println("Ingrese el código del empleado a modificar:");
        String codigo = sc.nextLine();

        Empleado empleado = buscarEmpleadoPorCodigo(codigo);
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado.getNombreEmpleado());
            System.out.println("Ingrese el nuevo nombre del empleado (dejar en blanco para no cambiar):");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                empleado.setNombreEmpleado(nuevoNombre);
            }

            System.out.println("Ingrese las nuevas horas trabajadas (ingresar -1 para no cambiar):");
            int nuevasHoras = sc.nextInt();
            if (nuevasHoras != -1) {
                empleado.setHorasTrabajadas(nuevasHoras);
            }

            System.out.println("Ingrese el nuevo valor de la hora (ingresar -1 para no cambiar):");
            double nuevoValor = sc.nextDouble();
            if (nuevoValor != -1) {
                empleado.setValorHoraTrabajada(nuevoValor);
            }
            sc.nextLine(); // Limpiar el buffer del scanner

            System.out.println("Empleado modificado: " + empleado.getNombreEmpleado());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void buscarEmpleado() {
        System.out.println("Ingrese el código del empleado a buscar:");
        String codigo = sc.nextLine();

        Empleado empleado = buscarEmpleadoPorCodigo(codigo);
        if (empleado != null) {
            System.out.println("Empleado encontrado:");
            System.out.println("Código: " + empleado.getCodigo());
            System.out.println("Nombre: " + empleado.getNombreEmpleado());
            System.out.println("Horas Trabajadas: " + empleado.getHorasTrabajadas());
            System.out.println("Valor Hora Trabajada: " + empleado.getValorHoraTrabajada());
            System.out.println("Salario: " + empleado.getSalario());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la lista.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println("Código: " + empleado.getCodigo());
                System.out.println("Nombre: " + empleado.getNombreEmpleado());
                System.out.println("Horas Trabajadas: " + empleado.getHorasTrabajadas());
                System.out.println("Valor Hora Trabajada: " + empleado.getValorHoraTrabajada());
                System.out.println("Salario: " + empleado.getSalario());
                System.out.println("-----------------------");
            }
        }
    }

    private Empleado buscarEmpleadoPorCodigo(String codigo) {
        for (Empleado empleado : empleados) {
            if (empleado.getCodigo().equals(codigo)) {
                return empleado;
            }
        }
        return null;
    }

    private double calcularSueldo(int horas, double valorHora) {
        return horas * valorHora;
    }
}
