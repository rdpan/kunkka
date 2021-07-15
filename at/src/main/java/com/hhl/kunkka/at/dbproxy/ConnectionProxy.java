package com.hhl.kunkka.at.dbproxy;

import com.alibaba.druid.util.JdbcUtils;
import com.hhl.kunkka.at.sqlparser.DBType;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectionProxy implements Connection {

    private Connection targetConnection;
    private DBType dbType;
    public ConnectionProxy(Connection connection) throws SQLException {
        this.targetConnection = connection;
        String dbType = JdbcUtils.getDbType(connection.getMetaData().getURL(), null);
        this.dbType = DBType.valueOf(dbType);
    }
    @Override
    public Statement createStatement() throws SQLException {
        return targetConnection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return this.targetConnection.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return this.targetConnection.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return this.targetConnection.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.targetConnection.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return this.targetConnection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        this.targetConnection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        this.targetConnection.rollback();
    }

    @Override
    public void close() throws SQLException {
        this.targetConnection.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return this.targetConnection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return this.targetConnection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        this.targetConnection.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return this.targetConnection.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        this.targetConnection.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return this.targetConnection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        this.targetConnection.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return this.targetConnection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return this.targetConnection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        this.targetConnection.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.targetConnection.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.targetConnection.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.targetConnection.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return this.targetConnection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        this.targetConnection.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        this.targetConnection.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return this.targetConnection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return this.targetConnection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return this.targetConnection.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        this.targetConnection.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        this.targetConnection.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.targetConnection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.targetConnection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.targetConnection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return this.targetConnection.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return this.targetConnection.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return this.targetConnection.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return this.targetConnection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return this.targetConnection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return this.targetConnection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return this.targetConnection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return this.targetConnection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        this.targetConnection.setClientInfo(name, value);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.targetConnection.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return this.targetConnection.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return this.targetConnection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return this.targetConnection.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return this.targetConnection.createStruct(typeName, attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        this.targetConnection.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return this.targetConnection.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        this.targetConnection.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        this.targetConnection.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return this.targetConnection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.targetConnection.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.targetConnection.isWrapperFor(iface);
    }
}
