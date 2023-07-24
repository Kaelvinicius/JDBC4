package application;

import db.DB;
import db.DbExeption;
import db.DbIntegrityException;

import java.sql.*;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        // Deleting data
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM  department "
                    + "WHERE "
                    + "ID = ?");


            st.setDouble(1,2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
