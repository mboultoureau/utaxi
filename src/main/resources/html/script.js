var map = L.map('map');

var tileLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors',
    maxZoom: 18
});

map.addLayer(tileLayer);

var marker = L.marker([48.833, 2.333]).addTo(map);


function setView(x, y, zoom) {
    map.setView([x, y], zoom);
}

function setSimpleMarker(x, y) {
    L.marker([x, y]).addTo(map);
}