package afterwork.db;

import java.util.*;
import java.sql.*;
import afterwork.objects.Restaurant;

public class ReadDBtoRestaurant {

  public static List<Restaurant> get() throws SQLException {
    List<Restaurant> restaurants = new ArrayList<>();

    Connection con = DriverManager.getConnection("jdbc:sqlite:AfterWork.db");
    Statement stm = con.createStatement();

    ResultSet rsRestaurant = stm.executeQuery("SELECT * FROM Restaurant");

    while (rsRestaurant.next()) {
      restaurants.add(new Restaurant.Builder(
                      rsRestaurant.getString("name"),
                      rsRestaurant.getString("adress"))
                      .web(rsRestaurant.getString("web"))
                      .info(rsRestaurant.getString("info"))
                      .AW_id(rsRestaurant.getInt("AW_id"))
                      .build());
    }

    stm.close();

    return restaurants;
  }

}
