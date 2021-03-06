package mybatis.mapping;

import mybatis.domain.LdHomeWorkFB;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface LdHomeWorkFBMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ldhomeworkfb
     *
     * @mbg.generated
     */
    @Delete({
        "delete from ldhomeworkfb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ldhomeworkfb
     *
     * @mbg.generated
     */
    @Insert({
        "insert into ldhomeworkfb (id, my_id, ",
        "user_id, homework_id, ",
        "level_flag, mark)",
        "values (#{id,jdbcType=BIGINT}, #{myId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT}, #{homeworkId,jdbcType=BIGINT}, ",
        "#{levelFlag,jdbcType=CHAR}, #{mark,jdbcType=VARCHAR})"
    })
    int insert(LdHomeWorkFB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ldhomeworkfb
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, my_id, user_id, homework_id, level_flag, mark",
        "from ldhomeworkfb",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="homework_id", property="homeworkId", jdbcType=JdbcType.BIGINT),
        @Result(column="level_flag", property="levelFlag", jdbcType=JdbcType.CHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR)
    })
    LdHomeWorkFB selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ldhomeworkfb
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, my_id, user_id, homework_id, level_flag, mark",
        "from ldhomeworkfb"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="homework_id", property="homeworkId", jdbcType=JdbcType.BIGINT),
        @Result(column="level_flag", property="levelFlag", jdbcType=JdbcType.CHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR)
    })
    List<LdHomeWorkFB> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ldhomeworkfb
     *
     * @mbg.generated
     */
    @Update({
        "update ldhomeworkfb",
        "set my_id = #{myId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "homework_id = #{homeworkId,jdbcType=BIGINT},",
          "level_flag = #{levelFlag,jdbcType=CHAR},",
          "mark = #{mark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LdHomeWorkFB record);
    
    
    @Select({
        "select",
        "id, my_id, user_id, homework_id, level_flag, mark",
        "from ldhomeworkfb",
        "where homework_id = #{homeworkId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="homework_id", property="homeworkId", jdbcType=JdbcType.BIGINT),
        @Result(column="level_flag", property="levelFlag", jdbcType=JdbcType.CHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR)
    })
    List<LdHomeWorkFB> selectByhomeworkId(Integer homeworkId);
}