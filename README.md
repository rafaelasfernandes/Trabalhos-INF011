# Trabalhos-INF011
Trabalhos da disciplina Padrões de Projeto. 

Especificação do Trabalho 1: 
Implementar um Abstract Factory com dois produtos: 1) SyntaxHighlighter e 2) Builder. O objetivo é criar um sistema visual onde você possa abrir um arquivo .cpp ou .java. A depender de qual arquivo você abra ele utilizará uma fábrica que disponibiliza um syntaxhighlighter e builder apropriado para a linguagem em questão.

Quem for fazer eu Java sugiro utilizar o RSyntaxTextArea (https://github.com/bobbylight/RSyntaxTextArea) para fazer o highlight. Em distros baseadas no Ubuntu/Debian, esta lib pode ser instalada com "sudo apt install librsyntaxtextarea-java".

Interfaces dos produtos:
1) Syntax highlighter: JFrame (esta interface já existe no Java, você não precisará criar).
2) Compilador: IBuilder (esta você deverá criar). A interface IBuilder deverá ter o método compile(File file), que irá invocar o compilador g++ ou javac a depender da fábrica concreta em uso.

Crie duas fábricas: uma para suportar C++ e outra para Java. A fábrica a ser utilizada deverá ser automaticamente escolhida a depender da extensão do arquivo aberto (.cpp ou .java). Adicione um método "String [] supportedExtensions()" na fábrica para perguntar quais extensões a fábrica consegue suportar. O sistema deve usar a primeira fábrica encontrada que suporte a extensão do arquivo sendo aberto, ou informar "Não existe plugin que suporte este arquivo" caso nenhuma fábrica consiga suportar aquela extensão. As duas fábricas devem ser implementadas como plugins.

Especificação do Trabalho 2: 
Transformar as fábricas concretas do T1 em singletons.
Passos:
* Mudar os construtores para private/protected.
* Criar o atributo estático e implementar o método estático getInstance().
* Modificar a carga dos plugins para obter as instâncias via getInstance().

Especificação do Trabalho 3: 
Implementar um framework para editores de documentos, com especialização para visualização da primeira página de arquivos PDF.
Passos:
* Criar a interface IDocument (interface target do adapter) com os métodos open() e getEditor(). O getEditor() deve retornar um JFrame contendo a visualização do documento.
* Implementar o plugin para visualização de PDFs. Crie o class PDFDocument fazendo implements de IDocument e fazendo composição com a lib PDFBox da Apache. A implementação do método getEditor() deve retornar um JFrame visualizando a primeira página do documento.* Ao abrir um determinado arquivo, a aplicação deverá encontrar um plugin que suporte a visualização da extensão do arquivo escolhido.
Bônus: implementar a visualização das demais páginas do PDF, possibilitando a navegação para a página anterior e próxima.

Especificação do Trabalho 4:
Implementar um sistema para seleção de decorators a serem aplicados em um objeto básico que representa uma pizza. O método decorado será o método "void preparar()" e a implementação do objeto básico (denominado PizzaBasica) deverá exibir: "Preparando a massa + molho + queijo". Todos os decorators deverão exibir: "Adicionando <ingrediente-do-decorator>". Três decorators concretos deverão ser implementados como plugins, identificados no momento da carga (através de instanceof ou casting para o pai de todos os decorators) e exibidos na lista de decorators disponíveis. O usuário irá selecionar os decorators que ele deseja incluir na pizza, podendo realizar múltiplas seleções de um mesmo decorator e redefinir a ordem de aplicação dos decorators. Ao clicar no botão "Preparar", o sistema deverá instanciar a cadeia de decorators selecionados e invocar o método "void preparar()" na ponta desta cadeia.
