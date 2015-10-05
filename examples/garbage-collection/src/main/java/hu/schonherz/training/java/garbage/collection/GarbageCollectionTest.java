package hu.schonherz.training.java.garbage.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class GarbageCollectionTest {

	public static void main(String[] args) {
		final String prototype = createPrototype();
		final Map<Integer, String> map = 
				new WeakHashMap<>();
		
		for(int i=0;;++i) {
			map.put(
				i,
				new String(
					prototype.toCharArray()
				)
			);
		}
		
	}

	private static String createPrototype() {
		final StringBuilder sb = new StringBuilder();
		final String base = "sample";
		final int count = 1;
		
		for(int i=0; i<count; ++i) {
			sb.append(base).append('\n');
		}
		
		return sb.toString();
	}
	
}
