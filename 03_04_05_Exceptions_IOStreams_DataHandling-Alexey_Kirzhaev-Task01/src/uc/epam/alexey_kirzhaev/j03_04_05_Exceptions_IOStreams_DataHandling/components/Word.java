package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components;

import java.util.List;

public class Word implements Component {
	private String data;
	private boolean punctBool = false;

	public Word(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isPunctBool() {
		return punctBool;
	}

	public void setPunctBool(boolean punctBool) {
		this.punctBool = punctBool;
	}

	@Override
	public void add(Component c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Component> getItems() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.punctBool) {
			sb.append(this.data).append(" ");
		} else {
			sb.append(this.data).append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (null == o) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Word word = (Word) o;
		if ((this.data.equals(word.getData()) == false) || (this.punctBool != word.isPunctBool())) {
			return false;
		}
		return true;
	}
}
