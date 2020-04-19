package com.itcast.service;

import com.itcast.pojo.Meeting;
import net.sf.json.JSONArray;

import java.util.List;

public interface MeetingService {
	List<Meeting> selByid(int id);
	List<Meeting> selBymeetingid(int meeting_id);
	int insMeeting(Meeting meeting);
	int delmeeting(int meeting_id);
	List<Meeting> show();
}
