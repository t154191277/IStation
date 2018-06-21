package bistu.wmlove.istation.dao;

import java.util.List;

import bistu.wmlove.istation.entity.WordAndCount;

public interface IWordCountDao {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(WordAndCount record);
//
//    int insertSelective(WordAndCount record);

    WordAndCount selectByPrimaryKey(String text);

	List<WordAndCount> queryWordAndCountList(Integer offset, Integer limit);

//    int updateByPrimaryKeySelective(WordAndCount record);
//
//    int updateByPrimaryKey(WordAndCount record);
}