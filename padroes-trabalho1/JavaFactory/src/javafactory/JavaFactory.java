package javafactory;

import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;


public class JavaFactory implements IIDEFactory{
    
    static String[] extensions = {"java"};

    @Override
    public IBuilder createBuilder() {
        return new JavaBuilder();
    }

    @Override
    public ISyntaxHighlighter createSyntaxHighlighter() {
        return new JavaSyntaxHighlighter();
    }

    @Override
    public String[] supportedExtensions() { 
        return extensions;
    }
}
