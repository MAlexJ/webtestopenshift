'use strict';

// ************  Home Page  ******************
myApp.controller('homeController', function ($scope, $http) {
});

// ************  Articles Page  ******************
myApp.controller('articlesController', function ($scope, $http) {
});

// ************  Info Page  ******************
myApp.controller('infoController', function ($scope, $http) {
});


// ************ ADMIN:  Admin Home Page  ******************
myAdmin.controller('adminHomeController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Create Page  ******************
myAdmin.controller('adminCreateController', function ($scope, $http) {

    $http.get('/admin/image').success(function (data) {
        $scope.imagesDel = data;
        $scope.imagesPrev = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // POST: image -> click to button
    $scope.uploadFile = function (imgForm, imgRadio, imgFile) {
        if (imgForm.$valid && imgRadio.name == true) {
            var fd = new FormData();
            fd.append('file', imgFile);
            fd.append('type', imgRadio.radio);
            $http.post("/admin/image", fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).success(function () {
                Materialize.toast('The image is added to the database', 3000, 'rounded')
                // repeat: get list
                $http.get('/admin/image').success(function (data) {
                    $scope.imagesDel = data;
                    $scope.imagesPrev = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            }).error(function () {
                Materialize.toast('The image is not added in the database!!!', 3000, '')
            });
            this.imgRadio.radio = 'NONE';
            this.imgRadio.name = false;
        } else {
            Materialize.toast('Please upload image!!!', 3000, '')
        }
    };
    $scope.imgRadio = {
        radio: 'NONE'
    };

    //DELETE
    $scope.deleteImg = function (selectOptDel) {
        if (selectOptDel > 0) {
            $http.delete('/admin/image/' + selectOptDel).success(function () {
                Materialize.toast('Delete image id:' + selectOptDel, 3000, 'rounded')
                // repeat: get list
                $http.get('/admin/image').success(function (data) {
                    $scope.imagesDel = data;
                    $scope.imagesPrev = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            });
        }
        else {
            Materialize.toast('Please select image!!!', 3000, '')
        }
    };
    
    //GET -> ID
    $scope.findImg = function (selectOptFind) {
        if (selectOptFind > 0) {
            $http.get('/admin/image/' + selectOptFind).success(function (data) {
                $scope.imageViewId = data;
            });
        }
        else {
            Materialize.toast('Please select image!!!', 3000, '')
        }
    };
});

// ************ ADMIN:  Admin Update Page  ******************
myAdmin.controller('adminUpdateController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Delete Page  ******************
myAdmin.controller('adminDeleteController', function ($scope, $http) {
});

// ************ ADMIN:  Admin View Page  ******************
myAdmin.controller('adminViewController', function ($scope, $http) {
});

