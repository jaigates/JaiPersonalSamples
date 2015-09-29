package client;

import java.lang.reflect.Field;

import javax.xml.bind.annotation.XmlElement;

/**
 * oh so minimal consideration of JAXB annotation
 */
public class JaxbValidator {

	public static class ValidationException extends Exception {
		public ValidationException(String message, Throwable cause) {
			super(message, cause);
		}

		public ValidationException(String message) {
			super(message);
		}
	}

	/**
	 * Enforce 'required' attibute.
	 * 
	 * Requires either no security manager is used or the default security
	 * manager is employed.
	 * 
	 * @see {@link Field#setAccessible(boolean)}.
	 */
	public static <T> boolean validateRequired(T target, Class<T> targetClass) throws ValidationException {
		StringBuilder errors = new StringBuilder();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			XmlElement annotation = field.getAnnotation(XmlElement.class);
			if (annotation != null && annotation.required()) {
				try {
					field.setAccessible(true);
					if (field.get(target) == null) {
						if (errors.length() != 0) {
							errors.append(" ");
						}
						String message = String.format("%s: required field '%s' is null.", targetClass.getSimpleName(),
								field.getName());
						errors.append(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (errors.length() != 0) {
				throw new ValidationException(errors.toString());
			}
		}
		return true;
	}
	
}