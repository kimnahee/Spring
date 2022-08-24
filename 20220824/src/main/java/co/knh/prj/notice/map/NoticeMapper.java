package co.knh.prj.notice.map;

import java.util.List;

import co.knh.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeList(); //게시글 리스트
	NoticeVO noticeSelect(NoticeVO vo); //단건조회
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
}
