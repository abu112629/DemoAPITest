package com.sams.promotions.emulation.test.steps.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Scanner;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.json.JSONException;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.sams.promotions.platform.emulation.util.mapper.SmartObjectMapper;


public class UnitTestUtil {

	// https://stackoverflow.com/questions/2597271/easy-way-to-get-a-test-file-into-junit
	@Deprecated
	public static String loadResourceAsString(String filename) throws FileNotFoundException {
		File file = new File(filename);
		if (!file.exists())
			throw new FileNotFoundException(filename + " does not exist");
		Scanner scanner = new Scanner(file);
	    String contents = scanner.useDelimiter("\\A").next();
	    scanner.close();
	    return contents;
	}
	
	public static String loadClassPathResource(String classPath) throws FileNotFoundException, IOException {
		try {
			InputStream in = UnitTestUtil.class.getResourceAsStream(formJarAbsolutePath(classPath));
			Scanner scanner = new Scanner(in);
		    String contents = scanner.useDelimiter("\\A").next();
		    scanner.close();
		    return contents;
		} catch (Throwable t) {
			throw new FileNotFoundException("Cannot find classPath resource: "+fileClassPath(classPath));
		}
	}
	
	public static <T> T loadClassPathResource(String classPath, Class<T> type) throws FileNotFoundException, IOException {
	try {
		InputStream in = UnitTestUtil.class.getResourceAsStream(formJarAbsolutePath(classPath));
		return new SmartObjectMapper().deserialize(in, type);
	} catch (Throwable t) {
		throw new FileNotFoundException("Cannot find classPath resource: "+fileClassPath(classPath));
	}
	}
	
	private static String formJarAbsolutePath(String classPath) {
		return classPath.startsWith(File.separator) ? classPath : 
			File.separator + classPath;
	}
	
	private static String fileClassPath(String file) {
		return formJarAbsolutePath(file).substring(1);
	}
	
	public static void assertXML_Equivalence_Canonical(String expected, String actual, String message) {
		XMLUnit.setIgnoreWhitespace(true);
		try {
			if (message == null) {
				XMLAssert.assertXMLEqual(expected, actual);
			} else {
				XMLAssert.assertXMLEqual(message, expected, actual);
			}
		} catch (Exception e) {
			String errorMsg = message == null ? e.getMessage() :
				message + ": " + e.getMessage();
			Assert.fail(errorMsg);
		}
	}
	
	public static void assertXML_Equivalence_Canonical(String expected, String actual) {
		assertXML_Equivalence_Canonical(expected, actual, null);
	}
	
	public static void assertXML_Equivalence_RegEx(String expected, String actual, String message) {
		final String PATTERN = "\\s";
		if (message == null) {
			Assert.assertEquals(expected.replaceAll(PATTERN,""), actual.replaceAll(PATTERN,""));
		} else {
			Assert.assertEquals(message, expected.replaceAll(PATTERN,""), actual.replaceAll(PATTERN,""));
		}
	}
	
	public static void assertXML_Equivalence_RegEx(String expected, String actual) throws Exception {
		assertXML_Equivalence_RegEx(expected, actual, null);
	}
	
	public static void assertJSON_Equivalence(String expected, String actual, String message) {
		try {
			assertWillParseJsonStrictly(actual);
			assertWillParseJsonStrictly(expected);
			JSONAssert.assertEquals(message, 
					expected, actual, JSONCompareMode.LENIENT);
		} catch (JSONException e) {
			Assert.fail((message == null ? "" : message + "; ") + e.getMessage());
			
		} catch (ParseException e) {
			Assert.fail((message == null ? "" : message + "; ") + e.getMessage() + e.getErrorOffset());
		}
	}
	
	private static void assertWillParseJsonStrictly(String json) throws ParseException {
		final String msg = "Exception occured when Parsing JSON at Offset =  ";
		if (json == null)
			throw new ParseException(msg, -1);
		if (!json.startsWith("{"))
			throw new ParseException(msg, 0);
		if (!json.endsWith("}"))
			throw new ParseException(msg, json.length());
	}
}
