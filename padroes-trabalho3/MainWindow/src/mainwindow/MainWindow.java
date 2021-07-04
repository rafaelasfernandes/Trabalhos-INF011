/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainwindow;

import interfaces.IDocument;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 *
 * @author Rafaela
 */
public class MainWindow {
    
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
  
        ArrayList<IDocument> documents = new ArrayList<IDocument>();
        IDocument pdf;
        
        File currentDir = new File("./plugins");
        String[] plugins = currentDir.list();
        URL[] jars = new URL[plugins.length];

        for(int i = 0; i < plugins.length; i++){
            System.out.println(i+1 + " - " + plugins[i].split("\\.")[0]);
            jars[i] = (new File("./plugins/" + plugins[i])).toURL();
        }
        
        URLClassLoader ulc = new URLClassLoader(jars);
        String nomePlugin;
        
        for (String plugin : plugins) {
            nomePlugin = plugin.split("\\.")[0];
            documents.add((IDocument) Class.forName(nomePlugin.toLowerCase() + "." + nomePlugin, true, ulc).newInstance());
        }
        pdf = documents.get(0);
        pdf.getEditor();
    }
}
