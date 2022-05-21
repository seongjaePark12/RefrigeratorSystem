package RefrigeratorMemo;

import java.awt.Color;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class RmMain extends JFrame implements WindowListener{

	private JPanel contentPane;
	RmC rc;
	
	public static void main(String[] args) {
		new RmMain();
	}
	
	public RmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 656, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\javaCourse\\Java\\works\\java06_psj\\images\\음식.jpg"));
		lblNewLabel.setBounds(0, 0, 656, 491);
		panel.add(lblNewLabel);
		
		JButton btnIn = new JButton("입장하기");
		btnIn.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnIn.setBackground(new Color(245, 255, 250));
		btnIn.setBounds(0, 487, 332, 76);
		panel.add(btnIn);
		
		JButton btnExit = new JButton("뒤로가기");
		btnExit.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnExit.setBackground(new Color(245, 255, 250));
		btnExit.setBounds(328, 487, 328, 76);
		panel.add(btnExit);
		
		setVisible(true);
		// 윈도우 창 알림
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmC();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIn.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					new RmC();
				}
			}
		});
		btnExit.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				dispose();
				}
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
