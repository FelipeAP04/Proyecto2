package uvg.edu.gt;

import java.util.Scanner;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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
        

    @SuppressWarnings("deprecation")
        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic(
                        "neo4j",
                        "MarR3-18"

                        ));

        try (Session session = driver.session()) {

            session.writeTransaction(tx -> {
                tx.run("CREATE (user:Raza {name:'Chihuaha'})");
                tx.run("CREATE (user:Tamaño {name:'pequeño'})");
                tx.run("CREATE (user:Pelo {name:'liso'})");
                tx.run("CREATE (user:Personalidad {name:'Protector'})");
                tx.run("CREATE (user:color {name:'cafe'})");
                return null;
            });

            Result result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

            result = session.run("""
                    MATCH (p:Raza {name:"Name"}), (t:Tamaño {name:"pequeño"})
                    MERGE (p)-[e:WATCH]-(a)
                    RETURN p.name, e, a.name
                    """
            );


            while (result.hasNext()) {
                Record record = result.next();
                System.out.println(record);
            }


            result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

 

        } finally {
            driver.close();
        }
    }
}