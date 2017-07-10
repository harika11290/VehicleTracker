(function() {
  'use strict';
  angular.module('plunker', ['ngRoute','angularUtils.directives.dirPagination']);


  angular.module('plunker')
    .config(moduleConfig);

  moduleConfig.$inject = ['$routeProvider'];

  function moduleConfig($routeProvider) {
    $routeProvider
      .when('/vehicleDetails', {
        templateUrl: 'vehicle-details/vehicle-details.tmpl.html',
        controller: 'vehicleDetailsController',
        controllerAs: 'vDetailsVm'
      }).when('/vehicleReadings', {
        templateUrl: 'vehicle-readings/vehicle-readings.tmpl.html',
        controller: 'vehicleReadingsController',
        controllerAs: 'vReadingsVm'
      }).when('/vehicleReadings/:vin', {
        templateUrl: 'vehicle-readings/vehicle-readingsby-id.tmpl.html',
        controller: 'vehicleReadingsByIdController',
        controllerAs: 'vReadingsVinVm'
      }).when('/vehicleAlerts', {
        templateUrl: 'vehicle-alerts/vehicle-alerts.tmpl.html',
        controller: 'vehicleAlertsController',
        controllerAs: 'vAlertsVm'
      }).when('/vehicleHAlerts', {
        templateUrl: 'vehicle-alerts/vehicle-high-alerts.tmpl.html',
        controller: 'vehicleHAlertsController',
        controllerAs: 'vHAlertsVm'
      }).when('/vehicleAlerts/:vin', {
        templateUrl: 'vehicle-alerts/vehicle-alertsby-id.tmpl.html',
        controller: 'vehicleAlertsByIdController',
        controllerAs: 'vAlertsVinVm'
      })
      .otherwise({
        redirectTo:'/vehicleDetails'
      });
  }
})();