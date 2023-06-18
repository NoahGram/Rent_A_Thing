public interface IProduct {
    ProductPriceCalculator createPriceCalculator();
    boolean isRented();
    void setRented(boolean rented);
    String GetDetails();

    void assignCustomer(Customer customer);

    Customer getCustomer();
}
