package com.path;// files/PathWatcher.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ExcludeFromGradle}

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

import java.util.concurrent.*;

public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test)
                    // TODO: 2021/9/8 过滤掉所有 .txt 文件，需要显示的将Path 转换为字符串，
                    //  否则调用endWith 将与整个Path对象进行比较，而不是路径名称字符串的一部分进行比较
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        // TODO: 2021/9/8 注册 WatchService 监听对象 test 路径下的文件,不会监听其他路径，
        //  如果监听整个树目录，必须在整个树的每个目录上放置一个 WatchService，
        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE,ENTRY_CREATE);

        Executors.newSingleThreadScheduledExecutor()
                .schedule(
                        PathWatcher::delTxtFiles,
                        250, TimeUnit.MILLISECONDS);
        // TODO: 2021/9/8  循环监听目录
        WatchKey key = watcher.take();
        while (key != null) {
            for (WatchEvent evt : key.pollEvents()) {
                System.out.println(
                        "evt.context(): " + evt.context() +
                                "\nevt.count(): " + evt.count() +
                                "\nevt.kind(): " + evt.kind());
            }
        }
    }
}
/* Output:
deleting test\bag\foo\bar\baz\File.txt
deleting test\bar\baz\bag\foo\File.txt
deleting test\baz\bag\foo\bar\File.txt
deleting test\foo\bar\baz\bag\File.txt
deleting test\Hello.txt
evt.context(): Hello.txt
evt.count(): 1
evt.kind(): ENTRY_DELETE
*/
