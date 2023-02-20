package forkjoin;

import java.util.concurrent.RecursiveTask;

public class GetSum extends RecursiveTask<Long> {
  long from, to;

  public GetSum(long from, long to) {
    this.from = from;
    this.to = to;
  }

  @Override
  protected Long compute() {
    long gap = to - from;

    if (gap <= 3) {
      long sum = calculateSum(from, to);
      log("return=" + sum);
      return sum;
    }
    long middle = (from + to) / 2;
    GetSum sumPre = new GetSum(from, middle);
    log("from= "+ from + " to=" + middle);
    GetSum sumPost = new GetSum(middle + 1, to);
    log("from= "+ (middle + 1) + " to=" + to);
    sumPre.fork(); // 다시 나뉨
    sumPost.fork();
    return sumPre.join() + sumPost.join();
  }

  private long calculateSum(long from, long to) {
    long sum = 0;
    for (long i = from; i <= to; i++) {
      sum += i;
    }
    return sum;
  }

  static private void log(String message) {
    String name = Thread.currentThread().getName();
    System.out.println(name + ": " + message);
  }
}
