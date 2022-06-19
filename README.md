# Calculator
### Create a calculator in java without tools that help create graphical interfaces, to improve with the java.swing library

<div align="center">
	<img src="https://i.imgur.com/raPIrCU.png">
</div>
---------------------------------------------------------------------------------------------------

The JVJFrame file is responsible for generating
the graphic part with the javax.swing library.

The "view" variable is the one in charge of the
function of the calculator screen, it is a JTextField,
in addition to being static and public.

The "symbol" variable is in charge of knowing what
type of mathematical operation should be performed

The Interface function is responsible for generalizing
the graphic aspect of the application, and executes
the Numbers function

The Numbers function is responsible for creating all
the buttons in the app in an orderly manner. 
This function needs the "CreateButtons" class to save
code when creating each button, this "CreateButtons"
class will return the buttons with the necessary properties
and the events that are requested and the Numbers function
will take care of adding the buttons.

The "CreateButtons" class, is in charge of creating 
the buttons and returning it, it will allow you one of these three formats:

	CreateButtons(String name, Integer x0, Integer y0, Integer x1, Integer y1);
	CreateButtons(String name, Integer x0, Integer y0, Integer xy1);
	CreateButtons(String name, Integer x0, Integer y0);

The "Calculate" function will take into account
everything that the view variable has, and that
the symbol variable has assigned, to perform
mathematical operations.

The "DELCharacter" function is found in the
CreateButtons class, it is in charge of returning
the string of the view variable (the calculator screen)
without the last character, it does the function of
the DEL button of the calculators.

The "Result" function is found in the CreateButtons class,
it is used for the equal button "=", and it is in charge of
writing the result of the mathematical operation on the
screen (variable view).

The "insertSimbols" function is found in the 
CreateButtons class,it is responsible for writing to the
screen (variable view) and saving the pressed symbol, it is
only used by buttons with mathematical symbols ("+", "-", "* " , "/")

The "insertNumbers" function is located in the
CreateButtons class, it is responsible for writing
the numbers pressed on the screen (variable view).

---------------------------------------------------------------------------------------------------
