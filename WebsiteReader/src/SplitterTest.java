import static org.junit.Assert.*;

import org.junit.Test;


public class SplitterTest {

	@Test
	public void test() {
		String x = "<b>This</b> is a class";
		assertEquals("verify that it can remove a <>", "This", Splitter.split(x).get(0));
	}

}
