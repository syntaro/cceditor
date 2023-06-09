/*
 * Copyright 2023 Syntarou YOSHIDA.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.synthtarou.cceditor.view;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import jp.synthtarou.cceditor.view.common.AnotherTableData;
import jp.synthtarou.cceditor.view.common.AnotherTableData2;
import jp.synthtarou.cceditor.view.common.IPrompt;
import jp.synthtarou.cceditor.view.common.CCPromptUtil;
import jp.synthtarou.cceditor.common.CCUtilities;
import jp.synthtarou.cceditor.xml.CCXMLManagerPanel;

/**
 *
 * @author Syntarou YOSHIDA
 */
public class CCV10Kontrol extends javax.swing.JPanel {
    
    /**
     * Creates new form Panel03ControllerList
     */
    public CCV10Kontrol() {
        initComponents();
        
        _model = new AnotherTableData2();
        jTable1.setModel(_model);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (jTable1 != null) {
                    CCUtilities.autoResizeTableLastColumnWidth(jScrollPane1, jTable1);
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
                updateUI();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }
    
    public void updateUI() {
        super.updateUI();
        if (jTable1 != null) {
            CCUtilities.autoResizeTableColumnWidth(jScrollPane1, jTable1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButtonEdirXMLCC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSliderValue = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonValue = new javax.swing.JButton();
        jButtonPort = new javax.swing.JButton();
        jButtonPlusOne = new javax.swing.JButton();
        jButtonMinusOne = new javax.swing.JButton();
        jButtonEditOne = new javax.swing.JButton();
        jLabelChannel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jButtonEdirXMLCC.setText("XML Manager");
        jButtonEdirXMLCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdirXMLCCActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        add(jButtonEdirXMLCC, gridBagConstraints);

        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jSliderValue, gridBagConstraints);

        jLabel1.setText("Value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Gate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel2, gridBagConstraints);

        jButtonValue.setText("127");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButtonValue, gridBagConstraints);

        jButtonPort.setText("MIDI Manager");
        jButtonPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPortActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButtonPort, gridBagConstraints);

        jButtonPlusOne.setText("+ Plus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButtonPlusOne, gridBagConstraints);

        jButtonMinusOne.setText("- Minus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButtonMinusOne, gridBagConstraints);

        jButtonEditOne.setText("Edit");
        jButtonEditOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButtonEditOne, gridBagConstraints);

        jLabelChannel.setText("CH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelChannel, gridBagConstraints);

        jButton1.setText("CH1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton1, gridBagConstraints);

        jButton2.setText("C4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEdirXMLCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdirXMLCCActionPerformed
        CCXMLManagerPanel panel = new CCXMLManagerPanel();
        CCPromptUtil.showPrompt(this, panel);
    }//GEN-LAST:event_jButtonEdirXMLCCActionPerformed

    private void jButtonPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPortActionPerformed
        IPrompt panel = new CCV14MIDISelector();
        CCPromptUtil.showPrompt(this, panel);
    }//GEN-LAST:event_jButtonPortActionPerformed

    private void jButtonEditOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditOneActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            _model.startEdit(this, row);
            jTable1.setModel(_model);
            updateUI();
        }
    }//GEN-LAST:event_jButtonEditOneActionPerformed
    
    AnotherTableData _model;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEdirXMLCC;
    private javax.swing.JButton jButtonEditOne;
    private javax.swing.JButton jButtonMinusOne;
    private javax.swing.JButton jButtonPlusOne;
    private javax.swing.JButton jButtonPort;
    private javax.swing.JButton jButtonValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelChannel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderValue;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
