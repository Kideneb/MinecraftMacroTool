package logic;

import java.io.IOException;

public class CommandHelper {

	public static String input = "";

	public void listen() throws IOException {
		if(!input.equals("")) {
			String line = input;
			System.out.println(line);
			input = "";
			String command = "";
			boolean singleWordCommand;
			String[] params = line.substring(line.indexOf(" ") + 1).split(" ");
			
			if (line.contains(" ")) {
				command = line.substring(0, line.indexOf(" "));
				singleWordCommand = false;
			} else { 
				command = line;
				singleWordCommand = true;
			}
			
			
			switch (command) {
				case "help": 	
								if (singleWordCommand) {
									printMessage("Write commands into the console.");
									printMessage("To execute a macro type \"start <'file'>\".");
									printMessage("To stop all macros type either \"stop\" or press the F10 key.");
									printMessage("To repeat the last executed macrofile press the F9 key.");
									printMessage("To see a list of all commands type \"help commands\".");
									printMessage("To see a detailed description of a single command type \"help <'command'>\".");
									printMessage("For more information on how to create macros and a FAQ read the README.txt in the download folder.");
								} else {
									if(params.length > 1) {
										System.out.println("WARNING: \"help\" has only a single parameter (help [commands|'command'])");
									}
									switch(params[0]) {
									case "commands":
										printMessage("help [commands | 'command']");
										printMessage("list");
										printMessage("start <'file'> ['numberOfTicks']");
										printMessage("stop ['file']");
										printMessage("info");
										break;
									case "help":
										printMessage("Syntax: help [commands|'command']");
										printMessage("\"help\" gives basic information about the usage of the logic.Macro Parkour Tool.");
										printMessage("\"help commands\" lists all commands and their syntax.");
										printMessage("\"help 'command'\" gives a detailed description of the command.\"");
										printMessage("Examples: \"help\", \"help commands\", \"help start\"");
										break;
									case "list":
										printMessage("Syntax: list");
										printMessage("\"list\" lists all macros that are currently being read and executed.");
										break;
									case "start":
										printMessage("Syntax: start <'file'> ['numberOfTicks']");
										printMessage("\"start 'file'\" begins executing the macro file.");
										printMessage("\"start 'file' 'numberOfTicks'\" opens the macro file after the specified amount of ticks.");
										printMessage("The file got to be in the same directory as the logic.Macro Parkour Tool.");
										printMessage("You also have to specify the file type with the corresponding filename extension.");
										printMessage("Examples: \"start hard_jump.txt\", \"start double_triple_neo.txt 40\"");
										break;
									case "stop":
										printMessage("Syntax: stop ['file']");
										printMessage("\"stop\" stops all running macros and simulated keypresses.");
										printMessage("\"stop 'file'\" stops interpreting the file.");
										printMessage(" Examples: \"stop\", \"stop quad_neo\"");
										break;
									case "info":
										printMessage("Syntax: info");
										printMessage("\"info\" shows information about the tool's version, author and release date.");
										break;
									default:
										printError("Unknown command \"" + params[0] + "\".");
										break;
									}
									
								}
								System.out.println("");
								break;
				case "list":
								if (!singleWordCommand) { printWarning("\"list\" has no parameters (list)"); }
								Macro.currentMacros.forEach((Macro macro) -> System.out.println(macro.getFile()));
								
								break;				
				case "start":
								if (singleWordCommand) {
									printError("\"start\" needs filename parameter (start <'file'> ['numberOfTicks']).");
								} else { 
									Macro.prevMacro = params[0];
									if(params.length > 1) {
										try {
											int sleepMillis = Integer.parseInt(params[1]) * 50;
											Thread.sleep(sleepMillis);
											Main.millis += sleepMillis;
											new Macro(params[0]);
										} catch (IllegalArgumentException e2) {
											printError("numberOfTicks parameter may only be a full, positive number.");
										} catch (InterruptedException e) {}
									} else {
										new Macro(params[0]);
									}
									
								}
								
								break;						
				case "stop":
								if (singleWordCommand) {
								Macro.closeMacros();						
								} else { Macro.currentMacros.removeIf((Macro macro) -> macro.getFile().equals(line.substring(line.indexOf(" ") + 1, line.length()))); }
								
								break;
				case "info":	
								if (!singleWordCommand) { printWarning("\"info\" has no parameters: (info)"); }
								printMessage("" + Main.versionName);
								printMessage("" + Main.versionDate);
								printMessage("Developed by Kideneb");
								System.out.println("");
								break;
				default:
								printError("Unknown command \"" + command + "\".");
								break;
			}
			
				
		}
		
	}
	
	static void printMessage(String m) {
		System.out.println("MESSAGE: " + m);
	}
	static void printWarning(String m) {
		System.out.println("WARNING: " + m);
	}
	
	static void printError(String m) {
		System.out.println("ERROR: " + m);
	}
	
}
