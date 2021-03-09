package expression;

public class Soma extends Expression {
    Expression left;
    Expression right;


    public Soma(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return left.toString()+" + "+right.toString();
    }

}
