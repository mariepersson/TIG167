package afterwork.objects;

import java.util.*;

public class Restaurant {
  private String name;
  private String adress;
  private String web;
  private String info;
  private int AW_id;  //istället för id ha en referens till en instans av klassen AW

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

  public int getAW_id() {
    return AW_id;
  }

  private Restaurant(Builder builder) { // ny konstruktor med builder
    this.name = builder.name;
    this.adress = builder.adress;
    this.web = builder.web;
    this.info = builder.info;
    this.AW_id = builder.AW_id;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(AW_id).append(name).append(", ").append(adress).toString();
  }

  public static class Builder { // static hör till klassen och inte instansen
    private String name;
    private String adress;
    private String web;
    private String info;
    private int AW_id;

    public Builder(String name, String adress) {  //behöver en kostruktor om mamn skall tvinga att några variabler inte får vara null
      this.name = name;
      this.adress = adress;
    }

    public Builder name(String name) {//behövs denna när kostruktor finns?
      this.name = name;
      return this;
    }

    public Builder adress(String adress) {
      this.adress = adress;
      return this;
    }

    public Builder web(String web) {
      this.web = web;
      return this;
    }

    public Builder info(String info) {
      this.info = info;
      return this;
    }

    public Builder AW_id(int AW_id) {
      this.AW_id = AW_id;
      return this;
    }

    public Restaurant build() {
      return new Restaurant(this); //this här är en Builder
    }

  }

}
