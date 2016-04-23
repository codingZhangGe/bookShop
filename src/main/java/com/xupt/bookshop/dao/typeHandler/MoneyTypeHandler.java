package com.xupt.bookshop.dao.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import qunar.api.pojo.Money;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangge on 16-4-19.
 */
public class MoneyTypeHandler implements TypeHandler<Money> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType)
            throws SQLException {
        if (money != null) {
            preparedStatement.setBigDecimal(i, money.getAmount());
        } else {
            preparedStatement.setBigDecimal(i, null);
        }
    }

    @Override
    public Money getResult(ResultSet resultSet, String s) throws SQLException {
        BigDecimal bigDecimal = resultSet.getBigDecimal(s);
        return Money.of(bigDecimal);
    }

    @Override
    public Money getResult(ResultSet resultSet, int i) throws SQLException {
        return Money.of(resultSet.getBigDecimal(i));
    }

    @Override
    public Money getResult(CallableStatement callableStatement, int i) throws SQLException {
        return Money.of(callableStatement.getBigDecimal(i));
    }

}
