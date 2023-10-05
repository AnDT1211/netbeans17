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
package org.netbeans.modules.debugger.jpda.truffle;

import java.io.File;
import java.net.URL;
import junit.framework.Test;

import org.netbeans.api.debugger.DebuggerManager;
import org.netbeans.api.debugger.jpda.JPDADebugger;
import org.netbeans.modules.debugger.jpda.truffle.breakpoints.TruffleLineBreakpoint;
import org.netbeans.modules.debugger.jpda.truffle.frames.TruffleStackFrame;
import org.netbeans.modules.debugger.jpda.truffle.vars.TruffleVariable;
import org.netbeans.modules.debugger.jpda.truffle.vars.impl.TruffleScope;
import org.netbeans.modules.javascript2.debug.breakpoints.JSLineBreakpoint;

public class DebugRTest extends JPDATestCase {

    public DebugRTest(String name) {
        super(name);
    }

    public static Test suite() {
        return createSuite(DebugRTest.class);
    }

    public void testRTypes() throws Exception {
        DebuggerManager dm = DebuggerManager.getDebuggerManager();
        File source = new File(sourceRoot, "org/netbeans/modules/debugger/jpda/truffle/scripts/Types.r");
        URL url = source.toURI().toURL();
        String sourcePath = source.getAbsolutePath();
        int debugLine = 38;
        String methodName = "typesTest";
        JSLineBreakpoint lb1 = new TruffleLineBreakpoint(url, debugLine);
        dm.addBreakpoint(lb1);
        runScriptUnderJPDA("Rscript", source.getAbsolutePath(), support -> {
            JPDADebugger debugger = support.getDebugger();
            TruffleStackFrame frame = checkStoppedAtScript(debugger.getCurrentThread(), sourcePath, debugLine);
            assertTrue("Bad method name: " + frame.getMethodName(), frame.getMethodName().contains(methodName));
            checkVariableTypes(frame.getScopes());
            support.doContinue();
        });
    }

    private static void checkVariableTypes(TruffleScope[] scopes) {
        assertEquals(1, scopes.length);
        TruffleVariable[] variables = scopes[0].getVariables();

        checkVar(variables[0], "a", "double", "[1]  1  2  3 42");
        checkVar(variables[1], "b1", "logical", "[1] TRUE");
        checkVar(variables[2], "b2", "logical", "[1] FALSE");

        checkVar(variables[3], "i", "double", "[1] 42");
        checkVar(variables[4], "s", "character", "[1] \"string\"");
        checkVar(variables[5], "n", "NULL", "NULL");
        checkVar(variables[6], "f", "closure", "function() {\n\n}");
        checkVar(variables[7], "d", "double", null);
        checkVar(variables[8], "map", "environment", null);
    }

    private static void checkVar(TruffleVariable variable, String name, String type, String value) {
        assertEquals("Name", name, variable.getName());
        assertEquals("Type of " + name, type, variable.getType());
        if (value != null) {
            assertEquals("Value of " + name, value, variable.getValue());
        }
    }

}
