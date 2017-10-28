package ph.mramos.ocjsfd;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

import org.junit.Test;

public class PatternTest {

	@Test
	public void testChoiceFormat() {
//		ChoiceFormat choiceFormat = new ChoiceFormat("-1#is negative | 0#is zero | 1#is positive | 1<is more than one");
//		System.out.println(choiceFormat.format(-1));
//		System.out.println(choiceFormat.format(0));
//		System.out.println(choiceFormat.format(1));
//		System.out.println(choiceFormat.format(2));
		
		String pattern = "Your score {0,choice,-1#{0} is negative|0#{0} is zero|1#{0} is positive|1<{0} is more than one}";
		System.out.println(MessageFormat.format(pattern, -1));
		System.out.println(MessageFormat.format(pattern, 0));
		System.out.println(MessageFormat.format(pattern, 1));
		System.out.println(MessageFormat.format(pattern, 2));
		
	}
	
}
