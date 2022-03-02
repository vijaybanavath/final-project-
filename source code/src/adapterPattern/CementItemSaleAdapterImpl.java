package adapterPattern;

public class CementItemSaleAdapterImpl implements ConcreteStoreSaleAdapter {

	private ConcreteStoreSale concStoreSale;

	public CementItemSaleAdapterImpl(ConcreteStoreSale concStoreSale) {
		this.concStoreSale = concStoreSale;
	}

	@Override
	public double getSalePercentage() {
		return concStoreSale.getSalePercentage();
	}

}
