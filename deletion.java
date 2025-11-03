import java.sql.*;
public class deletion {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="admin@33";
        String query="delete from employee where id=3;";
        try {
            Class.forName("com.mysql.jdbc.Driver");//load driver
            System.out.println("Driver loaded successfully....");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);//connection established
            System.out.println("connection established sucessfully...");

            //create statement ,does not contain any argument
            Statement stmt=con.createStatement();
            int rowsaffected= stmt.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println("delete data successfully."+ rowsaffected+"row(s)affected.");
            }else {
                System.out.println("deletion failed...");
            }
            stmt.close();
            con.close();
            System.out.println("connection close successfully...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
