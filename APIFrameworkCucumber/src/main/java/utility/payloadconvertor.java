package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadconvertor {
	
	public static String generatepayloadstring(String filename) throws IOException
	{
		String filepath = "E:\\Selenium-Workspace\\Rest Assured\\APIFrameworkCucumber\\resource\\" + filename;
		//String filepath = System.getProperty("user.dir")+"\\resource\\" + filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
		System.out.print("This is sunil");
	}

}
