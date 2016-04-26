package com.xupt.bookshop.dao.typeHandler;

import com.xupt.bookshop.model.enums.Category;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangge on 16-4-20.
 */
public class EnumTypeHandler implements TypeHandler<Category> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Category category, JdbcType jdbcType) throws SQLException {
        if(category !=null){
            preparedStatement.setInt(i, category.getCode());
        }
        else {
            preparedStatement.setInt(i,0);
        }
    }

    @Override
    public Category getResult(ResultSet resultSet, String s) throws SQLException {
        int code=resultSet.getInt(s);
        return Category.codeOf(code);
    }

    @Override
    public Category getResult(ResultSet resultSet, int i) throws SQLException {

        return Category.codeOf(i);
    }

    @Override
    public Category getResult(CallableStatement callableStatement, int i) throws SQLException {
        return Category.codeOf(callableStatement.getInt(i));
    }
}
