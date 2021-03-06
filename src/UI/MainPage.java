/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.FunctionsTXT;

/**
 *
 * @author isaac
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int selectedOption = JOptionPane.showOptionDialog(null, "¿Desea guardar los datos?",
                         "Guardar los datos en la base de datos" ,
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE,
                         null,
                         new Object[] { "Sí", "No"},
                         "No");
                if (selectedOption == JOptionPane.YES_OPTION) {
                    FunctionsTXT.save();
                }
                e.getWindow().dispose();
                System.exit(0);
            }
        });
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
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        addArticleButton = new javax.swing.JButton();
        openAnalyzePageButton = new javax.swing.JButton();
        openSearchPageButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        title.setText("MetroMendeley: Repositorio Científico");
        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo.png"))); // NOI18N
        jPanel2.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 70));

        addArticleButton.setText("Agregar Resumen");
        addArticleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArticleButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addArticleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 180, 140));

        openAnalyzePageButton.setText("Analizar Resumen");
        openAnalyzePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAnalyzePageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(openAnalyzePageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 180, 140));

        openSearchPageButton.setText("Buscar Investigación");
        openSearchPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSearchPageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(openSearchPageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 180, 140));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/output-onlinepngtools.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-670, -130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addArticleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArticleButtonActionPerformed
        FunctionsUI.openJFileChooser();
    }//GEN-LAST:event_addArticleButtonActionPerformed

    private void openSearchPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSearchPageButtonActionPerformed
        GlobalUI.openSearchArticlePage();
        FunctionsUI.fillComboBoxWithListStrings(GlobalUI.getSearchArticlePage().getAuthorComboBox(), GlobalUI.getListAuthor());
    }//GEN-LAST:event_openSearchPageButtonActionPerformed

    private void openAnalyzePageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAnalyzePageButtonActionPerformed
        GlobalUI.openAnalyzeArticlePage();
        FunctionsUI.fillComboBoxWithListStrings(GlobalUI.getAnalyzeArticlePage().getjComboBox1(), GlobalUI.getListTitles());
    }//GEN-LAST:event_openAnalyzePageButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addArticleButton;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton openAnalyzePageButton;
    private javax.swing.JButton openSearchPageButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
