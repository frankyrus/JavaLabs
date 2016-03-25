import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextCopy extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1603368713754859920L;

	JTextField firstEdit = new JTextField();
	JLabel firstLabel = new JLabel("Поле ввода");
	JPanel firstPanel = new JPanel(new BorderLayout());

	JTextField secondEdit = new JTextField();
	JLabel secondLabel = new JLabel("Поле вывода");
	JPanel secondPanel = new JPanel(new BorderLayout());

	JButton button = new JButton("Скопировать");

	public TextCopy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		firstPanel.add(firstEdit, BorderLayout.SOUTH);
		firstPanel.add(firstLabel, BorderLayout.NORTH);

		secondPanel.add(secondLabel, BorderLayout.NORTH);
		secondPanel.add(secondEdit, BorderLayout.SOUTH);

		setSize(200, 100);
		add(firstPanel, BorderLayout.WEST);
		add(secondPanel, BorderLayout.EAST);

		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);

		setTitle("Окошко");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		secondEdit.setText(firstEdit.getText());
		firstEdit.setText(null);
	}
}
