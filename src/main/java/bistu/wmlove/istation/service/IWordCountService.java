package bistu.wmlove.istation.service;

import java.util.List;

import bistu.wmlove.istation.entity.WordAndCount;

public interface IWordCountService {

	public WordAndCount getWordAndCount(String text);

	public List<WordAndCount> getWordAndCount(Integer offset, Integer limit);
}

