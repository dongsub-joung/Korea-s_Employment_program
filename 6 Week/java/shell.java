public class shell {
  public static void main (String[] args) {
    boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("mac os x");
    try {
       Runtime.getRuntime().exec(String.format("clear"));
    } catch(Exception e) {
      
    }
  }
}
