package hu.schonherz.training.java.api.collection.comparison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemFactory {

	private static List<ComparableItem> comparableItems = null;

	public static Collection<ComparableItem> getItems() {
		if (comparableItems == null) {
			comparableItems = new ArrayList<>();
			for (int i = 0; i < 3_000_000; i++) {
				comparableItems.add(new ComparableItem("" + i, "test_" + i));

			}
		}
		return comparableItems;

	}
}
