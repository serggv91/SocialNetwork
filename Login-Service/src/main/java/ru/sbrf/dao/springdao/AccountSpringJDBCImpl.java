package ru.sbrf.dao.springdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import ru.sbrf.authentification.AuthentificationInfo;
import ru.sbrf.authentification.NewAccountInfo;
import ru.sbrf.dao.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class AccountSpringJDBCImpl implements Account {
    private final String SQL_GET_ID = "SELECT ID FROM ACCOUNTS WHERE NAME LIKE ?";
    private final String SQL_GET_MAX_ID = "SELECT NVL(MAX(ID), 0) FROM ACCOUNTS";
    private final String SQL_CHECK_PASSWORD = "SELECT ID FROM ACCOUNTS WHERE NAME LIKE ? AND PASSWORD LIKE ?";
    private final String SQL_ADD_USER = "INSERT INTO ACCOUNTS(ID, NAME, PASSWORD) VALUES(ACCOUNTS_SEQ.NEXTVAL, :name, :password)";

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AccountSpringJDBCImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Long add(AuthentificationInfo authentificationInfo) {
        Long id = jdbcTemplate.queryForObject(SQL_GET_MAX_ID, Long.class) + 1;
        NewAccountInfo info = new NewAccountInfo(authentificationInfo, id);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(info);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_ADD_USER, sqlParameterSource, keyHolder);
        return (Long) keyHolder.getKey();
    }

    @Override
    public Long getID(AuthentificationInfo authentificationInfo) {
        Long results = jdbcTemplate.query(SQL_CHECK_PASSWORD, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, authentificationInfo.getName());
                preparedStatement.setString(2, authentificationInfo.getPassword());

            }
        }, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    return resultSet.getLong("ID");
                }
                return null;
            }
        });
        return results;
    }

    @Override
    public List<Long> getIdbyName(String name) {
        return jdbcTemplate.queryForList(SQL_GET_ID, Long.class, name);
    }
}
