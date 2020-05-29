var map = L.map('map');

var tileLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors',
    maxZoom: 18
});

map.addLayer(tileLayer);

function setView(x, y, zoom) {
    map.setView([x, y], zoom);
}

// Ajout des marqueurs
let markers = [];

function addMarker(x, y, icon) {
    let marker;
    if (icon !== undefined) {
        icon.iconUrl = "../" + icon.iconUrl;

        if (icon.shadowUrl !== undefined)
            icon.shadowUrl = "../" + icon.shadowUrl;

        marker = L.marker([x, y], { icon: L.icon(icon) });
    } else {
        marker = L.marker([x, y]);
    }
    marker.addTo(map);
    markers.push(marker);
}

function removeMarker(index) {
    let marker = markers[index];
    map.removeLayer(marker);
    markers.splice(index, 1);
}

// Tests
// setView(47.2186371, -1.5541362, 13);
// addMarker(48.833, 2.333)
// addMarker(49.833, 2.333, { iconUrl: 'img/taxi.png', iconSize: [30, 15] })