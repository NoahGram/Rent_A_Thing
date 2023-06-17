public class Truck implements IProduct {

    private String merk;
    private int laadVermogen;
    private int motorInhoud;
    private double huurPrijs;
    private double verzekering;
    private boolean rented;

    public Truck(String merk, int laadVermogen, int motorInhoud, double huurPrijs, double verzekering) {
        this.merk = merk;
        this.laadVermogen = laadVermogen;
        this.motorInhoud = motorInhoud;
        this.huurPrijs = huurPrijs;
        this.verzekering = verzekering;
    }

    public TruckPriceCalculator createPriceCalculator() {
        return new TruckPriceCalculator(this);
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
                "Truck: " + this.getMerk() + ", LaadVermogen: " + this.getLaadVermogen() + "KG, MotorInhoud: " + this.getMotorInhoud() + "L, " +
                        "HuurPrijs: " + this.getHuurPrijs() + ", Verzekering: " + this.getVerzekering();

    }

    public String getMerk() {
        return merk;
    }
    public int getLaadVermogen() {
        return laadVermogen;
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
