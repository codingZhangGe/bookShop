package com.qunar.qauction.dao.typeHandler;

import com.qunar.qauction.model.enums.OldDegree;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangge on 16-4-20.
 */
public class EnumTypeHandler implements TypeHandler<OldDegree> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, OldDegree oldDegree, JdbcType jdbcType) throws SQLException {
        if(oldDegree!=null){
            preparedStatement.setInt(i,oldDegree.getCode());
        }
        else {
            preparedStatement.setInt(i,0);
        }
    }

    @Override
    public OldDegree getResult(ResultSet resultSet, String s) throws SQLException {
        int code=resultSet.getInt(s);
        return OldDegree.codeOf(code);
    }

    @Override
    public OldDegree getResult(ResultSet resultSet, int i) throws SQLException {

        return OldDegree.codeOf(i);
    }

    @Override
    public OldDegree getResult(CallableStatement callableStatement, int i) throws SQLException {
        return OldDegree.codeOf(callableStatement.getInt(i));
    }
}
