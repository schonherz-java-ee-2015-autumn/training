package hu.schonherz.training.java.api.collection.comparison;

import java.util.Collection;

public interface Test {

	void init(Collection<ComparableItem> items);

	void order();

	void getElements(int s);

	void delete(int s, int e);

	void deleteDup();

	String getClazz();
}
