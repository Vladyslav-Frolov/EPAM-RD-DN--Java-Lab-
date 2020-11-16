package com.epam.finalproject.hotel.dao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final String DATASOURCE_NAME = "jdbc/CP4DB";
    private static final String JNDI = "java:/comp/env";

    private static DataSource dataSource;

    static {
        try {
            Context envContext = (Context) new InitialContext().lookup(JNDI);
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
            LOGGER.debug("ЧЧЧЧ> connection to DB - OK");
        } catch (NamingException e) {
            LOGGER.error("Cannot obtain a connection from the pool", e);
        }
    }

    private ConnectionPool() {
    }

    /**
     * Returns a DB connection from the Pool Connections. Before using this
     * method you must configure the Date Source and the Connections Pool in your
     * WEB_APP_ROOT/META-INF/context.xml file.
     *
     * ƒл€ реализации стратегии конфигурации пула средствами Tomcat ЧЧ>
     * в web.xml добавл€етс€ тег описани€ ресурса <resource-ref>
     *
     * @return A DB connection.
     */
    static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
// метод возвращени€ Connection в пул не прописан, т. к. используетс€ try с ресурсами
}
