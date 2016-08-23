package ru.lexpr.processtart;

import java.io.IOException;
import java.nio.charset.Charset;
import java.io.*;

public class Program {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("process starting...");
		
		File cd = new File(".");
		System.out.println(cd.getCanonicalPath());
		
		Process p = Runtime.getRuntime().exec("cmd /C dir c:\\");
		InputStream in = p.getInputStream();
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(in, Charset.forName("cp866")));
		
		String s;
		while((s = reader.readLine()) != null)
			System.out.println(s);
		
		int exitCode = p.waitFor();
		System.out.printf("Exit code: %d\n", exitCode);
		
		System.exit(exitCode);
	}
}
