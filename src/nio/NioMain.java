package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioMain {

  public static void main(String[] args) {
    NioMain nioMain = new NioMain();
    nioMain.writeAndRead();
  }

  public void writeAndRead() {
    String fileName = "d:\\nioTest\\sample.txt";
    try {
      writeFile(fileName, "니오라고 읽는거냐\n뉴아이오라고 읽는거냐");
      readFile(fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private void writeFile(String fileName, String contents) throws Exception {
    FileChannel channel = new FileOutputStream(fileName).getChannel();
    byte[] bytes = contents.getBytes(StandardCharsets.UTF_8);
    ByteBuffer wrap = ByteBuffer.wrap(bytes);
    channel.write(wrap);
    channel.close();
  }
  private void readFile(String fileName) throws Exception {
    FileChannel channel = new FileInputStream(fileName).getChannel();
    ByteBuffer allocate = ByteBuffer.allocate(1024);
    channel.read(allocate);
    byte[] results = new byte[allocate.position()]; // 읽은 길이만큼 바이트 생성
    allocate.flip();
    allocate.get(results);
    System.out.println(new String(results, StandardCharsets.UTF_8));
    channel.close();
  }
}
