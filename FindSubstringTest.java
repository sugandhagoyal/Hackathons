import static org.junit.Assert.*;

import org.junit.Test;

public class FindSubstringTest {

	@Test
	public void test() {
		int res =  FindAnagramPair.findPair("abba");
		assertTrue(res == 4);
	}

}
