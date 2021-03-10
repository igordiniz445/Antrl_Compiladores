package app;

import antlr.GramaticaLexer;
import antlr.GramaticaParser;
import expr.AntlrToProgram;
import expr.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class SemanticoTeste {
    public static void main(String[] args) {

        String fileName = "src\\test\\programaA.txt";
        GramaticaParser parser = getParser(fileName);

        System.out.println("Parser:\n"+parser);
        ParseTree antlrAST = parser.prog();

        System.out.println("Codigo:\n"+antlrAST);

        AntlrToProgram progVisitor = new AntlrToProgram();
        Program progFonte = progVisitor.visit(antlrAST);
        progFonte.printExpressions();

        if (progVisitor.semanticErrors.isEmpty()) {
            System.out.println("***Resultado da Analise: OK");
        } else {
            System.out.println("***Resultado da Analise: " + progVisitor.semanticErrors.size() + " erros encontrados");
            for (String err : progVisitor.semanticErrors) {
                System.out.println(err);
            }

        }
        progVisitor.printSymbleTable();


    }


    private static GramaticaParser getParser(String fileName) {
            GramaticaParser parser = null;

            try {
                CharStream input = CharStreams.fromFileName(fileName);
                GramaticaLexer lexer = new GramaticaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                parser = new GramaticaParser(tokens);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return parser;
    }
}

