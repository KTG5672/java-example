package optional;

import java.util.Optional;

public class OptionalMain {

  private String stringData;

  public static void main(String[] args) throws Exception {
    OptionalMain optionalMain = new OptionalMain();
    optionalMain.setData(Optional.ofNullable(null));
    optionalMain.setDefaultData(Optional.ofNullable(null));
    try {
      optionalMain.ifNullThrowRuntimeException(Optional.ofNullable(null));
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    optionalMain.ifNullThrowRuntimeException(Optional.ofNullable("hello"));
  }
  private void setData(Optional<String> str) {
    String result = str.get();
    System.out.println("setData = " + result);
  }

  private void setDefaultData(Optional<String> str) {
    String defaultData = "default";
    String result = str.orElse(defaultData);
    System.out.println("setDefaultData = " + result);
  }

  private void ifNullThrowRuntimeException(Optional<String> str) throws RuntimeException {
    String result = str.orElseThrow(() -> {
      return new RuntimeException("파라미터로 널이 들어옴");
    });
    System.out.println("ifNullThrowRuntimeException = " + result);
  }

}
