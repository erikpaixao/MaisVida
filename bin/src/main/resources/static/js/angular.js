var app = angular.module('MaisVida', ['ngRoute'])
	app.config(function($routeProvider) {
	    $routeProvider
	      .when('/medicos', {
	        templateUrl: 'templates/medicos/medicos.html',
	        controller: 'MedicosController'
	      })
	      .when('/medicos/:id', {
	        templateUrl: 'templates/medicos/detalhe.html',
	        controller: 'MedicoDetalheController'
	      }).when('/login', {
		        templateUrl: 'login.html',
		        controller: 'LoginController'
		      }).otherwise({
	        redirectTo: '/medicos'
	      });
	  });


// ********************* Controllers *********************//

app.controller('MedicosController', function(MedicosService, $scope){
	$scope.medicos = MedicosService.listarTodos();
	console.log(MedicosService.listarTodos());
});

app.controller('MedicoDetalheController', function(MedicosDetalheService, $scope){
	$scope.medico = {};
});

app.controller('LoginController', function(LoginService, $scope){
	$scope.username = username;
	$scope.password = password;
});


// ******************** Services ************************//

app.service('MedicosService', function($http){

	this.listarTodos = function(){

		$http({method:'GET', url:'http://localhost:8080/api/privado/medicos/'}).then(function(response){
			return response.data;
	});
});

app.service('MedicosDetalheService', function($http){});

app.service('LoginService', function($http){});
