/**
 * 
 */
package com.gtkv1qa.RetryListnerClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.gtkv1qa.util.RetryFailedTestCases;


/**
 * @author mahenderd
 *
 */
public class RetryListenerClass implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();
 
		if (retry == null)	{
			testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}
 
	}
}

