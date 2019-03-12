/*
 * Copyright 2017 - 2018 Volker Berlin (i-net software)
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
package de.inetsoftware.jwebassembly.runtime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.inetsoftware.jwebassembly.ScriptEngine;
import de.inetsoftware.jwebassembly.WasmException;
import de.inetsoftware.jwebassembly.WasmRule;
import de.inetsoftware.jwebassembly.api.annotation.Export;
import de.inetsoftware.jwebassembly.api.annotation.Import;

/**
 * @author Volker Berlin
 */
@RunWith( Parameterized.class )
public class RuntimeErrors {

    @ClassRule
    public static WasmRule     rule = new WasmRule( TestClass.class );

    private final ScriptEngine script;

    public RuntimeErrors( ScriptEngine script ) {
        this.script = script;
    }

    @Parameters( name = "{0}" )
    public static Collection<ScriptEngine[]> data() {
        return ScriptEngine.testParams();
    }

    @Test
    public void longReturn() {
        String error = rule.evalWasm( script, "longReturn" );
        int newlineIdx = error.indexOf( '\n' );
        if( newlineIdx > 0 ) {
            error = error.substring( 0, newlineIdx );
        }
        String expected = script == ScriptEngine.SpiderMonkey ? "TypeError: cannot pass i64 to or from JS" : "TypeError: wasm function signature contains illegal type";
        assertEquals( expected, error );
    }

    static class TestClass {

        @Export
        static long longReturn() {
            return Long.MAX_VALUE;
        }
    }

    private void compileErrorTest( String expectedMessge, Class<?> classes ) throws IOException {
        WasmRule wasm = new WasmRule( classes );
        try {
            wasm.compile();
            fail( "Exception expected with: " + expectedMessge );
        } catch( WasmException ex ) {
            assertTrue( "Wrong error message: " + ex.getMessage(), ex.getMessage().contains( expectedMessge ) );
        } finally {
            wasm.delete();
        }

    }

    @Test
    public void nonStaticExport() throws IOException {
        compileErrorTest( "Export method must be static:", NonStaticExport.class );
    }

    static class NonStaticExport {
        @Export
        float function() {
            return 1;
        }
    }


    @Test
    public void nonStaticImport() throws IOException {
        compileErrorTest( "Import method must be static:", NonStaticImport.class );
    }

    static class NonStaticImport {
        @Import( module = "m", name = "n" )
        float function() {
            return 1;
        }
    }
}
