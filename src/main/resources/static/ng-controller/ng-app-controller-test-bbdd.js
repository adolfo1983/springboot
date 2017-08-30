app.controller('ng-app-controller-test-bbdd', ["$scope", "$http", "$timeout",
    function ($scope, $http, $timeout)
    {
        $scope.testOk = false;
        
        $scope.test = function(){
        $http.post('/test',
                {
                    table: 'hello'
                })
                .then(function (response)
                {
                    var data = response.data;
                    
                    $scope.spring = data;
                    $scope.testOk = true;
                    
                    $timeout(function()
                    {
                     $scope.testOk = false;   
                    }, 3000);

                });
            };
    }]);