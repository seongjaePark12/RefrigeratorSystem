package RefrigeratorMemo;

import java.awt.Color;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings({ "serial", "unused" })
public class RmC extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textMemo;
	private JTextField textNum;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblImage = new JLabel("");
	
	
	RmVO vo = new RmVO();
	RmDAO dao = new RmDAO();


	public static void main(String[] args) {
		new RmC();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RmC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(new Color(245, 255, 250));
		pnTop.setForeground(Color.BLACK);
		pnTop.setBounds(0, 0, 656, 75);
		contentPane.add(pnTop);
		pnTop.setLayout(null);
		
		JLabel lblTop = new JLabel("냉장고를 부탁해");
		lblTop.setBackground(Color.LIGHT_GRAY);
		lblTop.setForeground(new Color(255, 127, 80));
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		lblTop.setFont(new Font("휴먼매직체", Font.BOLD, 50));
		lblTop.setBounds(128, 10, 380, 55);
		pnTop.add(lblTop);
		
		JButton btnNext = new JButton("냉장고안");
		btnNext.setBackground(new Color(255, 182, 193));
		btnNext.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		btnNext.setBounds(520, 10, 108, 41);
		pnTop.add(btnNext);
		
		JPanel pnRight = new JPanel();
		pnRight.setBackground(new Color(245, 255, 250));
		pnRight.setLayout(null);
		pnRight.setForeground(Color.BLACK);
		pnRight.setBounds(275, 74, 381, 434);
		contentPane.add(pnRight);
		
		JLabel lblName = new JLabel("이름");
		lblName.setForeground(Color.BLACK);
		lblName.setBackground(Color.CYAN);
		lblName.setBounds(12, 24, 128, 44);
		pnRight.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		
		JLabel lblPutdate = new JLabel("유통기한");
		lblPutdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPutdate.setForeground(Color.BLACK);
		lblPutdate.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lblPutdate.setBackground(Color.CYAN);
		lblPutdate.setBounds(12, 92, 128, 44);
		pnRight.add(lblPutdate);
		
		JLabel lblPosition = new JLabel("위치");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setForeground(Color.BLACK);
		lblPosition.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lblPosition.setBackground(Color.CYAN);
		lblPosition.setBounds(12, 160, 128, 44);
		pnRight.add(lblPosition);
		
		JLabel lblNum = new JLabel("개수");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setForeground(Color.BLACK);
		lblNum.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lblNum.setBackground(Color.CYAN);
		lblNum.setBounds(12, 228, 128, 44);
		pnRight.add(lblNum);
		
		JLabel lblKind = new JLabel("종류");
		lblKind.setHorizontalAlignment(SwingConstants.CENTER);
		lblKind.setForeground(Color.BLACK);
		lblKind.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lblKind.setBackground(Color.CYAN);
		lblKind.setBounds(12, 296, 128, 44);
		pnRight.add(lblKind);
		
		JLabel lblMemo = new JLabel("메모");
		lblMemo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemo.setForeground(Color.BLACK);
		lblMemo.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lblMemo.setBackground(Color.CYAN);
		lblMemo.setBounds(12, 364, 128, 44);
		pnRight.add(lblMemo);
		
		textName = new JTextField();
		textName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textName.setBounds(152, 24, 200, 44);
		pnRight.add(textName);
		textName.setColumns(10);
		
		textMemo = new JTextField();
		textMemo.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textMemo.setColumns(10);
		textMemo.setBounds(152, 364, 200, 44);
		pnRight.add(textMemo);
		
		JComboBox comboBoxYY = new JComboBox();
		comboBoxYY.setBackground(new Color(248, 248, 255));
		comboBoxYY.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		comboBoxYY.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBoxYY.setBounds(152, 92, 84, 34);
		pnRight.add(comboBoxYY);
		
		JComboBox comboBoxMM = new JComboBox();
		comboBoxMM.setBackground(new Color(248, 248, 255));
		comboBoxMM.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMM.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		comboBoxMM.setBounds(248, 92, 46, 34);
		pnRight.add(comboBoxMM);
		
		JComboBox comboBoxDD = new JComboBox();
		comboBoxDD.setBackground(new Color(248, 248, 255));
		comboBoxDD.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDD.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		comboBoxDD.setBounds(306, 92, 46, 34);
		pnRight.add(comboBoxDD);
		
		JRadioButton RadioPosition1 = new JRadioButton("냉장실");
		RadioPosition1.setBackground(new Color(245, 255, 250));
		RadioPosition1.setSelected(true);
		RadioPosition1.setForeground(new Color(0, 0, 0));
		buttonGroup.add(RadioPosition1);
		RadioPosition1.setHorizontalAlignment(SwingConstants.CENTER);
		RadioPosition1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		RadioPosition1.setBounds(152, 160, 95, 44);
		pnRight.add(RadioPosition1);
		
		JRadioButton RadioPosition2 = new JRadioButton("냉동실");
		RadioPosition2.setBackground(new Color(245, 255, 250));
		buttonGroup.add(RadioPosition2);
		RadioPosition2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		RadioPosition2.setBounds(257, 160, 95, 44);
		pnRight.add(RadioPosition2);
		
		
		textNum = new JTextField();
		textNum.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textNum.setColumns(10);
		textNum.setBounds(152, 228, 200, 44);
		pnRight.add(textNum);
		
		JComboBox comboBoxKind = new JComboBox();
		comboBoxKind.setBackground(new Color(248, 248, 255));
		comboBoxKind.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		comboBoxKind.setModel(new DefaultComboBoxModel(new String[] {"(선택)", "유제품", "육류", "해산물", "과일(채소)", "소스류", "주스", "인스턴트", "반찬", "기타"}));
		comboBoxKind.setBounds(152, 296, 200, 44);
		pnRight.add(comboBoxKind);
		
		JPanel pnEnd = new JPanel();
		pnEnd.setBackground(new Color(245, 255, 250));
		pnEnd.setLayout(null);
		pnEnd.setForeground(Color.BLACK);
		pnEnd.setBounds(275, 506, 381, 57);
		contentPane.add(pnEnd);
		
		JButton btnInput = new JButton("입력");
		btnInput.setBackground(new Color(255, 182, 193));
		btnInput.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		btnInput.setBounds(53, 10, 111, 37);
		pnEnd.add(btnInput);
		JButton btnClose = new JButton("닫기");
		btnClose.setBackground(new Color(255, 182, 193));
		btnClose.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		btnClose.setBounds(217, 10, 111, 37);
		pnEnd.add(btnClose);
		
		JPanel pnImage = new JPanel();
		pnImage.setBounds(0, 74, 276, 489);
		contentPane.add(pnImage);
		pnImage.setLayout(null);
		lblImage.setBackground(new Color(245, 255, 250));
		lblImage.setIcon(new ImageIcon("D:\\javaCourse\\Java\\works\\java06_psj\\images\\11.png"));
		lblImage.setBounds(0, 0, 276, 489);
		pnImage.add(lblImage);
		lblImage.setForeground(new Color(255, 255, 255));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
//-----------------------------------------------------------
		
		// 입력
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();;      // 이름
				String yy = comboBoxYY.getSelectedItem().toString();
				String mm = comboBoxMM.getSelectedItem().toString();
				String dd = comboBoxDD.getSelectedItem().toString();
				String ymd = yy+"-"+mm+"-"+dd;
			//	String position = RadioPosition1.gets;     // 위치
				String num = textNum.getText();     // 개수
				String kind = comboBoxKind.getSelectedItem().toString();     // 개수
				String memo = textMemo.getText();   // 메모
				
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
					textName.requestFocus();
				}
				else if(yy.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "년도를 선택하세요");
					//ymd.
				}
				else if(mm.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "월을 선택하세요");
				//	textNum.requestFocus();
				}
				else if(dd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "일을 선택하세요");
				//	textNum.requestFocus();
				}
				else if(num.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "개수를 입력하세요");
					textNum.requestFocus();
				}
				else if(kind.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "종류를 선택하세요");
				//	textNum.requestFocus();
					
				}
				else{
					String position;
					if(RadioPosition1.isSelected()) {
						position = RadioPosition1.getText();
					}
					else {
						position = RadioPosition2.getText();
					}
					
					vo.setName(name);
					vo.setPutdate(ymd);
					vo.setPosition(position);
					vo.setNum(Integer.parseInt(textNum.getText()));
					vo.setKind(kind);
					vo.setMemo(memo);
					
					dao.RmC(vo);
					JOptionPane.showMessageDialog(null, "음식 등록 완료");
					
					textName.setText("");
					textNum.setText("");
					textMemo.setText("");
					new RmGraph();
				}
			}
		});
		//닫기
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// 냉장고 안
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmGraph();
			}
		});
		
		btnInput.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				String name = textName.getText();;      // 이름
				String yy = comboBoxYY.getSelectedItem().toString();
				String mm = comboBoxMM.getSelectedItem().toString();
				String dd = comboBoxDD.getSelectedItem().toString();
				String ymd = yy+"-"+mm+"-"+dd;
			//	String position = RadioPosition1.gets;     // 위치
				String num = textNum.getText();     // 개수
				String kind = comboBoxKind.getSelectedItem().toString();     // 개수
				String memo = textMemo.getText();   // 메모
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					if(name.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력하세요");
						textName.requestFocus();
					}
					else if(yy.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "년도를 선택하세요");
						//ymd.
					}
					else if(mm.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "월을 선택하세요");
					//	textNum.requestFocus();
					}
					else if(dd.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "일을 선택하세요");
					//	textNum.requestFocus();
					}
					else if(num.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "개수를 입력하세요");
						textNum.requestFocus();					
					}
					else if(kind.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "종류를 선택하세요");
					//	textNum.requestFocus();
					}
					else{
						String position;
						if(RadioPosition1.isSelected()) {
							position = RadioPosition1.getText();
						}
						else {
							position = RadioPosition2.getText();
						}
						
						vo.setName(name);
						vo.setPutdate(ymd);
						vo.setPosition(position);
						vo.setNum(Integer.parseInt(textNum.getText()));
						vo.setKind(kind);
						vo.setMemo(memo);
						
						dao.RmC(vo);
						JOptionPane.showMessageDialog(null, "음식 등록 완료");
						
						textName.setText("");
						textNum.setText("");
						textMemo.setText("");
						new RmGraph();
					}
			}
		});
		btnClose.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					dispose();
			}
		});
		btnNext.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					new RmGraph();
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
