package search;

public class WorkInfo {
	int Id;
	String WriterId;
	String Title;
	String content;
	String summary;
	String types;
	String WriterName;
	
	public String getWriterName() {
		return WriterName;
	}
	public void setWriterName(String writerName) {
		WriterName = writerName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getWriterId() {
		return WriterId;
	}
	public void setWriterId(String writerId) {
		WriterId = writerId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
}
