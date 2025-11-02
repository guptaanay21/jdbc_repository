import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="admin@33";
        String query="select * from employee;";
        try {
            Class.forName("com.mysql.jdbc.Driver");//load driver
            System.out.println("Driver loaded successfully....");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);//connection established
            System.out.println("connection established sucessfully...");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);//result set store data

            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                int salary=rs.getInt("salary");
                System.out.println();
                System.out.println("================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+ name);
                System.out.println("job title: "+job_title);
                System.out.println("ID: "+salary);

            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("connection close successfully...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
