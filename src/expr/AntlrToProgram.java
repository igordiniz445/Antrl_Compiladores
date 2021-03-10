package expr;

import antlr.GramaticaBaseVisitor;
import antlr.GramaticaParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends GramaticaBaseVisitor<Program> {
    public List<String> semanticErrors;
    public List<SymbleTable> symbleTable;

    @Override
    public Program visitPrograma(GramaticaParser.ProgramaContext ctx) {

        Program prog = new Program();

        semanticErrors = new ArrayList<>();

        symbleTable = new ArrayList<>();

        AntlrToExpression exprVisitor = new AntlrToExpression(semanticErrors, symbleTable);

        for (int i =0;i<ctx.getChildCount();i++){
            if (i!=ctx.getChildCount()-1){
                prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
            }
        }

        return prog;
    }

    public void printSymbleTable(){
        for (SymbleTable table : this.symbleTable) {
            System.out.println(table);
        }
    }
}
