package socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 10; i++) {
      sendData("데이터 " + i);
    }
    sendData("EXIT");
  }

  private static void sendData(String data) throws IOException {
    Socket socket = null;
    try {
      socket = new Socket("127.0.0.1", 9999);
      OutputStream outputStream = socket.getOutputStream();
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
      InputStream inputStream = socket.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      byte[] bytes = data.getBytes();
      bufferedOutputStream.write(bytes);

      String receiveData = null;
      while(bufferedReader.ready() && (receiveData = bufferedReader.readLine()) != null) {
        System.out.println("receiveData = " + receiveData);
      }

      outputStream.close();
      inputStream.close();
      bufferedOutputStream.close();
      bufferedReader.close();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (socket != null) {
        socket.close();
      }
    }
  }

}
