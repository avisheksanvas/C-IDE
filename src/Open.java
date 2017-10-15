/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abhey
 */
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
public class Open extends javax.swing.JFrame {

    /**
     * Creates new form Open
     */
    public Open() {
        initComponents();
        OpenDialog.setDialogTitle("Open File");
        OpenDialog.setAcceptAllFileFilterUsed(false);
        javax.swing.filechooser.FileNameExtensionFilter filter=new javax.swing.filechooser.FileNameExtensionFilter(".c, .cpp, .java","c","cpp","java");
        OpenDialog.setFileFilter(filter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpenDialog = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open File");
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(410, 155));
        setType(java.awt.Window.Type.POPUP);

        OpenDialog.setDialogTitle("Open File");
        OpenDialog.setFileFilter(null);
        OpenDialog.setPreferredSize(new java.awt.Dimension(502, 410));
        OpenDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OpenDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OpenDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenDialogActionPerformed
        // TODO add your handling code here:
        if(evt.getActionCommand().compareTo("CancelSelection")==0){
            this.dispose();
            Eureka.frame.toFront();
            return;
        }
        File file=OpenDialog.getSelectedFile();
        if(file!=null){
        try{    
                java.io.FileReader reader = new java.io.FileReader(file);
                char inputBuffer[]=new char[(int)file.length()];
                int red=reader.read(inputBuffer);
                StringBuffer str=new StringBuffer("");
                str.append(inputBuffer);
                String Str=str.toString();
                String FilePath=file.getAbsolutePath();
                // Edit here ..............
                Eureka.OpenFile(file.getName(),Str,FilePath,true);
                Eureka.frame.toFront();
                this.dispose();
                return;
            }
            catch (FileNotFoundException e){
                JOptionPane.showMessageDialog(null,"File not found");
                this.dispose();
                Eureka.frame.toFront();
                return;
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null,"Input Output Exception occurred");
                this.dispose();
                Eureka.frame.toFront();
                return;
            }
        }
        else{
            this.dispose();
            Eureka.frame.toFront();
            return;
        }
    }//GEN-LAST:event_OpenDialogActionPerformed

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
            java.util.logging.Logger.getLogger(Open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Open.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Open().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser OpenDialog;
    // End of variables declaration//GEN-END:variables
}