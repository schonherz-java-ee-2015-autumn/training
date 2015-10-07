package hu.schonherz.training.java.language.inheritance.interf;

public class Impl implements InterfaceC {

	static String FIELD = "IMPL";

	@Override
	public void a() {
		// TODO Auto-generated method stub

	}

	@Override
	public void b() {
		// TODO Auto-generated method stub

	}

	@Override
	public void c() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		good();

		bad();

		bad2();

	}

	private static void bad() {
		System.out.println("bad");
		InterfaceA implA = new Impl();

		System.out.println(implA.FIELD);

		InterfaceB implB = new Impl();

		System.out.println(implB.FIELD);

		InterfaceC implC = new Impl();

		System.out.println(implC.FIELD);
		System.out.println("-----");
		bad3(implC);
	}

	private static void bad2() {
		Impl impl = new Impl();
		System.out.println("bad2");
		System.out.println(((InterfaceA) impl).FIELD);
		System.out.println(((InterfaceB) impl).FIELD);
		System.out.println(((InterfaceC) impl).FIELD);
		System.out.println("-----");
	}

	private static void bad3(InterfaceB impl) {
		System.out.println("bad3");
		System.out.println(impl.FIELD);
		System.out.println("-----");
	}

	private static void good() {
		System.out.println("good");
		System.out.println(Impl.FIELD);
		System.out.println(InterfaceA.FIELD);
		System.out.println(InterfaceB.FIELD);
		System.out.println(InterfaceC.FIELD);
		System.out.println("-----");
	}

}
