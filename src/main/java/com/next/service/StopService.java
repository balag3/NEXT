package com.next.service;

import com.next.model.concrete.schedule.Schedule;
import com.next.model.internal.Stop;
import com.next.model.internal.StopInfo;
import com.next.model.meta.ApiResponse;
import com.next.model.meta.Entry;
import com.next.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopService {

	@Autowired
	private BKKService bkkService;
	@Autowired
	private StopRepository stopRepository;
	@Autowired
	private TaskExecutor executor;

	private Stop readAndSaveStop(String id) {
		ApiResponse response = bkkService.getScheduleForStop(id);
		Schedule schedule = (Schedule) response.getData().getEntry();

		Stop stop = Stop.builder()
				.id(schedule.getStopId())
				.schedule(schedule)
				.build();
		stopRepository.save(stop);
		return stop;
	}

	public List<StopInfo> getStopInfo(String lat, String lon, String radius) {
		ApiResponse response = bkkService.getStopsForLocation(lat, lon,radius);
		List<Entry> entryList = response.getData().getList();
		List<com.next.model.concrete.stop.Stop> stops = entryList.stream().map(e -> (com.next.model.concrete.stop.Stop) e)
				.collect(Collectors.toList());

		return stops.stream().map( a -> {
			return StopInfo.builder()
					.id(a.getId())
					.direction(a.getDirection())
					.lat(a.getLat())
					.lon(a.getLon())
					.name(a.getName())
					.build();
		}).collect(Collectors.toList());
	}

	public Stop read(String id) {
		Assert.hasText(id, "No id present!");

		Stop stop = null;
		if (stopRepository.exists(id)) {
			stop = stopRepository.findOne(id);
		} else {
			stop = readAndSaveStop(id);
		}

		Assert.notNull(stop, "Stop cannot be found!");

		if (stop.isOutDated()) {
			executor.execute(() -> readAndSaveStop(id));
		}

		return stop;
	}

}
