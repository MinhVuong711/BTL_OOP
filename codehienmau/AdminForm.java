package codehienmau;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminForm extends JFrame {
	private DefaultTableModel tableModel;
	private JTable userTable;
	private Stack<User> deletedUsersStack = new Stack<>();

	public AdminForm() {
		setTitle("Quản lý Admin");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Bảng JTable
		String[] columnNames = { "STT", "Tên", "Ngày sinh", "Nhóm máu", "Số điện thoại" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô trong bảng
			}
		};
		userTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(userTable);
		add(scrollPane, BorderLayout.CENTER);

		// Panel nút chức năng
		JPanel buttonPanel = new JPanel();

		JButton deleteButton = new JButton("Xóa");
		deleteButton.setFont(new Font("Arial", Font.BOLD, 30));
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		buttonPanel.add(deleteButton);

		JButton undoButton = new JButton("Hoàn Tác");
		undoButton.setFont(new Font("Arial", Font.BOLD, 30));
		undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undoDeleteUser();
			}
		});
		buttonPanel.add(undoButton);

		JButton logoutButton = new JButton("Đăng Xuất");
		logoutButton.setFont(new Font("Arial", Font.BOLD, 30));
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HelloForm();
			}
		});
		buttonPanel.add(logoutButton);

		add(buttonPanel, BorderLayout.SOUTH);

		updateUserList();

		setVisible(true);
	}

	private void deleteUser() {
		int selectedRow = userTable.getSelectedRow();
		if (selectedRow != -1) {
			User selectedUser = UserManager.getUsers().get(selectedRow);
			deletedUsersStack.push(selectedUser); // Lưu người dùng đã xóa vào stack
			UserManager.getUsers().remove(selectedUser);
			updateUserList();
			JOptionPane.showMessageDialog(this, "Xóa thông tin thành công!");
		}
	}

	private void undoDeleteUser() {
		if (!deletedUsersStack.isEmpty()) {
			User lastDeletedUser = deletedUsersStack.pop();
			UserManager.getUsers().add(lastDeletedUser);
			updateUserList();
			JOptionPane.showMessageDialog(this, "Khôi phục thông tin thành công!");
		} else {
			JOptionPane.showMessageDialog(this, "Không có lệnh xóa nào để khôi phục!");
		}
	}

	private void updateUserList() {
		tableModel.setRowCount(0);
		List<User> users = UserManager.getUsers();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			Object[] rowData = { i + 1, user.getName(), user.getDateOfBirth(), user.getBloodType(),
					user.getPhoneNumber() };
			tableModel.addRow(rowData);
		}
	}

	public static void main(String[] args) {
		new HelloForm();
	}
}
