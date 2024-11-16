package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseCLI {

  protected int readInt() throws IOException {
    return Integer.parseInt(readString());
  }

  protected String readString() throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    return br.readLine().trim();
  }

  protected String prompt(String value) {
    try {
      System.out.print(value);
      return readString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  protected int promptInt(String value) {
    return Integer.parseInt(prompt(value));
  }

  protected void br() {
    System.out.println("================================");
  }

  protected void br(String preMessage) {
    System.out.println(preMessage);
    br();
  }

  protected void showError(String msg) {
    System.err.println(msg);
  }

}
