package uvg.edu.gt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Hola! Vamos a encontrar el perro perfecto para ti.");
        
        System.out.println("¿De qué color te gustaría que fuera el perro?");
        String color = scanner.nextLine();
        
        System.out.println("¿Qué tamaño prefieres para el perro? (pequeño, mediano, grande)");
        String tamaño = scanner.nextLine();
        
        System.out.println("¿Qué tipo de pelo te gusta en un perro? (corto, largo, mediano)");
        String pelo = scanner.nextLine();
        
        System.out.println("¿Qué tipo de personalidad te gustaría que tuviera el perro?");
        String personalidad = scanner.nextLine();
        
        System.out.println("¿Que tamaño tienes disponible para tu perro? (pequeño, mediano, grande)");
        String tamañoEspacio = scanner.nextLine();
        
        System.out.println("¿Cuántos años tienes?");
        int edad = scanner.nextInt();
        
        System.out.println("¿Vives solo? (si/no)");
        String viveSolo = scanner.nextLine(); // Consuming the new line character
        viveSolo = scanner.nextLine();
        
        System.out.println("¿Tienes alguna alergia? (si/no)");
        String alergia = scanner.nextLine();
        
        System.out.println("¡Gracias por responder las preguntas!");
        System.out.println("Aquí está un resumen de tus respuestas:");
        System.out.println("Color preferido del perro: " + color);
        System.out.println("Tamaño preferido del perro: " + tamaño);
        System.out.println("Tipo de pelo preferido: " + pelo);
        System.out.println("Personalidad preferida del perro: " + personalidad);
        System.out.println("Tamaño de espacio disponible: " + tamañoEspacio);
        System.out.println("Edad: " + edad + " años");
        System.out.println("¿Vives solo? " + viveSolo);
        System.out.println("¿Tienes alguna alergia? " + alergia);
    }
}