package iteratorPattern;

import java.util.ArrayList;

import driverCode.ConcreteStoreImplementation;
import model.ConcreteStoreModel;

public class ConcreteItemCatelog implements IterableItem {

	@Override
	public ConcreteStoreIterator getItemIterator() {
		return new ConcreteItemIterator();
	}

	private class ConcreteItemIterator implements ConcreteStoreIterator {
		int i;

		@Override
		public boolean hasNextItem() {
			if (i < ConcreteStoreImplementation.concreteCount) {
				return true;
			}
			return false;
		}

		@Override
		public Object nextItem() {
			if (this.hasNextItem()) {
				return ConcreteStoreImplementation.concreteList[i++];
			}
			return null;
		}

	}

}
