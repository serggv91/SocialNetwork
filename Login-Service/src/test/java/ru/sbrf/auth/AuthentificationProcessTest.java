package ru.sbrf.auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import ru.sbrf.authentification.AuthentificationInfo;
import ru.sbrf.authentification.AuthentificationProcess;
import ru.sbrf.dao.springdao.AccountSpringJDBCImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

public class AuthentificationProcessTest {
    private EmbeddedDatabase db;

    @Before
    public void setUp() {
        // creates an H2 in-memory database populated from default scripts
        // classpath:schema.sql and classpath:data.sql
        db = new EmbeddedDatabaseBuilder()
                .setType(H2)
                .generateUniqueName(true)
                .addDefaultScripts()
                .build();
    }

    private final AuthentificationInfo authentificationInfo = mock(AuthentificationInfo.class);

    @After
    public void tearDown() {
        db.shutdown();
    }

    @Test
    public void testCreate() throws Exception {

    }

}
