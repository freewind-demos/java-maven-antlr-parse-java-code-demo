Java Maven Antlr Parse Java Code Demo
=====================

如何利用antlr生成可以解析java语法的parser，并且利用它来解析一个已有的java文件

- https://github.com/antlr/antlr4/blob/master/doc/getting-started.md
- Java grammar: https://github.com/antlr/grammars-v4/tree/master/java/java

```
brew install python
pip3 install antlr4-tools
antlr4 JavaLexer.g4 -o src/main/java/generated -package generated
antlr4 JavaParser.g4 -o src/main/java/generated -package generated
```

然后在IDE中运行`demo.Hello`，可以看到解析结果

