var app = angular.module('MaisVida', ['ngRoute'])
	app.config(function($routeProvider, $locationProvider) {
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
	    $locationProvider.html5Mode()
	  });


// ********************* Controllers *********************//

app.controller('MedicosController', function($http, $scope, $window){
		 $http({method:'GET', url:'http://localhost:8080/api/privado/medicos/'})
		 .then(function(response){
			$scope.medicos = response.data;
	})

	$scope.detalhar = function(id){
		window.location.href = window.location.href + "/" + id;
	}
		 
	 $scope.salvar = function(medico){
		 $http.post('http://localhost:8080/api/privado/medicos/', medico).then(function(){
			 $window.location.reload();
		 })
		}

});

app.controller('MedicoDetalheController', function($http, $scope, $routeParams){
	$http({method:'GET', url:'http://localhost:8080/api/privado/medicos/' + $routeParams.id})
	 .then(function(response){
		$scope.medico = response.data;
})
});

app.controller('LoginController', function(LoginService, $scope){
	$scope.username = username;
	$scope.password = password;
});


// ******************** Services ************************//

app.service('MedicosService', function($http){});

app.service('MedicosDetalheService', function($http){});

app.service('LoginService', function($http){});
