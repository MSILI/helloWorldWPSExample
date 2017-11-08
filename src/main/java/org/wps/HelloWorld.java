package org.wps;

import org.geoserver.wps.gs.GeoServerProcess;
import org.geoserver.wps.process.RawData;
import org.geotools.process.factory.DescribeParameter;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;
import org.geotools.process.factory.StaticMethodsProcessFactory;
import org.geotools.text.Text;
import org.wps.utils.DataUtils;

public class HelloWorld extends StaticMethodsProcessFactory<HelloWorld> implements GeoServerProcess {

	public HelloWorld() {
		super(Text.text("WPS hello world "), "testWPS", HelloWorld.class);
	}

	@DescribeProcess(title = "WPS HelloWorld", description = "WPS Hello World")
	@DescribeResult(name = "helloMessage", description = "the resulting hello message")
	public static String sayHello(
			@DescribeParameter(name = "name", description = "The name to use in the result") final String name) {

		return ("Hello " + name);

	}

	@DescribeProcess(title = "WPS multiplication", description = "WPS Multiplication")
	@DescribeResult(name = "helloMessage", description = "the resulting hello message")
	public static int mulitplication(
			@DescribeParameter(name = "number 1", description = "The first number") final int number1,
			@DescribeParameter(name = "number 2", description = "The second number") final int number2) {

		return number1 * number2;
	}
	
	@DescribeProcess(title = "WPS HelloWorld", description = "WPS Hello World")
	@DescribeResult(name = "helloJSONMessage", description = "the resulting hello message in JSON format")

	public static RawData sayHelloJSONReturn(
			@DescribeParameter(name = "name", description = "The name to use in the result", min = 1, max = 1, meta = {
					"mimeTypes=text/plain" }) final String name,
			@DescribeParameter(name = "outputMimeType", min = 0, max = 1) String outputMimeType) {
		if (outputMimeType == null) {
			outputMimeType = "application/json";
		}
		return DataUtils.display(name, outputMimeType);
	}
}
