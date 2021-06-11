package javafactory;

import interfaces.ISyntaxHighlighter;
import java.awt.BorderLayout;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;


public class JavaSyntaxHighlighter extends ISyntaxHighlighter{
    
    private RSyntaxTextArea textArea;
    
    public JavaSyntaxHighlighter() {
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        add(sp);
    }

    @Override
    public void setText(String text) {
        textArea.setText(text);
    }
    
}
