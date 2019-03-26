package sef.module6.activity;
/**
 * @author  Anton Kokhanchik
 * 
 * This interface represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public interface Point3D extends Point2D{
	
	
	/**
	 * Returns the distance to the point specified by the parameters
	 * 
	 * @param x2 x coordinate of the target point 
	 * @param y2 y coordinate of the target point 
	 * @param z2 z coordinate of the target point
	 * 
	 * @return the distance to the target point
	 */
	public double getDistance(double x2, double y2, double z2);
	
	/**
	 * Returns the distance to the point specified by the parameter
	 * 
	 * @param p coordinate of the target point
	 * 
	 * @return the distance to the target point
	 */
	public double getDistance(Point3D p);
	
	/**
	 * Sets the coordinate of along the z-axis
	 * 
	 * @param z the coordinate along the z-axis
	 */
	public void setZ(double z);
	
	/**
	 * Returns the coordinate along the z-axis
	 * 
	 * @return the coordinate along the z-axis
	 */
	public double getZ();
	
	public void move(double x, double y, double z);
	
	/**
	 * Translates this point located at (x,y,z) such that the new coordinates
	 * represented is (x+x2, y+y2, z+z2)
	 * 
	 * @param dx the x axis delta
	 * @param dy the y axis delta
	 * @param dz the z axis delta
	 */
	public void translate(double dx, double dy, double dz);
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameters
	 * 
	 * @param x2 the x coordinate to compare
	 * @param y2 the y coordinate to compare
	 * @param z2 the z coordinate to compare
	 * @return true if the coordinates are equal, false otherwise
	 */
	public boolean equals(double x2, double y2, double z2);
	
}
