package demo;

import generated.JavaLexer;
import generated.JavaParser;
import generated.JavaParserBaseListener;
import generated.JavaParserListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Hello {

    public static void main(String[] args) throws IOException {
        String projectRoot = System.getProperty("user.dir");
        CharStream input = CharStreams.fromPath(Path.of(projectRoot + "/src/main/java/demo/Hello.java")); // this file
        JavaLexer lex = new JavaLexer(input); // transforms characters into tokens
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        JavaParser parser = new JavaParser(tokens); // transforms tokens into parse trees


        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new JavaParserBaseListener() {
            @Override
            public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
                System.out.println("### className: " + ctx.identifier().getText());
            }

        }, parser.compilationUnit());

    }

}
