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
programa : (funcion | declaracionGlobal)* EOF ;

declaracionGlobal : tipo listaIdent PYC ;

instrucciones : instruccion instrucciones
              |
              ;

instruccion : declaracion
            | asignacion
            | estructuraControl
            | bloque
            | llamadaFuncion PYC
            | returnStmt
            ;

declaracion : tipo listaIdent PYC ;
asignacion : ID IGUAL expresion PYC ;

estructuraControl :  ifStmt
                   | forStmt
                   | whileStmt
                   ;

llamadaFuncion : ID PA expresion PC ;

tipo        : INT | DOUBLE | VOID ;

listaIdent  : ident (COMA ident)* ;

ident       : ID (IGUAL expresion)? ;

expresion : expresion (MAS | MENOS | MULT | DIV ) expresion
          | NUMERO
          | ID
          | llamadaFuncion
          | PA expresion PC
          ;

bloque : LLA instrucciones LLC ;

funcion : tipo ID PA parametros PC bloque ;

parametros : parametro (COMA parametro)*
            |
            ;
parametro  : tipo ID ;

condicion : expresion comparador expresion ;

comparador : MENOR | MAYOR | MENIG | MAYIG | DIF | IGUALIGUAL ;


// Estructuras de control

ifStmt : IF PA condicion PC instruccion (ELSE instruccion)? ;
forStmt : FOR PA asignacion condicion PYC asignacion PC instruccion ;
whileStmt : WHILE PA condicion PC instruccion ;
breakStmt : BREAK PYC ;
returnStmt : RETURN expresion PYC;

