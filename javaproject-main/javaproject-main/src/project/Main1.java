package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main1 {

	public static void main(String[] args) {
		new GUI();
	}

}

class GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	JScrollPane scroll2;

	GUI() {
		// Frame
		super("다 같이 게시판");
		setBounds(100, 100, 900, 900);


		// Panel
		JPanel panel = new JPanel(); // 패널생성
		
		panel.setLayout(null);


		// Component
		btn1 = new JButton("글 작성");
		btn2 = new JButton("내가 쓴글");
		btn3 = new JButton("다 같이 게시판");
		btn4 = new JButton("종료");
		btn5 = new JButton("검색");
		txt1 = new JTextField();
		txt2 = new JTextField();
		area1 = new JTextArea();
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);
		
		JTextField srch = new JTextField();

		// Positioning
		txt1.setBounds(10, 130, 860, 200);		//인기글
		txt2.setBounds(10, 340, 860, 450);		//메인글
		
		btn1.setBounds(680, 80, 90, 30);		//글작성
		btn2.setBounds(780, 80, 90, 30);		//내가 쓴 글
		btn3.setBounds(10, 10, 860, 60);		//제목
		btn4.setBounds(770, 800, 90, 30); 		// 나가기
		btn5.setBounds(160, 800, 60, 30); 		// 검색
		
		scroll1.setBounds(10, 130, 860, 200);	//인기글 스크롤
		scroll2.setBounds(10, 340, 860, 450);	//메인글 스크롤
		
		srch.setBounds(15,800,140,30);			//검색

		// Event처리
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GUI1();	
			}
		});		//글작성
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GUI2();
			}
		});
//		btn2.addActionListener(this);		//내가 쓴 글
		btn3.addActionListener(this);		//제목
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 	//종료
				JOptionPane.showMessageDialog(null, "프로그램 종료하실?");
				System.exit(0);
			}
		});		
		txt1.addKeyListener(this);
		area1.setEditable(false);
		
		btn1.setFont(new Font("굴림",Font.BOLD,12));
		btn2.setFont(new Font("굴림",Font.BOLD,12));		
		btn3.setFont(new Font("굴림",Font.BOLD,25));
		btn4.setFont(new Font("굴림",Font.BOLD,12));
		btn5.setFont(new Font("굴림",Font.BOLD,12));
		
		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		panel.add(txt1);
		panel.add(txt2);
//			panel.add(area1);
		panel.add(scroll1);
		panel.add(scroll2);
		
		panel.add(srch);

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