import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextCopy implements ActionListener {

	/**
	 * 
	 */
	JTextField firstEdit = new JTextField();
	JLabel firstLabel = new JLabel("Поле ввода");
	JPanel firstPanel = new JPanel(new BorderLayout());

	JTextField secondEdit = new JTextField();
	JLabel secondLabel = new JLabel("Поле вывода");
	JPanel secondPanel = new JPanel(new BorderLayout());

	JFrame frame = new JFrame("Окошко");

	JButton button = new JButton("Скопировать");

	public TextCopy() {

		firstPanel.add(firstEdit, BorderLayout.SOUTH);
		firstPanel.add(firstLabel, BorderLayout.NORTH);

		secondPanel.add(secondLabel, BorderLayout.NORTH);
		secondPanel.add(secondEdit, BorderLayout.SOUTH);

		frame.setSize(200, 100);
		frame.add(firstPanel, BorderLayout.WEST);
		frame.add(secondPanel, BorderLayout.EAST);

		button.addActionListener(this);
		frame.add(button, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		secondEdit.setText(firstEdit.getText());
		firstEdit.setText(null);
	}
}
