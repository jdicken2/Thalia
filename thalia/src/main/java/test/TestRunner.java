package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//import org.junit.runner.notification.Su

public class TestRunner
{
	public static void main(String [] args)
	{
		Result result=JUnitCore.runClasses(Unittests.class);
		for (Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
			System.out.println("All tests were successful");
			System.out.println("The number of tests ran:" + " " + result.getRunCount());
			System.out.println("The amount of time taken for all tests ran:" + " " + result.getRunTime() + " " +"ms");
			//System.out.println("Here is the unit test coverage:");
			//System.out.println(;
			


	}
}
