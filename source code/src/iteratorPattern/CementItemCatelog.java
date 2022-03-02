package iteratorPattern;

import java.util.ArrayList;

import driverCode.ConcreteStoreImplementation;
import model.ConcreteStoreModel;

public class CementItemCatelog implements IterableItem {

	@Override
	public ConcreteStoreIterator getItemIterator() {
		return new CementItemIterator();
	}

	private class CementItemIterator implements ConcreteStoreIterator {
		int i;

		@Override
		public boolean hasNextItem() {
			if (i < ConcreteStoreImplementation.cementCount) {
				return true;
			}
			return false;
		}

		@Override
		public Object nextItem() {
			if (this.hasNextItem()) {
				return ConcreteStoreImplementation.cementList[i++];
			}
			return null;
		}

	}

}
