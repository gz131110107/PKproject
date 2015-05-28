package Model;

/**
 * AbstractTable entity provides the base persistence definition of the Table
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTable implements java.io.Serializable {

	// Fields

	private String tid;
	private Integer type;
	private Integer count;
	private Integer reFlag;

	// Constructors

	/** default constructor */
	public AbstractTable() {
	}

	/** full constructor */
	public AbstractTable(String tid, Integer type, Integer count, Integer reFlag) {
		this.tid = tid;
		this.type = type;
		this.count = count;
		this.reFlag = reFlag;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getReFlag() {
		return this.reFlag;
	}

	public void setReFlag(Integer reFlag) {
		this.reFlag = reFlag;
	}

}