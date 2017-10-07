package com.next.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.next.model.internal.Stop;
import com.next.model.meta.ApiResponse;
import com.next.repository.StopRepository;

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
		Stop stop = null; // TODO: build internal.Stop from response
		stopRepository.save(stop);
		return stop;
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
