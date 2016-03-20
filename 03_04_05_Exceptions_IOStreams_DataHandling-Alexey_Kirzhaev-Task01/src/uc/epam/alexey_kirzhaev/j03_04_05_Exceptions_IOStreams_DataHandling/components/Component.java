package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components;

import java.util.List;

public interface Component {
	void add(Component c);
	List<Component> getItems();
	String toString();
}