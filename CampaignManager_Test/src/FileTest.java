import java.io.File;


public class FileTest {

	
	public static void main(String[] args) {

		File root = new File(".");

		String[] childs = root.list();
		
		for (String f : childs){
			System.out.println(f.toString());
		}
		
	}
}

