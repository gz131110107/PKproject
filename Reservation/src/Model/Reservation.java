package Model;

/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */
public class Reservation extends AbstractReservation implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Reservation() {
	}

	/** full constructor */
	public Reservation(String name, String telnumber, String tablenum,
			String retime) {
		super(name, telnumber, tablenum, retime);
	}

}
