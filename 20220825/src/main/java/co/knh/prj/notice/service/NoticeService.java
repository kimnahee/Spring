package co.knh.prj.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	List<Map<String, Object>> noticeSelectList(); //join or vo객체를 만들지 않고 사용할 때
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(String Key, String val);
	
}
