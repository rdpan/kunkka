import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLUpdateStatement;
import org.junit.Test;

import java.util.List;

public class SqlTest {
    @Test
    public void testSqlparser() {
//        String sql = "update order_tbl set user_id='11111' where commodity_code='C1000001';";
//        String sql = "update spfc_currency_rate a left join spfc_currency_tab b on a.target_currency = b.currency_code set a.target_currency_symbol=b.currency_symbol;";
        String sql = "update spfc_currency_rate set name = 'lpp' where id in (select id from table2)";
        String dbType = "mysql";
        List<SQLStatement> list = SQLUtils.parseStatements(sql, dbType);
        for (SQLStatement sqlStatement: list) {
            System.out.println(sqlStatement.getClass());
            SQLUpdateStatement statement = (SQLUpdateStatement)sqlStatement;
            System.out.println(statement.getWhere());
        }


    }
}
