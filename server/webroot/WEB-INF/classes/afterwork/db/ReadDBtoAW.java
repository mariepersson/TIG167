package afterwork.db;

import java.util.*;
import java.sql.*;
import afterwork.objects.AW;

public class ReadDBtoAW {

  public static List<AW> get() throws SQLException {
    List<AW> aw = new ArrayList<>();

    Connection con = DriverManager
                     .getConnection("jdbc:sqlite:AfterWork.db");
    Statement stm = con.createStatement();

    ResultSet rsAW = stm.executeQuery("SELECT * FROM AW");

    while (rsAW.next()) {
      aw.add(new AW.Builder().info(rsAW.getString("info"))
                             .startTime(rsAW.getString("startTime"))
                             .endTime(rsAW.getString("endTime"))
                             .food(rsAW.getBoolean("food"))
                             .AW_id(rsAW.getInt("AW_id"))
                             .build());
    }

    stm.close();

    return aw;
  }

}
