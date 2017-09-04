app.controller('ng-app-controller-Search',
        ['$scope', '$http', '$timeout', 'utilFactory', function ($scope, $http, $timeout, utilFactory)
            {
                var respuestas= 0;
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
                                    respuestas++;
                                    $scope.resp = respuestas;
                                    var data = response.data;
                                    if(data.length > 0)
                                    {
                                     $scope.items = data;   
                                    }
                                    
                                    $scope.contador = data.length;
                                    
                                    
                                    
                                });
                    }, timer.search.ms);
                };
            }]
        );

