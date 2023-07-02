package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Search {

	public static void main(String[] args) {
	    DefaultTableModel model = new DefaultTableModel();
	    String searchKeyword = ""; // 원하는 검색 키워드를 입력하세요
	    new Search_GUI(searchKeyword, model);
	}

}

class Search_GUI extends JFrame implements ActionListener, KeyListener {
	

	JButton btn1;

	JLabel lbl1;
	JTable tbl2;
	DefaultTableModel searchModel;
	
	JTextArea area1;
	
	JScrollPane scroll1;
	JScrollPane scroll2;

	 Search_GUI(String searchKeyword, DefaultTableModel model) {

	        // Frame
	        super("검색된 글");
	        setBounds(100, 100, 900, 900);

	        // Panel
	        JPanel panel = new JPanel(); // 패널생성
	        panel.setLayout(null);

	        // Component
	        btn1 = new JButton("나가기");
	        lbl1 = new JLabel();
	        tbl2 = new JTable();

	        JTextField srch = new JTextField(searchKeyword);
	        searchModel = new DefaultTableModel(
	                new Object[]{"number", "글쓴이", "글제목", "작성날짜", "조회수"}, 0); // 컬럼 이름 설정

	        // Positioning
	        lbl1.setBounds(10, 10, 860, 80);     //제목
	        tbl2.setBounds(10, 100, 860, 680);    //작성 글 
	        
//	        글쓴이 or 글제목이 searchKeyword랑 같으면 내용을 가져온다
//	        equalsIgnoreCase는 대소문자를 무시한 상태로 일치 여부 확인
	        
	        lbl1.setText("'" + searchKeyword + "'" + "(으)로 검색된 결과입니다.");
	        for (int row = 0; row < model.getRowCount(); row++) {
	            String title = (String) model.getValueAt(row, 2);
	            String author = (String) model.getValueAt(row, 1);
	            if (title.equalsIgnoreCase(searchKeyword) || author.equalsIgnoreCase(searchKeyword)) {
	                Object[] rowData = {
	                    model.getValueAt(row, 0),
	                    author,
	                    title,
	                    model.getValueAt(row, 3)
	                };
	                searchModel.addRow(rowData);
	            }
	        }

	        btn1.setBounds(770, 800, 90, 30);        //나가기

	        // Event처리
	        btn1.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(null, "나가실?");
	                dispose(); // 현재 GUI 창 닫기
	                new Main_GUI(); // GUI1으로 돌아가기
	            }
	        });        //글작성

	        lbl1.addKeyListener(this);

	        btn1.setFont(new Font("굴림", Font.BOLD, 12));
	        lbl1.setFont(new Font("굴림", Font.BOLD, 30));

	        // Add_Panel_Component
	        panel.add(btn1);
	        panel.add(lbl1);

	        // 테이블 모델 설정
	        tbl2.setModel(searchModel);
	        scroll2 = new JScrollPane(tbl2);
	        scroll2.setBounds(10, 100, 860, 680);
	        panel.add(scroll2);
	        
//	        테이플 가로 넓이 조정
	        tbl2.getColumnModel().getColumn(0).setMaxWidth(50);
	        tbl2.getColumnModel().getColumn(1).setMaxWidth(200);
	        tbl2.getColumnModel().getColumn(2).setMaxWidth(1000);
	        tbl2.getColumnModel().getColumn(3).setMaxWidth(400);
	        tbl2.getColumnModel().getColumn(4).setMaxWidth(100);


	        // Frame
	        add(panel); // 프레임에 panel추가

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }
		


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}