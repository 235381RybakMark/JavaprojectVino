package com.example.JDBCWines.service;

import com.example.JDBCWines.domain.Wine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WineManagerJDBC implements WineManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTableWine = "CREATE TABLE Wine(id bigint GENERATED BY DEFAULT AS IDENTITY, winename varchar(50) unique, tastename varchar(50), cost double, year varchar(4))";

	private PreparedStatement addWineStmt;
	private PreparedStatement deleteAllWinesStmt;
	private PreparedStatement getAllWinesStmt;
	private PreparedStatement removeWineStmt;

	private Statement statement;

	public WineManagerJDBC() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Wine".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableWine);

			addWineStmt = connection
					.prepareStatement("INSERT INTO Wine (winename, tastename, cost, year) VALUES (?, ?, ?, ?)");
			deleteAllWinesStmt = connection
					.prepareStatement("DELETE FROM Wine");
			getAllWinesStmt = connection
					.prepareStatement("SELECT id, winename, tastename, cost, year FROM Wine");
			removeWineStmt = connection
					.prepareStatement("DELETE FROM Wine WHERE winename=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	void clearWines() {
		try {
			deleteAllWinesStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addWine(Wine Wine) {
		int count = 0;
		try {
			addWineStmt.setString(1, Wine.getWinename());
			addWineStmt.setString(2, Wine.getTastename());
			addWineStmt.setDouble(3, Wine.getCost());
			addWineStmt.setString(4, Wine.getYear());

			count = addWineStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void removeWine(String winename) {
		try {
			removeWineStmt.setString(1, winename);
			removeWineStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeSelectedWines(List<Wine> list) {
		try {
			connection.setAutoCommit(false);
			for (Wine Wine : list) {
				removeWineStmt.setString(1, Wine.getWinename());
				removeWineStmt.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void addAllWines(List<Wine> list) {
		try {
			connection.setAutoCommit(false);
			for (Wine Wine : list) {
				addWineStmt.setString(1, Wine.getWinename());
				addWineStmt.setString(2, Wine.getTastename());
				addWineStmt.setDouble(3, Wine.getCost());
				addWineStmt.setString(4, Wine.getYear());
				addWineStmt.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List<Wine> getAllWines() {
		List<Wine> Wines = new ArrayList<Wine>();

		try {
			ResultSet rs = getAllWinesStmt.executeQuery();

			while (rs.next()) {
				Wine s = new Wine();
				s.setId(rs.getInt("id"));
				s.setWinename(rs.getString("winename"));
				s.setTastename(rs.getString("tastename"));
				s.setCost(rs.getDouble("cost"));
				s.setYear(rs.getString("year"));
				Wines.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Wines;
	}

}
