(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleReadingsByIdController', vehicleReadingsByIdController);

  vehicleReadingsByIdController.$inject = ['vehicleService'];

  function vehicleReadingsByIdController(vehicleService) {
    var vReadingsVinVm = this;

    vehicleService.getReadingsVin()
    .then(function(vehicleReadings){
      vReadingsVinVm.vehicleReadings = vehicleReadings;
    }, function (error){
      console.log(error);
    });
  }

})();