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
COMA : ',';
IGUALIGUAL: '==' ;
MENOR      : '<' ;
MAYOR      : '>' ;
MENIG      : '<=' ;
MAYIG      : '>=' ;
DIF      : '!=' ;

// Operadores
MAS    : '+' ;
MENOS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;


// Palabras reservada
INT : 'int' ;
DOUBLE : 'double' ;
IF     : 'if';
ELSE   : 'else';
FOR    : 'for';
WHILE  : 'while';
BREAK  : 'break';
RETURN : 'return';
VOID   : 'void';

NUMERO : DIGITO+ ('.' DIGITO*)? ;

ID : LETRA (LETRA | DIGITO | '_')* ;

// La estructura del programa
programa : instrucciones EOF ;

instrucciones : instruccion instrucciones
              |
              ;

// Tipos de instrucciones posibles

instruccion : declaracion
            | asignacion
            | estructuraControl
            | llamadaFuncion PYC
            ;

declaracion : tipo listaIdent PYC ;

tipo        : INT | DOUBLE | VOID ;

listaIdent  : ident (COMA ident)* ;

ident       : ID (IGUAL expresion)? ;

asignacion : ID IGUAL expresion PYC ;

expresion  : expresion (MAS | MENOS | MULT | DIV) expresion
           | NUMERO
           | ID
           | llamadaFuncion
           | PA expresion PC
           ;

estructuraControl : ifStmt
                   | forStmt
                   | whileStmt
                   ;

llamadaFuncion : ID PA (expresion (COMA expresion)*)? PC ;

condicion : expresion comparador expresion ;

comparador : MENOR | MAYOR | MENIG | MAYIG | DIF | IGUALIGUAL ;


// Estructuras de control

ifStmt : IF PA condicion PC instrucciones (ELSE instrucciones)? ;
forStmt : FOR PA (declaracion | asignacion)? PYC condicion? PYC asignacion? PC instrucciones ;
whileStmt : WHILE PA condicion PC instrucciones ;
breakStmt : BREAK PYC ;

