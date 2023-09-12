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
package org.netbeans.modules.j2ee.ejbverification.fixes;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.ModifiersTree;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import org.netbeans.api.java.source.CancellableTask;
import org.netbeans.api.java.source.ElementHandle;
import org.netbeans.api.java.source.JavaSource;
import org.netbeans.api.java.source.TreeMaker;
import org.netbeans.api.java.source.WorkingCopy;
import org.netbeans.modules.j2ee.ejbverification.JavaUtils;
import org.netbeans.spi.editor.hints.ChangeInfo;
import org.netbeans.spi.editor.hints.Fix;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

/**
 * @author Tomasz.Slota@Sun.COM
 */
public class MakeClassPublic implements Fix {

    private static final Logger LOG = Logger.getLogger(MakeClassPublic.class.getName());
    private FileObject fileObject;
    private ElementHandle<TypeElement> classHandle;

    /**
     * Creates a new instance of ImplementSerializable.
     */
    public MakeClassPublic(FileObject fileObject, ElementHandle<TypeElement> classHandle) {
        this.classHandle = classHandle;
        this.fileObject = fileObject;
    }

    @Override
    public ChangeInfo implement() {
        CancellableTask<WorkingCopy> task = new CancellableTask<WorkingCopy>() {
            @Override
            public void cancel() {
            }

            @Override
            public void run(WorkingCopy workingCopy) throws Exception {
                workingCopy.toPhase(JavaSource.Phase.RESOLVED);
                TypeElement clazz = classHandle.resolve(workingCopy);

                if (clazz != null) {
                    ClassTree clazzTree = workingCopy.getTrees().getTree(clazz);
                    TreeMaker make = workingCopy.getTreeMaker();

                    Set<Modifier> flags = EnumSet.of(Modifier.PUBLIC);
                    flags.addAll(clazzTree.getModifiers().getFlags());
                    ModifiersTree newModifiers = make.Modifiers(flags, clazzTree.getModifiers().getAnnotations());
                    workingCopy.rewrite(clazzTree.getModifiers(), newModifiers);
                }
            }
        };

        JavaSource javaSource = JavaSource.forFileObject(fileObject);

        try {
            javaSource.runModificationTask(task).commit();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public String getText() {
        return NbBundle.getMessage(MakeClassPublic.class, "LBL_MakeClassPublic",
                JavaUtils.getShortClassName(classHandle.getQualifiedName()));
    }
}
