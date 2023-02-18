class PerformanceTest extends Test //add modifier
{
	int x; //add modifier
	int y; //add modifier
	
	public int[] getInput() {
		return new int[]{x,y};
	}
	
	public PerformanceTest(String category, int inx,int iny) {
		super(category);
		x=inx;
		y=iny;
	}

	@Override
	public TestResult runTest(Program p) {
		long startTime = System.nanoTime();   
		try {
			p.calculate(x, y);
		} catch (NegativeNumbersException e) {
			
		}
		long estimatedTime = System.nanoTime() - startTime;
		String msg= "Time elapsed: " + estimatedTime;
		TestResult t = new TestResult(false,msg);	
		return t;
	}

}
