package expr;

public class Expressao extends Expression{
    Expression left;

    public Expressao(Expression left){
        this.left = left;
    }

    @Override
    public String toString() {
        return left.toString()+";";
    }
}
