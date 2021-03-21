package expr;

import antlr.GramaticaBaseVisitor;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AntlrToExpression extends GramaticaBaseVisitor<Expression> {
    private List<String> declaredVariables;

    private List<String> semanticErrors;

    private List<SymbleTable> symbleTable;

    public AntlrToExpression(List<String> semanticErrors, List<SymbleTable> symbleTable) {
        declaredVariables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
        this.symbleTable=symbleTable;
    }


    @Override
    public Expression visitPrograma(GramaticaParser.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
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
        }else{
            expectedType= "int";
            decl.ivalue=Integer.parseInt(value);
        }
        if(this.hasVariable(id)){
            semanticErrors.add("Erro: variável "+id+" já foi declarada.");
        }else{
            addVariables(id);
        }
        //@TODO : ARRUMAR VARIAVEIS JA DECLARADAS
        if (!Objects.equals(type,expectedType)){
            semanticErrors.add("Erro: Variável " + id + " é "+type+", mas o valor atribuído é "+expectedType+" (" + linha + "," + coluna + ").");
        }

        SymbleTable simb = new SymbleTable();
        simb.setSimbolo(decl.id);
        simb.setTipo(decl.type);
        simb.setPosicao(String.valueOf(SymbleTable.ENDERECO));
        symbleTable.add(simb);
        return decl;
    }

    @Override
    public Expression visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Multiplicacao multiplicacao = new Multiplicacao(left,right);
        /*Verificação de tipos antes de realizar a expressão*/
        if (left.type=="int" && right.type=="int"){
            multiplicacao.setType("int");
        }
        else{
            multiplicacao.setType("float");
        }
        return  multiplicacao;
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
        /*Verificação de tipos antes de realizar a expressão*/
        if (left.type=="int" && right.type=="int"){
            soma.setType("int");
        }
        else{
            soma.setType("float");
        }
        return  soma;
    }

    @Override
    public Expression visitSubtracao(GramaticaParser.SubtracaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Subtracao subtracao = new Subtracao(left,right);
        /*Verificação de tipos antes de realizar a expressão*/
        if (left.type=="int" && right.type=="int"){
            subtracao.setType("int");
        }
        else{
            subtracao.setType("float");
        }
        return  subtracao;
    }

    @Override
    public Expression visitDivisao(GramaticaParser.DivisaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Divisao divisao = new Divisao(left,right);
        /*Verificação de tipos antes de realizar a expressão*/
        if (left.type=="int" && right.type=="int"){
            divisao.setType("int");
        }else if (right.toString().equals("0")){
            /*Verificação se o divisor é diferente de 0*/ 
            semanticErrors.add("Não é possível realizar divisão por 0");
        }else{
            divisao.setType("float");
        }
        return  divisao;
    }

    @Override
    public Expression visitExpressaoFinal(GramaticaParser.ExpressaoFinalContext ctx) {
        Expressao x = new Expressao(visit(ctx.getChild(0)));
        return x;
    }

    public void addVariables(String variable){
        this.declaredVariables.add(variable);
    }

    public boolean hasVariable(String id){
        return declaredVariables.contains(id);
    }
}
