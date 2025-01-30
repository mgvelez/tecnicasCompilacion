// Generated from D:/UNI/9° SEMESTRE/TC/finalTc/v1/tecnicasCompilacion/src/main/java/finalCompiladores/TrabajoFinal.g4 by ANTLR 4.13.1
package finalCompiladores;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TrabajoFinalParser}.
 */
public interface TrabajoFinalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(TrabajoFinalParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(TrabajoFinalParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(TrabajoFinalParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(TrabajoFinalParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(TrabajoFinalParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(TrabajoFinalParser.LlamadaFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(TrabajoFinalParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(TrabajoFinalParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(TrabajoFinalParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(TrabajoFinalParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(TrabajoFinalParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(TrabajoFinalParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(TrabajoFinalParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(TrabajoFinalParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(TrabajoFinalParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(TrabajoFinalParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#listaVariables}.
	 * @param ctx the parse tree
	 */
	void enterListaVariables(TrabajoFinalParser.ListaVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#listaVariables}.
	 * @param ctx the parse tree
	 */
	void exitListaVariables(TrabajoFinalParser.ListaVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TrabajoFinalParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TrabajoFinalParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(TrabajoFinalParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(TrabajoFinalParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(TrabajoFinalParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(TrabajoFinalParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#accessArray}.
	 * @param ctx the parse tree
	 */
	void enterAccessArray(TrabajoFinalParser.AccessArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#accessArray}.
	 * @param ctx the parse tree
	 */
	void exitAccessArray(TrabajoFinalParser.AccessArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(TrabajoFinalParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(TrabajoFinalParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncrementoOp}
	 * labeled alternative in {@link TrabajoFinalParser#incremento}.
	 * @param ctx the parse tree
	 */
	void enterIncrementoOp(TrabajoFinalParser.IncrementoOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncrementoOp}
	 * labeled alternative in {@link TrabajoFinalParser#incremento}.
	 * @param ctx the parse tree
	 */
	void exitIncrementoOp(TrabajoFinalParser.IncrementoOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(TrabajoFinalParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(TrabajoFinalParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TrabajoFinalParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TrabajoFinalParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TrabajoFinalParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TrabajoFinalParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(TrabajoFinalParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(TrabajoFinalParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#comparador}.
	 * @param ctx the parse tree
	 */
	void enterComparador(TrabajoFinalParser.ComparadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#comparador}.
	 * @param ctx the parse tree
	 */
	void exitComparador(TrabajoFinalParser.ComparadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TrabajoFinalParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TrabajoFinalParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(TrabajoFinalParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(TrabajoFinalParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(TrabajoFinalParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(TrabajoFinalParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(TrabajoFinalParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(TrabajoFinalParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TrabajoFinalParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(TrabajoFinalParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrabajoFinalParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(TrabajoFinalParser.TipoDatoContext ctx);
}