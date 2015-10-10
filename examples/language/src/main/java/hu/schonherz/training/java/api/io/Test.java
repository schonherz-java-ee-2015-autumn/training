package hu.schonherz.training.java.api.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	static final String dataFile = "data";

	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

	public static void main(String[] args) {
		write();
		read();
	}

	private static void write() {
		
		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}

		} catch (IOException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	private static void read() {
		DataInputStream in = null;
		try {

			in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			while (true) {
				double price = in.readDouble();
				int unit = in.readInt();
				String desc = in.readUTF();
				System.out.format("You ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
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
