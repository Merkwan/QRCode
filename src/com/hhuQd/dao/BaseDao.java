package com.hhuQd.dao;

import com.hhuQd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner=new QueryRunner();

    //update用来执行update,insert,delete,返回-1表示失败
    public int update(String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }
    //update用来执行update,insert,delete多个数据
    public int updateManyValues(String sql,Object[] ... args){
        Connection conn=JdbcUtils.getConnection();
        Object[] arg=new Object[args.length];
        int k=-1;
        for(int i=0;i<args[0].length;i++)
        {
            for (int j=0;j<args.length;j++) {
                arg[j] = args[j][i];
            }
            try {
                k=-1;
                k=queryRunner.update(conn,sql,arg);
                k=1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (k==-1)
                return -1;
        }
        JdbcUtils.close(conn);
        return k;
    }


    //查询返回一个javabean的sql语句
    //type:返回的对象类型
    //sql:执行的sql语句
    //args:sql对应得参数值
    //<T>:返回类型的泛型
    public <T> T quryForOne(Class<T> type,String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    //查询返回多个javabean的sql语句
    //type:返回的对象类型
    //sql:执行的sql语句
    //args:sql对应得参数值
    //<T>:返回类型的泛型
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn=JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    //执行返回一行一列得sql语句
    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();
        try {
            return  queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }


    /*返回一列的多个值
    *
    *
     */
    public List<Object> queryForManyValues(String sql){
        Connection conn=JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ColumnListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /*返回多行多列的内容
    *
    *
    * */
    public List<Object[]> queryForManyLines(String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();
        List<Object[]> query = null;
        try {
            return queryRunner.query(conn, sql, new ArrayListHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
