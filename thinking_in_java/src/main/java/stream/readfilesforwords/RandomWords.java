package stream.readfilesforwords;// streams/RandomWords.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;

// TODO: 2021/8/31 使用流读取文件
public class RandomWords implements Supplier<String> {

    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines =
                Files.readAllLines(Paths.get(fname));
        // Skip the first line:
        for (String line : lines.subList(1, lines.size())) {
            // 使用空格 点 逗号 问号 分隔 +表示出现一次或者多次
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {

        return words.stream()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                // TODO: 2021/8/31 Stream.generate()，把任意Supplier<T> 用于生成 T 类型的流
                Stream.generate(new RandomWords("src/main/resources/Cheese.dat"))
                        .limit(10)
                        // TODO: 2021/8/31 collect() 根据参数来结合所有的流元素，使用逗号分割
                        .collect(Collectors.joining("，")));
    }
}
/* Output:
it shop sir the much cheese by conclusion district is
*/
