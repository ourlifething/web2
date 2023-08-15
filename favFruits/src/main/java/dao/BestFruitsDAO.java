package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.FruitsJB;

public class BestFruitsDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() throws NamingException, SQLException {
		
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
		this.db = ds.getConnection();
	}
	
	private void disconnect() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(db != null) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public List<FruitsJB> findAll(){
		List<FruitsJB> fruitsList = new ArrayList<>();
		
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM favorites");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id =rs.getInt("id");
				String name = rs.getString("name");
				String month = rs.getString("month");
				fruitsList.add(new FruitsJB(id,name,month));
			}
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return fruitsList;
	}
	
	public void insertOne(FruitsJB fruitsList) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO favorites(name,month) VALUES(?,?)");
			ps.setString(1, fruitsList.getName());
			ps.setString(2, fruitsList.getMonth());
			ps.execute();

		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		
	}
	//一番人気のフルーツ
	public List<FruitsJB> findBest(int selectMonth){
		List<FruitsJB> bestFruits = new ArrayList<>();
		
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM favorites WHERE month=? GROUP BY name ORDER BY count(name) DESC LIMIT 1");
			ps.setInt(1, selectMonth);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id =rs.getInt("id");
				String name = rs.getString("name");
				String month = rs.getString("month");
				bestFruits.add(new FruitsJB(id,name,month));
			}
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return bestFruits;
	}
	//ランキング上位10を表示
	public List<FruitsJB> findLimit(int selectMonth){
		List<FruitsJB> fruitsList = new ArrayList<>();
		
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM favorites WHERE month=? GROUP BY name ORDER BY count(name) DESC LIMIT 10");
			ps.setInt(1, selectMonth);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id =rs.getInt("id");
				String name = rs.getString("name");
				String month = rs.getString("month");
				fruitsList.add(new FruitsJB(id,name,month));
			}
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return fruitsList;
	}
}
