// Generated from C:/Users/igorc/Desktop/ANTLR/SemanticoExemplo/src/antlr\Gramatica.g4 by ANTLR 4.9.1
package antlr;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Programa}
	 * labeled alternative in {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplicacao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(GramaticaParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Soma}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoma(GramaticaParser.SomaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtracao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtracao(GramaticaParser.SubtracaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divisao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisao(GramaticaParser.DivisaoContext ctx);
}