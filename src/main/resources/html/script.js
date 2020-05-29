var map = L.map('map');

// Enable search control
L.Control.geocoder().addTo(map);

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

function moveMarker(index, x, y) {
    markers[index].setLatLng([x, y])
}

let routing;
function traceRoute(index1, index2) {
    routing = L.Routing.control({
        waypoints: [
            L.latLng(markers[index1].getLatLng()),
            L.latLng(markers[index2].getLatLng())
        ],
        router: L.Routing.mapbox('pk.eyJ1IjoibWJvdWx0b3VyZWF1IiwiYSI6ImNqdXI0aGp2ODA2ZmI0NHA1dXNibG9sdHYifQ.VhYH2p2C5wf5CswSAxgQ8A')
    }).addTo(map);
}

function removeRoute() {
    map.removeControl(routing);
}

// Tests
// setView(47.2186371, -1.5541362, 13);
// addMarker(48.833, 2.333)
// addMarker(49.833, 2.333, { iconUrl: 'img/taxi.png', iconSize: [30, 15] })
// traceRoute(0, 1)