package serializable;

import java.io.Serializable;

public class SerializableData implements Serializable {

  private Long id;
  private String name;
  private String desc;
  private Integer number;

  protected SerializableData() {}

  public SerializableData(Long id, String name, String desc, Integer number) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.number = number;
  }

  @Override
  public String toString() {
    return "SerializableData{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", desc='" + desc + '\'' +
        ", number=" + number +
        '}';
  }
}
