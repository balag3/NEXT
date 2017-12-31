package com.next.service;

import com.next.model.concrete.vehicle.Location;
import org.springframework.stereotype.Service;

@Service
public class CoordinationService {

    public boolean isLocationInRadius(Location center, Integer radius, Location target) {
        int R = 6371;
        Double dLat = (center.getLat() - target.getLat()) * Math.PI / 180;
        Double dLong = (center.getLon() - target.getLon()) * Math.PI / 180;

        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(target.getLat() * Math.PI / 180) * Math.cos(center.getLat() * Math.PI / 180) *
                        Math.sin(dLong / 2) * Math.sin(dLong / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double d = R * c;

        return (d * 1000 <= radius);
    }
}
