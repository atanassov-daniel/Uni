public class TestManager 
{

	public static void main(String[] args) {
		Program[] programs= {new Multiply1(),new Multiply2(), new Multiply3(), new Multiply4(), new Multiply5()};
		Test t1=new PerformanceTest("Small numbers", 10, 9);
		Test t2=new PerformanceTest("Big numbers", 4324324, 3132);
		Test t3=new PerformanceTest("Incorrect Input", -5, -5);
		Test[] tests= {t1,t2,t3};
		runTests(programs,tests);
	}
	
	public static void runTests(Program[] ps, Test[] tests) {
		for(Program p:ps) {
			System.out.println("Run tests on program: "+ p.getName());
			for(Test t:tests) {
				System.out.print("\t");
				TestResult res= t.runTest(p);
				if() { //TODO Wenn ein Performance Test ausgefuehrt wird, dann soll pt t als PerformanceTest sein 
					int[] input=pt.getInput();
					System.out.println("Executed performance test: " + pt.getName() +" with inputs " + input[0]
							+" " +input[1]+ " and "+res.message());
				}else { // Funktionaler Test
					if() { //TODO wenn result angibt, dass ein Fehler vorliegt
						System.out.println(t.getName() + " failed with message: " + res.message());
					}else{
						System.out.println(t.getName() + ": OK");
					}

				}
				
			}
		}
		
	}
	
}


