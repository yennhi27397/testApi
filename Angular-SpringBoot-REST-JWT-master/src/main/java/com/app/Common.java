package com.app;

import java.lang.reflect.Field;

public class Common {
  public static boolean isEmptyObject(Object o) {
    for (Field field : o.getClass().getDeclaredFields()) {
      try {
        field.setAccessible(true);
        if (field.get(o) != null) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    }
    return true;
  }
}
