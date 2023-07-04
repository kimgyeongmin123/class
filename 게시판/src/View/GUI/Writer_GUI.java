package View.GUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dto.BoardDto;

//	id는 JLabel을 사용하여 불러오게끔....

public class Writer_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1; // 저장
	JButton btn2; // 나가기
	JTextField txt1; // title
	JTextField txt2; // contents
	JTextArea area1;
	JScrollPane scroll1;

	Writer_GUI() {
//		Frame
		super("글쓰기");
		setBounds(100, 100, 1000, 800);

//		Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

// 		Component
		btn1 = new JButton("저장");
		btn2 = new JButton("나가기");
		txt1 = new JTextField("제목");
		txt2 = new JTextField("내용");
		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);

// 		Positioning
		txt1.setBounds(40, 70, 700, 40);
		txt2.setBounds(40, 125, 950, 570);

		btn1.setBounds(770, 10, 90, 30); // 저장
		btn2.setBounds(870, 700, 90, 30); // 나가기

		scroll1.setBounds(40, 125, 950, 570);

// 		Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
//		txt1.setBounds(40, 15, 300, 40); // 아이디 넣을 위치

		txt1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt2.getText().equals("title")) {
					txt2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt2.getText().isEmpty()) {
					txt2.setText("title");
				}
			}
		});
		txt2.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt2.getText().equals("contents")) {
					txt2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt2.getText().isEmpty()) {
					txt2.setText("contents");
				}
			}
		});

		// 보드 DAO 인스턴스 생성
		BoardDao boardDao = BoardDao.getInstance();

		// 저장버튼 눌렀을 때 이벤트 처리
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "저장하실?");

//				List<BoardDto> boardList = null;
//				boardList = boardDao.insert();
//				
//				new MAINGUI();
//				dispose();

				// 사용자가 입력한 제목과 내용을 가져옴
				String title = txt1.getText();
				String contents = txt2.getText();

				// BoardDto 객체를 생성하여 입력할 데이터 설정
				BoardDto boardDto = new BoardDto();
				boardDto.setTitle(title);
				boardDto.setContents(contents);

				try {
					// DAO를 사용하여 데이터 저장
					int result = boardDao.insert(boardDto, "role"); // role에는 적절한 값을 전달해야 합니다.

					if (result > 0) {
						// 저장 완료 메시지 표시
						JOptionPane.showMessageDialog(null, "글이 저장되었습니다.");

						// 저장 후에는 원하는 동작을 수행하도록 구현

						// 현재 GUI 창 닫기
						dispose();

						// 다른 GUI 창 열기
						new MAINGUI();
					} else {
						// 저장 실패 메시지 표시
						JOptionPane.showMessageDialog(null, "글 저장에 실패했습니다.");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					// 예외 처리 작업
				}
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
				dispose(); // 현재 GUI 창 닫기

				new MAINGUI(); // GUI1으로 돌아가기
			}
		});

//		글씨체
		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		btn2.setFont(new Font("굴림", Font.BOLD, 12));

//		tap키 순서 지정
		List<Component> tabOrder = new ArrayList<>(); // tap키 순서 지정
		tabOrder.add(txt1);
		tabOrder.add(txt2);
		tabOrder.add(btn1);
		tabOrder.add(btn2);

//		add_panel_component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
		panel.add(scroll1);

//		Frame
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