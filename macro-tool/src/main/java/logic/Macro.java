package logic;

import java.io.*;
import java.util.Vector;

public class Macro {

	final static String WORKING_DIR = System.getProperty("user.dir") + File.separator;
	
	public static Vector<Macro> currentMacros = new Vector<Macro>();
	
	private String file = "";
	private int line = 1;
	
	BufferedReader userInput;
	
	static boolean allOutputsClosed = true;
	static boolean justClosed = false;
	public static String prevMacro;
	
	public static float xRotation;
	public static float currentXRotation;
	public static int currentXPixels;
	public static float yRotation;
	public static float currentYRotation;
	public static int currentYPixels;
	private static int wIterations;
	private static int aIterations;
	private static int sIterations;
	private static int dIterations;
	private static int sprintIterations;
	private static int sneakIterations;
	private static int jumpIterations;
	private static int lmbIterations;
	private static int rmbIterations;
	public static int[] pressIterations = {wIterations, aIterations, sIterations, dIterations, sprintIterations, sneakIterations, jumpIterations, lmbIterations, rmbIterations};
	
	
	public Macro(String name) {
		this.file = name;
		currentMacros.add(this);
		allOutputsClosed = false;
		//currentMacros.forEach((logic.Macro macro) -> System.out.println(macro.getFilename()));
		
			try {
				this.userInput = new BufferedReader(new FileReader(WORKING_DIR + this.getFile()));
			} catch (FileNotFoundException e1) {
				CommandHelper.printError("The file \" " + this.file + " could not be found." );
				currentMacros.remove(this);
				allOutputsClosed = true;
			}

		try {
			this.userInput.readLine();
		} catch (IOException e) { 
			CommandHelper.printError("The file \" " + this.file + " could not be read." );
		}
		catch (NullPointerException e1) {}
		
	}
	
	public void readLine() {
		//System.out.println(this.file);
		this.line++;		
		try {
				String[] lineSplit = this.userInput.readLine().split("\t");
				if (lineSplit.length > 0) {
					if(!lineSplit[0].equals("")) {
						String[] newMacros = lineSplit[0].split("/");
						for (String string : newMacros) {
							if (string.startsWith("-")) {
								currentMacros.removeIf((Macro macro) -> macro.getFile().equals(string.substring(1)));
							} else {
								new Macro(string);
							}
						}
					}
					for (int i = 1; i < lineSplit.length && i <= 9; i++) {
						if(!lineSplit[i].equals("")) {
							int num = -1;
							try {
								 num = Integer.parseInt(lineSplit[i]);
							} catch (NumberFormatException e2) {CommandHelper.printError("Your input in line " + this.line + ", column " + (i+1) + " is not valid.");}
							if(num > pressIterations[i-1]) { pressIterations[i-1] = num; }
						}
					}
					if (lineSplit.length > 10 && !lineSplit[10].equals("")) {
						xRotation += Double.parseDouble(lineSplit[10]);
					}
					if (lineSplit.length > 11) {
						yRotation += Double.parseDouble(lineSplit[11]);
					}
				}
			} catch (IOException e) { }
	}
	
	public String getFile() {
		return this.file;
	}
	
	public static void closeMacros() {
		   for (int i = 0; i < Macro.pressIterations.length; i++) {
				Macro.pressIterations[i] = -1;
		   }

		   for (int i = 0; i < currentMacros.size(); i++) {
			   try {
				currentMacros.get(i).userInput.close();
			} catch (IOException e) { }
		   }
		   Macro.currentMacros.clear();
		   allOutputsClosed = true;
		   justClosed = true;
	}
}
