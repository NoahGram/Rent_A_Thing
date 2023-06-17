public abstract class ProductPriceCalculator {
    protected IProduct product;

    public ProductPriceCalculator(IProduct product) {
        this.product = product;
    }

    protected abstract double berekenPrijs();
    protected abstract double berekenHuurPrijs();
    protected abstract double berekenVerzekering();
}
