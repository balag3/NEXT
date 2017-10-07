package com.next.configuration;

import com.next.model.concrete.route.Route;
import com.next.model.concrete.schedule.Schedule;
import com.next.model.concrete.stop.Stop;
import com.next.model.concrete.vehicle.Vehicle;
import com.next.model.meta.Entry;

// Registry for deserializing Entry's child classes
public class EntryDeserializer extends UniquePropertyPolymorphicDeserializer<Entry> {

    private static final String vehicleUniqueKey = "vehicleId";
    private static final String routeUniqueKey = "iconDisplayType";
    private static final String scheduleUniqueKey = "schedules";
    private static final String stopUniqueKey = "direction";

    public EntryDeserializer() {
        super(Entry.class);
        this.register(vehicleUniqueKey, Vehicle.class);
        this.register(routeUniqueKey, Route.class);
        this.register(scheduleUniqueKey, Schedule.class);
        this.register(stopUniqueKey, Stop.class);
    }
}
