package request;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Utils {
	/**
	 * string with the carriage return and line-feed
	 */
	public 7static final String CRLF = "\r\n";

	public static HashMap<String, String> getContentDirectory (String directory) throws IOException {
		HashMap<String, String> contentDirectory = new HashMap<String, String>();
   
        Path directoryPath = FileSystems.getDefault().getPath(directory);    
        File folder = new File(directoryPath.toString());
        File[] files = folder.listFiles();
        for (File file : files) {
        	contentDirectory.put("/" + file.getName(), Files.readString(Path.of(file.toString())));
		}
		
		return contentDirectory;	
	}
}