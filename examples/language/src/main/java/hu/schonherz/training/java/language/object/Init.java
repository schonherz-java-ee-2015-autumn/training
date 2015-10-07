package hu.schonherz.training.java.language.object;

public class Init {
	static {
		staticField2 = 2;
		System.out.println("static init");
	}

	{
		System.out.println("instance init");
		staticField3 = 3;
		instanceField2 = 2;
	}

	public static int staticField = 1;

	public static int staticField2;

	public static int staticField3;

	public static int staticField4 = getStaticFieldValue();

	public int instanceField = 1;

	public int instanceField2;

	public int instanceField3 = getFieldValue();

	public Init() {
		System.out.println("constructor init");
	}

	private static int getStaticFieldValue() {
		System.out.println("static method init");
		return 4;
	}

	private final int getFieldValue() {
		System.out.println("instance method init");
		return 4;
	}

}
