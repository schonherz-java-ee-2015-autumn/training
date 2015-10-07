package hu.schonherz.training.java.api.collection;

public class ComparableItem extends Item implements Comparable<ComparableItem> {

	public ComparableItem() {
		super();
	}

	public ComparableItem(String id, String value) {
		super(id, value);
	}

	@Override
	public int compareTo(ComparableItem o) {
		System.out.println("run compareTo");
		if (this == o) {
			return 0;
		}

		return getId().compareTo(o.getId());
	}

}
