package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

	public HashMap<Long, TimeEntry> inMemoryRepo = new HashMap<Long, TimeEntry>();
	private long currentId = 1L;
	
	@Override
	public TimeEntry create(TimeEntry timeEntry) {
		Long id = currentId++;
		
		TimeEntry newTimeEntry = new TimeEntry(
	            id,
	            timeEntry.getProjectId(),
	            timeEntry.getUserId(),
	            timeEntry.getDate(),
	            timeEntry.getHours()
	        );
		
		inMemoryRepo.put(id, newTimeEntry);
		return newTimeEntry;
	}

	@Override
	public TimeEntry find(long timeEntryIdVal) {
		return inMemoryRepo.get(timeEntryIdVal);
	}

	@Override
	public List<TimeEntry> list() {
		
		 return new ArrayList<>(inMemoryRepo.values());
		
	}

	@Override
	public TimeEntry update(Long timeEntryIdVal, TimeEntry timeEntryObj) {
		if (find(timeEntryIdVal) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
        	timeEntryIdVal,
        	timeEntryObj.getProjectId(),
        	timeEntryObj.getUserId(),
        	timeEntryObj.getDate(),
        	timeEntryObj.getHours()
        );

        inMemoryRepo.replace(timeEntryIdVal, updatedEntry);
        return updatedEntry;
	}

		@Override
	public void delete(Long timeEntryIdVal) {
		TimeEntry timeEntryObj = inMemoryRepo.remove(timeEntryIdVal);
	}

	

}
