package bistu.wmlove.istation.entity;

public class Response {
	private static final String OK = "ok";
	private static final String ERROR = "error";

	private Integer code;
	private String desc;
	private Object data;

	public Response success() {
		this.desc = "success";
		this.code = 200;
		return this;
	}

	public Response success(Object data) {
		this.desc = "success";
		this.code = 200;
		this.data = data;
		return this;
	}

	public Response failure(Integer code, String message) {
		this.code = code;
		this.desc = message;
		return this;
	}

	public Response failure(Integer code) {
		this.desc = "failed";
		return this;
	}

	public Object getData() {
		return data;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	

}
