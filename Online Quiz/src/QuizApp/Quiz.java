package QuizApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Quiz implements ActionListener {
	JButton admin,user,login,category,ques,add,view,submit,add1,view1,submit1,login1,register,submit3,start,skip,start1,cancel1,next,cancel,result;
	JButton back,back1,back2,back3,back4,back5,back6,back7,back8,back9,back10,back11,back12;
	JFrame f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t20,t21,t22;
	JTextField t17,t18,t19;
	Choice ch, ch1;
	JRadioButton r1,r2,r3,r4;
	String coloumnNames[]= {"id","subjects"};
	String coloumnNames1[]= {"id","subjects","question","option_1","option_2","option_3","option_4","answer"};
	JTable jt,jt1,t;
	JLabel q,id,subject,sub;
	String ans;
	int current = 1;
	int marks=0;

	// Admin Code

	Quiz() {
		f1 = new JFrame("Online Quiz");
		f1.setBounds(190,80, 1200, 510);
		f1.setVisible(true);
		f1.getContentPane().setBackground(Color.WHITE);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("QuizApp/Images/login.jpeg"));
		JLabel l1=new JLabel(image);
		l1.setBounds(0, -60, 600, 600);
		f1.add(l1);

		JLabel onlinequiz=new JLabel("Online Quiz");
		onlinequiz.setFont(new Font("Monotype Corsiva",Font.PLAIN , 55));
		onlinequiz.setForeground(new Color(66,94,193));
		onlinequiz.setBounds(780, 50, 300, 60);
		f1.add(onlinequiz);

		JLabel mind=new JLabel("Check your Mind.");
		mind.setFont(new Font("Arial",Font.PLAIN , 16));
		mind.setForeground(Color.BLACK);
		mind.setBounds(790, 92, 150, 30);
		f1.add(mind);

		admin=new JButton("Admin");
		admin.setFont(new Font("Arial",Font.BOLD , 15));
		admin.setBackground(new Color(66,94,193));
		admin.setForeground(Color.WHITE);
		admin.setBounds(810, 180, 200, 30);
		admin.addActionListener(this);
		f1.add(admin);

		user=new JButton("User");
		user.setFont(new Font("Arial",Font.BOLD , 15));
		user.setBackground(new Color(66,94,193));
		user.setForeground(Color.WHITE);
		user.setBounds(810, 230, 200, 30);
		user.addActionListener(this);
		f1.add(user);

		JLabel note=new JLabel("Note-This App only Students Purpose");
		note.setBounds(810, 420, 300, 30);
		note.setForeground(new Color(66,94,193));
		note.setFont(new Font("Arial",Font.PLAIN , 12));
		f1.add(note);

	}

	public static void main(String[] args) {
		Quiz q=new Quiz();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==admin) {
			f1.dispose();
			f2=new JFrame("Admin");
			f2.setBounds(500, 80, 500, 500);
			f2.setVisible(true);
			f2.getContentPane().setBackground(Color.WHITE);
			f2.setLayout(null);
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel admin=new JLabel("Welcome");
			admin.setBounds(180, 50, 200, 50);
			admin.setFont(new Font("Monotype Corsiva",Font.PLAIN , 40));
			admin.setForeground(new Color(66,94,193));
			f2.add(admin);

			JLabel sign=new JLabel("Sign in to Continue.");
			sign.setBounds(180, 85, 200, 30);
			sign.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			sign.setForeground(Color.BLACK);
			f2.add(sign);

			JLabel username=new JLabel("Username");
			username.setBounds(210, 150, 100, 30);
			username.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			username.setForeground(Color.BLACK);
			f2.add(username);


			t1=new TextField(20);
			t1.setBounds(150, 180, 200, 20);
			t1.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t1.setForeground(Color.BLACK);
			f2.add(t1);

			JLabel pass=new JLabel("Password");
			pass.setBounds(210, 210, 100, 30);
			pass.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			pass.setForeground(Color.BLACK);
			f2.add(pass);

			t2=new TextField(20);
			t2.setBounds(150, 240, 200, 20);
			t2.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t2.setForeground(Color.BLACK);
			t2.setEchoChar('*');
			f2.add(t2);

			login=new JButton("Login");
			login.setFont(new Font("Arial",Font.PLAIN, 12));
			login.setBackground(new Color(66,94,193));
			login.setForeground(Color.WHITE);
			login.setBounds(160, 270, 75, 20);
			login.addActionListener(this);
			f2.add(login);

			cancel=new JButton("Cancel");
			cancel.setFont(new Font("Arial",Font.PLAIN , 12));
			cancel.setBackground(new Color(66,94,193));
			cancel.setForeground(Color.WHITE);
			cancel.setBounds(260, 270, 75, 20);
			cancel.addActionListener(this);
			f2.add(cancel);

			back=new JButton("Back");
			back.setFont(new Font("Arial",Font.PLAIN , 12));
			back.setBackground(new Color(66,94,193));
			back.setForeground(Color.WHITE);
			back.setBounds(20, 420, 65, 20);
			back.addActionListener(this);
			f2.add(back);
		}
		if(e.getSource()==back) {
			f2.setVisible(false);
			f1.setVisible(true);
		}


		if  (e.getSource()==login) {
			if(t1.getText().equals("maroof@") && t2.getText().equals("12345")) {
				f2.dispose();
				f3=new JFrame();
				f3.setVisible(true);
				f3.setBounds(500, 150, 400, 250);
				f3.getContentPane().setBackground(Color.WHITE);
				f3.setLayout(null);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JLabel choose=new JLabel("Choose any One Option.");
				choose.setBounds(70, 25, 300, 30);
				choose.setFont(new Font("Monotype Corsiva",Font.PLAIN , 30));
				choose.setForeground(Color.BLACK);
				f3.add(choose);

				category=new JButton("Category");
				category.setFont(new Font("Arial",Font.PLAIN , 12));
				category.setBackground(new Color(66,94,193));
				category.setForeground(Color.WHITE);
				category.setBounds(120, 80, 150, 25);
				category.addActionListener(this);
				f3.add(category);

				ques=new JButton("Question");
				ques.setFont(new Font("Arial",Font.PLAIN , 12));
				ques.setBackground(new Color(66,94,193));
				ques.setForeground(Color.WHITE);
				ques.setBounds(120, 120, 150, 25);
				ques.addActionListener(this);
				f3.add(ques);	

				back1=new JButton("Back");
				back1.setFont(new Font("Arial",Font.PLAIN , 12));
				back1.setBackground(new Color(66,94,193));
				back1.setForeground(Color.WHITE);
				back1.setBounds(20, 180, 65, 20);
				back1.addActionListener(this);
				f3.add(back1);
			}

			else if (t1.getText().equals("maroof@") || t2.getText().equals("rongPass@*1")){
				JOptionPane.showMessageDialog(f3, "Incorrect Password.");
			}
			else if (t1.getText().equals("ronguser@#!") || t2.getText().equals("12345")){
				JOptionPane.showMessageDialog(f3, "Incorrect Username.");
			}
			else if (t1.getText().equals("") && t2.getText().equals("")){
				JOptionPane.showMessageDialog(f3, "Username and Password not Fill.");
			}
		}
		if(e.getSource()==back1) {
			f3.setVisible(false);
			f2.setVisible(true);
		}


		if(e.getActionCommand().equalsIgnoreCase("Cancel")) {
			f2.dispose();	
		}

		if(e.getSource()==category) {
			f3.dispose();
			f4=new JFrame();
			f4.setVisible(true);
			f4.setBounds(500, 150, 400, 250);
			f4.getContentPane().setBackground(Color.WHITE);
			f4.setLayout(null);
			f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel choose=new JLabel("Choose which you want.");
			choose.setBounds(70, 25, 300, 30);
			choose.setFont(new Font("Monotype Corsiva",Font.PLAIN, 30));
			choose.setForeground(Color.BLACK);
			f4.add(choose);

			add=new JButton("Add");
			add.setFont(new Font("Arial",Font.PLAIN, 12));
			add.setBackground(new Color(66,94,193));
			add.setForeground(Color.WHITE);
			add.setBounds(120, 80, 150, 25);
			add.addActionListener(this);
			f4.add(add);

			view=new JButton("View");
			view.setFont(new Font("Arial",Font.PLAIN, 12));
			view.setBackground(new Color(66,94,193));
			view.setForeground(Color.WHITE);
			view.setBounds(120, 120, 150, 25);
			view.addActionListener(this);
			f4.add(view);

			back2=new JButton("Back");
			back2.setFont(new Font("Arial",Font.PLAIN , 12));
			back2.setBackground(new Color(66,94,193));
			back2.setForeground(Color.WHITE);
			back2.setBounds(20, 180, 65, 20);
			back2.addActionListener(this);
			f4.add(back2);
		}

		if(e.getSource()==back2) {
			f4.setVisible(false);
			f3.setVisible(true);
		}

		if(e.getSource()==add) {
			f4.dispose();
			f5=new JFrame();
			f5.setBounds(500, 150, 400, 250);
			f5.setVisible(true);
			f5.getContentPane().setBackground(Color.WHITE);
			f5.setLayout(null);
			f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel test=new JLabel("Add Your Subjects.");
			test.setBounds(90, 35, 300, 30);
			test.setFont(new Font("Monotype Corsiva",Font.PLAIN , 30));
			test.setForeground(Color.BLACK);
			f5.add(test);

			/*		JLabel test1=new JLabel("Choose for Test");
			test1.setBounds(100, 50, 300, 30);
			test1.setFont(new Font("Monotype Corsiva",Font.CENTER_BASELINE , 30));
			test1.setForeground(new Color(9,93,106));
			f5.add(test1);  */

			t3=new TextField(20);
			t3.setBounds(120, 90, 150, 20);
			t3.setForeground(Color.BLACK);
			t3.setFont(new Font("Arial",Font.PLAIN , 12));
			f5.add(t3);

			submit=new JButton("Submit");
			submit.setFont(new Font("Arial",Font.PLAIN, 12));
			submit.setBackground(new Color(66,94,193));
			submit.setForeground(Color.WHITE);
			submit.setBounds(145, 130, 100, 25);
			submit.addActionListener(this);
			f5.add(submit);

			back3=new JButton("Back");
			back3.setFont(new Font("Arial",Font.PLAIN , 12));
			back3.setBackground(new Color(66,94,193));
			back3.setForeground(Color.WHITE);
			back3.setBounds(20, 180, 65, 20);
			back3.addActionListener(this);
			f5.add(back3);
		}

		if(e.getSource()==back3) {
			f5.setVisible(false);
			f4.setVisible(true);
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement ment=con.createStatement();

			if(e.getSource()==submit) {
				//		f5.dispose();
				String category=t3.getText();
				String s="insert into category(subjects)Values(?)";
				PreparedStatement pr=con.prepareStatement(s);
				pr.setString(1, category);
				pr.executeUpdate();
				JOptionPane.showMessageDialog(null,category+" Sucessfully Added");

			}

		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery("select * from category");

			while(rt.next()) {
				if(e.getSource()==view) {
					f4.dispose();
					f6=new JFrame("Subjects Category Tabel");
					f6.setBounds(450, 150, 500, 400);
					f6.setVisible(true);
					f6.setLayout(null);
					f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					back4=new JButton("Back");
					back4.setFont(new Font("Arial",Font.PLAIN , 12));
					back4.setBackground(new Color(66,94,193));
					back4.setForeground(Color.WHITE);
					back4.setBounds(20, 330, 65, 20);
					back4.addActionListener(this);
					f6.add(back4);

					jt=new JTable();
					DefaultTableModel model=new DefaultTableModel();
					model.setColumnIdentifiers(coloumnNames);
					jt.setModel(model);
					jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					jt.setEnabled(true);
					jt.setBounds(0, 0, 500, 400);
					jt.setForeground(Color.BLACK);
					jt.setFont(new Font("Arial",Font.PLAIN , 12));
					f6.add(jt);

					rt=st.executeQuery("select * from category");
					st=con.createStatement();

					while(rt.next()) {
						int i=0;
						JTableHeader th=jt.getTableHeader();
						int id= rt.getInt("id");
						String subjects=rt.getString("subjects");
						model.addRow(new Object[] {id,subjects});
						i++;
					}	
				}
				if(e.getSource()==back4) {
					f6.setVisible(false);
					f4.setVisible(true);
				}
			}
		}
		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
		catch(Exception y) {
			System.out.println(y.getMessage());
		}

		if(e.getSource()==ques) {
			f3.dispose();

			f7=new JFrame();
			f7.setVisible(true);
			f7.setBounds(500, 150, 400, 250);
			f7.getContentPane().setBackground(Color.WHITE);
			f7.setLayout(null);
			f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel choose=new JLabel("Choose which you want.");
			choose.setBounds(70, 25, 300, 30);
			choose.setFont(new Font("Monotype Corsiva",Font.PLAIN, 30));
			choose.setForeground(Color.BLACK);
			f7.add(choose);

			add1=new JButton("Add");
			add1.setFont(new Font("Arial",Font.PLAIN , 12));
			add1.setBackground(new Color(66,94,193));
			add1.setForeground(Color.WHITE);
			add1.setBounds(120, 80, 150, 25);
			add1.addActionListener(this);
			f7.add(add1);

			view1=new JButton("View");
			view1.setFont(new Font("Arial",Font.PLAIN, 12));
			view1.setBackground(new Color(66,94,193));
			view1.setForeground(Color.WHITE);
			view1.setBounds(120, 120, 150, 25);
			view1.addActionListener(this);
			f7.add(view1);	

			back5=new JButton("Back");
			back5.setFont(new Font("Arial",Font.PLAIN , 12));
			back5.setBackground(new Color(66,94,193));
			back5.setForeground(Color.WHITE);
			back5.setBounds(20, 180, 65, 20);
			back5.addActionListener(this);
			f7.add(back5);
		}
		if(e.getSource()==back5) {
			f7.setVisible(false);
			f3.setVisible(true);
		}

		if(e.getSource()==add1) {
			f7.dispose();

			f8=new JFrame();
			f8.setBounds(500, 80, 400, 500);
			f8.setVisible(true);
			f8.getContentPane().setBackground(Color.WHITE);
			f8.setLayout(null);
			f8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel addq=new JLabel("Add Your Questions.");
			addq.setBounds(80, 15, 300, 25);
			addq.setFont(new Font("Monotype Corsiva",Font.PLAIN , 30));
			addq.setForeground(Color.BLACK);
			f8.add(addq);

			JLabel subj=new JLabel("Subjects:");
			subj.setBounds(20, 60, 70, 30);
			subj.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			subj.setForeground(Color.BLACK);
			f8.add(subj);

			ch=new Choice();
			ch.setBounds(110, 60, 110, 30);
			ch.setForeground(Color.BLACK);
			ch.setFont(new Font("Arial",Font.PLAIN , 12));
			f8.add(ch);


			JLabel question=new JLabel("Question:");
			question.setBounds(20, 100, 70, 30);
			question.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			question.setForeground(Color.BLACK);
			f8.add(question);


			t4=new TextField(20);
			t4.setBounds(110, 100, 250, 20);
			t4.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t4.setForeground(Color.BLACK);
			f8.add(t4);

			JLabel op1=new JLabel("Option 1:");
			op1.setBounds(20, 150, 70, 30);
			op1.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			op1.setForeground(Color.BLACK);
			f8.add(op1);


			t5=new TextField(20);
			t5.setBounds(110, 150, 250, 20);
			t5.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t5.setForeground(Color.BLACK);
			f8.add(t5);

			JLabel op2=new JLabel("Option 2:");
			op2.setBounds(20, 180, 70, 30);
			op2.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			op2.setForeground(Color.BLACK);
			f8.add(op2);


			t6=new TextField(20);
			t6.setBounds(110, 180, 250, 20);
			t6.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t6.setForeground(Color.BLACK);
			f8.add(t6);

			JLabel op3=new JLabel("Option 3:");
			op3.setBounds(20, 210, 70, 30);
			op3.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			op3.setForeground(Color.BLACK);
			f8.add(op3);


			t7=new TextField(20);
			t7.setBounds(110, 210, 250, 20);
			t7.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t7.setForeground(Color.BLACK);
			f8.add(t7);

			JLabel op4=new JLabel("Option 4:");
			op4.setBounds(20, 240, 70, 30);
			op4.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			op4.setForeground(Color.BLACK);
			f8.add(op4);


			t8=new TextField(20);
			t8.setBounds(110, 240, 250, 20);
			t8.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t8.setForeground(Color.BLACK);
			f8.add(t8);

			JLabel ans=new JLabel("Answer:");
			ans.setBounds(20, 290, 70, 30);
			ans.setFont(new Font("Bahnschrift",Font.PLAIN, 15));
			ans.setForeground(Color.BLACK);
			f8.add(ans);


			t9=new TextField(20);
			t9.setBounds(110, 290, 250, 20);
			t9.setFont(new Font("Bahnschrift",Font.PLAIN, 12));
			t9.setForeground(Color.BLACK);
			f8.add(t9);

			submit1=new JButton("Submit");
			submit1.setFont(new Font("Arial",Font.PLAIN, 12));
			submit1.setBackground(new Color(66,94,193));
			submit1.setForeground(Color.WHITE);
			submit1.setBounds(180, 330, 100, 25);
			submit1.addActionListener(this);
			f8.add(submit1);

			back6=new JButton("Back");
			back6.setFont(new Font("Arial",Font.PLAIN , 12));
			back6.setBackground(new Color(66,94,193));
			back6.setForeground(Color.WHITE);
			back6.setBounds(20, 430, 65, 20);
			back6.addActionListener(this);
			f8.add(back6);	
		}

		if(e.getSource()==back6) {
			f8.setVisible(false);
			f7.setVisible(true);
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();
			ResultSet rt1=st.executeQuery("select * from category");
			while(rt1.next()) {
				//	String subjects=rt1.getString("subjects");
				ch.addItem(rt1.getString("subjects"));
				//	ch.addItem(subjects);
			}

		}

		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
		catch(Exception y) {
			System.out.println(y.getMessage());
		} 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();

			if(e.getSource()==submit1) {
				//		f5.dispose();
				String subjects=ch.getSelectedItem();
				String question=t4.getText();
				String option_1=t5.getText();
				String option_2=t6.getText();
				String option_3=t7.getText();
				String option_4=t8.getText();
				String answer=t9.getText();
				String s="insert into question(subjects,question,option_1,option_2,option_3,option_4,answer)Values(?,?,?,?,?,?,?)";
				PreparedStatement pr=con.prepareStatement(s);
				pr.setString(1, subjects);
				pr.setString(2, question);
				pr.setString(3, option_1);
				pr.setString(4, option_2);
				pr.setString(5, option_3);
				pr.setString(6, option_4);
				pr.setString(7, answer);
				pr.executeUpdate();
				JOptionPane.showMessageDialog(null,"Your Question Sucessfully Added");	
			}
		}

		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
		catch(Exception y) {
			System.out.println(y.getMessage());
		} 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery("select * from question");

			while(rt.next()) {
				if(e.getSource()==view1) {
					f7.dispose();
					f9=new JFrame("All Question Tabel");
					f9.setBounds(300, 150, 1000, 400);
					f9.setVisible(true);
					f9.setLayout(null);
					f9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					back7=new JButton("Back");
					back7.setFont(new Font("Arial",Font.PLAIN , 12));
					back7.setBackground(new Color(66,94,193));
					back7.setForeground(Color.WHITE);
					back7.setBounds(20, 330, 65, 20);
					back7.addActionListener(this);
					f9.add(back7);

					jt1=new JTable();
					DefaultTableModel model=new DefaultTableModel();
					model.setColumnIdentifiers(coloumnNames1);
					jt1.setModel(model);
					jt1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					jt1.setEnabled(true);
					jt1.setBounds(0, 0, 1000, 400);
					jt1.setForeground(Color.BLACK);
					jt1.setFont(new Font("Arial",Font.PLAIN , 12));
					//					JScrollPane sp = new JScrollPane(jt1);
					//					sp.setBounds(0, 0, 50, 400);
					//					f9.add(sp);
					f9.add(jt1);

					rt=st.executeQuery("select * from question");
					st=con.createStatement();

					while(rt.next()) {
						int i=0;
						JTableHeader th=jt1.getTableHeader();
						int id= rt.getInt("id");
						String subjects=rt.getString("subjects");
						String question=rt.getString("question");
						String option_1=rt.getString("option_1");
						String option_2=rt.getString("option_2");
						String option_3=rt.getString("option_3");
						String option_4=rt.getString("option_4");
						String answer=rt.getString("answer");
						model.addRow(new Object[] {id, subjects, question, option_1, option_2, option_3, option_4, answer});
						i++;
					}	
				}
				if(e.getSource()==back7) {
					f9.setVisible(false);
					f7.setVisible(true);
				}
			}
		}
		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
		catch(Exception y) {
			System.out.println(y.getMessage());
		}

		// User Code

		if(e.getSource()==user) {
			f1.dispose();
			f10=new JFrame("Quiz Time");
			f10.setBounds(500, 80, 500, 500);
			f10.getContentPane().setBackground(Color.WHITE);
			f10.setVisible(true);
			f10.setLayout(null);
			f10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("QuizApp/Images/time.jpg"));
			JLabel l2=new JLabel(image1);
			l2.setBounds(0, 0, 500, 196);
			f10.add(l2); 

			JLabel user=new JLabel("Username");
			user.setBounds(210, 220, 100, 30);
			user.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			user.setBackground(Color.BLACK);
			f10.add(user);

			t10=new TextField(20);
			t10.setBounds(150, 250, 200, 20);
			t10.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t10.setForeground(Color.BLACK);
			f10.add(t10);

			JLabel pass=new JLabel("Password");
			pass.setBounds(210, 270, 100, 30);
			pass.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			pass.setBackground(Color.BLACK);
			f10.add(pass);

			t11=new TextField(20);
			t11.setBounds(150, 300, 200, 20);
			t11.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t11.setForeground(Color.BLACK);
			t11.setEchoChar('*');
			f10.add(t11);

			login1=new JButton("Login");
			login1.setFont(new Font("Arial",Font.PLAIN, 12));
			login1.setBackground(new Color(66,94,193));
			login1.setForeground(Color.WHITE);
			login1.setBounds(155, 330, 85, 20);
			login1.addActionListener(this);
			f10.add(login1);

			register =new JButton("Register");
			register .setFont(new Font("Arial",Font.PLAIN , 12));
			register .setBackground(new Color(66,94,193));
			register.setForeground(Color.WHITE);
			register.setBounds(255, 330, 85, 20);
			register.addActionListener(this);
			f10.add(register);

			back8=new JButton("Back");
			back8.setFont(new Font("Arial",Font.PLAIN , 12));
			back8.setBackground(new Color(66,94,193));
			back8.setForeground(Color.WHITE);
			back8.setBounds(20, 420, 65, 20);
			back8.addActionListener(this);
			f10.add(back8);

			skip=new JButton("Skip For Now.");
			skip.setFont(new Font("Arial",Font.PLAIN , 12));
			skip.setBackground(new Color(66,94,193));
			skip.setBounds(190, 360, 120, 20);
			skip.setForeground(Color.WHITE);
			skip.addActionListener(this);  

			/*	JLabel skip=new JLabel();
	skip.setText("Skip For Now.");
	skip.setBounds(210, 350, 100, 30);
	skip.setForeground(new Color(66,94,193));
	JPanel panel = new JPanel();
	skip.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	skip.addMouseListener(new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==skip) {
				f10.dispose();
				 f12=new JFrame();
				 f12.setBounds(600, 250, 300, 150);
				 f12.getContentPane().setBackground(Color.WHITE);
				 f12.setVisible(true);
				 f12.setLayout(null);
		     	 f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				 start=new JButton("Take Test Now.");
				 start.setFont(new Font("Arial",Font.PLAIN , 12));
				 start.setBackground(new Color(66,94,193));
				 start.setForeground(Color.WHITE);
				 start.setBounds(70, 30, 150, 30);
				 start.addMouseListener(this);
				 f12.add(start);

				 back10=new JButton("Back");
					back10.setFont(new Font("Arial",Font.PLAIN , 12));
					back10.setBackground(new Color(66,94,193));
					back10.setForeground(Color.WHITE);
					back10.setBounds(20, 80, 65, 20);
					back10.addMouseListener(this);
					f12.add(back10); 
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	});  */
			f10.add(skip);



		}
		if(e.getSource()==back8) {
			f10.setVisible(false);
			f1.setVisible(true);
		}
		if(e.getSource()==skip) {
			f10.dispose();
			f12=new JFrame();
			f12.setBounds(600, 250, 300, 150);
			f12.getContentPane().setBackground(Color.WHITE);
			f12.setVisible(true);
			f12.setLayout(null);
			f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			start=new JButton("Take Test Now.");
			start.setFont(new Font("Arial",Font.PLAIN , 12));
			start.setBackground(new Color(66,94,193));
			start.setForeground(Color.WHITE);
			start.setBounds(70, 30, 150, 30);
			start.addActionListener(this);
			f12.add(start);

			back10=new JButton("Back");
			back10.setFont(new Font("Arial",Font.PLAIN , 12));
			back10.setBackground(new Color(66,94,193));
			back10.setForeground(Color.WHITE);
			back10.setBounds(20, 80, 65, 20);
			back10.addActionListener(this);
			f12.add(back10); 
		}
		if(e.getSource()==back10) {
			f12.setVisible(false);
			f10.setVisible(true);
		}  


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery("select * from students_registration");

			if(e.getSource()==login1) {
				//		 f10.setVisible(false);

				while(rt.next()) {
					if(t10.getText().equals(rt.getString("username")) && t11.getText().equals(rt.getString("password"))) {
						f10.setVisible(false);

						f12=new JFrame();
						f12.setBounds(600, 250, 300, 150);
						f12.getContentPane().setBackground(Color.WHITE);
						f12.setVisible(true);
						f12.setLayout(null);
						f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						start=new JButton("Take Test Now.");
						start.setFont(new Font("Arial",Font.PLAIN , 12));
						start.setBackground(new Color(66,94,193));
						start.setForeground(Color.WHITE);
						start.setBounds(70, 30, 150, 30);
						start.addActionListener(this);
						f12.add(start);

						back10=new JButton("Back");
						back10.setFont(new Font("Arial",Font.PLAIN , 12));
						back10.setBackground(new Color(66,94,193));
						back10.setForeground(Color.WHITE);
						back10.setBounds(20, 80, 65, 20);
						back10.addActionListener(this);
						f12.add(back10); 
					}
					else if (t10.getText().equals(rt.getString("username")) || t11.getText().equals("hfggh")){
						JOptionPane.showMessageDialog(f12, "Incorrect Password.");
					}
				}
				if (t10.getText().equals("") && t11.getText().equals("")){
					JOptionPane.showMessageDialog(f12, "Username and Password not Fill.");
				}
			}
			if(e.getSource()==back10) {
				f12.setVisible(false);
				f10.setVisible(true);
			}

		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
		}

		if(e.getSource()==register) {
			f10.dispose();

			f11=new JFrame();
			f11.setBounds(500, 80, 400, 500);
			f11.getContentPane().setBackground(Color.WHITE);
			f11.setVisible(true);
			f11.setLayout(null);
			f11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel register=new JLabel("Registration");
			register.setBounds(100, 10, 300, 50);
			register.setFont(new Font("Monotype Corsiva",Font.PLAIN , 40));
			register.setForeground(new Color(66,94,193));
			f11.add(register);

			JLabel info=new JLabel("Fill Your Form.");
			info.setBounds(140, 52, 300, 30);
			info.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			info.setBackground(Color.BLACK);
			f11.add(info);

			JLabel firstname=new JLabel("First Name:");
			firstname.setBounds(20, 90, 100, 30);
			firstname.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			firstname.setBackground(Color.BLACK);
			f11.add(firstname);

			t12=new TextField(20);
			t12.setBounds(130, 90, 220, 20);
			t12.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t12.setForeground(Color.BLACK);
			f11.add(t12);

			JLabel lastname=new JLabel("Last Name:");
			lastname.setBounds(20, 120, 100, 30);
			lastname.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			lastname.setBackground(Color.BLACK);
			f11.add(lastname);

			t13=new TextField(20);
			t13.setBounds(130, 120, 220, 20);
			t13.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t13.setForeground(Color.BLACK);
			f11.add(t13);

			JLabel father=new JLabel("Father Name:");
			father.setBounds(20, 150, 100, 30);
			father.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			father.setBackground(Color.BLACK);
			f11.add(father);

			t14=new TextField(20);
			t14.setBounds(130, 150, 220, 20);
			t14.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t14.setForeground(Color.BLACK);
			f11.add(t14);

			JLabel user=new JLabel("Userame:");
			user.setBounds(20, 180, 100, 30);
			user.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			user.setBackground(Color.BLACK);
			f11.add(user);

			t15=new TextField(20);
			t15.setBounds(130, 180, 220, 20);
			t15.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t15.setForeground(Color.BLACK);
			f11.add(t15);

			JLabel Pass=new JLabel("Password:");
			Pass.setBounds(20, 210, 100, 30);
			Pass.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			Pass.setBackground(Color.BLACK);
			f11.add(Pass);

			t16=new TextField(20);
			t16.setBounds(130, 210, 220, 20);
			t16.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t16.setForeground(Color.BLACK);
			f11.add(t16);

			JLabel date=new JLabel("Date of Birth:");
			date.setBounds(20, 240, 100, 30);
			date.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			date.setBackground(Color.BLACK);
			f11.add(date);

			t17=new JTextField("dd");
			t17.setBounds(130, 240, 50, 20);
			t17.setForeground(Color.GRAY);
			f11.add(t17);
			t17.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					if(t17.getText().isEmpty()) {
						t17.setForeground(Color.GRAY);
						t17.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
						t17.setText("dd");
					}	
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(t17.getText().equals("dd")) {
						t17.setText("");
						t17.setForeground(Color.BLACK);
					}

				}
			});

			t18=new JTextField("mm");
			t18.setBounds(190, 240, 80, 20);
			t18.setForeground(Color.GRAY);
			f11.add(t18);
			t18.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					if(t18.getText().isEmpty()) {
						t18.setForeground(Color.GRAY);
						t18.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
						t18.setText("mm");
					}	
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(t18.getText().equals("mm")) {
						t18.setText("");
						t18.setForeground(Color.BLACK);
					}

				}
			});

			t19=new JTextField("yyyy");
			t19.setBounds(280, 240, 70, 20);
			t19.setForeground(Color.GRAY);
			f11.add(t19);
			t19.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					if(t19.getText().isEmpty()) {
						t19.setForeground(Color.GRAY);
						t19.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
						t19.setText("yyyy");
					}	
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(t19.getText().equals("yyyy")) {
						t19.setText("");
						t19.setForeground(Color.BLACK);
					}

				}
			});

			JLabel email=new JLabel("Email:");
			email.setBounds(20, 270, 100, 30);
			email.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			email.setBackground(Color.BLACK);
			f11.add(email);

			t20=new TextField(20);
			t20.setBounds(130, 270, 220, 20);
			t20.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t20.setForeground(Color.BLACK);
			f11.add(t20);

			JLabel contact=new JLabel("Contact No:");
			contact.setBounds(20, 300, 100, 30);
			contact.setFont(new Font("Bahnschrift",Font.PLAIN , 15));
			contact.setBackground(Color.BLACK);
			f11.add(contact);

			t21=new TextField(20);
			t21.setBounds(130, 300, 220, 20);
			t21.setFont(new Font("Bahnschrift",Font.PLAIN , 12));
			t21.setForeground(Color.BLACK);
			f11.add(t21);

			submit3 =new JButton("Submit");
			submit3.setFont(new Font("Arial",Font.PLAIN , 12));
			submit3.setBackground(new Color(66,94,193));
			submit3.setForeground(Color.WHITE);
			submit3.setBounds(190, 330, 85, 20);
			submit3.addActionListener(this);
			f11.add(submit3);

			back9=new JButton("Back");
			back9.setFont(new Font("Arial",Font.PLAIN , 12));
			back9.setBackground(new Color(66,94,193));
			back9.setForeground(Color.WHITE);
			back9.setBounds(20, 420, 65, 20);
			back9.addActionListener(this);
			f11.add(back9);
		}

		if(e.getSource()==back9) {
			f11.setVisible(false);
			f10.setVisible(true);
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement ment=con.createStatement();

			if(e.getSource()==submit3) {
				f11.dispose();
				f10.setVisible(true);

				String firstname=t12.getText();
				String lastname=t13.getText();
				String father=t14.getText();
				String user=t15.getText();
				String pass=t16.getText();
				String date=t17.getText()+" / "+t18.getText()+" / "+t19.getText();
				String email=t20.getText();
				String contact=t21.getText();
				String s="insert into students_registration(firstname, lastname, fathername, username, password, date_of_birth, email, contact_no)Values(?,?,?,?,?,?,?,?)";
				PreparedStatement pr=con.prepareStatement(s);
				pr.setString(1, firstname);
				pr.setString(2, lastname);
				pr.setString(3, father);
				pr.setString(4, user);
				pr.setString(5, pass);
				pr.setString(6, date);
				pr.setString(7, email);
				pr.setString(8, contact);
				pr.executeUpdate();
				JOptionPane.showMessageDialog(null," Your Registration Sucessfully");	
			}

		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
		}

		if(e.getSource()==start) {
			f12.setVisible(false);

			f13=new JFrame();
			f13.setBounds(550, 250, 400, 200);
			f13.setVisible(true);
			f13.getContentPane().setBackground(Color.WHITE);
			f13.setLayout(null);
			f13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel select=new JLabel("Select Your Subject.");
			select.setBounds(90, 15, 300, 30);
			select.setFont(new Font("Monotype Corsiva",Font.PLAIN , 30));
			select.setForeground(Color.BLACK);
			f13.add(select);

			ch1=new Choice();
			ch1.setBounds(140, 60, 110, 30);
			ch1.setForeground(Color.BLACK);
			ch1.setFont(new Font("Arial",Font.PLAIN , 12));
			f13.add(ch1);

			start1=new JButton("Start");
			start1.setFont(new Font("Arial",Font.PLAIN , 12));
			start1.setBackground(new Color(66,94,193));
			start1.setForeground(Color.WHITE);
			start1.setBounds(150, 95, 85, 20);
			start1.addActionListener(this);
			f13.add(start1); 

			back11=new JButton("Back");
			back11.setFont(new Font("Arial",Font.PLAIN , 12));
			back11.setBackground(new Color(66,94,193));
			back11.setForeground(Color.WHITE);
			back11.setBounds(20, 130, 65, 20);
			back11.addActionListener(this);
			f13.add(back11); 

		}
		if(e.getSource()==back11) {
			f13.setVisible(false);
			f12.setVisible(true);
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
			Statement st=con.createStatement();
			ResultSet rt1=st.executeQuery("select * from category");
			while(rt1.next()) {
				//	String subjects=rt1.getString("subjects");
				//ch1.addItem(subjects);
				ch1.addItem(rt1.getString("subjects"));
			}	
		}

		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
		catch(Exception y) {
			System.out.println(y.getMessage());
		} 

		if(e.getSource()==start1) {
			f13.setVisible(false);

			f14=new JFrame();
			f14.setBounds(150, 100, 1200, 600);
			f14.setLayout(null);
			f14.setVisible(true);
			f14.getContentPane().setBackground(Color.WHITE);
			f14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			ImageIcon image2=new ImageIcon(ClassLoader.getSystemResource("QuizApp/Images/quiz.jpg"));
			JLabel l3=new JLabel(image2);
			l3.setBounds(0, -70, 1200, 380);
			f14.add(l3); 

			q=new JLabel("");
			q.setBounds(50, 370, 1000, 20);
			q.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			q.setForeground(Color.BLACK);
			f14.add(q);

			//			id=new JLabel("");
			//			id.setBounds(50, 330, 50, 20);
			//			id.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			//			id.setForeground(Color.BLACK);
			//			f14.add(id);

			sub=new JLabel("Subject:");
			sub.setBounds(550, 330, 150, 20);
			sub.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			sub.setForeground(new Color(66,94,193));
			f14.add(sub);
			subject=new JLabel("");
			subject.setBounds(630, 330, 150, 20);
			subject.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			subject.setForeground(Color.BLACK);
			f14.add(subject);

			JLabel a=new JLabel("1.");
			a.setBounds(30, 410, 30, 20);
			a.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			a.setForeground(new Color(66,94,193));
			f14.add(a);
			r1=new JRadioButton("",false);
			r1.setBounds(50, 410, 250, 20);
			r1.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			r1.setForeground(Color.BLACK);
			r1.setBackground(Color.WHITE);
			f14.add(r1);

			JLabel b=new JLabel("2.");
			b.setBounds(300, 410, 30, 20);
			b.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			b.setForeground(new Color(66,94,193));
			f14.add(b);
			r2=new JRadioButton("", false);
			r2.setBounds(320, 410, 250, 20);
			r2.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			r2.setForeground(Color.BLACK);
			r2.setBackground(Color.WHITE);
			f14.add(r2);

			JLabel c=new JLabel("3.");
			c.setBounds(30, 480, 30, 20);
			c.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			c.setForeground(new Color(66,94,193));
			f14.add(c);
			r3=new JRadioButton("", false);
			r3.setBounds(50, 480, 250, 20);
			r3.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			r3.setForeground(Color.BLACK);
			r3.setBackground(Color.WHITE);
			f14.add(r3);

			JLabel d=new JLabel("4.");
			d.setBounds(300, 480, 30, 20);
			d.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			d.setForeground(new Color(66,94,193));
			f14.add(d);
			r4=new JRadioButton("", false);
			r4.setBounds(320, 480, 250, 20);
			r4.setFont(new Font("Bahnschrift",Font.PLAIN , 18));
			r4.setForeground(Color.BLACK);
			r4.setBackground(Color.WHITE);
			f14.add(r4);

			ButtonGroup bg=new ButtonGroup();    
			bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);

			next=new JButton("Next");
			next.setFont(new Font("Arial",Font.PLAIN , 12));
			next.setBackground(new Color(66,94,193));
			next.setForeground(Color.WHITE);
			next.setBounds(700, 430, 80, 20);
			next.addActionListener(this);
			f14.add(next); 

			cancel1=new JButton("Cancel Test");
			cancel1.setFont(new Font("Arial",Font.PLAIN , 12));
			cancel1.setBackground(new Color(66,94,193));
			cancel1.setForeground(Color.WHITE);
			cancel1.setBounds(1000, 400, 100, 25);
			cancel1.addActionListener(this);
			f14.add(cancel1); 

			result=new JButton("Result");
			result.setFont(new Font("Arial",Font.PLAIN , 12));
			result.setBackground(new Color(66,94,193));
			result.setForeground(Color.WHITE);
			result.setBounds(1000, 450, 100, 25);
			result.addActionListener(this);
			f14.add(result); 
			result.setVisible(false);
		} 

		if(e.getActionCommand().equalsIgnoreCase("Cancel Test")) {
			f14.dispose();	
		}

		if(current<=5) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_quiz","root","");
				Statement st=con.createStatement();
				ResultSet rt1=st.executeQuery("select * from question where id order by rand() limit 5");
				while(rt1.next()) {	
					if(ch1.getSelectedItem().equals(rt1.getString("subjects"))) {

						//	id.setText(rt1.getString("id"));
						subject.setText(rt1.getString("subjects"));
						q.setText(rt1.getString("question"));
						r1.setText(rt1.getString("option_1"));
						r2.setText(rt1.getString("option_2"));
						r3.setText(rt1.getString("option_3"));
						r4.setText(rt1.getString("option_4"));
						ans=rt1.getString("answer");	

						if(r1.getText().equals(ans)) {	
							marks+=2;
						}
						else if(r2.getText().equals(ans)) {
							marks+=2;
						}
						else if(r3.getText().equals(ans)) {
							marks+=2;	
						}
						else if(r4.getText().equals(ans)) {
							marks+=2;	
						}
						else
						{
							JOptionPane.showMessageDialog(null, marks);
						}
						if(current==4) {
							//	next.disable();
							next.setVisible(false);
							result.setVisible(true);
						}
					}
				}
			}
			catch(SQLException x) {
				System.out.println(x.getMessage());
			}
			catch(Exception y) {
				System.out.println(y.getMessage());
			} 

		}

		if(e.getSource()==next) {
			if(current<=4) {
				//	question();
				current++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, marks);
			}
		}

		if(e.getSource()==result)
		{

			f14.dispose();
			f16=new JFrame();
			f16.setBounds(530, 150, 400, 300);
			f16.setLayout(null);
			f16.setVisible(true);
			f16.getContentPane().setBackground(Color.WHITE);
			f16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel score=new JLabel("Your Score is "+marks);
			score.setBounds(80, 60, 300, 50);
			score.setFont(new Font("Monotype Corsiva",Font.PLAIN , 40));
			score.setForeground(new Color(245,123,81));
			f16.add(score);

			ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("QuizApp/Images/score.jpg"));
			JLabel s=new JLabel(image);
			s.setBounds(0, 120, 150, 150);
			f16.add(s);

		}

	}

	//	void question() {
	//		
	//	}

}


