/**
 * @author Gryka Konrad S19228
 */

package zad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomersPurchaseSortFind {

    private List<Purchase> purchases = new ArrayList<>();

    public void readFile(String s) {

        purchases = new ArrayList<>();
        List<String> purchaseInfo = new ArrayList<>();

        try {
            new File(s);
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                List<String> stringList = Arrays.asList(temp.split("[; ]"));
                purchaseInfo.addAll(stringList);
            }

            for (int i = 0; i < purchaseInfo.size(); i += 6) {
                purchases.add(new Purchase(
                                purchaseInfo.get(i),
                                purchaseInfo.get(i + 1),
                                purchaseInfo.get(i + 2),
                                purchaseInfo.get(i + 3),
                                Float.parseFloat(purchaseInfo.get(i + 4)),
                                Float.parseFloat(purchaseInfo.get(i + 5)),
                                Float.parseFloat(purchaseInfo.get(i + 4)) * Float.parseFloat(purchaseInfo.get(i + 5))
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Unexpected err");
        }
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        purchases.stream()
                .filter(e -> {
                    return id.equals(e.getCoustumerID());
                })
                .forEach(System.out::println);
        System.out.println();
    }

    public void showSortedBy(String s) {
        Comparator<Purchase> sortBySurname = Comparator.comparing(Purchase::getCustomerSurname).thenComparing(purchase -> {
            return purchase.getCoustumerID();
        });
        Comparator<Purchase> sortByCosts = Comparator.comparing(Purchase::getCost).thenComparing(purchase -> {
            return purchase.getCoustumerID();
        });
        switch (s) {
            case "Nazwiska":
                System.out.println(s);
                purchases.stream().sorted(sortBySurname)
                        .forEach(System.out::println);
                break;
            case "Koszty":
                System.out.println(s);
                purchases.stream()
                        .sorted(sortByCosts)
                        .forEach(System.out::println);
                break;
            default:
                System.out.println(s);
                purchases.stream()
                        .sorted()
                        .forEach(System.out::println);
        }
        System.out.println();
    }
}