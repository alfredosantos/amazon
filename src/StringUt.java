import static java.io.File.separator;

public class StringUt {
    /**
     * Concatenates the given array of​​​​​​‌​​​‌​​​​​​‌‌​​​​‌​​‌​​​​ strings.
     */
    public String concat(String[] strings) {
      StringBuilder sb = new StringBuilder();
      String sep = ",";
      for (String s : strings) {
        sb.append(sep).append(s);
        sep = separator;
      }
      return sb.toString();
    }
}
