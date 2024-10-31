package Bms;

public class ManagementRepo {
	  private int id;
	    private String reportName;
	    private String generatedDate;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getReportName() {
			return reportName;
		}
		public void setReportName(String reportName) {
			this.reportName = reportName;
		}
		public String getGeneratedDate() {
			return generatedDate;
		}
		public void setGeneratedDate(String generatedDate) {
			this.generatedDate = generatedDate;
		}
}
