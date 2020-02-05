package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

	public TimeEntry create(TimeEntry timeEntryObj);
	
	public TimeEntry find(Long timeEntryIdVal);
	
	public List<TimeEntry> list();
	
	public TimeEntry update(Long timeEntryIdVal, TimeEntry timeEntryObj);
	
	public void delete(Long timeEntryIdVal);
	
}
