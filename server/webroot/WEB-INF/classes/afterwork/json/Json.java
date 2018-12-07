package afterwork.json;

import java.util.*;
import org.json.*;
import afterwork.objects.AW;
import afterwork.objects.Restaurant;

public class Json {

  public static String create(List<AW> AWs,
                              List<Restaurant> res)
                              throws JSONException {
    JSONObject joAll = new JSONObject();
    JSONObject joAfterWork = new JSONObject();
    for (int i = 0; i < res.size(); i++) {
      JSONObject joBoth = new JSONObject();
      joBoth.put("infoAW", AWs.get(i).getInfo())
            .put("startTime", AWs.get(i).getStartTime())
            .put("endTime", AWs.get(i).getEndTime())
            .put("food", AWs.get(i).getFood())
            .put("AW_id", AWs.get(i).getAW_id());

      joBoth.put("name", res.get(i).getName())
            .put("adress", res.get(i).getAdress())
            .put("web", res.get(i).getWeb())
            .put("infoRes", res.get(i).getInfo())
            .put("AW_id", res.get(i).getAW_id());
      joAfterWork.accumulate("Events", joBoth);
    }
    joAll.accumulate("AfterWork", joAfterWork);

    String json = joAll.toString(2);
    return json;
  }

}
