package models;


public class FileType{
	private Integer fileTypeId;
	private String fileType;

	public FileType(Integer fileTypeId){
		this.fileTypeId = fileTypeId;
		if(fileTypeId == 1)
			this.fileType = "Audio-Book";
		if(fileTypeId == 2)
			this.fileType = "E-Book";
	}

	//############# GETTER-SETTER ########################
	public Integer getFileTypeId(){
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId){
		this.fileTypeId = fileTypeId;
	}

	public String getFileType(){
		return fileType;
	}

	public void setFileType(String fileType){
		this.fileType = fileType;
	}
}