import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUpdateDemo {
//    1.Load the driver class
//    2.Get connection from DB

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Abhi@915020");
            Statement statement=con.createStatement();
//            String query="INSERT INTO student (id,stdName,age) values (4,'Ankit',21)";
//            ResultSet rs=statement.executeQuery(query);
            String query="UPDATE student set age=22 where id=1";
            int update=statement.executeUpdate(query);
            System.out.println("Updated "+update+"rows");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
