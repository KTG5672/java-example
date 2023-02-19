package thread;

public class SubThread implements Runnable {

  private Resource resource;

  public SubThread(Resource resource) {
    this.resource = resource;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      resource.addValue(1);
    }
  }
}
