import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class testGenerator {
	public static void main(String[] args) throws IOException {
		BufferedWriter bfd = new BufferedWriter(new FileWriter(new File("I:\\Programming Workspace\\JAVA\\CodeChef\\TestCase.txt")));
		
		bfd.write("3000");
		Random rnd = new Random();
		for(int i=0;i<3000;i++) {
			String s="";
			for(int j=0;j<3;j++) {
				double x=rnd.nextDouble();
				if(x<0.5) {
					s+='X';
				}
				else if(x<0.93) {
					s+='O';
				}
				else {
					s+='_';
				}
			}
			bfd.write("\n"+s);
		}
		bfd.close();
	}
}
