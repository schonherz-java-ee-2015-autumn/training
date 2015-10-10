package hu.schonherz.training.java.api.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {

//		setWithoutOrder();

//		setWithOrder();
//
//		setWithOrder2();
//
		Set<Item> singelton = Collections.singleton(new Item("1", "a"));
		System.out.println(singelton.getClass() + " " + singelton);
		singelton.add(new Item("3", "c"));

		Set<Item> empty = Collections.emptySet();
		System.out.println(singelton.getClass() + " " + empty);
	}

	private static void setWithOrder() {
		TreeSet<Item> treeSet = new TreeSet<>();
		treeSet.add(new ComparableItem("1", "b"));
		treeSet.add(new ComparableItem("2", "b"));
		treeSet.add(new ComparableItem("1", "a"));

		System.out.println(treeSet.getClass() + " " + treeSet);
	}

	private static void setWithOrder2() {
//		 TreeSet<Item> treeSet = new TreeSet<>();
//		
//		 treeSet.add(new Item("2", "b"));
//		 treeSet.add(new Item("1", "a"));
//
//		 System.out.println(treeSet.getClass() + " " + treeSet);

		Comparator<? super Item> comparator = new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				System.out.println("run comparator");
				return o1.getId().compareTo(o2.getId());
			}
		};

		TreeSet<Item> treeSet2 = new TreeSet<>();
		treeSet2.add(new Item("1", "b"));
		treeSet2.add(new Item("2", "b"));
		treeSet2.add(new Item("1", "a"));

		System.out.println(treeSet2.getClass() + " " + treeSet2);
	}

	private static void setWithoutOrder() {
		Set<Item> items = new HashSet<>();
		items.add(new Item("1", "b"));
		items.add(new Item("2", "b"));
		items.add(new Item("1", "a"));

		System.out.println(items.getClass() + " " + items);

		LinkedHashSet<Item> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(new Item("1", "b"));
		linkedHashSet.add(new Item("2", "b"));
		linkedHashSet.add(new Item("1", "a"));

		System.out.println(linkedHashSet.getClass() + " " + linkedHashSet);
		
		System.out.println(linkedHashSet.contains(new Item("1", "a")));

	}
}
