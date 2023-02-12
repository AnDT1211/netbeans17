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

package org.netbeans.modules.j2ee.persistence.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import org.netbeans.modules.j2ee.metadata.model.api.MetadataModel;
import org.netbeans.modules.j2ee.persistence.api.EntityClassScope;
import org.netbeans.modules.j2ee.persistence.api.metadata.orm.Entity;
import org.netbeans.modules.j2ee.persistence.api.metadata.orm.EntityMappingsMetadata;
import org.netbeans.modules.j2ee.persistence.util.MetadataModelReadHelper;
import org.netbeans.modules.j2ee.persistence.util.MetadataModelReadHelper.State;
import org.openide.util.Exceptions;

/**
 * Panel for adding entities to persistence unit.
 *
 * @author  Erno Mononen, Andrei Badea
 */
public class AddEntityPanel extends javax.swing.JPanel {
    
    private final MetadataModelReadHelper<EntityMappingsMetadata, List<String>> readHelper;
    
    public static AddEntityPanel create(EntityClassScope entityClassScope, Set<String> ignoreClassNames) {
        AddEntityPanel panel = new AddEntityPanel(entityClassScope, ignoreClassNames);
        panel.initialize();
        return panel;
    }
    
    private AddEntityPanel(EntityClassScope entityClassScope, final Set<String> ignoreClassNames) {
        initComponents();
        MetadataModel<EntityMappingsMetadata> model = entityClassScope.getEntityMappingsModel(true);
        readHelper = MetadataModelReadHelper.create(model, (EntityMappingsMetadata metadata) -> {
            List<String> result = new ArrayList<>();
            for (Entity entity : metadata.getRoot().getEntity()) {
                String className = entity.getClass2();
                if (!ignoreClassNames.contains(className)) {
                    result.add(className);
                }
            }
            Collections.sort(result);
            return result;
        });
    }
    
    private void initialize() {
        readHelper.addChangeListener( (ChangeEvent e) -> {
            if (readHelper.getState() == State.FINISHED) {
                SwingUtilities.invokeLater( () -> {
                    try {
                        setEntityClassModel(readHelper.getResult());
                    } catch (ExecutionException e1) {
                        Exceptions.printStackTrace(e1);
                    }
                });
            }
        });
        readHelper.start();
    }
    
    private void setEntityClassModel(List<String> entityClassNames) {
        assert SwingUtilities.isEventDispatchThread();
        DefaultListModel model = new DefaultListModel();
        for (String each : entityClassNames) {
            model.addElement(each);
        }
        entityList.setModel(model);
    }
    
    /**
     * @return fully qualified names of the selected entities' classes.
     */
    public List<String> getSelectedEntityClasses(){
        List<String> result = new ArrayList<>();
        for (Object elem : entityList.getSelectedValues()) {
            result.add((String)elem);
        }
        return result;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        entityList = new javax.swing.JList();

        jScrollPane1.setViewportView(entityList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList entityList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
