package forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {

  static final ForkJoinPool mainPool = new ForkJoinPool();

  public static void main(String[] args) {
    new ForkJoinMain().calculate();
  }

  public void calculate() {
    long from = 0;
    long to = 10;

    GetSum getSum = new GetSum(from, to);
    Long result = mainPool.invoke(getSum);
    System.out.println("result = " + result);
  }

}
