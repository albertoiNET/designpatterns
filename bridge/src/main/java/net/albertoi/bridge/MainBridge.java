package net.albertoi.bridge;

import java.util.logging.Logger;
import net.albertoi.bridge.bulletin.EmergencyBulletin;
import net.albertoi.bridge.bulletin.SafetyBulletin;
import net.albertoi.bridge.channel.MountainRadio;
import net.albertoi.bridge.channel.TrailDisplay;

public class MainBridge {

    private static final Logger LOGGER = Logger.getLogger(MainBridge.class.getName());

    public static void main(String[] args) {
        SafetyBulletin radioAlert = new EmergencyBulletin(new MountainRadio());
        SafetyBulletin displayAlert = new EmergencyBulletin(new TrailDisplay());

        LOGGER.info(() -> radioAlert.publish("Avalanche risk on the north ridge"));
        LOGGER.info(() -> displayAlert.publish("Avalanche risk on the north ridge"));
    }
}
