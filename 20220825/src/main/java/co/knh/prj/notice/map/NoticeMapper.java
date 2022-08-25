package co.knh.prj.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import co.knh.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	@Select("select * from notice")
	List<Map<String, Object>> noticeSelectList(); //join or vo객체를 만들지 않고 사용할 때
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(@Param("key") String Key, @Param("val") String val); //전달하고자 하는 값이 2개 이상일 때 @Param 
}
