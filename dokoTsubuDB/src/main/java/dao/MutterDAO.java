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

import model.Mutter;

public class MutterDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() throws NamingException, SQLException {//例外はエクリプスに書いてもらう
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsp");
		this.db = ds.getConnection();//赤線出たらホバーして例外を追加
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
		  //if文９行を選択して囲む->マルチキャッチブロックで例外を書き込む
			e.printStackTrace();
		}
	}
	public List<Mutter> findAll(){//returnを書いてないと赤線出るのでインスタンス化してreturn
		List<Mutter> list = new ArrayList<>();
		
		try {
			this.connect();//赤線->例外
			
			ps = db.prepareStatement("SELECT * FROM mutters ORDER BY id DESC");
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("username");
				String userText = rs.getString("usertext");
				list.add(new Mutter(id,userName,userText));
			}
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect(); //先に書く
		}
		return list;
		
	}
	
	
	public void insertOne(Mutter mutter) {
		try {
			this.connect();//赤線出たら例外で囲む
			ps = db.prepareStatement("INSERT INTO mutters(username,usertext)VALUES(?,?)");
			ps.setString(1, mutter.getUserName());
			ps.setString(2, mutter.getUserText());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect(); //先に書く
		}
		
	}
	
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM mutters WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	
	public void deleteAll() {
		try {
			this.connect();
			ps = db.prepareStatement("DELETE FROM mutters");
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	
}
















