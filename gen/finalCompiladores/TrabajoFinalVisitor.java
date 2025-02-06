// Generated from /Users/matias/Documents/universidad/TC/FINAL/tecnicasCompilacion/src/main/java/finalCompiladores/TrabajoFinal.g4 by ANTLR 4.13.1
package finalCompiladores;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TrabajoFinalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TrabajoFinalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(TrabajoFinalParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(TrabajoFinalParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(TrabajoFinalParser.LlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(TrabajoFinalParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(TrabajoFinalParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(TrabajoFinalParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(TrabajoFinalParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(TrabajoFinalParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#listaVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaVariables(TrabajoFinalParser.ListaVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TrabajoFinalParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(TrabajoFinalParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(TrabajoFinalParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#accessArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessArray(TrabajoFinalParser.AccessArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#inicializacionArreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacionArreglo(TrabajoFinalParser.InicializacionArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(TrabajoFinalParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncrementoOp}
	 * labeled alternative in {@link TrabajoFinalParser#incremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementoOp(TrabajoFinalParser.IncrementoOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(TrabajoFinalParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(TrabajoFinalParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TrabajoFinalParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(TrabajoFinalParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#comparador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparador(TrabajoFinalParser.ComparadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TrabajoFinalParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(TrabajoFinalParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(TrabajoFinalParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(TrabajoFinalParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrabajoFinalParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(TrabajoFinalParser.TipoDatoContext ctx);
}