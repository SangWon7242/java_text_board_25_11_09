import java.util.HashMap;
import java.util.Map;

public class QueryStringParsingTest {
  public static void main(String[] args) {
    String url = "/usr/article/list?page=1&code=title&q=제목1 입니까? 여기는..";
    Map<String, String> params1 = Ut.getParamFromUrl(url);
    String urlPath1 = Ut.getPathFromUrl(url);
    System.out.println("params1 : " + params1);
    System.out.println("urlPath1 : " + urlPath1);

    url = "/usr/article/list";
    Map<String, String> params2 = Ut.getParamFromUrl(url);
    String urlPath2 = Ut.getPathFromUrl(url);
    System.out.println("params2 : " + params2);
    System.out.println("urlPath2 : " + urlPath2);
  }

  class Ut {
    public static Map<String, String> getParamFromUrl(String url) {
      Map<String, String> params = new HashMap<>();
      String[] urlBits = url.split("\\?", 2);

      if(urlBits.length == 1) return params;

      String queryString = urlBits[1];

      String[] queryBits = queryString.split("&");
      for(String queryBit : queryBits) {
        String[] queryBitBits = queryBit.split("=", 2);

        String paramName = queryBitBits[0];
        String paramValue = queryBitBits[1];

        params.put(paramName, paramValue);
      }

      return params;
    }

    public static String getPathFromUrl(String url) {
      String[] urlBits = url.split("\\?", 2);
      return urlBits[0];
    }
  }
}
