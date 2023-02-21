package lambda;

// 어노테이션을 줘서 Functional 인 것을 명시
// 인터페이스에 내용이 없는 메소드는 하나만 선언할 수 있다.
// Multiple non-overriding abstract methods found in interface lambda.Calculator
@FunctionalInterface
public interface Calculator {
  int operation(int a, int b);
  //  int operationSubtract(int a, int b);
  default int operationAdd(int a, int b) {
    return a + b;
  }
}
