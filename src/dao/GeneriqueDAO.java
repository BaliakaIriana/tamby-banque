package dao;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;
import model.ObjetMere;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class GeneriqueDAO {

    static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##BANQUE", "WAWA");
        return connection;
    }

    public String selectQuery(ObjetMere obj) {
        String query = "SELECT ";
        /**
         * Generena le colonne reetra
         */
        query += generateColumn(obj);
        /**
         * Generena le FROM nom de table
         */
        query = appendTableName(obj, query);
        return query;
    }

    public String insertQuery(ObjetMere obj) {
        String query = "INSERT INTO ";
        query += getTableName(obj);
        query += " (" + generateColumn(obj) + ")";
        query += " VALUES ";
        query += "(" + generatePlaceholder(obj) + ")";
        return query;
    }

    public String updateQuery(ObjetMere obj) {
        String query = "UPDATE " + getTableName(obj);
        query += " SET ";
        // asina ny valeur ovaina
        query += " WHERE ";
        // asina ny condition
        return query;
    }

    private String appendTableName(ObjetMere obj, String query) {
        return query + " FROM " + getTableName(obj);
    }

    public String getCondition(ObjetMere obj) throws InvocationTargetException, IllegalAccessException {
        String query = " WHERE ";
        Class clazz = obj.getClass();
        Method[] methods = findGetter(Arrays.asList(clazz.getDeclaredMethods()).iterator()).toArray(new Method[0]);
        Method[] parameters = findGetterNotNull(obj, Arrays.asList(methods).iterator()).toArray(new Method[0]);
        ListIterator<Method> iterator = Arrays.asList(methods).listIterator();
        int paramCount = 0;
        for (int i = 0; i < parameters.length; i++) {
            Method m = parameters[i];
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null && m.getAnnotation(Id.class) == null) {
                query += m.getAnnotation(Column.class).name() + " = ?";
                if (i != parameters.length - 1) {
                    query += " AND ";
                }
                paramCount++;
            }
        }
        if (paramCount == 0) {
            query = query.replace(" WHERE ", "");
        }
        return query;
    }

    public String getConditionId(ObjetMere obj) throws InvocationTargetException, IllegalAccessException {
        String query = " WHERE ";
        Class clazz = obj.getClass();
        Method[] methods = findGetter(Arrays.asList(clazz.getDeclaredMethods()).iterator()).toArray(new Method[0]);
        Method[] parameters = findGetterAndIdNotNull(obj, Arrays.asList(methods).iterator()).toArray(new Method[0]);
        int paramCount = 0;
        for (int i = 0; i < parameters.length; i++) {
            Method m = parameters[i];
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null && m.getAnnotation(Id.class) != null) {
                query += m.getAnnotation(Column.class).name() + " = ?";
                if (i != parameters.length - 1) {
                    query += " AND ";
                }
                paramCount++;
            }
        }
        if (paramCount == 0) {
            query = query.replace(" WHERE ", "");
        }
        return query;
    }


    public String getConditionNot(ObjetMere obj) throws InvocationTargetException, IllegalAccessException {
        String query = " WHERE ";
        Class clazz = obj.getClass();
        Method[] methods = findGetter(Arrays.asList(clazz.getDeclaredMethods()).iterator()).toArray(new Method[0]);
        Method[] parameters = findGetterNotNull(obj, Arrays.asList(methods).iterator()).toArray(new Method[0]);
        ListIterator<Method> iterator = Arrays.asList(methods).listIterator();
        int paramCount = 0;
        for (int i = 0; i < parameters.length; i++) {
            Method m = parameters[i];
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null && m.getAnnotation(Id.class) == null) {
                query += m.getAnnotation(Column.class).name() + " <> ?";
                if (i != parameters.length - 1) {
                    query += " AND ";
                }
                paramCount++;
            }
        }
        if (paramCount == 0) {
            query = query.replace(" WHERE ", "");
        }
        return query;
    }

    private List<Method> findGetterNotNull(ObjetMere obj, Iterator<Method> iterator) throws InvocationTargetException, IllegalAccessException {
        ArrayList<Method> methods = new ArrayList<>();
        while (iterator.hasNext()) {
            Method m = iterator.next();
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null && m.getAnnotation(Id.class) == null) {
                methods.add(m);
            }
        }
        return methods;
    }

    private List<Method> findGetterAndIdNotNull(ObjetMere obj, Iterator<Method> iterator) throws InvocationTargetException, IllegalAccessException {
        ArrayList<Method> methods = new ArrayList<>();
        while (iterator.hasNext()) {
            Method m = iterator.next();
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null) {
                methods.add(m);
            }
        }
        return methods;
    }

    private String getTableName(ObjetMere obj) {
        Class clazz = obj.getClass();
        Table table = (Table) clazz.getAnnotation(Table.class);
        return table.name();
    }

    private String generateColumn(ObjetMere obj) {
        String query = "";
        Class clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        /**
         * Alaina ze fonction getter reetr
         */
        Iterator<Method> iterator = findGetter(Arrays.asList(methods).iterator()).iterator();
        while (iterator.hasNext()) {
            Method m = iterator.next();
            /**
             * Ito maka le valeur anle annotation
             */
            Column column = (Column) m.getAnnotation(Column.class);
            if (column != null) {

                query += column.name();
                if (iterator.hasNext()) {
                    query += ",";
                }
            }
        }
        return query;
    }

    private String generatePlaceholder(ObjetMere obj) {
        String query = "";
        Class clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        /**
         * Alaina ze fonction getter reetr
         */
        Iterator<Method> iterator = findGetter(Arrays.asList(methods).iterator()).iterator();
        while (iterator.hasNext()) {
            Method m = iterator.next();
            /**
             * Ito maka le valeur anle annotation
             */
            Column column = (Column) m.getAnnotation(Column.class);
            if (column != null) {

                query += "?";
                if (iterator.hasNext()) {
                    query += ",";
                }
            }
        }
        return query;
    }

    /**
     * Mitady ze getter
     *
     * @param iterator
     * @return
     */
    private List<Method> findGetter(Iterator<Method> iterator) {
        List<Method> methods = new ArrayList<>();
        while (iterator.hasNext()) {
            Method next = iterator.next();
            if (isGetter(next)) {
                methods.add(next);
            }
        }
        return methods;
    }

    /**
     * Mitady ze setter
     *
     * @param iterator
     * @return
     */
    private List<Method> findSetter(Iterator<Method> iterator) {
        List<Method> methods = new ArrayList<>();
        while (iterator.hasNext()) {
            Method next = iterator.next();
            if (isSetter(next)) {
                methods.add(next);
            }
        }
        return methods;
    }

    /**
     * Miverifier raha getter ny fonction ray
     *
     * @param method
     * @return
     */
    private boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    /**
     * Miverifier raha setter ny fonction ray
     *
     * @param method
     * @return
     */
    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }

    public List<ObjetMere> findAll(ObjetMere obj) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return findAll(obj, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<ObjetMere> findAll(ObjetMere obj, Connection connection) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String query = selectQuery(obj);
        PreparedStatement statement = null;
        Class clazz = obj.getClass();
        try {
            statement = connection.prepareStatement(query);
            ArrayList results = getDataResult(statement, clazz);
            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }


    }

    private void setInstanceAttribute(Class clazz, ResultSet rs, Object newInstance) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        Method[] methods = findSetter(Arrays.asList(newInstance.getClass().getDeclaredMethods()).iterator()).toArray(new Method[0]);
        for (Method m : methods) {
            Method getter = clazz.getDeclaredMethod(m.getName().replaceFirst("set", "get"));
            String columnName = getter.getAnnotation(Column.class).name();
            if (m.getParameterTypes()[0].getSimpleName().equals("Long")) {
                Object value = rs.getObject(columnName);
                if (value != null) {
                    m.invoke(newInstance, ((BigDecimal) value).longValue());
                }
            } else if (m.getParameterTypes()[0].getSimpleName().equals("Double")) {
                Object value = rs.getObject(columnName);
                if (value != null) {
                    m.invoke(newInstance, ((BigDecimal) value).doubleValue());
                }
            } else {
                m.invoke(newInstance, m.getParameterTypes()[0].cast(rs.getObject(columnName)));
            }
        }
    }

    public List<ObjetMere> findWhere(ObjetMere obj) throws Exception {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return findWhere(obj, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public ObjetMere findById(ObjetMere obj) throws Exception {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return findById(obj, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<ObjetMere> findWhereNot(ObjetMere obj) throws Exception {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return findWhereNot(obj, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<ObjetMere> findWhere(ObjetMere obj, Connection connection) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException, InstantiationException {
        String query = selectQuery(obj);
        query += getCondition(obj);
        return executeResultingQuery(obj, connection, query);
    }

    public ObjetMere findById(ObjetMere obj, Connection connection) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException, InstantiationException {
        String query = selectQuery(obj);
        query += getConditionId(obj);
        List<ObjetMere> objetMeres = executeResultingQuery(obj, connection, query);
        if (objetMeres.size() != 1) {
            return null;
        }
        return objetMeres.get(0);
    }


    public List<ObjetMere> findWhereNot(ObjetMere obj, Connection connection) throws InvocationTargetException, IllegalAccessException, SQLException, NoSuchMethodException, InstantiationException {
        String query = selectQuery(obj);
        query += getConditionNot(obj);
        return executeResultingQuery(obj, connection, query);
    }

    public List<ObjetMere> executeResultingQuery(ObjetMere obj, Connection connection, String query) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        PreparedStatement statement = null;
        try {
            statement = createStatement(obj, connection, query);
            ArrayList results = getDataResult(statement, obj.getClass());
            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private PreparedStatement createStatement(ObjetMere obj, Connection connection, String query) throws SQLException, InvocationTargetException, IllegalAccessException {
        PreparedStatement statement = connection.prepareStatement(query);
        Class clazz = obj.getClass();
        Method[] methods = findGetter(Arrays.asList(clazz.getDeclaredMethods()).iterator()).toArray(new Method[0]);
        Iterator<Method> iterator = Arrays.asList(methods).iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Method m = iterator.next();
            if (m.invoke(obj, null) != null && m.getAnnotation(Column.class) != null) {
                statement.setObject(i, m.invoke(obj, null));
                i++;
            }
        }
        return statement;
    }

    private PreparedStatement createInsertStatement(ObjetMere obj, Connection connection, String query) throws SQLException, InvocationTargetException, IllegalAccessException {
        PreparedStatement statement = connection.prepareStatement(query);
        Class clazz = obj.getClass();
        Method[] methods = findGetter(Arrays.asList(clazz.getDeclaredMethods()).iterator()).toArray(new Method[0]);
        Iterator<Method> iterator = Arrays.asList(methods).iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Method m = iterator.next();
            if (m.getAnnotation(Column.class) != null) {
                statement.setObject(i, m.invoke(obj, null));
                i++;
            }
        }
        return statement;
    }

    private ArrayList getDataResult(PreparedStatement statement, Class clazz) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ResultSet rs = statement.executeQuery();
        ArrayList results = new ArrayList<>();
        while (rs.next()) {
            Object newInstance = clazz.newInstance();
            setInstanceAttribute(clazz, rs, newInstance);
            results.add(newInstance);
        }
        return results;
    }

    public void insert(ObjetMere obj) throws ClassNotFoundException, SQLException, InvocationTargetException, IllegalAccessException {
        Connection connection = null;
        try {
            connection = getConnection();
            insert(obj, connection);
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InvocationTargetException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void insert(ObjetMere obj, Connection connection) throws IllegalAccessException, InvocationTargetException, SQLException {
        PreparedStatement statement = null;
        String query = insertQuery(obj);
        try {
            statement = createInsertStatement(obj, connection, query);
            statement.executeUpdate();
        } catch (SQLException | InvocationTargetException | IllegalAccessException e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public List<ObjetMere> findQuery(ObjetMere obj, String query) throws SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return findQuery(obj, query, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<ObjetMere> findQuery(ObjetMere obj, String query, Connection connection) throws InvocationTargetException, SQLException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        return executeResultingQuery(obj, connection, query);
    }

    public Long getSequenceValue(ObjetMere obj) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            return getSequenceValue(obj, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Long getSequenceValue(ObjetMere obj, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT S_" + obj.getClass().getAnnotation(Table.class).name() + ".NEXTVAL FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getLong(1);
        }
        return -1L;
    }
}
