grammar TrabajoFinal;

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
CORA : '[' ;
CORC : ']' ;
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

STRING_LITERAL : '"' .*? '"';

NUMERO : DIGITO+ (PUNTO DIGITO*)? ;

ID : LETRA (LETRA | DIGITO | '_')* ;

programa : funcion* EOF ;

funcion : tipoDato ID PA parametros? PC bloque ;
llamadaFuncion : ID PA argumentos? PC;
argumentos : expresion (COMA expresion)* ;

parametros : parametro (COMA parametro)* ;
parametro : tipoDato ID ;

bloque : LLA (instruccion | declaracion)* LLC ;

declaracion : tipoDato listaVariables PYC ;
listaVariables : variable (COMA variable)* ;
variable :  ID (IGUAL expresion)?
           |ID array* (IGUAL expresion);

instruccion : asignacion
            | ifStmt
            | forStmt
            | whileStmt
            | returnStmt
            | bloque
            | BREAK PYC
            ;

array : CORA NUMERO CORC
      ;
accessArray : ID (CORA expresion CORC)+
            ;

asignacion : (ID | accessArray) IGUAL expresion PYC
           | incremento PYC
           ;

incremento : ID (INCREMENTO | DECREMENTO)? # IncrementoOp; // es un tag libro

expresion : term ((MAS | MENOS) term)* ;
term : factor ((MULT | DIV) factor)* ;
factor : NUMERO
       | ID
       | STRING_LITERAL
       | PA expresion PC
       | incremento
       | llamadaFuncion
       | accessArray
       ;

condicion : expresion comparador expresion ;

comparador : MENOR | MAYOR | MENIG | MAYIG | DIF | IGUALIGUAL ;

ifStmt : IF PA condicion PC instruccion (ELSE instruccion)? ;
forStmt : FOR PA (declaracion | expresion) condicion PYC expresion PC instruccion ;
whileStmt : WHILE PA condicion PC instruccion ;
returnStmt : RETURN expresion? PYC;

tipoDato : INT | FLOAT | DOUBLE | STRING | VOID ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;