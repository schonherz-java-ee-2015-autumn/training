package hu.schonherz.training.java.api.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ComparableItem extends Item implements Comparable<ComparableItem>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {

		return super.toString();
	}

	public void writeObject(ObjectOutputStream stream) throws IOException {
		stream.writeUTF(getId());
		stream.writeUTF(getValue());
	}

	public void readObject(ObjectInputStream stream) throws IOException {

		setId(stream.readUTF());
		setValue(stream.readUTF());

	}
}
