package socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

  public static void main(String[] args) throws IOException {
    startServer();
  }

  private static void startServer() throws IOException {
    ServerSocket serverSocket = null;
    Socket client = null;
    try {
      serverSocket = new ServerSocket(9999);
      while (true) {
        client = serverSocket.accept();

        InputStream inputStream = client.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = client.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        StringBuilder sb = new StringBuilder();
        String data = null;
        while (bufferedReader.ready() && (data = bufferedReader.readLine()) != null) {
          sb.append(data);
        }
        System.out.println(sb.toString());

        bufferedOutputStream.write("OK".getBytes());

        outputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        bufferedReader.close();
        client.close();

        if (sb != null && "EXIT".equals(sb.toString())) {
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (serverSocket != null) {
        serverSocket.close();
      }
    }
  }

}
