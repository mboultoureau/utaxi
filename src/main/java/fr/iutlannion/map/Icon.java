package fr.iutlannion.map;

/**
 * Représente une icone sur la carte
 */
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

    /**
     * Créé une icone
     * @param iconUrl L'URL de l'icone
     * @param iconSizeX La largeur de l'icone
     * @param iconSizeY La hauteur de l'icone
     */
    public Icon(String iconUrl, int iconSizeX, int iconSizeY) {
        this.iconUrl = iconUrl;
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
    }

    /**
     * Créé une icone avec une ombre
     * @param iconUrl L'URL de l'icone
     * @param iconSizeX La largeur de l'icone
     * @param iconSizeY La hauteur de l'icone
     * @param shadowUrl L'URL de l'ombre de l'icone
     * @param shadowSizeX La largeur de l'ombre
     * @param shadowSizeY La hauteur de l'ombre
     */
    public Icon(String iconUrl, int iconSizeX, int iconSizeY, String shadowUrl, int shadowSizeX, int shadowSizeY) {
        this.iconUrl = iconUrl;
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
        this.shadowUrl = shadowUrl;
        this.shadowSizeX = shadowSizeX;
        this.shadowSizeY = shadowSizeY;
    }

    /**
     * Retourne l'URL de l'icone
     * @return L'URL de l'icone
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * Permet de définir l'URL de l'icone
     * @param iconUrl La nouvelle URL de l'icone
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * Retourne l'URL de l'ombre de l'icone
     * @return L'URL de l'ombre
     */
    public String getShadowUrl() {
        return shadowUrl;
    }

    /**
     * Permet de définir l'URL de l'ombre de l'icone
     * @param shadowUrl La nouvelle URL de l'ombre
     */
    public void setShadowUrl(String shadowUrl) {
        this.shadowUrl = shadowUrl;
    }

    /**
     * Permet de définir les dimensions de l'icone
     * @param iconSizeX La largeur de l'icone
     * @param iconSizeY La hauteur de l'icone
     */
    public void setIconSize(int iconSizeX, int iconSizeY) {
        this.iconSizeX = iconSizeX;
        this.iconSizeY = iconSizeY;
    }

    /**
     * Permet de définir les dimensions de l'ombre de l'icone
     * @param shadowSizeX La largeur de l'ombre
     * @param shadowSizeY La hauteur de l'ombre
     */
    public void setShadowSize(int shadowSizeX, int shadowSizeY) {
        this.shadowSizeX = shadowSizeX;
        this.shadowSizeY = shadowSizeY;
    }

    /**
     * Définit les coordonnées de l'image de l'icone
     * @param iconAnchorX Coordonnée X de l'image de l'icone
     * @param iconAnchorY Coordonnée Y de l'image de l'icone
     */
    public void setIconAnchor(int iconAnchorX, int iconAnchorY) {
        this.iconAnchorX = iconAnchorX;
        this.iconAnchorY = iconAnchorY;
    }

    /**
     * Définit la position de l'ombre
     * @param shadowAnchorX Coordonnée X de l'ombre
     * @param shadowAnchorY Coordonnée Y de l'ombre
     */
    public void setShadownAnchor(int shadowAnchorX, int shadowAnchorY) {
        this.shadowAnchorX = shadowAnchorX;
        this.shadowAnchorY = shadowAnchorY;
    }

    /**
     * Définit la position du popup
     * @param popupAnchorX Coordonnée X du popup
     * @param popupAnchorY Coordonnée Y du popup
     */
    public void setPopupAnchor(int popupAnchorX, int popupAnchorY) {
        this.popupAnchorX = popupAnchorX;
        this.popupAnchorY = popupAnchorY;
    }

    /**
     * Retourne l'objet au format JSON
     * Utile pour l'intégrer à Leaflet avec JavaScript
     * @return L'objet au format JSON
     */
    public String getObject() {
        String object = "{iconUrl: '" + this.iconUrl + "',";
        object += "shadowUrl: '" + this.shadowUrl + "',";
        object += "iconSize: [" + this.iconSizeX + ", " + this.iconSizeY + "],";
        object += "shadowSize: [" + this.shadowSizeX + ", " + this.shadowSizeY + "],";
        object += "iconAnchor: [" + this.iconAnchorX + ", " + this.iconAnchorY + "],";
        object += "shadowAnchor: [" + this.shadowAnchorX + ", " + this.shadowAnchorY + "],";
        object += "popupAnchor: [" + this.popupAnchorX + ", " + this.popupAnchorY + "]}";

        return object;
    }
}
