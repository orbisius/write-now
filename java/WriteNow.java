/**
 * Creates a file really quick and allows you to start writing NOW.
 * The file is prefixed by an exclamation which hints that it's a draft.
 * 
 * @author Svetoslav (SLAVI) Marinov | http://orbisius.com
 * @copyright (c) 2016 Svetoslav (SLAVI) Marinov
 */
 
import java.util.Scanner;
import java.util.Calendar;
import java.io.File;
import java.io.PrintWriter;

import java.awt.Desktop;
import java.io.IOException;

class WriteNow
{
   public static void main(String args[])
   {
	   try {
		  Calendar cal = Calendar.getInstance();
		  int year = cal.get(Calendar.YEAR);
		  int month = cal.get(Calendar.MONTH) + 1; // starts from 0!
		  int day = cal.get(Calendar.DAY_OF_MONTH);
		  String baseWritingDir = "C:/Copy/Dropbox/Business/" + year + "/Writing";
		  String targetExt = ".docx";
		  String articleTitle;

		  Scanner in = new Scanner(System.in);

		  System.out.print("Enter post title: ");
		  articleTitle = in.nextLine();
		  articleTitle = articleTitle.trim();
		  
		  // ! is for drafts
		  // http://stackoverflow.com/questions/11599947/calendar-minute-giving-minutes-without-leading-zero
		  String articleDir = baseWritingDir + File.separator + 
				'!' + year + '-'+ String.format("%02d", month) + '-' 
				+ String.format("%02d", day ) + '-' + articleTitle;

		  File f = new File(articleDir);
		  
		  if ( ! f.exists() ) {
			  f.mkdirs();
		  }

		  File articleFile = new File(articleDir + File.separator + articleTitle + targetExt);		  
		  
		  /*try {			 
			 articleFile.getParentFile().mkdirs();		  
		  } catch (Exception e) {
		  }*/

		  // Create a blank file
		  if ( ! articleFile.exists() ) {
			// http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
		    System.out.println("Creating " + articleFile);
			
			PrintWriter writer = new PrintWriter(articleFile, "UTF-8");
			writer.close();
		  }
		  
		  // http://stackoverflow.com/questions/6871664/using-java-how-do-i-cause-word-to-open-and-edit-a-file
		  try {
			 if (Desktop.isDesktopSupported()) {
			System.out.println("Opening " + articleFile);
			   Desktop.getDesktop().open(articleFile);
			 }
		  } catch (IOException ioe) {
			 ioe.printStackTrace();
		  }

		  // http://www.mkyong.com/java/how-to-execute-shell-command-from-java/
		  // Open dir that the file is in
		  Process p = Runtime.getRuntime().exec("explorer /select," + articleFile);
	  } catch (Exception e) {
	  }
   }
}
