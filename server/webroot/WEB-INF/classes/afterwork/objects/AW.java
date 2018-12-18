package afterwork.objects;

public class AW {
  private String info;
  private String startTime;
  private String endTime;
  private boolean food;

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

  private AW(Builder builder) {
    this.info = builder.info;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.food = builder.food;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(info)
              .append(" ")
              .append(startTime)
              .append(" - ")
              .append(endTime)
              .toString();
  }

  public static class Builder {
    private String info;
    private String startTime;
    private String endTime;
    private boolean food;

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

    public AW build() {
      return new AW(this);
    }

  }

}
