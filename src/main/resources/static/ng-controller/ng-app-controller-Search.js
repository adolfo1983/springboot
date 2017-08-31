app.controller('ng-app-controller-Search', ["$scope", "$http", "$timeout",
    function ($scope, $http, $timeout)
    {
        $scope.search = function () {
            var value = this.value;
            $http.post('/searchItem',
                    {
                        nombre: value
                    })
                    
                    
                    
                    
                    
                    .then(function (response)
                    {
                        var data = response.data;

                        $scope.spring = data;
                        $scope.testOk = true;

                        $timeout(function ()
                        {
                            $scope.testOk = false;
                        }, 3000);

                    });
        };
    }]);


