package bistu.wmlove.istation.advice;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import bistu.wmlove.istation.entity.Response;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
	
	private static Logger logger = Logger.getLogger(ExceptionAdvice.class);
	
	 /** 
     * 400 - Bad Request 
     */  
    @ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(HttpMessageNotReadableException.class)  
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {  
        logger.error("��������ʧ��", e);  
        return new Response().failure(HttpStatus.BAD_REQUEST.value(),"could_not_read_json");  
    }
    
    /** 
     * 405 - Method Not Allowed 
     */  
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)  
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)  
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {  
        logger.error("��֧�ֵ�ǰ���󷽷�", e);  
        return new Response().failure(HttpStatus.METHOD_NOT_ALLOWED.value(), "request_method_not_supported");  
    }  
  
    /** 
     * 415 - Unsupported Media Type 
     */  
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)  
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)  
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {  
        logger.error("��֧�ֵ�ǰý������", e);  
        return new Response().failure(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "content_type_not_supported");  
    }  
  
    /** 
     * 500 - Internal Server Error 
     */  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(Exception.class)  
    public Response handleException(Exception e) {  
        logger.error("���������쳣", e);  
        return new Response().failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());  
    }  
}
