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

import model.Todo;

public class TodoDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() throws NamingException, SQLException{
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsp");
		db = ds.getConnection();
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
	
	
	public List<Todo> findAll(){ // TodoDAO findAllメソッド
		List<Todo> list = new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM todos ORDER BY importance DESC");//データの取得
			rs=ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int importance = rs.getInt("importance");
				list.add(new Todo(id,title,importance));		
			}
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;	
	}
	
	
	public void insertOne(Todo todo) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO todos(title,importance) VALUES(?,?)");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getImportance());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	
	
	public Todo findOne(int id) {
		Todo todo = null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM todos WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				int importance = rs.getInt("importance");
				todo = new Todo(id,title,importance);
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return todo;
	}
	
	
	public void updateOne(Todo todo) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE todos SET title=?,importance=? WHERE id=?");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getImportance());
			ps.setInt(3, todo.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	
	
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM todos WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

}
