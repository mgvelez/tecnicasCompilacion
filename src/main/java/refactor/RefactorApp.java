package refactor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class RefactorApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Refactor!!!");
        // create a CharStream that reads from file
        CharStream input = CharStreams.fromFileName("input/entrada.txt");

        // create a lexer that feeds off of input CharStream
        RefactorLexer lexer = new RefactorLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RefactorParser parser = new RefactorParser(tokens);

        // create Listener
        RefactorBaseListener escuchaRefactor = new EscuchaRefactor();

        // Conecto el objeto con Listeners al parser
        parser.addParseListener(escuchaRefactor);

        // Solicito al parser que comience indicando una regla gramatical
        // En este caso la regla es el simbolo inicial
        // parser.s();
        // ParseTree tree =  parser.s();
        ParseTree tree =  parser.programa();
        //System.out.println(tree.toStringTree(parser));
        // Conectamos el visitor
        // Caminante visitor = new Caminante();
        // visitor.visit(tree);
        // System.out.println(visitor);
        // System.out.println(visitor.getErrorNodes());
        // Imprime el arbol obtenido
        System.out.println("ChauTP, Tp2!!!");
        //System.out.println(escuchaTpUno);
        // System.out.println(tree.toStringTree(parser));
        // System.out.println(escucha);

    }
}
