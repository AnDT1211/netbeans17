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

package org.netbeans.modules.j2ee.ejbcore.ejb.wizard.dd;

import java.awt.Component;
import java.io.IOException;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.j2ee.core.Profile;
import org.netbeans.api.project.Project;
import org.netbeans.modules.j2ee.api.ejbjar.EjbJar;
import org.netbeans.modules.j2ee.deployment.devmodules.api.J2eeModule;
import org.netbeans.modules.j2ee.deployment.devmodules.spi.J2eeModuleProvider;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Martin Adamek
 */
public final class EjbJarXmlWizardIterator implements WizardDescriptor.InstantiatingIterator {

    // generated by apisupport wizard

    private int index;

    private WizardDescriptor wizard;
    private WizardDescriptor.Panel[] panels;

    /**
     * Initialize panels representing individual wizard's steps and sets
     * various properties for them influencing wizard appearance.
     */
    private WizardDescriptor.Panel[] getPanels() {
        if (panels == null) {
            panels = new WizardDescriptor.Panel[] {
                new EjbJarXmlWizardPanel1()
            };
            String[] steps = createSteps();
            for (int i = 0; i < panels.length; i++) {
                Component component = panels[i].getComponent();
                if (steps[i] == null) {
                    // Default step name to component name of panel. Mainly
                    // useful for getting the name of the target chooser to
                    // appear in the list of steps.
                    steps[i] = component.getName();
                }
                if (component instanceof JComponent) { // assume Swing components
                    JComponent jComponent = (JComponent) component;
                    // Sets step number of a component
                    jComponent.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                    // Sets steps names for a panel
                    jComponent.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                    // Turn on subtitle creation on each step
                    jComponent.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, Boolean.TRUE);
                    // Show steps on the left side with the image on the background
                    jComponent.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, Boolean.TRUE);
                    // Turn on numbering of all steps
                    jComponent.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, Boolean.TRUE);
                }
            }
        }
        return panels;
    }

    public Set instantiate() throws IOException {
        FileObject confRoot = ((EjbJarXmlWizardPanel1) panels[0]).getSelectedLocation();
        Project project = ((EjbJarXmlWizardPanel1) panels[0]).getProject();
        J2eeModuleProvider j2eeModuleProvider = project.getLookup().lookup(J2eeModuleProvider.class);
        J2eeModule j2eeModule = j2eeModuleProvider.getJ2eeModule();
        Profile j2eeProfile = EjbJar.getEjbJar(confRoot).getJ2eeProfile();
        if (confRoot != null) {
            String resource;
            // see #213631 - caused by fact that EJB DD schemas have different numbering than WEB DD schemas
            //   (so Java EE6 Web-DD is of the version 3.0, but Ejb-DD is of the version 3.1)
            if (j2eeProfile != null && j2eeProfile.isAtLeast(Profile.JAKARTA_EE_9_WEB)) {
                resource = "org-netbeans-modules-j2ee-ejbjarproject/ejb-jar-4.0.xml";
            } else if (j2eeProfile != null && j2eeProfile.isAtLeast(Profile.JAVA_EE_7_WEB)) {
                resource = "org-netbeans-modules-j2ee-ejbjarproject/ejb-jar-3.2.xml";
            } else if (j2eeProfile != null && j2eeProfile.isAtLeast(Profile.JAVA_EE_6_WEB)) {
                // ee6 web module is of the version 3.0 but the ee6 deployment descriptor schema should be of version 3.1
                resource = "org-netbeans-modules-j2ee-ejbjarproject/ejb-jar-3.1.xml";
            } else if (j2eeModule != null) {
                resource = "org-netbeans-modules-j2ee-ejbjarproject/ejb-jar-" + j2eeModule.getModuleVersion() + ".xml";
            } else {
                return Collections.EMPTY_SET;
            }
            FileObject source = FileUtil.getConfigFile(resource);
            if (source == null) {
                throw new NullPointerException("Could not find source file: " + resource);
            }
            FileObject ddFile = FileUtil.copyFile(source, confRoot, "ejb-jar"); //NOI18N
            return Collections.singleton(ddFile);
        }
        return Collections.EMPTY_SET;
    }

    public void initialize(WizardDescriptor wizard) {
        this.wizard = wizard;
    }

    public void uninitialize(WizardDescriptor wizard) {
        panels = null;
    }

    public WizardDescriptor.Panel current() {
        return getPanels()[index];
    }

    public String name() {
        return index + 1 + ". from " + getPanels().length;
    }

    public boolean hasNext() {
        return index < getPanels().length - 1;
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    public void addChangeListener(ChangeListener listener) {}
    public void removeChangeListener(ChangeListener listener) {}

    // If something changes dynamically (besides moving between panels), e.g.
    // the number of panels changes in response to user input, then uncomment
    // the following and call when needed: fireChangeEvent();
    /*
    private Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);
    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }
    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }
    protected final void fireChangeEvent() {
        Iterator<ChangeListener> it;
        synchronized (listeners) {
            it = new HashSet<ChangeListener>(listeners).iterator();
        }
        ChangeEvent ev = new ChangeEvent(this);
        while (it.hasNext()) {
            it.next().stateChanged(ev);
        }
    }
     */

    // You could safely ignore this method. Is is here to keep steps which were
    // there before this wizard was instantiated. It should be better handled
    // by NetBeans Wizard API itself rather than needed to be implemented by a
    // client code.
    private String[] createSteps() {
        String[] beforeSteps = null;
        Object prop = wizard.getProperty(WizardDescriptor.PROP_CONTENT_DATA);
        if (prop instanceof String[]) {
            beforeSteps = (String[]) prop;
        }

        if (beforeSteps == null) {
            beforeSteps = new String[0];
        }

        String[] res = new String[(beforeSteps.length - 1) + panels.length];
        for (int i = 0; i < res.length; i++) {
            if (i < (beforeSteps.length - 1)) {
                res[i] = beforeSteps[i];
            } else {
                res[i] = panels[i - beforeSteps.length + 1].getComponent().getName();
            }
        }
        return res;
    }

}
