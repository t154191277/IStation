package bistu.wmlove.istation.dao;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User queryUserByName(String name);

    int updateByPrimaryKeySelective(User record);

    int selectById(User record);
    
    User selectById(@Param("id")String phone);
    
    User login(@Param("id") String phone);
}