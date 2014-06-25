package liquibase.executor;

import liquibase.ExecutionEnvironment;
import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.statement.SqlStatement;

/**
 * Convenience base class for Executor implementations.
 */
public abstract class AbstractExecutor implements Executor {
    protected Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    /**
     * Default implementation delegates to {@link #query(liquibase.statement.SqlStatement, liquibase.ExecutionEnvironment)}
     */
    @Override
    public QueryResult query(SqlStatement sql) throws DatabaseException {
        return query(sql, createDefaultExecutionOptions());
    }

    /**
     * Default implementation delegates to {@link #execute(liquibase.statement.SqlStatement, liquibase.ExecutionEnvironment)}
     */
    @Override
    public ExecuteResult execute(SqlStatement sql) throws DatabaseException {
        return execute(sql, createDefaultExecutionOptions());
    }

    /**
     * Default implementation delegates to {@link #update(liquibase.statement.SqlStatement, liquibase.ExecutionEnvironment)}
     */
    @Override
    public UpdateResult update(SqlStatement sql) throws DatabaseException {
        return update(sql, createDefaultExecutionOptions());
    }

    /**
     * Create ExecutionOptions to use in single-parameter execute/update/query calls.
     */
    protected ExecutionEnvironment createDefaultExecutionOptions() {
        return new ExecutionEnvironment(database);
    }
}
