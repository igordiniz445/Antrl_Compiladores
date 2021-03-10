grammar Gramatica;

@header{
    package antlr;
}

prog: (decl|expr)+ EOF #Programa
    ;
decl: TYPE ID'='NUM ';'     #Declaracao
    ;
expr: expr'+'expr      #Soma
    | NUM            #Numero
    | ID              #Variavel
    | expr '*' expr    #Multiplicacao
    | expr '/' expr    #Divisao
    | expr '-' expr    #Subtracao
    | expr ';'  #ExpressaoFinal
    ;

TYPE: ('int'|'float');
ID:([a-z]|[A-Z])+;
WS:[ \r\t\n]* ->skip;
NUM: [0-9]+('.'[0-9]+)?;