'use strict';

// Declare app level module which depends on views, and components
var prototipo = angular.module('prototipo', []);

prototipo.controller('homeController', [ '$scope', function($scope) {

    var template = {
	name : 'Empresas',
	content : 'views/empresaView.html'
    };

    $scope.template = template;

    $scope.updateTemplate = function(event) {
	if (event != undefined) {
	    var id = event.target.getAttribute("id");
	    if (id == 'empresas') {
		template = {
		    name : 'Empresas',
		    content : 'views/empresaView.html'
		};

	    } else if (id == 'problemas') {
		template = {
		    name : 'Problemas',
		    content : 'views/problemasView.html'
		};
	    } else if (id == 'solucoes') {
		template = {
		    name : 'Solucoes',
		    content : 'views/solucoesView.html'
		};
	    }
	    $scope.template = template;
	} else {

	    if ($scope.template.name == 'Empresas') {
		template = {
		    name : 'Problemas',
		    content : 'views/problemasView.html'
		};
	    } else if ($scope.template.name == 'Problemas') {
		template = {
		    name : 'Solucoes',
		    content : 'views/solucoesView.html'
		};
	    }
	    $scope.template = template;

	}
    };
} ]);