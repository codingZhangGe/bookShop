package com.xupt.bookshop.dao.typeHandler;

import com.xupt.bookshop.model.enums.OrderState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**订单状态转换
 * Created by zhangge on 16-4-20.
 */
public class EnumTypeHandler implements TypeHandler<OrderState> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, OrderState orderState, JdbcType jdbcType) throws SQLException {
        if(orderState !=null){
            preparedStatement.setInt(i, orderState.getCode());
        }
        else {
            preparedStatement.setInt(i,0);
        }
    }

    @Override
    public OrderState getResult(ResultSet resultSet, String s) throws SQLException {
        int code=resultSet.getInt(s);
        return OrderState.codeOf(code);
    }

    @Override
    public OrderState getResult(ResultSet resultSet, int i) throws SQLException {

        return OrderState.codeOf(i);
    }

    @Override
    public OrderState getResult(CallableStatement callableStatement, int i) throws SQLException {
        return OrderState.codeOf(callableStatement.getInt(i));
    }
}
