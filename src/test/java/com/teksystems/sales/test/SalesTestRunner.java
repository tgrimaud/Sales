package com.teksystems.sales.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SalesTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SalesTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}

