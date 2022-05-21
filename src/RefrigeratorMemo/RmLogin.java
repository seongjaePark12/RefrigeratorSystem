package RefrigeratorMemo;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class RmLogin extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JTextField textMid;
	private JTextField textPwd;
	
	RmHwVO vo2 = new RmHwVO();
	RmDAO dao = new RmDAO();
	
	public static void main(String[] args) {
		new RmLogin();
	}
	
	public RmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("로그인");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblLogin.setBounds(69, 24, 294, 60);
		contentPane.add(lblLogin);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblMid.setBounds(52, 104, 141, 51);
		contentPane.add(lblMid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblPwd.setBounds(52, 200, 141, 51);
		contentPane.add(lblPwd);
		
		textMid = new JTextField();
		textMid.setBounds(205, 104, 158, 51);
		textMid.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		contentPane.add(textMid);
		textMid.setColumns(10);
		
		textPwd = new JPasswordField();
		textPwd.setBounds(205, 200, 158, 51);
		textPwd.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		contentPane.add(textPwd);
		textPwd.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnLogin.setBackground(new Color(255, 182, 193));
		btnLogin.setBounds(52, 277, 131, 60);
		contentPane.add(btnLogin);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnJoin.setBackground(new Color(255, 182, 193));
		btnJoin.setBounds(232, 277, 131, 60);
		contentPane.add(btnJoin);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		
//---------------------------------------------------
		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputLogin();
			}
		});
		// 회원가입 이동
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmJoin();
				dispose();
			}
		});
		btnLogin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputLogin();
			}
		});
		btnJoin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					new RmJoin();
					dispose();
			}
		});
		textPwd.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputLogin();
			}
		});
		textMid.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputLogin();
			}
		});
	}

	protected void inputLogin() {
		String mid = textMid.getText();
		String pwd = textPwd.getText();
		
		if(mid.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
			textMid.requestFocus();
			return;
		}
		else if(pwd.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			textPwd.requestFocus();
			return;
		}
		else {
			int result = dao.Login(textMid.getText(), textPwd.getText());
			if (result == -2) {
				JOptionPane.showMessageDialog(null, "데이터베이스 오류", "DATABASE error", JOptionPane.WARNING_MESSAGE);
			}
			else if (result == -1) {
				JOptionPane.showMessageDialog(null, "등록되지 않은 아이디 입니다.", "ID error", JOptionPane.WARNING_MESSAGE);
			}
			else if (result == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 잘못 입력하셨습니다.", "password error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "로그인에 성공 하였습니다.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				textMid.setText("");
				textPwd.setText("");
				new Main();
				dispose();
			}
		}
		
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
