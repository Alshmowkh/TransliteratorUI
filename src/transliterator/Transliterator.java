/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transliterator;

import buckwalter.ArabicToBuckwalter;
import buckwalter.BuckwalterToArabic;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author bakee
 */
public class Transliterator extends javax.swing.JFrame {
    
    ArabicToBuckwalter atb;
    BuckwalterToArabic bta;
    String string;
    
    public Transliterator() {
        initComponents();
        this.jTextField1.transferFocus();
        this.getRootPane().setDefaultButton(this.jButton1);
        this.setLocationRelativeTo(null);
        this.setTitle("Transliterator");
        
    }
    
    public Transliterator(String text) {
        string = text;
    }
    
    public String transliterate() {
        if (string != null) {
            return this.translitrate(string);
        } else {
            return null;
        }
    }
    
    private String translitrate(String str) {
        String ret = "";
        atb = new ArabicToBuckwalter();
        bta = new BuckwalterToArabic();
        if (atb.containsKey(str.trim().charAt(0) + "")) {
            ret = atb.transliterate(str);
        } else if (bta.containsKey(str.trim().charAt(0) + "")) {
            ret = bta.transliterate(str);
        }
        ret = ret.replaceAll("null", " ");
        return ret;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        jButton1.setText("Transliterate");
        jButton1.setName("transBtn"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.setName("textField"); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setToolTipText("Click me double for copy text.");
        jLabel1.setAutoscrolls(true);
        jLabel1.setName("outputLabel"); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copy(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str = this.jTextField1.getText();
        if (str.isEmpty()) {
            return;
        }
        String ret = "";
        atb = new ArabicToBuckwalter();
        bta = new BuckwalterToArabic();
        if (atb.containsKey(str.trim().charAt(0) + "")) {
            ret = atb.transliterate(str);
            this.jTextField1.setHorizontalAlignment(JLabel.RIGHT);
            this.jLabel1.setHorizontalAlignment(JLabel.LEFT);
        } else if (bta.containsKey(str.trim().charAt(0) + "")) {
            ret = bta.transliterate(str);
            this.jTextField1.setHorizontalAlignment(JLabel.LEFT);
            this.jLabel1.setHorizontalAlignment(JLabel.RIGHT);
        }
        ret = ret.replaceAll("null", " ");
        this.jLabel1.setText(ret);
        this.jTextField1.selectAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void copy(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copy
        if (evt.getClickCount() == 2) {
            StringSelection slc = new StringSelection(jLabel1.getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(slc, null);
            jLabel1.setBackground(Color.blue);
        }
    }//GEN-LAST:event_copy

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            clip.setContents(new StringSelection(jLabel1.getText()), null);
            jLabel1.setFocusable(rootPaneCheckingEnabled);
            
        }
    }//GEN-LAST:event_jTextField1MouseClicked

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
            java.util.logging.Logger.getLogger(Transliterator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transliterator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transliterator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transliterator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transliterator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
