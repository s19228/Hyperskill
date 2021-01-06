/**
 *
 *  @author Gryka Konrad S19228
 *
 */


package zad3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<String> dest = Arrays.asList(
            "bleble bleble 2000",
            "WAW HAV 1200",
            "xxx yyy 789",
            "WAW DPS 2000",
            "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream().filter(elm ->
            elm.startsWith("WAW")).map(elm -> {
              String [] strTab = elm.split( " ");
              return "to " + strTab[1] + " - price in PLN: " + Math.round(Integer.parseInt(strTab[2])*ratePLNvsEUR);
            }
    ).collect(Collectors.toCollection(ArrayList::new));

    for (String r : result) System.out.println(r);
  }
}

