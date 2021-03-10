package expr;

public class Numero extends Expression{
    float fvalue;
    int ivalue;


    public Numero(int value){
        this.ivalue=value;
        this.type="int";
    }

    public Numero(float value){
        this.fvalue=value;
        this.type="real";
    }

    @Override
    public String toString() {
        if (type=="int"){
            return Integer.toString(ivalue);
        }
        else {
            return Float.toString(fvalue);
        }
    }
}
