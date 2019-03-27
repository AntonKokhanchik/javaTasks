package sef.module9.activity;

import java.util.*;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{

	private List<RadarContact> contacts;

	/**
	 *  Constructs a new Radar 
	 */
	public RadarImpl(){
		contacts = new ArrayList<>();
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {
		for(RadarContact c : contacts) {
			if (c.getContactID() == contact.getContactID()) {
				c.setBearing(contact.getBearing());
				c.setDistance(contact.getDistance());
				return c;
			}
		}
		contacts.add(contact);
		return contact;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {
		for(RadarContact c : contacts) {
			if (c.getContactID() == id)
				return c;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		return contacts.size();
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {
		for(RadarContact c : contacts) {
			if (c.getContactID() == id) {
				contacts.remove(c);
				return c;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
		return new ArrayList<>(contacts);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
		List<RadarContact> sortedContacts = new ArrayList<>(contacts);
		sortedContacts.sort(comparator);
		return sortedContacts;
//		return Collections.sort(arg0, new DistanceComparator());
	}

	
}
