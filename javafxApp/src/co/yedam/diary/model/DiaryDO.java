package co.yedam.diary.model;

import java.time.LocalDate;

public class DiaryDO {
	private String dDate;
	private String weather;
	private String title;
	private String contents;
	
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String localDate) {
		this.dDate = localDate;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "DiaryDO [dDate=" + dDate + ", weather=" + weather + ", title=" + title + ", contents=" + contents + "]";
	}
	
	
	
	
}
