public class Car implements IProduct {
    private String merk;
    private int gewicht;
    private int motorInhoud;
    private double huurPrijs;
    private double verzekering;
    private boolean rented;

    public Car(String merk, int gewicht, int motorInhoud, double huurPrijs, double verzekering) {
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
        this.huurPrijs = huurPrijs;
        this.verzekering = verzekering;
    }

    public CarPriceCalculator createPriceCalculator() {
        return new CarPriceCalculator(this);
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String GetDetails() {
        return
                "Car: " + this.getMerk() + ", Gewicht: " + this.getGewicht() +
                        ", HuurPrijs: " + this.getHuurPrijs() + ", Verzekering: " + this.getVerzekering();
    }

    public String getMerk() {
        return merk;
    }

    public int getGewicht() {
        return gewicht;
    }

    public int getMotorInhoud() {
        return motorInhoud;
    }

    public double getHuurPrijs() {
        return huurPrijs;
    }

    public double getVerzekering() {
        return verzekering;
    }

}
