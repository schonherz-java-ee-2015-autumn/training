package hu.schonherz.training.java.api.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

public class TestObject {
	static final String dataFile = "objectData";
	static List<ComparableItem> items;

	public static void main(String[] args) {
		items = new ArrayList<>();
		items.add(new ComparableItem("1", "a"));
		items.add(new ComparableItem("2", "b"));

		write();
		read();
	}

	private static void write() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
			for (int i = 0; i < items.size(); i++) {
				out.writeObject(items.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}

		}
	}

	private static void read() {
		
		ObjectInputStream in = null;
		try {

			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			try {
				while (true) {
					Item item = (Item) in.readObject();
					System.out.println(item);
				}
			} catch (EOFException e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
