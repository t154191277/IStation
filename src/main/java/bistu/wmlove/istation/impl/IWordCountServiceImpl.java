package bistu.wmlove.istation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.IWordCountDao;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.IWordCountService;

@Service("wordCountService")
public class IWordCountServiceImpl  implements IWordCountService{

	@Autowired
	public IWordCountDao wdao;
	
	public WordAndCount getWordAndCount(String text) {
		return wdao.selectByPrimaryKey(text);
	}

	public List<WordAndCount> getWordAndCount(Integer offset, Integer limit) {
		return wdao.queryWordAndCountList(offset, limit);
	}

}
