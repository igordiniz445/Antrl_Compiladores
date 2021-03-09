package expression;

import antlr.GramaticaBaseVisitor;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AntlrToExpression extends GramaticaBaseVisitor<Expression> {

    private List<String> declaredVariables;

    /*
     * Semantic Errors:
     * (1) Duplicate variable declaration;
     * (2) Variable not declared.
     * (3) Type conflict
     * */
    private List<String> semanticErrors;

    public AntlrToExpression(List<String> semanticErrors) {
        declaredVariables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaracao(GramaticaParser.DeclaracaoContext ctx) {
        Token token = ctx.TYPE().getSymbol();
        int linha = token.getLine();
        int coluna = token.getCharPositionInLine();
        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();
        String value = ctx.NUM().getText();
        System.out.println("Visitou Declaracao");
        System.out.println(id + " " + type + " " + value);
        Declaracao decl = new Declaracao(id,type);
        String expectedType;
        if (value.matches("[0-9]*\\.[0-9]+")){
            expectedType= "float";
            decl.fvalue=Float.parseFloat(value);

        }
        else{
            expectedType= "int";
            decl.ivalue=Integer.parseInt(value);
        }
        if (!Objects.equals(type,expectedType)){
            semanticErrors.add("Erro: Variável " + id + " é "+type+", mas o valor atribuído é "+expectedType+" (" + linha + "," + coluna + ").");
        }
            return decl;
    }


    @Override
    public Expression visitNumero(GramaticaParser.NumeroContext ctx) {
        String numtxt = ctx.getChild(0).getText();
        if(numtxt.matches("[-+]?[0-9]*\\.[0-9]+")){
            return new Numero(Float.parseFloat(numtxt));
        }
        else{
            return new Numero(Integer.parseInt(numtxt));
        }

    }

    @Override
    public Expression visitVariavel(GramaticaParser.VariavelContext ctx) {
        String id=ctx.getChild(0).getText();
        return new Variavel(id);
    }


    @Override
    public Expression visitSoma(GramaticaParser.SomaContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Soma soma = new Soma(left,right);
        if (left.type=="int" && right.type=="int"){
            soma.setType("int");
        }
        else{
            soma.setType("float");
        }
        return  soma;
    }

    @Override
    public Expression visitPrograma(GramaticaParser.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }

    @Override
    public Expression visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Multiplicacao multiplicacao = new Multiplicacao(left,right);
        if (left.type=="int" && right.type=="int"){
            multiplicacao.setType("int");
        }
        else{
            multiplicacao.setType("float");
        }
        return  multiplicacao;
    }

    @Override
    public Expression visitDivisao(GramaticaParser.DivisaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Divisao divisao = new Divisao(left,right);
        if (left.type=="int" && right.type=="int"){
            divisao.setType("int");
        }else if (right.toString().equals("0")){
            semanticErrors.add("Não é possível realizar divisão por 0");
        }else{
            divisao.setType("float");
        }
        return  divisao;
    }

    @Override
    public Expression visitSubtracao(GramaticaParser.SubtracaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Subtracao subtracao = new Subtracao(left,right);
        if (left.type=="int" && right.type=="int"){
            subtracao.setType("int");
        }
        else{
            subtracao.setType("float");
        }
        return  subtracao;
    }
}
