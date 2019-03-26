package sef.module6.activity;

/*
 * Тут есть несколько вариантов решения
 * хотелось бы получить комментарий, как принято делать, какой стиль более правильный
 * ещё получилось, что в Point2D поля private, нужно ли менять их на protected?
 */

/**
 * @author  Anton Kokhanchik
 * 
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D{
	
	@SuppressWarnings("unused")
	private double z;
	
	/**
	 * Creates a Point3D object with the default coordinate of 0,0,0 
	 *
	 */
	public Point3DImpl(){
		super();
		z = 0;
	}
	
	/**
	 * Creates a Point3D object at the specified coordinates
	 * 
	 * @param x coordinate along the x axis
	 * @param y coordinate along the y axis
	 * @param z coordinate along the z axis
	 */
	public Point3DImpl(double x, double y, double z){
		super(x, y);
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#setZ(double)
	 */
	public final void setZ(double z){
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getZ()
	 */
	public final double getZ(){
		return z;
	}
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#move(double, double, double)
	 */
	public void move(double x, double y, double z){
//		setX(x);
//		setY(y);
		super.move(x,y);
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#translate(double, double, double)
	 */
	public void translate(double dx, double dy, double dz){
//		setX(getX()+dx);
//		setY(getY()+dy);
		super.translate(dx, dy);
		z += dz;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#equals(double, double, double)
	 */
	public boolean equals(double x2, double y2, double z2){
//		1
//		 if (getX() == x2 && getY() == y2 && z == z2)
//		2
//		if (getDistance(x2, y2, z2) == 0)
		if (z == z2 && super.equals(x2, y2))
			return true;
		return false;
	}
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameter
	 * 
	 * @param p the coordinates to compare
	 * 
	 * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
	 */
	public boolean equals(Object p){
		if (this.getClass() != p.getClass())
			return false;

		Point3D pp = (Point3D) p;
//		if (getDistance(pp.getX(), pp.getY(), pp.getZ()) == 0)
		if(getX() == pp.getX() && getY() == pp.getY() && z == pp.getZ())
			return true;

		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
	 */
	public double getDistance(Point3D p){
		return getDistance(p.getX(), p.getY(), p.getZ());
	}


	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(double, double, double)
	 */
	public double getDistance(double x2, double y2, double z2){
//		return Math.sqrt((getX()-x2)*(getX()-x2) + (getY()-y2)*(getY()-y2) + (z-z2)*(z-z2) );
		return Math.sqrt( (super.getDistance(x2, y2))*(super.getDistance(x2, y2)) + (z-z2)*(z-z2) );
	}
}
