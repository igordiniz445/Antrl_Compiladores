package expr;

import java.util.HashMap;
import java.util.Map;

public class SymbleTable {

    public static int ENDERECO = 0;

    private String posicao;
    private String tipo;
    private String simbolo;


    public SymbleTable() {
        ENDERECO += 1;
    }

    @Override
    public String toString(){
        return "Posicao Memoria: "+this.posicao+ " Tipo: "+this.tipo+ " Simbolo: "+ this.simbolo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String id) {
        this.posicao = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String valor) {
        this.simbolo = valor;
    }
}
