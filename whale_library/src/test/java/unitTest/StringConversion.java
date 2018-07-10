package unitTest;

/**
 * StringConversion.java
 * - jUnit 테스트를 위한 스트링 변환 테스트
 * 
 * @version 1.0 / 2018. 7. 10.
 * @author miseong
 *
 */
public class StringConversion {

	/**
	 * getInteger - 숫자변환
	 *
	 * @param string
	 * @return Integer
	 * @author miseong
	 */
	 public Integer getInteger(final String string) {

		try {

			return Integer.parseInt(string);
			
		} catch (final Exception e) {
			return null;
		}

	}

}
