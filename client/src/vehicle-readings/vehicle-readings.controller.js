(function() {
  'use strict';
  angular.module('plunker')
    .controller('vehicleReadingsController', vehicleReadingsController);

  vehicleReadingsController.$inject = ['vehicleService'];

  function vehicleReadingsController(vehicleService) {
    var vReadingsVm = this;
    vReadingsVm.getSelectedTime = getSelectedTime;
    vReadingsVm.options = [5, 10, 15, 20, 25, 30, 60, 90, 120];
    vReadingsVm.selectSignal = ["fuelVolume", "EngineRpm", "engineHp", "Speed"];

    getReadings();

    function getReadings() {
      vehicleService.getReadings()
        .then(function(vehicleReadings) {
          vReadingsVm.displayAlerts = vehicleReadings
          vReadingsVm.vehicleReadings = vehicleReadings;
        }, function(error) {
          console.log(error);
        });
    }

    function getSelectedTime(givenalerts) {
      var selectedtime = vReadingsVm.selectedTime;
      var selectedSignal = vReadingsVm.selectedSignal;
      var displayArr = [];

      console.log("time selected" + selectedtime);
      displayArr = changeDisp(selectedtime, givenalerts, selectedSignal);

      if (displayArr.length === 0) {
        vReadingsVm.displayAlerts = displayArr;
        vReadingsVm.vehicleAlerts = givenalerts;
      } else {
        vReadingsVm.displayAlerts = displayArr;
      }
    }

    // changing display according to time specified    

    function changeDisp(selectedTime, alerts, selectedSignal) {
      var displayArr = [];

      var todayDate = new Date();
      angular.forEach(alerts, function(obj) {
        var receivedDate = new Date(obj.timestamp);
        if (receivedDate.getDate() == todayDate.getDate()) {
          var difference = todayDate.getTime() - receivedDate.getTime();
          var minutes = parseInt(Math.abs(difference) / (1000 * 60) % 60); //
          //var seconds = parseInt(Math.abs(difference) / (1000) % 60);
          if (minutes <= selectedTime) {
            if (selectedSignal === null || selectedSignal === undefined) {
              displayArr.push(obj);
            } else {
              if (selectedSignal == "fuelVolume") {
                displayArr.push(obj.fuelVolume);
              } else if (selectedSignal == "EngineRpm") {
                displayArr.push(obj.engineRpm);
              } else if (selectedSignal == "engineHp") {
                displayArr.push(obj.engineHp);
              } else if (selectedSignal == "Speed") {
                displayArr.push(obj.speed);
              }
              displayArr.push(obj.vin);
            }
          }

        }

      });
      return displayArr;
    }

  }

})();