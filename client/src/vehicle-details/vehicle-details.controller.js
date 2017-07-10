(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleDetailsController', vehicleDetailsController);

  vehicleDetailsController.$inject = ['vehicleService'];

  function vehicleDetailsController(vehicleService) {
    var vDetailsVm = this;

    vehicleService.get()
    .then(function(vehicleDetails){
      vDetailsVm.vehicleDetails = vehicleDetails;
    }, function (error){
      console.log(error);
    });
  }

})();