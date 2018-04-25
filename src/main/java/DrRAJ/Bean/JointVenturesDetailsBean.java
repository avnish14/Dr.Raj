package DrRAJ.Bean;

public class JointVenturesDetailsBean {

	private String id;
	private String title;
	private String imageLink;
	private String content;
	private String jointVenturesId;
	private String jointVenturesName;

	public String getJointVenturesName() {
		return jointVenturesName;
	}

	public void setJointVenturesName(String jointVenturesName) {
		this.jointVenturesName = jointVenturesName;
	}

	public String getJointVenturesId() {
		return jointVenturesId;
	}

	public void setJointVenturesId(String jointVenturesId) {
		this.jointVenturesId = jointVenturesId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
