// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/tpuno/TpUno.g4 by ANTLR 4.13.1
package tpuno;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TpUnoParser}.
 */
public interface TpUnoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(TpUnoParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(TpUnoParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(TpUnoParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(TpUnoParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(TpUnoParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(TpUnoParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(TpUnoParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(TpUnoParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(TpUnoParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(TpUnoParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#listaIdent}.
	 * @param ctx the parse tree
	 */
	void enterListaIdent(TpUnoParser.ListaIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#listaIdent}.
	 * @param ctx the parse tree
	 */
	void exitListaIdent(TpUnoParser.ListaIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(TpUnoParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(TpUnoParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(TpUnoParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(TpUnoParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(TpUnoParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(TpUnoParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#iwhile}.
	 * @param ctx the parse tree
	 */
	void enterIwhile(TpUnoParser.IwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#iwhile}.
	 * @param ctx the parse tree
	 */
	void exitIwhile(TpUnoParser.IwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(TpUnoParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(TpUnoParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#comparador}.
	 * @param ctx the parse tree
	 */
	void enterComparador(TpUnoParser.ComparadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#comparador}.
	 * @param ctx the parse tree
	 */
	void exitComparador(TpUnoParser.ComparadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(TpUnoParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(TpUnoParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TpUnoParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TpUnoParser.IfStmtContext ctx);
}