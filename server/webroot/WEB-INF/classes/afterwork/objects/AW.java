package afterwork.objects;

/**
 * Represents an After Work.
 */
public class AW {
  private String info;
  private String startTime;
  private String endTime;
  private boolean food;

  /**
   * To get the information text about the After Work.
   *
   * @return information text about the After Work.
   */
  public String getInfo() {
    return info;
  }

  /**
   * To get the staring time of the After Work.
   *
   * @return the starting time of the After Work.
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * To get the ending time of the After Work.
   *
   * @return the ending time of the After Work.
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * To get the information if there is After Work-food at the After Work.
   *
   * @return a boolean value telling if there is After Work-food. True
   * indicating there is such food and false otherwise.
   */
  public boolean getFood() {
    return food;
  }

  /**
   * Constructor for AW. Uses the class Builder to create a AW.
   *
   * @param builder containing the information describing the After Work.
   */
  private AW(Builder builder) {
    this.info = builder.info;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.food = builder.food;
  }

  /**
   * Returns a String describing the After Work.
   *
   * @return a String describing the After Work.
   */
  public String toString() {
    StringBuilder str = new StringBuilder();
    return str.append(info)
              .append(" ")
              .append(startTime)
              .append(" - ")
              .append(endTime)
              .toString();
  }

  /**
   * A class that collects the parts that describe a After Work and builds
   * them togheter.
   */
  public static class Builder {
    private String info;
    private String startTime;
    private String endTime;
    private boolean food;

    /**
     * Add a information text to the After Work.
     *
     * @param info the information text.
     * @return the builder containing all added information.
     */
    public Builder info(String info) {
      this.info = info;
      return this;
    }

    /**
     * Add a starting time to the After Work.
     *
     * @param startTime the starting time.
     * @return the builder containing all added information.
     */
    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * Add a ending time to the After Work.
     *
     * @param endTime the ending time.
     * @return the builder containing all added information.
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * Add information about if the After Work has After Work-food.
     *
     * @param food the information if there is After Worg-food.
     * @return the builder containing all added information.
     */
    public Builder food(boolean food) {
      this.food = food;
      return this;
    }

    /**
     * Create a AW object containing the infomation added to the builder.
     *
     * @return the AW object created from the different building blocks.
     */
    public AW build() {
      return new AW(this);
    }

  }

}
