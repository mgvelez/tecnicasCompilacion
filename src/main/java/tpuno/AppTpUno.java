package tpuno;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// Las diferentes entradas se explicaran oportunamente
public class AppTpUno {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Tp1!!!");
        // create a CharStream that reads from file
        CharStream input = CharStreams.fromFileName("input/tpUno.txt");

        // create a lexer that feeds off of input CharStream
       TpUnoLexer lexer = new tpuno.TpUnoLexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        TpUnoParser parser = new tpuno.TpUnoParser(tokens);
                
        // create Listener
        TpUnoBaseListener escucha = new EscuchaTpUno();

        // Conecto el objeto con Listeners al parser
        parser.addParseListener(escucha);

        // Solicito al parser que comience indicando una regla gramatical
        // En este caso la regla es el simbolo inicial
        // parser.s();
        // ParseTree tree =  parser.s();
        ParseTree tree =  parser.programa();
        // Conectamos el visitor
        // Caminante visitor = new Caminante();
        // visitor.visit(tree);
        // System.out.println(visitor);
        // System.out.println(visitor.getErrorNodes());
        // Imprime el arbol obtenido
        System.out.println("ChauTP1, Tp1!!!");
        System.out.println(escucha);
        // System.out.println(tree.toStringTree(parser));
        // System.out.println(escucha);
        
    }
}
