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

                                    $scope.articles = data;
                                });

                    }, timer.search.ms);
                };

            }]);

