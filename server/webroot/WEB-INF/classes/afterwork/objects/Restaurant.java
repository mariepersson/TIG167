package afterwork.objects;

import java.util.*;

public class Restaurant {
  private String name;
  private String adress;
  private String web;
  private String info;
  private AW aw;

  public String getName() {
    return name;
  }

  public String getAdress() {
    return adress;
  }

  public String getWeb() {
    return web;
  }

  public String getInfo() {
    return info;
  }

  public AW getAW() {
    return aw;
  }

  private Restaurant(Builder builder) {
    this.name = builder.name;
    this.adress = builder.adress;
    this.web = builder.web;
    this.info = builder.info;
    this.aw = builder.aw;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(name)
              .append(", ")
              .append(adress)
              .toString();
  }

  public static class Builder {
    private String name;
    private String adress;
    private String web;
    private String info;
    private AW aw;

    public Builder(String name, String adress) {
      this.name = name;
      this.adress = adress;
    }

    public Builder web(String web) {
      this.web = web;
      return this;
    }

    public Builder info(String info) {
      this.info = info;
      return this;
    }

    public Builder aw(AW aw) {
      this.aw = aw;
      return this;
    }

    public Restaurant build() {
      return new Restaurant(this);
    }

  }

}
