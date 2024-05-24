// Generated from /Users/matias/Documents/universidad/TC/TP1/tecnicasCompilacion/src/main/java/tpuno/TpUno.g4 by ANTLR 4.13.1
package tpuno;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TpUnoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, PA=3, PC=4, LLA=5, LLC=6, PYC=7, IGUAL=8, COMMA=9, IGUALIGUAL=10, 
		LT=11, GT=12, EQ=13, LE=14, GE=15, NE=16, INT=17, DOUBLE=18, IF=19, BREAK=20, 
		NUMERO=21, ID=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LETRA", "DIGITO", "WS", "PA", "PC", "LLA", "LLC", "PYC", "IGUAL", 
			"COMMA", "IGUALIGUAL", "LT", "GT", "EQ", "LE", "GE", "NE", "INT", "DOUBLE", 
			"IF", "BREAK", "NUMERO", "ID"
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


	public TpUnoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TpUno.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0016\u0091\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003"+
		"=\b\u0003\u000b\u0003\f\u0003>\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0004\u0016y\b\u0016\u000b\u0016\f\u0016z\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u007f\b\u0016\n\u0016\f\u0016\u0082\t\u0016\u0003\u0016"+
		"\u0084\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0088\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u008d\b\u0017\n\u0017\f\u0017"+
		"\u0090\t\u0017\u0000\u0000\u0018\u0001\u0001\u0003\u0000\u0005\u0000\u0007"+
		"\u0002\t\u0003\u000b\u0004\r\u0005\u000f\u0006\u0011\u0007\u0013\b\u0015"+
		"\t\u0017\n\u0019\u000b\u001b\f\u001d\r\u001f\u000e!\u000f#\u0010%\u0011"+
		"\'\u0012)\u0013+\u0014-\u0015/\u0016\u0001\u0000\u0003\u0002\u0000AZa"+
		"z\u0001\u000009\u0003\u0000\t\n\r\r  \u0096\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00011"+
		"\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u00059\u0001\u0000"+
		"\u0000\u0000\u0007<\u0001\u0000\u0000\u0000\tB\u0001\u0000\u0000\u0000"+
		"\u000bD\u0001\u0000\u0000\u0000\rF\u0001\u0000\u0000\u0000\u000fH\u0001"+
		"\u0000\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013L\u0001\u0000\u0000"+
		"\u0000\u0015N\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019"+
		"S\u0001\u0000\u0000\u0000\u001bU\u0001\u0000\u0000\u0000\u001dW\u0001"+
		"\u0000\u0000\u0000\u001fZ\u0001\u0000\u0000\u0000!]\u0001\u0000\u0000"+
		"\u0000#`\u0001\u0000\u0000\u0000%c\u0001\u0000\u0000\u0000\'g\u0001\u0000"+
		"\u0000\u0000)n\u0001\u0000\u0000\u0000+q\u0001\u0000\u0000\u0000-x\u0001"+
		"\u0000\u0000\u0000/\u0087\u0001\u0000\u0000\u000012\u0005w\u0000\u0000"+
		"23\u0005h\u0000\u000034\u0005i\u0000\u000045\u0005l\u0000\u000056\u0005"+
		"e\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0007\u0000\u0000\u0000"+
		"8\u0004\u0001\u0000\u0000\u00009:\u0007\u0001\u0000\u0000:\u0006\u0001"+
		"\u0000\u0000\u0000;=\u0007\u0002\u0000\u0000<;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0006\u0003\u0000\u0000A\b\u0001\u0000"+
		"\u0000\u0000BC\u0005(\u0000\u0000C\n\u0001\u0000\u0000\u0000DE\u0005)"+
		"\u0000\u0000E\f\u0001\u0000\u0000\u0000FG\u0005{\u0000\u0000G\u000e\u0001"+
		"\u0000\u0000\u0000HI\u0005}\u0000\u0000I\u0010\u0001\u0000\u0000\u0000"+
		"JK\u0005;\u0000\u0000K\u0012\u0001\u0000\u0000\u0000LM\u0005=\u0000\u0000"+
		"M\u0014\u0001\u0000\u0000\u0000NO\u0005,\u0000\u0000O\u0016\u0001\u0000"+
		"\u0000\u0000PQ\u0005=\u0000\u0000QR\u0005=\u0000\u0000R\u0018\u0001\u0000"+
		"\u0000\u0000ST\u0005<\u0000\u0000T\u001a\u0001\u0000\u0000\u0000UV\u0005"+
		">\u0000\u0000V\u001c\u0001\u0000\u0000\u0000WX\u0005=\u0000\u0000XY\u0005"+
		"=\u0000\u0000Y\u001e\u0001\u0000\u0000\u0000Z[\u0005<\u0000\u0000[\\\u0005"+
		"=\u0000\u0000\\ \u0001\u0000\u0000\u0000]^\u0005>\u0000\u0000^_\u0005"+
		"=\u0000\u0000_\"\u0001\u0000\u0000\u0000`a\u0005!\u0000\u0000ab\u0005"+
		"=\u0000\u0000b$\u0001\u0000\u0000\u0000cd\u0005i\u0000\u0000de\u0005n"+
		"\u0000\u0000ef\u0005t\u0000\u0000f&\u0001\u0000\u0000\u0000gh\u0005d\u0000"+
		"\u0000hi\u0005o\u0000\u0000ij\u0005u\u0000\u0000jk\u0005b\u0000\u0000"+
		"kl\u0005l\u0000\u0000lm\u0005e\u0000\u0000m(\u0001\u0000\u0000\u0000n"+
		"o\u0005i\u0000\u0000op\u0005f\u0000\u0000p*\u0001\u0000\u0000\u0000qr"+
		"\u0005b\u0000\u0000rs\u0005r\u0000\u0000st\u0005e\u0000\u0000tu\u0005"+
		"a\u0000\u0000uv\u0005k\u0000\u0000v,\u0001\u0000\u0000\u0000wy\u0003\u0005"+
		"\u0002\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0083\u0001\u0000\u0000"+
		"\u0000|\u0080\u0005.\u0000\u0000}\u007f\u0003\u0005\u0002\u0000~}\u0001"+
		"\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000"+
		"\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083|\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084.\u0001\u0000\u0000\u0000"+
		"\u0085\u0088\u0003\u0003\u0001\u0000\u0086\u0088\u0005_\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u008e\u0001\u0000\u0000\u0000\u0089\u008d\u0003\u0003\u0001\u0000\u008a"+
		"\u008d\u0003\u0005\u0002\u0000\u008b\u008d\u0005_\u0000\u0000\u008c\u0089"+
		"\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f0\u0001"+
		"\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\b\u0000>z\u0080"+
		"\u0083\u0087\u008c\u008e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}