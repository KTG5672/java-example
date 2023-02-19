package thread;

public class MainThread {

  public static void main(String[] args) throws InterruptedException {
    Resource resource = new Resource();
    for (int i = 0; i < 10; i++) {
      startThread(resource);
    }
    Thread.sleep(1000);
    System.out.println("resource = " + resource.getValue());
  }

  private static void startThread(Resource resource) throws InterruptedException {
    Thread thread = new Thread(new SubThread(resource));
    thread.start();
  }
}


