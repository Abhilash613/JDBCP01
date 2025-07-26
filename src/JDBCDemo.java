import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
//    1.Load the driver class
//    2.Get connection from DB

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Abhi@915020");
            Statement statement=con.createStatement();
            String query="select * from student";
            ResultSet rs=statement.executeQuery(query);
            System.out.println("-------------------Read Data--------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "|"+
                        rs.getString("stdName")+
                        rs.getInt("age"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
