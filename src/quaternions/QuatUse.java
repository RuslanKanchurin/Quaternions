package quaternions;

public class QuatUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quaternion p=new Quaternion(0,2,0,0);
		Quaternion q=new Quaternion(0,Math.sqrt(2)/2,0,Math.sqrt(2)/2);
		System.out.println(p.rotate(q,45));		
	}

}
