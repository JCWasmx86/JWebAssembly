/*
 * Copyright 2018 - 2019 Volker Berlin (i-net software)
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.zip.CRC32;

import org.junit.Assume;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import de.inetsoftware.jwebassembly.ScriptEngine;
import de.inetsoftware.jwebassembly.WasmRule;
import de.inetsoftware.jwebassembly.api.annotation.Export;

public class ArrayOperations extends AbstractBaseTest {

    @ClassRule
    public static WasmRule rule = new WasmRule( TestClass.class );

    public ArrayOperations( ScriptEngine script, String method, Object[] params ) {
        super( rule, script, method, params );
    }

    @Parameters( name = "{0}-{1}" )
    public static Collection<Object[]> data() {
        ArrayList<Object[]> list = new ArrayList<>();

        ScriptEngine[] engines = ScriptEngine.testEngines();
        engines = Arrays.copyOf( engines, engines.length + 2 );
        engines[engines.length - 2] = ScriptEngine.SpiderMonkeyGC;
        engines[engines.length - 1] = ScriptEngine.SpiderMonkeyWatGC;
        for( ScriptEngine script : engines ) {
            addParam( list, script, "length" );
            addParam( list, script, "loopByte" );
            addParam( list, script, "loopShort" );
            addParam( list, script, "loopChar" );
            addParam( list, script, "loopInt" );
            addParam( list, script, "loopLong" );
            addParam( list, script, "loopFloat" );
            addParam( list, script, "loopDouble" );
            addParam( list, script, "loopObject" );
            addParam( list, script, "copyBack2Front" );
            addParam( list, script, "copyFront2Back" );
            addParam( list, script, "dup_x2" );
        }
        rule.setTestParameters( list );
        return list;
    }

    @Test
    @Override
    public void test() {
        Assume.assumeFalse( getScriptEngine().name().endsWith( "GC" ) );
        super.test();
    }

    static class TestClass {

        @Export
        static int length() {
            return new int[5].length;
        }

        @Export
        static byte loopByte() {
            byte[] data = {-1,2,3};
            byte sum = 0;
            for( byte i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static short loopShort() {
            short[] data = {-1,-2,-3};
            short sum = 0;
            for( short i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static char loopChar() {
            char[] data = {1,2,0x8000};
            char sum = 0;
            for( char i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static int loopInt() {
            int[] data = {1,2,3};
            int sum = 0;
            for( int i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static int loopLong() {
            long[] data = {1,2,3};
            long sum = 0;
            for( long i : data ) {
                sum += i;
            }
            return (int)sum;
        }

        @Export
        static float loopFloat() {
            float[] data = {1,2,3};
            float sum = 0;
            for( float i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static double loopDouble() {
            double[] data = {1,2,3};
            double sum = 0;
            for( double i : data ) {
                sum += i;
            }
            return sum;
        }

        @Export
        static int loopObject() {
            Object[] data = {null,null,null};
            int sum = 0;
            for( Object obj : data ) {
                sum++;
            }
            return sum;
        }

        @Export
        static double copyBack2Front() {
            byte[] a = new byte[50];
            for( int i = 0; i < a.length; i++ ) {
                a[i] = (byte)i;
            }

            System.arraycopy( a, 20, a, 15, 10 );
            CRC32 crc = new CRC32();
            crc.update( a );
            return crc.getValue();
        }

        @Export
        static double copyFront2Back() {
            byte[] a = new byte[50];
            for( int i = 0; i < a.length; i++ ) {
                a[i] = (byte)i;
            }

            System.arraycopy( a, 15, a, 20, 10 );
            CRC32 crc = new CRC32();
            crc.update( a );
            return crc.getValue();
        }

        @Export
        static int dup_x2() {
            Object[] data = {null,null,null};
            int index = 1;
            Object value = null;

            if ((data[index] = value) != null) { // test for instruction dup_x2
                return 1;
            } else {
                return 2;
            }
        }
    }
}
