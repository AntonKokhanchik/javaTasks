package sef.module9.activity;

/**
 * Implementation of a RadarContact
 * 
 * @author Anton Kokhanchik
 *
 */
public class RadarContactImpl implements RadarContact {

	private String id;
	private double bearing;
	private double distance;

	/**
	 * Creates a RadarContact with the specified ID, bearing and distance.  
	 * 
	 * @param contactID the contact's ID
	 * @param bearing the contact's bearing
	 * @param distance the contact's distance
	 */
	public RadarContactImpl(String contactID, double bearing, double distance){
		id = contactID;
		this.bearing = validateBearing(bearing);
		this.distance = validateDistance(distance);
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getBearing()
	 */
	public final double getBearing() {
		return bearing;
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setBearing(double)
	 */
	public final void setBearing(double bearing) {
		this.bearing = validateBearing(bearing);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getDistance()
	 */
	public final double getDistance() {
		return distance;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setDistance(double)
	 */
	public final void setDistance(double distance) {
		this.distance = validateDistance(distance);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getContactID()
	 */
	public final String getContactID() {
		return id;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setContactID(java.lang.String)
	 */
	public final void setContactID(String contactID) {
		id = contactID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "RadarContact id: " + id +
				"\nbearing: " + bearing + "distance: " + distance;
	}

	private double validateBearing(double bearing){
		return (bearing % 360 + 360) % 360;
	}

	private double validateDistance(double distance){
		return distance < 0 ? 0 : distance;
	}

}
