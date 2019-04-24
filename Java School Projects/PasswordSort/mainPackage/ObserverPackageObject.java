package mainPackage;

/*
 * This class is a data package for the observer class.  To send what sort type the current thread is doing 
 * and the progress of that sort.  It is used to update the correct progress bar.
 */
public class ObserverPackageObject {

	protected int sortType;
	protected int progUpdate;
	
	public ObserverPackageObject(int sortType, int progUpdate){
		this.sortType = sortType;
		this.progUpdate = progUpdate;	
	}
	
}
