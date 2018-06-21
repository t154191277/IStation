package bistu.wmlove.istation.api.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomObjectMapper extends ObjectMapper {  
	  
    private boolean camelCaseToLowerCaseWithUnderscores = false;  
    private String dateFormatPattern;  
  
    public void setCamelCaseToLowerCaseWithUnderscores(boolean camelCaseToLowerCaseWithUnderscores) {  
        this.camelCaseToLowerCaseWithUnderscores = camelCaseToLowerCaseWithUnderscores;  
    }  
  
    public void setDateFormatPattern(String dateFormatPattern) {  
        this.dateFormatPattern = dateFormatPattern;  
    }  
  
    public void init() {  
        // �ų�ֵΪ������  
        setSerializationInclusion(Include.NON_NULL);  
        // �����������  false
        configure(SerializationFeature.INDENT_OUTPUT, false);  
        // ���շ�תΪ�»���  
        if (camelCaseToLowerCaseWithUnderscores) {  
            setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);  
        }  
        // �������ڸ�ʽ��  
        if (!StringUtils.isEmpty(dateFormatPattern)) {  
            DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);  
            setDateFormat(dateFormat);  
        }  
    }  
} 