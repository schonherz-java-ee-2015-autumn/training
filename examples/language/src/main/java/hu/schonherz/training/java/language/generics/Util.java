package hu.schonherz.training.java.language.generics;

import java.io.Serializable;
import java.util.List;

public class Util {

	public static <T extends Serializable & Comparable> void print(T t) {
		System.out.println(t.toString());
	}

	public static void process(List<? extends Comparable<?>> list) {
		for (Comparable<?> comparable : list) {
//			comparable.compareTo(list.get(0));
			extracted(list.get(0), comparable);
			
		}
		
		
	}

	private static <T extends Comparable> int extracted(T t1, T t2) {
		return t1.compareTo(t2);
	}
}
