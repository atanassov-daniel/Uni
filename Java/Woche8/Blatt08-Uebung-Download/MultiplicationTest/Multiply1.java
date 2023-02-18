
public class Multiply1 implements Program 
{
	public static String name="M1";
	@Override
	public int calculate(int x, int y) throws NegativeNumbersException {
		if(x < 0)
			throw new NegativeNumbersException(true,x);
		if(y < 0)
			throw new NegativeNumbersException(false,y);
		return x*y;
	}
	@Override
	public String getName() {
		return name;
	}

}
