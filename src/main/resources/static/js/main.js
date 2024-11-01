let map;
let markers = [];
let cityPolygon;
let openInfoWindow = null

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 16.159434, lng: 106.628482},
        zoom: 6.3,
        mapTypeId: 'hybrid',
        mapId: 'f415504edddf2cbe'
    });

}

function getCoordinates(cityName) {
    for (let feature of geoData.features) {
        if (feature.properties.GID_0 === cityName) {
            return feature.geometry.coordinates;
        }
    }
    return null;
}

function getColor(cityName) {
    for (let feature of geoData.features) {
        if (feature.properties.GID_0 === cityName) {
            return feature.properties.stroke;
        }
    }
}

function addMarkers(locations) {
    removePolygon();
    locations.forEach(location => {
        const coords = location.coords.split(',').map(Number);
        const position = {lat: coords[0], lng: coords[1]};
        const marker = new google.maps.marker.AdvancedMarkerElement({
            title: location.name,
            map: map,
            position: position,
            gmpDraggable: false,
        });
        let infoWindow = null;
        marker.addListener('click', () => {
            if (openInfoWindow) {
                openInfoWindow.close();
            }
            infoWindow = new google.maps.InfoWindow({
                ariaLabel: location.name,
                content: `<div style="display: flex; flex-direction: column;">
        <h3>${location.name}</h3>
        <p>Coords: ${marker.position.lat}, ${marker.position.lng}</p>
    </div>`
            });
            infoWindow.open(map, marker);
            openInfoWindow = infoWindow;
        });

        markers.push(marker);
    });
}

function removeMarker() {
    markers.forEach(marker => marker.map = null);
    markers = [];
}

function removePolygon() {
    if (cityPolygon) {
        cityPolygon.setMap(null);
        cityPolygon = null;
    }
}

function resetMap() {
    removeMarker();
    removePolygon();
    map.setCenter({lat: 16.159434, lng: 106.628482});
    map.setZoom(6.3);
}

function fetchSubRegions(regionId) {
    $.ajax({
        url: '/api/map/v1?regionId=' + regionId,
        method: 'GET',
        success: function (data) {
            let subRegionList = '';
            data.forEach(subRegion => {
                subRegionList += `<li data-coords=${subRegion.coords}>${subRegion.name}</li>`;
            });
            $(`#region-${regionId}`).html(subRegionList);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching sub-regions:', error);
        }
    });
}

function drawPolygon(polygonCoords, color) {
    removeMarker();
    if (cityPolygon) {
        cityPolygon.setMap(null);
    }

    cityPolygon = new google.maps.Polygon({
        paths: polygonCoords,
        strokeColor: color,
        strokeOpacity: 1,
        strokeWeight: 2,
        fillColor: color,
        fillOpacity: 0.2,
        map: map
    });

    const bounds = new google.maps.LatLngBounds();
    polygonCoords.forEach(coord => bounds.extend(coord));
    map.fitBounds(bounds);
}

$(document).ready(function () {
    $('ul#regions > li').each(function () {
        const regionId = $(this).data('region-id');
        fetchSubRegions(regionId);
    });

    $('.sidebar').on('click', '.regions', function (event) {
        event.stopPropagation();
        resetMap();
        let regionId = $(this).data('region-id');

        $.ajax({
            url: '/api/map/v1?regionId=' + regionId,
            method: 'GET',
            success: function (data) {
                addMarkers(data);
            },
            error: function (xhr, status, error) {
                console.error('Error fetching coordinates:', error);
            }
        });
    });

    $('.sidebar').on('click', '.sub-region li', function (event) {
        event.stopPropagation();
        const cityName = $(this).text().trim();
        const coordinates = getCoordinates(cityName);
        const color = getColor(cityName);
        if (coordinates) {
            if (Array.isArray(coordinates[0][0][0])) {
                coordinates.forEach(polygon => {
                    const polygonCoords = polygon[0].map(coord => ({lat: coord[1], lng: coord[0]}));
                    drawPolygon(polygonCoords, color);
                });
            } else {
                const polygonCoords = coordinates[0].map(coord => ({lat: coord[1], lng: coord[0]}));
                drawPolygon(polygonCoords, color);
            }
        } else {
            console.warn('Không tìm thấy polygon cho thành phố:', cityName);
        }
    });

    $('.reset-map').on('click', function () {
        resetMap();
    });
});