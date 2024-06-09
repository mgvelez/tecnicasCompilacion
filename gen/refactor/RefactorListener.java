// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/refactor/Refactor.g4 by ANTLR 4.13.1
package refactor;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RefactorParser}.
 */
public interface RefactorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RefactorParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(RefactorParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(RefactorParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(RefactorParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(RefactorParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(RefactorParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(RefactorParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#programaMain}.
	 * @param ctx the parse tree
	 */
	void enterProgramaMain(RefactorParser.ProgramaMainContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#programaMain}.
	 * @param ctx the parse tree
	 */
	void exitProgramaMain(RefactorParser.ProgramaMainContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(RefactorParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(RefactorParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#listaIdent}.
	 * @param ctx the parse tree
	 */
	void enterListaIdent(RefactorParser.ListaIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#listaIdent}.
	 * @param ctx the parse tree
	 */
	void exitListaIdent(RefactorParser.ListaIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(RefactorParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(RefactorParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(RefactorParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(RefactorParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#incremento}.
	 * @param ctx the parse tree
	 */
	void enterIncremento(RefactorParser.IncrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#incremento}.
	 * @param ctx the parse tree
	 */
	void exitIncremento(RefactorParser.IncrementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(RefactorParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(RefactorParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(RefactorParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(RefactorParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(RefactorParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(RefactorParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraControl(RefactorParser.EstructuraControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraControl(RefactorParser.EstructuraControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(RefactorParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(RefactorParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#comparador}.
	 * @param ctx the parse tree
	 */
	void enterComparador(RefactorParser.ComparadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#comparador}.
	 * @param ctx the parse tree
	 */
	void exitComparador(RefactorParser.ComparadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(RefactorParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(RefactorParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(RefactorParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(RefactorParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RefactorParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(RefactorParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RefactorParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(RefactorParser.WhileStmtContext ctx);
}