package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class TrackRecordInfo {
	private Integer trackRecordId;

	@NotNull(message = "{trackRecordInfo.studentId.isnull}", groups = { ValidGroupUpdate.class, ValidGroupAdd.class })
	private Integer studentId;

	private String trackRecordTitle;

	private String trackRecordContent;

	@NotNull(message = "{trackRecordInfo.trackRecordTime.isnull}", groups = { ValidGroupUpdate.class,
			ValidGroupAdd.class })
	@Past(message = "{trackRecordInfo.trackRecordTime.past}", groups = { ValidGroupUpdate.class, ValidGroupAdd.class })
	private Date trackRecordTime;

	private String enrollment;

	@NotNull(message = "{trackRecordInfo.nextRecordTime.isnull}", groups = { ValidGroupUpdate.class,
			ValidGroupAdd.class })
	@Future(message = "{trackRecordInfo.nextRecordTime.future}", groups = { ValidGroupUpdate.class,
			ValidGroupAdd.class })
	private Date nextRecordTime;

	public Integer getTrackRecordId() {
		return trackRecordId;
	}

	public void setTrackRecordId(Integer trackRecordId) {
		this.trackRecordId = trackRecordId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getTrackRecordTitle() {
		return trackRecordTitle;
	}

	public void setTrackRecordTitle(String trackRecordTitle) {
		this.trackRecordTitle = trackRecordTitle == null ? null : trackRecordTitle.trim();
	}

	public String getTrackRecordContent() {
		return trackRecordContent;
	}

	public void setTrackRecordContent(String trackRecordContent) {
		this.trackRecordContent = trackRecordContent == null ? null : trackRecordContent.trim();
	}

	public Date getTrackRecordTime() {
		return trackRecordTime;
	}

	public void setTrackRecordTime(Date trackRecordTime) {
		this.trackRecordTime = trackRecordTime;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment == null ? null : enrollment.trim();
	}

	public Date getNextRecordTime() {
		return nextRecordTime;
	}

	public void setNextRecordTime(Date nextRecordTime) {
		this.nextRecordTime = nextRecordTime;
	}
}