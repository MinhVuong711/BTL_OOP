package codehienmau;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HelloForm extends JFrame {

	public HelloForm() {
		setTitle("Chào mừng!");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 1));

		JLabel welcomeLabel = new JLabel("Babe đã có tài khoản chưa?", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Tăng_cỡ_chữ
		add(welcomeLabel);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		JButton haveAccountButton = new JButton("Đã có");
		haveAccountButton.setFont(new Font("Arial", Font.PLAIN, 32)); // Tăng_cỡ_chữ
		haveAccountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginForm();
			}
		});
		buttonPanel.add(haveAccountButton);

		JButton noAccountButton = new JButton("Chưa có");
		noAccountButton.setFont(new Font("Arial", Font.PLAIN, 32)); // Tăng_cỡ_chữ
		noAccountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisForm();
			}
		});
		buttonPanel.add(noAccountButton);

		add(buttonPanel);

		setVisible(true);
	}

	public static void main(String[] args) {
		new HelloForm();
	}
}
