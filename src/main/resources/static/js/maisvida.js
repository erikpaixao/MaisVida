angular.module('MaisVida', ['ngRoute'])

 .controller('MainController', function($scope, $route, $routeParams, $location) {
     $scope.$route = $route;
     $scope.$location = $location;
     $scope.$routeParams = $routeParams;
 })

 .controller('HomeController', function($scope, $routeParams) {
     $scope.name = 'HomeController';
     $scope.params = $routeParams;
 })

 .controller('MedicoController', function($scope, $routeParams) {
     $scope.name = 'ChapterController';
     $scope.params = $routeParams;
 })
 
.config(function($routeProvider, $locationProvider)
{
   // remove o # da url
   $locationProvider.html5Mode(true);

   $routeProvider

   // para a rota '/', carregaremos o template home.html e o controller 'HomeCtrl'
   .when('/', {
      templateUrl : 'templates/home.html',
      controller     : 'HomeCtrl',
   })

   // para a rota '/sobre', carregaremos o template sobre.html e o controller 'SobreCtrl'
   .when('/medico', {
      templateUrl : 'templates/medico.html',
      controller  : 'MedicoCtrl',
   })

   // caso não seja nenhum desses, redirecione para a rota '/'
   .otherwise ({ redirectTo: '/' });
});