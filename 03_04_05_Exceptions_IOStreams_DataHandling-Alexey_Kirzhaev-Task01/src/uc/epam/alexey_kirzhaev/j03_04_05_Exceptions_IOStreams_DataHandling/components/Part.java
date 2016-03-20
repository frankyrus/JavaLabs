package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components;

import java.util.ArrayList;

public class Part implements Component {
	private ArrayList<Component> partElements = new ArrayList<Component>();
	private CompElements attachment;

	@Override
	public void add(Component c) {
		partElements.add(c);
	}

	@Override
	public ArrayList<Component> getItems() {
		return this.partElements;
	}

	public Component getChild(int i) {
		return this.partElements.get(i);
	}

	public void setItems(ArrayList<Component> partElements) {
		this.partElements = partElements;
	}

	public CompElements getAttachment() {
		return attachment;
	}

	public void setAttachment(CompElements attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		boolean firstPart = true;
		StringBuilder sb = new StringBuilder();
		for (Component partElement : this.partElements) {
			if (partElement instanceof Part) {
				Part part = (Part) partElement;
				if (part.getAttachment().equals(CompElements.PARAGRAPH)) {
					if (!firstPart) {
						sb.append("\n");
					}
					firstPart = false;
				}
			}
			sb.append(partElement.toString());
		}
		return sb.toString();
	}
}
