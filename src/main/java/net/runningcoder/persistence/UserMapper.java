package net.runningcoder.persistence;

import net.runningcoder.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by machine on 2017/12/17.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findOne(Long id);

    @Select("select * from user")
    List<User> findAll();

    @SelectProvider(type = UserSqlBuilder.class, method = "findByCondition")
    List<User> findByCondition(String name);


    class UserSqlBuilder {
        public String findByCondition(final String name) {
            return new SQL(){{
                SELECT("*").FROM("user");
                if (name != null)
                    WHERE(" name = #{name} ");
            }}.toString();
        }

    }
}
