package Interfaces;

public interface IStringInterface {

	String COLOR_STRING = "Färg";
	String COLOR_FILL_STRING = "Ifyllnadsfärg";
	String CIRCLE_STRING = "Cirkel";
	String LINE_STRING = "Linje";
	String RECT_STRING = "Rektangel";
	String CLOSE_MISC = "Stäng";
	/**
	 * Settings strings
	 * */
	String HEIGHT_STRING = "Höjd";
	String WIDTH_STRING = "Bredd";
	String LINE_WIDTH = "Linjebredd";
	String MENU_CHOICE_ALTERNATIVE = "Alternativ";
	String MENU_CHOICE_FILE = "Fil";
	/**
	 * Alternative alternatives
	 * */
	String MENU_OPEN = "Öppna";
	String MENU_NEW = "Ny fil";
	String MENU_CLOSE = "Stäng fil";
	String MENU_SAVE = "Spara";
	String MENU_EXIT_APP = "Avsluta";
	/**
	 * File alternatives
	 * */
	String MENU_REGRET = "Ångra";
	/**
	 * What happened in Controller -> Model ; telling view
	 * */
	String USER_SELECTED_COLOR = "userselectedcolorfromdialog";
	String USER_SELECTED_FILL_COLOR = "userselectedfillcolorfromdialog";
	String USER_EXIT_ASK_TO_SAVE = "userexitasktosave";
	String USER_CLOSES_FILE = "userclosesfilerenewui";
	String USER_CLOSES_FILE_ASK_TO_SAVE = "userclosesfileasktosave";
	String USER_OPENS_FILE = "useropensfileshowittothem";
	/**
	 * View inner class communication
	 * */
	String VIEW_USER_SELECTED_CIRCLE = "viewuserselectedcircle";
	String VIEW_USER_SELECTED_LINE = "viewuserselectedline";
	String VIEW_USER_SELECTED_RECT = "viewuserselectedrect";
	String VIEW_USER_CLOSE_MISC = "viewuserclosesmisc";
	String USER_PRESSES_SAVE_CHOICE = "userpressetosave";
	String USER_PRESSES_OPEN_CHOICE = "userpressesopenchoice";
	String NO_SAVE_OPEN_IMG = "nosaveopenimg";
	String USER_REGRETS_LAST_FIGURE = "userregretslastdrawnfigure";
	/**
	 * General messages to display
	* */
	String USER_CHOOSE_FIGURE_TO_DRAW = "Du måste välja en figur att rita";
	String EMPTY_OR_NOT_ACCURATE = " är fel. Fyll i korrekt.";
	String OVERRIDE_SAVE_FILE = "Spara över filen?";
}
