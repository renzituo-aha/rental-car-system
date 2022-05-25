$(function() {

    $(".btn-book").on('click', function(){
          var rand = Math.random() * 10;
          var id = $(this).data("carid");
          layer.confirm( 'confirm to book ？' , {
          			icon: 3,
          			title: 'book order' ,
          			btn: [ 'confirm', 'cancel' ]
          		}, function(index){
          			layer.close(index);
          			$.ajax({
          				type : 'POST',
          				url : base_url + '/book/book' + "?ran=" + rand,
          				data :JSON.stringify({"userId":1,"carId":id,"useDays":1}),
          				dataType : "json",
          				contentType: 'application/json;charset=utf-8',
          				success : function(data){
          					if (data.code == 0) {
          						layer.open({
          							title: "success" ,
          							btn: [ "ok" ],
          							content: "success to book!You can find you car in MY ORDER",
          							icon: '1',
          							end: function(layero, index){
                                        location.reload();
          							}
          						});
          					} else {
          						layer.open({
          							title: "book failed",
          							btn: "ok",
          							content: (data.msg),
          							icon: '2'
          						});
          					}
          				},
          			});
          		});
    });
    $(".btn-pay").on('click', function(){
        var rand = Math.random() * 10;
                               var id = $(this).data("orderid");
                               var fee = $(this).data("fee");
                               layer.confirm( 'you are paying the order ,you need to pay $' + fee, {
                               			icon: 3,
                               			title: 'pay order',
                               			btn: [ 'pay', 'cancel' ]
                               		}, function(index){
                               			layer.close(index);
                               			$.ajax({
                               				type : 'POST',
                               				url : base_url + '/book/pay?ran='+rand,
                               				data :JSON.stringify({"userId":1,"orderId":id,"price":fee}),
                               				dataType : "json",
                               				contentType: 'application/json;charset=utf-8',
                               				success : function(data){
                               					if (data.code == 0) {
                               						layer.open({
                               							title: "success" ,
                               							btn: [ "ok" ],
                               							content: "success to pay!You can find you car in MY ORDER",
                               							icon: '1',
                               							end: function(layero, index){
                                                            location.reload();
                               							}
                               						});
                               					} else {
                               						layer.open({
                               							title: "pay failed",
                               							btn: "ok",
                               							content: (data.msg),
                               							icon: '2'
                               						});
                               					}
                               				},
                               			});
                               		});
                         });
    $(".btn-return").on('click', function(){
                               var id = $(this).data("orderid");
                               layer.confirm( 'confirm to return the car？' , {
                               			icon: 3,
                               			title: 'return car' ,
                               			btn: [ 'return', 'cancel' ]
                               		}, function(index){
                               			layer.close(index);
                               			$.ajax({
                               				type : 'POST',
                               				url : base_url + '/personal/returnCar',
                               				data :JSON.stringify({"userId":1,"orderId":id}),
                               				dataType : "json",
                               				contentType: 'application/json;charset=utf-8',
                               				success : function(data){
                               					if (data.code == 0) {
                               						layer.open({
                               							title: "success" ,
                               							btn: [ "ok" ],
                               							content: "success to return!welcome 2 use at next time",
                               							icon: '1',
                               							end: function(layero, index){
                                                            location.reload();
                               							}
                               						});
                               					} else {
                               						layer.open({
                               							title: "book failed",
                               							btn: "ok",
                               							content: (data.msg),
                               							icon: '2'
                               						});
                               					}
                               				},
                               			});
                               		});
                         });
});