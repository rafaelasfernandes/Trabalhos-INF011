package javafactory;

import interfaces.IBuilder;
import java.io.File;


public class JavaBuilder implements IBuilder{
    
    static String comando = "javac -cp . ";
    private int result;
    
    @Override
    public void compile(File file) {
        System.out.println("Compilando arquivo...");
        try{
            String arquivo = file.toString();
            Process processo = Runtime.getRuntime().exec(comando + arquivo);
            processo.waitFor();
            System.out.println(arquivo + " exitValue() " + processo.exitValue());
            result = processo.exitValue();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    @Override
    public int getResult(){
       return result;
    }
}
