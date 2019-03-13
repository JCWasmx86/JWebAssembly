/*
 * Copyright 2018 Volker Berlin (i-net software)
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
import java.util.Collection;

import org.junit.ClassRule;
import org.junit.runners.Parameterized.Parameters;

import de.inetsoftware.jwebassembly.ScriptEngine;
import de.inetsoftware.jwebassembly.WasmRule;
import de.inetsoftware.jwebassembly.api.annotation.Export;

public class Wide extends AbstractBaseTest {

    @ClassRule
    public static WasmRule rule = new WasmRule( TestClass.class );

    public Wide( ScriptEngine script, String method, Object[] params ) {
        super( rule, script, method, params );
    }

    @Parameters( name = "{0}-{1}" )
    public static Collection<Object[]> data() {
        ArrayList<Object[]> list = new ArrayList<>();
        for( ScriptEngine[] val : ScriptEngine.testParams() ) {
            ScriptEngine script = val[0];
            addParam( list, script, "abc" );
        }
        return list;
    }

    static class TestClass {

        /**
         * more as 255 variable slots
         * @return
         */
        @Export
        static int abc() {
            long a0 = 0;
            long a1 = 1;
            long a2 = 2;
            long a3 = 3;
            long a4 = 4;
            long a5 = 5;
            long a6 = 6;
            long a7 = 7;
            long a8 = 8;
            long a9 = 9;
            long a10 = 10;
            long a11 = 11;
            long a12 = 12;
            long a13 = 13;
            long a14 = 14;
            long a15 = 15;
            long a16 = 16;
            long a17 = 17;
            long a18 = 18;
            long a19 = 19;
            long a20 = 20;
            long a21 = 21;
            long a22 = 22;
            long a23 = 23;
            long a24 = 24;
            long a25 = 25;
            long a26 = 26;
            long a27 = 27;
            long a28 = 28;
            long a29 = 29;
            long a30 = 30;
            long a31 = 31;
            long a32 = 32;
            long a33 = 33;
            long a34 = 34;
            long a35 = 35;
            long a36 = 36;
            long a37 = 37;
            long a38 = 38;
            long a39 = 39;
            long a40 = 40;
            long a41 = 41;
            long a42 = 42;
            long a43 = 43;
            long a44 = 44;
            long a45 = 45;
            long a46 = 46;
            long a47 = 47;
            long a48 = 48;
            long a49 = 49;

            long b0 = 0;
            long b1 = 1;
            long b2 = 2;
            long b3 = 3;
            long b4 = 4;
            long b5 = 5;
            long b6 = 6;
            long b7 = 7;
            long b8 = 8;
            long b9 = 9;
            long b10 = 10;
            long b11 = 11;
            long b12 = 12;
            long b13 = 13;
            long b14 = 14;
            long b15 = 15;
            long b16 = 16;
            long b17 = 17;
            long b18 = 18;
            long b19 = 19;
            long b20 = 20;
            long b21 = 21;
            long b22 = 22;
            long b23 = 23;
            long b24 = 24;
            long b25 = 25;
            long b26 = 26;
            long b27 = 27;
            long b28 = 28;
            long b29 = 29;
            long b30 = 30;
            long b31 = 31;
            long b32 = 32;
            long b33 = 33;
            long b34 = 34;
            long b35 = 35;
            long b36 = 36;
            long b37 = 37;
            long b38 = 38;
            long b39 = 39;
            long b40 = 40;
            long b41 = 41;
            long b42 = 42;
            long b43 = 43;
            long b44 = 44;
            long b45 = 45;
            long b46 = 46;
            long b47 = 47;
            long b48 = 48;
            long b49 = 49;

            double c0 = 0;
            double c1 = 1;
            double c2 = 2;
            double c3 = 3;
            double c4 = 4;
            double c5 = 5;
            double c6 = 6;
            double c7 = 7;
            double c8 = 8;
            double c9 = 9;
            double c10 = 10;
            double c11 = 11;
            double c12 = 12;
            double c13 = 13;
            double c14 = 14;
            double c15 = 15;
            double c16 = 16;
            double c17 = 17;
            double c18 = 18;
            double c19 = 19;
            double c20 = 20;
            double c21 = 21;
            double c22 = 22;
            double c23 = 23;
            double c24 = 24;
            double c25 = 25;
            double c26 = 26;
            double c27 = 27;
            double c28 = 28;
            double c29 = 29;
            double c30 = 30;
            double c31 = 31;
            double c32 = 32;
            double c33 = 33;
            double c34 = 34;
            double c35 = 35;
            double c36 = 36;
            double c37 = 37;
            double c38 = 38;
            double c39 = 39;
            double c40 = 40;
            double c41 = 41;
            double c42 = 42;
            double c43 = 43;
            double c44 = 44;
            double c45 = 45;
            double c46 = 46;
            double c47 = 47;
            double c48 = 48;
            double c49 = 49;

            return 255;
        }
    }
}
