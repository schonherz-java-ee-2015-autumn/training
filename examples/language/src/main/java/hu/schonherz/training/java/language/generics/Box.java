package hu.schonherz.training.java.language.generics;

import java.io.Serializable;

/**
 * Generic version of the Box class.
 * 
 * @param <T>
 *            the type of the value being boxed
 */
public class Box<T extends Comparable<T>> implements Serializable, Comparable<T> {
	// T stands for "Type"
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	@Override
	public String toString() {
		return "Box [t=" + t.toString() + "(" + t.getClass() + ")]";
	}

	@Override
	public int compareTo(T o) {
		return t.compareTo(o);
	}

}