package com.arsex.api.events;

import net.minecraftforge.eventbus.api.Event;

public class EventsBase {
    public static boolean cancel(Event event) {
        if (event.isCancelable()) {
            event.setCanceled(true);
            return true;
        }
        if (event.hasResult()) {
            event.setResult(Event.Result.DENY);
            return true;
        }
        return false;
    }
}
