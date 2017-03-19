/*
 * Copyright 2017 Volker Berlin (i-net software)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.inetsoftware.jwebassembly;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * The main class of the compiler.
 * 
 * @author Volker Berlin
 */
public class JWebAssembly {

    private List<File> classFiles = new ArrayList<File>();

    /**
     * Create a instance.
     */
    public JWebAssembly() {
    }

    /**
     * Add a classFile to compile
     * 
     * @param classFile
     *            the file
     */
    public void addFile( @Nonnull File classFile ) {
        classFiles.add( classFile );
    }

    /**
     * Convert the added files to a WebAssembly module in text representation.
     * 
     * @return the module as string
     * @throws CompileException
     *             if any conversion error occurs
     */
    public String compileToText() throws CompileException {
        return null;
    }
}
