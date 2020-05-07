# MinecraftMacroTool
2020-05-07
Version 0.1.2

The tool is an external unofficial tool for the game Minecraft, which allows the implementation of movement macros.
Those macros can include movements which are humanly impossible.
Since this can be considered cheating, the author advises to use the tool only for testing purposes and never on multiplayer servers.


HOW TO START THE TOOL:

1. Download the tool from releases.
2. Configure Config.txt
3. Make sure the jar and Config file are in the directory.
4. Run the jar; A console should pop up with two numbers.
	If this does not work make sure, you have java installed correctly.
5. Now you can input commands. A list of commands can be found below.
   
   
   
HOW TO CREATE MACROS:
1. Start by choosing an editor. 
	You can simply choose any text editor but using either Microsoft Office's Excel or Open Office's Calc is HIGHLY encouraged.
2. Copy the default.txt file and open the copy in your editor:
	-Excel: Drag the file into Excel and keep the default settings for interpreting text files.
	-Open Offic Calc: Drag the file into Calc and change 'Seperated by' to Tab.
3. Don't change the first line in the spreadsheet. It shows you, which column is for what kind of input.
	Every line after the first one then represents one tick. 
	I: 	Macros written in the column "Files" will  be opened or closed.
		If you write hh_timing.txt into the third line for example (which is tick 2), it will register the macro and start executing it in tick 3.
		If you write a '-' in front of a macro, it will be closed, if it is currently executed (e.g. -jump_loop.txt).
	II:	In the columns "W", "A", "S", "D", "Sprint", "Sneak", "Jump", "LMB" and "RMB" you write integers.
		The integer represents the amount of ticks the keyboard key or mouse button will be held down, starting in this tick.
		If you write a "1", the key will only be pressed for a single tick. 
		For example, if you write "5" into the sneak column, line 5, the sneak key will be pressed during ticks 4-8.
	III:The column "Direction" accepts any number. The number represents the amount of rotation
		your character will undergo in the tick. e.g. "-15.6" will make you turn about 15.6° to the left.
		The actual rotation you undergo is just the closest possible value and will increase in accuracy with a lower ingame mouse sensitivity.
4. After the macro has been edited, it should be saved into the text file again.



HOTKEYS:
F9: Repeats the last macro you input into the console. When you change the macro before pressing F9,
    those changes will be instantly applied.
F10:Stops all currently running macros.
F12:Reloads all configs from the config file (Should be used after changing the mouse sensitivity and hotkeys).



CONSOLE COMMANDS:
Syntax information: 
	Guillemets(<>) indicate neccessary parameters. 
	Square brackets([]) indicate optional parameters
	The vertical bar(|) indicates that one of multiple parameters can be used.
	Single quotation marks('') indicate, that the parameter in the syntax is not meant literally.
    
Commands:
	help [commands | 'command']                                       
		"help" gives basic information about the usage of the Macro Parkour Tool.
		"help commands" lists all commands and their syntax.              
		"help 'command'" gives a detailed description of the command.      
		Examples: "help", "help commands", "help start"
	info                                                             
		"info" shows information about the tool's version, author and release date.	
	list                                                     
		"list" lists all macros that are currently being read and executed.
	start <'file'> ['numberOfTicks']                                              
		"start 'file'" begins executing the macro file.                                      
		"start 'file' 'numberOfTicks'" opens the macro file after the specified amount of ticks.
		The file needs to be in the same directory as the Macro Parkour Tool.                    
		You also have to specify the file type with the corresponding filename extension.      
		Examples: "start hard_jump.txt", "start double_triple_neo.txt 40"
	stop ['file']                                   
		"stop" stops all running macros and simulated keypresses.
		"stop 'file'" stops interpreting the file.            
		 Examples: "stop", "stop quad_neo"


		 
FAQ:
Q:What is the tool for?
A:With the tool, players are on the one hand supposed to push the boundaries of parkour in Minecraft.
  It doesn't matter, if this means doing very hard jumps or creating a TAS, 
  even though the latter may become a tideous task.
  On the other hand you might learn how to do jumps more easily by actually creating a macro that does the jump.
  The tool might also help, find new techniques, if there are any.
Q:Why does a macro work for me, but not for someone else.
A:If that is the case, make sure you use the same ingame mouse sensitivity.
Q:Why is my macro incosistent?
A: The cause for incosistencies is often lag. If Minecraft has to skip a tick or the tool takes longer 
   than a minecraft tick to compute it's own tick, the run is basically ruined. If that happens make sure 
   you reduce settings in Minecraft and close background programs. Also check the Task Manager to make sure
   you have no other instances of the tool running.
Q: What features are planned in the future?
A: The next goal is to implement LWJGL (a library, Minecraft uses as well) to make sure every Minecraft
   key can be simulated in the future. It is planned to turn the tool into an internal mod, in order to fix
   some major issues and implement features like seeing effects of changes in your macros in game or
   skipping between ticks so you dont have to run macros from the start each time.