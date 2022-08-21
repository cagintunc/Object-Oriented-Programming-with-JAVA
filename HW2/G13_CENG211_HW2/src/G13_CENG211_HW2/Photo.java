package G13_CENG211_HW2;

public class Photo implements Cloneable {
	private int id;
	private String resolution;
	private String position;
	
	public Photo(int id, String resolution, String position) {
		this.id = id;
		this.resolution = resolution;
		this.position = position;
	}
	
	public Photo clone() {
		try {
			return (Photo) super.clone();
		} catch(CloneNotSupportedException e) {
			System.out.println("Error was occured.");
			e.printStackTrace();
			return null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	// Inspectors
	public boolean isResolutionValid() {
		String[] tempResolutions = resolution.split("x");
		int[] resolutions = {Integer.parseInt(tempResolutions[0]), 
				Integer.parseInt(tempResolutions[1])};
		if(resolutions[0] != resolutions[1]) {
			return false;
		}
		if(!((resolutions[0] >= 600)&&(resolutions[0] <= 1200))) {
			return false;
		}
		return true;
	}
	public boolean isPositionValid() {
		if(!((position.toLowerCase().equals("neutral face"))||
				(position.toLowerCase().equals("natural smile"))))
			return false;
		return true;
	}
}
