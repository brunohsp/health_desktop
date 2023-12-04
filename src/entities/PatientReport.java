package entities;

public class PatientReport {
	private String type;
	private String infos;
	private String date;
	
	public PatientReport(Object type) {
		if(type instanceof Appointment) {
			this.type = "Consulta";
			this.infos = "Médico: " + ((Appointment) type).getDoctor();
			this.date = ((Appointment) type).getAppointmentDate();
		}
		
		else if(type instanceof MedicalTestOrder) {
			this.type = "Exame";
			this.infos = "Médico: " + ((MedicalTestOrder) type).getDoctor() + " Exame: " + ((MedicalTestOrder) type).getTest();
			this.date = ((MedicalTestOrder) type).getTestDate();
		}
		
		else {
			this.type = null;
			this.infos = null;
			this.date = null;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
