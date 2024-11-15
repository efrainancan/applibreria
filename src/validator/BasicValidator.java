package validator;

import java.util.Arrays;

public class BasicValidator {

  protected boolean isBlank(String value) {
    return value == null || value.isBlank();
  }

  protected boolean inArray(String[] arr, String value) {
    return Arrays.asList(arr).contains(value);
  }

}
