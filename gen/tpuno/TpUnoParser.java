// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/tpuno/TpUno.g4 by ANTLR 4.13.1
package tpuno;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TpUnoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PA=2, PC=3, LLA=4, LLC=5, PYC=6, IGUAL=7, COMA=8, IGUALIGUAL=9, 
		MENOR=10, MAYOR=11, MENIG=12, MAYIG=13, DIF=14, MAS=15, MENOS=16, MULT=17, 
		DIV=18, INT=19, DOUBLE=20, IF=21, ELSE=22, FOR=23, WHILE=24, BREAK=25, 
		RETURN=26, VOID=27, NUMERO=28, ID=29;
	public static final int
		RULE_programa = 0, RULE_declaracionGlobal = 1, RULE_instrucciones = 2, 
		RULE_instruccion = 3, RULE_declaracion = 4, RULE_asignacion = 5, RULE_estructuraControl = 6, 
		RULE_llamadaFuncion = 7, RULE_tipo = 8, RULE_listaIdent = 9, RULE_ident = 10, 
		RULE_expresion = 11, RULE_bloque = 12, RULE_funcion = 13, RULE_parametros = 14, 
		RULE_parametro = 15, RULE_condicion = 16, RULE_comparador = 17, RULE_ifStmt = 18, 
		RULE_forStmt = 19, RULE_whileStmt = 20, RULE_breakStmt = 21, RULE_returnStmt = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracionGlobal", "instrucciones", "instruccion", "declaracion", 
			"asignacion", "estructuraControl", "llamadaFuncion", "tipo", "listaIdent", 
			"ident", "expresion", "bloque", "funcion", "parametros", "parametro", 
			"condicion", "comparador", "ifStmt", "forStmt", "whileStmt", "breakStmt", 
			"returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'", "'{'", "'}'", "';'", "'='", "','", "'=='", 
			"'<'", "'>'", "'<='", "'>='", "'!='", "'+'", "'-'", "'*'", "'/'", "'int'", 
			"'double'", "'if'", "'else'", "'for'", "'while'", "'break'", "'return'", 
			"'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "PA", "PC", "LLA", "LLC", "PYC", "IGUAL", "COMA", "IGUALIGUAL", 
			"MENOR", "MAYOR", "MENIG", "MAYIG", "DIF", "MAS", "MENOS", "MULT", "DIV", 
			"INT", "DOUBLE", "IF", "ELSE", "FOR", "WHILE", "BREAK", "RETURN", "VOID", 
			"NUMERO", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TpUno.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TpUnoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TpUnoParser.EOF, 0); }
		public List<FuncionContext> funcion() {
			return getRuleContexts(FuncionContext.class);
		}
		public FuncionContext funcion(int i) {
			return getRuleContext(FuncionContext.class,i);
		}
		public List<DeclaracionGlobalContext> declaracionGlobal() {
			return getRuleContexts(DeclaracionGlobalContext.class);
		}
		public DeclaracionGlobalContext declaracionGlobal(int i) {
			return getRuleContext(DeclaracionGlobalContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135790592L) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					funcion();
					}
					break;
				case 2:
					{
					setState(47);
					declaracionGlobal();
					}
					break;
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionGlobalContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ListaIdentContext listaIdent() {
			return getRuleContext(ListaIdentContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public DeclaracionGlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionGlobal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterDeclaracionGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitDeclaracionGlobal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitDeclaracionGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionGlobalContext declaracionGlobal() throws RecognitionException {
		DeclaracionGlobalContext _localctx = new DeclaracionGlobalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracionGlobal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			tipo();
			setState(56);
			listaIdent();
			setState(57);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionesContext extends ParserRuleContext {
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instrucciones);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LLA:
			case INT:
			case DOUBLE:
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case VOID:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				instruccion();
				setState(60);
				instrucciones();
				}
				break;
			case LLC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public EstructuraControlContext estructuraControl() {
			return getRuleContext(EstructuraControlContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruccion);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				estructuraControl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				bloque();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				llamadaFuncion();
				setState(70);
				match(PYC);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				returnStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ListaIdentContext listaIdent() {
			return getRuleContext(ListaIdentContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			tipo();
			setState(76);
			listaIdent();
			setState(77);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(TpUnoParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
			setState(80);
			match(IGUAL);
			setState(81);
			expresion(0);
			setState(82);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EstructuraControlContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public EstructuraControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructuraControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterEstructuraControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitEstructuraControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitEstructuraControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstructuraControlContext estructuraControl() throws RecognitionException {
		EstructuraControlContext _localctx = new EstructuraControlContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_estructuraControl);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				ifStmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				forStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				whileStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaFuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public LlamadaFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterLlamadaFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitLlamadaFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitLlamadaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaFuncionContext llamadaFuncion() throws RecognitionException {
		LlamadaFuncionContext _localctx = new LlamadaFuncionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_llamadaFuncion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(ID);
			setState(90);
			match(PA);
			setState(91);
			expresion(0);
			setState(92);
			match(PC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TpUnoParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TpUnoParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(TpUnoParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 135790592L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaIdentContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(TpUnoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(TpUnoParser.COMA, i);
		}
		public ListaIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterListaIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitListaIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitListaIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaIdentContext listaIdent() throws RecognitionException {
		ListaIdentContext _localctx = new ListaIdentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listaIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			ident();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(97);
				match(COMA);
				setState(98);
				ident();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(TpUnoParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(105);
				match(IGUAL);
				setState(106);
				expresion(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(TpUnoParser.NUMERO, 0); }
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public TerminalNode MAS() { return getToken(TpUnoParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(TpUnoParser.MENOS, 0); }
		public TerminalNode MULT() { return getToken(TpUnoParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(TpUnoParser.DIV, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(110);
				match(NUMERO);
				}
				break;
			case 2:
				{
				setState(111);
				match(ID);
				}
				break;
			case 3:
				{
				setState(112);
				llamadaFuncion();
				}
				break;
			case 4:
				{
				setState(113);
				match(PA);
				setState(114);
				expresion(0);
				setState(115);
				match(PC);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpresionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expresion);
					setState(119);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(120);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(121);
					expresion(6);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LLA() { return getToken(TpUnoParser.LLA, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode LLC() { return getToken(TpUnoParser.LLC, 0); }
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bloque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(LLA);
			setState(128);
			instrucciones();
			setState(129);
			match(LLC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			tipo();
			setState(132);
			match(ID);
			setState(133);
			match(PA);
			setState(134);
			parametros();
			setState(135);
			match(PC);
			setState(136);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(TpUnoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(TpUnoParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parametros);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				parametro();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(139);
					match(COMA);
					setState(140);
					parametro();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			tipo();
			setState(150);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ComparadorContext comparador() {
			return getRuleContext(ComparadorContext.class,0);
		}
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitCondicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitCondicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			expresion(0);
			setState(153);
			comparador();
			setState(154);
			expresion(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparadorContext extends ParserRuleContext {
		public TerminalNode MENOR() { return getToken(TpUnoParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(TpUnoParser.MAYOR, 0); }
		public TerminalNode MENIG() { return getToken(TpUnoParser.MENIG, 0); }
		public TerminalNode MAYIG() { return getToken(TpUnoParser.MAYIG, 0); }
		public TerminalNode DIF() { return getToken(TpUnoParser.DIF, 0); }
		public TerminalNode IGUALIGUAL() { return getToken(TpUnoParser.IGUALIGUAL, 0); }
		public ComparadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterComparador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitComparador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitComparador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparadorContext comparador() throws RecognitionException {
		ComparadorContext _localctx = new ComparadorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TpUnoParser.IF, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TpUnoParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IF);
			setState(159);
			match(PA);
			setState(160);
			condicion();
			setState(161);
			match(PC);
			setState(162);
			instruccion();
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(163);
				match(ELSE);
				setState(164);
				instruccion();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(TpUnoParser.FOR, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public List<AsignacionContext> asignacion() {
			return getRuleContexts(AsignacionContext.class);
		}
		public AsignacionContext asignacion(int i) {
			return getRuleContext(AsignacionContext.class,i);
		}
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(FOR);
			setState(168);
			match(PA);
			setState(169);
			asignacion();
			setState(170);
			condicion();
			setState(171);
			match(PYC);
			setState(172);
			asignacion();
			setState(173);
			match(PC);
			setState(174);
			instruccion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TpUnoParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(WHILE);
			setState(177);
			match(PA);
			setState(178);
			condicion();
			setState(179);
			match(PC);
			setState(180);
			instruccion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(TpUnoParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(BREAK);
			setState(183);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(TpUnoParser.RETURN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(TpUnoParser.PYC, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(RETURN);
			setState(186);
			expresion(0);
			setState(187);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0005\u00001\b"+
		"\u0000\n\u0000\f\u00004\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006X\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\td\b"+
		"\t\n\t\f\tg\t\t\u0001\n\u0001\n\u0001\n\u0003\nl\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000bv\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b{\b\u000b\n\u000b\f\u000b~\t\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u008e\b\u000e\n\u000e\f\u000e\u0091"+
		"\t\u000e\u0001\u000e\u0003\u000e\u0094\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00a6\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0001\u0016\u0017\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,\u0000\u0003\u0002\u0000\u0013\u0014\u001b\u001b\u0001\u0000\u000f"+
		"\u0012\u0001\u0000\t\u000e\u00b9\u00002\u0001\u0000\u0000\u0000\u0002"+
		"7\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000\u0006I\u0001"+
		"\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010^\u0001"+
		"\u0000\u0000\u0000\u0012`\u0001\u0000\u0000\u0000\u0014h\u0001\u0000\u0000"+
		"\u0000\u0016u\u0001\u0000\u0000\u0000\u0018\u007f\u0001\u0000\u0000\u0000"+
		"\u001a\u0083\u0001\u0000\u0000\u0000\u001c\u0093\u0001\u0000\u0000\u0000"+
		"\u001e\u0095\u0001\u0000\u0000\u0000 \u0098\u0001\u0000\u0000\u0000\""+
		"\u009c\u0001\u0000\u0000\u0000$\u009e\u0001\u0000\u0000\u0000&\u00a7\u0001"+
		"\u0000\u0000\u0000(\u00b0\u0001\u0000\u0000\u0000*\u00b6\u0001\u0000\u0000"+
		"\u0000,\u00b9\u0001\u0000\u0000\u0000.1\u0003\u001a\r\u0000/1\u0003\u0002"+
		"\u0001\u00000.\u0001\u0000\u0000\u00000/\u0001\u0000\u0000\u000014\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"35\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0005\u0000\u0000"+
		"\u00016\u0001\u0001\u0000\u0000\u000078\u0003\u0010\b\u000089\u0003\u0012"+
		"\t\u00009:\u0005\u0006\u0000\u0000:\u0003\u0001\u0000\u0000\u0000;<\u0003"+
		"\u0006\u0003\u0000<=\u0003\u0004\u0002\u0000=@\u0001\u0000\u0000\u0000"+
		">@\u0001\u0000\u0000\u0000?;\u0001\u0000\u0000\u0000?>\u0001\u0000\u0000"+
		"\u0000@\u0005\u0001\u0000\u0000\u0000AJ\u0003\b\u0004\u0000BJ\u0003\n"+
		"\u0005\u0000CJ\u0003\f\u0006\u0000DJ\u0003\u0018\f\u0000EF\u0003\u000e"+
		"\u0007\u0000FG\u0005\u0006\u0000\u0000GJ\u0001\u0000\u0000\u0000HJ\u0003"+
		",\u0016\u0000IA\u0001\u0000\u0000\u0000IB\u0001\u0000\u0000\u0000IC\u0001"+
		"\u0000\u0000\u0000ID\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000"+
		"IH\u0001\u0000\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0003\u0010"+
		"\b\u0000LM\u0003\u0012\t\u0000MN\u0005\u0006\u0000\u0000N\t\u0001\u0000"+
		"\u0000\u0000OP\u0005\u001d\u0000\u0000PQ\u0005\u0007\u0000\u0000QR\u0003"+
		"\u0016\u000b\u0000RS\u0005\u0006\u0000\u0000S\u000b\u0001\u0000\u0000"+
		"\u0000TX\u0003$\u0012\u0000UX\u0003&\u0013\u0000VX\u0003(\u0014\u0000"+
		"WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000X\r\u0001\u0000\u0000\u0000YZ\u0005\u001d\u0000\u0000Z[\u0005\u0002"+
		"\u0000\u0000[\\\u0003\u0016\u000b\u0000\\]\u0005\u0003\u0000\u0000]\u000f"+
		"\u0001\u0000\u0000\u0000^_\u0007\u0000\u0000\u0000_\u0011\u0001\u0000"+
		"\u0000\u0000`e\u0003\u0014\n\u0000ab\u0005\b\u0000\u0000bd\u0003\u0014"+
		"\n\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0013\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hk\u0005\u001d\u0000\u0000ij\u0005\u0007\u0000"+
		"\u0000jl\u0003\u0016\u000b\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000l\u0015\u0001\u0000\u0000\u0000mn\u0006\u000b\uffff\uffff"+
		"\u0000nv\u0005\u001c\u0000\u0000ov\u0005\u001d\u0000\u0000pv\u0003\u000e"+
		"\u0007\u0000qr\u0005\u0002\u0000\u0000rs\u0003\u0016\u000b\u0000st\u0005"+
		"\u0003\u0000\u0000tv\u0001\u0000\u0000\u0000um\u0001\u0000\u0000\u0000"+
		"uo\u0001\u0000\u0000\u0000up\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000"+
		"\u0000v|\u0001\u0000\u0000\u0000wx\n\u0005\u0000\u0000xy\u0007\u0001\u0000"+
		"\u0000y{\u0003\u0016\u000b\u0006zw\u0001\u0000\u0000\u0000{~\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0017"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0004"+
		"\u0000\u0000\u0080\u0081\u0003\u0004\u0002\u0000\u0081\u0082\u0005\u0005"+
		"\u0000\u0000\u0082\u0019\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u0010"+
		"\b\u0000\u0084\u0085\u0005\u001d\u0000\u0000\u0085\u0086\u0005\u0002\u0000"+
		"\u0000\u0086\u0087\u0003\u001c\u000e\u0000\u0087\u0088\u0005\u0003\u0000"+
		"\u0000\u0088\u0089\u0003\u0018\f\u0000\u0089\u001b\u0001\u0000\u0000\u0000"+
		"\u008a\u008f\u0003\u001e\u000f\u0000\u008b\u008c\u0005\b\u0000\u0000\u008c"+
		"\u008e\u0003\u001e\u000f\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0094\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u008a\u0001\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u001d\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u0010\b\u0000\u0096\u0097"+
		"\u0005\u001d\u0000\u0000\u0097\u001f\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0003\u0016\u000b\u0000\u0099\u009a\u0003\"\u0011\u0000\u009a\u009b\u0003"+
		"\u0016\u000b\u0000\u009b!\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0002"+
		"\u0000\u0000\u009d#\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0015\u0000"+
		"\u0000\u009f\u00a0\u0005\u0002\u0000\u0000\u00a0\u00a1\u0003 \u0010\u0000"+
		"\u00a1\u00a2\u0005\u0003\u0000\u0000\u00a2\u00a5\u0003\u0006\u0003\u0000"+
		"\u00a3\u00a4\u0005\u0016\u0000\u0000\u00a4\u00a6\u0003\u0006\u0003\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6%\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0017\u0000\u0000\u00a8"+
		"\u00a9\u0005\u0002\u0000\u0000\u00a9\u00aa\u0003\n\u0005\u0000\u00aa\u00ab"+
		"\u0003 \u0010\u0000\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac\u00ad\u0003"+
		"\n\u0005\u0000\u00ad\u00ae\u0005\u0003\u0000\u0000\u00ae\u00af\u0003\u0006"+
		"\u0003\u0000\u00af\'\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0018\u0000"+
		"\u0000\u00b1\u00b2\u0005\u0002\u0000\u0000\u00b2\u00b3\u0003 \u0010\u0000"+
		"\u00b3\u00b4\u0005\u0003\u0000\u0000\u00b4\u00b5\u0003\u0006\u0003\u0000"+
		"\u00b5)\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0019\u0000\u0000\u00b7"+
		"\u00b8\u0005\u0006\u0000\u0000\u00b8+\u0001\u0000\u0000\u0000\u00b9\u00ba"+
		"\u0005\u001a\u0000\u0000\u00ba\u00bb\u0003\u0016\u000b\u0000\u00bb\u00bc"+
		"\u0005\u0006\u0000\u0000\u00bc-\u0001\u0000\u0000\u0000\f02?IWeku|\u008f"+
		"\u0093\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}