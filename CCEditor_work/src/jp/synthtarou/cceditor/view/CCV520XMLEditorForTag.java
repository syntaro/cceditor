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

import jp.synthtarou.cceditor.view.common.CCTextPrompt;
import jp.synthtarou.cceditor.view.common.CCPromptUtil;
import javax.swing.table.DefaultTableModel;
import jp.synthtarou.cceditor.xml.CCXMLNode;

/**
 *
 * @author Syntarou YOSHIDA
 */
public class CCV520XMLEditorForTag extends javax.swing.JPanel {
    final CCV500XMLRoot _root;

    /**
     * Creates new form DDEditorForTag
     */
    public CCV520XMLEditorForTag(CCV500XMLRoot root) {
        initComponents();
        _root = root;
    }
    
    public void setTargetNode(CCXMLNode node) {
        jTextFieldTagPath.setText(node.getAsPathString());
        jTextAreaTagText.setText(node.getTextContent());
        DefaultTableModel model = new DefaultTableModel() {
            @Override 
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Name");
        model.addColumn("Value");
        for (int i = 0; i < node.countAttribute(); ++ i) {
            model.addRow(new Object[] { node.getAttributeName(i), node.getAttributeText(i) });
        }
        jTable1.setModel(model);
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

        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonNewChildTag = new javax.swing.JButton();
        jButtonDeleteThisTag = new javax.swing.JButton();
        jButtonDuplicateThisTag = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaTagText = new javax.swing.JTextArea();
        jTextFieldTagPath = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonRemoveAttribute = new javax.swing.JButton();
        jButtonAddAttribute = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jSplitPane3.setDividerLocation(200);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonNewChildTag.setText("NewChildTag");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButtonNewChildTag, gridBagConstraints);

        jButtonDeleteThisTag.setText("-DeleteIt");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jButtonDeleteThisTag, gridBagConstraints);

        jButtonDuplicateThisTag.setText("Duplicate It");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jButtonDuplicateThisTag, gridBagConstraints);

        jLabel7.setText("Tag Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel1.add(jLabel7, gridBagConstraints);

        jTextAreaTagText.setEditable(false);
        jTextAreaTagText.setColumns(20);
        jTextAreaTagText.setRows(5);
        jTextAreaTagText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaTagTextMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTextAreaTagText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane4, gridBagConstraints);

        jTextFieldTagPath.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jTextFieldTagPath, gridBagConstraints);

        jLabel5.setText("Path in XML");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel5, gridBagConstraints);

        jSplitPane3.setLeftComponent(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tag's Attribuets Editor"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonRemoveAttribute.setText("- Delete Attribute");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jButtonRemoveAttribute, gridBagConstraints);

        jButtonAddAttribute.setText("+New Attribute");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jButtonAddAttribute, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane3, gridBagConstraints);

        jSplitPane3.setRightComponent(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jSplitPane3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAreaTagTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaTagTextMouseClicked
        String text = jTextAreaTagText.getText();
        CCTextPrompt prompt = new CCTextPrompt(text, "Tag Text");
        CCPromptUtil.showPrompt(this, prompt);
        text = prompt.getPromptResult();
        if (text != null) {
            jTextAreaTagText.setText(text);
        }
    }//GEN-LAST:event_jTextAreaTagTextMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAttribute;
    private javax.swing.JButton jButtonDeleteThisTag;
    private javax.swing.JButton jButtonDuplicateThisTag;
    private javax.swing.JButton jButtonNewChildTag;
    private javax.swing.JButton jButtonRemoveAttribute;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaTagText;
    private javax.swing.JTextField jTextFieldTagPath;
    // End of variables declaration//GEN-END:variables
}