package Model;

/**
 * AbstractConsume entity provides the base persistence definition of the
 * Consume entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractConsume implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private String mname;
	private String mprice;

	// Constructors

	/** default constructor */
	public AbstractConsume() {
	}

	/** full constructor */
	public AbstractConsume(String cname, String mname, String mprice) {
		this.cname = cname;
		this.mname = mname;
		this.mprice = mprice;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMprice() {
		return this.mprice;
	}

	public void setMprice(String mprice) {
		this.mprice = mprice;
	}

}