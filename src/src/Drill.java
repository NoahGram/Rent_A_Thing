public class Drill implements IProduct {
    private String merk;
    private String type;
    private double huurPrijs;
    private double verzekering;
    private boolean rented;
    private Customer customer;

    public Drill(String merk, String type, double huurPrijs, double verzekering) {
        this.merk = merk;
        this.type = type;
        this.huurPrijs = huurPrijs;
        this.verzekering = verzekering;
    }

    public DrillPriceCalculator createPriceCalculator() {
        return new DrillPriceCalculator(this);
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public double getHuurPrijs() {
        return huurPrijs;
    }

    public double getVerzekering() {
        return verzekering;
    }

    public String GetDetails() {
        return
            "Drill: " + this.getMerk() + ", Type: " + this.getType() +
            ", HuurPrijs: " + this.getHuurPrijs() + ", Verzekering: " + this.getVerzekering() +
                ", Rental Status: " + this.isRented();

    }

    @Override
    public void assignCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }
}
