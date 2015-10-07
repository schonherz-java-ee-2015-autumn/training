package hu.schonherz.training.java.api.collection.comparison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class ArrayListTest implements Test {

	ArrayList<ComparableItem> arrayList;

	@Override
	public void init(Collection<ComparableItem> items) {
		arrayList = new ArrayList<>(items);
	}

	@Override
	public void order() {
		Collections.sort(arrayList);
	}

	@Override
	public void getElements(int s) {
		for (int i = 0; i < s; i++) {
			Random random = new Random();
			arrayList.get(random.nextInt(arrayList.size() - 1));
		}

	}

	@Override
	public void delete(int s, int e) {

		for (int i = s; i < e; i++) {
			arrayList.remove(i);
		}

	}

	@Override
	public String getClazz() {
		return "java.util.ArrayList";
	}

	@Override
	public void deleteDup() {
		TreeSet<ComparableItem> comparableItems = new TreeSet<>(arrayList);
	}

}
