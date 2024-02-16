package cucumber.resource;

import cucumber.BuiildPOJOClassByGoogleMapAddApi.GoogleMap;
import cucumber.BuiildPOJOClassByGoogleMapAddApi.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
  public GoogleMap dataBuild(){

    GoogleMap googleMap = new GoogleMap();

    googleMap.setAccuracy(50);
    googleMap.setName("Frontline house");
    googleMap.setPhone_number("(+91) 983 893 3937");
    googleMap.setAddress("29, side layout, cohen 09");
    googleMap.setWebsite("http://google.com");
    googleMap.setLanguage("French-IN");

    Location location = new Location();
    location.setLat(-38.383494);
    location.setLng(33.427362);

    List<String> types = new ArrayList<>();
    types.add("shoe park");
    types.add("shop");

    googleMap.setTypes(types);

    return googleMap;
  }
}
