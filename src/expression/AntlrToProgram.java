package expression;

import antlr.GramaticaBaseVisitor;
import antlr.GramaticaParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends GramaticaBaseVisitor<Programa> {


    public List<String> semanticError;

    @Override
    public Programa visitPrograma(GramaticaParser.ProgramaContext ctx) {
        Programa prog = new Programa();

        semanticError= new ArrayList<>();

        AntlrToExpression exprVisitor = new AntlrToExpression(semanticError);

        for(int i=0; i<ctx.getChildCount()-1;i++){
            prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
        }

        return prog;

    }


}
