package RefrigeratorMemo;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class RmGraph extends JFrame implements WindowListener{
	private JPanel contentPane;
	private JTextField textSearch;
	private JTable tblContent;
	@SuppressWarnings("rawtypes")
	private JComboBox comboSearch;

// 데이터베이스 연결을 위한 TableModel객체준비 : Vector 형식의 자료를 table로 표시한다
	// 테이블에 DB자료를 넣는 순서
	// 1. 헤드타이틀과 데이터를 준비한다 2. 준비된 데이터를 defaultTableModel에 넣는다
	// 3. defaultTableModel을 테이블에 넣는다 4. 테이블을 JScrollPane에 넣는다 5. JScrollPane을 프레임에 올린다
	private DefaultTableModel defaultTableModel;
	@SuppressWarnings("rawtypes")
	private Vector headings, vData;
	
	RmDAO dao = new RmDAO();
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		RmGraph frame = new RmGraph();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RmGraph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(new Color(245, 255, 250));
		pnTop.setBounds(0, 0, 656, 103);
		contentPane.add(pnTop);
		pnTop.setLayout(null);
		
		comboSearch = new JComboBox();
		comboSearch.setBackground(new Color(255, 182, 193));
		comboSearch.setModel(new DefaultComboBoxModel(new String[] {"이름", "위치", "종류"}));
		comboSearch.setBounds(18, 23, 110, 40);
		pnTop.add(comboSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(146, 23, 128, 40);
		pnTop.add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton("조건검색");
		btnSearch.setBackground(new Color(255, 182, 193));
		
		btnSearch.setBounds(292, 20, 88, 43);
		pnTop.add(btnSearch);
		
		JButton btnExit = new JButton("종료");
		btnExit.setBackground(new Color(255, 182, 193));
		
		
		btnExit.setBounds(517, 21, 101, 43);
		pnTop.add(btnExit);
		
		JButton btnSearchAll = new JButton("전체검색");
		btnSearchAll.setBackground(new Color(255, 182, 193));
		
		btnSearchAll.setBounds(398, 20, 101, 43);
		pnTop.add(btnSearchAll);
		
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBackground(new Color(255, 182, 193));
		btnDelete.setBounds(292, 73, 88, 23);
		pnTop.add(btnDelete);
		
		JButton btnDate = new JButton("유통기한확인");
		btnDate.setBackground(new Color(255, 182, 193));
		btnDate.setBounds(18, 73, 110, 23);
		pnTop.add(btnDate);
		
		JPanel pnContent = new JPanel();
		pnContent.setBackground(new Color(255, 182, 193));
		pnContent.setBounds(0, 102, 640, 411);
		contentPane.add(pnContent);
		pnContent.setLayout(null);
		

		
		// 헤드타이틀 준비(Vector형식으로)
		headings = new Vector();
		headings.add("번호");
		headings.add("이름");
		headings.add("유통기한");
		headings.add("위치");
		headings.add("개수");
		headings.add("종류");
		headings.add("메모");
		
		// 데이터 준비(Vector형식으로) - 전체자료검색
		vData = dao.getList();
		
		// 테이블 모델에 준비된 헤드타이틀과 데이터를 담는다.
		defaultTableModel = new DefaultTableModel(vData, headings); // (데이터자료, 헤드타이틀)
		
		// defaultTableModel을 테이블에 올린다
		tblContent = new JTable(defaultTableModel);
		tblContent.setBackground(new Color(248, 248, 255));
		
		// 테이블을 JScrollPane 올려준다
		JScrollPane sp = new JScrollPane(tblContent);
		// sp.setColumnHeaderView(tblContent);
		sp.setBounds(0, 0, 659, 453);
		
		// JScrollPane 프레임에 올려준다
		pnContent.add(sp);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 512, 656, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PSJ");
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Harrington", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 656, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(639, 93, 17, 420);
		contentPane.add(panel_1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		
		//---------------------------------------------------------
		
		// 조건
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputSearch();
			}
		});
		// 전체 검색
		btnSearchAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList();
				defaultTableModel.setDataVector(vData, headings);
			}
		});
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// 삭제
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RmDelete();
			}
		});
		// 유통기한 확인
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getDate();
				defaultTableModel.setDataVector(vData, headings);
				JOptionPane.showMessageDialog(null,"유통기한이 지났습니다 확인해주세요");
			}
		});
		// 조건
		btnSearch.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					inputSearch();
			}	
		});
		// 전체
		btnSearchAll.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					vData = dao.getList();
				defaultTableModel.setDataVector(vData, headings);
			}
		});
		// 닫기
		btnExit.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					dispose();
			}
		});
		// 삭제
		btnDelete.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					new RmDelete();
			}
		});
		// 유통기한
		btnDate.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				vData = dao.getDate();
				defaultTableModel.setDataVector(vData, headings);
				JOptionPane.showMessageDialog(null,"유통기한이 지났습니다 확인해주세요");
			}
		});
	}
	protected void inputSearch() {
		String comboStr = (String)comboSearch.getSelectedItem();
		String txtStr = textSearch.getText();
		
		if(txtStr.equals("")) {
			JOptionPane.showMessageDialog(null,"입력상자에 검색할 내용을 입력하세요");
			textSearch.requestFocus();
			return;
		}
		if(comboStr.equals("이름")) {
			vData = dao.getSearch("name",txtStr);
		}
		else if(comboStr.equals("위치")) {
			vData = dao.getSearch("position",txtStr);
		}
		else if(comboStr.equals("종류")) {
			vData = dao.getSearch("kind",txtStr);
		}
		defaultTableModel.setDataVector(vData, headings); 
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
