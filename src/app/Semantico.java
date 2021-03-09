package app;

import antlr.GramaticaLexer;
import antlr.GramaticaParser;
import expression.AntlrToProgram;
import expression.Programa;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Semantico {

    public static void main(String[] args) {
        
            
            GramaticaParser parser = getParser("src\\test\\teste1.txt");
            System.out.println("PEGOU O ARQUIVO");

            ParseTree ast = parser.prog();
            System.out.println("Gerou a arvore");
            AntlrToProgram progVisitor = new AntlrToProgram();
            System.out.println("***Visitando AST");
            Programa prog = progVisitor.visit(ast);

            if(progVisitor.semanticError.isEmpty()){
                System.out.println("Resultado da Análise: OK");
            }
            else {
                System.out.println("Resultado da Análise: "+progVisitor.semanticError.size()+ "erros encontrados");
                for(String err: progVisitor.semanticError){
                    System.out.println(err);
                }
            }


        

    }

    private static GramaticaParser getParser(String fileName) {
        GramaticaParser parser = null;

        try{
            CharStream input = CharStreams.fromFileName(fileName);
            GramaticaLexer lexer = new GramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GramaticaParser(tokens);
        } catch (IOException e){
            e.printStackTrace();
        }

        return parser;
    }

}
