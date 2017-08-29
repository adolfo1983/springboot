app.controller('ng-app-controller-template2', ["$scope", function ($scope)
  {
    console.log('2')
    $scope.mensaje = "Texto cargado desde el controlador Pagina2Controller";
    
    $scope.prueba1 = "Hola Ale!!!!";
    $scope.prueba2 = 5+5;
    $scope.prueba3 = "Se acabó Juego de Tronos... :(";
    
    $scope.prueba4 = "http://tmn-media-http.edgesuite.net/hbo/prod/minisite_landing/main_feature/636_1024x411.jpg";
  }]);