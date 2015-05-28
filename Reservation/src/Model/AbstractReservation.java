package Model;

/**
 * AbstractReservation entity provides the base persistence definition of the
 * Reservation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractReservation implements java.io.Serializable {

	// Fields

	private Integer reId;
	private String name;
	private String telnumber;
	private String tablenum;
	private String retime;

	// Constructors

	/** default constructor */
	public AbstractReservation() {
	}

	/** full constructor */
	public AbstractReservation(String name, String telnumber, String tablenum,
			String retime) {
		this.name = name;
		this.telnumber = telnumber;
		this.tablenum = tablenum;
		this.retime = retime;
	}

	// Property accessors

	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelnumber() {
		return this.telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getTablenum() {
		return this.tablenum;
	}

	public void setTablenum(String tablenum) {
		this.tablenum = tablenum;
	}

	public String getRetime() {
		return this.retime;
	}

	public void setRetime(String retime) {
		this.retime = retime;
	}

}