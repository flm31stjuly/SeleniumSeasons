package oct17th;

public class TypeCastDemo {

	public static void main(String[] args) {
		
		int x=10;
		
		double y = Math.random();  //return 0.0 to 1.0
		
		System.out.println(y);
		
		System.out.println(y*1000);
		
		System.out.println((int)(y*1000));

	}

}
