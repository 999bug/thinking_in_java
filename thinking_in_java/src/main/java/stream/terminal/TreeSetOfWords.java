package stream.terminal;// streams/TreeSetOfWords.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

// TODO: 2021/8/31 将文件中的单词收集到 TreeSet 中，使用Collections.toCollection()构建任何类型的集合
public class TreeSetOfWords {

    public static void main(String[] args) throws Exception {
        Set<String> words2 =
                Files.lines(Paths.get("src/main/java/stream/readfilesforwords/TreeSetOfWords.java"))
                        .flatMap(s -> Arrays.stream(s.split("\\W+")))
                        .filter(s -> !s.matches("\\d+")) // No numbers 移除数字
                        .map(String::trim)
                        // 过滤单词数小于3的people
                        .filter(s -> s.length() > 2)
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
/* Output:
[Arrays, Collectors, Exception, Files, Output, Paths,
Set, String, System, TreeSet, TreeSetOfWords, args,
class, collect, file, filter, flatMap, get, import,
java, length, limit, lines, main, map, matches, new,
nio, numbers, out, println, public, split, static,
stream, streams, throws, toCollection, trim, util,
void, words2]
*/
