package RefrigeratorMemo;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings({ "serial", "unused" })
public class AllMain extends JFrame implements WindowListener{
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		new AllMain();
	}
	
	public AllMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 76, 660, 585);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(0, 137, 670, 463);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnExit = new JButton("시스템종료");
		btnExit.setBounds(258, 328, 152, 77);
		panel_1.add(btnExit);
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		btnExit.setBackground(new Color(255, 182, 193));
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		btnJoin.setBackground(new Color(255, 182, 193));
		btnJoin.setBounds(258, 193, 152, 77);
		panel_1.add(btnJoin);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		btnLogin.setBackground(new Color(255, 182, 193));
		btnLogin.setBounds(258, 58, 152, 77);
		panel_1.add(btnLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(0, 0, 670, 139);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("냉장고 서비스");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 68, 393, 61);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PSJ");
		lblNewLabel_1.setFont(new Font("Harrington", Font.PLAIN, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(519, 10, 128, 48);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PSJ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Harrington", Font.BOLD, 40));
		lblNewLabel_2.setBounds(298, 691, 142, 39);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		
		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmLogin();
			}
		});
		// 회원가입
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmJoin();
			}
		});
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if(exit==0) {
				System.exit(0);
				}
				else{
				}
			}
		});
		// 종료버튼을 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnExit.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
					if(exit==0) {
					System.exit(0);
					}
					else{
					}
				}else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
					if(exit==0) {
					System.exit(0);
					}
					else{
					}
				}
			}
		});
		// 회원가입을 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnJoin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					new RmJoin();
				}
				else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
					if(exit==0) {
					System.exit(0);
					}
					else{
					}
				}
			}
		});
		// 로그인을 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnLogin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					new RmLogin();
				}
				else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
					if(exit==0) {
					System.exit(0);
					}
					else{
					}
				}
			}
		});
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	// 윈도우창 닫기 알림
	@Override
	public void windowClosing(WindowEvent e) {
		int exit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
			if(exit==0) {
				System.exit(0);
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
