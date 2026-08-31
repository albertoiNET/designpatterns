package net.albertoi.bridge;

import net.albertoi.bridge.bulletin.EmergencyBulletin;
import net.albertoi.bridge.bulletin.RoutineBulletin;
import net.albertoi.bridge.bulletin.SafetyBulletin;
import net.albertoi.bridge.channel.MountainRadio;
import net.albertoi.bridge.channel.TrailDisplay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {

    @Test
    void changesTheDeliveryImplementationWithoutChangingTheBulletin() {
        SafetyBulletin radio = new EmergencyBulletin(new MountainRadio());
        SafetyBulletin display = new EmergencyBulletin(new TrailDisplay());

        assertEquals(
            "Radio channel 7 | EMERGENCY - LEAVE THE TRAIL | HIGH WINDS",
            radio.publish("High winds")
        );
        assertEquals(
            "Trail display: [EMERGENCY - LEAVE THE TRAIL] HIGH WINDS",
            display.publish("High winds")
        );
    }

    @Test
    void changesTheAbstractionWithoutChangingTheDeliveryChannel() {
        SafetyBulletin routine = new RoutineBulletin(new MountainRadio());
        SafetyBulletin emergency = new EmergencyBulletin(new MountainRadio());

        assertEquals(
            "Radio channel 7 | DAILY TRAIL UPDATE | Snow cleared",
            routine.publish("Snow cleared")
        );
        assertEquals(
            "Radio channel 7 | EMERGENCY - LEAVE THE TRAIL | SNOW CLEARED",
            emergency.publish("Snow cleared")
        );
    }
}
