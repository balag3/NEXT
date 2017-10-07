package com.next.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Stop read(String id) {
		Assert.hasText(id, "No id present!");

		Stop stop = null;
		if (stopRepository.exists(id)) {
			stop = stopRepository.findOne(id);
		}

		if (stop == null || (stop != null && stop.isOutDated())) {
			ApiResponse response = bkkService.getScheduleForStop(id);
			stop = null; // TODO: build internal.Stop from response
			stopRepository.save(stop);
		}

		return stop;
	}

}
