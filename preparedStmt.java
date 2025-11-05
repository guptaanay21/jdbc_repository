import java.sql.*;
import java.util.Scanner;

public class preparedStmt {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Pizza@home3";
        String query="insert into employee(id,name,job_title,salary)values(?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");//load driver
            System.out.println("Driver loaded successfully....");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);//connection established
            System.out.println("connection established successfully...");
            Scanner sc=new Scanner(System.in);
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String job_title=sc.nextLine();
            double salary=sc.nextDouble();



            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,job_title);
            preparedStatement.setDouble(4,salary);

            int rowsAffected=preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("data insert successfully!!!");
            }else{
                System.out.println("data insertion fail");
            }
            preparedStatement.close();
            con.close();
            System.out.println("connection close successfully...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
