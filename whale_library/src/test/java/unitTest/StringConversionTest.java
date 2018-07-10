package unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * StringConversionTest.java
 * - 스트링변환 테스트
 * 
 * @version 1.0 / 2018. 7. 10.
 * @author miseong
 *
 */
public class StringConversionTest {

	@Test
	public void testGetInteger() {
		final StringConversion sc = new StringConversion();
		final String a = "a";
        assertEquals(null, sc.getInteger(a));
	}

}
