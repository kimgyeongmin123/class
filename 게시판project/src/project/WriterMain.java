package project;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class WriterMain {

	public static void main(String[] args) {
		new WriterMain_GUI();

	}

}

class WriterMain_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextArea area1;
	JScrollPane scroll1;
	
//	JLabel lbl1;
//	JLabel lbl2;
//	JLabel lbl3;
	
	
//	연결정보 저장용 변수
	String id="root";
	String pw="1234";
	String url="jdbc:mysql://localhost:3306/게시판";
	
//	JDBC참조변수
	Connection conn = null;				//DB연결용 참조변수
	PreparedStatement pstmt = null;		//SQL쿼리 전송용 참조변수
	ResultSet rs = null;				//SQL쿼리 결과(SELECT결과)수신용 참조변수


	WriterMain_GUI() {
		// Frame
		super("글쓰기");
		setBounds(100, 100, 1000, 800);

		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);


		// Component
		btn1 = new JButton("저장");
		btn2 = new JButton("수정");
		btn3 = new JButton("나가기");
		txt1 = new JTextField("이름");
		txt2 = new JTextField("제목");
		txt3 = new JTextField("내용");
		area1 = new JTextArea();
		
//		lbl1 = new JLabel("닉네임 : ");
//		lbl2 = new JLabel("제목 : ");
//		lbl3 = new JLabel("내용 : ");
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);

		// Positioning
		txt1.setBounds(15, 15, 300, 40); // 전
//		txt1.setBounds(730, 70, 235, 40); // 후
		txt2.setBounds(15, 70, 700, 40);
		txt3.setBounds(15, 125, 950, 570);

		btn1.setBounds(770, 10, 90, 30); // 저장
		btn2.setBounds(870, 10, 90, 30); // 수정
		btn3.setBounds(870, 700, 90, 30); // 나가기
		
//		lbl1.setBounds(getBounds());
//		lbl2.setBounds(getBounds());
//		lbl3.setBounds(getBounds());

		scroll1.setBounds(15, 125, 950, 570);

		// Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
		txt3.addKeyListener(this);
		
		txt1.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txt1.getText().equals("이름")) {
		            txt1.setText("");
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txt1.getText().isEmpty()) {
		            txt1.setText("이름");
		        }
		    }
		});
		txt2.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txt2.getText().equals("제목")) {
		            txt2.setText("");
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txt2.getText().isEmpty()) {
		            txt2.setText("제목");
		        }
		    }
		});
		txt3.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txt3.getText().equals("내용")) {
		            txt3.setText("");
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txt3.getText().isEmpty()) {
		            txt3.setText("내용");
		        }
		    }
		});

		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "저장하실?");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	//드라이버 적재
					System.out.println("Driver Loading Success..");
					conn = DriverManager.getConnection(url,id,pw);
					System.out.println("DB Connected..");
					pstmt = conn.prepareStatement("insert into tbl_게시판 values(null,?,?,?,now(),null)");
					pstmt.setString(1, txt1.getText());
					pstmt.setString(2, txt2.getText());
					pstmt.setString(3, txt3.getText());
					int result = pstmt.executeUpdate();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					try {pstmt.close();}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				new Main_GUI();
				dispose();
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn2 클릭 시 수정
				JOptionPane.showMessageDialog(null, "수정하실?");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 적재
					System.out.println("Driver Loading Success..");
					conn = DriverManager.getConnection(url, id, pw);
					System.out.println("DB Connected..");
					// 기존 데이터 조회
		            pstmt = conn.prepareStatement("SELECT * FROM tbl_게시판 WHERE 글제목=? AND 글쓴이=?");
		            pstmt.setString(1, txt2.getText());
		            pstmt.setString(2, txt1.getText());
		            rs = pstmt.executeQuery();
		            
		            if (rs.next()) {
		                // 글 제목과 글쓴이가 일치하는 데이터가 존재하는 경우
		                int postId = rs.getInt("number");
		                
		                // 내용 업데이트
		                pstmt = conn.prepareStatement("UPDATE tbl_게시판 SET 글내용=?, 작성날짜=now() WHERE number=?");
		                pstmt.setString(1, txt3.getText());
		                pstmt.setInt(2, postId);
		                
		                int result = pstmt.executeUpdate();
		                
		                if (result > 0) {
		                    JOptionPane.showMessageDialog(null, "수정되었습니다.", "DBCONN", JOptionPane.INFORMATION_MESSAGE);
//		                    setVisible(false); // 프레임 창 닫기
		                } else {
		                    JOptionPane.showMessageDialog(null, "수정 실패", "DBCONN", JOptionPane.ERROR_MESSAGE);
		                    setVisible(false); // 프레임 창 닫기
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "일치하는 데이터가 없습니다.", "DBCONN", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) rs.close();
		                if (pstmt != null) pstmt.close();
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
		            new Main_GUI();
		            dispose();
		        }
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn3 클릭 시 돌아가기
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                
                new Main_GUI(); // GUI1으로 돌아가기
				
				

				
			}
		});
	    List<Component> tabOrder = new ArrayList<>();  //tap키 순서 지정
	    tabOrder.add(txt1);
	    tabOrder.add(txt2);
	    tabOrder.add(txt3);
	    tabOrder.add(btn1);
	    tabOrder.add(btn2);
	    tabOrder.add(btn3);

	    setFocusTraversalPolicy(new FocusTraversalPolicy() {
	        @Override
	        public Component getComponentAfter(Container container, Component component) {
	            int index = tabOrder.indexOf(component);
	            return tabOrder.get((index + 1) % tabOrder.size());
	        }

	        @Override
	        public Component getComponentBefore(Container container, Component component) {
	            int index = tabOrder.indexOf(component);
	            return tabOrder.get((index - 1 + tabOrder.size()) % tabOrder.size());
	        }

	        @Override
	        public Component getFirstComponent(Container container) {
	            return tabOrder.get(0);
	        }

	        @Override
	        public Component getLastComponent(Container container) {
	            return tabOrder.get(tabOrder.size() - 1);
	        }

	        @Override
	        public Component getDefaultComponent(Container container) {
	            return tabOrder.get(0);
	        }
	    });
		
		btn1.setFont(new Font("굴림",Font.BOLD,12));
		btn2.setFont(new Font("굴림",Font.BOLD,12));		
		btn3.setFont(new Font("굴림",Font.BOLD,12));
		
		
// 		Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(txt2);
		panel.add(txt3);
//				panel.add(area1);
		panel.add(scroll1);
		
//		panel.add(lbl1);
//		panel.add(lbl2);
//		panel.add(lbl3);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {}


	@Override
	public void keyPressed(KeyEvent e) {}


	@Override
	public void keyReleased(KeyEvent e) {}


	@Override
	public void actionPerformed(ActionEvent e) {}

}