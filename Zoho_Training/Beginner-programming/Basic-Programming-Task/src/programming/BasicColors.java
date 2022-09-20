package programming;

public class BasicColors {
	public enum Color {
	    
		VIOLET(1),
		INDIGO(2),
	    RED(3),
		GREEN(4),
		BLUE(5),
		YELLOW(6),
		BLACK(7);
	    private int colorCode;
	    private Color(int i) {
	        this.colorCode = i;
	    }
	    public static Color getElement(int code)
	    {
	    	Color[] color = Color.values();
	    	return color[code];
	    }
	    public static int getColorCode(Color COLOR)
	    {
	    	return COLOR.colorCode;
	    }
	}
}
