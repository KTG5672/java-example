package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaMain {

  public static void main(String[] args) {
    LambdaMain lambdaMain = new LambdaMain();
    // Thread
    lambdaMain.runnableCase();
    // Comparator
    List<Integer> integers = Arrays.asList(3, 1, 2, 7, 4, 8);
    Collections.sort(integers, (x, y) -> x < y ? 1 : x == y ? 0 : -1);
    System.out.println("integers.toString() = " + integers.toString());
  }

  public void runnableCase() {
    runThread(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
      }
    });
    // 람다식으로 대체가능
    runThread(() -> System.out.println(Thread.currentThread().getName()));
  }

  private void runThread(Runnable runnable) {
    Thread thread = new Thread(runnable);
    thread.start();
  }
}
