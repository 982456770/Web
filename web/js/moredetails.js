$(function () {

    $(document).ready(function () {
        $("#1").addClass("on");
        $("#btn_1").show();
        $("#btn_2").hide();
    });						//页面加载的时候给第一个导航添加一样式, 显示id为btn_1的元素,隐藏id为btn_2的元素
    $("#tab div").click(function () {
        console.log(this.id)  				//通过点击事件获取当前元素的id
        $(this).siblings("div").removeClass("on"); 		//获取当前节点的同级的div元素并移除on样式
        $(this).addClass("on");   			//给当前节点添加on样式
        if (this.id == 1) {
            $("#btn_1").show();
            $("#btn_2").hide();
        } else {
            $("#btn_2").show();
            $("#btn_1").hide();
        }

    });
});