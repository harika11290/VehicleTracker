(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleHAlertsController', vehicleHAlertsController);
  vehicleHAlertsController.$inject = ['vehicleService'];


  function vehicleHAlertsController(vehicleService) {
    var vHAlertsVm = this;

    vehicleService.getAlerts()
      .then(function(vehicleAlerts) {
        vHAlertsVm.vehicleAlerts = vehicleAlerts;
              var displayArr =[];
              var todayDate = new Date();
              angular.forEach(vehicleAlerts, function(obj) {
                var receivedDate = new Date(obj.alertCreationDate);
                if (receivedDate.getDate() == todayDate.getDate()) {
                  var difference = todayDate.getTime() - receivedDate.getTime();
                  var minutes = parseInt(Math.abs(difference) / (1000 * 60) % 60); //
                  //var seconds = parseInt(Math.abs(difference) / (1000) % 60);

                  if (minutes <= 20 && (obj.priority=="HIGH") ) {
                    displayArr.push(obj);
                  }
                }

              });
              vHAlertsVm.vehicleAlerts = displayArr;
      }, function(error) {
        console.log(error);
      });



  }

})();