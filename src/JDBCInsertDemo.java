import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCInsertDemo {
//    1.Load the driver class
//    2.Get connection from DB

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Abhi@915020");
            Statement statement=con.createStatement();
            String query="INSERT INTO student (id,stdName,age) values (7,'majnu',24)";
//            ResultSet rs=statement.executeQuery(query);
            int update=statement.executeUpdate(query);
            System.out.println("Inserted "+update+"rows");



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
