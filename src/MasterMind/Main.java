/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author coding4u
 */
public class Main extends javax.swing.JFrame {

    private static final int QUATTRO=4;
    boolean isInizio;//indica start;
    Gioco objGioco;
    JLabel [][] grid;//griglia di label per la board
    JComboBox []cbCol=new JComboBox[QUATTRO]; //implementa ComboBox
    ImageIcon[] imgPioli = new ImageIcon[2*QUATTRO];//implementa la board di gioco
    ImageIcon[] imgRes = new ImageIcon[QUATTRO-1];//implementa la board di suggerimento
    int volte=0;//indica il numero di tentativi
    int neri=0;//indica il numero di esatti
    int conta=0;//conta i tentativi fatti
    String check="";//controllo piolo 8='B' 9='N' 10='.'
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        pnlScelta.setVisible(false);
        isInizio=true;
        pnlBoard.setVisible(false);
        pnlEsito.setVisible(false);
    }
   /**
    * il metodo stampa la board iniziale del mistermind
     * @param min indice di partenza 
     * @param max indice di arrivo
     * @param pan pannello di riferimento
    */
    private void inizializzaGioco(int min,int max, JPanel pan, boolean isInizio){
        if(isInizio){
            for(int i=0;i<imgPioli.length;i++)
                imgPioli[i]=new ImageIcon(Main.class.getResource("/Img/c"+i+".png"));
            for(int i=0;i<imgRes.length;i++)
                imgRes[i]=new ImageIcon(Main.class.getResource("/Img/c"+(i+2*QUATTRO)+".png"));
            for(int i=0; i<QUATTRO;i++){
                cbCol[i]=new JComboBox();
                cbCol[i].setModel(new DefaultComboBoxModel(imgPioli));
                pnlScelta.add(cbCol[i]);
            }
            this.setVisible(true);
        }
        for (int i=0; i<sldDifficolta.getValue();i++)
            for(int j=min;j<max;j++){
                grid[i][j]=new JLabel(null,imgRes[2], JLabel.CENTER);
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                pan.add(grid[i][j]);
        }
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDifficolta = new javax.swing.JLabel();
        sldDifficolta = new javax.swing.JSlider();
        lblDifficolta1 = new javax.swing.JLabel();
        btnDiff = new javax.swing.JButton();
        pnlScelta = new javax.swing.JPanel();
        btnVai = new javax.swing.JButton();
        pnlBoard = new javax.swing.JPanel();
        pnlEsito = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniNuova = new javax.swing.JMenuItem();
        mniExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniRegole = new javax.swing.JMenuItem();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MisteMind Color");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDifficolta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDifficolta.setForeground(new java.awt.Color(255, 255, 0));
        lblDifficolta.setText("Facile   ");
        getContentPane().add(lblDifficolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 0, -1, 30));

        sldDifficolta.setMajorTickSpacing(2);
        sldDifficolta.setMaximum(8);
        sldDifficolta.setMinimum(2);
        sldDifficolta.setMinorTickSpacing(1);
        sldDifficolta.setPaintTicks(true);
        sldDifficolta.setValue(5);
        sldDifficolta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldDifficolta.setOpaque(false);
        getContentPane().add(sldDifficolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 3, 180, -1));

        lblDifficolta1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDifficolta1.setForeground(new java.awt.Color(255, 255, 0));
        lblDifficolta1.setText("Seleziona:   Difficile   ");
        getContentPane().add(lblDifficolta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 172, 30));

        btnDiff.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDiff.setForeground(new java.awt.Color(255, 255, 0));
        btnDiff.setText("scelta");
        btnDiff.setOpaque(false);
        btnDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiffActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiff, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 169, 40));

        pnlScelta.setBackground(new java.awt.Color(0, 255, 255));
        pnlScelta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlScelta.setOpaque(false);

        btnVai.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVai.setForeground(new java.awt.Color(255, 255, 0));
        btnVai.setText("OK -->");
        btnVai.setMaximumSize(null);
        btnVai.setMinimumSize(null);
        btnVai.setOpaque(false);
        btnVai.setPreferredSize(null);
        btnVai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaiActionPerformed(evt);
            }
        });
        pnlScelta.add(btnVai);

        getContentPane().add(pnlScelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 100));

        pnlBoard.setBackground(new java.awt.Color(102, 102, 0,100));
        pnlBoard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(pnlBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, 648));

        pnlEsito.setBackground(new java.awt.Color(153, 153, 0,100));
        pnlEsito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(pnlEsito, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 160, 360, 648));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mmlogo.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 810));

        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mniNuova.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mniNuova.setText("Nuova Partita");
        mniNuova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNuovaActionPerformed(evt);
            }
        });
        jMenu1.add(mniNuova);

        mniExit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        jMenu1.add(mniExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        mniRegole.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mniRegole.setText("Regole");
        mniRegole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegoleActionPerformed(evt);
            }
        });
        jMenu2.add(mniRegole);

        mniAbout.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mniAbout.setText("About");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        jMenu2.add(mniAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiffActionPerformed
        btnDiff.setEnabled(false);
        sldDifficolta.setEnabled(false);
        volte=sldDifficolta.getValue();
        objGioco=new Gioco(volte);
        pnlScelta.setVisible(true);
        grid =new JLabel[sldDifficolta.getValue()][2*QUATTRO];
        for(int i=0;i<QUATTRO;i++){
            objGioco.generaCasuale(i);
        }
        inizializzaGioco(0,QUATTRO,pnlBoard,true);
        inizializzaGioco(QUATTRO,2*QUATTRO,pnlEsito,false);
        pnlBoard.setVisible(true);
        pnlEsito.setVisible(true);
    }//GEN-LAST:event_btnDiffActionPerformed

    private void btnVaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaiActionPerformed
        for(int i=0;i<QUATTRO;i++)
            objGioco.insNumeri(i, cbCol[i].getSelectedIndex());
        neri=objGioco.chkNumeri(neri);
        check=objGioco.stampaIndicazioni();
        for (int i=0;i<QUATTRO;i++){
            grid[conta][i].setIcon((ImageIcon)cbCol[i].getSelectedItem());
            switch (check.charAt(i)){
                case 'N': grid[conta][i+QUATTRO].setIcon(imgRes[0]);break;
                case 'B': grid[conta][i+QUATTRO].setIcon(imgRes[1]);break;
                case '.': grid[conta][i+QUATTRO].setIcon(imgRes[2]);break;
            }
        }
        volte--;conta++; 
        if(neri>=QUATTRO){
                JOptionPane.showMessageDialog(null, "Il gioco è finito! hai vinto in "+conta+" mosse", "Messaggio",JOptionPane.INFORMATION_MESSAGE);
                mniNuovaActionPerformed(evt);
                }   
        else  if(volte<1){
                JOptionPane.showMessageDialog(null, "Il gioco è finito! non hai vinto", "Messaggio",JOptionPane.ERROR_MESSAGE);
                mniNuovaActionPerformed(evt);
        }
        objGioco.stampaFinale();
    }//GEN-LAST:event_btnVaiActionPerformed

    private void mniNuovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNuovaActionPerformed
        dispose();
        Main main=new Main();
        main.setVisible(true);
    }//GEN-LAST:event_mniNuovaActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_mniExitActionPerformed

