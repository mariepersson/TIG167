package afterwork.objects;

import java.util.*;

/**
 * Represents a Restaurant.
 */
public class Restaurant {
  private String name;
  private String adress;
  private String web;
  private String info;
  private AW aw;

  /**
   * To get the name of the restaurant.
   *
   * @return the restaurants name.
   */
  public String getName() {
    return name;
  }

  /**
   * To get the adress of the restaurant.
   *
   * @return the restaurants adress.
   */
  public String getAdress() {
    return adress;
  }

  /**
   * To get the webadress of the restaurant.
   *
   * @return the restaurants webadress.
   */
  public String getWeb() {
    return web;
  }

  /**
   * To get the information text about the restaurant.
   *
   * @return information text about the restaurant.
   */
  public String getInfo() {
    return info;
  }

  /**
   * To get the object representing the After Work that is held at the restaurant.
   *
   * @return the object of an After Work that is held at the restaurant.
   */
  public AW getAW() {
    return aw;
  }

  /**
   * Constructor for Restaurant. Uses the class Builder to create a Restaurant.
   *
   * @param builder containing the information describing the restaurant.
   */
  private Restaurant(Builder builder) {
    this.name = builder.name;
    this.adress = builder.adress;
    this.web = builder.web;
    this.info = builder.info;
    this.aw = builder.aw;
  }

  /**
   * Returns a String describing the restaurant.
   *
   * @return a String describing the Restaurant.
   */
  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(name)
              .append(", ")
              .append(adress)
              .toString();
  }

  /**
   * A class that collects the parts that describe a restaurant and builds
   * them togheter.
   */
  public static class Builder {
    private String name;
    private String adress;
    private String web;
    private String info;
    private AW aw;

    /**
     * Constructs the base of the builder. Makes sure that the variables name and
     * adress are not null.
     *
     * @param name the name of the restaurant.
     * @param adress the adress of the restaurant.
     */
    public Builder(String name, String adress) {
      this.name = name;
      this.adress = adress;
    }

    /**
     * Add a webadress to the restaurant.
     *
     * @param web the webadress.
     * @return the builder containing all added information.
     */
    public Builder web(String web) {
      this.web = web;
      return this;
    }

    /**
     * Add a information text to the restaurant.
     *
     * @param info the information text.
     * @return the builder containing all added information.
     */
    public Builder info(String info) {
      this.info = info;
      return this;
    }

    /**
     * Add a After Work that is held at the restaurant.
     *
     * @param aw the After Work object representation.
     * @return the builder containing all added information.
     */
    public Builder aw(AW aw) {
      this.aw = aw;
      return this;
    }

    /**
     * Create a Restarurant object containing the infomation added to the builder.
     *
     * @return the Restaurant object created from the different building blocks.
     */
    public Restaurant build() {
      return new Restaurant(this);
    }

  }

}
