高位优先（Big Endian）：将最重要的字节放在最低内存地址中
低位优先（Little Endian）：将最重要的字节放在最高内存地址中

##ByteBuffer 以高位优先的形式存储数据

#视图缓冲区：
    通过特定的基本类型的窗口来查看底层 ByteBuffer

不能将基本类型缓冲区转换为 ByteBuffer，但我们能通过 视图缓冲区将基本类型数据
移动到 ByteBuffer 中或移出 ByteBuffer

旧式 I/O 中的三个类分别被更新成 FileChannel（文件通道），
分别是：FileInputStream、FileOutputStream，以及用于读写的 RandomAccessFile 类。