/**
 * il presente metodo crea un pannello cliccabile che apre il browser al click sul link
 * @param evt 
 */
    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");
        String msg = "<html><b>MisterMind Color</b> rel. 1.0.1<br>Il gioco è sviluppato da In4matika <br>Visita il sito:<br><u><a href=http://in4matika.altervista.org>in4matika.altervista.org</a></u></html>";
        jep.setText(msg);
        jep.setEditable(false);
        jep.addHyperlinkListener((HyperlinkEvent e) -> {
            if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
                System.out.println(e.getURL());
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(e.getURL().toURI());
                } catch (IOException | URISyntaxException ex) {
                }
            }
        });
       JOptionPane.showMessageDialog(rootPane,jep,"About",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mniAboutActionPerformed

    private void mniRegoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegoleActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Nel MasterMindColor si usano dei pioli di 8 colori differenti.\n" +
"Il Computer sceglie la combinazione di colori, il giocatore fa il suo primo tentativo, cercando di indovinare il codice.\nQuindi Il Computer, comunica:\n" +
"- con i pioli neri, il numero di colori giusti al posto giusto.\n" +
"- con i pioli bianchi, Il numero di colori giusti al posto sbagliato, cioè sono presenti nel codice, ma non al posto corretto.\n" +
"Non bisogna comunicare quali colori sono giusti o sbagliati ma solo quanti.\nSe il giocatore riesce ad indovinare il codice entro il numero di tentativi predeterminati \nallora vince la partita, altrimenti vince il Computer. ", "Regole Gioco:",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mniRegoleActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiff;
    private javax.swing.JButton btnVai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblDifficolta;
    private javax.swing.JLabel lblDifficolta1;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniNuova;
    private javax.swing.JMenuItem mniRegole;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlEsito;
    private javax.swing.JPanel pnlScelta;
    private javax.swing.JSlider sldDifficolta;
    // End of variables declaration//GEN-END:variables
}
