(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleAlertsByIdController', vehicleAlertsByIdController);

  vehicleAlertsByIdController.$inject = ['vehicleService', '$routeParams'];

  function vehicleAlertsByIdController(vehicleService, $routeParams) {
    var vAlertsVinVm = this;
$routeParams.vin ="1FMYU02143KB34432";
    vehicleService.getAlertsbyId($routeParams.vin)
    .then(function(vehicleAlerts){
      vAlertsVinVm.vehicleAlerts = vehicleAlerts;
    }, function (error){
      console.log(error);
    });
  }

})();