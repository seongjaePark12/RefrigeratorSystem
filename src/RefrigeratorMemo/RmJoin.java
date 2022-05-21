package RefrigeratorMemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.Pattern;

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
public class RmJoin extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JTextField textMid;
	private JTextField textPwd;
	private JTextField textHwName;
	private JTextField textAge;
	
	
	RmHwVO vo2 = new RmHwVO();
	RmDAO dao = new RmDAO();
	
	public RmJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(67, 10, 314, 49);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblmid = new JLabel("아이디");
		lblmid.setBounds(12, 91, 141, 49);
		lblmid.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblmid.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblmid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setBounds(12, 148, 141, 49);
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		contentPane.add(lblPwd);
		
		JLabel lblHwname = new JLabel("성명");
		lblHwname.setBounds(12, 205, 141, 49);
		lblHwname.setHorizontalAlignment(SwingConstants.CENTER);
		lblHwname.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		contentPane.add(lblHwname);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setBounds(12, 264, 141, 49);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		contentPane.add(lblAge);
		
		JButton btnJoin = new JButton("가입하기");
		btnJoin.setBounds(62, 334, 125, 55);
		btnJoin.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnJoin.setBackground(new Color(255, 182, 193));
		contentPane.add(btnJoin);
		
		JButton btnExit = new JButton("닫기");
		btnExit.setBounds(249, 334, 125, 55);
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnExit.setBackground(new Color(255, 182, 193));
		contentPane.add(btnExit);
		
		textMid = new JTextField(15);
		textMid.setBounds(177, 91, 198, 49);
		textMid.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		contentPane.add(textMid);
		textMid.setColumns(10);
		
		textPwd = new JPasswordField(15);
		textPwd.setColumns(10);
		textPwd.setBounds(177, 148, 198, 49);
		contentPane.add(textPwd);
		
		textHwName = new JTextField();
		textHwName.setColumns(10);
		textHwName.setBounds(177, 205, 198, 49);
		textHwName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		contentPane.add(textHwName);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(177, 264, 198, 49);
		textAge.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		contentPane.add(textAge);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
//-------------------------------------------------------------		

		// 회원가입 액션
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputJoin();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnJoin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputJoin();
			}
		});
		btnExit.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					dispose();
			}
		});
		textAge.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputJoin();
			}
		});
		textHwName.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputJoin();
			}
		});
		textMid.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputJoin();
			}
		});
		textPwd.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputJoin();
			}
		});
	}

	protected void inputJoin() {
		String mid = textMid.getText();
		String pwd = textPwd.getText();
		String Hwname = textHwName.getText();
		String age = textAge.getText();
		
		
		if(mid.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
			textMid.requestFocus();
		}
		else if(pwd.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			textPwd.requestFocus();
		}
		else if(Hwname.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "성명을 입력하세요");
			textHwName.requestFocus();
		}
		else if(age.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "나이을 입력하세요");
			textAge.requestFocus();
		}
		else {
			if (!Pattern.matches("^[0-9]*$", age)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
				//txtAge.setText("");
				textAge.requestFocus();
            }
			else{
				vo2.setMid(textMid.getText());
				vo2.setPwd(textPwd.getText());
				vo2.setHwName(textHwName.getText());
				vo2.setAge(Integer.parseInt(textAge.getText()));
				System.out.println(vo2);
	        
				dao.Join(vo2);
				dispose();
				JOptionPane.showMessageDialog(null, "회원 등록 완료");
				
				textMid.setText("");
				textPwd.setText("");
				textHwName.setText("");
				textAge.setText("");
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
