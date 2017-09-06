app.controller('ng-app-controller-Search',
        ['$scope', '$http', '$timeout', 'utilFactory', function ($scope, $http, $timeout, utilFactory)
            {
                var respuestas = 0;
                var timer =
                        {
                            search:
                                    {
                                        id: null,
                                        ms: 750
                                    }
                        };



                (function ()
                {

                    $http.post('/getItem', {})
                            .then(function (response)
                            {
                                var data = response.data;
                                $scope.items = data;

                            });
                })();


                $scope.searchArt = function (e)
                {
                    function isNumeric(str) {
                        var ruta = '';
                        if (str === '')
                        {
                            ruta = '/searchItem';
                        } else {
                            ruta = isNaN(str) ? '/searchItem' : '/searchPesoItem';
                        }
                        return ruta;
                    }



                    var value = e.target.value;
                    var ruta = isNumeric(value);

                    console.log(isNumeric(value));

                    $timeout.cancel(timer.search.id);
                    timer.search.id = $timeout(function ()
                    {

                        utilFactory.setContSearchItems(utilFactory.getContSearchItems() + 1);
                        $http.post(ruta,
                                {
                                    nombre: value
                                })
                                .then(function (response)
                                {
                                    respuestas++;
                                    $scope.resp = respuestas;
                                    var data = response.data;
                                    if (data.length > 0)
                                    {
                                        $scope.items = data;
                                    }

                                    $scope.contador = data.length;



                                });
                    }, timer.search.ms);
                };
            }]
        );

