package tddstack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TDDStack s = new TDDStack();
		s.push(2);
		s.push(12);
		s.push(45);
		
		System.out.println("size = " + s.getSize());
	
		for(int i: s.getContents()) {
			System.out.println(i);
		}
		System.out.println("size = " + s.getSize());
		
		s.clear();
		System.out.println("size = " + s.getSize());
		
		for(int i: s.getContents()) {
			System.out.println(i);
		}
		System.out.println("size = " + s.getSize());
		
		
		TDDStackConfigurable sc = new TDDStackConfigurable();
		
//		System.out.println("\nStos zmienny");
//		System.out.println(sc.getCapacity());
//		
//		sc.fillFullContents();
//		
//		for(int i: sc.getContents()) {
//			System.out.println(i);
//		}
//		
//		sc.setCapacity(5);
//
//		
//		System.out.println(sc.getCapacity());

	}

}

