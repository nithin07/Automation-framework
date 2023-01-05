package api.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtlis {

	public String empName()	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return "John "+generatedString;
	}
}
