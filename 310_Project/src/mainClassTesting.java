import java.util.ArrayList;

public class mainClassTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add(0, "depp");
		list.add(1, "dskjbfjkdbsf");
		list.add(2, "jkdfj");
		list.add(3, "kiohsfjbsd");
		list.add(4, "gibe");
		list.add(5, "five");
		
		String listString = "";
			   
			   for(String s : list) {
				   listString += s + "\t";
			   }
		System.out.println(listString + "\t");	

	}

}
