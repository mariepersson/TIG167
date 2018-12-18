package afterwork.db;

import java.util.*;
import java.sql.*;
import afterwork.objects.Restaurant;
import afterwork.objects.AW;

public class ReadDBtoList {

  public static List<Restaurant> get(String food, String city) throws SQLException {
    List<Restaurant> restaurants = new ArrayList<>();
    String callDB = "jdbc:sqlite:AfterWork.db";

    Connection con = DriverManager.getConnection(callDB);
    Statement stm = con.createStatement();

    StringBuilder query = new StringBuilder(
      "SELECT * FROM Restaurant inner join AW on Restaurant.AW_id = AW.AW_id ");

    if (food != null && food.toLowerCase().equals("ja")) {
      query.append(" AND AW.food = 1");
    } else if (food != null && food.toLowerCase().equals("nej")) {
      query.append(" AND AW.food = 0");
    }

    if (city != null && !city.toLowerCase().equals("alla")) {
      city = city.replaceAll("ö", "_");
      city = city.replaceAll("Ö", "_");
      city = city.replaceAll("ä", "_");
      city = city.replaceAll("Ä", "_");
      city = city.replaceAll("å", "_");
      city = city.replaceAll("Å", "_");
      query.append(" AND Restaurant.Adress like '%" + city + "%'");
    }

    ResultSet rs = stm.executeQuery(query.toString());

    while (rs.next()) {
      restaurants.add(new Restaurant.Builder(
      rs.getString("name"),
      rs.getString("adress"))
      .web(rs.getString("web"))
      .info(rs.getString("infoRes"))
      .aw(new AW.Builder().info(rs.getString("infoAW"))
                          .startTime(rs.getString("startTime"))
                          .endTime(rs.getString("endTime"))
                          .food(rs.getBoolean("food"))
                          .build())
      .build());
    }

    stm.close();

    return restaurants;
  }

}
