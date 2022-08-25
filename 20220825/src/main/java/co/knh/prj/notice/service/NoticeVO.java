package co.knh.prj.notice.service;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private int noticeHit;
	private String noticeAttech;
	private String noticeAttechDir;
}
