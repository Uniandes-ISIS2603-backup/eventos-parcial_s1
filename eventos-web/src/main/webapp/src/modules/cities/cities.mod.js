(function (ng) {
var mod = ng.module("eventosModule", []);
    mod.constant("eventosContext", "api/eventos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/eventos/';
            $urlRouterProvider.otherwise("/eventosList");

            $stateProvider.state('eventosList', {
                url: '/eventos',
                views: {
                    'mainView': {
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'eventos.list.html'
                    }
                }
            }).state('eventoCreate', {
                url: '/eventos/create',
                views: {
                    'mainView': {
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'eventos.create.html'
                    }
                }

            }).state('eventoEdit', {
                url: '/eventos/:eventoId',
                param: {
                    eventoId: null
                },
                views: {
                    'mainView': {
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'eventos.create.html'
                    }
                }
            });
        }]);

})(window.angular);

