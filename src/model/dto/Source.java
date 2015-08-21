package model.dto;

public class Source {
	private int source_id;
	private String source_name;
	private String source_code;
	private int source_status;
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public String getSource_code() {
		return source_code;
	}
	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}
	public int getSource_status() {
		return source_status;
	}
	public void setSource_status(int source_status) {
		this.source_status = source_status;
	}
	
}
