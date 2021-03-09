grammar Gramatica;

@header{
    package antlr;
}

prog: (decl|expr)+ EOF #Programa
    ;
decl: TYPE ID'='NUM     #Declaracao
    ;
mult: expr '*' expr     #Multiplicacao
    ;
div: expr '/' expr     #Divisao
    ;
sub: expr '-' expr     #Subtracao
    ;
expr: expr'+'expr       #Soma
    | NUM               #Numero
    | ID                #Variavel
    ;

TYPE: ('int'|'float');
ID:([a-z]|[A-Z])+;
WS:[ \r\t\n]* ->skip;
NUM: [0-9]+('.'[0-9]+)?;