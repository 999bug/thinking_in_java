package com.file.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author Lishiyan
 * @date 2021/9/916:20
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.print(entry.getKey()+": ");
            System.out.println(entry.getValue());
        }
    }
}
