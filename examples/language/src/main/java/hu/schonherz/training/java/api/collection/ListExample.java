package hu.schonherz.training.java.api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		list();
		list2();
	}

	private static void list() {
		List<Item> list = new ArrayList<>();
		list.add(new Item("2", "b"));
		list.add(new Item("1", "a"));
		list.add(new Item("2", "b"));
		list.add(new Item("1", "a"));
		System.out.println(list.getClass() + " " + list);

		Collections.sort(list, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				System.out.println("run comparator");
				return o1.getId().compareTo(o2.getId());
			}

		});
		System.out.println(list.getClass() + " " + list);

		Collections.shuffle(list);

		System.out.println(list.getClass() + " " + list);

		int frequency = Collections.frequency(list, new Item("1", "a"));
		System.out.println(frequency);
		


	}

	private static void list2() {
		List<ComparableItem> list = new ArrayList<>();
		list.add(new ComparableItem("2", "b"));
		list.add(new ComparableItem("1", "a"));
		list.add(new ComparableItem("2", "b"));
		System.out.println(list.getClass() + " " + list);

		Collections.sort(list);

		System.out.println(list.getClass() + " " + list);
		
		ComparableItem maxComparableItem = Collections.max(list);
		
		System.out.println(maxComparableItem);

	}
}
