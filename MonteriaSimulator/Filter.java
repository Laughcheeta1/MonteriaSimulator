/**
 * Just a simple Filter
 * 
 * @Santiago Yepes Mesa
 * @14/7/2023
 */
 

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

	private String extension;

	public Filter(String extension)
	{
		this.extension = extension;
	}
	
	public boolean accept(File dir, String name) 
	{
		return name.endsWith(extension);
	}

}
