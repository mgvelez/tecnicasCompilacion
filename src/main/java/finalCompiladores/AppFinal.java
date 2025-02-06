package finalCompiladores;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AppFinal {

    public static void main(String[] args) {
        System.out.println("=== Iniciando análisis ===");
        try {
            // 1) Leer el archivo de entrada
            CharStream input = CharStreams.fromFileName("input/entrada.txt");

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


            // 7) Generación de código de 3 direcciones con el Visitor
            CaminanteFinal visitor = new CaminanteFinal();
            visitor.visit(tree);
            System.out.println("\n=== Código 3 Direcciones Generado ===");
            for (String line : visitor.getThreeAddressCode()) {
                System.out.println(line);
            }

            // Opcional: optimizar código
//            visitor.optimizeCode();

//            // Obtener la lista de instrucciones de 3 direcciones
//            List<String> codigo3D = visitor.getThreeAddressCode();
//
//            // Imprimir en consola
//            System.out.println("\n=== Código de Tres Direcciones ===");
//            for (String line : codigo3D) {
//                System.out.println(line);
//            }

            // 8) Generar los archivos de salida
            generateOutputFiles(visitor);

            System.out.println("\n=== Proceso de análisis y generación completado ===");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo de entrada: " + e.getMessage());
        } catch (RecognitionException e) {
            System.err.println("Error de reconocimiento durante el parseo: " + e.getMessage());
        }
    }

    /**
     * Genera los archivos de salida:
     *  1) Tabla de símbolos
     *  2) Código de tres direcciones
     *  3) Código optimizado (placeholder)
     */
    private static void generateOutputFiles(CaminanteFinal visitor) throws IOException {
        String basePath = "output/";

        // Crear/abrir el archivo de salida "codigo_tres_direcciones.txt"
        try (FileWriter writer = new FileWriter(basePath + "codigo_tres_direcciones.txt")) {
            writer.write("Código de Tres Direcciones (Three Address Code)\n");
            writer.write("----------------------------------------------\n\n");

            // Volcar línea por línea el 3AC
            for (String line : visitor.getThreeAddressCode()) {
                writer.write(line + "\n");
            }

        }

        // Llamar a optimizeCode() para modificar el threeAddressCode
        visitor.optimizeCode();

        //  Obtener la lista optimizada
        List<String> optimized3AC = visitor.getThreeAddressCode();

        // Crear/abrir el archivo de salida "codigo_optimizado.txt"
        try (FileWriter writer = new FileWriter(basePath + "codigo_optimizado.txt")) {
            writer.write("Optimización de Código Intermedio\n");
            writer.write("---------------------------------\n\n");

            // Volcar línea por línea el 3AC optimizado
            for (String line : optimized3AC) {
                writer.write(line + "\n");
            }
        }

        // Llamar a optimizeCode() para modificar el threeAddressCode
        visitor.optimizeCodeV2();

        //  Obtener la lista optimizada
        List<String> optimized3ACv2 = visitor.getThreeAddressCodeOptimizado();

        // Crear/abrir el archivo de salida "codigo_optimizado.txt"
        try (FileWriter writer = new FileWriter(basePath + "codigo_optimizado_v2.txt")) {
            writer.write("Optimización de Código Intermedio v2\n");
            writer.write("---------------------------------\n\n");

            // Volcar línea por línea el 3AC optimizado
            for (String line : optimized3ACv2) {
                writer.write(line + "\n");
            }
        }

        System.out.println("Archivos de salida generados en: " + basePath);
    }
}

