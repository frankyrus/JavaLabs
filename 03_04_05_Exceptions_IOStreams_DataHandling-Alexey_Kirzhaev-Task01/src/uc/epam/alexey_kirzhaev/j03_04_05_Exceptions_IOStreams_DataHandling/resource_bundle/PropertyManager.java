package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.resource_bundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class PropertyManager {
	private ResourceBundle bundle;

	public String getValue(String key) {
		return bundle.getString(key);
	}
	
	public PropertyManager() {
		Locale locale = new Locale("ru", "RU");
		try {
			bundle = ResourceBundle.getBundle("property.prop",locale);
		}
		catch (MissingResourceException e) {
			System.out.println("x + " + e);
			e.getStackTrace();
		}
	}
}
