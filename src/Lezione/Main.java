package Lezione;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		File f = new File("../Test.txt");
		try {
			FileUtils.writeStringToFile(f, "Test", "UFT-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
