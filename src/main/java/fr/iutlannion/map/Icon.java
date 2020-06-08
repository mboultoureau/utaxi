package fr.iutlannion.map;

public class Icon {

    private String iconUrl;
    private String shadowUrl = null;

    private int iconSizeX;
    private int iconSizeY;

    private int shadowSizeX = 0;
    private int shadowSizeY = 0;

    private int iconAnchorX = 0;
    private int iconAnchorY = 0;

    private int shadowAnchorX = 0;
    private int shadowAnchorY = 0;

    private int popupAnchorX = 0;
    private int popupAnchorY = 0;

    public Icon(String iconUrl, int iconSizeX, int iconSizeY) {
        this.iconUrl = iconUrl;
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
    }

    public Icon(String iconUrl, int iconSizeX, int iconSizeY, String shadowUrl, int shadowSizeX, int shadowAnchorY) {
        this.iconUrl = iconUrl;
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
        this.shadowUrl = shadowUrl;
        this.shadowSizeX = shadowSizeX;
        this.shadowSizeY = shadowSizeY;
    }

    public Icon(String iconUrl, int iconSizeX, int iconSizeY, int iconAnchorX, int iconAnchorY, int popupAnchorX,
            int popupAnchorY) {
        this.iconUrl = iconUrl;
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
        this.shadowUrl = shadowUrl;
        this.shadowSizeX = shadowSizeX;
        this.shadowSizeY = shadowSizeY;
        this.iconAnchorX = iconAnchorX;
        this.iconAnchorY = iconAnchorY;
        this.popupAnchorX = popupAnchorX;
        this.popupAnchorY = popupAnchorY;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getShadowUrl() {
        return shadowUrl;
    }

    public void setShadowUrl(String shadowUrl) {
        this.shadowUrl = shadowUrl;
    }

    public void setIconSize(int iconSizeX, int iconSizeY) {
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
    }

    public void setShadowSize(int shadowSizeX, int shadowSizeY) {
        this.shadowSizeX = shadowSizeX;
        this.shadowSizeY = shadowSizeY;
    }

    public void setIconAnchor(int iconAnchorX, int iconAnchorY) {
        this.iconAnchorX = iconAnchorX;
        this.iconAnchorY = iconAnchorY;
    }

    public void setShadownAnchor(int shadowAnchorX, int shadowAnchorY) {
        this.shadowAnchorX = shadowAnchorX;
        this.shadowAnchorY = shadowAnchorY;
    }

    public void setPopupAnchor(int popupAnchorX, int popupAnchorY) {
        this.popupAnchorX = popupAnchorX;
        this.popupAnchorY = popupAnchorY;
    }

    public String getObject() {
        String object = "{iconUrl: '" + this.iconUrl + "',";
        object += "shadowUrl: '" + this.shadowUrl + "',";
        object += "iconSize: [" + this.iconSizeX + ", " + this.iconSizeY + "],";
        object += "shadowSize: [" + this.shadowSizeX + ", " + this.shadowSizeY + "],";
        object += "iconAnchor: [" + this.iconAnchorX + ", " + this.iconAnchorY + "],";
        object += "shadowAnchor: [" + this.shadowAnchorX + ", " + this.shadowAnchorY + "],";
        object += "popupAnchor: [" + this.popupAnchorX + ", " + this.popupAnchorY + "]}";

        // System.out.println(object);

        return object;
    }
}
