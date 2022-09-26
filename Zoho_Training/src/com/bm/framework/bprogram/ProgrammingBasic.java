/**
 * 
 */
package com.bm.framework.bprogram;
import java.util.*;

import com.bm.util.CustomException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * @author Balamurugan
 */
public class ProgrammingBasic {
	public static Scanner scan = new Scanner(System.in);
	public static void createDirectory(String path) throws IOException
	{
		Path PATH = Paths.get(path);
		if(!Files.exists(PATH))
		{
			Files.createDirectory(PATH);
		}
	}
	public static void writeFile(String fileName,String path) throws  Exception
	{
		createDirectory(path);
		try(FileOutputStream fos = new FileOutputStream(new File("/home/inc5/myDir/"+fileName));
				BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(fos));)
		{
			int n = 3;
			for(int i=0;i<3;i++)
			{
				String line = scan.nextLine();
				bWriter.write(line);
				bWriter.newLine();
			}
		}
		catch(IOException e)
		{
			throw new CustomException("File not found");
			
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
	}
	
}
