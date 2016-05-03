package com.xupt.bookshop.dao.typeHandler;

import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.enums.OrderState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangge on 16-5-1.
 */
public class BookStateEnumTypeHandler implements TypeHandler<BookState> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, BookState orderState, JdbcType jdbcType) throws SQLException {
        if(orderState !=null){
            preparedStatement.setInt(i, orderState.getCode());
        }
        else {
            preparedStatement.setInt(i,0);
        }
    }

    @Override
    public BookState getResult(ResultSet resultSet, String s) throws SQLException {
        int code=resultSet.getInt(s);
        return BookState.codeOf(code);
    }

    @Override
    public BookState getResult(ResultSet resultSet, int i) throws SQLException {

        return BookState.codeOf(i);
    }

    @Override
    public BookState getResult(CallableStatement callableStatement, int i) throws SQLException {
        return BookState.codeOf(callableStatement.getInt(i));
    }
}
