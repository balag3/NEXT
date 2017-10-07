package com.next.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.next.model.internal.Stop;
import com.next.repository.StopRepository;
import com.next.service.bkk.BkkService;

@Service
public class StopService {

	@Autowired
	private BkkService bkkService;
	@Autowired
	private StopRepository stopRepository;

	public Stop read(String id) {
		Assert.hasText(id, "No id present!");

		Stop stop = null;
		if (stopRepository.exists(id)) {
			stop = stopRepository.findOne(id);
		}

		if (stop == null || (stop != null && stop.isOutDated())) {
			stop = bkkService.readStop(id);
			stopRepository.save(stop);
		}

		return stop;
	}

}
