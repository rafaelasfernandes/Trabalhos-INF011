package mainwindow;

import interfaces.PizzaComponent;
import interfaces.PizzaDecorator;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        decoratorsDisponiveis = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        decoratorsSelecionados = new javax.swing.JList<>();
        inserirButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        subirButton = new javax.swing.JButton();
        descerButton = new javax.swing.JButton();
        prepararButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        decoratorsDisponiveis.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "AzeitonaDecorator", "MostardaDecorator", "PalmitoDecorator" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(decoratorsDisponiveis);

        decoratorsSelecionados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(decoratorsSelecionados);

        inserirButton.setText(">");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });

        removerButton.setText("<");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        subirButton.setText("Subir");
        subirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirButtonActionPerformed(evt);
            }
        });

        descerButton.setText("Descer");
        descerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descerButtonActionPerformed(evt);
            }
        });

        prepararButton.setText("Preparar");
        prepararButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepararButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Decorators Disponíveis");

        jLabel2.setText("Decorators Selecionados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inserirButton)
                                    .addComponent(removerButton)))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subirButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descerButton, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(prepararButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(inserirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(subirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descerButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(prepararButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descerButtonActionPerformed
        // TODO add your handling code here:
        int posicao = decoratorsSelecionados.getSelectedIndex();
        int tamArray = decoratorsSelecionados.getModel().getSize();
        if(posicao < tamArray - 1){
            model.add(posicao + 2, model.get(posicao));
            model.remove(posicao);
            decoratorsSelecionados.grabFocus();
            decoratorsSelecionados.setSelectedIndex(posicao + 1);
        }
        
    }//GEN-LAST:event_descerButtonActionPerformed

    private void subirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirButtonActionPerformed
        // TODO add your handling code here:
        int posicao = decoratorsSelecionados.getSelectedIndex();
        if(posicao > 0){
            model.add(posicao - 1, model.get(posicao));
            model.remove(posicao + 1);
            decoratorsSelecionados.grabFocus();
            decoratorsSelecionados.setSelectedIndex(posicao - 1);
        }
    }//GEN-LAST:event_subirButtonActionPerformed

    private void prepararButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepararButtonActionPerformed
        try {
            // TODO add your handling code here:
            PizzaComponent pizzaBasica = new PizzaBasica();
            PizzaDecorator pizzaDecorator = null;
            int tamArray = decoratorsSelecionados.getModel().getSize();
            for (int i = tamArray - 1; i >= 0; i--){
                for (String chave : pluginsMap.keySet()){
                    if(chave.equals(decoratorsSelecionados.getModel().getElementAt(i))){
                        pizzaDecorator = (PizzaDecorator) (PizzaComponent) Class.forName(chave.toLowerCase() + "." + chave, true, ulc).newInstance();
                        pizzaDecorator.setDecorated(pizzaBasica);
                        pizzaBasica = pizzaDecorator;
                    }
                }
            }
            System.out.println();
            System.out.println("***************************************");
            System.out.println();
            pizzaDecorator.preparar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prepararButtonActionPerformed

    private void inserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirButtonActionPerformed
        // TODO add your handling code here:
        String valor = decoratorsDisponiveis.getSelectedValue();
        if(valor != null){
            decoratorsSelecionados.setModel(model);
            model.addElement(valor);
        }
    }//GEN-LAST:event_inserirButtonActionPerformed

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        // TODO add your handling code here:
        String valor = decoratorsSelecionados.getSelectedValue();
        int posicao = decoratorsSelecionados.getSelectedIndex();
        if(valor != null){
            decoratorsSelecionados.setModel(model);
            model.remove(posicao);
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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
        jars = new URL[plugins.length];

        for(int i = 0; i < plugins.length; i++){
            System.out.println(i+1 + " - " + plugins[i].split("\\.")[0]);
            jars[i] = (new File("./plugins/" + plugins[i])).toURL();
        }
        
        ulc = new URLClassLoader(jars);
        String nomePlugin;
        
        for (int j = 0; j < plugins.length; j++) {
            nomePlugin = plugins[j].split("\\.")[0];
            PizzaComponent plugin = (PizzaComponent) Class.forName(nomePlugin.toLowerCase() + "." + nomePlugin, true, ulc).newInstance();
            pluginsMap.put(nomePlugin, (PizzaComponent)plugin);
        }
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    DefaultListModel model = new DefaultListModel();
    private static HashMap<String, PizzaComponent> pluginsMap = new HashMap<String, PizzaComponent>();
    private static URL[] jars;
    private static URLClassLoader ulc;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> decoratorsDisponiveis;
    private static javax.swing.JList<String> decoratorsSelecionados;
    private javax.swing.JButton descerButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton prepararButton;
    private javax.swing.JButton removerButton;
    private javax.swing.JButton subirButton;
    // End of variables declaration//GEN-END:variables
}