package Model;

/**
 * Table entity. @author MyEclipse Persistence Tools
 */
public class Table extends AbstractTable implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Table() {
	}

	/** full constructor */
	public Table(String tid, Integer type, Integer count, Integer reFlag) {
		super(tid, type, count, reFlag);
	}
	

}
