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
		T__0=1, WS=2, PA=3, PC=4, LLA=5, LLC=6, PYC=7, IGUAL=8, COMMA=9, IGUALIGUAL=10, 
		LT=11, GT=12, EQ=13, LE=14, GE=15, NE=16, INT=17, DOUBLE=18, IF=19, BREAK=20, 
		NUMERO=21, ID=22;
	public static final int
		RULE_programa = 0, RULE_instrucciones = 1, RULE_instruccion = 2, RULE_declaracion = 3, 
		RULE_tipo = 4, RULE_listaIdent = 5, RULE_ident = 6, RULE_asignacion = 7, 
		RULE_expresion = 8, RULE_iwhile = 9, RULE_condicion = 10, RULE_comparador = 11, 
		RULE_breakStmt = 12, RULE_ifStmt = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "instrucciones", "instruccion", "declaracion", "tipo", "listaIdent", 
			"ident", "asignacion", "expresion", "iwhile", "condicion", "comparador", 
			"breakStmt", "ifStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", null, "'('", "')'", "'{'", "'}'", "';'", "'='", "','", 
			null, "'<'", "'>'", null, "'<='", "'>='", "'!='", "'int'", "'double'", 
			"'if'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "PA", "PC", "LLA", "LLC", "PYC", "IGUAL", "COMMA", 
			"IGUALIGUAL", "LT", "GT", "EQ", "LE", "GE", "NE", "INT", "DOUBLE", "IF", 
			"BREAK", "NUMERO", "ID"
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
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TpUnoParser.EOF, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			instrucciones();
			setState(29);
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
		enterRule(_localctx, 2, RULE_instrucciones);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case INT:
			case DOUBLE:
			case IF:
			case BREAK:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				instruccion();
				setState(32);
				instrucciones();
				}
				break;
			case EOF:
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
		public IwhileContext iwhile() {
			return getRuleContext(IwhileContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
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
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				declaracion();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				asignacion();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				iwhile();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				ifStmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				breakStmt();
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
		enterRule(_localctx, 6, RULE_declaracion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			tipo();
			setState(45);
			listaIdent();
			setState(46);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TpUnoParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TpUnoParser.DOUBLE, 0); }
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
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
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
		public List<TerminalNode> COMMA() { return getTokens(TpUnoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TpUnoParser.COMMA, i);
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
		enterRule(_localctx, 10, RULE_listaIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			ident();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(51);
				match(COMMA);
				setState(52);
				ident();
				}
				}
				setState(57);
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
		enterRule(_localctx, 12, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(ID);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(59);
				match(IGUAL);
				setState(60);
				expresion();
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
		enterRule(_localctx, 14, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(ID);
			setState(64);
			match(IGUAL);
			setState(65);
			expresion();
			setState(66);
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
	public static class ExpresionContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(TpUnoParser.NUMERO, 0); }
		public TerminalNode ID() { return getToken(TpUnoParser.ID, 0); }
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
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==ID) ) {
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
	public static class IwhileContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public TerminalNode LLA() { return getToken(TpUnoParser.LLA, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode LLC() { return getToken(TpUnoParser.LLC, 0); }
		public IwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).enterIwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TpUnoListener ) ((TpUnoListener)listener).exitIwhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TpUnoVisitor ) return ((TpUnoVisitor<? extends T>)visitor).visitIwhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IwhileContext iwhile() throws RecognitionException {
		IwhileContext _localctx = new IwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_iwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__0);
			setState(71);
			match(PA);
			setState(72);
			condicion();
			setState(73);
			match(PC);
			setState(74);
			match(LLA);
			setState(75);
			instrucciones();
			setState(76);
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
		enterRule(_localctx, 20, RULE_condicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			expresion();
			setState(79);
			comparador();
			setState(80);
			expresion();
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
		public TerminalNode LT() { return getToken(TpUnoParser.LT, 0); }
		public TerminalNode GT() { return getToken(TpUnoParser.GT, 0); }
		public TerminalNode EQ() { return getToken(TpUnoParser.EQ, 0); }
		public TerminalNode LE() { return getToken(TpUnoParser.LE, 0); }
		public TerminalNode GE() { return getToken(TpUnoParser.GE, 0); }
		public TerminalNode NE() { return getToken(TpUnoParser.NE, 0); }
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
		enterRule(_localctx, 22, RULE_comparador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 129024L) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(BREAK);
			setState(85);
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
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TpUnoParser.IF, 0); }
		public TerminalNode PA() { return getToken(TpUnoParser.PA, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TpUnoParser.PC, 0); }
		public TerminalNode LLA() { return getToken(TpUnoParser.LLA, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode LLC() { return getToken(TpUnoParser.LLC, 0); }
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
		enterRule(_localctx, 26, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(IF);
			setState(88);
			match(PA);
			setState(89);
			condicion();
			setState(90);
			match(PC);
			setState(91);
			match(LLA);
			setState(92);
			instrucciones();
			setState(93);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016`\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001$\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002+\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u00056\b\u0005\n\u0005\f\u0005"+
		"9\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006>\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u0000\u0003\u0001\u0000\u0011\u0012\u0001\u0000\u0015"+
		"\u0016\u0001\u0000\u000b\u0010X\u0000\u001c\u0001\u0000\u0000\u0000\u0002"+
		"#\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006,\u0001"+
		"\u0000\u0000\u0000\b0\u0001\u0000\u0000\u0000\n2\u0001\u0000\u0000\u0000"+
		"\f:\u0001\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000\u0010D\u0001"+
		"\u0000\u0000\u0000\u0012F\u0001\u0000\u0000\u0000\u0014N\u0001\u0000\u0000"+
		"\u0000\u0016R\u0001\u0000\u0000\u0000\u0018T\u0001\u0000\u0000\u0000\u001a"+
		"W\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u001e"+
		"\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000\u0000\u0000\u001f \u0003"+
		"\u0004\u0002\u0000 !\u0003\u0002\u0001\u0000!$\u0001\u0000\u0000\u0000"+
		"\"$\u0001\u0000\u0000\u0000#\u001f\u0001\u0000\u0000\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%+\u0003\u0006\u0003\u0000"+
		"&+\u0003\u000e\u0007\u0000\'+\u0003\u0012\t\u0000(+\u0003\u001a\r\u0000"+
		")+\u0003\u0018\f\u0000*%\u0001\u0000\u0000\u0000*&\u0001\u0000\u0000\u0000"+
		"*\'\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0003\b\u0004\u0000-.\u0003\n"+
		"\u0005\u0000./\u0005\u0007\u0000\u0000/\u0007\u0001\u0000\u0000\u0000"+
		"01\u0007\u0000\u0000\u00001\t\u0001\u0000\u0000\u000027\u0003\f\u0006"+
		"\u000034\u0005\t\u0000\u000046\u0003\f\u0006\u000053\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008\u000b\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":=\u0005\u0016\u0000\u0000;<\u0005\b\u0000\u0000<>\u0003\u0010\b\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\r\u0001\u0000\u0000"+
		"\u0000?@\u0005\u0016\u0000\u0000@A\u0005\b\u0000\u0000AB\u0003\u0010\b"+
		"\u0000BC\u0005\u0007\u0000\u0000C\u000f\u0001\u0000\u0000\u0000DE\u0007"+
		"\u0001\u0000\u0000E\u0011\u0001\u0000\u0000\u0000FG\u0005\u0001\u0000"+
		"\u0000GH\u0005\u0003\u0000\u0000HI\u0003\u0014\n\u0000IJ\u0005\u0004\u0000"+
		"\u0000JK\u0005\u0005\u0000\u0000KL\u0003\u0002\u0001\u0000LM\u0005\u0006"+
		"\u0000\u0000M\u0013\u0001\u0000\u0000\u0000NO\u0003\u0010\b\u0000OP\u0003"+
		"\u0016\u000b\u0000PQ\u0003\u0010\b\u0000Q\u0015\u0001\u0000\u0000\u0000"+
		"RS\u0007\u0002\u0000\u0000S\u0017\u0001\u0000\u0000\u0000TU\u0005\u0014"+
		"\u0000\u0000UV\u0005\u0007\u0000\u0000V\u0019\u0001\u0000\u0000\u0000"+
		"WX\u0005\u0013\u0000\u0000XY\u0005\u0003\u0000\u0000YZ\u0003\u0014\n\u0000"+
		"Z[\u0005\u0004\u0000\u0000[\\\u0005\u0005\u0000\u0000\\]\u0003\u0002\u0001"+
		"\u0000]^\u0005\u0006\u0000\u0000^\u001b\u0001\u0000\u0000\u0000\u0004"+
		"#*7=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}