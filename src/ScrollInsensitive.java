import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollInsensitive {
//    1.Load the driver class
//    2.Get connection from DB

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Abhi@915020");
            Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query="select * from student";
            ResultSet rs=statement.executeQuery(query);
            System.out.println("----------Scroll insensitive, read only-----");
            System.out.println("-------------------Read Data--------------");

            rs.last();
            System.out.println("Last Row: "+rs.getInt("id"));
            System.out.println("Last Row: "+rs.getString("stdName"));

            rs.first();
            System.out.println("Last Row: "+rs.getInt("id"));
            System.out.println("Last Row: "+rs.getString("stdName"));

            rs.absolute(2);
            System.out.println("Last Row: "+rs.getInt("id"));
            System.out.println("Last Row: "+rs.getString("stdName"));
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id") + "|"+
//                        rs.getString("stdName")+
//                        rs.getInt("age"));
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
