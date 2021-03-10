package expr;

public class Multiplicacao extends Expression{

    Expression left;
    Expression right;


    public Multiplicacao(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return left.toString()+" * "+right.toString();
    }
    
}
