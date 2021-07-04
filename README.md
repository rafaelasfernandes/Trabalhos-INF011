# Trabalhos-INF011
Trabalhos da disciplina Padrões de Projeto. 

Especificação Trabalho 1: 
Implementar um Abstract Factory com dois produtos: 1) SyntaxHighlighter e 2) Builder. O objetivo é criar um sistema visual onde você possa abrir um arquivo .cpp ou .java. A depender de qual arquivo você abra ele utilizará uma fábrica que disponibiliza um syntaxhighlighter e builder apropriado para a linguagem em questão.

Quem for fazer eu Java sugiro utilizar o RSyntaxTextArea (https://github.com/bobbylight/RSyntaxTextArea) para fazer o highlight. Em distros baseadas no Ubuntu/Debian, esta lib pode ser instalada com "sudo apt install librsyntaxtextarea-java".

Interfaces dos produtos:
1) Syntax highlighter: JFrame (esta interface já existe no Java, você não precisará criar).
2) Compilador: IBuilder (esta você deverá criar). A interface IBuilder deverá ter o método compile(File file), que irá invocar o compilador g++ ou javac a depender da fábrica concreta em uso.

Crie duas fábricas: uma para suportar C++ e outra para Java. A fábrica a ser utilizada deverá ser automaticamente escolhida a depender da extensão do arquivo aberto (.cpp ou .java). Adicione um método "String [] supportedExtensions()" na fábrica para perguntar quais extensões a fábrica consegue suportar. O sistema deve usar a primeira fábrica encontrada que suporte a extensão do arquivo sendo aberto, ou informar "Não existe plugin que suporte este arquivo" caso nenhuma fábrica consiga suportar aquela extensão. As duas fábricas devem ser implementadas como plugins.

Especificação Trabalho 2: 
Transformar as fábricas concretas do T1 em singletons.
Passos:
* Mudar os construtores para private/protected.
* Criar o atributo estático e implementar o método estático getInstance().
* Modificar a carga dos plugins para obter as instâncias via getInstance().
