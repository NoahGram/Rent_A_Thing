public class TruckPriceCalculator extends ProductPriceCalculator {
    private Truck truck;

    public TruckPriceCalculator(Truck truck) {
        super(truck);
        this.truck = truck;
    }

    @Override
    protected double berekenPrijs() {
        return berekenHuurPrijs() * berekenVerzekering();
    }

    @Override
    protected double berekenHuurPrijs() {
        return truck.getLaadVermogen() * 0.10;
    }

    @Override
    protected double berekenVerzekering() {
        return truck.getMotorInhoud() * 0.01; // 0.01 euro per cc motorinhoud per day
    }
}