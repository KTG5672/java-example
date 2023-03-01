package serializable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class SerializeToFile {

  private static final String FILE_PATH = "C:\\Users\\zzang\\Desktop";

  public static void main(String[] args) {
    SerializableData data = new SerializableData(1L, "1번", "1번 객체", 1028);
    writeObjectToFile(data);
    SerializableData dataResult = (SerializableData) readFileToObject();
    System.out.println(dataResult.toString());
  }

  public static void writeObjectToFile(Serializable serializable) {
    FileChannel channel = null;
    ByteArrayOutputStream bos = null;
    ObjectOutputStream out = null;
    try {
      channel = new FileOutputStream(new File(FILE_PATH + "\\object.csv")).getChannel();
      bos = new ByteArrayOutputStream();
      out = new ObjectOutputStream(bos);
      out.writeObject(serializable);
      bos.flush();
      byte[] toByteArray = bos.toByteArray();
      ByteBuffer wrap = ByteBuffer.wrap(toByteArray);
      channel.write(wrap);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Serializable readFileToObject() {
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    Serializable serializable = null;
    try {
      fis = new FileInputStream(new File(FILE_PATH + "\\object.csv"));
      ois = new ObjectInputStream(fis);
      serializable = (Serializable) ois.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return serializable;
  }
}
