package model.dto;

public class Module {
	private int module_id;
	private String modult_cat_name;
	private String module_name;
	private String module_type;
	private String module_code;
	private String module_type_code;
	private String module_info_code;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public String getModult_cat_name() {
		return modult_cat_name;
	}

	public void setModult_cat_name(String modult_cat_name) {
		this.modult_cat_name = modult_cat_name;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_type() {
		return module_type;
	}

	public void setModule_type(String module_type) {
		this.module_type = module_type;
	}

	public String getModule_code() {
		return module_code;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public String getModule_info_code() {
		return module_info_code;
	}

	public void setModule_info_code(String module_info_code) {
		this.module_info_code = module_info_code;
	}

	public String getModule_type_code() {
		return module_type_code;
	}

	public void setModule_type_code(String module_type_code) {
		this.module_type_code = module_type_code;
	}

}
