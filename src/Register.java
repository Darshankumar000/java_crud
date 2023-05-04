import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame
{
	JFrame f = new JFrame();
	JLabel lblenrollment,lblrollno,lblfname,lbllname,lblmname,lblgender,lbldob,lblmno,lblcity,lblstate,lblcountry,lblemail,lblhobby;
	JTextField txtenrollment,txtrollno,txtfname,txtlname,txtmname,txtdob,txtmobile,txtemail;
	JRadioButton rmale,rfemale;
	JComboBox combocity,combostate;
	JComboBox combocountry;
	JCheckBox chkreading,chkdriving,chkcricket;
	JButton btninsert,btnupdate,btndelete,btnshow,btnclose;
	
		Register(){	
		setSize(700,1000);
		setTitle("Login Form");
		setLayout(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);

		lblenrollment = new JLabel("Enrollment : ");
		lblenrollment.setBounds(50,50,100,25);
		add(lblenrollment);

		txtenrollment = new JTextField();
		txtenrollment.setBounds(150,50,250,25);
		add(txtenrollment);
	
		lblrollno = new JLabel("Roll No : ");
		lblrollno.setBounds(50,80,100,25);
		add(lblrollno);

		txtrollno = new JTextField();
		txtrollno.setBounds(150,80,250,25);
		add(txtrollno);
		
		lblfname = new JLabel("Frist Name : ");
		lblfname.setBounds(50,110,100,25);
		add(lblfname);

		txtfname = new JTextField();
		txtfname.setBounds(150,110,250,25);
		add(txtfname);
		
		lbllname = new JLabel("Last Name : ");
		lbllname.setBounds(50,140,100,25);
		add(lbllname);

		txtlname = new JTextField();
		txtlname.setBounds(150,140,250,25);
		add(txtlname);
		
		lblmname = new JLabel("Middel Name : ");
		lblmname.setBounds(50,170,100,25);
		add(lblmname);

		txtmname = new JTextField();
		txtmname.setBounds(150,170,250,25);
		add(txtmname);

		lblgender = new JLabel("Gender : ");
		lblgender.setBounds(50,200,100,25);
		add(lblgender);
		
		rmale = new JRadioButton("Male");
    	rmale.setBounds(150,200,100,35);
    	add(rmale);
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(250,200,100,35);
        add(rfemale);
        
        lbldob = new JLabel("Date of Birth : ");
        lbldob.setBounds(50,230,100,25);
		add(lbldob);
		
		txtdob = new JTextField();
		txtdob.setBounds(150,230,250,25);
		add(txtdob);
		
        
		lblmno = new JLabel("Mobile No : ");
		lblmno.setBounds(50,260,100,25);
		add(lblmno);
        
		txtmobile = new JTextField();
		txtmobile.setBounds(150,260,250,25);
		add(txtmobile);
		
		lblcity = new JLabel("City : ");
		lblcity.setBounds(50,290,100,25);
		add(lblcity);
		
		String city[]={"--Select--","Amreli","Rajkot","Morbi","Surat","Ahemdabad"};        
	    combocity=new JComboBox(city);    
	    combocity.setBounds(150, 290,250,25);    
	    add(combocity); 
	    
	    lblstate = new JLabel("State : ");
	    lblstate.setBounds(50,320,100,25);
		add(lblstate);
		
		String state[]={"--Select--","Gujrat","Rajsthan","Maharashtra","Dilhi","Panjab"};        
	    combostate=new JComboBox(state);    
	    combostate.setBounds(150, 320,250,25);    
	    add(combostate); 
	    
	    lblcountry = new JLabel("Country : ");
	    lblcountry.setBounds(50,350,100,25);
		add(lblcountry);
		
		String country[]={"--Select--","India","Aus","U.S.A","England","Newzealand"};        
	    combocountry=new JComboBox(country);    
	    combocountry.setBounds(150, 350,250,25);    
	    add(combocountry); 
	    
	    lblemail = new JLabel("Email : ");
	    lblemail.setBounds(50,380,100,25);
		add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setBounds(150,380,250,25);
		add(txtemail);
		
		lblhobby = new JLabel("Hobby : ");
		lblhobby.setBounds(50,420,100,25);
		add(lblhobby);
		
		chkreading = new JCheckBox("Reading");    
		chkreading.setBounds(150, 410, 90, 50);    
        chkdriving = new JCheckBox("Driving");    
        chkdriving.setBounds(250, 410,  70, 50);  
        chkcricket = new JCheckBox("Cricket");    
        chkcricket.setBounds(350, 410,  70, 50);  
        add(chkreading);    
        add(chkdriving);  
        add(chkcricket);
        
        
		btninsert = new JButton("Submit");
		btninsert.setBounds(50,480,90,30);
		add(btninsert);	

		btnupdate= new JButton("Update");
		btnupdate.setBounds(150,480,90,30);
		add(btnupdate);
		
		btndelete = new JButton("Delete");
		btndelete.setBounds(250,480,90,30);
		add(btndelete);	

		btnshow= new JButton("Show");
		btnshow.setBounds(100,520,90,30);
		add(btnshow);
		
		btnclose= new JButton("Close");
		btnclose.setBounds(200,520,90,30);
		add(btnclose);
	
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gn="Male";
				String hb="";
				if(rfemale.isSelected())
				{
					gn="Female";
				}
				if(chkreading.isSelected())
				{
					hb+="Reading";
				}
				if(chkdriving.isSelected())
				{
					hb+="Driving";
				}
				if(chkcricket.isSelected())
				{
					hb+="Cricket";
				}
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String conUrl ="jdbc:mysql://localhost:3307/jdbc_f_demo?user=root";
					String sql="insert into reg_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					Connection conn =DriverManager.getConnection(conUrl);
					PreparedStatement st = conn.prepareStatement(sql);
					
					st.setString(1,txtenrollment.getText());
					st.setString(2,txtrollno.getText());
					st.setString(3,txtfname.getText());
					st.setString(4,txtlname.getText());
					st.setString(5,txtmname.getText());
					st.setString(6,gn);
					st.setString(7,txtdob.getText());
					st.setString(8,txtmobile.getText());
					st.setString(9,combocity.getSelectedItem().toString());
					st.setString(10,combostate.getSelectedItem().toString());
					st.setString(11,combocountry.getSelectedItem().toString());
					st.setString(12,txtemail.getText());
					st.setString(13,hb);
					
					int res =st.executeUpdate();
					if(res>0)
					{
						JOptionPane.showMessageDialog(f,"Record Inserted.............");
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		
		btnshow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String column[]= {"Enrollment","Roll No","Frist Name","Last Name","Middle Name","Gender","DOB","Mobile","City","State","Country","Email","Hobby"};
				String[][] data =new String[4][13];
				try
				{
					JFrame f2 = new JFrame();
					f2.setSize(1200,500);
					f2.setVisible(true);
					
					Class.forName("com.mysql.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3307/jdbc_f_demo?user=root";
					Connection conn = DriverManager.getConnection(url);
					Statement stat = conn.createStatement();
					ResultSet rs = stat.executeQuery("select * from reg_user limit 0,10");
					
					int i =0;
					while(rs.next())
					{
						for(int j=0;j<13;j++)
						{
							data[i][j]=rs.getString(j+1);
						}
						i=i+1;
					}
					JTable table = new JTable(data,column);
					JScrollPane scroll = new JScrollPane(table);
					f2.add(scroll);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		
		btnupdate.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gn="Male";
				String hb="";
				if(rfemale.isSelected())
				{
					gn="Female";
				}
				if(chkreading.isSelected())
				{
					hb+="Reading";
				}
				if(chkdriving.isSelected())
				{
					hb+="Driving";
				}
				if(chkcricket.isSelected())
				{
					hb+="Cricket";
				}
				try 
				{		
					Class.forName("com.mysql.jdbc.Driver");
					String dbconn = "jdbc:mysql://localhost:3307/jdbc_f_demo?user=root";
					Connection conn =DriverManager.getConnection(dbconn);
					String sql="update reg_user set rollno=?,fname=?,lname=?,mname=?,gender=?,dob=?,mobile=?,city=?,state=?,counrty=?,email=?,hobby=? where enrollment=?";
					
					PreparedStatement st = conn.prepareStatement(sql);
					
					st.setString(1,txtrollno.getText());
					st.setString(2,txtfname.getText());
					st.setString(3,txtlname.getText());
					st.setString(4,txtmname.getText());
					st.setString(5,gn);
					st.setString(6,txtdob.getText());
					st.setString(7,txtmobile.getText());
					st.setString(8,combocity.getSelectedItem().toString());
					st.setString(9,combostate.getSelectedItem().toString());
					st.setString(10,combocountry.getSelectedItem().toString());
					st.setString(11,txtemail.getText());
					st.setString(12,hb);
					st.setString(13,txtenrollment.getText());
					
					int res =st.executeUpdate();
					if(res>0)
					{
						JOptionPane.showMessageDialog(f,"Record Updated.............");
					}
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbconn = "jdbc:mysql://localhost:3307/jdbc_f_demo?user=root";
					Connection conn = DriverManager.getConnection(dbconn);
					String sql = "Delete from reg_user where enrollment=?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, txtenrollment.getText());
					if(st.executeUpdate()>0) {
						JOptionPane.showMessageDialog(f, "Record deleted...");
					}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}	
			}
		});
		
		btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtenrollment.setText("");
				txtfname.setText("");
				txtlname.setText("");
				txtmname.setText("");
				txtdob.setText("");
				txtemail.setText("");
				txtmobile.setText("");
				txtrollno.setText("");
				rmale.setSelected(false);
				rfemale.setSelected(false);
				combocity.setSelectedIndex(0);
				combocountry.setSelectedIndex(0);
				combostate.setSelectedIndex(0);
				chkcricket.setSelected(false);
				chkdriving.setSelected(false);
				chkreading.setSelected(false);
			}
		});
		
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Register();

	}

}
