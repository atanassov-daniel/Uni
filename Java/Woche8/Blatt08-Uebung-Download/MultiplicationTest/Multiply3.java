
public class Multiply3 implements Program 
{
	public static String name="M3";
	@Override
	public int calculate(int x, int y) throws NegativeNumbersException {
		int result=0;
		for(int i=0;i<Math.abs(y);++i) {
			result=result+x;
		}
		return result;
	}
	@Override
	public String getName() {
		return name;
	}	
	
}
