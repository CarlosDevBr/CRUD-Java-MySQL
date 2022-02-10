package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class deletar {

	public static void main(String[] args) {

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE from department "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffected);
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}
}