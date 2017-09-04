app.controller('ng-app-controller-test-bbdd', ['$scope', '$http', '$timeout', 'utilFactory',
    function ($scope, $http, $timeout, utilFactory)
    {
        $scope.testOk = false;
        
        $scope.test = function(){
             utilFactory.setContTestBBDD(utilFactory.getContTestBBDD() + 1);
        $http.post('/test',
                {
                    table: 'hello'
                })
                .then(function (response)
      {
        scopeTest(response.data);
      });
    };


    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/
    function scopeTest(data)
    {
      $scope.testOk = true;
      $scope.spring = data;

      $timeout(function ()
      {
        $scope.testOk = false;
      }, 5000);
    }

  }]);