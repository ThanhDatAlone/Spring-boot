app.controller("product-ctrl",function($scope,$http){
    $scope.items =[];
    $scope.form={};
    $scope.cates = [];

    $scope.initialize=function(){
        //load product
        //load catrogory
        $http.get("/rest/products").then(resp =>{
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        $http.get("/rest/categories").then(resp =>{
            $scope.cates = resp.data;
          
        });
    }
    $scope.initialize();

    //xóa form
    $scope.reset = function(){
        $scope.form ={
            createDate: new Date(),
            image:'cloud-upload.jpeg',
            available:true
        
    
        }

    }
    //hiển thị lên form
    $scope.edit = function(item){
  $scope.form = angular.copy(item);
  $(".nav-tabs a:eq(0)").tab('show');

    }

    // thên sp
    $scope.create = function(){
         var item = angular.copy($scope.form);
         $http.post(`/rest/products`,item).then(resp =>{
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("thêm sản phẩm thành công ");

         }).catch(error =>{
            alert("Lỗi thêm mới sản phẩm");
            console.log("rrrr",error);
         });

    }
    $scope.update=function(){
          var item = angular.copy($scope.form);
          $http.put(`/rest/products/${item.id}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật thành công");
          })
          .catch(error =>{
            alert("cập nhật lỗi")
            console.log("error",error);
          });
    }
    $scope.delete = function(item){
   
        $http.delete(`/rest/products/${item.id}`).then(resp =>{
          var index = $scope.items.findIndex(p => p.id == item.id);
          $scope.items.splice(index,1);
          $scope.reset();
          alert("Xóa thành công ");
        })
        .catch(error =>{
          alert("Xóa lỗi")
          console.log("error",error);
        });

    }
    $scope.imageChanged=function(files){
        var data = new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
        transformRequest: angular.identity,
        headers:{'Content-Type':undefined}
        }).then(resp =>{
            $scope.form.image = resp.data.name;
        }).cath(error =>{
            alert("up lỗi hinhgf ahr");
            console.log(error);
        })
    }
    $scope.pager={
        page: 0,
        size: 10,
        get items(){
           var start = this.page*this.size;
           return $scope.items.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1.0*$scope.items.length / this.size);
        },
        first(){
            this.page =0;
        },
        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
    
        },
        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page =this.count -1;
        }
    }

})