app.controller('ng-app-controller-template1', ['$scope', '$http', function ($scope,
            $http)
    {
        console.log('1');
        $scope.mensaje = 'Texto cargado desde el controlador Pagina1Controller      ';

        $http.post('/test',
                {
                    propiedad: 'hello',
                    table: 'alumno'
                })
                .then(function (response)
                {
                    
                    console.log(response.data);
                    var data= response.data;
                    for (var i = 0, max = data.length; i < max; i++) {
                        console.log(data[i].table);
                        $scope.mensaje +=  data[i].table;
                    }

                });

    }]);