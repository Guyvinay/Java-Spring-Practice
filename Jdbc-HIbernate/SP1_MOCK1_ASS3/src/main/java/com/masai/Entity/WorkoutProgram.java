package com.masai.Entity;

/*
 * programId
programName
programDuration
 */
public class WorkoutProgram {

	private int programId;
	private String programName;
	private String programDuration;
	
	public WorkoutProgram(int programId, String programName, String programDuration) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.programDuration = programDuration;
	}
	public WorkoutProgram() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDuration() {
		return programDuration;
	}
	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}
	@Override
	public String toString() {
		return "WorkoutProgram [programId=" + programId + ", programName=" + programName + ", programDuration="
				+ programDuration + "]";
	}
	
	
	
}
