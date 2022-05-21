package RefrigeratorMemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class GameMain extends JFrame implements WindowListener{
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		new GameMain();
	}
	
	public GameMain() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		panel_1.setBounds(0, 496, 670, 104);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnExit = new JButton("뒤로가기");
		btnExit.setBounds(269, 10, 153, 77);
		panel_1.add(btnExit);
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		btnExit.setBackground(new Color(255, 182, 193));
		
		JButton btnGame1 = new JButton("New button");
		btnGame1.setIcon(new ImageIcon("D:\\javaCourse\\Java\\works\\java06_psj\\images\\가위바위보.png"));
		btnGame1.setBounds(0, 0, 350, 499);
		panel.add(btnGame1);
		
		JButton btnGame2 = new JButton("New button");
		btnGame2.setIcon(new ImageIcon("D:\\javaCourse\\Java\\works\\java06_psj\\images\\숫자.png"));
		btnGame2.setBounds(350, 0, 320, 499);
		panel.add(btnGame2);
		
		JLabel lblNewLabel_2 = new JLabel("PSJ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Harrington", Font.BOLD, 40));
		lblNewLabel_2.setBounds(298, 691, 142, 39);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// 게임1
		btnGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game();
			}
		});
		// 게임2
		btnGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Game2();
				
			}
		});
		// 종료버튼을 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnExit.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				dispose();
				}
			}
		});
		// 게임1 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnGame1.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					new Game();
				}
			}
		});
		// 게임2 키보드 엔터키를 눌렀을때 수행하는 메소드
		btnGame2.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					new Game2();
				}
			}
		});
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	// 윈도우창 닫기 알림
	@Override
	public void windowClosing(WindowEvent e) {
		int exit =0;
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
