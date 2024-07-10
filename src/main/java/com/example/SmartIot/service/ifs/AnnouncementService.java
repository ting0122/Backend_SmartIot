package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.Announcement;
import com.example.SmartIot.vo.AnnouncementReq;
import com.example.SmartIot.vo.AnnouncementRes;

public interface AnnouncementService {

    AnnouncementRes createAnnouncement(AnnouncementReq request);

    List<Announcement> getAnnouncementsByRoomId(Long roomId);

    void deleteAnnouncement(Long id);

}
