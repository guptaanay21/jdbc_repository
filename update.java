import java.sql.*;
public class update {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="admin@33";
        String query="UPDATE employee\n"+
                "SET job_title = 'Full stack developer', salary = 70000.0\n"+
                "WHERE id = 2;";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully....");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("connection established sucessfully...");

            Statement stmt=con.createStatement();
            int rowsaffected= stmt.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println("update data successfully."+ rowsaffected+"row(s)affected.");
            }else {
                System.out.println("updation failed...");
            }
            stmt.close();
            con.close();
            System.out.println("connection close successfully...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
