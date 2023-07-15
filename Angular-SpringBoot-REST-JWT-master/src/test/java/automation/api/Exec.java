package automation.api;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class Exec {
  @Test
  void testJSONAssert_WhenExpectationLessFieldThanActual_Then() {
    String actual = "{id:1,friends:[{id:2},{id:3}]}";
    String expected = "{friends:[{id:3},{id:2}]}";

    // cho phep ignore fields, cho phep 'un-order' in array.
    JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
  }

  @Test
  void testJSONAssert_WhenExpectationEqualAbsolutelyActual_Then() {
    String actual = "{id:1,friends:[{id:2},{id:3}]}";
    String expected = "{friends:[{id:2},{id:3}], id:1}";

    // phải đủ 100% các fields của 2 bên.
    // thứ tự của các field ko quan tâm.
    // thứ tự của array thì quan tâm nhé.
    JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
  }


  @Test
  void testJSONAssert_WhenExpectationEqualAbsolutelyActualAndArrayIsUnordered_Then() {
    String actual = "{id:1,friends:[{id:2},{id:3}]}";
    String expected = "{friends:[{id:3},{id:2}], id:1}";

    // phâỉ đủ 100% các fields của 2 bên.
    // thứ tự của các field ko quan tâm.
    // thứ tự của array thì ko quan tâm.
    JSONAssert.assertEquals(expected, actual, JSONCompareMode.NON_EXTENSIBLE);
  }


  @Test
  void testJSONAssert_WhenExpectationLessThanActualAndArrayIsOrdered_Then() {
    String actual = "{id:1,friends:[{id:2},{id:3}]}";
    String expected = "{friends:[{id:2},{id:3}]}";

    // cho phép ingore fields
    // thứ tự của các field ko quan tâm.
    // thứ tự của array thì phải đúng.
    JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT_ORDER);
  }
}
