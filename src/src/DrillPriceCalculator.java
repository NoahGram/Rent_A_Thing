public class DrillPriceCalculator extends ProductPriceCalculator {
    private Drill drill;
    public DrillPriceCalculator(IProduct product) {
        super(product);
        this.drill = drill;
    }

    @Override
    public double berekenPrijs() {
        return berekenHuurPrijs() + berekenVerzekering();
    }

    @Override
    protected double berekenHuurPrijs() {
        return 5;
    }

    @Override
    protected double berekenVerzekering() {
        return 1;
    }
}