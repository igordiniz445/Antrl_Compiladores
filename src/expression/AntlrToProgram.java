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

    @Override
    public Programa visitDeclaracao(GramaticaParser.DeclaracaoContext ctx) {
        return super.visitDeclaracao(ctx);
    }

    @Override
    public Programa visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx) {
        return super.visitMultiplicacao(ctx);
    }

    @Override
    public Programa visitDivisao(GramaticaParser.DivisaoContext ctx) {
        return super.visitDivisao(ctx);
    }

    @Override
    public Programa visitSubtracao(GramaticaParser.SubtracaoContext ctx) {
        return super.visitSubtracao(ctx);
    }

    @Override
    public Programa visitNumero(GramaticaParser.NumeroContext ctx) {
        return super.visitNumero(ctx);
    }

    @Override
    public Programa visitVariavel(GramaticaParser.VariavelContext ctx) {
        return super.visitVariavel(ctx);
    }

    @Override
    public Programa visitSoma(GramaticaParser.SomaContext ctx) {
        return super.visitSoma(ctx);
    }
}
