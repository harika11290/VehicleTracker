(function() {
  "use strict";
  angular.module("plunker")
    .controller("MapController", MapController);

  MapController.$inject = ['vehicleService', '$routeParams'];

  function MapController(vehicleService, $routeParams) {
    var maponeVm = this;
    init();

    function init() {
      maponeVm.map = {
        center: {
          latitude: 41.8460142,
          longitude: -87.6482463
        },
        zoom: 11,
        markers: []
      };

      vehicleService
        .getReadingsByVin($routeParams.id)
        .then(function(readings) {
          var mapLoc = [];
          var todayDate = new Date();
          angular.forEach(readings, function(obj) {
            var receivedDate = new Date(obj.timestamp);
            if (receivedDate.getDate() == todayDate.getDate()) {
              var difference = todayDate.getTime() - receivedDate.getTime();
              var minutes = parseInt(Math.abs(difference) / (1000 * 60) % 60); //
              //var seconds = parseInt(Math.abs(difference) / (1000) % 60);
              if (minutes <= 30) {
                mapLoc.push({
                  coords: {
                    latitude: reading.latitude,
                    longitude: reading.longitude
                  },
                  id: key,
                  icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png'
                });
                console.log(minutes);
              }
            }
          });

          if (mapLoc.length > 0) {
            maponeVm.showMap = true;
            maponeVm.showError = false;
          } else {
            maponeVm.showMap = false;
            maponeVm.showError = true;
          }
          maponeVm.map.markers = mapLoc;
        }, function(error) {
          console.log(error);
        });
    }

  }
})();