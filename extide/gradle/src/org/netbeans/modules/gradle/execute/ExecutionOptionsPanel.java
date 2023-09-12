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
package org.netbeans.modules.gradle.execute;

import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import org.netbeans.modules.gradle.api.execute.GradleCommandLine;
import org.netbeans.modules.gradle.api.execute.GradleCommandLine.LogLevel;
import org.netbeans.modules.gradle.api.execute.GradleCommandLine.StackTrace;
import static org.netbeans.modules.gradle.api.execute.GradleCommandLine.*;
import static org.netbeans.modules.gradle.api.execute.GradleCommandLine.Flag.*;
import static org.netbeans.modules.gradle.api.execute.GradleCommandLine.Parameter.*;

/**
 *
 * @author lkishalmi
 */
public class ExecutionOptionsPanel extends javax.swing.JPanel {
    
    private static final GradleCommandLine CLI_MASK = new GradleCommandLine(
        "--no-rebuild", 
        "--offline", 
        "-x", TEST_TASK, 
        "-x", CHECK_TASK,
        "--quiet",
        "--info",
        "--debug",
        "--warn",
        "--configure-on-demand",
        "--stacktrace",
        "--full-stacktrace"
    );

    /**
     * Creates new form ExecutionOptionsPanel
     */
    public ExecutionOptionsPanel() {
        initComponents();
        cbLogLevel.setModel(new DefaultComboBoxModel<>(LogLevel.values()));
        cbStackTrace.setModel(new DefaultComboBoxModel<>(StackTrace.values()));
    }

    public void setCommandLine(GradleCommandLine cli) {
        cbNoRebuild.setSelected(cli.hasFlag(NO_REBUILD));
        cbOffline.setSelected(cli.hasFlag(OFFLINE));
        cbConfigureOnDemand.setSelected(cli.hasFlag(CONFIGURE_ON_DEMAND));
        Set<String> excluded = cli.getExcludedTasks();
        cbSkipCheck.setSelected(excluded.contains(CHECK_TASK));
        cbSkipTest.setSelected(excluded.contains(TEST_TASK)); 
        cbLogLevel.setSelectedIndex(cli.getLoglevel().ordinal());
        cbStackTrace.setSelectedIndex(cli.getStackTrace().ordinal());
    }
    
    public GradleCommandLine getCommandLine() {
        GradleCommandLine ret = new GradleCommandLine();
        ret.setFlag(OFFLINE, cbOffline.isSelected());
        ret.setFlag(NO_REBUILD, cbNoRebuild.isSelected());
        ret.setFlag(CONFIGURE_ON_DEMAND, cbConfigureOnDemand.isSelected());
        ret.setLogLevel((LogLevel) cbLogLevel.getSelectedItem());
        ret.setStackTrace((StackTrace) cbStackTrace.getSelectedItem());
        if (cbSkipCheck.isSelected()) {
            ret.addParameter(EXCLUDE_TASK, CHECK_TASK);
        }
        if (cbSkipTest.isSelected()) {
            ret.addParameter(EXCLUDE_TASK, TEST_TASK);
        }
        return ret;
    }
    
    public static GradleCommandLine getCLIMask() {
        return new GradleCommandLine(CLI_MASK);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOffline = new javax.swing.JCheckBox();
        cbSkipTest = new javax.swing.JCheckBox();
        cbSkipCheck = new javax.swing.JCheckBox();
        cbNoRebuild = new javax.swing.JCheckBox();
        cbConfigureOnDemand = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        cbLogLevel = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbStackTrace = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbOffline, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.cbOffline.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbSkipTest, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.cbSkipTest.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbSkipCheck, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.cbSkipCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbNoRebuild, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.cbNoRebuild.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbConfigureOnDemand, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.cbConfigureOnDemand.text")); // NOI18N

        jLabel1.setLabelFor(cbLogLevel);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.jLabel1.text")); // NOI18N

        jLabel2.setLabelFor(cbStackTrace);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ExecutionOptionsPanel.class, "ExecutionOptionsPanel.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNoRebuild, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(cbOffline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbConfigureOnDemand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSkipTest, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSkipCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLogLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStackTrace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOffline)
                    .addComponent(cbSkipCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNoRebuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSkipTest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbConfigureOnDemand)
                    .addComponent(jLabel1)
                    .addComponent(cbLogLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbStackTrace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbConfigureOnDemand;
    private javax.swing.JComboBox<LogLevel> cbLogLevel;
    private javax.swing.JCheckBox cbNoRebuild;
    private javax.swing.JCheckBox cbOffline;
    private javax.swing.JCheckBox cbSkipCheck;
    private javax.swing.JCheckBox cbSkipTest;
    private javax.swing.JComboBox<StackTrace> cbStackTrace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
