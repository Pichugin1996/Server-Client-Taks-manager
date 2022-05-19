package com.dimastik.server.service;

import com.dimastik.server.entity.Task;
import com.dimastik.server.entity.Users;
import com.dimastik.server.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String testUserController() {
        return "SERVICE USER OK";
    }

//    //TODO Переделать, отлавливать ошибку, возращать null
//    public UserResponseDTO getUserById(Long id) {
//        String query = "SELECT * FROM tm_users WHERE id = %s";
//        Users user = new Users();
//        try {
//            Map<String, Object> resultSet = jdbcTemplate.queryForMap(String.format(query, id));
//
//            if (!resultSet.isEmpty()) {
//                user.setId((Long) resultSet.get("id"));
//                user.setName((String) resultSet.get("name"));
//                user.setPassword((String) resultSet.get("password"));
//                user.setEmail((String) resultSet.get("email"));
//
//                UserResponseDTO response = new UserResponseDTO(user);
//                return response;
//            }
//
//        } catch (EmptyResultDataAccessException e) {
//            System.out.println(e);
//        }
//        return new UserResponseDTO(user);
//    }

    public Users getUserByNameAndPassword(String name, String password) {
        String sql = "SELECT * FROM tm_users r WHERE r.name = '%s' and r.password = '%s'";
        String format = String.format(sql, name, password);

        Users user = new Users();

        try {
            Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(format);

            System.out.println("Ok");
            user.setId((Long) stringObjectMap.get("id"));
            user.setName((String) stringObjectMap.get("name"));
            user.setPassword((String) stringObjectMap.get("password"));
            System.out.println(user);

//            return getTaskByUser(Math.toIntExact(user.getId()));
            return user;
        } catch (EmptyResultDataAccessException e) {
            e.getMessage();
            return user;
        }
    }

//    private List<Task> getTaskByUser(Integer id) {
//        String sql = "SELECT * FROM tm_task WHERE user_id = " + id;
//        return jdbcTemplate.query(sql, new ResultSetExtractor<List>() {
//            @Override
//            public List extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<Task> list = new ArrayList<>();
//                while (rs.next()) {
//                    Task task = new Task();
//                    task.setId(rs.getLong("id"));
//                    task.setTitle(rs.getString("title"));
//                    task.setDescription(rs.getString("description"));
//                    task.setUserId(rs.getInt("user_id"));
//                    list.add(task);
//                }
//                return list;
//            }
//        });
//    }
}

