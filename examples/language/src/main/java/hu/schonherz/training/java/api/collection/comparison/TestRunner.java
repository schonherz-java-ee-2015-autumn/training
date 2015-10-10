package hu.schonherz.training.java.api.collection.comparison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TestRunner {

	private List<Test> tests;
	
	public TestRunner() {
		this.tests = new ArrayList<>();
	}

	private void test() {
		Collection<ComparableItem> items = generateItems();
		List<TestResult> testResults = runTestsWithItems(items);

		System.out.println(testResults);
	}

	private List<TestResult> runTestsWithItems(Collection<ComparableItem> items) {
		List<TestResult> testResults = new ArrayList<>();

		for (Test test : tests) {
			TestResult testResult = new TestResult();
			testResults.add(testResult);
			Date date = new Date();

			test.init(items);
			test.getElements(items.size() / 10);
			
			Date date2 = new Date();
			long time = date2.getTime() - date.getTime();
			testResult.setClazz(test.getClazz());
			testResult.setInit(time);
		}
		return testResults;
	}

	private Collection<ComparableItem> generateItems() {
		Date datei = new Date();
		Collection<ComparableItem> items = ItemFactory.getItems();
		Date datei2 = new Date();
		long timei = datei2.getTime() - datei.getTime();
		System.out.format("Generating items took %f seconds\n", timei / 1000.0);
		return items;
	}

	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.tests.add(new ArrayListTest());
		runner.test();
	}
}
