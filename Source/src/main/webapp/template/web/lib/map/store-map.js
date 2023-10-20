var store_map_data = []
var store_DATA = []
var datas = [];
var idMap = "googleMap"
var iconMarker = '/template/web/images/map/pin.png'

function initMap() {
    var $doc = jQuery(document);
    var isChooseStorePage = $doc.find('#' + idMap).length;
    if (isChooseStorePage) {
        resetData()
    }
}

function resetData() {
    const callback = function (data) {
        store_DATA = Object.assign(store_DATA, data)
        storeLoadMap(data);
    }
    storeLoadData(callback);
}


function storeLoadData(callback) {
    jQuery.ajax({
        url:  url,
        method: 'GET',
        'dataType': 'json',
    }).then(function (res) {
        var regionsData = (res || {}) || [];
        if (typeof callback === 'function') {
            callback(regionsData);
        }
    });
}

function storeLoadMap(regions) {
    var vietnam = {
        lat: 16.8472634,
        lng: 101.2441985
    };
    store_map = new google.maps.Map(document.getElementById(idMap), {
        zoom: 5,
        center: vietnam,
        disableDefaultUI: true,
        zoomControl: true,
        scrollWheel: true,
        gestureHandling: 'greedy',
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: false
    });

    google.maps.event.addListenerOnce(store_map, 'idle', function () {
        setTimeout(function () {
            storeMapMarker(datas);
        }, 200);
    });

    store_map_info = new google.maps.InfoWindow();
    storeMapGenHtml(regions);
    convertArray(regions)
    $(".item").eq(0).click();
}

function convertArray(stores) {
    stores.forEach(function (store, index) {
        datas.push(store);
    });
}

function storeMapMarker(stores) {
    var path = '/template/web/images/map/'
    var clusterStyles = [
        {
            textColor: 'white',
            url: `${path}m1.png`,
            height: 53,
            width: 52
        },
        {
            textColor: 'white',
            url: `${path}m2.png`,
            height: 56,
            width: 55
        },
        {
            textColor: 'white',
            url: `${path}m3.png`,
            height: 66,
            width: 65
        }
    ];
    var mcOptions = {
        gridSize: 50,
        styles: clusterStyles,
        maxZoom: 15
    };
    if (stores == null) {
        stores = []
    }
    // Code Group Location
    var markers = stores.map(function (item, i) {

        var location = {
            lat: item.lat,
            lng: item.lng
        }
        if (location) {
            var marker = new google.maps.Marker({
                position: location,
                icon: iconMarker,
                map: store_map
            });

            marker.addListener('click', function () {

                var position = this.getPosition();
                var pos = {
                    lat: position.lat(),
                    lng: position.lng()
                };
                storeMapShowInfo(pos);
            });
            store_map_data.push({
                data: item,
                marker: marker
            });

        }
        return marker;
    });
    new MarkerClusterer(store_map, markers, mcOptions);

    setTimeout(function () {

        if (typeof window.mapData != 'undefined') {
            var currentStore = jQuery('.region-wrap .item > a[data-id=' + window.mapData + ']');
            if (currentStore.size()) {
                currentStore = currentStore.eq(0);
                currentStore.click();
                currentStore.parent().addClass('active');
                currentStore.addClass('active');
            }
        }
    }, 1000);
}

function storeMapGetInfo(data) {
    data = data || {};
    var image = data.image || '';
    var id = data.store_id || 0;
    var name = data.storeName || '';
    var phone = data.storePhone || '';
    var mail = data.storeMail || '';
    var address = data.storeAddress || '';
    var url = data.url;

    var string = '<div class="store-map-info"><div class="inner"><div style="width:100%" class="store-photo"><img src="' + image + '" alt=""></div> <div class="store-name"><a href="javascript:;" onclick="_goToStore(\'' + id + '\', \'' + name + '\', \'' + url + '\');">' + name + '</a></div> <div class="store-address">' + address + '</div> <div class="store-phone">';
    if (phone) {
        string += '<span class="icon icon-phone"></span>' + phone;
    }
    string += '</div> <div class="store-fax">' + "" + '</div><div class="store-mail">';

    if (mail) {
        string += '<span class="icon icon-mail"></span>' + mail;
    }
    string += '</div> </div> </div>';

    return string;
}

function storeMapGenHtml(liststore) {
    jQuery('.list-region .stores').html('');
    let html_stores_ul = '';
    let store_html = '';
    var stores = liststore || [];
    for (var i in stores) {
        var child = stores[i] || {};
        if (child) {
            store_html += '<li class="item"><a href="javascript:void(0)"  data-id="' + child.id + '" data-location="' + [child.lat, child.lng].join(', ') + '">' + child.storeName + '</a>                </li>';
        }
    }
    html_stores_ul += '<ul>' + store_html + '</ul>';
    $('.list-region .stores').html(html_stores_ul);
}

function storeMapGenHtmlByKeyword(data, keyword = '') {
    let stores = Object.assign([], data)
    if (keyword !== '') {
        stores = stores.filter(function (child) {
            const store_name = removeUnicode(child.storeName);
            keyword = removeUnicode(keyword);
            return store_name.search(keyword) >= 0
        })
    }
    storeMapGenHtml(stores);
}


function storeMapGetCurrent(pos) {
    var foundIndex = store_map_data.findIndex(function (item) {
        var position = item.marker.getPosition();
        var lat = position.lat().toFixed(6);
        var lng = position.lng().toFixed(6);
        return pos.lat.toFixed(6) === lat && pos.lng.toFixed(6) === lng;
    });
    return store_map_data[foundIndex];
}

function storeMapShowInfo(position) {

    var current = storeMapGetCurrent(position);

    if (current && current.marker) {
        var infoContent = storeMapGetInfo(current.data);
        store_map_info.setContent(infoContent);
        store_map_info.open(store_map, current.marker);
    }
}

$(document).on('click', 'a[data-location]', function (event) {
    var $this = $(this);
    $('a[data-location]').parent().removeClass('active');
    $this.parent().addClass('active');
    var location = $this.data('location');
    var is_head = $this.data('role') === 'head';
    if (location && location !== 'undefined') {
        var position = convertToPosition(location);

        var zoom = 15;
        if (is_head) {
            zoom = 10;
        }
        storeMapShowInfo(position);
        store_map.setZoom(zoom);
        store_map.panTo(position);
    }
});

$(document).on('click', '.store-search .controls', function (event) {
    $(this).select();
});

$(document).on('click', '#btn-search', function (event) {
    var keyword = $('#search-store').val();
    const clone = JSON.parse(JSON.stringify(store_DATA));
    storeMapGenHtmlByKeyword(clone, keyword);
});

function removeUnicode(name) {
    name = name.toLowerCase();
    name = name.replace(/á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ/gi, 'a');
    name = name.replace(/é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ/gi, 'e');
    name = name.replace(/i|í|ì|ỉ|ĩ|ị/gi, 'i');
    name = name.replace(/ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ/gi, 'o');
    name = name.replace(/ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự/gi, 'u');
    name = name.replace(/ý|ỳ|ỷ|ỹ|ỵ/gi, 'y');
    name = name.replace(/đ/gi, 'd');
    return name;
}

function convertToPosition(latlng) {
    var ret = null;
    if (latlng) {
        var arr = latlng.split(',') || [];
        if (arr.length) {
            ret = {
                lat: parseFloat(arr[0]),
                lng: parseFloat(arr[1])
            };
        }
    }
    return ret;
}
