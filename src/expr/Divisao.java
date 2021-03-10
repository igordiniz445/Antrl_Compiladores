package expr;


public class Divisao extends Expression{
    Expression left;
    Expression right;


    public Divisao(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return left.toString()+" / "+right.toString() ;
    }
}
