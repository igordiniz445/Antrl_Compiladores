package expr;

public class Id extends Expression{
    String name;

    public Id(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }

}
