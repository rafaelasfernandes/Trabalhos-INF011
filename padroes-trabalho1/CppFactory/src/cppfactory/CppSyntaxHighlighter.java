package cppfactory;

import interfaces.ISyntaxHighlighter;
import java.awt.BorderLayout;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;


public class CppSyntaxHighlighter extends ISyntaxHighlighter{
    
    private RSyntaxTextArea textArea;
    
    public CppSyntaxHighlighter() {
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        add(sp);
    }

    @Override
    public void setText(String text) {
        textArea.setText(text);
    }
}
