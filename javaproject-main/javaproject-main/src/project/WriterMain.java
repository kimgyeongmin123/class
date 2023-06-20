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



public class WriterMain {

	public static void main(String[] args) {
		new GUI1();

	}

}

class GUI1 extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextArea area1;
	JScrollPane scroll1;


	GUI1() {
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
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt3 = new JTextField();
		area1 = new JTextArea();
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

		scroll1.setBounds(15, 125, 950, 570);

		// Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
		txt3.addKeyListener(this);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area1.append("내가 무엇을 적었을까");
				
			}
		});
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn1 클릭 시 저장
				JOptionPane.showMessageDialog(null, "저장하실?");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn2 클릭 시 수정
				JOptionPane.showMessageDialog(null, "수정하실?");
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//btn3 클릭 시 돌아가기
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                new GUI(); // GUI1으로 돌아가기
				
				

				
			}
		});

		
		btn1.setFont(new Font("굴림",Font.BOLD,12));
		btn2.setFont(new Font("굴림",Font.BOLD,12));		
		btn3.setFont(new Font("굴림",Font.BOLD,12));
		
		
		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(txt2);
		panel.add(txt3);
//				panel.add(area1);
		panel.add(scroll1);

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