package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement(sql);
            pss.setter(ps);

            ps.executeUpdate();
        } finally {
            if(ps != null) {
                ps.close();
            }

            if(con != null) {
                con.close();
            }
        }
    }

    public User executeQuery(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement(sql);
            pss.setter(ps);

            rs = ps.executeQuery();

            User user = null;
            if (rs.next()) {
                return (User) rowMapper.map(rs);
            }

            return user;
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }

}
