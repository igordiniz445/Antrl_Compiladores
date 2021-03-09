// Generated from C:/Users/igorc/Desktop/ANTLR/SemanticoExemplo/src/antlr\Gramatica.g4 by ANTLR 4.9.1
package antlr;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Programa}
	 * labeled alternative in {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Programa}
	 * labeled alternative in {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplicacao}
	 * labeled alternative in {@link GramaticaParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplicacao}
	 * labeled alternative in {@link GramaticaParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divisao}
	 * labeled alternative in {@link GramaticaParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDivisao(GramaticaParser.DivisaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divisao}
	 * labeled alternative in {@link GramaticaParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDivisao(GramaticaParser.DivisaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtracao}
	 * labeled alternative in {@link GramaticaParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSubtracao(GramaticaParser.SubtracaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtracao}
	 * labeled alternative in {@link GramaticaParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSubtracao(GramaticaParser.SubtracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumero(GramaticaParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumero(GramaticaParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Soma}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSoma(GramaticaParser.SomaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Soma}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSoma(GramaticaParser.SomaContext ctx);
}