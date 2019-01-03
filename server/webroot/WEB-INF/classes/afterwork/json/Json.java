package afterwork.json;

import java.util.*;
import org.json.*;
import afterwork.objects.AW;
import afterwork.objects.Restaurant;

/**
 * A class that helps pars a list to json.
 */
public class Json {

  /**
   * Takes a list of restaurants that holds After Work, parses it to json
   * and returns the json text.
   *
   * @param res a list of Restaurants that holds After Work.
   * @return a json text.
   * @throws JSONException if the parsing to json isn't possible.
   */
  public static String create(List<Restaurant> res) throws JSONException {

    JSONObject joAll = new JSONObject();
    JSONObject joAfterWork = new JSONObject();

    for (int i = 0; i < res.size(); i++) {
      JSONObject joBoth = new JSONObject();
      joBoth.put("name", res.get(i).getName())
            .put("adress", res.get(i).getAdress())
            .put("web", res.get(i).getWeb())
            .put("infoRes", res.get(i).getInfo());

      joBoth.put("infoAW", res.get(i).getAW().getInfo())
            .put("startTime", res.get(i).getAW().getStartTime())
            .put("endTime", res.get(i).getAW().getEndTime())
            .put("food", res.get(i).getAW().getFood());

      joAfterWork.accumulate("Events", joBoth);
    }

    joAll.accumulate("AfterWork", joAfterWork);

    return joAll.toString(2);
  }

}
