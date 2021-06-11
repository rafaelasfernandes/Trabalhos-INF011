package cppfactory;

import interfaces.IBuilder;
import java.io.File;


public class CppBuilder implements IBuilder{
    
    private int result;

    @Override
    public void compile(File file) {
        System.out.println("Compilando arquivo...");
        try{
            String arquivoCpp = file.toString();
            String arquivoSemCpp = arquivoCpp.split("\\.")[0];
            String comando = "g++ " + arquivoCpp + " -o " + arquivoSemCpp;
            Process processo = Runtime.getRuntime().exec(comando);
            processo.waitFor();
            System.out.println(comando + " exitValue() " + processo.exitValue());
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
