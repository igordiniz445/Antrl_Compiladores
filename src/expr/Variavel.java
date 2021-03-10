package expr;

public class Variavel extends Expression {
    String id;

    public Variavel(String id){
        this.id=id;
    }

    @Override
    public String toString() {
        return id;
    }
}
