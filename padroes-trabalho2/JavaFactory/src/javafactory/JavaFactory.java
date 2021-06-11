package javafactory;

import interfaces.IBuilder;
import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;

public class JavaFactory implements IIDEFactory{
    
    public static JavaFactory instancia;
    static String[] extensions = {"java"};
    
    protected JavaFactory(){
        
    }
    
    public static IIDEFactory getInstance() {
          if(instancia == null){
            instancia = new JavaFactory();
        }
        return instancia;
    } 

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
