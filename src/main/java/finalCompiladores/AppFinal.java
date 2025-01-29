package finalCompiladores;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class AppFinal {

    public static void main(String[] args) {
        System.out.println("=== Iniciando análisis ===");
        try {
            // 1) Leer el archivo de entrada
            CharStream input = CharStreams.fromFileName("input/trabajoFinal.txt");

            // 2) Crear el lexer y tokenizar
            TrabajoFinalLexer lexer = new TrabajoFinalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // 3) Crear el parser
            TrabajoFinalParser parser = new TrabajoFinalParser(tokens);

            // Remover error listeners por defecto y agregar uno personalizado
            parser.removeErrorListeners();

            // 4) Iniciar el parse: regla inicial "programa"
            ParseTree tree = parser.programa();

            // 5) Crear y ejecutar el Listener para Análisis Semántico
            EscuchaFinal escuchaFinal = new EscuchaFinal();

            // Recorre el árbol con el Listener
            ParseTreeWalker.DEFAULT.walk(escuchaFinal, tree);

            // 6) Revisar si hubo errores semánticos
            String semanticErrors = escuchaFinal.getErrors();
            if (!semanticErrors.isEmpty()) {
                System.err.println("\n=== Errores semánticos encontrados ===");
                System.err.println(semanticErrors);
            } else {
                System.out.println("\n=== No se encontraron errores semánticos ===");
            }

            // 6-bis) Revisar si hubo errores sintacticos
            String sintacticErrors = escuchaFinal.getErrorSintactico();
            if (!sintacticErrors.isEmpty()) {
                System.err.println("\n=== Errores sintacticos encontrados ===");
                System.err.println(sintacticErrors);
            } else {
                System.out.println("\n=== No se encontraron errores sintacticos ===");
            }

            System.out.println("\n=== Proceso de análisis y generación completado ===");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo de entrada: " + e.getMessage());
        } catch (RecognitionException e) {
            System.err.println("Error de reconocimiento durante el parseo: " + e.getMessage());
        }
    }
}
