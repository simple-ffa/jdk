/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 6786682
 * @summary This test verifies the use of lang attribute by <HTML>.
 * @author Bhavesh Patel
 * @library ../lib/
 * @build JavadocTester
 * @build TestHtmlTag
 * @run main TestHtmlTag
 */

import java.util.Locale;

public class TestHtmlTag extends JavadocTester {

    private static final String[][] TEST1 = {
        { "pkg1/C1.html",
            "<html lang=\"" + Locale.getDefault().getLanguage() + "\">"},
        { "pkg1/package-summary.html",
            "<html lang=\"" + Locale.getDefault().getLanguage() + "\">"}};
    private static final String[][] NEGATED_TEST1 = {
        { "pkg1/C1.html", "<html>"}};
    private static final String[][] TEST2 = {
        { "pkg2/C2.html", "<html lang=\"ja\">"},
        { "pkg2/package-summary.html", "<html lang=\"ja\">"}};
    private static final String[][] NEGATED_TEST2 = {
        { "pkg2/C2.html", "<html>"}};
    private static final String[][] TEST3 = {
        { "pkg1/C1.html", "<html lang=\"en\">"},
        { "pkg1/package-summary.html", "<html lang=\"en\">"}};
    private static final String[][] NEGATED_TEST3 = {
        { "pkg1/C1.html", "<html>"}};

    private static final String[] ARGS1 =
        new String[] {
            "-d", OUTPUT_DIR + "-1", "-sourcepath", SRC_DIR, "pkg1"};
    private static final String[] ARGS2 =
        new String[] {
            "-locale", "ja", "-d", OUTPUT_DIR + "-2", "-sourcepath", SRC_DIR, "pkg2"};
    private static final String[] ARGS3 =
        new String[] {
            "-locale", "en_US", "-d", OUTPUT_DIR + "-3", "-sourcepath", SRC_DIR, "pkg1"};

    /**
     * The entry point of the test.
     * @param args the array of command line arguments.
     */
    public static void main(String[] args) {
        TestHtmlTag tester = new TestHtmlTag();
        tester.run(ARGS1, TEST1, NEGATED_TEST1);
        tester.run(ARGS2, TEST2, NEGATED_TEST2);
        tester.run(ARGS3, TEST3, NEGATED_TEST3);
        tester.printSummary();
    }
}
