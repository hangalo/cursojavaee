package dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppMYSQL {

    public static void main(String[] arg) {

        String SQLAgencias = "SELECT * FROM agencia";
        ConexaoDB conexoaDB = new ConexaoDB();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = conexoaDB.ligarBB();
            ps = conn.prepareStatement(SQLAgencias);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "" + rs.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados" + ex.getLocalizedMessage());
        }

    }
}
