package RefrigeratorMemo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class RmDelete extends JFrame implements WindowListener{
	private JPanel contentPane;
	private JTextField txtDelete;
	private JButton btnNo;
	private JButton btnD;
	
	RmDAO dao = new RmDAO();
	RmVO vo = new RmVO();
	
	public static void main(String[] args) {
		new RmDelete();
	}

	public RmDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제할 품목명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 45, 199, 60);
		contentPane.add(lblNewLabel);
		
		txtDelete = new JTextField();
		txtDelete.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		txtDelete.setBounds(265, 45, 253, 60);
		contentPane.add(txtDelete);
		txtDelete.setColumns(10);
		
		
		
		btnNo = new JButton("취소");
		btnNo.setBackground(new Color(255, 182, 193));
		btnNo.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnNo.setBounds(419, 115, 99, 38);
		contentPane.add(btnNo);
		
		btnD = new JButton("삭제");
		btnD.setBackground(new Color(255, 182, 193));
		btnD.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnD.setBounds(305, 115, 99, 38);
		contentPane.add(btnD);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtDelete.getText().toString();
				dao.delete(txtDelete.getText().toString());
				dispose();
			}
		});
		btnNo.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					dispose();
			}
		});
		btnD.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) 
					dao.delete(txtDelete.getText().toString());
					dispose();
			}
		});
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	// 윈도우창 닫기 알림
	@Override
	public void windowClosing(WindowEvent e) {
		int exit = 0;
			if(exit==0) {
				dispose();
			}
			else{
			}
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
