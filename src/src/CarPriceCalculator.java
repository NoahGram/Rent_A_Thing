public class CarPriceCalculator extends ProductPriceCalculator {
    private Car car;
    public CarPriceCalculator(Car car) {
        super(car);
        this.car = car;
    }

    @Override
    protected double berekenPrijs() {
        return berekenHuurPrijs() + berekenVerzekering();
    }

    @Override
    protected double berekenHuurPrijs() {
        return 50;
    }

    @Override
    protected double berekenVerzekering() {
        return car.getMotorInhoud() * 0.01; // 0.01 euro per cc motorinhoud per day
    }
}