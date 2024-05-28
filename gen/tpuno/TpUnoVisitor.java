// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/tpuno/TpUno.g4 by ANTLR 4.13.1
package tpuno;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TpUnoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TpUnoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(TpUnoParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#declaracionGlobal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionGlobal(TpUnoParser.DeclaracionGlobalContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(TpUnoParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(TpUnoParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(TpUnoParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(TpUnoParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#estructuraControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraControl(TpUnoParser.EstructuraControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(TpUnoParser.LlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(TpUnoParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#listaIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIdent(TpUnoParser.ListaIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(TpUnoParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(TpUnoParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(TpUnoParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(TpUnoParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(TpUnoParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(TpUnoParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(TpUnoParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#comparador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparador(TpUnoParser.ComparadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TpUnoParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(TpUnoParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(TpUnoParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(TpUnoParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TpUnoParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(TpUnoParser.ReturnStmtContext ctx);
}