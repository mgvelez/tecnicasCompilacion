grammar Refactor;
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
PUNTO : '.';
IGUALIGUAL: '==' ;
MENOR      : '<' ;
MAYOR      : '>' ;
MENIG      : '<=' ;
MAYIG      : '>=' ;
DIF      : '!=' ;
MAIN       : 'main';

// Operadores
MAS    : '+' ;
MENOS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
INCREMENTO : '++' ;
DECREMENTO : '--' ;


// Palabras reservada
INT : 'int' ;
FLOAT : 'float' ;
DOUBLE : 'double' ;
STRING : 'String';
IF     : 'if';
ELSE   : 'else';
FOR    : 'for';
WHILE  : 'while';
BREAK  : 'break';
RETURN : 'return';
VOID   : 'void';

NUMERO : DIGITO+ (PUNTO DIGITO*)? ;

ID : LETRA (LETRA | DIGITO | '_')* ;

programa : instrucciones EOF ;

instrucciones : instruccion instrucciones
              |
              ;

instruccion : programaMain
            | LLA instrucciones LLC
            | declaracion
            | asignacion
            | estructuraControl
            | bloque
            | returnStmt
            ;

programaMain : (VOID | tipoDato) MAIN PA PC bloque;

declaracion : tipoDato (ID (IGUAL expresion)? | listaIdent) PYC ;
listaIdent  : ident (COMA ident)* ;
ident       : ID (IGUAL expresion)? ;

asignacion : ID (IGUAL expresion)? PYC
            | incremento
            ;

incremento : ID (INCREMENTO | DECREMENTO);

expresion : expresion (MAS | MENOS | MULT | DIV ) expresion
          | NUMERO
          | ID
          | PA expresion PC
          | ID IGUAL expresion
          | incremento
          | asignacion
          | listaIdent
          ;

bloque : LLA instrucciones LLC ;

tipoDato : INT | FLOAT | DOUBLE | STRING ;

estructuraControl :  ifStmt
                   | forStmt
                   | whileStmt
                   ;

condicion : expresion comparador expresion ;

comparador : MENOR | MAYOR | MENIG | MAYIG | DIF | IGUALIGUAL ;

ifStmt : IF PA condicion PC instruccion (ELSE instruccion)? ;
forStmt : FOR PA declaracion condicion PYC expresion PC instruccion ;
whileStmt : WHILE PA condicion PC bloque ;
returnStmt : RETURN expresion PYC;