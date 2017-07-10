(function() {
  angular.module('plunker')
    .service('vehicleService', vehicleService);

  vehicleService.$inject = ['$q', '$http'];

  function vehicleService($q, $http) {
    var self = this;

    self.get = getVehicleDetails;
    self.getAlerts = getAlerts;
    self.getAlertsbyId=getAlertsbyId;
    self.getReadings=getReadings

    function getVehicleDetails() {
      return $http.get('http://localhost:8086/Tracker/api/vehicleDetails')
        .then(successFn, errorFn);
    }
    function getAlerts() {
      return $http.get('http://localhost:8086/Tracker/api/alertDetails')
        .then(successFn, errorFn);
    }
    function getAlertsbyId(vin){
      return $http.get('http://localhost:8086/Tracker/api/alertDetails'+vin)
        .then(successFn, errorFn);
    }
    function getReadings(){
      return $http.get('http://localhost:8086/Tracker/api/vehicleReadings/')
        .then(successFn, errorFn);
    }
    function getReadingsVin(vin){
      return $http.get('http://localhost:8086/Tracker/api/vehicleReadings/'+vin)
        .then(successFn, errorFn);
    }
     function successFn(response) {
      return response.data;
    }

    function errorFn(error) {
      return $q.reject(error);
    }
  }
})();
