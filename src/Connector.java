import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Connector {

    //establish connection to dataBase
    public Connection connectToDatabase() throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");
            String url = "jdbc:postgresql://localhost:5432/ecole";
            String user = "postgres";
            String passwd = "pgsql";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");
            return conn;

    }

    //
    public ResultSetMetaData request(String query) throws SQLException, ClassNotFoundException {
        //connect to database
        Connection conn = connectToDatabase();
        //Create  Statement object
        Statement statement = conn.createStatement();
        //the object ResultSet the request result
        ResultSet result = statement.executeQuery(query);
        //the result information in MetaData
        ResultSetMetaData resultMeta = result.getMetaData();
        //put Column names in a vector:
        Vector columns = new Vector<>();
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
            columns.add(resultMeta.getColumnName(i).toUpperCase());
        System.out.println(columns);
        //put data each row in a list and all rows in a vector
        List<String> row  = new ArrayList<String>();
        Vector data = new Vector<>();
        while(result.next()){
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                row.add( result.getObject(i).toString());
            data.add(row);
        }
        //test affichage :
        for(int i=0; i<data.size(); i++)
        {
            System.out.println (i+"=>"+data.get(i));
        }
        return resultMeta;
    }


    //INSERT a table row in STUDENT table
    public void insertIntoStudent(Vector insertData) throws SQLException, ClassNotFoundException {
        String query= "INSERT INTO student VALUES(nextval('seq_stu'),?,?,?,?,?,?,?)";
        Connection conn= connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement(query);
        for(int i=0;i<insertData.size(); i++)
            stmt.setObject(i + 1, insertData.get(i));
        System.out.println(stmt.toString());
        stmt.execute();
    }

    //INSERT a table row in TEACHER table
    public void insertIntoTeacher(Vector insertData) throws SQLException, ClassNotFoundException {
        String query= "INSERT INTO teacher VALUES(nextval('seq_tch'),?,?,?,?,?)";
        Connection conn= connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement(query);
        for(int i=0;i<insertData.size(); i++)
            stmt.setObject(i + 1, insertData.get(i));
        System.out.println(stmt.toString());
        stmt.execute();
    }


    //UPDATE a table row specifing the query
    public void updateDatabase(String query) throws SQLException, ClassNotFoundException {
        //connect to database
        Connection conn= connectToDatabase();
        //create the sql delete statement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the preparedstatement
        preparedStmt.execute();
        //close connection
        conn.close();
    }
    //DELETE a table row from database specifying the table
    public void deleteFromDatabase(String tableName, String condition) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM "+tableName+" WHERE "+condition;
        //connect to database
        Connection conn= connectToDatabase();
        //create the sql delete statement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the preparedstatement
        preparedStmt.execute();
        //close connection
        conn.close();
    }

    public Vector getInfo (String tableName,String FN,String LN) throws SQLException, ClassNotFoundException {
        String query="SELECT * FROM "+tableName+" WHERE first_name='"+FN+"' and last_name='"+LN+"'";
        //connect to database
        Connection conn = connectToDatabase();
        //Create  Statement object
        Statement statement = conn.createStatement();
        //the object ResultSet the request result
        ResultSet result = statement.executeQuery(query);
        //the result information in MetaData
        ResultSetMetaData resultMeta = result.getMetaData();
        //put Column names in a vector:
        Vector v = new Vector<>();
        while(result.next()){
            for(int i = 2; i <= resultMeta.getColumnCount(); i++)
                v.add( result.getObject(i).toString());
        }
        return v;
    }


    //BRANCH
        //Provide the branch list
    public Vector getBranchList () throws SQLException, ClassNotFoundException {
        //connect to database
        Connection conn = connectToDatabase();
        //Create  Statement object
        Statement statement = conn.createStatement();
        //the object ResultSet the request result
        ResultSet result = statement.executeQuery("SELECT * FROM branch");
        //the result information in MetaData
        ResultSetMetaData resultMeta = result.getMetaData();
        //put Column names in a vector:
        Vector bl = new Vector<>();
        while(result.next()){
            bl.add(result.getString("branch_name") );
        }
        return bl;
    }
        //INSERT a table row in BRANCH table
    public void insertIntoBranch(String query) throws SQLException, ClassNotFoundException {
        Connection conn= connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.execute();
        conn.close();
    }
    public void insertIntoCourse(String query) throws SQLException, ClassNotFoundException {
        Connection conn= connectToDatabase();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.execute();
        conn.close();
    }

    //get teacher list
    public Vector getTeacherList () throws SQLException, ClassNotFoundException {
        //connect to database
        Connection conn = connectToDatabase();
        //Create  Statement object
        Statement statement = conn.createStatement();
        //the object ResultSet the request result
        ResultSet result = statement.executeQuery("SELECT * FROM teacher");
        //the result information in MetaData
        ResultSetMetaData resultMeta = result.getMetaData();
        //put Column names in a vector:
        Vector Tl = new Vector<Teachers>();
        while(result.next()){
            Tl.add(new Teachers( result.getString("first_name"),result.getString("last_name"),result.getString("email"),result.getString("field"), result.getInt("salary"),result.getInt("teacher_id") ));
        }
        return Tl;
    }





}
