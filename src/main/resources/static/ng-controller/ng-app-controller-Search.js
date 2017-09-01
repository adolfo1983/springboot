app.controller('ng-app-controller-Search',
        ['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
            {
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
                });


                $scope.searchArt = function (e)
                {
                    var value = e.target.value;
                    $timeout.cancel(timer.search.id);
                    timer.search.id = $timeout(function ()
                    {
                        $http.post('/searchItem',
                                {
                                    nombre: value
                                })
                                .then(function (response)
                                {
                                    var data = response.data;
                                    $scope.items = data;
                                    $scope.contador = data.length;
                                });
                    }, timer.search.ms);
                };
            }]
        );

