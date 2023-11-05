public class Automobile{
	// Declaring private variables
		private String autoMake;
		private String autoModel;
		private String autoColor;
		private int autoYear;		
		private int autoMileage;
		// Defining getter methods
		public String getAutoMake() {
			return autoMake;
		}
		public String getAutoModel() {
			return autoModel;
		}
		public String getAutoColor() {
			return autoColor;
		}
		public int getAutoYear() {
			return autoYear;
		}
		public int getAutoMileage() {
			return autoMileage;
		}
		// Defining setter methods
		public void setAutoMake(String AutoMake) {
			this.autoMake = AutoMake;
		}
		public void setAutoModel(String AutoModel) {
			this.autoModel = AutoModel;
		}
		public void setAutoColor(String AutoColor) {
			this.autoColor = AutoColor;
		}
		public void setAutoYear(int AutoYear) {
			this.autoYear = AutoYear;
		}
		public void setAutoMileage(int AutoMileage) {
			this.autoMileage = AutoMileage;
		}
		// Defining a default constructor
		public Automobile() {
			this.autoMake = "";
			this.autoModel = "";
			this.autoColor = "";
			this.autoYear = 0;			
			this.autoMileage = 0;
		}
		// Defining a parameterized constructor
		public Automobile(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage) {
			this.autoMake = autoMake;
			this.autoModel = autoModel;
			this.autoColor = autoColor;
			this.autoYear = autoYear;
			this.autoMileage = autoMileage;
		}
}