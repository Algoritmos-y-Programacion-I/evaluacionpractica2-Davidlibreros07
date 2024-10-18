package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {

        //AÑADIDO

        control.mostrarPillares(); // Mostrar pilares disponibles

        System.out.println("Elige el número del pillar al que desees añadir el projecto");
        int pillarType = reader.nextInt() - 1; // Restar 1 para coincidir con el índice del arreglo
        reader.nextLine(); 

        System.out.println("¿Cuántos projectos desea agregar?");
        int cantidadProjectos = reader.nextInt();
        reader.nextLine(); 

        for (int i = 0; i < cantidadProjectos; i++) {
            System.out.println("Projecto " + (i + 1));

            System.out.println("ID del proyecto:");
            String id = reader.nextLine();

            System.out.println("Nombre del projecto:");
            String name = reader.nextLine();

            System.out.println("ingrese una breve descripcion:");
            String description = reader.nextLine();

            

            System.out.println("ingrese el estado del projecto(1 para activo, 2 para inactivo):");
            int status = reader.nextInt();
            reader.nextLine();

        
            // Pasar la especie a la controladora para agregarla al lugar
            boolean exito = control.registerProjectInPillar(pillarType, id, name, description, status);
            if (!exito) {
                System.out.println("No se pudo agregar el projecto. El pillar ha alcanzado el límite de projectos o índice no válido.");
            } else {
                System.out.println("Projecto añadido con éxito.");
            }

        }

        //AÑADIDO



    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {

        control.mostrarPillares(); 

        System.out.println("Elige el número del Pillar para ver sus projectos:");
        reader.nextLine(); 
        int pillarType = reader.nextInt() - 1; 
       
        

        System.out.println(control.queryProjectsByPillar(pillarType));



    }

}