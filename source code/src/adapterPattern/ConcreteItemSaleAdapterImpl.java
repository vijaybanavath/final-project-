package adapterPattern;

public class ConcreteItemSaleAdapterImpl implements ConcreteStoreSaleAdapter {

	private ConcreteStoreSale concStoreSale;

	public ConcreteItemSaleAdapterImpl(ConcreteStoreSale concStoreSale) {
		this.concStoreSale = concStoreSale;
	}

	@Override
	public double getSalePercentage() {
		return concStoreSale.getSalePercentage();
	}

}
