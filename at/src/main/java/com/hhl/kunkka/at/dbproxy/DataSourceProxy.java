package com.hhl.kunkka.at.dbproxy;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DataSourceProxy implements DataSource {

    private DataSource targetDatasource;
    public DataSourceProxy(DataSource dataSource) {
        this.targetDatasource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new ConnectionProxy(targetDatasource.getConnection());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return new ConnectionProxy(targetDatasource.getConnection(username, password));
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return targetDatasource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return targetDatasource.isWrapperFor(iface);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return targetDatasource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        targetDatasource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        targetDatasource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return targetDatasource.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return targetDatasource.getParentLogger();
    }
}
