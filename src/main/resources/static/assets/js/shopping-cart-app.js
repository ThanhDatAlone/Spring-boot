const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {
    // Quản lý giỏ hàng
    $scope.cart = {
        items: [],

        // Khởi tạo giỏ hàng từ localStorage


        // Thêm vào giỏ hàng
        add(id) {
            alert("ID sản phẩm: " + id); // Hiển thị ID sản phẩm
            const item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                });
            }
        },
        remove(id){
          var  index =this.items.findIndex(item => item.id == id);
          this.items.splice(index,1);
          this.saveToLocalStorage();
        },
        clear(){
            this.items =[]
            this.saveToLocalStorage();
        },

        // Lưu giỏ hàng vào localStorage
        saveToLocalStorage() {
            const json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        // Tổng số lượng sản phẩm trong giỏ hàng
        get count() {
            return this.items.map(item => item.qty).reduce((total, qty) => total += qty, 0);
        },

        // Tổng số tiền của các sản phẩm trong giỏ hàng
        get amount() {
            return this.items.map(item => item.qty * item.price).reduce((total, qty) => total += qty, 0);
        },

         loadFromLocalStorage(){
            var  json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json):[];

         }

    };
    $scope.cart.loadFromLocalStorage();
      
    $scope.order={

        createDate: new Date(),
        address: "",
        account: {username:$("#userName").text()},
       get orderDetail(){
        return $scope.cart.items.map(item => {

            return{
                product:{id: item.id},
                price: item.price,
                quantity: item.qty
            }
        });
       },
        purchase(){
            var order = angular.copy(this);
            $http.post("/rest/orders", order).then(resp => {
                alert("đặt hàng thành công");
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi");
                console.log(error);
            });
        }

    }

});
