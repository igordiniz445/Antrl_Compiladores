package expression;


public class Subtracao extends Expression{
    Expression left;
    Expression right;


    public Subtracao(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return left.toString()+" - "+right.toString();
    }
}