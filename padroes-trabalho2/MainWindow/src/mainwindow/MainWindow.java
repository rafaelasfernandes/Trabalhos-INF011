/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainwindow;

import interfaces.ISyntaxHighlighter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import interfaces.IIDEFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafactory.JavaFactory;

/**
 *
 * @author Rafaela
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAbrir = new javax.swing.JMenuItem();
        itemCompilar = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(itemAbrir);

        itemCompilar.setText("Compilar");
        itemCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompilarActionPerformed(evt);
            }
        });
        jMenu1.add(itemCompilar);

        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        jMenu1.add(itemSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            arquivoSelecionado = jfc.getSelectedFile();    
            extensaoArquivo = arquivoSelecionado.getName().split("\\.")[1];
            minhaFabrica = null;
            for (IIDEFactory fabrica : fabricas){
                for (int i = 0; i < fabrica.supportedExtensions().length; i++){
                    if (fabrica.supportedExtensions()[i].equals(extensaoArquivo)){
                        minhaFabrica = fabrica;
                        break;
                    }
                }
            }
            if (minhaFabrica != null) {             
                ISyntaxHighlighter highlighter = minhaFabrica.createSyntaxHighlighter();
                try {                
                    FileInputStream fis = new FileInputStream(arquivoSelecionado);
                    byte[] data = new byte[(int) arquivoSelecionado.length()];
                    fis.read(data);
                    fis.close();
                    highlighter.setText(new String(data, StandardCharsets.UTF_8));     
                } catch (FileNotFoundException ex) {       
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {     
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                setContentPane(highlighter);
                pack();
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Não há fábrica para a extensão de arquivo (." + extensaoArquivo + ").");               
            }
        }
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void itemCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompilarActionPerformed
        // TODO add your handling code here:
        minhaFabrica.createBuilder().compile(arquivoSelecionado);
        if(minhaFabrica.createBuilder().getResult() == 0){
            JOptionPane.showMessageDialog(jPanel1, "Arquivo compilado com sucesso!");
        }
        else{
            JOptionPane.showMessageDialog(jPanel1, "Problema ao compilar arquivo!");
        }
    }//GEN-LAST:event_itemCompilarActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_itemSairActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        File currentDir = new File("./plugins");
        String[] plugins = currentDir.list();
        URL[] jars = new URL[plugins.length];
       
        for(int i = 0; i < plugins.length; i++){
            System.out.println(i+1 + " - " + plugins[i].split("\\.")[0]);
            jars[i] = (new File("./plugins/" + plugins[i])).toURL();
        }
        
        URLClassLoader ulc = new URLClassLoader(jars);
        String nomeFabrica;
        
        for(int j = 0; j < plugins.length; j++){
           nomeFabrica = plugins[j].split("\\.")[0];
           Class metaClasse = Class.forName(nomeFabrica.toLowerCase() + "." + nomeFabrica, true, ulc);
           Method metaMetodo = metaClasse.getDeclaredMethod("getInstance");
           
           if(metaMetodo != null){
               fabricas.add((IIDEFactory) metaMetodo.invoke(null));
           }
        }
           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow tela = new MainWindow();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }    
   
    private File arquivoSelecionado;
    private String extensaoArquivo;
    private IIDEFactory minhaFabrica;
    private static ArrayList<IIDEFactory> fabricas = new ArrayList<IIDEFactory>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemCompilar;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
