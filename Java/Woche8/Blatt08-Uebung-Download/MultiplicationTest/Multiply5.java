
public class Multiply5 implements Program
{
	public static String name="M5";
	@Override
	public int calculate(int x, int y) throws NegativeNumbersException {
		if(x < 0 && y < 0)
			throw new NegativeNumbersException(true,x);
		int result=0;
		for(int i=0;i<Math.abs(x);++i) {
			result=result+y;
		}
		if(x<0) {
			result=-result;
		}
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

}
