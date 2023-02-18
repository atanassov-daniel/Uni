
public class Multiply4 implements Program 
{
	public static String name="M4";	
	@Override
	public int calculate(int x, int y) throws NegativeNumbersException {
		if(!(x >= 0))
			throw new NegativeNumbersException(true,x);
		if(!(y >= -1))
			throw new NegativeNumbersException(false,y);
		int result=0;
		for(int i=0;i<Math.abs(x);++i) {
			result=result+Math.abs(y);
		}
		if(x<0 || y<0) {
			result=-result;
		}
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

}
