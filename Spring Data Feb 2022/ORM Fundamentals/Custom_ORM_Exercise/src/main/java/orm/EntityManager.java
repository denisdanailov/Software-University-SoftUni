package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idColumn = getIdColumn(entity.getClass());
        idColumn.setAccessible(true);
        Object idValue = idColumn.get(entity);

        if (idValue == null || (long) idValue <= 0) {
            return doInsert(entity, idColumn);
        }

        return doUpdate(entity, idColumn);
    }

    private boolean doUpdate(E entity, Field idColumn) throws IllegalAccessException, SQLException {
        Object idValue = idColumn.get(entity);
        String tableName = getTableName(entity.getClass());
        String sqlQuery = String.format("Update %s SET username = 'pesho' WHERE id = %d",tableName, (long) idValue);
        return connection.prepareStatement(sqlQuery).execute();
    }

    private boolean doInsert(E entity, Field idColumn) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String tableFields = getColumnsWithoutId(entity.getClass());
        String tableValues = getColumnValuesWithoutId(entity);

        String sqlQuery = String.format("INSERT INTO %s(%s) VALUES (%s)", tableName, tableFields, tableValues);

        PreparedStatement statement = connection.prepareStatement(sqlQuery);

        return statement.execute();
    }

    private String getTableName(Class<?> aClass) {
        Entity[] annotations = aClass.getAnnotationsByType(Entity.class);

        if (annotations.length == 0) {
            throw new UnsupportedOperationException("Missing table name");
        }

        return annotations[0].name();
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getIdColumn(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have Primary Key"));

    }

    private String getColumnValuesWithoutId(E entity) throws IllegalAccessException {
        Class<?> aClass = entity.getClass();
        List<Field> fields = Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());

        List<String> fieldValues = new ArrayList<>();
        for (Field field :
                fields) {
            field.setAccessible(true);
            Object fieldValue = field.get(entity);

            if (fieldValue instanceof String || fieldValue instanceof LocalDate) {
                fieldValue = "'" + fieldValue + "'";
            }

            fieldValues.add(fieldValue.toString());
        }

        return String.join(", ", fieldValues);
    }

    private String getColumnsWithoutId(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(a -> a.getAnnotationsByType(Column.class))
                .map(a -> a[0].name())
                .collect(Collectors.joining(", "));
    }
}
