package client;

import javax.xml.bind.annotation.XmlElement;

import client.JaxbValidator.ValidationException;

public class JaxbValidatorTest {

	static class Llama {
		@XmlElement(required = false)
		private final String no;

		@XmlElement(required = true)
		private final String yes;

		public Llama(String no, String yes) {
			super();
			this.no = no;
			this.yes = yes;
		}
	}

	public static void main(String args[]) {
		try {
			Llama o = new Llama("a", "b");
			// THE MAIN EVENT - see if 'required' is honored
			boolean validateRequired = JaxbValidator.validateRequired(o, Llama.class);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		try {
			Llama o = new Llama(null, null);
			// Again - see if 'required' is honored
			boolean validateRequired = JaxbValidator.validateRequired(o, Llama.class);
			assert false : "Should have thrown validation exception for 'yes'";
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
}