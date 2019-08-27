package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.Select;
import wang.ismy.pms.domain.Member;

/**
 * @author MY
 * @date 2019/8/27 9:47
 */
public interface MemberDao {

    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findById(String id);
}
