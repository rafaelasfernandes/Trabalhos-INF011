package pdfdocument;

import interfaces.IDocument;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author Rafaela
 */
public class PDFDocument implements IDocument{
    
    private File arquivoSelecionado;
    private String extensaoArquivo;
    static String extensao = "pdf";
    private ArrayList<Icon> images = new ArrayList<Icon>();
  
    private final JFrame janela = new JFrame();
    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenuItem itemAbrir;
    private JMenuItem itemSair;
    
    private void initComponents(){
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        itemAbrir = new JMenuItem();
        itemSair = new JMenuItem();
     
        jMenu1.setText("Arquivo");
        
        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener((java.awt.event.ActionEvent evt) -> {
            open();
        });
        jMenu1.add(itemAbrir);
        
        itemSair.setText("Sair");
        itemSair.addActionListener((java.awt.event.ActionEvent evt) -> {
            System.exit(0);
        });
        jMenu1.add(itemSair);
        
        jMenuBar1.add(jMenu1);
        janela.setJMenuBar(jMenuBar1);
    }

    @Override
    public void open() {
        boolean pdf = false;
        do{
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
        
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                arquivoSelecionado = jfc.getSelectedFile();  
                extensaoArquivo = arquivoSelecionado.getName().split("\\.")[1];
                pdf = isPDF(extensaoArquivo);
                if(!pdf){
                    JOptionPane.showMessageDialog(janela, "Não é possível abrir arquivo com a extensão (." + extensaoArquivo + ")."); 
                }
            }
            else if (returnValue == JFileChooser.CANCEL_OPTION){
                System.exit(0);
            }
            System.out.println("Abrindo... " + arquivoSelecionado);
        }while(!pdf);  
    }

    @Override
    public JFrame getEditor() {
        initComponents();    
        try { 
            if(arquivoSelecionado == null){
                open();
            }   
            PDDocument document = Loader.loadPDF(new File(arquivoSelecionado.toString()));
            if(!document.isEncrypted()){
                PDFRenderer renderer = new PDFRenderer(document);
                BufferedImage imagem = null;
                for (int i = 0; i < document.getNumberOfPages(); i++){
                    imagem = renderer.renderImage(i);
                    images.add((Icon) new ImageIcon(imagem));
                }            
                ImageIcon img = (ImageIcon) images.get(0);
                JLabel label = new JLabel(img);
                janela.add(label);  
            }
            else{
                JOptionPane.showMessageDialog(janela, "O arquivo (" + arquivoSelecionado.toString() + ") está encriptado!.");
            }       
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        janela.setLocationRelativeTo(null);
        janela.setSize(600,400);
        janela.setVisible(true);
        return janela;
    }
    
    public boolean isPDF(String extensaoArquivo){
       return extensaoArquivo.equals(extensao);
    }
}
