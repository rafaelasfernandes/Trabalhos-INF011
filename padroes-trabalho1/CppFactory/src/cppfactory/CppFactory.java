package cppfactory;

import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;


public class CppFactory implements IIDEFactory{
    
    static String[] extensions = {"cpp"};

    @Override
    public IBuilder createBuilder() {
        return new CppBuilder();
    }

    @Override
    public ISyntaxHighlighter createSyntaxHighlighter() {
        return new CppSyntaxHighlighter();
    }

    @Override
    public String[] supportedExtensions() {
      return extensions;
    }  
}
