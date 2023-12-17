/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.cnd.meson.project.ui;

import java.awt.event.ItemEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import static org.netbeans.modules.cnd.meson.project.ActionProviderImpl.COMMAND_SETUP;
import org.netbeans.modules.cnd.meson.project.Configuration;
import org.netbeans.modules.cnd.meson.project.ConfigurationProvider;
import org.netbeans.modules.cnd.meson.project.MesonProject;
import static org.netbeans.spi.project.ActionProvider.COMMAND_BUILD;
import static org.netbeans.spi.project.ActionProvider.COMMAND_TEST;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;


/**
 *
 */
public class ConfigurationPanel extends javax.swing.JPanel
{

    /**
     * Creates new form MesonProjectOptionsPanel
     */
    public ConfigurationPanel(String projectRoot)
    {
        this.projectRoot = projectRoot;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buildDirectoryTextField = new javax.swing.JTextField();
        buildDirectoryLabel = new javax.swing.JLabel();
        buildDirectoryBrowseButton = new javax.swing.JButton();
        buildTypeLabel = new javax.swing.JLabel();
        buildTypeComboBox = new javax.swing.JComboBox<>();
        wrapModeLabel = new javax.swing.JLabel();
        wrapModeComboBox = new javax.swing.JComboBox<>();
        backendLabel = new javax.swing.JLabel();
        backendComboBox = new javax.swing.JComboBox<>();
        configurationLabel = new javax.swing.JLabel();
        configurationComboBox = new javax.swing.JComboBox<>();
        newConfigurationButton = new javax.swing.JButton();
        deleteConfigurationButton = new javax.swing.JButton();
        renameConfigurationButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        additionalArgumentsTable = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        runExecutableLabel = new javax.swing.JLabel();
        runExecutableTextField = new javax.swing.JTextField();
        runExecutableBrowseButton = new javax.swing.JButton();
        runArgumentsLabel = new javax.swing.JLabel();
        runArgumentsTextField = new javax.swing.JTextField();
        runDirectoryLabel = new javax.swing.JLabel();
        runDirectoryBrowseButton = new javax.swing.JButton();
        runDirectoryTextField = new javax.swing.JTextField();

        buildDirectoryTextField.setText(org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.buildDirectoryTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buildDirectoryLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.buildDirectoryLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buildDirectoryBrowseButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.buildDirectoryBrowseButton.text")); // NOI18N
        buildDirectoryBrowseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buildDirectoryBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buildTypeLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.buildTypeLabel.text")); // NOI18N

        buildTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "plain", "debug", "debugoptimized", "release", "minsize", "custom" }));
        buildTypeComboBox.setSelectedIndex(1);

        org.openide.awt.Mnemonics.setLocalizedText(wrapModeLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.wrapModeLabel.text")); // NOI18N

        wrapModeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "default", "nofallback", "nodownload", "forcefallback", "nopromote" }));

        org.openide.awt.Mnemonics.setLocalizedText(backendLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.backendLabel.text")); // NOI18N

        backendComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ninja", "vs", "vs2010", "vs2012", "vs2013", "vs2015", "vs2017", "vs2019", "vs2022", "xcode", "none" }));

        org.openide.awt.Mnemonics.setLocalizedText(configurationLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.configurationLabel.text")); // NOI18N

        configurationComboBox.setModel(configurationComboBoxModel);
        configurationComboBox.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                configurationComboBoxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(newConfigurationButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.newConfigurationButton.text")); // NOI18N
        newConfigurationButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newConfigurationButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteConfigurationButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.deleteConfigurationButton.text")); // NOI18N
        deleteConfigurationButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteConfigurationButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(renameConfigurationButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.renameConfigurationButton.text")); // NOI18N
        renameConfigurationButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                renameConfigurationButtonActionPerformed(evt);
            }
        });

        additionalArgumentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {"setup", null},
                {"compile", null},
                {"test", null}
            },
            new String []
            {
                "Command", "Additional Arguments"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, true
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        additionalArgumentsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        additionalArgumentsTable.getColumnModel().getColumn(0).setMinWidth(100);
        additionalArgumentsTable.getColumnModel().getColumn(0).setMaxWidth(150);
        jScrollPane1.setViewportView(additionalArgumentsTable);

        org.openide.awt.Mnemonics.setLocalizedText(runExecutableLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runExecutableLabel.text")); // NOI18N

        runExecutableTextField.setText(org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runExecutableTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(runExecutableBrowseButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runExecutableBrowseButton.text")); // NOI18N
        runExecutableBrowseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                runExecutableBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(runArgumentsLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runArgumentsLabel.text")); // NOI18N

        runArgumentsTextField.setText(org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runArgumentsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(runDirectoryLabel, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runDirectoryLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(runDirectoryBrowseButton, org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runDirectoryBrowseButton.text")); // NOI18N
        runDirectoryBrowseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                runDirectoryBrowseButtonActionPerformed(evt);
            }
        });

        runDirectoryTextField.setText(org.openide.util.NbBundle.getMessage(ConfigurationPanel.class, "ConfigurationPanel.runDirectoryTextField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(runExecutableLabel)
                            .addComponent(runArgumentsLabel)
                            .addComponent(runDirectoryLabel))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(runArgumentsTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(runDirectoryTextField)
                            .addComponent(runExecutableTextField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(runExecutableBrowseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(runDirectoryBrowseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buildDirectoryLabel)
                            .addComponent(buildTypeLabel)
                            .addComponent(backendLabel)
                            .addComponent(configurationLabel)
                            .addComponent(wrapModeLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buildTypeComboBox, 0, 542, Short.MAX_VALUE)
                                    .addComponent(buildDirectoryTextField)
                                    .addComponent(backendComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(wrapModeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(buildDirectoryBrowseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(configurationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newConfigurationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(renameConfigurationButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteConfigurationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configurationLabel)
                    .addComponent(configurationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newConfigurationButton)
                    .addComponent(deleteConfigurationButton)
                    .addComponent(renameConfigurationButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buildDirectoryLabel)
                    .addComponent(buildDirectoryBrowseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buildTypeLabel)
                            .addComponent(buildTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backendLabel)
                            .addComponent(backendComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wrapModeLabel)
                            .addComponent(wrapModeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(runExecutableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runExecutableLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(runArgumentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runArgumentsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(runDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runDirectoryLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(runExecutableBrowseButton)
                        .addGap(70, 70, 70)
                        .addComponent(runDirectoryBrowseButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void renameConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_renameConfigurationButtonActionPerformed
    {//GEN-HEADEREND:event_renameConfigurationButtonActionPerformed
        final String oldName = configurationComboBox.getSelectedItem().toString();

        String newName =
            (String)JOptionPane.showInputDialog(
                this,
                "Please enter a new name for the \"" + oldName + "\" configuration.",
                "Rename Configuration",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                oldName);

        if ((newName != null) && !newName.equals(oldName)) {
            boolean alreadyExists = false;
            for (Configuration cfg: configurations) {
                if (newName.equals(cfg.getDisplayName())) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                for (Configuration cfg: configurations) {
                    if (oldName.equals(cfg.getDisplayName())) {
                        cfg.setDisplayName(newName);
                        if (cfg.getBuildDirectory().equals(Paths.get(MesonProject.BUILD_DIRECTORY, oldName).toString())) {
                            cfg.setBuildDirectory(Paths.get(MesonProject.BUILD_DIRECTORY, newName).toString());
                            buildDirectoryTextField.setText(cfg.getBuildDirectory());
                        }
                        configurationComboBoxModel.setSelectedItem(newName);
                        configurationComboBoxModel.configurationsChanged();
                        break;
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(
                    this,
                    "Failed to rename configuration because a configuration named \"" + newName + "\" already exsits.",
                    "Rename Configuration Failed",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_renameConfigurationButtonActionPerformed

    private void buildDirectoryBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buildDirectoryBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_buildDirectoryBrowseButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(Paths.get(projectRoot, buildDirectoryTextField.getText()).toFile());
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setFileHidingEnabled(false);
        final int result = chooser.showDialog(this, "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            buildDirectoryTextField.setText(
                Paths.get(projectRoot).relativize(chooser.getSelectedFile().toPath()).toString());
        }
    }//GEN-LAST:event_buildDirectoryBrowseButtonActionPerformed

    private void configurationComboBoxItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_configurationComboBoxItemStateChanged
    {//GEN-HEADEREND:event_configurationComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            final String selectedCfg = evt.getItem().toString();

            for (Configuration cfg: configurations) {
                if (selectedCfg.equals(cfg.getDisplayName())) {
                    toUI(cfg);
                    break;
                }
            }
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            final String selectedCfg = evt.getItem().toString();

            for (Configuration cfg: configurations) {
                if (selectedCfg.equals(cfg.getDisplayName())) {
                    fromUI(cfg);
                    break;
                }
            }
        }
    }//GEN-LAST:event_configurationComboBoxItemStateChanged

    private void newConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newConfigurationButtonActionPerformed
    {//GEN-HEADEREND:event_newConfigurationButtonActionPerformed
        String cfgName =
            JOptionPane.showInputDialog(
                this,
                "Please enter a name for the new configuration.",
                "New Configuration",
                JOptionPane.PLAIN_MESSAGE);

        if (cfgName != null) {
            boolean alreadyExists = false;
            for (Configuration cfg: configurations) {
                if (cfgName.equals(cfg.getDisplayName())) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                Configuration cfg = Configuration.getDefault();
                cfg.setDisplayName(cfgName);
                cfg.setBuildDirectory(Paths.get(MesonProject.BUILD_DIRECTORY, cfgName).toString());
                configurations.add(cfg);
                configurationComboBoxModel.configurationsChanged();
                configurationComboBox.setSelectedItem(cfgName);
            }
            else {
                JOptionPane.showMessageDialog(
                    this,
                    "Failed to create new configuration because a configuration named \"" + cfgName + "\" already exsits.",
                    "Create Configuration Failed",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_newConfigurationButtonActionPerformed

    private void deleteConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteConfigurationButtonActionPerformed
    {//GEN-HEADEREND:event_deleteConfigurationButtonActionPerformed
        final String cfgName = configurationComboBox.getSelectedItem().toString();

        if (configurations.size() > 1) {
            for (Configuration cfg: configurations) {
                if (cfgName.equals(cfg.getDisplayName())) {
                    configurations.remove(cfg);
                    configurationComboBoxModel.setSelectedItem(configurations.get(0).getDisplayName());
                    configurationComboBoxModel.configurationsChanged();
                    toUI(configurations.get(0));
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(
                this,
                "Cannot delete the \"" + cfgName + "\" configuration because it's the last one and at least one configuration must exist.",
                "Delete Configuration Failed",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteConfigurationButtonActionPerformed

    private void runExecutableBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_runExecutableBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_runExecutableBrowseButtonActionPerformed
        JFileChooser chooser = new JFileChooser();

        if (runExecutableTextField.getText().isEmpty()) {
            chooser.setCurrentDirectory(Paths.get(projectRoot, buildDirectoryTextField.getText()).toFile());
        }
        else {
            chooser.setSelectedFile(Paths.get(projectRoot, runExecutableTextField.getText()).toFile());
        }
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileHidingEnabled(false);
        final int result = chooser.showDialog(this, "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            runExecutableTextField.setText(
                Paths.get(projectRoot).relativize(chooser.getSelectedFile().toPath()).toString());
        }
    }//GEN-LAST:event_runExecutableBrowseButtonActionPerformed

    private void runDirectoryBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_runDirectoryBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_runDirectoryBrowseButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        if (runDirectoryTextField.getText().isEmpty()) {
            chooser.setCurrentDirectory(Paths.get(projectRoot).toFile());
        }
        else {
            chooser.setSelectedFile(Paths.get(projectRoot, runDirectoryTextField.getText()).toFile());
        }
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setFileHidingEnabled(false);
        final int result = chooser.showDialog(this, "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            runDirectoryTextField.setText(
                Paths.get(projectRoot).relativize(chooser.getSelectedFile().toPath()).toString());
        }
    }//GEN-LAST:event_runDirectoryBrowseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable additionalArgumentsTable;
    private javax.swing.JComboBox<String> backendComboBox;
    private javax.swing.JLabel backendLabel;
    private javax.swing.JButton buildDirectoryBrowseButton;
    private javax.swing.JLabel buildDirectoryLabel;
    private javax.swing.JTextField buildDirectoryTextField;
    private javax.swing.JComboBox<String> buildTypeComboBox;
    private javax.swing.JLabel buildTypeLabel;
    private javax.swing.JComboBox<String> configurationComboBox;
    private javax.swing.JLabel configurationLabel;
    private javax.swing.JButton deleteConfigurationButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newConfigurationButton;
    private javax.swing.JButton renameConfigurationButton;
    private javax.swing.JLabel runArgumentsLabel;
    private javax.swing.JTextField runArgumentsTextField;
    private javax.swing.JButton runDirectoryBrowseButton;
    private javax.swing.JLabel runDirectoryLabel;
    private javax.swing.JTextField runDirectoryTextField;
    private javax.swing.JButton runExecutableBrowseButton;
    private javax.swing.JLabel runExecutableLabel;
    private javax.swing.JTextField runExecutableTextField;
    private javax.swing.JComboBox<String> wrapModeComboBox;
    private javax.swing.JLabel wrapModeLabel;
    // End of variables declaration//GEN-END:variables

    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType=MesonProject.PROJECT_KEY, position=220)
    public static ProjectCustomizer.CompositeCategoryProvider createCategoryProvider() {
        return new ProjectCustomizer.CompositeCategoryProvider() {
            @Override
            public ProjectCustomizer.Category createCategory(Lookup context) {
                return ProjectCustomizer.Category.create("configuration", "Configuration", null);
            }
            @Override
            public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
                MesonProject project = context.lookup(MesonProject.class);
                ConfigurationPanel panel = new ConfigurationPanel(project.getProjectDirectory().getPath());
                panel.load(project.getConfigurationProvider());
                category.setOkButtonListener(evt -> {
                    panel.commit(project.getConfigurationProvider());
                });
                category.setStoreListener(evt -> {
                    project.getConfigurationProvider().save();
                });
                return panel;
            }
        };
    }

    private final String projectRoot;
    private List<Configuration> configurations = new ArrayList<>();

    private final class ConfigurationComboBoxModel implements ComboBoxModel<String> {
        private String selectedItem = null;
        private ListDataListener listener = null;

        @Override
        public void setSelectedItem(Object o) {
            selectedItem = o.toString();
        }

        @Override
        public Object getSelectedItem() {
            return selectedItem;
        }

        @Override
        public int getSize() {
            return configurations.size();
        }

        @Override
        public String getElementAt(int i) {
            return configurations.get(i).getDisplayName();
        }

        @Override
        public void addListDataListener(ListDataListener ll) {
            listener = ll;
        }

        @Override
        public void removeListDataListener(ListDataListener ll) {
            if (listener == ll) {
                listener = null;
            }
        }

        public void configurationsChanged() {
            if (selectedItem != null) {
                boolean found = false;
                for (Configuration cfg: configurations) {
                    if (selectedItem.equals(cfg.getDisplayName())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    selectedItem = null;
                }
            }

            if (listener != null) {
                listener.contentsChanged(
                    new ListDataEvent(
                        this,
                        ListDataEvent.CONTENTS_CHANGED,
                        0,
                        getSize() - 1));
            }

            if ((selectedItem == null) && !configurations.isEmpty()) {
                configurationComboBox.setSelectedItem(
                    configurations.get(0).getDisplayName());
            }
        }
    }

    private ConfigurationComboBoxModel configurationComboBoxModel = new ConfigurationComboBoxModel();

    private void load(ConfigurationProvider provider) {
        for (Configuration cfg: provider.getConfigurations()) {
            configurations.add(new Configuration(cfg));
        }
        configurationComboBoxModel.configurationsChanged();
        configurationComboBox.setSelectedItem(
            provider.getActiveConfiguration().getDisplayName());
    }

    private void commit(ConfigurationProvider provider) {
        final String selectedCfg = configurationComboBox.getSelectedItem().toString();

        for (Configuration cfg: configurations) {
            if (selectedCfg.equals(cfg.getDisplayName())) {
                fromUI(cfg);
                break;
            }
        }

        provider.setConfigurations(configurations);
    }

    private void toUI(Configuration cfg) {
        buildDirectoryTextField.setText(cfg.getBuildDirectory());
        buildTypeComboBox.setSelectedItem(cfg.getBuildType());
        backendComboBox.setSelectedItem(cfg.getBackend());
        wrapModeComboBox.setSelectedItem(cfg.getWrapMode());
        additionalArgumentsTable.setValueAt(cfg.getAdditionalArgumentsFor(COMMAND_SETUP), 0, 1);
        additionalArgumentsTable.setValueAt(cfg.getAdditionalArgumentsFor(COMMAND_BUILD), 1, 1);
        additionalArgumentsTable.setValueAt(cfg.getAdditionalArgumentsFor(COMMAND_TEST), 2, 1);
        runExecutableTextField.setText(cfg.getRunExecutable());
        runArgumentsTextField.setText(cfg.getRunArguments());
        runDirectoryTextField.setText(cfg.getRunDirectory());
    }

    private void fromUI(Configuration cfg) {
        cfg.setBuildDirectory(buildDirectoryTextField.getText());
        cfg.setBuildType(buildTypeComboBox.getSelectedItem().toString());
        cfg.setBackend(backendComboBox.getSelectedItem().toString());
        cfg.setWrapMode(wrapModeComboBox.getSelectedItem().toString());
        cfg.setAdditionalArgumentsFor(COMMAND_SETUP, additionalArgumentsTable.getValueAt(0, 1).toString());
        cfg.setAdditionalArgumentsFor(COMMAND_BUILD, additionalArgumentsTable.getValueAt(1, 1).toString());
        cfg.setAdditionalArgumentsFor(COMMAND_TEST, additionalArgumentsTable.getValueAt(2, 1).toString());
        cfg.setRunExecutable(runExecutableTextField.getText());
        cfg.setRunArguments(runArgumentsTextField.getText());
        cfg.setRunDirectory(runDirectoryTextField.getText());
    }
}
