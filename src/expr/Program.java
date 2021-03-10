package expr;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public List<Expression> expressions;


    public Program() {
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expression e){
        this.expressions.add(e);
    }

    public void printExpressions(){
        System.out.println("Programa fonte:");
        for (int i=0; i<this.expressions.size();i++){
            System.out.println(this.expressions.get(i).toString());
        }
    }


}
