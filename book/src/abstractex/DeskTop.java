package abstractex;

public class DeskTop extends Computer {

	@Override
	public void distplay() {
		System.out.println("DeskTop display()");		
	}

	@Override
	public void typing() {
		System.out.println("DeskTop typing()");
	}

}
