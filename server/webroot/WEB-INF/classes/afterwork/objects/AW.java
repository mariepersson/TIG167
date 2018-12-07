package afterwork.objects;

import java.util.*;

public class AW {
  private String info;
  private String startTime;
  private String endTime;
  private boolean food;
  private int AW_id; // om en AW hämtas som en instans till en Restaurang istället blir denna överflödig

  public String getInfo() {
    return info;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public boolean getFood() {
    return food;
  }

  public int getAW_id() {
    return AW_id;
  }

//ny konstruktor
  private AW(Builder builder) {
    this.info = builder.info;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.food = builder.food;
    this.AW_id = builder.AW_id;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(AW_id).toString();
  }

  //ny inre klassen
  public static class Builder {
    private String info;
    private String startTime;
    private String endTime;
    private boolean food;
    private int AW_id;

    //tvinga att ha med kräver en konstruktor, behövs inte här
    public Builder info(String info) {
      this.info = info;
      return this;
    }

    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }

    public Builder food(boolean food) {
      this.food = food;
      return this;
    }

    public Builder AW_id(int AW_id) {
      this.AW_id = AW_id;
      return this;
    }

    public AW build() {
      return new AW(this);
    }

  }

}
