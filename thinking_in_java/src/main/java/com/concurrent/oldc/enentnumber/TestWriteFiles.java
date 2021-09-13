package com.concurrent.oldc.enentnumber;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.stream.StreamSupport;

/**
 * @author Lishiyan
 * @date 2021/9/1311:10
 */
public class TestWriteFiles {
    public static void main(String[] args) {
        try (
                PrintWriter printWriter = new PrintWriter("out.txt");
        ) {

            printWriter.write("wwww");
            printWriter.write("\n");
            printWriter.write("sdfsf");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
