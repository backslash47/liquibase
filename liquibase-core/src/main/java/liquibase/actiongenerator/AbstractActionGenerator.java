package liquibase.actiongenerator;

import liquibase.exception.ValidationErrors;
import liquibase.exception.Warnings;
import  liquibase.ExecutionEnvironment;
import liquibase.statement.SqlStatement;

public abstract class AbstractActionGenerator<StatementType extends SqlStatement> implements ActionGenerator<StatementType> {

    @Override
    public int getPriority() {
        return PRIORITY_DEFAULT;
    }

    @Override
    public boolean supports(StatementType statement, ExecutionEnvironment env) {
        return true;
    }

    @Override
    public ValidationErrors validate(StatementType statement, ExecutionEnvironment env, ActionGeneratorChain chain) {
        return chain.validate(statement, env);
    }

    @Override
    public Warnings warn(StatementType statementType, ExecutionEnvironment env, ActionGeneratorChain chain) {
        return chain.warn(statementType, env);
    }
}
