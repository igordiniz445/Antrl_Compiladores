package expression;

import java.util.ArrayList;
import java.util.List;

public class Programa extends Expression{
    List<Expression> expressionList;

    public Programa(){
        this.expressionList = new ArrayList<>();
    }

    public void addExpression(Expression e){
        this.expressionList.add(e);
    }

    public void printExpressions(){
        System.out.println("Programa fonte:");
        for (int i=0; i<this.expressionList.size();i++){
            System.out.println(this.expressionList.get(i).toString());
        }
    }

}
