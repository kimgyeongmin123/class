package project;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public class DB extends MyWriter_GUI {

	public static void main(String[] args) {
//		new DB_GUI();
	}

}

class DB_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JLabel lbl1;
	JLabel tbl1;
	JLabel tbl2;
	JLabel tbl3;
	JTable tbl4;
	JLabel tbl5;
//	JTextArea comment; // 댓글
	JTextArea area1;
	JScrollPane scroll1;

	JTextArea comment = new JTextArea();
	
	DefaultTableModel commentmodel;	//DB에서 끌어온 댓글목록을 보여줄 공간 

//	댓글을 저장할 리스트
	List<String> commentList = new ArrayList<>();

	// DefaultTableModel 변수 추가
	DefaultTableModel model4;

	DB_GUI(int number, String writer, String title, String date) {

		// Frame
		super("클릭한 게시물");
		setBounds(100, 100, 900, 900);
		setResizable(false);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		btn1 = new JButton("나가기");
		lbl1 = new JLabel("게시물 조회");
		area1 = new JTextArea();
		JButton uploadBtn = new JButton("댓글 업로드");
		uploadBtn.setBounds(720, 700, 120, 50);
		area1.setBounds(10, 90, 210, 500);

		JTextField srch = new JTextField();

		// ---------------------------------------------------------------
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/게시판";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			comment = new JTextArea();
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success..");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected..");

			tbl1 = new JLabel("NO : " + number);
			tbl2 = new JLabel("글쓴이 :" + writer);
			tbl3 = new JLabel("글제목 : " + title);
			tbl5 = new JLabel("작성날짜 : " + date);
//			Component comment = new JTextArea(); // 댓글쓰는 창

			String[] column4 = { "글내용" };

			model4 = new DefaultTableModel(column4, 0);
			tbl4 = new JTable(model4);
			tbl4.setRowHeight(300);
//			테이블 수정 불가능
			tbl4.setEnabled(false);

			JScrollPane scroll4 = new JScrollPane(tbl4);

			scroll4.setBounds(10, 200, 850, 300);
			lbl1.setBounds(10, 30, 400, 50);
			tbl1.setBounds(10, 100, 100, 50);
			tbl2.setBounds(130, 100, 730, 50);
			tbl3.setBounds(10, 150, 850, 50);
			tbl5.setBounds(10, 750, 850, 50);
			comment.setBounds(8, 700, 700, 50);
			panel.add(tbl1);
			panel.add(tbl2);
			panel.add(tbl3);
			panel.add(tbl5);
			panel.add(comment); // 댓글쓰는창 추가
			panel.add(uploadBtn);

			// 글내용만 끌어오기
			pstmt = conn.prepareStatement("SELECT 글내용 FROM tbl_게시판 WHERE number = ?");
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String content = rs.getString("글내용");
				model4.addRow(new Object[] { content });
			}

//			tbl4.setModel(model4);
			scroll4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			panel.add(scroll4);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
				dispose();
			}
		});
		// 댓글 관련 코드------------------------------------------------------------------
		// 업로드 버튼을 눌렀을 때, 이벤트 처리
		uploadBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String id = "root";
					String pw = "1234";
					String url = "jdbc:mysql://localhost:3306/게시판";

					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("댓글Driver Loading Success..");

					conn = DriverManager.getConnection(url, id, pw);

					System.out.println("댓글 DB Connected..");
//					JTextArea comment = new JTextArea(); // 댓글
					String numberText = tbl1.getText().substring(4).trim(); // tbl1에서 가져온 숫자 부분을 공백을 제거하고 추출하여 설정
					String nameText = tbl2.getText().substring(5).trim(); // tbl2에서 가져온 글쓴이 부분을 공백을 제거하고 추출하여 설정

					pstmt = conn
							.prepareStatement("INSERT INTO tbl_댓글 (number, 댓글내용, 글쓴이, 작성날짜) VALUES (?, ?, ?, NOW())");
					pstmt.setInt(1, Integer.parseInt(numberText)); // 숫자로 변환하여 쿼리에 설정
					pstmt.setString(2, comment.getText());
					pstmt.setString(3, nameText); // 쿼리에 설정\

					int result = pstmt.executeUpdate();

					if (result > 0) {
						System.out.println("댓글이 성공적으로 저장되었습니다.");
						// 댓글 입력 필드 초기화
						comment.setText("");
					} else {
						System.out.println("댓글 저장에 실패했습니다.");
					}

					pstmt.close();
					conn.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 드라이버 적재

			}
		});

		//tbl_댓글 DB를 보여주기------------------------------------------------------
		


		
		
		//-------------------------------------------------------------------------
		
		area1.setEditable(false);

		btn1.setFont(new Font("굴림", Font.BOLD, 17));
		lbl1.setFont(new Font("굴림", Font.BOLD, 30));
		tbl1.setFont(new Font("굴림", Font.BOLD, 15));
		tbl2.setFont(new Font("굴림", Font.BOLD, 15));
		tbl3.setFont(new Font("굴림", Font.BOLD, 17));
		tbl4.setFont(new Font("굴림", Font.BOLD, 20));
		tbl5.setFont(new Font("굴림", Font.BOLD, 20));

		panel.add(btn1);
		panel.add(lbl1);
		panel.add(srch);

		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}