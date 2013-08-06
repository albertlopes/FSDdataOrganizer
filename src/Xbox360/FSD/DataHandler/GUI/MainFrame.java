package Xbox360.FSD.DataHandler.GUI;

import Xbox360.FSD.DataHandler.Main.Main;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Albert_Dark
 */
public class MainFrame extends javax.swing.JFrame {

    Main main = new Main();
    boolean listItems = false;
    boolean noSort = false;
    boolean caps = false;
    boolean delfav = false;
    boolean delrat = false;
    boolean delrec = false;
    File file;

    public MainFrame() {
        initComponents();

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frm_SelectFile = new javax.swing.JFrame();
        fc_SelecFile = new javax.swing.JFileChooser();
        btn_SelectFile = new javax.swing.JButton();
        chk_CleanFavs = new javax.swing.JCheckBox();
        chk_CleanRecent = new javax.swing.JCheckBox();
        chk_CleanRatting = new javax.swing.JCheckBox();
        chk_Dontorganize = new javax.swing.JCheckBox();
        chk_ListItens = new javax.swing.JCheckBox();
        lbl_MainLabel = new javax.swing.JLabel();
        lbl_MainOptions = new javax.swing.JLabel();
        chk_Capitalize = new javax.swing.JCheckBox();
        lbl_Cleanoptions = new javax.swing.JLabel();
        sp_MainText = new javax.swing.JScrollPane();
        txt_MainText = new javax.swing.JTextArea();
        btn_Start = new javax.swing.JButton();

        fc_SelecFile.setDialogTitle("Open fs2data.db");

        javax.swing.GroupLayout frm_SelectFileLayout = new javax.swing.GroupLayout(frm_SelectFile.getContentPane());
        frm_SelectFile.getContentPane().setLayout(frm_SelectFileLayout);
        frm_SelectFileLayout.setHorizontalGroup(
            frm_SelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frm_SelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fc_SelecFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frm_SelectFileLayout.setVerticalGroup(
            frm_SelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frm_SelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fc_SelecFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 510));
        setResizable(false);

        btn_SelectFile.setText("Open fs2data.db");
        btn_SelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectFileActionPerformed(evt);
            }
        });

        chk_CleanFavs.setText("Clean all Favorites");
        chk_CleanFavs.setEnabled(false);

        chk_CleanRecent.setText("Clean all Recent playeds");
        chk_CleanRecent.setEnabled(false);

        chk_CleanRatting.setText("Clean all Users Rattings");
        chk_CleanRatting.setEnabled(false);

        chk_Dontorganize.setText("Don't Organize");
        chk_Dontorganize.setEnabled(false);

        chk_ListItens.setSelected(true);
        chk_ListItens.setText("List Itens");
        chk_ListItens.setEnabled(false);

        lbl_MainLabel.setText("FSD2 DATABASE ORGANIZER");

        lbl_MainOptions.setText("Main Options");
        lbl_MainOptions.setEnabled(false);
        lbl_MainOptions.setFocusable(false);

        chk_Capitalize.setText("Capitalize Titles");
        chk_Capitalize.setEnabled(false);

        lbl_Cleanoptions.setText("Clean Options");
        lbl_Cleanoptions.setEnabled(false);
        lbl_Cleanoptions.setFocusable(false);

        txt_MainText.setColumns(20);
        txt_MainText.setEditable(false);
        txt_MainText.setRows(5);
        txt_MainText.setText("Main Options ::\n\n- Capitalize will made your game tiltles looks like this:\n   GAME TITLE = Game Title\n   GaME tiTlE = Game Title\n   game title = Game Title\n\n- Don't organize: if you like your games ordered by date added use this. \n\n- List Itens: Will list your itens here in the end.\n\nClean Options ::\n\n- All clean options will delete only references in database for \nall profiles, not the game.\n");
        sp_MainText.setViewportView(txt_MainText);

        btn_Start.setText("Start ");
        btn_Start.setToolTipText("Start with selected options. ");
        btn_Start.setEnabled(false);
        btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_MainText, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_Capitalize)
                            .addComponent(lbl_MainOptions)
                            .addComponent(chk_Dontorganize)
                            .addComponent(chk_ListItens)
                            .addComponent(btn_SelectFile))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chk_CleanFavs)
                                    .addComponent(lbl_Cleanoptions)
                                    .addComponent(chk_CleanRatting, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE))
                            .addComponent(chk_CleanRecent))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_SelectFile)
                    .addComponent(btn_Start))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MainOptions)
                    .addComponent(lbl_Cleanoptions, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_Capitalize)
                    .addComponent(chk_CleanRatting))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_Dontorganize)
                    .addComponent(chk_CleanFavs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_CleanRecent)
                    .addComponent(chk_ListItens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(sp_MainText, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectFileActionPerformed


        int returnVal = fc_SelecFile.showOpenDialog(frm_SelectFile);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            file = fc_SelecFile.getSelectedFile();

            btn_SelectFile.setText("File Opened");
            btn_Start.setEnabled(true);

            chk_Capitalize.setEnabled(true);
            chk_CleanFavs.setEnabled(true);
            chk_CleanRatting.setEnabled(true);
            chk_CleanRecent.setEnabled(true);
            chk_Dontorganize.setEnabled(true);
            chk_ListItens.setEnabled(true);

            lbl_Cleanoptions.setEnabled(true);
            lbl_MainLabel.setEnabled(true);
            lbl_MainOptions.setEnabled(true);



        } else {
            
        }

    }//GEN-LAST:event_btn_SelectFileActionPerformed

    private void btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartActionPerformed

        listItems = chk_ListItens.isSelected();
        noSort = chk_Dontorganize.isSelected();
        caps = chk_Capitalize.isSelected();
        delfav = chk_CleanFavs.isSelected();
        delrat = chk_CleanRatting.isSelected();
        delrec = chk_CleanRecent.isSelected();
        
        txt_MainText.append("\n");

    }//GEN-LAST:event_btn_StartActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
            
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SelectFile;
    private javax.swing.JButton btn_Start;
    private javax.swing.JCheckBox chk_Capitalize;
    private javax.swing.JCheckBox chk_CleanFavs;
    private javax.swing.JCheckBox chk_CleanRatting;
    private javax.swing.JCheckBox chk_CleanRecent;
    private javax.swing.JCheckBox chk_Dontorganize;
    private javax.swing.JCheckBox chk_ListItens;
    private javax.swing.JFileChooser fc_SelecFile;
    private javax.swing.JFrame frm_SelectFile;
    private javax.swing.JLabel lbl_Cleanoptions;
    private javax.swing.JLabel lbl_MainLabel;
    private javax.swing.JLabel lbl_MainOptions;
    private javax.swing.JScrollPane sp_MainText;
    private javax.swing.JTextArea txt_MainText;
    // End of variables declaration//GEN-END:variables
}
