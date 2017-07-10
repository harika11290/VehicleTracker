(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleAlertsController', vehicleAlertsController);
  vehicleAlertsController.$inject = ['vehicleService'];


  function vehicleAlertsController(vehicleService) {
    var vAlertsVm = this;
    vAlertsVm.getSelectedTime = getSelectedTime;
    getAlerts();

    vAlertsVm.options = [5, 10, 15, 20, 30, 60, 90, 120];

    function getAlerts() {
      vehicleService.getAlerts()
        .then(function(vehicleAlerts) {
          vAlertsVm.vehicleAlerts = vehicleAlerts;
          vAlertsVm.displayAlerts = vehicleAlerts;
        }, function(error) {
          console.log(error);
        });

    }
// getting details on selected time range
    function getSelectedTime(givenalerts) {
      var selectedtime = vAlertsVm.selectedTime;
      var displayArr = [];
     
      console.log("time selected" + selectedtime);
      displayArr = changeDisp(selectedtime,givenalerts);

      if (displayArr.length === 0) {
        vAlertsVm.displayAlerts = displayArr;
        vAlertsVm.vehicleAlerts = givenalerts;
      } else {
        vAlertsVm.displayAlerts = displayArr;
      }
    }

// changing display according to time specified    
    
    function changeDisp(selectedTime,alerts ){
      var displayArr = [];
       var todayDate = new Date();
      angular.forEach(alerts, function(obj) {
          var receivedDate = new Date(obj.alertCreationDate);
          if (receivedDate.getDate() == todayDate.getDate()) {
            var difference = todayDate.getTime() - receivedDate.getTime();
            var minutes = parseInt(Math.abs(difference) /(1000 * 60) % 60);//
            //var seconds = parseInt(Math.abs(difference) / (1000) % 60);
            if (minutes <= selectedTime) {
              displayArr.push(obj);
              console.log(minutes);
            }

          }

        });
         console.log("returning results"+displayArr.length)
        return displayArr;
    }
    
  }

})();