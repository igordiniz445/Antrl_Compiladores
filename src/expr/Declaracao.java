package expr;

public class Declaracao extends Expression{
    String id;
    Float fvalue;
    int ivalue;

    public Declaracao(String id, String type){
        this.id=id;
        this.type=type;
    }


    @Override
    public String toString() {
        if (type.equals("int")){
            return type+" "+id+"="+ivalue + ";";
        }
        else {
            return type+" "+id+"="+fvalue + ";";
        }
    }
}
