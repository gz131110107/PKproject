package Model;

/**
 * AbstractMenu entity provides the base persistence definition of the Menu
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMenu implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mname;
	private String mprice;

	// Constructors

	/** default constructor */
	public AbstractMenu() {
	}

	/** full constructor */
	public AbstractMenu(String mname, String mprice) {
		this.mname = mname;
		this.mprice = mprice;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
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