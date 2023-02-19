package thread;

public class Resource {
  private int value = 0;

  // 동기 처리
  public synchronized void addValue(int add) {
    value = value + add;
  }
//  public void addValue(int add) {
//    value = value + add;
//  }

  public int getValue() {
    return value;
  }
}
