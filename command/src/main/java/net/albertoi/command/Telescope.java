package net.albertoi.command;

public class Telescope {

    private int azimuth;
    private int elevation;
    private boolean shutterOpen;

    public void slewTo(int azimuth, int elevation) {
        if (azimuth < 0 || azimuth >= 360 || elevation < 0 || elevation > 90) {
            throw new IllegalArgumentException("Coordinates are outside the telescope range");
        }
        this.azimuth = azimuth;
        this.elevation = elevation;
    }

    public void setShutterOpen(boolean shutterOpen) {
        this.shutterOpen = shutterOpen;
    }

    public int getAzimuth() {
        return azimuth;
    }

    public int getElevation() {
        return elevation;
    }

    public boolean isShutterOpen() {
        return shutterOpen;
    }
}
