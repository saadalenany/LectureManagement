package lecturemanagementdoctor.doctor.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author Saad Alenany
 */
public class DataBaseManager {

    public static String SQLITEURL = "jdbc:sqlite:/lol.sqlite";

    Connection con;
    Statement stat;
    String[] sqlCreate = {StaticsQueries.CREATE_DEPARTMENT, StaticsQueries.CREATE_ACADEMIC_YEAR,
        StaticsQueries.CREATE_COURSES, StaticsQueries.CREATE_USER, StaticsQueries.CREATE_STUDENT,
        StaticsQueries.CREATE_DOCTOR, StaticsQueries.CREATE_LECTURE, StaticsQueries.CREATE_QUIZ,
        StaticsQueries.CREATE_QUIZQUESTION, StaticsQueries.CREATE_CHAT};

    String[] sqlDrop = {StaticsQueries.DROP_CHAT, StaticsQueries.DROP_QUIZQUESTION,
        StaticsQueries.DROP_QUIZ, StaticsQueries.DROP_LECTURE, StaticsQueries.DROP_DOCTOR,
        StaticsQueries.DROP_STUDENT, StaticsQueries.DROP_USER, StaticsQueries.DROP_COURSES,
        StaticsQueries.DROP_ACADEMIC_YEAR, StaticsQueries.DROP_DEPARTMENT};

    public DataBaseManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBNAME, DBUSERNAME, DBPASSWORD);
            con = DriverManager.getConnection(SQLITEURL);
            stat = con.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createDatabaseIfNotExist() {
        try {
            for (String create : sqlCreate) {
                System.out.println("executing " + create);
                stat.execute(create);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet SelectFrom(String tableName) {
        ResultSet result = null;
        try {
            stat = (Statement) con.createStatement();
            String SQL = "SELECT * FROM " + tableName;
            result = stat.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<String> getTablesNames() {
        ArrayList<String> tables = new ArrayList<>();
        try {
            ResultSet rs = stat.executeQuery("SHOW TABLES");
            rs.beforeFirst();
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
            rs.beforeFirst();   //save tables names into array
            return tables;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insertInto(String tableName, String[] fields, ArrayList<String> DataFields) {
        String SQL = "INSERT INTO " + tableName + " (";
        for (int i = 0; i < fields.length; i++) {
            SQL += fields[i];
            if (i != fields.length - 1) {
                SQL += ",";
            }
        }
        SQL += ") VALUES (";

        for (int i = 0; i < DataFields.size(); i++) {
            SQL += "'" + DataFields.get(i) + "'";
            if (i != fields.length - 1) {
                SQL += ",";
            }
        }
        SQL += ");";

        System.out.println(SQL);
        try {
            stat.execute(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean executeStatement(String SQL) {
        try {
            con.createStatement().execute(SQL);
            System.out.println(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public ResultSet performQuery(String sql) {
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet Search(String tableName, String key, String Column) {
        try {
            String SQL = "SELECT * FROM " + tableName + " WHERE " + Column + " = " + key;
            stat = (Statement) con.createStatement();
            ResultSet result = stat.executeQuery(SQL);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getId(String tablename) {
        String id = null;
        try {
            String SQL = "SELECT " + tablename + "_id  FROM " + tablename;
            stat = con.createStatement();
            ResultSet result = stat.executeQuery(SQL);
            while (result.next()) {
                id = result.getInt(1) + "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean DeleteRow(String TableName, String column, String key) {

        String SQL = "DELETE FROM " + TableName + " WHERE " + column + " = " + key;
        try {
            con.createStatement().executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public void Update(String newvalue, String colname, int condition, String tablename) {
        try {
            stat.executeUpdate("UPDATE " + tablename + " SET " + colname + " = " + newvalue + " WHERE " + tablename + "_id = " + condition);
            System.out.println("Updated!");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
