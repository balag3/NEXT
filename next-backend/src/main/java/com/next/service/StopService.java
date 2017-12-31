package com.next.service;

import com.next.exception.BkkApiException;
import com.next.model.concrete.schedule.Schedule;
import com.next.model.concrete.vehicle.Location;
import com.next.model.internal.Stop;
import com.next.model.internal.StopDTO;
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

	private final static String API_SUCCESS = "OK";

	@Autowired
	private BKKService bkkService;

	@Autowired
	private StopRepository stopRepository;

	@Autowired
	private TaskExecutor executor;

	@Autowired
	private CoordinationService coordinationService;

	private Stop readAndSaveStop(String id) {
		ApiResponse response = bkkService.getScheduleForStop(id);

		if (!API_SUCCESS.equals(response.getStatus())) {
			throw new BkkApiException(response.getText());
		}

		Schedule schedule = (Schedule) response.getData().getEntry();

		Stop stop = Stop.builder()
				.id(schedule.getStopId())
				.schedule(schedule)
				.build();
		stopRepository.save(stop);
		return stop;
	}

	public List<StopDTO> getStopInfo(String lat, String lon, String radius) {
		ApiResponse response = bkkService.getStopsForLocation(lat, lon,radius);
		return convertResponseToStopInfo(response);
	}

	public List<StopDTO> stopsByRadius(Integer radius, Location center) {
		return getAllStops()
				.stream()
				.filter( stop -> coordinationService.isLocationInRadius(center, radius, getStopLocation(stop)))
				.collect(Collectors.toList());
	}

	public Stop read(String id) {
		Assert.hasText(id, "No id present!");

		Stop stop;
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

	public List<StopDTO> getAllStops() {
		ApiResponse response = bkkService.getAllStops();
		return convertResponseToStopInfo(response);
	}

	private Location getStopLocation(StopDTO stop) {
		Location target = new Location();
		target.setLon(stop.getLon());
		target.setLat(stop.getLat());
		return target;
	}


	private List<StopDTO> convertResponseToStopInfo(ApiResponse response) {
		List<Entry> entryList = response.getData().getList();

		List<com.next.model.concrete.stop.Stop> stops = entryList.stream()
				.map(e -> (com.next.model.concrete.stop.Stop) e)
				.collect(Collectors.toList());

		return stops.stream().map( a -> StopDTO.builder()
				.id(a.getId())
				.direction(a.getDirection())
				.lat(a.getLat())
				.lon(a.getLon())
				.name(a.getName())
				.build()).collect(Collectors.toList());
	}
}
