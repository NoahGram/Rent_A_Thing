public interface IProduct {
    ProductPriceCalculator createPriceCalculator();
    boolean isRented();
    void setRented(boolean rented);

    String GetDetails();
}
