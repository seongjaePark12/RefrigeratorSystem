package RefrigeratorMemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Game2 extends JFrame implements WindowListener{

	private JTextField answer;
	int lifeRemaining = 5;

	public static void main(String[] args) {
		new Game2();
	}

	public Game2() {
		initialize();
		setVisible(true);
	}

	private void initialize() {
		int randomNumber = (int)(Math.random()*30)+1;
		System.out.println(randomNumber);
		setBounds(100, 100, 670, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 656, 574);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel life = new JLabel(": 5");
		life.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		life.setBounds(110, 15, 193, 46);
		panel.add(life);
		
		JLabel lblPickANumber = new JLabel("1 - 30중 숫자를 선택해주세요");
		lblPickANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickANumber.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		lblPickANumber.setBounds(26, 169, 604, 46);
		panel.add(lblPickANumber);
		
		answer = new JTextField();
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("Tahoma", Font.PLAIN, 42));
		answer.setBounds(139, 269, 193, 63);
		panel.add(answer);
		answer.setColumns(10);
		
		JButton guess = new JButton("입력");
		guess.setBackground(new Color(221, 160, 221));
		
		guess.setFont(new Font("휴먼편지체", Font.PLAIN, 50));
		guess.setBounds(337, 269, 193, 63);
		panel.add(guess);
		
		JLabel res = new JLabel("행운을 빕니다");
		res.setForeground(Color.BLUE);
		res.setFont(new Font("휴먼편지체", Font.PLAIN, 42));
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setBounds(139, 398, 391, 57);
		panel.add(res);
		
		JLabel life_1 = new JLabel("");
		life_1.setIcon(new ImageIcon("D:\\javaCourse\\Java\\works\\java06_psj\\images\\하트.png"));
		life_1.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		life_1.setBounds(26, 15, 72, 46);
		panel.add(life_1);
		
		JLabel lblNewLabel = new JLabel("숫자 맞추기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 50));
		lblNewLabel.setBounds(148, 68, 339, 70);
		panel.add(lblNewLabel);
		
		JButton btnR = new JButton("다시하기");
		btnR.setBackground(new Color(221, 160, 221));
		btnR.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnR.setBounds(337, 474, 134, 62);
		panel.add(btnR);
		
		JButton btnC = new JButton("종료");
		btnC.setBackground(new Color(221, 160, 221));
		btnC.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		btnC.setBounds(487, 474, 123, 62);
		panel.add(btnC);
		
		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ans = Integer.parseInt(answer.getText());
				if(lifeRemaining <= 0) {
					res.setText("이런..실패");
					return;
				}
				if(ans == randomNumber){
					JOptionPane.showMessageDialog(null, "와우 정답입니다!");
				}
				life.setText("Life : " + --lifeRemaining);
				res.setForeground(Color.RED);
				if(ans > randomNumber){
					res.setText("더 낮은 숫자입니다");
				}else{
					res.setText("더 높은 숫자입니다");
				}
			}
		});
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game2();
				dispose();
			}
		});
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnR.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					new Game2();
					dispose();
			}
		});
		btnC.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
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
