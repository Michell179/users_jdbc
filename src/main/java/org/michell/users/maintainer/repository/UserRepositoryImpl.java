package org.michell.users.maintainer.repository;

import org.michell.users.maintainer.models.User;
import org.michell.users.maintainer.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User> {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getInstance();
    }

    @Override
    public void update(User user) {
        if (user.getId() == null){
            System.out.println("ID is empty");
            return;
        }

        String sql = "UPDATE usuarios SET username=?, password=?, email=? WHERE id=?";
        try (Connection bd = getConnection();
             PreparedStatement st = bd.prepareStatement(sql)){

            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setLong(4, user.getId());

            // Execute Query
            st.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (Connection bd = getConnection();
             PreparedStatement st = bd.prepareStatement(sql)){
            st.setLong(1, id);

            st.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) {
        String sql = "INSERT INTO usuarios(username, password, email) VALUES(?,?,?)";
        try (Connection bd = getConnection();
             PreparedStatement st = bd.prepareStatement(sql)){

            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());

            st.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> show() {
        List<User> users = new ArrayList<>();

        try (Connection bd = getConnection();
             Statement st = bd.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios")){

            while (rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
