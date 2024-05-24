grammar TpUno;
/*
@header {
package compiladores;
}*/

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

// Tokens
WS : [ \t\r\n]+ -> skip ;
PA : '(' ;
PC : ')' ;
LLA : '{' ;
LLC : '}' ;
PYC : ';' ;
IGUAL : '=' ;
COMMA : ',';
IGUALIGUAL: '==' ;

// Operadores
LT      : '<' ;
GT      : '>' ;
EQ      : '==' ;
LE      : '<=' ;
GE      : '>=' ;
NE      : '!=' ;


// Palabras reservada
INT : 'int' ;
DOUBLE : 'double' ;
IF : 'if';
BREAK : 'break';

NUMERO : DIGITO+ ('.' DIGITO*)? ;
ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;

programa : instrucciones EOF ;

instrucciones : instruccion instrucciones
              |
              ;

instruccion : declaracion
            | asignacion
            | iwhile
            | ifStmt
            | breakStmt
            ;

declaracion : tipo listaIdent PYC ;
tipo        : INT | DOUBLE ;
listaIdent  : ident (COMMA ident)* ;
ident       : ID (IGUAL expresion)? ;

asignacion : ID IGUAL expresion PYC ;

expresion  : NUMERO
           | ID
           ;

iwhile : 'while' PA condicion PC LLA instrucciones LLC ;
condicion : expresion comparador expresion ;
comparador : '<' | '>' | EQ | '<=' | '>=' | '!=' ;

breakStmt : BREAK PYC ;
ifStmt : IF PA condicion PC LLA instrucciones LLC;
