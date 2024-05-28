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
	 * Enter a parse tree produced by {@link TpUnoParser#declaracionGlobal}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionGlobal(TpUnoParser.DeclaracionGlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#declaracionGlobal}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionGlobal(TpUnoParser.DeclaracionGlobalContext ctx);
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
	 * Enter a parse tree produced by {@link TpUnoParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraControl(TpUnoParser.EstructuraControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraControl(TpUnoParser.EstructuraControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(TpUnoParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(TpUnoParser.LlamadaFuncionContext ctx);
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
	 * Enter a parse tree produced by {@link TpUnoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(TpUnoParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(TpUnoParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(TpUnoParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(TpUnoParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(TpUnoParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(TpUnoParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(TpUnoParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(TpUnoParser.ParametroContext ctx);
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
	 * Enter a parse tree produced by {@link TpUnoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TpUnoParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TpUnoParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(TpUnoParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(TpUnoParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TpUnoParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(TpUnoParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(TpUnoParser.WhileStmtContext ctx);
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
	 * Enter a parse tree produced by {@link TpUnoParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(TpUnoParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TpUnoParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(TpUnoParser.ReturnStmtContext ctx);
}