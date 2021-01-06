package Testy2;

public class Purchase {

    private final String coustumerID;
    private final String customerSurname;
    private final String coustumerName;
    private final String productName;
    private final double price;
    private final double aumount;
    private final double cost;

    public Purchase(String coustumerID, String customerSurname, String coustumerName, String productName, double price, double aumount, double cost) {
        this.coustumerID = coustumerID;
        this.customerSurname = customerSurname;
        this.coustumerName = coustumerName;
        this.productName = productName;
        this.price = price;
        this.aumount = aumount;
        this.cost = cost;
    }

    public String getCoustumerID() {
        return coustumerID;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return coustumerID + ";" + customerSurname + " " + coustumerName + ";" + productName + ";" + price + ";" + aumount;
    }
}
