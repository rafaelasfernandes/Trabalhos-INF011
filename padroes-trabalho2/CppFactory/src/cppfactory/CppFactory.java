package cppfactory;

import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;


public class CppFactory implements IIDEFactory{
    
    public static CppFactory instancia;
    static String[] extensions = {"cpp"};
    
    protected CppFactory(){
        
    }
    
    public static IIDEFactory getInstance(){
        if(instancia == null){
            instancia = new CppFactory();
        }
        return instancia;
    }

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
