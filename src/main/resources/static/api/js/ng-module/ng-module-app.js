var app = angular.module('app', ['ngRoute']); //Hace referencia al "app" del index

app.config(['$routeProvider', '$locationProvider', function ($routeProvider,
            $locationProvider)
    {
//    $locationProvider.html5Mode(true);


        $routeProvider.otherwise(//Carga la página si no encuentra la URL que se le indica
                {
                    redirectTo: '/'
                })

                .when('/', //Carga la URL con el template y el controlador asociado
                        {
                            templateUrl: GBL_COFG.urlTemplate('inicio.html'),
                            //controller: 'ng-app-controller-Index'
                        })

                .when('/info',
                        {
                            templateUrl: GBL_COFG.urlTemplate('info.html'),
                            //controller: 'ng-app-controller-template2'
                        })

                .when('/test-bbdd',
                        {
                            templateUrl: GBL_COFG.urlTemplate('test-bbdd.html'),
                            controller: 'ng-app-controller-test-bbdd'
                        }
                )
                .when('/kirby',
                        {
                            templateUrl: GBL_COFG.urlTemplate('kirby.html'),
                            //controller: 'ng-app-controller-template2'
                        })
                        
                .when('/searchItem',
                        {
                            templateUrl: GBL_COFG.urlTemplate('search.html'),
                            controller: 'ng-app-controller-Search'
                        });
    }]);

app.directive('apploading', ['$http', function ($http)
    {
        var loading =
                {
                    restrict: 'A',
                    link: function (scope, elm, attrs)
                    {
                        scope.isLoading = function ()
                        {
                            return $http.pendingRequests.length > 0;
                        };

                        scope.$watch(scope.isLoading, function (v)
                        {
                            //console.log(JSON.stringify(elm) + ' ' + JSON.stringify(attrs))
                            if (v)
                            {
                                elm[0].classList.add('appLoading');
                            } else
                            {
                                elm[0].classList.remove('appLoading');
                            }
                        });
                    }
                };

        return loading;
    }]);


