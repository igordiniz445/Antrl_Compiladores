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


}
