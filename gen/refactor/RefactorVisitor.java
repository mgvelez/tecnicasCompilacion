// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/refactor/Refactor.g4 by ANTLR 4.13.1
package refactor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RefactorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RefactorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RefactorParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(RefactorParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(RefactorParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(RefactorParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#programaMain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramaMain(RefactorParser.ProgramaMainContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(RefactorParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#listaIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIdent(RefactorParser.ListaIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(RefactorParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(RefactorParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#incremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncremento(RefactorParser.IncrementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(RefactorParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(RefactorParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(RefactorParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#estructuraControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraControl(RefactorParser.EstructuraControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(RefactorParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#comparador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparador(RefactorParser.ComparadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(RefactorParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(RefactorParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RefactorParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(RefactorParser.WhileStmtContext ctx);
}