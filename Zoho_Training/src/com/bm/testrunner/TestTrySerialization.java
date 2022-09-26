/**
 * 
 */
package com.bm.testrunner;

/**
 * @author Balamurugan
 *
 */
import com.bm.framework.serialization.*;
public class TestTrySerialization
{
	public static void main(String[] args)
	{
		TrySerialization trySerial = new TrySerialization();
		trySerial.addDummyValues();
//		trySerial.displayValue();
//		trySerial.serializeObject();
		trySerial.deSerializeObject();
	}
}
